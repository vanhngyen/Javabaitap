package food.model;

import food.entity.Account;
import food.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryModel implements CategoryDataAccessObject<Category , Integer> {
    Connection connection = MySqlFood.getInstance().getConnection();
    PreparedStatement ps = null;


    @Override
    public boolean add(Category category) {
        String query = "INSERT INTO category(name, image, createdAt, updatedAt, deletedAt, status)VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,category.getName());
            ps.setString(2,category.getImage());
            ps.setLong(3,category.getCreatedAt());
            ps.setLong(4,category.getUpdatedAt());
            ps.setLong(5,category.getDeletedAt());
            ps.setInt(6,category.getStatus());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        String query = "UPDATE category SET name = ? , image = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,category.getName());
            ps.setString(2,category.getImage());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Category category) {
        String query = "UPDATE category SET status = ? , deletedAt = ? WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,category.getStatus());
            ps.setLong(2,category.getDeletedAt());
            ps.setInt(3,category.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Category> list() {
        ArrayList<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM category";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                categories.add(new Category(rs.getInt("id"),rs.getString("name"),rs.getString("image"),rs.getLong("createdAt"),rs.getLong("updatedAt"),rs.getLong("deletedAt"),rs.getInt("status")));
                return categories;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
