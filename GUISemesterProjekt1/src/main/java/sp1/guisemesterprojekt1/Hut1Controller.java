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

    //Setting the Button ImageViews
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
    ImageView field2_1;
    @FXML
    ImageView field2_2;
    @FXML
    ImageView field2_3;
    @FXML
    ImageView field5_1;
    @FXML
    ImageView field5_5;
    @FXML
    ImageView field6_1;
    @FXML
    ImageView field6_5;
    @FXML
    ImageView field9_2;
    @FXML
    ImageView field10_6;

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
    ImageView currentField;
    
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

        //Setting the appearance of the Help, Book, Close and Trash button images
        trashBtn.setImage(trashButton);

        helpBtn.setImage(helpButton);

        closeDialog.setImage(closeButton);
        closeHelp.setImage(closeButton);

        openHandbook.setImage(handbookButton);
        
        //Setting the dialog buttons' text
        answer1.setText("More Symptoms");
        answer2.setText("Patient Healthy");
        answer3.setText("Leave");
        
        //Setting the NPC Mini Images
        field2_3.setImage(hendaMini);
        field5_5.setImage(neltonMini);
        field6_5.setImage(kishorMini);
        field9_2.setImage(momedMini);
        field10_6.setImage(leonildoMini);

        //Setting the background image
        backgroundImage.setImage(toShow);
        
        //Setting the NPCs
        Henda = da.getRoom().getNPC("Henda");
        if(Henda.isAlive()==false){
            field2_3.setVisible(false);
        }
        
        Kishor = da.getRoom().getNPC("Kishor");
        if(Kishor.isAlive()==false){
            field6_5.setVisible(false);
        }
        
        Nelton = da.getRoom().getNPC("Nelton");
        if(Nelton.isAlive()==false){
            field5_5.setVisible(false);
        }
        
        Momed = da.getRoom().getNPC("Momed");
        if(Momed.isAlive()==false){
            field9_2.setVisible(false);
        }
        
        Leonildo = da.getRoom().getNPC("Leonildo");
        if(Leonildo.isAlive()==false){
            field10_6.setVisible(false);
        }
        
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
    public void handleHendaClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Henda;
        currentField = field2_3;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(hendaConvo);
        NPCNameLabel.setText(Henda.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("You are doctor? You are here to help me?\n"+
                                "Please look at my rash, it is very big and itchy.");
        
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
                    dialogLabel.setText("Are you crazy?!");
                
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
                        
                            field2_3.setVisible(false);
                            
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
                    
                    dialogLabel.setText("Please... Help me...");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("Thank you, thank you, thank you!");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    }
    
    public void handleKishorClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Kishor;
        currentField = field6_5;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(kishorConvo);
        NPCNameLabel.setText(Kishor.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("Doctor! You must help! I am very sick, I am so warm...");
        
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
                    dialogLabel.setText("You must be a fake doctor. You want to kill me?!");
                
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
                        
                            field6_5.setVisible(false);
                            
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
                    
                    dialogLabel.setText("Please... I AM sick...");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("I am very very grateful for your work, thank you");
            
            giveItemBtn.setVisible(true);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
            treatBtn.setVisible(false);
        }
    }
    
    public void handleNeltonClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Nelton;
        currentField = field5_5;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(neltonConvo);
        NPCNameLabel.setText(Nelton.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("*cough*");
        
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
                    dialogLabel.setText("*cough* you are the devil...");
                
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
                    
                    dialogLabel.setText("Please *cough* my body is dying...");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("The air feels so good in my lungs now, thank you!");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    }
    
    public void handleMomedClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Momed;
        currentField = field9_2;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(momedConvo);
        NPCNameLabel.setText(Momed.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("Doctor, my wife says I keep her awake all night\n"+
                                "with my coughing. Can you help?");
        
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
                    dialogLabel.setText("My wife will come after you, ''Doctor'");
                
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
                        
                            field9_2.setVisible(false);
                            
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
                    
                    dialogLabel.setText("I beg you, my wife is so angry because she can't sleep."+
                                        "Help me, please...");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("Thank you so much for helping me, now my wife will be happy.");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    }
    
    public void handleLeonildoClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Leonildo;
        currentField = field10_6;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(leonildoConvo);
        NPCNameLabel.setText(Leonildo.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("Good doctor, you must help. My stomach is very painful,\n"+
                                "and my... toilet visits are very unpleasant...");
        
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
                    dialogLabel.setText("How can you not care about others? Are you that selfish?");
                
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
                        
                            field10_6.setVisible(false);
                        
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
                    
                    dialogLabel.setText("Are you coming back with more medicine?");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("Thank you so much, now I can feel better soon.");
            
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
                    currentField.setVisible(false);
                    NPCNameLabel.setText(null);
                    NPCImage.setImage(null);
                    talkNPC.setAlive(false);
                    
                    treatBtn.setVisible(false);
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
    
    /**
     * Method to handle trashing and change color of the grid when trashing is active.
     * @param event 
     */
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
    public void handleCloseDialog(MouseEvent event) {
        treatActive = false;
        giveActive = false;
        updateInventory();
        dialogPane.setVisible(false);
    }
    
    public void handleCloseHelp(MouseEvent event) {
        helpPopup.setVisible(false);
    }

    //HANDLERS FOR THE HELP PANES
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
    public void handleExitEvent(MouseEvent event) throws IOException {
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        da.setRoom(da.getRoomMap().get("village"));
        App.setRoot("village");
    }

}
