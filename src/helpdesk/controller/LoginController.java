package helpdesk.controller;

import helpdesk.utils.Validation;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
                    // Jeigu gerai įvesti duomenys reikės pereiti iš login ekrano į dashboard(pagrindinį) ekraną
                    goToDashboard(actionEvent);
                }
                else {
                    login_error.getText();
                    login_error.setVisible(true);
                }

            }
        });

    }

    public void goToDashboard(ActionEvent actionEvent){
        // Mes esame kontrolerio aplanke, bet vaizdo čia nėra, todėl mes turime pakilti vienu aplanku į viršų (../)
        try {
            // Sukuriamas dashboard langas
            Parent root = FXMLLoader.load(getClass().getResource("../view/dashboard.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dashboard");
            stage.setScene(new Scene(root, 800, 700));
            stage.show();
            // Paslepiamas prisijungimo langas
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
