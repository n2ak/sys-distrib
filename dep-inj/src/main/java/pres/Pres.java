package pres;

import dao.DaoImpl;
import dao.IDao;
import metier.MetierImpl;

public class Pres {
    public static void main(String[] args) {
        IDao dao = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        double res = metier.calculer();
        System.out.println("Resultat " + res);
    }
}
