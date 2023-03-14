package helpdesk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    TextField username;
    @FXML
    PasswordField password1;
    @FXML
    PasswordField password2;
    @FXML
    Label error_message;
    @FXML
    Button button_cancel;
    @FXML
    Button button_register;

    public void onCancelButtonClick(ActionEvent actionEvent) {
        try {
            // Sukuriamas dashboard langas
            Parent root = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
            Stage stage = new Stage();
            stage.setTitle(("Login"));
            stage.setScene(new Scene(root, 550, 450));
            stage.show();
            // Paslepiamas prisijungimo langas
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onRegisterButtonClick(ActionEvent actionEvent) {
        
    }
}
