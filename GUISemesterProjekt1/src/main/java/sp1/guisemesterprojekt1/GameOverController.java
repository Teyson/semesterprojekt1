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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author marku
 */
public class GameOverController implements Initializable {

    @FXML
    Button startGameBtn;
    
    @FXML
    ImageView backgroundImage;
    
    @FXML
    ImageView backgroundGIF;

    //Backgrounds
    String gameOver = "backgrounds/gameover.gif";
    Image toShow = new Image(gameOver);

    private static DomainAdministration da;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        da = App.getDomainAdministration();
        backgroundImage.setImage(toShow);

    }
    
    public void handleRestartEvent(MouseEvent event) throws IOException {
        System.exit(-1);
    }
}
