package homework.two;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String host = "mysite.ru";
        int port = 5587;
        try {
            Socket clientSocket = new Socket(host, port);
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            while (!clientSocket.isOutputShutdown()) {
                String result = in.readUTF();
                System.out.println(result);
                out.writeUTF(scanner.nextLine());
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}