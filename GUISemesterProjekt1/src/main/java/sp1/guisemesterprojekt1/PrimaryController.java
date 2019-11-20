/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.guisemesterprojekt1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author marku
 */
public class PrimaryController implements Initializable {
    
    @FXML
    ProgressBar timeProgressBar;
    
    @FXML
    GridPane inventoryGrid;
    
    @FXML
    AnchorPane dialogPane;
    
    @FXML
    Circle testNPC;
    
    @FXML
    Label helpPopup;
    
    @FXML
    Button helpBtn;
    
    
    
    private double percentageTimeBar;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        percentageTimeBar = 1.0;
        timeProgressBar.setProgress(percentageTimeBar);
        dialogPane.setVisible(false);
        helpPopup.setVisible(false);
        
        
    }
    
    public void onMouseClickedAction(MouseEvent event){
        dialogPane.setVisible(!dialogPane.isVisible());
    }
    
    public void openHelpLabel(ActionEvent event){
        helpPopup.setVisible(!helpPopup.isVisible());
        
    }
}
