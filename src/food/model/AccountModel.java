package food.model;

import food.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountModel implements AccountDataAccessObject<Account,Integer>{
    Connection connection = MySqlFood.getInstance().getConnection();
    PreparedStatement ps = null;

    @Override
    public boolean register(Account account) {
        String query = "INSERT INTO account(username, password, memberdId, createdAt, updatedAt , deletedAt, status, memberid)VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,account.getUsername());
            ps.setString(2,account.getPassword());
            ps.setString(3,account.getMembercardId());
            ps.setLong(4,account.getCreatedAt());
            ps.setLong(5,account.getUpdatedAt());
            ps.setLong(6,account.getDeletedAt());
            ps.setInt(7,account.getStatus());
            ps.setInt(8,account.getMemberid());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account login(String username, String password) {
        String query = "SELECT * FROM account WHERE username = ? AND password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Account account) {
        String query = "UPDATE account SET password = ?, updatedAt = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,account.getPassword());
            ps.setLong(2,account.getUpdatedAt());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Account> list() {
        ArrayList<Account> list = new ArrayList<>();
        String query = "SELECT * FROM account";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Account(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("membercardId"),rs.getLong("createdAt"),rs.getLong("updatedAt"),rs.getLong("deletedAt"),rs.getInt("status"),rs.getInt("memberId")));
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deletedAt(Account account) {
        String query = "UPDATE account SET password =? ,updatedAt=? WHERE id =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,account.getPassword());
            ps.setLong(2,account.getUpdatedAt());
            ps.setInt(3,account.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
