/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.guisemesterprojekt1;

import Domain.DomainAdministration;
import Interfaces.IInventory;
import Interfaces.IMedicineItem;
import Interfaces.ITime;
import Interfaces.INPC;
import Interfaces.IUtilityItem;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marku
 */
public class Hut1Controller implements Initializable {

    DomainAdministration da;
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
    
    //NPCs
    String hendaPath = "npc/Lady1 Mini.png";
    Image hendaMini = new Image(hendaPath);
    String hendaPathConvo = "npc/Lady 1 Mozambique.png";
    Image hendaConvo = new Image(hendaPathConvo);
    INPC Henda;
    
    String kishorPath = "npc/Lady2 Mini.png";
    Image kishorMini = new Image(kishorPath);
    String kishorPathConvo = "npc/Lady 2 Mozambique.png";
    Image kishorConvo = new Image(kishorPathConvo);
    INPC Kishor;
    
    String neltonPath = "npc/Man1 Mini.png";
    Image neltonMini = new Image(neltonPath);
    String neltonPathConvo = "npc/Man 1 Mozambique.png";
    Image neltonConvo = new Image(neltonPathConvo);
    INPC Nelton;
    
    String momedPath = "npc/Man2 Mini.png";
    Image momedMini = new Image(momedPath);
    String momedPathConvo = "npc/Man 2 Mozambique.png";
    Image momedConvo = new Image(momedPathConvo);
    INPC Momed;
    
    String leonildoPath = "npc/Man3 Mini.png";
    Image leonildoMini = new Image(leonildoPath);
    String leonildoPathConvo = "npc/Man 3 Mozambique.png";
    Image leonildoConvo = new Image(leonildoPathConvo);
    INPC Leonildo;

    INPC talkNPC;
    
    //Backgrounds
    String hut1 = "backgrounds/Hut 1.jpg";
    Image toShow = new Image(hut1);

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
    ArrayList<ImageView> inventoryImageList;
    ArrayList<Rectangle> rectList;

    boolean trashingActive = false;
    boolean treatActive = false;
    boolean giveActive = false;
    
    @FXML
    private Label pointLabel;
    @FXML
    private Rectangle rect1;
    @FXML
    private Rectangle rect2;
    @FXML
    private Rectangle rect3;
    @FXML
    private Rectangle rect4;
    @FXML
    private Rectangle rect5;
    @FXML
    private Rectangle rect6;
    @FXML
    private Rectangle rect7;
    @FXML
    private Rectangle rect8;
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        da = App.getDomainAdministration();
        ITime time = (ITime)da.getTime();
        timeProgressBar.setProgress(time.getPercentTime());
        dialogPane.setVisible(false);
        helpPopup.setVisible(false);
        openHandbook.setVisible(true);

        //Setting the appearance of the Help, Book, Close and Trash button images
        trashBtn.setImage(trashButton);

        helpBtn.setImage(helpButton);

        closeDialog.setImage(closeButton);
        closeHelp.setImage(closeButton);

        openHandbook.setImage(handbookButton);

        //Setting the background image
        backgroundImage.setImage(toShow);
        
        //Setting the NPCs
        Henda = da.getRoom().getNPC("Henda");
        Kishor = da.getRoom().getNPC("Kishor");
        Nelton = da.getRoom().getNPC("Nelton");
        Momed = da.getRoom().getNPC("Momed");
        Leonildo = da.getRoom().getNPC("Leonildo");
        
        //Get roominventory
        roomInventory = da.getRoom().getItems();

        //Get playerinventory
        playerInventory = da.getInventory();

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
        
        rectList = new ArrayList<>() {
            {
            add(rect1);
            add(rect2);
            add(rect3);
            add(rect4);
            add(rect5);
            add(rect6);
            add(rect7);
            add(rect8);
            }
        };

