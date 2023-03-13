package helpdesk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML
    Button return_button;
    // Jeigu nerodo ikonėlių prie FXML elementų patikrinti ar FXMLe yra nurodytas kontroleris

    /**
     * Funkcija kuri gražina vartotoja į login ekraną
     */
    public void goToLogin(ActionEvent actionEvent){
        try {
            // Sukuriamas dashboard langas
            Parent root = FXMLLoader.load(getClass().getResource("../view/login.fxml"));

            Stage stage = new Stage();
            // Susikuriama scena kuri yra pakonfiguruojama
            Scene loginScene = new Scene(root, 300, 275);
            // Scenai nurodomas CSS failiukas pagal kurį bus modifikuojami scenoje esantys elementai
            loginScene.getStylesheets().add(getClass().getResource("../view/CSS.css").toExternalForm());
            stage.setTitle("Login");
            stage.setScene(loginScene);
            stage.show();
            // Paslepiamas dashboard langas
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
