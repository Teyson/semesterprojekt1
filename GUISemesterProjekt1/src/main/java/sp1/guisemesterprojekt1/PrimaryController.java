package sp1.guisemesterprojekt1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
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

import Domain.DomainAdministration;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author marku
 */
public class PrimaryController implements Initializable{

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

    @FXML Button answer1;
    @FXML Button answer2;
    @FXML Button answer3;
    
    //Setting the ImageViews
    @FXML ImageView backgroundImage;
    @FXML ImageView NPCImage;
    @FXML ImageView helpBtn;
    @FXML ImageView trashBtn;
    @FXML ImageView closeDialog;
    @FXML ImageView closeHelp;
    @FXML ImageView openHandbook;
    
    //Setting the Grid ImageViews
    @FXML ImageView field6_1;
    @FXML ImageView field7_3;

    
    //Setting the Inventory images
    @FXML ImageView inv1;
    @FXML ImageView inv2;
    @FXML ImageView inv3;
    @FXML ImageView inv4;
    @FXML ImageView inv5;
    @FXML ImageView inv6;
    @FXML ImageView inv7;
    @FXML ImageView inv8;

    //Initialising the image paths and setting them to an image
    //Buttons
    String trashButtonPath = "buttons/Trash.png";
    Image trashButton = new Image(trashButtonPath);

    String helpButtonPath = "buttons/Help.png";
    Image helpButton = new Image(helpButtonPath);

    String closeButtonPath = "buttons/Close.png";
    Image closeButton = new Image(closeButtonPath);

    String handbookPath = "buttons/Handbook.png";
    Image handbookButton = new Image(handbookPath);

    //Backgrounds
    String startZone = "backgrounds/WHO HQ.png";
    Image whoHQ = new Image(startZone);
    String nextRoom = "backgrounds/HQ Medicine Room.png";
    Image medHQ = new Image(nextRoom);

    //NPCs followed by that NPCs conversation image
    String mariaImage = "npc/Maria Mini.png";
    Image mariaMini = new Image(mariaImage);
    String mariaConvo = "convosprite/Maria.png";
    Image mariaTalk = new Image(mariaConvo);

    private double percentageTimeBar;

    /**
     * Initializes the controller class.
     *
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
        
        
        //Setting the room

        //Setting the appearance of the Help, Book, Close and Trash button images
        trashBtn.setImage(trashButton);

        helpBtn.setImage(helpButton);

        closeDialog.setImage(closeButton);
        closeHelp.setImage(closeButton);

        openHandbook.setImage(handbookButton);

        //Setting the background image
        backgroundImage.setImage(whoHQ);

        //Initialising Maria's NPC world sprite
        field7_3.setImage(mariaMini);

    }

    public void handleMariaClicked(MouseEvent event) {
        dialogPane.setVisible(!dialogPane.isVisible());
        answer1.setVisible(false);
        answer2.setVisible(false);
        answer3.setVisible(false);
        treatBtn.setVisible(false);
        giveItemBtn.setVisible(false);

        //Initialising Maria's conversation image
        NPCImage.setImage(mariaTalk);

        //Renaming the Dialog window for Maria
        NPCNameLabel.setText("Maria Hoffmann");

        dialogLabel.setText("Hello! Welcome to the World Health Organisation's HQ!\n"
                + "My name is Maria and I will be your guide on your volunteering experience!\n");
        
        answer1.setVisible(true);
        answer1.setText("More");
        answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dialogLabel.setText("Your job is to go to Mozambique and treat patients with some dangerous\n"
                        + "diseases; these diseases are: Malaria, HIV/AIDS and Tuberculosis.\n"
                        + "First however, you must learn to use this Handbook, and then you will\n"
                        + "travel to our Mozambique warehouse, where you will pack medicine into\n"
                        + "a truck, and depart for one of the villages we work with. Be careful though\n"
                        + "you do not have unlimited space and time! Cure as many as you can before\n"
                        + "your own vaccines are running out.");

                if (openHandbook.isVisible() == false) {
                    answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            NPCNameLabel.setText(null);
                            NPCImage.setImage(null);
                            dialogLabel.setText("You obtained the Doctor's Handbook!");

                            openHandbook.setVisible(true);

                            answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    NPCNameLabel.setText("Maria Hoffmann");
                                    NPCImage.setImage(mariaTalk);
                                    dialogLabel.setText("I think you are ready now!\n"
                                            + "Go through the door to get to the warehouse in Mozambique!\n"
                                            + "I will meet you there!");

                                    answer1.setVisible(false);
                                }

                            });
                        }
                    });
                }

                if (openHandbook.isVisible() == true) {
                    answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            NPCNameLabel.setText("Maria Hoffmann");
                            NPCImage.setImage(mariaTalk);
                            dialogLabel.setText("I think you are ready now!\n"
                                    + "Go through the door to get to the warehouse in Mozambique!\n"
                                    + "I will meet you there!");

                            answer1.setVisible(false);
                        }

                    });
                }
            }
        });

    }

    public void handleCloseDialog(MouseEvent event) {
        dialogPane.setVisible(false);
    }

    public void handleOpenHelpPane(MouseEvent event) {
        helpPopup.setVisible(true);
        helpLabel.setText("Your task is to cure as many citizens of Mozambique as you can, within the time\n"+
                          "limit. You do this by talking to them, by clicking on them, and making your \n"+
                          "choice of progression. Be aware that certain actions take time.\n"+
                          "You earn points by treating patients correctly, and by giving them an item \n"+
                          "that helps them prevent spreading their disease. When time is out, see how\n"+
                          "many you have saved from their contracted disease!");

    }

    public void handleCloseHelp(MouseEvent event) {
        helpPopup.setVisible(false);
    }

    public void handleOpenBook(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sp1/guisemesterprojekt1/Handbook.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Doctor's Handbook");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void handleExitClickedEvent(MouseEvent event) throws IOException {
       if(openHandbook.isVisible() == true){
        App.setRoot("medHQ");
       }
       else{
           dialogPane.setVisible(!dialogPane.isVisible());
           answer1.setVisible(false);
           answer2.setVisible(false);
           answer3.setVisible(false);
           treatBtn.setVisible(false);
           giveItemBtn.setVisible(false);
           
           NPCImage.setImage(mariaTalk);
           NPCNameLabel.setText("Maria Hoffmann");

           dialogLabel.setText("Hey! Come over here and talk to me before leaving!");
       }
    }
    /*
    public void handleRestartKey(KeyEvent event){
        if (event.getCode() == KeyCode.SPACE) {
            try {
                App.setRoot("startMenu");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            }
    }
    */
}
