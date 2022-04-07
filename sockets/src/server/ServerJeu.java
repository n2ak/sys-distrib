package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerJeu extends Thread{
    int secret = -1;
    public static void main(String[] args) {
        new ServerJeu().start();
    }
    @Override
    public void run() {
        int num = 0;
        try {
            var serverSocket = new ServerSocket(1234);
            secret = new Random().nextInt(1000);
            System.out.println("Le server est demarré");
            System.out.println("Le numero secret: "+secret);

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

                System.out.println("Client " + numero + " connecté: " + socket.getRemoteSocketAddress());
                pw.println("Bienvenue client num: " + numero);
                boolean fin = false;
                String gagnant = "";
                while(true){
                    var line = br.readLine();
                    int nb = -1;
                    try{
                        nb = Integer.parseInt(line);
                    }catch(NumberFormatException e){
                        pw.println("Le message envoyé n'est pas un nembre");
                        continue;
                    }
                    System.out.println("une tentative du client " + numero +" : " + nb);
                    if(!fin){
                        if(nb < secret){
                            pw.println("Le nombre " + nb + " est inferieur au nombre secret");
                        }else if(nb > secret){
                            pw.println("Le nombre " + nb + " est superieur au nombre secret");
                        }else{
                            pw.println("Brave au client " + numero + ", le nombre est: "+secret);
                            System.out.println("Brave au client " + numero + ", le nombre est: "+secret);
                            gagnant = socket.getRemoteSocketAddress().toString();
                            fin = true;
                        }
                    }else{
                        pw.println("Le gagnan est :" + gagnant);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
