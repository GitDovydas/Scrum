package helpdesk.controller;

import helpdesk.model.Password;
import helpdesk.model.User;
import helpdesk.model.UserDAO;
import helpdesk.utils.Validation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    TextField email;
    @FXML
    Label error_message;
    @FXML
    Button button_cancel;
    @FXML
    Button button_register;

    public void onCancelButtonClick(ActionEvent actionEvent) {
        try {
            // Sukuriamas dashboard langas
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/login.fxml"));
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
        button_register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!Validation.isValidUsername(username.getText())){
                    error_message.setText("Invalid username");
                }
                else if (!Validation.isValidPassword(password1.getText())){
                    error_message.setText("Invalid password");
                }
                else if(!password1.getText().equals(password2.getText())){
                    error_message.setText("Passwords do not match");
                }
                else if(!Validation.isValidEmail(email.getText())){
                    error_message.setText("Invalid email");
                }
                else{
                    // Dashboard kontrolerį yra funkcija kuri gražina vartotoja į Login ekraną
                try{

                } catch (){

                }

                    String hashedPassword = Password.hashPasswWord(password1.getText());
                    User user = new User(username.getText(), hashedPassword, email.getText());
                    UserDAO.create(user);

                    DashboardController dashboardController = new DashboardController();
                    dashboardController.goToLogin(actionEvent);
                }






            }
        });


    }
}
