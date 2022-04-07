package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier{
    @Autowired
    private IDao dao;


    @Override
    public double calculer() {
        return dao.getData();
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
