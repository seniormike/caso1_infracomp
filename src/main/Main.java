package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFileChooser;

public class Main
{

	/*
		numero.clientes=10
		numero.servidores=2
		numero.consultas.cliente=5
		buffer.size=4
	 */
	public static int numClientes;
	public static int numServidores;
	public static int numConsultas;
	public static int bufferSize;

	/**
	 * Variable que representa el archivo del cual se va a leer la informacion.
	 */
	public static File prop;




	public static void cargar()
	{
		JFileChooser fc = new JFileChooser("./data");
		int resultado = fc.showOpenDialog(fc );
		 
		
		if( resultado == JFileChooser.APPROVE_OPTION)
		{
			prop = fc.getSelectedFile( );
		}
		Properties p = new Properties();

		try {
			p.load(new FileReader(fc.getSelectedFile().getPath()));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		numClientes = Integer.parseInt(p.getProperty("numero.clientes"));
		numServidores = Integer.parseInt(p.getProperty("numero.servidores"));	
		numConsultas = Integer.parseInt(p.getProperty("numero.consultas.cliente"));
		bufferSize = Integer.parseInt(p.getProperty("buffer.size"));
		
		Buffer bf = new Buffer(numClientes, bufferSize);
		
		for(int i=0 ; i< numConsultas ; i++)
		{
//			Cliente cliente = new Cliente(bf,i,Integer.parseInt());
//			cliente.start() ;
		}

//		for (int i = 0; i < numeroServidores; i++) {
//
//			Servidor servidor = new Servidor(buffer,i) ;
//			servidor.start();
//
//		}
		
		
	}

	public static void main(String[] args)
	{
		cargar();
	}

}
