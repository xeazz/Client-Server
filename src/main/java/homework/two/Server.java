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
                try (
                        Socket clientSoсket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(clientSoсket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSoсket.getInputStream()))) {

                    System.out.printf("Новое подключение установлено " +
                            clientSoсket.getInetAddress().getHostAddress()
                            + ":" + serverSocket.getLocalPort());

                    while (!clientSoсket.isClosed()) {
                        out.println(String.format("Введите Ваш возраст."));
                        System.out.println("Ждем ответа от пользователя");
                        final String age = in.readLine();
                        if (Integer.parseInt(age) < 18) {
                            out.println("Вы не проходите по возрасту. Пока-пока");
                            in.close();
                            out.close();
                            clientSoсket.close();
                            break;
                        }

                        out.println("Введите Ваше ФИО");
                        String[] name = in.readLine().split(" ");
                        out.println("Здравствуйте, " + (Arrays.toString(name)
                                .replaceAll("^\\[|\\,|\\]$", "")) + "!");
                        out.println("Введите страну проживания");
                        String country = in.readLine();
                        System.out.println("страна проживания " + country);
                        out.println("Для выхода введите \"exit\". Продолжить - любая клавиша");
                        if (in.readLine().equals("exit")) {
                            out.println("Вы завершили общение с сервером");
                            in.close();
                            out.close();
                            clientSoсket.close();
                            break;
                        }
                    }
                }
            }
        }
    }
}
