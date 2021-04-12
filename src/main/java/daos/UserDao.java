package daos;

import models.User;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDao implements Dao<User> {

    Connection connection = ConnectionFactory.getConnection();

    public User findById(int id) {

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id =" + id);

            if (rs.next()) {
                return this.extractUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();

        user.setId( rs.getInt("Id") );
        user.setUser( rs.getString("user") );
        user.setName( rs.getString("Name") );
        user.setDob( rs.getDate("DOB").toLocalDate() );
        user.setCity( rs.getString("City") );
        user.setCountry( rs.getString("Country") );
        user.setPass( rs.getString("Pass") );

        return user;
    }

    public Set<User> findAll() {
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM User");

            Set<User> users = new HashSet<>();

            while (rs.next()) {
                users.add(this.extractUserFromResultSet(rs));
            }

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer create(User user) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO User VALUES (null, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUser() );
            ps.setString(2, user.getName() );
            ps.setDate(3, java.sql.Date.valueOf(user.getDob()) );
            ps.setString(4, user.getCity() );
            ps.setString(5, user.getCountry() );
            ps.setString(6, user.getPass() );
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
            //return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(User user) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(
                    "UPDATE User " +
                        "SET user = ?, " +
                        "Name = ?, " +
                        "DOB = ?, " +
                        "City = ?, " +
                        "Country = ?, " +
                        "Pass = ? " +
                        "WHERE id = ? "
            );

            ps.setString(1, user.getUser() );
            ps.setString(2, user.getName() );
            ps.setDate(3, java.sql.Date.valueOf(user.getDob()) );
            ps.setString(4, user.getCity() );
            ps.setString(5, user.getCountry() );
            ps.setString(6, user.getPass() );
            ps.setInt(7, user.getId());
            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            Statement s = this.connection.createStatement();
            return s.executeUpdate("DELETE FROM user WHERE id=" + id) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
