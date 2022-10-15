//package homework.one;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server {
//
//    public static void main(String[] args) throws IOException {
//        System.out.println("Сервер запущен");
//        int port = 8080;
//
//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//            while (true) {
//                try (Socket clientSoсket = serverSocket.accept();
//                     PrintWriter out = new PrintWriter(clientSoсket.getOutputStream(), true);
//                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSoсket.getInputStream()))) {
//                    System.out.printf("Новое подключение установлено");
//                    final String name = in.readLine();
//                    out.println(String.format("Hi %s, your port is %d", name,clientSoсket.getPort()));
//                }
//            }
//        }
//    }
//}
//
//
//
