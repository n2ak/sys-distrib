package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServerChat extends Thread{
    int secret = -1;
    private List<Conversation> conversations = new ArrayList<Conversation>();
    public static void main(String[] args) {
        new ServerChat().start();
    }
    @Override
    public void run() {
        int num = 0;
        try {
            var serverSocket = new ServerSocket(1234);
            System.out.println("Le server est demarré");

            while(true){
                var c = new Conversation(serverSocket.accept(),++num);
                c.start();
                conversations.add(c);
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

                System.out.println("Client " + numero + " connecté: " + socket.getRemoteSocketAddress());
                pw.println("Bienvenue client num: " + numero);
                
                while(true){
                    var req = br.readLine();
                    String message = req;
                    int to = -1;
                    if(req.contains("=>")){
                        var m = req.split("=>");
                        if(m.length == 2){
                            to = Integer.parseInt(m[0]);
                            message = m[1];
                        }
                    }
                    broadcast(message,socket,to);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void broadcast(String message, Socket s, int to) throws IOException {
            for (var c : conversations) {
                if(c.socket != s){
                    if(to == -1 || c.numero == to){
                        var pw = new PrintWriter(c.socket.getOutputStream(),true);
                        pw.println(message);
                    }
                }
            }
        }
        
    }
}
