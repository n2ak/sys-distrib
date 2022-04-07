package server;
import java.io.IOException;

import java.net.ServerSocket;

public class Server {
    
    public static void main(String[] args) throws IOException {
        var socketServer = new ServerSocket(1234);
        System.out.println("Attente d'une connexion");
        var socket = socketServer.accept();
        var input = socket.getInputStream();
        var output = socket.getOutputStream();
        System.out.println("Un client est connecté : address" + socket.getRemoteSocketAddress());
        int nb = input.read();
        output.write(nb * 10);
        System.out.println("Recoit le nombre:" + nb);
        socketServer.close();
        input.close();
        output.close();
    }
}
