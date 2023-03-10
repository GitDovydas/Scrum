package helpdesk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Main klasė pavrldi tėvinę Application klasę, kuri atsaking už darbalaukio aplikacijų kūrimą
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Nurodomo, kur yra vaizdas (kur yra grafinė vartotojo sąsaja, t.y. forma į kurią vesime duomenis
        // Sukuriama scena kuri yra konfiguruojama
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        // Scenai nurodomas CSS failas pagalkur5 bus modifikuojami scenoje esantys elementai
//        Scene loginScene = new Scene(root, 300, 275);
//        loginScene.getStylesheets().add(getClass().getResource("view/style.css").toExternalForm());
        // Šiuo metu rodomoas dialogas. Nustatomas jo antraštė
        primaryStage.setTitle("Login");
        // Nustatomas dialogo plotas ir ilgis, ir priskiriama dialogui grafinė artotojo sąsaja (Forma), tai yra užkraunama vartojo vaizdas
        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.setScene(loginScene);
        // Reikalinga, kad rodytų dialogą
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Paleidžiamas metodas, kuris startuos GUI aplikaciją (Start metodas)
        launch(args);
    }
}
