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
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author marku
 */
public class Hut2Controller implements Initializable {
    
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
    ImageView field1_2;
    @FXML
    ImageView field5_5;
    @FXML
    ImageView field5_1;
    @FXML
    ImageView field6_1;
    @FXML
    ImageView field8_3;
    @FXML
    ImageView field10_4;


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
    INPC talkNPC;
    ImageView currentField;
    
    String yuranPath = "npc/Lady1 Mini.png";
    Image yuranMini = new Image(yuranPath);
    String yuranPathConvo = "npc/Lady 1 Mozambique.png";
    Image yuranConvo = new Image(yuranPathConvo);
    INPC Yuran;
    
    String riyadhPath = "npc/Man1 Mini.png";
    Image riyadhMini = new Image(riyadhPath);
    String riyadhPathConvo = "npc/Man 1 Mozambique.png";
    Image riyadhConvo = new Image(riyadhPathConvo);
    INPC Riyadh;
    
    String ganiPath = "npc/Lady2 Mini.png";
    Image ganiMini = new Image(ganiPath);
    String ganiPathConvo = "npc/Lady 2 Mozambique.png";
    Image ganiConvo = new Image(ganiPathConvo);
    INPC Gani;
    
    String abubakarPath = "npc/Man3 Mini.png";
    Image abubakarMini = new Image(abubakarPath);
    String abubakarPathConvo = "npc/Man 3 Mozambique.png";
    Image abubakarConvo = new Image(abubakarPathConvo);
    INPC Abubakar;
    
    //Backgrounds
    String hut2 = "backgrounds/Hut 2.jpg";
    Image toShow = new Image(hut2);


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
    ArrayList<ImageView> inventoryImageList;
    ArrayList<Rectangle> rectList;
    ArrayList<Tooltip> tts;
    Tooltip t0 = new Tooltip(null);
    Tooltip t1 = new Tooltip(null);
    Tooltip t2 = new Tooltip(null);
    Tooltip t3 = new Tooltip(null);
    Tooltip t4 = new Tooltip(null);
    Tooltip t5 = new Tooltip(null);
    Tooltip t6 = new Tooltip(null);
    Tooltip t7 = new Tooltip(null);
    
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
        
        //Setting the dialog buttons' text
        answer1.setText("More Symptoms");
        answer2.setText("Patient Healthy");
        answer3.setText("Leave");
        
        //Setting the NPCs into the room
        Yuran = da.getRoom().getNPC("Yuran");
        field8_3.setImage(yuranMini);
        if(Yuran.isAlive()==false){
            field8_3.setVisible(false);
        }
        
        
        Riyadh = da.getRoom().getNPC("Riyadh");
        field1_2.setImage(riyadhMini);
        if(Riyadh.isAlive()==false){
            field1_2.setVisible(false);
        }
        
        Gani = da.getRoom().getNPC("Gani");
        field10_4.setImage(ganiMini);
        if(Gani.isAlive()==false){
            field10_4.setVisible(false);
        }
        
        Abubakar = da.getRoom().getNPC("Abubakar");
        field5_5.setImage(abubakarMini);
        if(Abubakar.isAlive()==false){
            field5_5.setVisible(false);
        }
        
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

        //Fill items into map.
        itemImageMap = new HashMap<>()
        {{
            put("Clean Syringe", imgKanyleClean);
            put("Dirty Syringe", imgKanyleDirty);
            put("Condom", imgCondom);
            put("HIV Medication", imgHivMeds);
            put("Malaria Medication", imgMalariaMeds);
            put("Tuberculosis Medication", imgTbMeds);
            put("Pill", imgPill);
            put("Mask", imgMask);
            put("Mosquito Spray", imgSpray);
        }};

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
        
        //Make arraylist of rectangles to show background color of individual inventory slots
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
        
        //Installs each tooltip on the correctinventory slot and makes then show with no delay.
        for (int i = 0; i < tts.size(); i++) {
            Tooltip.install(inventoryImageList.get(i), tts.get(i));
            tts.get(i).setShowDelay(Duration.ZERO);
        }

