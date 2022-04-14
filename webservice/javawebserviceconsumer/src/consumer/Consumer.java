package consumer;

import service.BanqueService;
import service.BanqueServiceService;
import service.Compte;

public class Consumer {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueServiceService().getBanqueServicePort();
        System.out.println(proxy.convertFromEu2Dh(53));
        printCompte(proxy.getCompte(3));
        proxy.getComptes().forEach(c -> printCompte(c));
    }
    private static void printCompte(Compte c){
        System.out.println("----------");
        System.out.println("id : "+c.getId());
        System.out.println("date : "+c.getDate());
    }
}
