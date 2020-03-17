package food.model;

import food.entity.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailModel implements OrderDetailDataAccessObject<OrderDetail,Integer> {
    Connection connection = MySqlFood.getInstance().getConnection();
    PreparedStatement ps;

    @Override
    public ArrayList<OrderDetail> list() {
        ArrayList<OrderDetail> list = new ArrayList<>();
        String query = "SELECT * FROM orderdetail";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new OrderDetail(rs.getInt("id"),rs.getInt("orderid"),rs.getInt("foodid"),rs.getInt("quantity"),rs.getFloat("unitprice")));
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(OrderDetail orderDetail) {
        String query = "INSERT INTO orderdetail(orderid, foodid, quantity, unitprice)VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,orderDetail.getOrderid());
            ps.setInt(2,orderDetail.getFoodid());
            ps.setInt(3,orderDetail.getQuantity());
            ps.setFloat(4,orderDetail.getUnitprice());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
