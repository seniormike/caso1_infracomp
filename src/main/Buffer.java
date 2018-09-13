package main;

import java.util.ArrayList;

public class Buffer {

	private int nClientes;
	private int tamanoBuffer;
	private Object lleno, vacio; 
	private ArrayList<Mensaje> losMensajes;

	public Buffer (int nCli, int tamBuf)
	{
		this.lleno = new Object();
		this.vacio = new Object();
		this.nClientes = nCli;
		this.tamanoBuffer = tamBuf;
		this.losMensajes = new ArrayList<Mensaje>();
	}

	public int enviar(Mensaje msj)
	{
		synchronized(lleno)
		{
			if (losMensajes.size() == tamanoBuffer)
			{
				return -1;
			}
			losMensajes.add(msj);
			synchronized (this) {
				this.notifyAll();
			}
			return 1;
		}

	}

	public Mensaje retirar ()
	{
		synchronized(vacio)
		{
			while (losMensajes.size( ) == 0 )
			{ 
				try { 
					vacio.wait(); 
				}catch( InterruptedException e )
				{
					e.printStackTrace();
				}
			}
		}
		Mensaje msj;
		synchronized( losMensajes )
		{ 
			msj = (Mensaje) losMensajes.remove(0); 
		}
		synchronized( lleno )
		{
			lleno.notify( ); 
		}
		return msj;
	}
	public synchronized int darCantidadMsjsEnBuffer()
	{
		synchronized (losMensajes) {
			return losMensajes.size();
		}
	}
	public synchronized void terminaCliente()
	{
		nClientes--;
	}
	public void termina()
	{
		synchronized (lleno)
		{
			lleno.notifyAll();
		}
		synchronized (vacio)
		{
			vacio.notifyAll();
		}
	}
	
	public synchronized int darNumClientes()
	{
		return nClientes;
	}
}
