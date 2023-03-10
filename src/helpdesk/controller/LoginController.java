package helpdesk.controller;

import helpdesk.utils.Validation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    Button login_button;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label login_error;

    public void onLoginButtonClick(ActionEvent actionEvent) {
        // Aprašomas mygtuko paspaudimas
        login_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Aprašomi veiksmai kurie bus atlikti paspaudus mygtuką
                String username2 = username.getText();
                String password2 = password.getText();

                // Atliekama vartotojo įvestų duomenų validacija
                if(Validation.isValidUsername(username2) && Validation.isValidPassword(password2)){
                    login_error.setText("Username: " + username2 + "\n" + "Password: " + password2);
                }
                else {
                    login_error.setText("Wrong username or password");
                }

            }
        });

    }
}
