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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML GridPane gameGrid;
    @FXML GridPane dialogOptionsGrid;
    
    //Setting the AnchorPane
    @FXML AnchorPane dialogPane;
    @FXML AnchorPane helpPopup;
    
    //Setting the sprites in the gridpane
    @FXML Circle testNPC;
    
    //Setting the labels and their texts
    @FXML Label helpLabel;
    @FXML Label dialogLabel;
    @FXML Label NPCNameLabel;
    
    
    //Setting the buttons
    @FXML Button treatBtn;
    @FXML Button giveItemBtn;
    @FXML Button openHandbook;
    @FXML Button answer1;
    @FXML Button answer2;
    @FXML Button answer3;
    @FXML Button answer4;
    @FXML Button answer5;
    
    
    //Setting the ImageViews
    @FXML ImageView backgroundImage;
    @FXML ImageView NPCImage;
    @FXML ImageView field7_3;
    @FXML ImageView helpBtn;
    @FXML ImageView trashBtn;
    @FXML ImageView closeDialog;
    @FXML ImageView closeHelp;
    
    
    
    
    private double percentageTimeBar;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        percentageTimeBar = 1.0;
        timeProgressBar.setProgress(percentageTimeBar);
        dialogPane.setVisible(false);
        helpPopup.setVisible(false);
        openHandbook.setVisible(false);
        
        //Setting the appearance of the Help and Trash button images
        String trashButtonPath = "buttons/Trash.png";
        Image trashButton = new Image(trashButtonPath);
        trashBtn.setImage(trashButton);

        String helpButtonPath = "buttons/Help.png";
        Image helpButton = new Image(helpButtonPath);
        helpBtn.setImage(helpButton);
        
        String closeButtonPath = "buttons/Close.png";
        Image closeButton = new Image(closeButtonPath);
        closeDialog.setImage(closeButton);
        closeHelp.setImage(closeButton);
        
        //Setting the background image
        String startZone = "backgrounds/WHO HQ.png";
        Image whoHQ = new Image(startZone);
        backgroundImage.setImage(whoHQ);
        
        //Initialising Maria's NPC world sprite
        String mariaImage = "npc/Maria Mini.png";
        Image mariaMini = new Image(mariaImage);
        
        field7_3.setImage(mariaMini);
        
        
        
    }
    
    public void handleMariaClicked(MouseEvent event){
        dialogPane.setVisible(!dialogPane.isVisible());
        answer1.setVisible(false);
        answer3.setVisible(false);
        answer5.setVisible(false);
        treatBtn.setVisible(false);
        giveItemBtn.setVisible(false);

        //Initialising Maria's conversation image
        String mariaConvo = "convosprite/Maria.png";
        Image mariaTalk = new Image(mariaConvo);
        NPCImage.setImage(mariaTalk);
        
        //Renaming the Dialog window for Maria
        NPCNameLabel.setText("Maria Hoffmann");
        
        dialogLabel.setText("Hello! Welcome to the World Health Organisation's HQ!\n"+
                           "My name is Maria and I will be your guide on your volunteering experience!\n"+
                           "Is there anything you want to know?");
        
        answer2.setText("More");
       
        answer4.setText("Leave");
        
        
    }
    
    public void handleCloseDialog(MouseEvent event){
        dialogPane.setVisible(false);
    }
    
    public void handleOpenHelpPane(MouseEvent event){
        helpPopup.setVisible(true);
        closeDialog.setVisible(true);
        
    }
    
    public void handleCloseHelp(MouseEvent event){
        helpPopup.setVisible(false);
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
