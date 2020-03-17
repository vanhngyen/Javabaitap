package food.model;

import food.entity.Category;
import food.entity.Foods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class FoodModel implements FoodDataAccessObject<Foods, Integer> {
    Connection connection = MySqlFood.getInstance().getConnection();
    PreparedStatement ps = null;

    @Override
    public Foods getOne(Foods foods) {

        return null;
    }

    @Override
    public Foods findById(Integer id) {
        String query = "SELECT * FROM foods BY category WHERE id =?  ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return new Foods(rs.getInt("id"),rs.getString("code"),rs.getString("name"),rs.getString("description"),rs.getString("image"),rs.getLong("createdAt"),rs.getLong("updatedAt"),rs.getLong("deletedAt"),rs.getInt("status"),rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Foods> findAll() {
        ArrayList<Foods> list = new ArrayList<>();
        String query = "SELECT * FROM foods WHERE status = 0 OR status = 1";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Foods(rs.getInt("id"), rs.getString("code"), rs.getString("name"), rs.getString("description"), rs.getString("image"), rs.getLong("createdAt"), rs.getLong("updatedAt"), rs.getLong("deletedAt"), rs.getInt("status"), rs.getDouble("price")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Foods> findByCategoryId(Category category) {
        ArrayList<Foods> list = new ArrayList<>();
        String query = "SELECT * FROM foods WHERE status = 0 OR status = 1 AND catId = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, category.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Foods(rs.getInt("id"), rs.getString("code"), rs.getString("name"), rs.getString("description"), rs.getString("image"), rs.getLong("createdAt"), rs.getLong("updatedAt"), rs.getLong("deletedAt"), rs.getInt("status"), rs.getDouble("price")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Foods foods) {
        String query = "INSERT INTO foods(code, name, description, image, createdAt, updatedAt, deletedAt, status, price)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, foods.getCode());
            ps.setString(2, foods.getName());
            ps.setString(3, foods.getDescription());
            ps.setString(4, foods.getImage());
            ps.setLong(5, foods.getCreatedAt());
            ps.setLong(6, foods.getUpdatedAt());
            ps.setLong(7, foods.getDeletedAt());
            ps.setInt(8, foods.getStatus());
            ps.setDouble(9, foods.getPrice());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Foods foods) {
        String query = "UPDATE foods SET code = ?, name = ?, description = ?, image = ?, updatedAt = ?, price = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,foods.getCode());
            ps.setString(2,foods.getName());
            ps.setString(3,foods.getDescription());
            ps.setString(4,foods.getImage());
            ps.setLong(5,foods.getUpdatedAt());
            ps.setDouble(6,foods.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //xoa cứng là xóa hẳn
    // xóa mềm là ẩn giá trị đó đi bằng status và nó vẫn tồn tại trong cơ sở dư liệu .
    @Override
    public boolean delete(Foods foods) {
        String query = "UPDATE foods SET status = ? , deletedAt = ? WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, foods.getStatus());
            ps.setLong(2,foods.getDeletedAt());
            ps.setInt(3,foods.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
