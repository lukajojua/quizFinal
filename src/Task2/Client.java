package Task2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    String Command;
    Socket s;
    ObjectOutputStream out;
    Scanner scanner = new Scanner(System.in);


    @Override
    public void run() {

        try {

            s = new Socket(InetAddress.getByName("localhost"), 8081);
            System.out.println("Input Command");
            Command=scanner.nextLine();
            out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(Command);






        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
