package main;

import java.util.ArrayList;

public class Buffer {

    private int nCliente;
    private int tamanoBuffer;
    private ArrayList<Mensaje> losMensajes;

    public Buffer (int nCli, int tamBuf){
        this.nCliente = nCli;
        this.tamanoBuffer = tamBuf;
        this.losMensajes = new ArrayList<Mensaje>();
    }

    public void enviar(int msj){
        
    }

}
