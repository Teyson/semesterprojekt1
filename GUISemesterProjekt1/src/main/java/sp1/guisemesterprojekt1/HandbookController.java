package sp1.guisemesterprojekt1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class HandbookController implements Initializable{
    @FXML private Tab malariaTab;
    @FXML private Tab tbTab;
    @FXML private Tab hivTab;
    @FXML private Tab useTab;
    
    @FXML private Pagination malariaPag;
    @FXML private Pagination tbPag;
    @FXML private Pagination hivPag;
    
    //Setting the Title Labels
    @FXML private Label useLabel;
    @FXML private Label malariaLabel;
    @FXML private Label tbLabel;
    @FXML private Label hivLabel;
    
    //Setting the Text Labels
    @FXML private Label useText;
    @FXML private Label malariaText;
    @FXML private Label tbText;
    @FXML private Label hivText;
    
    //Setting the Image Views
    @FXML private ImageView useImage;//set to Maria2.png through Scenebuilder so required init. but not used in the code.
    @FXML private ImageView malariaImage1;
    @FXML private ImageView malariaImage2; //made for setting image of person larger
    @FXML private ImageView tbImage1;
    @FXML private ImageView tbImage2;//made for setting image of person larger
    @FXML private ImageView hivImage1;
    @FXML private ImageView hivImage2; //made for setting image of person larger
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Setting the How To Use Page
        
        useLabel.setText("How to Use the Doctor's Handbook");
        useText.setText("Welcome to the Doctor's Handbook!\n"+
                        "This Handbook will serve as your primary aid on your mission here in Mozambique. A difficult task is \n"+ 
                        "before you, and hopefully this book will give you some guidance.\n"+
                        "\n"+
                        "This book contains 4 sections, one of these is the one you are currently reading. The others are:\n"+
                        "   - Malaria \n"+
                        "   - Tuberculosis \n" +
                        "   - HIV/AIDS\n"+
                        "These sections give you all the information you will need (and more) about the diseases you will face\n"+
                        "while you are here. Each section contains information about:\n"+
                        "   1. The Epidemiology of the Disease (Their spread and the threat they pose)\n"+
                        "   2. The Symptoms of the Disease\n"+
                        "   3. How to Treat and Prevent the Disease\n"+
                        "While it will mostly be the last 2 sections that you will be using, we recommend \n"+
                        "you read the first as well, as it is important to understand the things \n" +
                        "contained here, so you can use the knowledge in real life!");
        
                        useLabel.setPadding(new Insets(0,0,0,8));
                        useText.setPadding(new Insets(0,0,0,15));
        
        //Setting the pages for Malaria
        malariaPag.setPageFactory((pageIndex) -> {
            switch(pageIndex){
                case 0: malariaLabel.setText("The Epidemiology of Malaria");
                        malariaText.setText("In 2017, about 86% of the global Malaria burden was found in \n" +
                             "Africa; The highest incidence rates were found in Congo (25%)\n" +
                             "Nigeria (11%), and Mozambique (5%).\n" + 
                             "\n" +
                             "In Mozambique, it was estimated that in 2018, almost 16 \n" + 
                             "million citizens were affected by the disease, with almost 9  \n" +
                             "million confirmed cases. Despite efforts made by the WHO  \n" + 
                             "and the United Nations (UN), there has been a gradual increase in cases over the period of 2015-2018. A \n" +
                             "small percentage of cases are fatal, primarily because there is a rise in the multi-antibiotic resistant Malaria \n" +
                             "larvae. This renders the disease difficult to treat, as more advanced antibiotics are expensive and difficult \n" + 
                             "to access.\n"+
                             "\n" +
                             "Malaria is typically transmitted through a specific type of mosquito, that carries the Malaria larvae, as it is\n" +
                             "primarily transmittable through the blood. The larvae are injected into the bloodstream, from which larvae \n"+
                             "will travel to the liver. Here, the will settle and mature within a couple of days. From the liver, they will \n"+
                             "infect the red blood cells, and cause them to burst. This causes 'Anemia', a condition where oxygen is not\n" +
                             "transported sufficiently around the body, due to a lack of efficient red blood cells.");
                        
                        malariaLabel.setPadding(new Insets(0,0,0,8));
                        malariaText.setPadding(new Insets(0,0,0,15));
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String imagePath1 = "img/MozambiqueMalaria.jpg";
                        Image image1 = new Image(imagePath1);
                        
                        this.malariaImage1.setImage(image1);
                        this.malariaImage2.setImage(null);
   
                break;
                case 1: malariaLabel.setText("The Symptoms of Malaria");
                        malariaText.setText("The symptoms of Malaria are typical to those of any other \n" +
                                            "infection, which makes it a hard diagnosis to make in practice,\n"+
                                            "unless the patient's history warrants suspicion of Malaria.\n"+
                                            "\n"+
                                            "The most common symptoms are: \n"+
                                            " - High fever and shaking chills\n" +
                                            " - Profuse Sweating\n"+
                                            " - Headaches\n"+
                                            " - Nausea and Vomiting\n"+
                                            " - Abdominal pain and Diarrhea\n"+
                                            " - Loss of breath and anemia\n"+
                                            "\n"+
                                            "Malaria is typically diagnosed through a blood test, which will \n"+
                                            "also show which strain that the patient has. Moreover, the doctor\n"+ 
                                            "will touch the patient's stomach, to determine if the spleen\n"+
                                            "and/or liver is enlarged.");
                        
                        malariaLabel.setPadding(new Insets(0,0,0,8));
                        malariaText.setPadding(new Insets(0,0,0,15));
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String imagePath2 = "img/Lady2Malaria.png";
                        Image image2 = new Image(imagePath2);
                        
                        this.malariaImage2.setImage(image2);
                        this.malariaImage1.setImage(null);
                        
                break;
                case 2: malariaLabel.setText("The Treatment & Prevention of Malaria");
                        malariaText.setText("There are many different treatments for Malaria, which attack different stages of the infection. Most of them\n"+
                                            "are used to target the parasites at the stage in which they are targeting the red blood cells, but some also\n"+
                                            "blood cells, but some also target their metabolism. The latter are the more harsh treatments, used for late-\n "+
                                            "stage infections.\n"+
                                            "\n"+
                                            "There are many preventative measures that one can take to avoid getting infected by the parasites. Most \n"+
                                            "citizens from medically advanced countries receive pills that they can take to prevent catching the\n"+
                                            "disease while in dangerous areas. The medicine called Ercoquin is recommended by the WHO for use when\n"+
                                            "traveling to vulnerable areas, as it is both cheap and effective.\n"+
                                            "\n"+
                                            "Non-medically, the WHO has been working on distributing mosquito nets in Mozambique, which can be put\n"+
                                            "over the bed of citizens in the affected areas. These nets are typically sprayed with insecticides, to\n"+
                                            "further keep the mosquitos from stinging citizens, something that has been proven to decrease the risk of\n"+
                                            "infection by up to 50% with African children. This insecticide typically lasts up to 3 years. \n");
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        this.malariaImage1.setImage(null);
                        this.malariaImage2.setImage(null);
                        
                break;  
            }
            
            return new VBox(malariaLabel,malariaText);
        });
        
        //Setting the pages for TB
        tbPag.setPageFactory((pageIndex) -> {
            switch(pageIndex){
                case 0: tbLabel.setText("The Epidemiology of Tuberculosis");
                        tbText.setText("Tuberculosis (TB) is a global health concern, and Mozambique\n"+
                                       "is one of the few high-burden countries, where the incidence\n"+
                                       "rate has not improved in the latest years.\n"+
                                       "\n"+
                                       "Mozambique has an incidence of 552/100.000 citizens, where \n"+
                                       "3-4% of these cases are diagnosed as multiresistant strains. \n"+
                                       "It is estimated that up to 56% of cases of TB are HIV-induced.\n"+
                                       "are HIV-induced. Mozambique also has one of the world's  \n"+
                                       "lowestTB detection rates, at only 37%; for reference, the   \n"+
                                       "detection rate is 86% in the USA.\n"+
                                       "\n"+
                                       "TB is contracted by breathing in air, that contains the TB bacteria. It is therefore widely spread in areas\n"+
                                       "where people live close to each other, and where sanitation is low. It is important to know, that people are\n"+
                                       "not equally prone to becoming sick; it is mostly people with TB in the throat or lungs who are infectious. It\n"+
                                       "is solely spread by e.g. coughing or sneezing, not through food/water, skin contact, saliva or clothes. \n"+
                                       "to common belief, it is also not a hereditary disease.");
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String imagePath3 = "img/TBEpi.jpg";
                        Image image3 = new Image(imagePath3);
                        
                        this.tbImage1.setImage(image3);
                        this.tbImage2.setImage(null);
                        
                        tbLabel.setPadding(new Insets(0,0,0,8));
                        tbText.setPadding(new Insets(0,0,0,15));
                        
                break;
                case 1: tbLabel.setText("The Symptoms of Tuberculosis");
                        tbText.setText("TB is a tricky disease to diagnose, as it may lie dormant for\n" +
                                       "extended periods of time. There are therefore two states of\n"+
                                       "the disease:\n"+
                                       " - Latent, where the bacteria are inactive and there are no symptoms.\n"+
                                       " - Active, where the bacteria are active, and symptoms arise.\n"+
                                       "\n"+
                                       "The symptoms of active, infectious TB are:\n"+
                                       " - Persistent cough (>3 weeks)\n" +
                                       " - Coughing up blood\n"+
                                       " - Chest pains/pain while breathing/coughing\n"+
                                       " - Fatigue\n"+
                                       " - High fever, night sweats and chills\n"+
                                       " - Loss of appetite and/or weight loss\n"+
                                       "\n"+
                                       "TB is typically diagnosed using a stethoscope to listen to the lungs, and\n"+
                                       "by checking lymph nodes for swelling. Most commonly however, it is diagnosed by doing a skin test\n"+
                                       "or a blood test. If the skin creates a hard, red bump from the skin test, it is a positive result.");
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String imagePath4 = "img/Lady1TB.png";
                        Image image4 = new Image(imagePath4);
                        
                        this.tbImage1.setImage(null);
                        this.tbImage2.setImage(image4);
                        
                        tbLabel.setPadding(new Insets(0,0,0,8));
                        tbText.setPadding(new Insets(0,0,0,15));
                break;
                case 2: tbLabel.setText("The Treatment & Prevention of Tuberculosis");
                        tbText.setText("There are many different types of medication that treats TB, and in cases where it is multi-drug\n" +
                                       "resistant TB, multiple will likely be used at the same time. In particularly severe cases, treatment\n"+
                                       "will typically persist throughout 20-30 months, and in many cases, the strain will become resistant\n"+
                                       "throughout these prolonged periods of treatment. In such instances, additional drugs can be used.\n"+
                                       "\n"+
                                       "Because of the harsh nature of these drugs, there will almost always be moderate to severe side-\n"+
                                       "effects, as all of these medications can be highly toxic to the liver.\n"+
                                       "\n"+
                                       "TB is typically a very preventable disease, as it is only transmitted through air containing the\n"+
                                       "bacteria. One of the most effective means of prevention is using a mouthbind, covering both the mouth\n"+
                                       "and the nose, and this is also strongly suggested to be used by clinicians treating these patients.\n"+
                                       "As it is a disease that does not transmit through saliva, food/water, and skin contact, it is very easy\n"+
                                       "to avoid contracting, once using a mouthbind.");
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        this.tbImage1.setImage(null);
                        this.tbImage2.setImage(null);
                        
                        
                break;
                
                
            }
            
            return new VBox(tbLabel,tbText);
        });
        

        //Setting the pages for HIV
        hivPag.setPageFactory((pageIndex) -> {
            switch(pageIndex){
                case 0: hivLabel.setText("The Epidemiology of HIV/AIDS");
                        hivText.setText("Mozambique is the country that has the 8th highest HIV rate in \n"+
                                "the world, with 12.6% of adults aged 15-49 having the infection in \n"+
                                "2018. Of these, only 56% were on treatment for HIV. "+
                                "");
                
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String imagePath5 = "img/HIVEpi.jpg";
                        Image image5 = new Image(imagePath5);
                        
                        this.hivImage1.setImage(null);
                        this.hivImage2.setImage(image5);
                break;
                case 1: hivLabel.setText("The Symptoms of HIV/AIDS");
                        hivText.setText("The symptoms of HIV/AIDS are: " + "\n" +
                                "- High fever" + "\n" +
                                "- Sweating");
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String imagePath6 = "img/Man1HIV.png";
                        Image image6 = new Image(imagePath6);
                        
                        this.hivImage1.setImage(null);
                        this.hivImage2.setImage(image6);
                break;
                case 2: hivLabel.setText("The Treatment & Prevention of HIV/AIDS");
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        this.hivImage1.setImage(null);
                        this.hivImage2.setImage(null);
                break;
                
            }
            
            return new VBox(hivLabel,hivText);
        });
        
        
    }
    
}
