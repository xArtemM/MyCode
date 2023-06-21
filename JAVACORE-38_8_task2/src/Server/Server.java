package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("Client connection");

                    out.println("Write your name");

                    final String name = in.readLine();
                    System.out.println(name);

                    out.println("Are you child? (yes/no)");

                    final String answer = in.readLine();
                    if (answer.equals("yes")) {
                        System.out.printf("Welcome to the kids area, %s! Let's play!", name);
                    } else if (answer.equals("no")) {
                        System.out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name);
                    }

                }
            }
        }
    }

}