        updateInventory();
    }

    //HANDLERS FOR THE INVENTORY
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

            if (!treatActive) {
                    for (int i = 0; i < rectList.size(); i++) {
                            rectList.get(i).setVisible(false);
                    }
            }

            if (!giveActive) {
                    for (int i = 0; i < rectList.size(); i++) {
                            rectList.get(i).setVisible(false);
                    }
            }        
    }

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

    @FXML
    public void handleExitEvent(MouseEvent event) throws IOException {
        da.setRoom(da.getRoomMap().get("village"));
        App.setRoot("village");
    }

    @FXML
    private void handleTrash(MouseEvent event) {
            //Change trashing state
            trashingActive = !trashingActive;

            //Updates state of treatment and give item
            treatActive = false;
            giveActive = false;
            updateInventory(); //updates colors

            if (trashingActive)
                    inventoryGrid.setStyle("-fx-background-color:#ff8f87"); //Red
            else
                    inventoryGrid.setStyle("-fx-background-color:#ffffff"); //White
    }

    @FXML
    private void handleTreat(MouseEvent event) {
            treatActive = true;

            //Disables give state
            giveActive = false;
            updateInventory(); //updates colors

            for (int i = 0; i < playerInventory.getValues().size(); i++) {
                    if (playerInventory.getValues().get(i) instanceof IMedicineItem) {
                            rectList.get(i).setVisible(true);
                            rectList.get(i).setFill(Color.GREEN);
                    }
            }
    }

    @FXML
    private void handleGive(MouseEvent event) {
            giveActive = true;

            //Disables treat state
            treatActive = false;
            updateInventory();

            for (int i = 0; i < playerInventory.getValues().size(); i++) {
                    if (playerInventory.getValues().get(i) instanceof IUtilityItem) {
                            rectList.get(i).setVisible(true);
                            rectList.get(i).setFill(Color.CORNFLOWERBLUE);
                    }
            }
    }

    private void inventorySlotClicked(int i) {
        //Trashing
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(i));
        } 
        
        //Treatment
        if (treatActive) {
            if (playerInventory.getValues().get(i) instanceof IMedicineItem) { //If this slot contains medicine item
                //Makes temporary item from slot in inventory
                IMedicineItem tempItem = (IMedicineItem) playerInventory.getValues().get(i);
                
                //Tries to treat patient with this item.
                da.getRoom().getNPC(talkNPC.getName()).correctTreatment(tempItem);

                //If treatment was correct
                if (talkNPC.isAlive()) {
                    dialogLabel.setText("You have treated " + talkNPC.getName());
                    NPCNameLabel.setText(null);
                    treatBtn.setVisible(false);
                }
                    
                //Remove item from inventory
                playerInventory.removeItem(playerInventory.getKeys().get(i));
                treatActive = false;
            }
            else {
                treatActive = false; //stops you from "looking" for medicineitem.
            }
        }
        
        //Giving
        if (giveActive) {
            if (playerInventory.getValues().get(i) instanceof IUtilityItem) { //If this slot contains utility item
                //Makes temporary item from slot in inventory
                IUtilityItem tempItem = (IUtilityItem) playerInventory.getValues().get(i);
                
                //Gives item to NPC.
                da.getRoom().getNPC(talkNPC.getName()).correctItem(tempItem);
                dialogLabel.setText("You gave '" + playerInventory.getKeys().get(i) + "' to " + talkNPC.getName());
                
                //Delete item from inventory
                playerInventory.removeItem(playerInventory.getKeys().get(i));
                giveActive = false;
            }
            else {
                giveActive = false; //stops you from "looking" for utilityitem.
            }
        }        
        
        updateInventory(); 
    }
    

    @FXML
    private void handleInventorySlotClicked1(MouseEvent event) {
        inventorySlotClicked(0);
    }

    
    @FXML
    private void handleInventorySlotClicked2(MouseEvent event) {
        inventorySlotClicked(1);
    }

    @FXML
    private void handleInventorySlotClicked3(MouseEvent event) {
        inventorySlotClicked(2);
    }

    @FXML
    private void handleInventorySlotClicked4(MouseEvent event) {
        inventorySlotClicked(3);
    }

    @FXML
    private void handleInventorySlotClicked5(MouseEvent event) {
        inventorySlotClicked(4);
    }
    
    @FXML
    private void handleInventorySlotClicked6(MouseEvent event) {
        inventorySlotClicked(5);
    }

    @FXML
    private void handleInventorySlotClicked7(MouseEvent event) {
        inventorySlotClicked(6);
    }

    @FXML
    private void handleInventorySlotClicked8(MouseEvent event) {
        inventorySlotClicked(7);
    }
}
