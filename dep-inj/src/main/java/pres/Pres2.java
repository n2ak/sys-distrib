package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.util.Scanner;

public class Pres2 {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("src/config.txt"));
        ;
        IDao dao = (IDao) Class.forName(scanner.nextLine()).newInstance();
        Class m = Class.forName(scanner.nextLine());
        IMetier metier = (IMetier) m.newInstance();
        m.getMethod("setDao",IDao.class).invoke(metier,dao);
        double res = metier.calculer();
        System.out.println("Resultat " + res);
    }
}
