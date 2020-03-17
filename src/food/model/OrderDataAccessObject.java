package food.model;

import food.entity.Order;

import java.util.ArrayList;

public interface OrderDataAccessObject<T , ID> {
    public boolean add(T t);
    public boolean update(T t);
    public boolean delete(T t);
    public ArrayList<T> list();
    public boolean changeStatus(T t);
}
