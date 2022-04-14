package service;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost/8484",new BanqueService());
        System.out.println("Deployé sur http://localhost/8484");
    }
}
