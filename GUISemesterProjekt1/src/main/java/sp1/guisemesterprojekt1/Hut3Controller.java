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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Hut3Controller implements Initializable {
    
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
    ImageView field1_5;
    @FXML
    ImageView field2_2;
    @FXML
    ImageView field4_4;
    @FXML
    ImageView field5_1;
    @FXML
    ImageView field6_1;
    @FXML
    ImageView field8_3;
    @FXML
    ImageView field9_4;
    @FXML
    ImageView field10_2;

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
    String hut3 = "backgrounds/hut 3.jpg";
    Image toShow = new Image(hut3);
    
    //NPCs
    INPC talkNPC;
    ImageView currentField;
    
    String kiriPath = "npc/Lady1 Mini.png";
    Image kiriMini = new Image(kiriPath);
    String kiriPathConvo = "npc/Lady 1 Mozambique.png";
    Image kiriConvo = new Image(kiriPathConvo);
    INPC Kiri;
    
    String ikbalPath = "npc/Lady2 Mini.png";
    Image ikbalMini = new Image(ikbalPath);
    String ikbalPathConvo = "npc/Lady 2 Mozambique.png";
    Image ikbalConvo = new Image(ikbalPathConvo);
    INPC Ikbal;
    
    String jojoPath = "npc/Lady3 Mini.png";
    Image jojoMini = new Image(jojoPath);
    String jojoPathConvo = "npc/Lady 3 Mozambique.png";
    Image jojoConvo = new Image(jojoPathConvo);
    INPC Jojo;
    
    String braytonPath = "npc/Man1 Mini.png";
    Image braytonMini = new Image(braytonPath);
    String braytonPathConvo = "npc/Man 1 Mozambique.png";
    Image braytonConvo = new Image(braytonPathConvo);
    INPC Brayton;
    
    String kelvenPath = "npc/Man2 Mini.png";
    Image kelvenMini = new Image(kelvenPath);
    String kelvenPathConvo = "npc/Man 2 Mozambique.png";
    Image kelvenConvo = new Image(kelvenPathConvo);
    INPC Kelven;
    
    String faizalPath = "npc/Man3 Mini.png";
    Image faizalMini = new Image(faizalPath);
    String faizalPathConvo = "npc/Man 3 Mozambique.png";
    Image faizalConvo = new Image(faizalPathConvo);
    INPC Faizal;

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
    @FXML
    private ImageView field4_5;
    @FXML
    private ImageView field6_11;
    
    
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
        field1_5.setImage(faizalMini);
        field2_2.setImage(kelvenMini);
        field4_5.setImage(jojoMini);
        field8_3.setImage(kiriMini);
        field9_4.setImage(ikbalMini);
        field10_2.setImage(braytonMini);

        //Setting the background image
        backgroundImage.setImage(toShow);
        
        //Setting the NPCs
        Kiri = da.getRoom().getNPC("Kiri");
        if(Kiri.isAlive()==false){
            field8_3.setVisible(false);
        }
        
        Ikbal = da.getRoom().getNPC("Ikbal");
        if(Ikbal.isAlive()==false){
            field9_4.setVisible(false);
        }
        
        Jojo = da.getRoom().getNPC("Jojo");
        if(Jojo.isAlive()==false){
            field4_5.setVisible(false);
        }
        
        Brayton = da.getRoom().getNPC("Brayton");
        if(Brayton.isAlive()==false){
            field10_2.setVisible(false);
        }
        
        Kelven = da.getRoom().getNPC("Kelven");
        if(Kelven.isAlive()==false){
            field2_2.setVisible(false);
        }
        
        Faizal = da.getRoom().getNPC("Faizal");
        if(Faizal.isAlive()==false){
            field1_5.setVisible(false);
        }
        
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
        updatePoints();
        updateInventory();
    }

    public void updatePoints() {
        pointLabel.setText(String.valueOf(da.getEvaluation().getPoints()));
    }
    
    //HANDLERS FOR THE NPCs
    @FXML
    public void handleKiriClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Kiri;
        currentField = field8_3;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(kiriConvo);
        NPCNameLabel.setText(Kiri.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("Doctor... *cough* I feel not so good...");
        
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
                    
                    treatBtn.setVisible(true);
                }
            });
            
            //If the player decides to tell the PT that they're fine, the PT will die
            answer2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    dialogLabel.setText("Send a real Doctor next time, so you don't kill more people...");
                
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
                    
                    dialogLabel.setText("Please come back to help me...");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("You must be sent by the Gods. I am so blessed to have been helped.");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    }
    
    @FXML
    public void handleIkbalClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Ikbal;
        currentField = field9_4;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(ikbalConvo);
        NPCNameLabel.setText(Ikbal.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("My lungs are sore.");
        
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
                    dialogLabel.setText("WHAT?! No!");
                
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
                        
                            field9_4.setVisible(false);
                            
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
                    
                    dialogLabel.setText("You must come back and help me! I am important!");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("My children and their grandchildren will hear of your greatness.");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    }
    
    @FXML
    public void handleJojoClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Jojo;
        currentField = field4_4;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(jojoConvo);
        NPCNameLabel.setText(Jojo.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("I think something bit me doctor, can you take a look?");
        
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
                    dialogLabel.setText("You must be delusional.");
                
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
                        
                            field4_5.setVisible(false);
                            
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
                    
                    dialogLabel.setText("You have other duties, I understand. But please help me.");
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("You fixed me! I am forever in your debt.");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    }
    
    @FXML
    public void handleBraytonClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Brayton;
        currentField = field10_2;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(braytonConvo);
        NPCNameLabel.setText(Brayton.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("Good day to you Doctor. Can you cure my fever?");
        
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
                    dialogLabel.setText("Are you stupid? Can you not see that I am sick?");
                
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
                        
                            field10_2.setVisible(false);
                            
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
                    
                    dialogLabel.setText("I understand. Other people must be more sick than I.");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("I am very grateful for your help.");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    }
    
    @FXML
    public void handleKelvenClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Kelven;
        currentField = field2_2;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(kelvenConvo);
        NPCNameLabel.setText(Kelven.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("I think some bug has ravaged everyone in my home\n"+
                                "we are all bitten and now sick.");
        
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
                    dialogLabel.setText("Have you not seen me?");
                
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
                        
                            field2_2.setVisible(false);
                            
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
                    
                    dialogLabel.setText("Go get your medicine, I will wait.");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("The Gods may have sent you to us, to give us a second chance.");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
    }
    
    @FXML
    public void handleFaizalClicked(MouseEvent event){
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        talkNPC = Faizal;
        currentField = field1_5;
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(true);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(faizalConvo);
        NPCNameLabel.setText(Faizal.getName());
        
        //The branch to be executed if the PT is currently not attempted treated AKA first encounter.
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("I think I have been infected by a disease from another man in this hut,\n"+
                                "would you know how I get good again?");
        
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
                    
                    treatBtn.setVisible(true);
                }
            });
            
            //If the player decides to tell the PT that they're fine, the PT will die
            answer2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    dialogLabel.setText("I will haunt you when I am a ghost.");
                
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
                        
                            field1_5.setVisible(false);
                            
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
                    
                    dialogLabel.setText("I am sick and I don't know why. Please, help me.");
                    
                }
            });
        }
         //Used when the player returns to the PT after having treated successfully
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("I will forever be thankful to you.");
            
            giveItemBtn.setVisible(true);
            treatBtn.setVisible(false);
            answer1.setVisible(false);
            answer2.setVisible(false);
            answer3.setVisible(false);
        }
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
                    
                    treatBtn.setVisible(false);
                    currentField.setVisible(false);
                    talkNPC.setAlive(false);
                    
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    
                    System.out.println(talkNPC.getName()+ " killed");
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
    
    //HANDLER FOR THE CLOSE-BUTTON
    @FXML
    public void handleCloseDialog(MouseEvent event) {
        treatActive = false;
        giveActive = false;
        updateInventory();
        
        dialogPane.setVisible(false);
    }

    //HANDLERS FOR THE HELP-PANE
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
