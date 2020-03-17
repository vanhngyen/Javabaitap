package food.model;

import java.util.ArrayList;

public interface OrderDetailDataAccessObject<T , ID> {
    public ArrayList<T> list();
    public boolean add(T t);


}
