package helpdesk.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML
    Button return_button;
    // Jei nerodo ikonėlių prie FXML elementų patikrinti ar FMLe yra nurodytas kontroleris

    /**
     * Funkcija grąžinantį vartotoją į login langą
     */
    public void goToLogin(ActionEvent actionEvent) {
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
    };
}
