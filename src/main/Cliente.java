package main;

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
	 * Cantidad de mensajes que posee un cliente.
	 */
	private int numMsj;
	
	public Cliente(Buffer bf, int id, int numMsj)
	{
		this.id = id;
		this.bf = bf;
		this.numMsj = numMsj;
	}
	
	public void run()
	{
		
	}

	public int darId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Buffer getBf()
	{
		return bf;
	}

	public void setBf(Buffer bf)
	{
		this.bf = bf;
	}

	public int getNumMsj()
	{
		return numMsj;
	}

	public void setNumMsj(int numMsj)
	{
		this.numMsj = numMsj;
	}
	
}
