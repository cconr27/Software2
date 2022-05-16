package Controller;

import helper.JDBC;
import helper.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {
    public TextField UserNameTF;
    public TextField passwordTF;
    public String currentUserName;
    public String currentPassword;
    public String c;
    public String p;


    public String getCurrentUserName() {

        currentUserName = UserNameTF.getText();
        return currentUserName;
    }

    public String getCurrentPassword() {

        currentPassword = passwordTF.getText();
        return currentPassword;
    }

    public void onExitClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            JDBC.closeConnection();
            System.exit(0);
        }

    }

    public void onSubmitClick(ActionEvent actionEvent) throws IOException {
        c = getCurrentUserName();
        p = getCurrentPassword();


        for (Users user : Users.userList) {
            System.out.println(user.userName);
            String pw;
            if (user.userName.equals(c)) {
                pw = user.password;
                System.out.println("Username found");

                if (pw.equals(p)) {
                    System.out.println("Credentials Accepted");

                    Parent root = FXMLLoader.load(getClass().getResource("/View/DisplayScheduleScreen.fxml"));
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root, 1200, 800);
                    stage.setTitle("Schedule Screen");
                    stage.setScene(scene);
                    stage.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "UserName or password is incorrect.");
                    alert.show();
                }

            }

            else {

                    Alert alert = new Alert(Alert.AlertType.ERROR, "UserName or password is incorrect.");
                    alert.show();

            }


        }
    }

        @Override
        public void initialize (URL url, ResourceBundle resourceBundle){
            Users.getAllUsers();
        }
    }

