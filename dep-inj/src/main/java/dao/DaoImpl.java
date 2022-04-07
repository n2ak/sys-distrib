package dao;

import org.springframework.stereotype.Component;

@Component
public class DaoImpl implements IDao{
    @Override
    public double getData() {
        System.out.println("Data via DaoImpl");
        return 0;
    }
}
