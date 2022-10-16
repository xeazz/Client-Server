package homework.two;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 5587;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            while (!clientSocket.isClosed()) {


                String age = in.readLine();
                System.out.println(age);
                String a = scanner.nextLine();
                out.println(a);
                if (Integer.parseInt(a) < 18) {
                    String warning = in.readLine();
                    System.out.println(warning);
                    break;
                }
                String name = in.readLine();
                System.out.println(name);
                out.println(scanner.nextLine());
                String welcome = in.readLine();
                System.out.println(welcome);

                String country = in.readLine();
                System.out.println(country);
                out.println(scanner.nextLine());

                String questionExit = in.readLine();
                System.out.println(questionExit);
                String answer = scanner.nextLine();
                out.println(answer);
                if (answer.equals("exit")) {
                    String answerSecond = in.readLine();
                    System.out.println(answerSecond);
                    break;
                } else {
                    System.out.println("Вы решили продолжить общение с сервером");
                }
            }
        }
    }
}