package Main;

import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/LoginScreen.fxml"));
        stage.setTitle("Login Screen");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }

    public static void main(String[] args){


        JDBC.openConnection();


        launch(args);



        JDBC.closeConnection();
    }


   // ResourceBundle rb = ResourceBundle.getBundle("Main/Nat_fr.properties", Locale.getDefault());



}
