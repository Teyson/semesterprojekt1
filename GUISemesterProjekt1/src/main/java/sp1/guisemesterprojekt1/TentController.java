/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.guisemesterprojekt1;

import Domain.DomainAdministration;
import Interfaces.IInventory;
import Interfaces.INPC;
import Interfaces.ITime;
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
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    @FXML
    ImageView dirtySyringeView;
    @FXML
    ImageView cleanSyringeView;

    //Setting the Grid ImageViews
    @FXML
    ImageView field5_1;
    @FXML
    ImageView field8_2;
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
    
    //NPCs followed by that NPCs conversation image
    String mariaImage = "npc/Maria Mini.png";
    Image mariaMini = new Image(mariaImage);
    String mariaConvo = "convosprite/Maria.png";
    Image mariaTalk = new Image(mariaConvo);
    INPC Maria;

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

    IInventory playerInventory;
    IInventory roomInventory;
    IInventory truckInventory;
    ArrayList<ImageView> inventoryImageList;
    ArrayList<ImageView> truckInventoryImageList;
    ArrayList<Tooltip> tts;
    ArrayList<Tooltip> truckTts;
    Tooltip t0 = new Tooltip(null);
    Tooltip t1 = new Tooltip(null);
    Tooltip t2 = new Tooltip(null);
    Tooltip t3 = new Tooltip(null);
    Tooltip t4 = new Tooltip(null);
    Tooltip t5 = new Tooltip(null);
    Tooltip t6 = new Tooltip(null);
    Tooltip t7 = new Tooltip(null);
    Tooltip tt0 = new Tooltip(null);
    Tooltip tt1 = new Tooltip(null);
    Tooltip tt2 = new Tooltip(null);
    Tooltip tt3 = new Tooltip(null);
    Tooltip tt4 = new Tooltip(null);
    Tooltip tt5 = new Tooltip(null);
    Tooltip tt6 = new Tooltip(null);
    Tooltip tt7 = new Tooltip(null);
    Tooltip tt8 = new Tooltip(null);
    Tooltip tt9 = new Tooltip(null);
    Tooltip tt10 = new Tooltip(null);
    Tooltip tt11 = new Tooltip(null);
    Tooltip tt12 = new Tooltip(null);
    Tooltip tt13 = new Tooltip(null);
    Tooltip tt14 = new Tooltip(null);
    Tooltip tt15 = new Tooltip(null);
    Tooltip tt16 = new Tooltip(null);
    Tooltip tt17 = new Tooltip(null);
    Tooltip tt18 = new Tooltip(null);
    Tooltip tt19 = new Tooltip(null);
    Tooltip tt20 = new Tooltip(null);
    Tooltip tt21 = new Tooltip(null);
    Tooltip tt22 = new Tooltip(null);
    Tooltip tt23 = new Tooltip(null);
    Tooltip tt24 = new Tooltip(null);
    Tooltip tt25 = new Tooltip(null);
    Tooltip tt26 = new Tooltip(null);
    Tooltip tt27 = new Tooltip(null);
    Tooltip tt28 = new Tooltip(null);
    Tooltip tt29 = new Tooltip(null);
    Tooltip tt30 = new Tooltip(null);
    Tooltip tt31 = new Tooltip(null);
    Tooltip tt32 = new Tooltip(null);
    Tooltip tt33 = new Tooltip(null);
    Tooltip tt34 = new Tooltip(null);
    Tooltip tt35 = new Tooltip(null);
    Tooltip tt36 = new Tooltip(null);
    Tooltip tt37 = new Tooltip(null);
    Tooltip tt38 = new Tooltip(null);
    Tooltip tt39 = new Tooltip(null);
    

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
        closeTruckInventory.setImage(closeButton);

        openHandbook.setImage(handbookButton);
        
        //Setting the NPC Image
        field8_2.setImage(mariaMini);
        
        //Setting the NPCs
        Maria = da.getRoom().getNPC("Maria Hoffmann");

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
        
        //Fill tooltip list with tooltips for each slot in inventory.
        tts = new ArrayList<>() {
            {
                add(t0);
                add(t1);
                add(t2);
                add(t3);
                add(t4);
                add(t5);
                add(t6);
                add(t7);
            }
        };
        
        //Installs each tooltip on the correct inventory slot and makes then show with no delay.
        for (int i = 0; i < tts.size(); i++) {
            Tooltip.install(inventoryImageList.get(i), tts.get(i));
            tts.get(i).setShowDelay(Duration.ZERO);
        }
        
        //Fill tooltip for truckinventory list.
        truckTts = new ArrayList<>() {
            {
                add(tt0);
                add(tt1);
                add(tt2);
                add(tt3);
                add(tt4);
                add(tt5);
                add(tt6);
                add(tt7);
                add(tt8);
                add(tt9);
                add(tt10);
                add(tt11);
                add(tt12);
                add(tt13);
                add(tt14);
                add(tt15);
                add(tt16);
                add(tt17);
                add(tt18);
                add(tt19);
                add(tt20);
                add(tt21);
                add(tt22);
                add(tt23);
                add(tt24);
                add(tt25);
                add(tt26);
                add(tt27);
                add(tt28);
                add(tt29);
                add(tt30);
                add(tt31);
                add(tt32);
                add(tt33);
                add(tt34);
                add(tt35);
                add(tt36);
                add(tt37);
                add(tt38);
                add(tt39);
            }
        };
        
        //Installs each tooltip on the correct inventory slot and makes then show with no delay.
        for (int i = 0; i < truckTts.size(); i++) {
            Tooltip.install(truckInventoryImageList.get(i), truckTts.get(i));
            truckTts.get(i).setShowDelay(Duration.ZERO);
        }
        
        updatePoints();
        updateInventory();
        updateTruckInventory();
    }

    /*
    THE ORDER OF THE HANDLERS IS AS FOLLOWS:
    1. NPCs
    2. Points
    3. Inventory
    4. Truck
    5. Close buttons
    6. Help Popup
    7. Truck Inventory Slots
    8. Handbook
    9. Exits
    */
    
    //HANDLER FOR MARIA
    public void handleMariaClicked(MouseEvent event){
        INPC talkNPC = Maria;

        dialogPane.setVisible(!dialogPane.isVisible());
        answer2.setVisible(false);
        answer3.setVisible(false);
        treatBtn.setVisible(false);
        giveItemBtn.setVisible(false);

        //Initialising Maria's conversation image
        NPCImage.setImage(mariaTalk);

        //Renaming the Dialog window for Maria
        NPCNameLabel.setText(Maria.getName());

        dialogLabel.setText("Did you remember to grab all the clean syringes you need?\n"+
                            "If you use a used syringe on a new patient, they might get\n"+
                            "even more sick, or even die! Remember good hygiene when treating\n"+
                            "your patients.");
        
        answer1.setText("More");
        answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                answer1.setVisible(false);
                
                dialogLabel.setText("They look like this:\n"+
                                    "Left is clean, right is dirty.");
                cleanSyringeView.setImage(imgKanyleClean);
                dirtySyringeView.setImage(imgKanyleDirty); 
            }
        
        });
    }
    
    /**
     * updates the label with the current points the player has obtained.
     */
    public void updatePoints() {
        pointLabel.setText(String.valueOf(da.getEvaluation().getPoints()));
    }

    /**
     * Method to update the inventory 
     */
    public void updateInventory() {
        //Clears inventory
        for (int i = 0; i < inventoryImageList.size(); i++) {
            inventoryImageList.get(i).setVisible(false);
        }

        //Inserts items
        for (int j = 0; j < playerInventory.getKeys().size(); j++) {
            inventoryImageList.get(j).setImage(itemImageMap.get(playerInventory.getKeys().get(j)));
            inventoryImageList.get(j).setVisible(true);
            
            //Sets correct tooltip
            tts.get(j).setText(playerInventory.getValues().get(j).getName());
        }
    }
    
    /**
     * Method to handle trashing and change color of the grid when trashing is active.
     * @param event 
     */
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
    private void moveItemFromPlayerToTruck(int i){
        if(truckInventoryPane.isVisible() && truckInventory.getSpaceUsed() < truckInventory.getInventorySize()){
            String itemName = playerInventory.getKeys().get(i);
            truckInventory.addItem(itemName, playerInventory.getValues().get(i));
            playerInventory.removeItem(itemName);
            updateInventory();
            updateTruckInventory();
        }
    }

    //These next 8 methods are used to trash the correct item when the specific slot is pressed.    
    @FXML
    private void handleInventorySlotClicked1(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(0));
            updateInventory();
            
        }
        moveItemFromPlayerToTruck(0);
    }

    @FXML
    private void handleInventorySlotClicked2(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(1));
            updateInventory();
        }
        moveItemFromPlayerToTruck(1);
    }

    @FXML
    private void handleInventorySlotClicked3(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(2));
            updateInventory();
        }
        moveItemFromPlayerToTruck(2);
    }

    @FXML
    private void handleInventorySlotClicked4(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(3));
            updateInventory();
        }
        moveItemFromPlayerToTruck(3);
    }

    @FXML
    private void handleInventorySlotClicked5(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(4));
            updateInventory();
        }
        moveItemFromPlayerToTruck(4);
    }

    @FXML
    private void handleInventorySlotClicked6(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(5));
            updateInventory();
        }
        moveItemFromPlayerToTruck(5);
    }

    @FXML
    private void handleInventorySlotClicked7(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(6));
            updateInventory();
        }
        moveItemFromPlayerToTruck(6);
    }

    @FXML
    private void handleInventorySlotClicked8(MouseEvent event) {
        if (trashingActive) {
            playerInventory.removeItem(playerInventory.getKeys().get(7));
            updateInventory();
        }
        moveItemFromPlayerToTruck(7);
    }

    //HANDLERS FOR THE TRUCK
    public void updateTruckInventory() {
        //Clears inventory
        for (int i = 0; i < truckInventoryImageList.size(); i++) {
            truckInventoryImageList.get(i).setVisible(false);
        }
        
        //Inserts items
        for (int j = 0; j < truckInventory.getKeys().size(); j++) {
            truckInventoryImageList.get(j).setImage(itemImageMap.get(truckInventory.getKeys().get(j)));
            truckInventoryImageList.get(j).setVisible(true);
            truckTts.get(j).setText(truckInventory.getValues().get(j).getName()); //Updates tooltip
        }
    }
    
    @FXML
    private void handleTruckClicked(MouseEvent event) {
        truckInventoryPane.setVisible(!truckInventoryPane.isVisible());
        truckInventoryGrid.setVisible(!truckInventoryGrid.isVisible());
        
    }
    
    public void removeTruckInventoryOnClicked(int i) {
        truckInventory.removeItem(truckInventory.getKeys().get(i));
        updateTruckInventory();
    }
    
    public void pickUpItemToPlayerInventory(int i) {
        String itemName = truckInventory.getKeys().get(i);
        //Add condition if playerInventory is full
        if (playerInventory.getSpaceUsed() < playerInventory.getInventorySize()) {
            playerInventory.addItem(itemName, truckInventory.getValues().get(truckInventory.getKeys().indexOf(itemName)));
            truckInventory.removeItem(truckInventory.getKeys().get(i));
            updateTruckInventory();
            updateInventory();
        }

    }

    //HANDLERS FOR THE CLOSE-BUTTONS
    @FXML
    public void handleCloseDialog(MouseEvent event) {
        dialogPane.setVisible(false);
    }
    
    @FXML
    public void handleCloseHelp(MouseEvent event) {
        helpPopup.setVisible(false);
    }
    
    @FXML
    private void handleTruckInventoryClose(MouseEvent event) {
        truckInventoryPane.setVisible(false);
        truckInventoryGrid.setVisible(false);
    }

    //HANDLER FOR THE HELP PANE
    @FXML
    public void handleOpenHelpPane(MouseEvent event) {
        helpPopup.setVisible(true);
        helpLabel.setText("Grab the things from the truck that you packed in the HQ.\n"+
                          "You do this by clicking the truck, and then the items that you want\n"+
                          "to bring with you now. You can also deposit things from your inventory\n"+
                          "into the truck.");

    }
    
    //HANDLERS FOR THE TRUCK INVENTORY SLOTS
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

    //HANDLER FOR THE HANDBOOK
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

    //HANDLER FOR THE EXIT
    @FXML
    public void handleExitEvent(MouseEvent event) throws IOException {
        da.setRoom(da.getRoomMap().get("village"));
        App.setRoot("village");
    }
}
