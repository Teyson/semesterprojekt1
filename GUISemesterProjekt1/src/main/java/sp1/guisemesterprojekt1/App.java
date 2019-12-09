package sp1.guisemesterprojekt1;

import Domain.DomainAdministration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import Domain.DomainAdministration;

/**
 * JavaFX App
 */
public class App extends Application {

    private static DomainAdministration da;
    private static Scene scene;

    @Override
    public void init() {
        da = new DomainAdministration();
        da.setup();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("startMenu"), 800, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        if (da.getTime().getTime() != 0) {
            scene.setRoot(loadFXML(fxml));
        }
        if (da.getTime().getTime() == 0 && da.getWinCondition() == false) {
            scene.setRoot(loadFXML("gameOver"));

        }
        if (da.getTime().getTime() == 0 && da.getWinCondition() == true) {
            scene.setRoot(loadFXML("win"));

        }
    }

    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void load(String[] args) {
        launch();
    }

    public static DomainAdministration getDomainAdministration() {
        return da;
    }
}
