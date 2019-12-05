/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.guisemesterprojekt1;

import Domain.DomainAdministration;
import Domain.Item;
import Interfaces.IInventory;
import Interfaces.IItem;
import Interfaces.ITime;
import Interfaces.IUtilityItem;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
public class MedHqController implements Initializable {

    //Setting the Time Indicator
    @FXML
    ProgressBar timeProgressBar;
    @FXML
    ProgressBar truckLoadBar;

    //Setting the GridPane
    @FXML
    GridPane inventoryGrid;
    @FXML
    GridPane gameGrid;
    @FXML
    GridPane dialogOptionsGrid;
    @FXML
    GridPane truckInventoryGrid;

    //Setting the AnchorPane
    @FXML
    AnchorPane dialogPane;
    @FXML
    AnchorPane helpPopup;
    @FXML
    AnchorPane truckInventoryPane;

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
    @FXML
    Label truckInventoryView;

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
    ImageView closeTruckInventory;
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

    @FXML
    ImageView tck0;
    @FXML
    ImageView tck1;
    @FXML
    ImageView tck2;
    @FXML
    ImageView tck3;
    @FXML
    ImageView tck4;
    @FXML
    ImageView tck5;
    @FXML
    ImageView tck6;
    @FXML
    ImageView tck7;
    @FXML
    ImageView tck8;
    @FXML
    ImageView tck9;
    @FXML
    ImageView tck10;
    @FXML
    ImageView tck11;
    @FXML
    ImageView tck12;
    @FXML
    ImageView tck13;
    @FXML
    ImageView tck14;
    @FXML
    ImageView tck15;
    @FXML
    ImageView tck16;
    @FXML
    ImageView tck17;
    @FXML
    ImageView tck18;
    @FXML
    ImageView tck19;
    @FXML
    ImageView tck20;
    @FXML
    ImageView tck21;
    @FXML
    ImageView tck22;
    @FXML
    ImageView tck23;
    @FXML
    ImageView tck24;
    @FXML
    ImageView tck25;
    @FXML
    ImageView tck26;
    @FXML
    ImageView tck27;
    @FXML
    ImageView tck28;
    @FXML
    ImageView tck29;
    @FXML
    ImageView tck30;
    @FXML
    ImageView tck31;
    @FXML
    ImageView tck32;
    @FXML
    ImageView tck33;
    @FXML
    ImageView tck34;
    @FXML
    ImageView tck35;
    @FXML
    ImageView tck36;
    @FXML
    ImageView tck37;
    @FXML
    ImageView tck38;
    @FXML
    ImageView tck39;

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

    //NPCs
    String mariaPath = "npc/Maria Mini.png";
    Image mariaMini = new Image(mariaPath);
    String mariaPathConvo = "convosprite/Maria.png";
    Image mariaConvo = new Image(mariaPathConvo);

    //Backgrounds
    String nextRoom = "backgrounds/HQ Medicine Room.png";
    Image medHQ = new Image(nextRoom);

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

    DomainAdministration da;
    IInventory playerInventory;
    IInventory truckInventory;
    IInventory roomInventory;
    ArrayList<ImageView> inventoryImageList;
    // init truckInventoryImageList
    ArrayList<ImageView> truckInventoryImageList;

    boolean trashingActive = false;

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
        percentageTimeBar = time.getPercentTime();
        timeProgressBar.setProgress(percentageTimeBar);
        //init truckload bar to 0
        truckLoadBar.setProgress(0.0);
        dialogPane.setVisible(false);
        helpPopup.setVisible(false);
        openHandbook.setVisible(true);
        truckInventoryPane.setVisible(false);

        //Setting the appearance of the Help, Book, Close and Trash button images
        trashBtn.setImage(trashButton);

        helpBtn.setImage(helpButton);

        closeDialog.setImage(closeButton);
        closeHelp.setImage(closeButton);
        closeTruckInventory.setImage(closeButton);

        openHandbook.setImage(handbookButton);

        //Setting the background image
        backgroundImage.setImage(medHQ);

