/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.guisemesterprojekt1;

import Domain.DomainAdministration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author marku
 */
public class StartMenuController implements Initializable {

    @FXML
    Button startGameBtn;

    @FXML
    ImageView backgroundImage;

    //Backgrounds
    String start = "backgrounds/starmenu.jpg";
    Image toShow = new Image(start);

    private static DomainAdministration da;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        da = App.getDomainAdministration();
        backgroundImage.setImage(toShow);

    }

    public void startGameOnAction(ActionEvent event) throws IOException {
        da.setRoom(da.getRoomMap().get("spawn"));
        App.setRoot("spawn");
    }

}
