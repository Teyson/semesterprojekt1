/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.guisemesterprojekt1;

import Domain.DomainAdministration;
import Interfaces.IInventory;
import Interfaces.ITime;
import Interfaces.INPC;
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
    
    HashMap<String, String> itemImageMapReverse;

    IInventory playerInventory;
    IInventory roomInventory;
    ArrayList<ImageView> inventoryImageList;
    
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
        
        Riyadh = da.getRoom().getNPC("Riyadh");
        field1_2.setImage(riyadhMini);
        
        Gani = da.getRoom().getNPC("Gani");
        field10_4.setImage(ganiMini);
        
        Abubakar = da.getRoom().getNPC("Abubakar");
        field5_5.setImage(abubakarMini);
        
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

        itemImageMapReverse = new HashMap<>()
        {{
            put("Clean Kanyle.png", "Clean Syringe");
            put("Dirty Kanyle.png" ,"Dirty Syringe");
            put("Condom.png" ,"Condom");
            put("HIV Medicine.png" ,"HIV Medication");
            put("Malaria Medicine.png" ,"Malaria Medication");
            put("TB Medicine.png" ,"Tuberculosis Medication");
            put("pill.png" ,"Pill");
            put("mask.png" ,"Mask");
            put("Mosquito Spray.png" ,"Mosquito Spray");
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
        updateInventory();
    }
    
    //HANDLERS FOR THE NPCs
    public void handleYuranClicked(MouseEvent event){
        INPC talkNPC = da.getRoom().getNPC("Yuran");
        
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        treatBtn.setVisible(false);
        giveItemBtn.setVisible(false);
        
        dialogPane.setVisible(!dialogPane.isVisible());
        NPCImage.setImage(yuranConvo);
        NPCNameLabel.setText(Yuran.getName());
        
        if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == false){
            dialogLabel.setText("Good to see you doctor! I feel very sick, I have a rash on my body\n"+
                               "and I think I have a fever. Can you please help me?");
        
            answer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event){
                    NPCImage.setImage(null);
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
        
            answer2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    dialogLabel.setText("I most certainly am not!\n"+
                                        "Will I now die because you are wrong?");
                
                    answer1.setText("More");
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                
                    answer1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event){
                            answer1.setVisible(false);
                            NPCNameLabel.setText(null);
                            
                            talkNPC.kill();
                            
                            NPCImage.setImage(null);
                            System.out.println(talkNPC.getName() + " killed");
                            dialogLabel.setText(talkNPC.getName() + " has died.");
                        
                            field8_3.setVisible(false);
                        }
                    });
                }
            });
            
            answer3.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    answer1.setVisible(false);
                    answer2.setVisible(false);
                    answer3.setVisible(false);
                    
                    dialogLabel.setText("Please, come back soon and help me!");
                    
                }
            });
        }
        else if(talkNPC.isAlive() == true && talkNPC.isTreatAttempted() == true){
            dialogLabel.setText("Thank you so much for helping me, I am very grateful!");
            
            giveItemBtn.setVisible(true);
        }
    }
    
    public void handleRiyadhClicked(MouseEvent event){
    
    }
    
    public void handleGaniClicked(MouseEvent event){
    
    }
    
    public void handleAbubakarClicked(MouseEvent event){
    
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
    }
    
    //HANDLERS FOR THE POPUPS
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
        da.setRoom(da.getRoomMap().get("village"));
        App.setRoot("village");
    }
    
    @FXML
    private void handleTrash(MouseEvent event) {
        //Change trashing state
        trashingActive = !trashingActive;
        
        if (trashingActive)
            inventoryGrid.setStyle("-fx-background-color:#ff8f87"); //Red
        else
            inventoryGrid.setStyle("-fx-background-color:#ffffff"); //White
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

}
