package food.model;

import food.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderModel implements OrderDataAccessObject<Order,Integer>{
    Connection connection = MySqlFood.getInstance().getConnection();
    PreparedStatement ps;
    @Override
    public boolean add(Order order) {
        String query = "INSERT INTO order(name, address, phone, email, createdAt, updatedAt, deletedAt, status, totalprice)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,order.getName());
            ps.setString(2,order.getAddress());
            ps.setString(3,order.getPhone());
            ps.setString(4,order.getEmail());
            ps.setLong(5,order.getCreatedAt());
            ps.setLong(6,order.getUpdatedAt());
            ps.setLong(7,order.getDeletedAt());
            ps.setInt(8,order.getStatus());
            ps.setFloat(9,order.getTotalprice());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Order order) {
        String query = "UPDATE order SET name = ? , address = ?, phone = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, order.getName());
            ps.setString(2,order.getAddress());
            ps.setString(3,order.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Order order) {
        String query = "UPDATE order SET status = ? , updatedAt = ? WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,order.getStatus());
            ps.setLong(2,order.getUpdatedAt());
            ps.setInt(3,order.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Order> list() {
        ArrayList<Order> list = new ArrayList<>();
        String query = "SELECT * FROM order";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Order(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getString("phone"),rs.getString("email"),rs.getLong("createdAt"),rs.getLong("updatedAt"),rs.getLong("deletedAt"),rs.getInt("status"),rs.getFloat("totalprice")));
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean changeStatus(Order order) {
        String query = "UPDATE order SET status =? , updatedAt = ? WHERE id =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,order.getStatus());
            ps.setLong(2,order.getUpdatedAt());
            ps.setInt(3,order.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