        //Initialising Maria's Sprite
        field0_5.setImage(mariaMini);

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
        updateInventory();
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
        updateTruckInventory();

    }

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
    public void updateTruckLoadBar(){
        truckLoadBar.setProgress(truckInventory.calcPctUsed());
        System.out.println(truckInventory.calcPctUsed());
        if(truckInventory.calcPctUsed() >= 0.50 && truckInventory.calcPctUsed() < 1.0){
            truckLoadBar.setStyle("-fx-accent: yellow;");
        }
        else if(truckInventory.calcPctUsed()==1.0){
            truckLoadBar.setStyle("-fx-accent: red;");
        }
    }

    public void handleMariaClicked(MouseEvent event) {
        dialogPane.setVisible(!dialogPane.isVisible());
        answer2.setVisible(false);
        treatBtn.setVisible(false);
        giveItemBtn.setVisible(false);

        NPCNameLabel.setText("Maria Hoffmann");
        NPCImage.setImage(mariaConvo);

        dialogLabel.setText("Are you ready to leave for Mozambique?\n"
                + "(Did you finish packing the truck? You cannot return once left.)");

        answer1.setText("Ready");
        answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    da.setRoom(da.getRoomMap().get("village"));
                    App.setRoot("village");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        answer3.setText("Not yet");
        answer3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dialogPane.setVisible(false);
            }
        });
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

    public void handleTruckClicked(MouseEvent event) {
        truckInventoryPane.setVisible(!truckInventoryPane.isVisible());
    }

    public void handleTruckInventoryClose(MouseEvent event) {
        truckInventoryPane.setVisible(false);
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

    public void handleMasksClicked(MouseEvent event) {
        int tempIndex = roomInventory.getKeys().indexOf("Mask");
        truckInventory.addItem(roomInventory.getKeys().get(tempIndex), roomInventory.getValues().get(tempIndex));
        updateTruckLoadBar();
        updateTruckInventory();
    }

    public void handleCondomsClicked(MouseEvent event) {
        int tempIndex = roomInventory.getKeys().indexOf("Condom");
        truckInventory.addItem(roomInventory.getKeys().get(tempIndex), roomInventory.getValues().get(tempIndex));
        updateTruckLoadBar();
        updateTruckInventory();
    }

    public void handleMosquitoSprayClicked(MouseEvent event) {
        int tempIndex = roomInventory.getKeys().indexOf("Mosquito Spray");
        truckInventory.addItem(roomInventory.getKeys().get(tempIndex), roomInventory.getValues().get(tempIndex));
        updateTruckLoadBar();
        updateTruckInventory();
    }

    public void handleSyringesClicked(MouseEvent event) {
        System.out.println(da.getRoom().getItems().getKeys().size());
        int tempIndex = roomInventory.getKeys().indexOf("Clean Syringe");
        System.out.println(tempIndex);
        truckInventory.addItem(roomInventory.getKeys().get(tempIndex), roomInventory.getValues().get(tempIndex));
        updateTruckLoadBar();
        updateTruckInventory();
    }

    public void handleHIVClicked(MouseEvent event) {
        int tempIndex = roomInventory.getKeys().indexOf("HIV Medication");
        truckInventory.addItem(roomInventory.getKeys().get(tempIndex), roomInventory.getValues().get(tempIndex));
        updateTruckLoadBar();
        updateTruckInventory();
    }

    public void handleMalariaClicked(MouseEvent event) {
        int tempIndex = roomInventory.getKeys().indexOf("Malaria Medication");
        truckInventory.addItem(roomInventory.getKeys().get(tempIndex), roomInventory.getValues().get(tempIndex));
        updateTruckLoadBar();
        updateTruckInventory();
        
    }

    public void handleTBClicked(MouseEvent event) {
        int tempIndex = roomInventory.getKeys().indexOf("Tuberculosis Medication");
        truckInventory.addItem(roomInventory.getKeys().get(tempIndex), roomInventory.getValues().get(tempIndex));
        updateTruckLoadBar();
        updateTruckInventory();

        /* just for debugging
        for (String string : truckInventory.getKeys()) {
            System.out.println(string);

        }
        */
    }
}
