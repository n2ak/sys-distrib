package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT extends Thread{
    public static void main(String[] args) {
        new ServerMT().start();
    }
    @Override
    public void run() {
        int num = 0;
        try {
            var serverSocket = new ServerSocket(1234);
            System.out.println("Le server est demarré");
            while(true){
                new Conversation(serverSocket.accept(),++num).start();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    class Conversation extends Thread{
        Socket socket;
        int numero;
        public Conversation(Socket socket,int numero){
            this.socket = socket;
            this.numero = numero;
        }
        @Override
        public void run() {
            try {
                var br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                var os = socket.getOutputStream();
                var pw = new PrintWriter(os,true);

                System.out.println("Client " + numero + " connecté : " + socket.getRemoteSocketAddress());
                pw.println("Bienvenue client num: " + numero);
                while(true){
                    var line = br.readLine();
                    System.out.println("Message par client " + numero +" : " + line);
                    pw.println("Line length : " + line.length());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
