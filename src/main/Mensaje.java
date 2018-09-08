package main;

public class Mensaje
{
	/**
	 * Identificador de cada mensaje.
	 */
	private int id;

	/**
	 * Mensaje en texto.	
	 */
	private String msj;

	
	/**
	 * Estado del mensaje: 0 (enviado) v 1 (no enviado). 
	 */
	private int estado;
	
	public Mensaje(int id, String msj)
	{
		this.id = id;
		this.msj = msj;
		this.estado = 0;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getMsj()
	{
		return msj;
	}

	public void setMsj(String msj)
	{
		this.msj = msj;
	}

	public int getEstado()
	{
		return estado;
	}

	public void setEstado(int estado)
	{
		this.estado = estado;
	}
}