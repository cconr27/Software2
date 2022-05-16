package helper;

import com.mysql.cj.jdbc.JdbcConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {

    public static ObservableList<Users> userList = FXCollections.observableArrayList();
    public String userName;
    public String password;

    public Users (String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public static ObservableList<Users> getAllUsers(){
        try{
            String sql = "Select * from users";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String userName = rs.getString("User_Name");
                String password = rs.getString("Password");
                Users u = new Users(userName, password);
                userList.add(u);
                System.out.print(userName + " | " + password + "\n");



            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return userList;
    }
}
