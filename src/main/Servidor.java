package main;


public class Servidor extends Thread
{
	private Buffer bf;

	public Servidor(Buffer bf)
	{
		this.bf = bf;
	}

	public void run()
	{
		synchronized (this)
		{
			while(bf.darNumClientes()>0)
			{
				Mensaje m = bf.retirar();
				if(m != null)
				{
					m.respuesta();
				}
				else
				{
					yield();
				}
			}
		}
	}
}
