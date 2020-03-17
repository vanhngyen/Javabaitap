package food.model;

public interface MemberDataAccessObject<T,ID>  {
    public boolean add(T t);
    public boolean update(T t);
}