        updatePoints();
        updateInventory();
    }
    
     /*
    THE ORDER OF THE HANDLERS IS AS FOLLOWS:
    1. NPCs
    2. Points
    3. Treat
    4. Give
    5. Inventory
    6. Close buttons
    7. Help Popup
    8. Handbook
    9. Exits
    */
    
    //HANDLERS FOR THE NPCs
    @FXML
    public void handleYuranClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Yuran;
        currentField = field8_3;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(yuranConvo);
        NPCNameLabel.setText(Yuran.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("Good to see you doctor! I feel very sick, I have a rash on my body\n"+
                               "and I think I have a fever. Can you please help me?");
        
            answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event){
                    NPCImage.setImage(null);
                    NPCNameLabel.setText(null);
                    dialogLabel.setText("You further examine " + talkNPC.getName() + " and discover that\n"+
                                        "they have a high fever, and are sweating profusely. Additionally\n"+
                                        "they report that they feel very winded when walking for long,\n"+
                                        "and the rash covers their entire back and genital area.");
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                }
            });
            
            //If the player decides to tell the PT that they're fine, the PT will die
            answer2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    dialogLabel.setText("I most certainly am not!\n"+
                                        "Will I now die because you are wrong?");
                
                    answer1.setText("More");
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    treatBtn.setVisible(false);
                    closeDialog.setVisible(false);
                
                    answer1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event){
                            answer1.setVisible(false);
                            NPCNameLabel.setText(null);
                            
                            talkNPC.kill();
                            talkNPC.setAlive(false);
                            
                            NPCImage.setImage(null);
                            System.out.println(talkNPC.getName() + " killed");
                            dialogLabel.setText(talkNPC.getName() + " has died.");
                        
                            field8_3.setVisible(false);
                            
                            closeDialog.setVisible(true);
                        }
                    });
                }
            });
            //this just prompts the player to know that he must come back
            answer3.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    treatBtn.setVisible(false);
                    
                    dialogLabel.setText("Please, come back soon and help me!");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("Thank you so much for helping me, I am very grateful!");
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    }
    
    @FXML
    public void handleRiyadhClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();

        talkNPC = Riyadh;
        currentField = field1_2;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(riyadhConvo);
        NPCNameLabel.setText(Riyadh.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("Hello, you must help me! I am very sick.");
        
            answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event){
                    NPCImage.setImage(null);
                    NPCNameLabel.setText(null);
                    dialogLabel.setText("You further examine " + talkNPC.getName() + " and discover that\n"+
                                        "they have a high fever, and are sweating profusely. They also report\n"+
                                        "nausea and vomiting, and several days of having diarrhea, and they\n"+
                                        "have small red lumps on their skin, looking like bug bites.");
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                }
            });
            
            //If the player decides to tell the PT that they're fine, the PT will die
            answer2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    dialogLabel.setText("I am not healthy, ''Doctor''. What is wrong with you?\n");
                
                    answer1.setText("More");
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    treatBtn.setVisible(false);
                    closeDialog.setVisible(false);
                
                    answer1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event){
                            answer1.setVisible(false);
                            NPCNameLabel.setText(null);
                            
                            talkNPC.kill();
                            talkNPC.setAlive(false);
                            
                            NPCImage.setImage(null);
                            System.out.println(talkNPC.getName() + " killed");
                            dialogLabel.setText(talkNPC.getName() + " has died.");
                        
                            field1_2.setVisible(false);
                            
                            closeDialog.setVisible(true);
                        }
                    });
                }
            });
            
            //this just prompts the player to know that he must come back
            answer3.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    treatBtn.setVisible(false);
                    
                    dialogLabel.setText("Please, help me...");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("Thank you for helping me, may the Gods smile upon you.");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    
    }
    
    @FXML
    public void handleGaniClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();

        talkNPC = Gani;
        currentField = field10_4;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(ganiConvo);
        NPCNameLabel.setText(Gani.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("Hello Doctor! I think I have infection, I heard that you get a\n"+
                                "fever from that. I also have itchy skin. It looks weird.");
        
            answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event){
                    NPCImage.setImage(null);
                    NPCNameLabel.setText(null);
                    dialogLabel.setText("You further examine " + talkNPC.getName() + " and discover that\n"+
                                        "they have a high fever, and are sweating profusely. They also report\n"+
                                        "nausea and vomiting, and several days of having diarrhea and they\n"+
                                        "have small red lumps on their skin, looking like bug bites.");
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                }
            });
            
            //If the player decides to tell the PT that they're fine, the PT will die
            answer2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    dialogLabel.setText("You will let me die because you are too proud to help me?\n");
                
                    answer1.setText("More");
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    treatBtn.setVisible(false);
                    closeDialog.setVisible(false);
                
                    answer1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event){
                            answer1.setVisible(false);
                            NPCNameLabel.setText(null);
                            
                            talkNPC.kill();
                            talkNPC.setAlive(false);
                            
                            NPCImage.setImage(null);
                            System.out.println(talkNPC.getName() + " killed");
                            dialogLabel.setText(talkNPC.getName() + " has died.");
                        
                            field10_4.setVisible(false);
                            
                            closeDialog.setVisible(true);
                        }
                    });
                }
            });
            //this just prompts the player to know that he must come back
            answer3.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    treatBtn.setVisible(false);
                    
                    dialogLabel.setText("Please, help me... I have kids...");
                    
                }
            });
        }
        //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("Thank you for helping me, I will name my next daughter after you.");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    
    }
    
    @FXML
    public void handleAbubakarClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();

        talkNPC = Abubakar;
        currentField = field5_5;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(abubakarConvo);
        NPCNameLabel.setText(Abubakar.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("Doctor... *cough* I think I am... very sick. My lungs... Feel weird\n");
        
            answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event){
                    NPCImage.setImage(null);
                    NPCNameLabel.setText(null);
                    dialogLabel.setText("You further examine " + talkNPC.getName() + " and discover that\n"+
                                        "they have a high fever, and they are very skinny. Listening to their\n"+
                                        "breathing through the stethoscope, you hear rattling sounds. They \n"+
                                        "are very clearly struggling to breathe.");
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                }
            });
            
            //If the player decides to tell the PT that they're fine, the PT will die
            answer2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    dialogLabel.setText("You... are evil... \n");
                
                    answer1.setText("More");
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    treatBtn.setVisible(false);
                    closeDialog.setVisible(false);
                
                    answer1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event){
                            answer1.setVisible(false);
                            NPCNameLabel.setText(null);
                            
                            talkNPC.kill();
                            talkNPC.setAlive(false);
                            
                            NPCImage.setImage(null);
                            System.out.println(talkNPC.getName() + " killed");
                            dialogLabel.setText(talkNPC.getName() + " has died.");
                        
                            field5_5.setVisible(false);
                            
                            closeDialog.setVisible(true);
                        }
                    });
                }
            });
            //this just prompts the player to know that he must come back
            answer3.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    treatBtn.setVisible(false);
                    
                    dialogLabel.setText("Please... Come back... *coughs*");
                    
                }
            });
        }
        //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("Thank you for helping me, hopefully I can return to work soon.");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    
    }
    
    /**
     * updates the label with the current points the player has obtained.
     */
    public void updatePoints() {
        pointLabel.setText(String.valueOf(da.getEvaluation().getPoints()));
    }
    
    /**
     * Method to handle what happens when the treat button has been pressed.
     * @param event 
     */
    @FXML
    private void handleTreat(MouseEvent event) {
        treatActive = true;
        
        //Disables give state
        giveActive = false;
        updateInventory(); //updates colors
        
        //Check if no syringe.
        if (!playerInventory.getKeys().contains("Clean Syringe") && !playerInventory.getKeys().contains("Dirty Syringe")) {
            dialogLabel.setText("You need a syringe to treat the patient.");
            treatActive = false;
        } 
        //If player has a syringe
        else {
            //Changes backgroundcolor of every medicineitem
            for (int i = 0; i < playerInventory.getValues().size(); i++) {
                if (playerInventory.getValues().get(i) instanceof IMedicineItem) {
                    rectList.get(i).setVisible(true);
                    rectList.get(i).setFill(Color.GREEN);
                }
            }
            
            //If player only has a used syringe
            if (!playerInventory.getKeys().contains("Clean Syringe") && playerInventory.getKeys().contains("Dirty Syringe"))
                dialogLabel.setText("You only have a used syringe, using it is not hygienic.");
        }
    }

    /**
     * Method to handle what happens when the give button has been pressed.
     * @param event 
     */
    @FXML
    private void handleGive(MouseEvent event) {
        giveActive = true;
        
        //Disables treat state
        treatActive = false;
        updateInventory();
        
        for (int i = 0; i < playerInventory.getValues().size(); i++) {
            if (playerInventory.getValues().get(i) instanceof IUtilityItem && playerInventory.getKeys().get(i) != "Clean Syringe" && playerInventory.getKeys().get(i) != "Dirty Syringe") {
                rectList.get(i).setVisible(true);
                rectList.get(i).setFill(Color.CORNFLOWERBLUE);
            }
        }
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

            //Clears highlighting rectancles by making them invisible.
            for (int i = 0; i < rectList.size(); i++) {
                rectList.get(i).setVisible(false);
            }
    }
    
    /**
     * Method to handle trashing and change color of the grid when trashing is active.
     * @param event 
     */
        @FXML
    private void handleTrash(MouseEvent event) {
        treatActive = false;
        giveActive = false;
        updateInventory();        
        
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
 
    /**
     * Method that handles what happens when an inventory slot is clicked.
     * The action changes depending on states for deleting items, giving items, and using items to treat patients.
     * @param i is the index in the list of inventory slots.
     */
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
                
                //Treats and stores result.
                boolean outcome = da.getRoom().getNPC(talkNPC.getName()).correctTreatment(tempItem, playerInventory.getKeys().contains("Clean Syringe"));
                
                //Changes dialogbox according to outcome.
                if (outcome) {
                    dialogLabel.setText("You have treated " + talkNPC.getName());
                    NPCNameLabel.setText(null);
                    NPCImage.setImage(null);
                    
                    treatBtn.setVisible(false);
                    
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                } 
                else {
                    dialogLabel.setText(talkNPC.getName() + " has died due to poor care.");
                    NPCNameLabel.setText(null);
                    NPCImage.setImage(null);
                    
                    currentField.setVisible(false);
                    treatBtn.setVisible(false);
                    talkNPC.setAlive(false);
                    
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    
                    System.out.println(talkNPC.getName()+" killed");
                }
                    
                //Remove item from inventory
                playerInventory.removeItem(playerInventory.getKeys().get(i));
                treatActive = false;
                
                //Changes syringe item if clean syringe was used.
                if (playerInventory.getKeys().contains("Clean Syringe")) {
                    playerInventory.removeItem("Clean Syringe");
                    playerInventory.addItem("Dirty Syringe", da.getDirtySyringe());
                }
            }
            else {
                treatActive = false; //stops you from "looking" for medicineitem.
            }
        }
        
        //Giving
        if (giveActive) { //If this slot contains utility item
            if (playerInventory.getValues().get(i) instanceof IUtilityItem && playerInventory.getKeys().get(i) != "Clean Syringe" && playerInventory.getKeys().get(i) != "Dirty Syringe") { 
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
        updatePoints();
        updateInventory(); 
    }
    
    //These next 8 handlers call the above method for the corrosponding index in the inventory list.
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
    
    //HANDLERS FOR THE CLOSE-BUTTONS
    @FXML
    public void handleCloseDialog(MouseEvent event) {
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        dialogPane.setVisible(false);
    }

    @FXML
    public void handleCloseHelp(MouseEvent event) {       
        helpPopup.setVisible(false);
    }
    
    //HANDLER FOR THE HELP PANE
    @FXML
    public void handleOpenHelpPane(MouseEvent event) {
        helpPopup.setVisible(true);
        helpLabel.setText("Your task is to cure as many citizens of Mozambique as you can, within the time\n"
                + "limit. You do this by clicking on them, and talking to them. There are several dialog\n"
                + "options, and some have more fatal consequences than others. Some actions cost time.\n"
                + "You earn points by treating patients correctly, and by giving them an item \n"
                + "that helps them prevent spreading their disease. When time is out, see how\n"
                + "many you have saved from their contracted disease!");

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
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        da.setRoom(da.getRoomMap().get("village"));
        App.setRoot("village");
    }
}
