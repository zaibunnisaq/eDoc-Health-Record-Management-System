package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController 
{
    /*The logic of user registration is moved to a UserController class.
The UserController class handles all the validations, database interactions, and returns a result message.
This maintains high cohesion and follows the Controller pattern.*/
	
	
    // Method to register a new user
    public String registerUser(String name, String email, String username, String password, String phone) {
        if (name.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            return "Every field is required";
        }
        if (doesUserExist(username)) {
            return "This username already exists";
        }

        // Insert user into database
        boolean isInserted = insertNewUser(name, email, username, password, phone);
        if (isInserted) {
            return "Registration Successful";
        } else {
            return "Could not register user";
        }
    }

    // check if a user already exists in the database
    private boolean doesUserExist(String username) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
             PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM patient WHERE uusername = ?")) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Ideally, log this error
        }
        return false;
    }

    // Method to insert a new user into the database
    private boolean insertNewUser(String name, String email, String username, String password, String phone) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/edoc", "root", "kissa123");
             PreparedStatement stmt = con.prepareStatement("INSERT INTO patient (uname, uemail, uusername, upassword, uphone) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, username);
            stmt.setString(4, password); // Consider using hashed password
            stmt.setString(5, phone);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Ideally, log this error
        }
        return false;
    }
}
