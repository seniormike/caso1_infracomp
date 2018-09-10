package main;

public class Servidor extends Thread
{
    private Buffer buffer;

    public Servidor(Buffer buf){
        this.buffer = buf;
    }


}
