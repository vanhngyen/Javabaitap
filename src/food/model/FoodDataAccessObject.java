package food.model;

import food.entity.Category;

import java.util.ArrayList;

public interface FoodDataAccessObject<T, ID> {
    public T getOne(T t);
    public T findById(ID id);
    public ArrayList<T> findAll();
    public ArrayList<T> findByCategoryId(Category category);
    public boolean add(T t);
    public boolean update(T t);
    public boolean delete(T t);
}
