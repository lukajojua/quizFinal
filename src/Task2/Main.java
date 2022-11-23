package Task2;


import java.io.File;

public class Main {
    public static void main(String[] args) {

       Server s = new Server();
        s.start();
        Thread thread=new Thread(new Client());
        thread.start();
    }
}
