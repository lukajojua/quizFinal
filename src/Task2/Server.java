package Task2;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;


public class Server extends Thread {
    Socket s;
    ObjectInputStream in;
    ObjectOutputStream outputStream;
    Random random = new Random();

    public void run() {
        try {
            ServerSocket ss = new ServerSocket(8081);
            s = ss.accept();
            in = new ObjectInputStream(s.getInputStream());
            String Command = (String) in.readObject();
            if (Command.equals("write1")){
                write1();
            }
            if (Command.equals("write2")){
                write2();
            }

            if (Command.equals("print")){
                print();
            }

            if (Command.equals("delete")){
                delete();
            }

            if (Command.equals("add")){
                write1();
                write2();
            }


        } catch (Exception e) {

        }
    }

        public void write1 () throws IOException {
            File file = new File("data.txt");

            try (FileWriter fileWriter = new FileWriter(file);) {

                int n = 10;
                int b = 15;
                int c = 30;
                for (int i = 0; i < 10; i++) {
                    fileWriter.write(random.nextInt(b, c) + " ");
                    fileWriter.flush();


                }
            } catch (IOException e) {

            }
        }

        public void write2 () {
            File file = new File("data.txt");
            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                File file1 = new File("text.txt");
                FileWriter fileWriter = new FileWriter(file1);
                String line = fileReader.readLine();
                String[] content = line.split(" ");
                for (int i = 0; i < content.length; i++) {
                    int leteeramount = Integer.parseInt(content[i]);
                    for (int j = 0; j < leteeramount; j++) {
                        String res = "";
                        res += (char) (random.nextInt(26) + 'a');
                        fileWriter.write(res);

                    }
                    fileWriter.write(" ");
                    fileWriter.flush();
                }


            } catch (Exception e) {

            }


        }

        public void print () throws IOException {
            File file = new File("data.txt");
            File file1 = new File("text.txt");
            System.out.println(Files.readString(file.toPath()));
            System.out.println(Files.readString(file1.toPath()));


        }

        public void delete()throws IOException {
            File file = new File("data.txt");
            File file2 = new File("text.txt");
            file.delete();
            file2.delete();


        }

    }


