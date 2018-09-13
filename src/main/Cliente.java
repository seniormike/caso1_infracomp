package main;

import java.util.LinkedList;
import java.util.Queue;

public class Cliente extends Thread
{
	/**
	 * Identificador de cada uno de los clientes.
	 */
	private int id;

	/**
	 * Atributo que representa el buffer al que tiene acceso
	 * cada cliente.
	 */

	private Buffer bf;

	/**
	 * Cola donde se almacenan los mensajes que va a enviar cada cliente.
	 */
	private Queue<Mensaje> colita;


	/**
	 * Cantidad de mensajes que posee un cliente.
	 */
	private int numMsj;

	public Cliente(Buffer bf, int id, int numMsj)
	{
		colita = new LinkedList<Mensaje>();
		this.id = id;
		this.bf = bf;
		this.numMsj = numMsj;

		int t = 0;
		while(t<numMsj)
		{
			colita.add(new Mensaje());
			t++;
		}
	}
	
	@Override
	public void run()
	{
		int entra = -1;
		
		while(!colita.isEmpty())
		{
			Mensaje msj  = colita.remove();
			synchronized (msj) {
				while (entra == -1) {
					entra = bf.enviar(msj);
					yield();
				}
				try
				{
					msj.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				entra = -1;
			}
			if(msj.getMsj() == 0)
				throw new NullPointerException("No se pudo recibir el mensaje" + id);
		}
		bf.terminaCliente();
		
	}
	public int darId()
	{
		return this.id;
	}

	public Buffer getBf()
	{
		return bf;
	}
	public int getNumMsj()
	{
		return numMsj;
	}

}
