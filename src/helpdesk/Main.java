package helpdesk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Main klasė paveldi tėvine Application klasę, kuri atsakinga už darbalaukio aplikacijų kūrima
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Nurodoma kur yra vaizdas (Kur yra grafinė vartotojo sąsaja (Forma į kuria vesime duomenis))
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));

        // Susikuriama scena kuri yra pakonfiguruojama
        Scene loginScene = new Scene(root, 300, 275);
        // Scenai nurodomas CSS failiukas pagal kurį bus modifikuojami scenoje esantys elementai
        loginScene.getStylesheets().add(getClass().getResource("view/CSS.css").toExternalForm());

        // Šiuo metu rodomas dialogas, nustatoma jo antraštė
        primaryStage.setTitle("Login");
        // Nustatomas dialogo plotas ir ilgis, ir priskiriama dialogui grafinė vartotojo sąsaja (Forma), tai yra užkraunami GUI
        primaryStage.setScene(loginScene);
        // Reikalinga kad rodytų dialoga
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Paleidžiamas metodas, kuris startuos GUI aplikaciją (Start metodas)
        launch(args);
    }
}
