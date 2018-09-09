package main;

import java.util.ArrayList;

public class Buffer {

    private int nCliente;
    private int tamanoBuffer;
    private ArrayList losMensajes;

    public Buffer (int nCli, int tamBuf){
        nCliente = nCli;
        tamanoBuffer = tamBuf;
        losMensajes = new ArrayList<Mensaje>();
    }

}
