package food.model;

import food.entity.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberModel implements MemberDataAccessObject<Member,Integer>{
    Connection connection = MySqlFood.getInstance().getConnection();
    PreparedStatement ps = null;

    @Override
    public boolean add(Member member) {
        String query = "INSERT INTO member(fullname, address, phone, email, gender)VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,member.getFullname());
            ps.setString(2,member.getAddress());
            ps.setString(3,member.getPhone());
            ps.setString(4,member.getEmail());
            ps.setString(5,member.getGender());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Member member) {
        String query = "UPDATE member SET fullname = ? , address = ? , phone = ?, email = ? , gender = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,member.getFullname());
            ps.setString(2,member.getAddress());
            ps.setString(3,member.getPhone());
            ps.setString(4,member.getEmail());
            ps.setString(5,member.getGender());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
