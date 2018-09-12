package main;

public class Mensaje
{

	/**
	 * Mensaje en texto.	
	 */
	private int msj;


	public Mensaje()
	{
		this.msj = 0;
	}


	public int getMsj()
	{
		return msj;
	}

	public void setMsj(int msj)
	{
		this.msj = msj;
	}

	public synchronized void respuesta()
	{
		msj++;
		notifyAllMsj();
	}
	public synchronized void notifyAllMsj()
	{
		this.notifyAll();
	}
}