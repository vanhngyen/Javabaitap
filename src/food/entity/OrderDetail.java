package food.entity;

public class OrderDetail {
    private int id;
    private int orderid;
    private int foodid;
    private int quantity;
    private float unitprice;

    public OrderDetail() {
    }

    public OrderDetail(int id, int orderid, int foodid, int quantity, float unitprice) {
        this.id = id;
        this.orderid = orderid;
        this.foodid = foodid;
        this.quantity = quantity;
        this.unitprice = unitprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }
}
