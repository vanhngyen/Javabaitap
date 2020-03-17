package food.model;

import java.util.ArrayList;

public interface AccountDataAccessObject<T , ID> {
    public boolean register(T t);
    public T login(String username, String password);
    public boolean update(T t);
    public ArrayList<T> list();
    public boolean deletedAt(T t);
}
