package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        var socket = new Socket("localhost",1234);
        System.out.println("Connecté à " + socket.getRemoteSocketAddress());
        var input = socket.getInputStream();
        var output = socket.getOutputStream();
        var scanner = new Scanner(System.in);
        System.out.println("Entrez le nombre à envoyer:");
        int nb1 = scanner.nextInt();
        output.write(nb1);
        int nb2 = input.read();
        System.out.println("Resultat est:" + nb2);

        socket.close();
        scanner.close();
        input.close();
        output.close();
    }
}