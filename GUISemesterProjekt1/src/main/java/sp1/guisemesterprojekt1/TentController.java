/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.guisemesterprojekt1;

import Domain.DomainAdministration;
import Interfaces.IInventory;
import Interfaces.ITime;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
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
public class TentController implements Initializable {

    DomainAdministration da;
    //Setting the Time Indicator
    @FXML
    ProgressBar timeProgressBar;

    @FXML
    Label pointLabel;

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
    String tent = "backgrounds/tent.png";
    Image toShow = new Image(tent);

    private double percentageTimeBar;

    //Items
    String kanyleClean = "img/Clean Kanyle.png";
    Image imgKanyleClean = new Image(kanyleClean);
    String kanyleDirty = "img/Dirty Kanyle.png";
    Image imgKanyleDirty = new Image(kanyleDirty);
    String condom = "img/Condom.png";
    Image imgCondom = new Image(condom);
    String hivMeds = "img/HIV Medicine.png";
    Image imgHivMeds = new Image(hivMeds);
    String malariaMeds = "img/Malaria Medicine.png";
    Image imgMalariaMeds = new Image(malariaMeds);
    String tbMeds = "img/TB Medicine.png";
    Image imgTbMeds = new Image(tbMeds);
    String pill = "img/pill.png";
    Image imgPill = new Image(pill);
    String mask = "img/mask.png";
    Image imgMask = new Image(mask);
    String spray = "img/Mosquito Spray.png";
    Image imgSpray = new Image(spray);
    HashMap<String, Image> itemImageMap;
    HashMap<String, String> itemImageMapReverse;

    IInventory playerInventory;
    IInventory roomInventory;
    IInventory truckInventory;
    ArrayList<ImageView> inventoryImageList;
    ArrayList<ImageView> truckInventoryImageList;

    boolean trashingActive = false;
    @FXML
    private AnchorPane truckInventoryPane;

    @FXML
    private GridPane truckInventoryGrid;

    @FXML
    private ImageView tck0;
    @FXML
    private ImageView tck1;
    @FXML
    private ImageView tck2;
    @FXML
    private ImageView tck3;
    @FXML
    private ImageView tck4;
    @FXML
    private ImageView tck5;
    @FXML
    private ImageView tck6;
    @FXML
    private ImageView tck7;
    @FXML
    private ImageView tck8;
    @FXML
    private ImageView tck9;
    @FXML
    private ImageView tck10;
    @FXML
    private ImageView tck11;
    @FXML
    private ImageView tck12;
    @FXML
    private ImageView tck13;
    @FXML
    private ImageView tck14;
    @FXML
    private ImageView tck15;
    @FXML
    private ImageView tck16;
    @FXML
    private ImageView tck17;
    @FXML
    private ImageView tck18;
    @FXML
    private ImageView tck19;
    @FXML
    private ImageView tck20;
    @FXML
    private ImageView tck21;
    @FXML
    private ImageView tck22;
    @FXML
    private ImageView tck23;
    @FXML
    private ImageView tck24;
    @FXML
    private ImageView tck25;
    @FXML
    private ImageView tck26;
    @FXML
    private ImageView tck27;
    @FXML
    private ImageView tck28;
    @FXML
    private ImageView tck29;
    @FXML
    private ImageView tck30;
    @FXML
    private ImageView tck31;
    @FXML
    private ImageView tck32;
    @FXML
    private ImageView tck33;
    @FXML
    private ImageView tck34;
    @FXML
    private ImageView tck35;
    @FXML
    private ImageView tck36;
    @FXML
    private ImageView tck37;
    @FXML
    private ImageView tck38;
    @FXML
    private ImageView tck39;
    @FXML
    private ImageView closeTruckInventory;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        da = App.getDomainAdministration();
        ITime time = da.getTime();
        timeProgressBar.setProgress(time.getPercentTime());
        dialogPane.setVisible(false);
        helpPopup.setVisible(false);
        openHandbook.setVisible(true);
        truckInventoryPane.setVisible(false);
        truckInventoryGrid.setVisible(false);

        //Setting the appearance of the Help, Book, Close and Trash button images
        trashBtn.setImage(trashButton);

        helpBtn.setImage(helpButton);

        closeDialog.setImage(closeButton);
        closeHelp.setImage(closeButton);

        openHandbook.setImage(handbookButton);

        //Setting the background image
        backgroundImage.setImage(toShow);

        //Get roominventory
        roomInventory = da.getRoom().getItems();

