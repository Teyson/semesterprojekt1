/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.guisemesterprojekt1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marku
 */
public class PrimaryController implements Initializable {
    //Setting the Time Indicator
    @FXML ProgressBar timeProgressBar;
    
    //Setting the GridPane
    @FXML GridPane inventoryGrid;
    
    //Setting the AnchorPane
    @FXML AnchorPane dialogPane;
    
    //Setting the sprites in the gridpane
    @FXML Circle testNPC;
    
    //Setting the labels and their texts
    @FXML Label helpPopup;
    
    //Setting the buttons
    @FXML Button helpBtn;
    @FXML Button openHandbook;
    
    
    
    
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
    
    public void handleOpenBook(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sp1/guisemesterprojekt1/Handbook.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Doctor's Handbook");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
        }
    
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
