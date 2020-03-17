package food.model;

import java.util.ArrayList;

public interface CategoryDataAccessObject<T,ID> {
    public boolean add(T t);
    public boolean update(T t);
    public boolean delete(T t);
    public ArrayList<T> list();
}
