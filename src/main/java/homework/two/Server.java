package homework.two;

import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Сервер запущен");
        int port = 5587;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try {
                    Socket clientSoсket = serverSocket.accept();
                    DataOutputStream out = new DataOutputStream(clientSoсket.getOutputStream());
                    DataInputStream in = new DataInputStream(clientSoсket.getInputStream());
                    System.out.printf("Новое подключение установлено");

                    while (!clientSoсket.isClosed()) {
                        out.writeUTF("Введите Ваш возраст.");
                        String age = in.readUTF();
                        if (Integer.parseInt(age) < 18) {
                            out.writeUTF("Вы не проходите по возрасту. Пока-пока");
                            out.flush();
                            clientSoсket.close();
                            break;
                        }

                        out.writeUTF("Введите Ваше ФИО");
                        String[] name = in.readUTF().split(" ");
                        out.writeUTF("Здравствуйте! " + Arrays.toString(name)
                                .replaceAll("^\\[|\\,|\\]$", ""));
                        out.writeUTF("Введите страну проживания");
                        String country = in.readUTF();
                        out.writeUTF("host: " + clientSoсket.getInetAddress().getHostAddress()
                                + " " + "port: " + serverSocket.getLocalPort());
                        out.writeUTF("Для выхода введите \"exit\". Продолжить - любая клавиша");
                        if (in.readUTF().equals("exit")) {
                            out.writeUTF("Программа работы сервера завершена");
                            out.close();
                            in.close();
                            clientSoсket.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
