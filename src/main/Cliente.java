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