        //Get playerinventory
        playerInventory = da.getInventory();

        // get truckInventory
        truckInventory = da.getTruckInventory();

        //Fill items into map.
        itemImageMap = new HashMap<>() {
            {
                put("Clean Syringe", imgKanyleClean);
                put("Dirty Syringe", imgKanyleDirty);
                put("Condom", imgCondom);
                put("HIV Medication", imgHivMeds);
                put("Malaria Medication", imgMalariaMeds);
                put("Tuberculosis Medication", imgTbMeds);
                put("Pill", imgPill);
                put("Mask", imgMask);
                put("Mosquito Spray", imgSpray);
            }
        };

        itemImageMapReverse = new HashMap<>() {
            {
                put("Clean Kanyle.png", "Clean Syringe");
                put("Dirty Kanyle.png", "Dirty Syringe");
                put("Condom.png", "Condom");
                put("HIV Medicine.png", "HIV Medication");
                put("Malaria Medicine.png", "Malaria Medication");
                put("TB Medicine.png", "Tuberculosis Medication");
                put("pill.png", "Pill");
                put("mask.png", "Mask");
                put("Mosquito Spray.png", "Mosquito Spray");
            }
        };

        //Make arraylist of inventory slots for easy iteration
        inventoryImageList = new ArrayList<>() {
            {
                add(inv1);
                add(inv2);
                add(inv3);
                add(inv4);
                add(inv5);
                add(inv6);
                add(inv7);
                add(inv8);
            }
        };
        truckInventoryImageList = new ArrayList<>() {
            {
                add(tck0);
                add(tck1);
                add(tck2);
                add(tck3);
                add(tck4);
                add(tck5);
                add(tck6);
                add(tck7);
                add(tck8);
                add(tck9);
                add(tck10);
                add(tck11);
                add(tck12);
                add(tck13);
                add(tck14);
                add(tck15);
                add(tck16);
                add(tck17);
                add(tck18);
                add(tck19);
                add(tck20);
                add(tck21);
                add(tck22);
                add(tck23);
                add(tck24);
                add(tck25);
                add(tck26);
                add(tck27);
                add(tck28);
                add(tck29);
                add(tck30);
                add(tck31);
                add(tck32);
                add(tck33);
                add(tck34);
                add(tck35);
                add(tck36);
                add(tck37);
                add(tck38);
                add(tck39);
            }
        };
        updatePoints();
        updateInventory();
        updateTruckInventory();

    }

    public void updatePoints() {
        pointLabel.setText(String.valueOf(da.getEvaluation().getPoints()));
    }

    //INVENTORY HANDLER
    public void updateInventory() {
        //Clears inventory
        for (int i = 0; i < inventoryImageList.size(); i++) {
            inventoryImageList.get(i).setVisible(false);
        }

        //Inserts items
        for (int j = 0; j < playerInventory.getKeys().size(); j++) {
            inventoryImageList.get(j).setImage(itemImageMap.get(playerInventory.getKeys().get(j)));
            inventoryImageList.get(j).setVisible(true);
        }
    }

    public void updateTruckInventory() {
        //Clears inventory
        for (int i = 0; i < truckInventoryImageList.size(); i++) {
            truckInventoryImageList.get(i).setVisible(false);
        }

        //Inserts items
        for (int j = 0; j < truckInventory.getKeys().size(); j++) {
            truckInventoryImageList.get(j).setImage(itemImageMap.get(truckInventory.getKeys().get(j)));
            truckInventoryImageList.get(j).setVisible(true);
        }
    }

    @FXML
    private void handleTrash(MouseEvent event) {
        //Change trashing state
        trashingActive = !trashingActive;

        if (trashingActive) {
            inventoryGrid.setStyle("-fx-background-color:#ff8f87"); //Red
        } else {
            inventoryGrid.setStyle("-fx-background-color:#ffffff"); //White
        }
    }

    @FXML
    private void handleInventorySlotClicked1(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(0));
            updateInventory();
        }
    }

    @FXML
    private void handleInventorySlotClicked2(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(1));
            updateInventory();
        }
    }

    @FXML
    private void handleInventorySlotClicked3(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(2));
            updateInventory();
        }
    }

    @FXML
    private void handleInventorySlotClicked4(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(3));
            updateInventory();
        }
    }

    @FXML
    private void handleInventorySlotClicked5(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(4));
            updateInventory();
        }
    }

    @FXML
    private void handleInventorySlotClicked6(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(5));
            updateInventory();
        }
    }

    @FXML
    private void handleInventorySlotClicked7(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(6));
            updateInventory();
        }
    }

    @FXML
    private void handleInventorySlotClicked8(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(7));
            updateInventory();
        }
    }

    //HANDLERS FOR DIALOGS
    @FXML
    public void handleCloseDialog(MouseEvent event) {
        dialogPane.setVisible(false);
    }

    @FXML
    public void handleOpenHelpPane(MouseEvent event) {
        helpPopup.setVisible(true);
        helpLabel.setText("Your task is to cure as many citizens of Mozambique as you can, within the time\n"
                + "limit. You do this by talking to them, by clicking on them, and making your \n"
                + "choice of progression. Be aware that certain actions take time.\n"
                + "You earn points by treating patients correctly, and by giving them an item \n"
                + "that helps them prevent spreading their disease. When time is out, see how\n"
                + "many you have saved from their contracted disease!");

    }

    @FXML
    public void handleCloseHelp(MouseEvent event) {
        helpPopup.setVisible(false);
    }

    //HANDLE HANDBOOK
    @FXML
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

    //HANDLE EXITS
    @FXML
    public void handleExitEvent(MouseEvent event) throws IOException {
        da.setRoom(da.getRoomMap().get("village"));
        App.setRoot("village");
    }

    @FXML
    private void handleTruckInventoryClose(MouseEvent event) {
    }

    public void removeTruckInventoryOnClicked(int i) {
        truckInventory.removeItem(truckInventory.getKeys().get(i));
        updateTruckInventory();
    }

    public void pickUpItemToPlayerInventory(int i) {
        String itemName = truckInventory.getKeys().get(i);
        System.out.println(itemName);
        //Add condition if playerInventory is full
        if (playerInventory.getSpaceUsed() < playerInventory.getInventorySize()) {
            playerInventory.addItem(itemName, truckInventory.getValues().get(truckInventory.getKeys().indexOf(itemName)));
            truckInventory.removeItem(truckInventory.getKeys().get(i));
            updateTruckInventory();
            updateInventory();
        }

    }

    @FXML
    private void handleTruckInventorySlotClicked1(MouseEvent event) {
        pickUpItemToPlayerInventory(0);
    }

    @FXML
    private void handleTruckInventorySlotClicked2(MouseEvent event) {
        pickUpItemToPlayerInventory(1);
    }

    @FXML
    private void handleTruckInventorySlotClicked3(MouseEvent event) {
        pickUpItemToPlayerInventory(2);
    }

    @FXML
    private void handleTruckInventorySlotClicked4(MouseEvent event) {
        pickUpItemToPlayerInventory(3);
    }

    @FXML
    private void handleTruckInventorySlotClicked5(MouseEvent event) {
        pickUpItemToPlayerInventory(4);
    }

    @FXML
    private void handleTruckInventorySlotClicked6(MouseEvent event) {
        pickUpItemToPlayerInventory(5);
    }

    @FXML
    private void handleTruckInventorySlotClicked7(MouseEvent event) {
        pickUpItemToPlayerInventory(6);
    }

    @FXML
    private void handleTruckInventorySlotClicked8(MouseEvent event) {
        pickUpItemToPlayerInventory(7);
    }

    @FXML
    private void handleTruckInventorySlotClicked9(MouseEvent event) {
        pickUpItemToPlayerInventory(8);
    }

    @FXML
    private void handleTruckInventorySlotClicked10(MouseEvent event) {
        pickUpItemToPlayerInventory(9);
    }

    @FXML
    private void handleTruckInventorySlotClicked11(MouseEvent event) {
        pickUpItemToPlayerInventory(10);
    }

    @FXML
    private void handleTruckInventorySlotClicked12(MouseEvent event) {
        pickUpItemToPlayerInventory(11);
    }

    @FXML
    private void handleTruckInventorySlotClicked13(MouseEvent event) {
        pickUpItemToPlayerInventory(12);
    }

    @FXML
    private void handleTruckInventorySlotClicked14(MouseEvent event) {
        pickUpItemToPlayerInventory(13);
    }

    @FXML
    private void handleTruckInventorySlotClicked15(MouseEvent event) {
        pickUpItemToPlayerInventory(14);
    }

    @FXML
    private void handleTruckInventorySlotClicked16(MouseEvent event) {
        pickUpItemToPlayerInventory(15);
    }

    @FXML
    private void handleTruckInventorySlotClicked17(MouseEvent event) {
        pickUpItemToPlayerInventory(16);
    }

    @FXML
    private void handleTruckInventorySlotClicked18(MouseEvent event) {
        pickUpItemToPlayerInventory(17);
    }

    @FXML
    private void handleTruckInventorySlotClicked19(MouseEvent event) {
        pickUpItemToPlayerInventory(18);
    }

    @FXML
    private void handleTruckInventorySlotClicked20(MouseEvent event) {
        pickUpItemToPlayerInventory(19);
    }

    @FXML
    private void handleTruckInventorySlotClicked21(MouseEvent event) {
        pickUpItemToPlayerInventory(20);
    }

    @FXML
    private void handleTruckInventorySlotClicked22(MouseEvent event) {
        pickUpItemToPlayerInventory(21);
    }

    @FXML
    private void handleTruckInventorySlotClicked23(MouseEvent event) {
        pickUpItemToPlayerInventory(22);
    }

    @FXML
    private void handleTruckInventorySlotClicked24(MouseEvent event) {
        pickUpItemToPlayerInventory(23);
    }

    @FXML
    private void handleTruckInventorySlotClicked25(MouseEvent event) {
        pickUpItemToPlayerInventory(24);
    }

    @FXML
    private void handleTruckInventorySlotClicked26(MouseEvent event) {
        pickUpItemToPlayerInventory(25);
    }

    @FXML
    private void handleTruckInventorySlotClicked27(MouseEvent event) {
        pickUpItemToPlayerInventory(26);
    }

    @FXML
    private void handleTruckInventorySlotClicked28(MouseEvent event) {
        pickUpItemToPlayerInventory(27);
    }

    @FXML
    private void handleTruckInventorySlotClicked29(MouseEvent event) {
        pickUpItemToPlayerInventory(28);
    }

    @FXML
    private void handleTruckInventorySlotClicked30(MouseEvent event) {
        pickUpItemToPlayerInventory(29);
    }

    @FXML
    private void handleTruckInventorySlotClicked31(MouseEvent event) {
        pickUpItemToPlayerInventory(30);
    }

    @FXML
    private void handleTruckInventorySlotClicked32(MouseEvent event) {
        pickUpItemToPlayerInventory(31);
    }

    @FXML
    private void handleTruckInventorySlotClicked33(MouseEvent event) {
        pickUpItemToPlayerInventory(32);
    }

    @FXML
    private void handleTruckInventorySlotClicked34(MouseEvent event) {
        pickUpItemToPlayerInventory(33);
    }

    @FXML
    private void handleTruckInventorySlotClicked35(MouseEvent event) {
        pickUpItemToPlayerInventory(34);
    }

    @FXML
    private void handleTruckInventorySlotClicked36(MouseEvent event) {
        pickUpItemToPlayerInventory(35);
    }

    @FXML
    private void handleTruckInventorySlotClicked37(MouseEvent event) {
        pickUpItemToPlayerInventory(36);
    }

    @FXML
    private void handleTruckInventorySlotClicked38(MouseEvent event) {
        pickUpItemToPlayerInventory(37);
    }

    @FXML
    private void handleTruckInventorySlotClicked39(MouseEvent event) {
        pickUpItemToPlayerInventory(38);
    }

    @FXML
    private void handleTruckInventorySlotClicked40(MouseEvent event) {
        pickUpItemToPlayerInventory(39);
    }

    @FXML
    private void handleTruckClicked1(MouseEvent event) {
        truckInventoryPane.setVisible(!truckInventoryPane.isVisible());
        truckInventoryGrid.setVisible(!truckInventoryGrid.isVisible());
        System.out.println("aåosdf");
    }

    @FXML
    private void handleTruckClicked2(MouseEvent event) {
        truckInventoryPane.setVisible(!truckInventoryPane.isVisible());
        truckInventoryGrid.setVisible(!truckInventoryGrid.isVisible());
        System.out.println("aåosdf");
    }

    @FXML
    private void handleTruckClicked3(MouseEvent event) {
        truckInventoryPane.setVisible(!truckInventoryPane.isVisible());
        truckInventoryGrid.setVisible(!truckInventoryGrid.isVisible());
    }

    @FXML
    private void handleTruckClicked4(MouseEvent event) {
        truckInventoryPane.setVisible(!truckInventoryPane.isVisible());
        truckInventoryGrid.setVisible(!truckInventoryGrid.isVisible());
    }

}
