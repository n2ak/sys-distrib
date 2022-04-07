package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

public class DaoImpl2 implements IDao{
    @Override
    public double getData() {
        System.out.println("Data via DaoImpl2");
        return 90;
    }
}
