package main;

import java.util.ArrayList;

public class Buffer {

    private int nCliente;
    private int tamanoBuffer;
    private Object lleno, vacio; 
    private ArrayList<Mensaje> losMensajes;

    public Buffer (int nCli, int tamBuf){
        this.lleno = new Object();
        this.vacio = new Object();
        this.nCliente = nCli;
        this.tamanoBuffer = tamBuf;
        this.losMensajes = new ArrayList<Mensaje>();
    }

    public void enviar(Mensaje msj) {
        synchronized(lleno){
            while (losMensajes.size() == tamanoBuffer){
                try {
                    lleno.wait();
                    Thread.yield(); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized(this){
            losMensajes.add(msj);
            System.out.println("la cantidad de mensaje en el buffer :  "+ losMensajes.size());
        }

        synchronized(vacio){
            vacio.notify();
        }

    }

}
