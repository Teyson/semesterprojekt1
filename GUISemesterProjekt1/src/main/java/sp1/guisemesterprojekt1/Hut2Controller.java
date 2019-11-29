/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * FXML Controller class
 *
 * @author marku
 */
public class Hut2Controller implements Initializable {

    //Setting the Time Indicator
    @FXML
    ProgressBar timeProgressBar;

    //Setting the GridPane
    @FXML
    GridPane inventoryGrid;
    @FXML
    GridPane gameGrid;
    @FXML
    GridPane dialogOptionsGrid;

    //Setting the AnchorPane
    @FXML
    AnchorPane dialogPane;
    @FXML
    AnchorPane helpPopup;

    //Setting the sprites in the gridpane
    @FXML
    Circle testNPC;

    //Setting the labels and their texts
    @FXML
    Label helpLabel;
    @FXML
    Label dialogLabel;
    @FXML
    Label NPCNameLabel;

    //Setting the buttons
    @FXML
    Button treatBtn;
    @FXML
    Button giveItemBtn;

    @FXML
    Button answer1;
    @FXML
    Button answer2;
    @FXML
    Button answer3;
    @FXML
    Button answer4;
    @FXML
    Button answer5;

    //Setting the ImageViews
    @FXML
    ImageView backgroundImage;
    @FXML
    ImageView NPCImage;
    @FXML
    ImageView helpBtn;
    @FXML
    ImageView trashBtn;
    @FXML
    ImageView closeDialog;
    @FXML
    ImageView closeHelp;
    @FXML
    ImageView openHandbook;

    //Setting the Grid ImageViews
    @FXML
    ImageView field0_0;
    @FXML
    ImageView field0_1;
    @FXML
    ImageView field0_2;
    @FXML
    ImageView field0_3;
    @FXML
    ImageView field0_4;
    @FXML
    ImageView field0_5;
    @FXML
    ImageView field0_6;
    @FXML
    ImageView field1_0;
    @FXML
    ImageView field1_1;
    @FXML
    ImageView field1_2;
    @FXML
    ImageView field1_3;
    @FXML
    ImageView field1_4;
    @FXML
    ImageView field1_5;
    @FXML
    ImageView field1_6;
    @FXML
    ImageView field2_0;
    @FXML
    ImageView field2_1;
    @FXML
    ImageView field2_2;
    @FXML
    ImageView field2_3;
    @FXML
    ImageView field2_4;
    @FXML
    ImageView field2_5;
    @FXML
    ImageView field2_6;
    @FXML
    ImageView field3_0;
    @FXML
    ImageView field3_1;
    @FXML
    ImageView field3_2;
    @FXML
    ImageView field3_3;
    @FXML
    ImageView field3_4;
    @FXML
    ImageView field3_5;
    @FXML
    ImageView field3_6;
    @FXML
    ImageView field4_0;
    @FXML
    ImageView field4_1;
    @FXML
    ImageView field4_2;
    @FXML
    ImageView field4_3;
    @FXML
    ImageView field4_4;
    @FXML
    ImageView field4_5;
    @FXML
    ImageView field4_6;
    @FXML
    ImageView field5_0;
    @FXML
    ImageView field5_1;
    @FXML
    ImageView field5_2;
    @FXML
    ImageView field5_3;
    @FXML
    ImageView field5_4;
    @FXML
    ImageView field5_5;
    @FXML
    ImageView field5_6;
    @FXML
    ImageView field6_0;
    @FXML
    ImageView field6_1;
    @FXML
    ImageView field6_2;
    @FXML
    ImageView field6_3;
    @FXML
    ImageView field6_4;
    @FXML
    ImageView field6_5;
    @FXML
    ImageView field6_6;
    @FXML
    ImageView field7_0;
    @FXML
    ImageView field7_1;
    @FXML
    ImageView field7_2;
    @FXML
    ImageView field7_3;
    @FXML
    ImageView field7_4;
    @FXML
    ImageView field7_5;
    @FXML
    ImageView field7_6;
    @FXML
    ImageView field8_0;
    @FXML
    ImageView field8_1;
    @FXML
    ImageView field8_2;
    @FXML
    ImageView field8_3;
    @FXML
    ImageView field8_4;
    @FXML
    ImageView field8_5;
    @FXML
    ImageView field8_6;
    @FXML
    ImageView field9_0;
    @FXML
    ImageView field9_1;
    @FXML
    ImageView field9_2;
    @FXML
    ImageView field9_3;
    @FXML
    ImageView field9_4;
    @FXML
    ImageView field9_5;
    @FXML
    ImageView field9_6;
    @FXML
    ImageView field10_0;
    @FXML
    ImageView field10_1;
    @FXML
    ImageView field10_2;
    @FXML
    ImageView field10_3;
    @FXML
    ImageView field10_4;
    @FXML
    ImageView field10_5;
    @FXML
    ImageView field10_6;
    @FXML
    ImageView field11_0;
    @FXML
    ImageView field11_1;
    @FXML
    ImageView field11_2;
    @FXML
    ImageView field11_3;
    @FXML
    ImageView field11_4;
    @FXML
    ImageView field11_5;
    @FXML
    ImageView field11_6;

    //Setting the Inventory images
    @FXML
    ImageView inv1;
    @FXML
    ImageView inv2;
    @FXML
    ImageView inv3;
    @FXML
    ImageView inv4;
    @FXML
    ImageView inv5;
    @FXML
    ImageView inv6;
    @FXML
    ImageView inv7;
    @FXML
    ImageView inv8;

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
    String hut2 = "backgrounds/Hut 2.jpg";
    Image toShow = new Image(hut2);


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

        //Setting the appearance of the Help, Book, Close and Trash button images
        trashBtn.setImage(trashButton);

        helpBtn.setImage(helpButton);

        closeDialog.setImage(closeButton);
        closeHelp.setImage(closeButton);

        openHandbook.setImage(handbookButton);

        //Setting the background image
        backgroundImage.setImage(toShow);

    }

    public void handleCloseDialog(MouseEvent event) {
        dialogPane.setVisible(false);
    }

    public void handleOpenHelpPane(MouseEvent event) {
        helpPopup.setVisible(true);
        helpLabel.setText("Your task is to cure as many citizens of Mozambique as you can, within the time\n"
                + "limit. You do this by talking to them, by clicking on them, and making your \n"
                + "choice of progression. Be aware that certain actions take time.\n"
                + "You earn points by treating patients correctly, and by giving them an item \n"
                + "that helps them prevent spreading their disease. When time is out, see how\n"
                + "many you have saved from their contracted disease!");

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

    public void handleExitEvent(MouseEvent event) throws IOException {
        App.setRoot("village");
    }

}
