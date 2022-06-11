package service;

import entities.Compte;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;

@WebService
public class BanqueService {
    @WebMethod(operationName = "convertFromEu2Dh")
    public double conversion(@WebParam(name = "montant") double m){
        return m*10;
    }
    @WebMethod
    public Compte getCompte(long id){
        return new Compte(id,new Date());
    }
    @WebMethod
    public Compte[] getComptes(){
        return new Compte[]{
                new Compte(1, new Date()),
                new Compte(2, new Date()),
                new Compte(3, new Date()),
                new Compte(4, new Date())
        };
    }
}
