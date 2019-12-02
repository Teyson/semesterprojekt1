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
    @FXML private ImageView treatMalaria;
    @FXML private ImageView tbImage1;
    @FXML private ImageView tbImage2;//made for setting image of person larger
    @FXML private ImageView treatTB;
    @FXML private ImageView hivImage1;
    @FXML private ImageView hivImage2; //made for setting image of person larger
    @FXML private ImageView treatHIV;
    
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
       
                        String imagePath = "img/Maria2.png";
                        Image image = new Image(imagePath);
                        useImage.setImage(image);
        
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
                        this.treatMalaria.setImage(null);
   
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
                        this.treatMalaria.setImage(null);
                        
                break;
                case 2: malariaLabel.setText("The Treatment & Prevention of Malaria");
                        malariaText.setText("There are many different treatments for Malaria, which attack different stages\n"+ 
                                            "of the infection. Most of them are used to target the parasites at the stage in\n"+
                                            "which they are targeting the red blood cells, but some target their metabolism.\n"+
                                            "\n"+                                            
                                            "There are many preventative measures that one can take to avoid getting \n"+
                                            "infected by the parasites. Most citizens from medically advanced countries\n"+
                                            "receive pills that they can take during their stay, to prevent catching the \n"+
                                            "disease while in dangerous areas.\n"+
                                            "\n"+
                                            "The WHO is working on distributing mosquito nets sprayed with insecticides, which citizens can put\n"+
                                            "over their beds so they are protected during the night.\n"+
                                            "A vast majority of citizens in Mozambique now own these nets, but they may still be very vulnerable\n"+
                                            "if they leave the net after twilight, where the mosquitos are most active. \n");
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String malariaMed = "img/Malaria Medicine.png";
                        Image malMed = new Image(malariaMed);
                        
                        this.malariaImage1.setImage(null);
                        this.malariaImage2.setImage(null);
                        this.treatMalaria.setImage(malMed);
                        
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
                        this.treatTB.setImage(null);
                        
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
                        this.treatTB.setImage(null);
                        
                        tbLabel.setPadding(new Insets(0,0,0,8));
                        tbText.setPadding(new Insets(0,0,0,15));
                break;
                case 2: tbLabel.setText("The Treatment & Prevention of Tuberculosis");
                        tbText.setText("There are many different types of medication that treats TB, and in cases where\n" +
                                       "it is multi-drug resistant TB, multiple will likely be used at the same time. In \n"+
                                       "particularly severe cases, treatment will typically persist throughout 20-30\n"+
                                       "months, and in many cases, the strain will become resistant throughout these\n"+
                                       "prolonged periods of treatment. In such instances, additional drugs can be used.\n"+
                                       "\n"+
                                       "Because of the harsh nature of these drugs, there will almost always be moderate \n"+
                                       "to severe side-effects, as all of these medications can be highly toxic to the liver.\n"+
                                       
                                       "\n"+
                                       "TB is typically a very preventable disease, as it is only transmitted through air containing the bacteria.\n"+
                                       "One of the most effective means of prevention is using a mouthbind, covering both the mouth and the nose,\n"+
                                       "and this is also strongly suggested to be used by clinicians treating these patients. As it is a disease that\n"+
                                       "does not transmit through saliva, food/water, and skin contact, it is very easy to avoid contracting it, \n"+
                                       "once using a mouthbind.");
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String tbTreat = "img/TB Medicine.png";
                        Image tbMed = new Image(tbTreat);
                        
                        this.tbImage1.setImage(null);
                        this.tbImage2.setImage(null);
                        this.treatTB.setImage(tbMed);
                        
                        
                break;
                
                
            }
            
            return new VBox(tbLabel,tbText);
        });
        

        //Setting the pages for HIV
        hivPag.setPageFactory((pageIndex) -> {
            switch(pageIndex){
                case 0: hivLabel.setText("The Epidemiology of HIV/AIDS");
                        hivText.setText("Globally, in 2018, there were an estimate of 37.9 million\n"+
                                "people living with the infection. On a global scale, about 0.8% of\n"+
                                "adults aged 15-49 have the infection, with the African WHO region\n"+
                                "having the highest prevalence, with nearly 1 in 25 (3.9%) living with\n"+
                                "the infection.\n"+
                                "\n"+
                                "Mozambique is the country that has the 8th highest HIV rate in \n"+
                                "the world, with 12.6% of adults aged 15-49 having the infection in \n"+
                                "2018. Of these, only 56% were on treatment for HIV. \n"+
                                "\n"+
                                "Women are disproportionally affected by HIV; of the 2,000,000 \n"+
                                "adults with HIV in Mozambique, 1,200,000 were women. Women \n"+
                                "are however also better at receiving treatment than males.\n"+
                                "The high transmission rates can be attributed to how only about \n"+
                                "31% of adults aged 15-24 can correctly identify ways of preventing\n"+
                                "sexual transmission of HIV.");
                
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String imagePath5 = "img/HIVEpi.jpg";
                        Image image5 = new Image(imagePath5);
                        
                        this.hivImage1.setImage(null);
                        this.hivImage2.setImage(image5);
                        this.treatHIV.setImage(null);
                        
                        hivLabel.setPadding(new Insets(0,0,0,8));
                        hivText.setPadding(new Insets(0,0,0,15));
                break;
                case 1: hivLabel.setText("The Symptoms of HIV/AIDS");
                        hivText.setText("HIV is a disease where the symptoms are typically connected\n"+
                                        "to other diseases contracted because of immunodeficiency.\n"+
                                        "\n"+
                                        "The following symptoms are common in patients with Stage 3 HIV:\n"+
                                        "   - Nausea and vomiting\n"+
                                        "   - Persistent diarrhea and rapid weight loss\n"+
                                        "   - Cough and shortness of breath\n"+
                                        "   - Recurring fevers and chills\n"+
                                        "   - Rashes, sores and lesions in the mouth or nose\n"+
                                        "\n"+
                                        "HIV is typically diagnosed by taking a blood- or saliva test, searching \n"+
                                        "for antibodies to the HIV virus. It can however take up to 12 weeks for \n"+
                                        "the body to form these. While the HIV test is done, a test for other\n"+
                                        "infections (complications) is typically made.");
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String imagePath6 = "img/Man1HIV.png";
                        Image image6 = new Image(imagePath6);
                        
                        this.hivImage1.setImage(null);
                        this.hivImage2.setImage(image6);
                        this.treatHIV.setImage(null);
                        
                        hivLabel.setPadding(new Insets(0,0,0,8));
                        hivText.setPadding(new Insets(0,0,0,15));
                break;
                case 2: hivLabel.setText("The Treatment & Prevention of HIV/AIDS");
                        hivText.setText("HIV is unfortunately a disease that cannot be cured. However, there are many\n"+
                                        "different drugs that can be used to control the virus (antiretroviral therapy).\n"+
                                        "\n"+
                                        "Treatment is typically offered to anyone with a positive diagnosis, but it is \n"+
                                        "particularly important when:\n"+
                                        "   - A patient has severe symptoms\n"+
                                        "   - The patient is pregnant\n"+
                                        "   - The patient is being treated for kidney diseases or Hepatitis\n"+
                                        "Treatment is very difficult, as it requires the patient to take many pills daily,\n"+
                                        "and these often have very severe side effects.\n"+
                                        "\n"+
                                        "HIV is also easily preventable, as it is an infection that gets transmitted either sexually or through blood.\n"+
                                        "It is therefore very effective to use condoms when having sex with an infected partner, and refraining from\n"+
                                        "unprotected oral, vaginal or anal sex is key. It does however not transmit through saliva, why kissing,\n"+
                                        "coughing and sneezing is safe. Anyone who takes their medicine for HIV as prescribed, are also \n"+
                                        "considered mostly safe, as it can reduce the virus' presence in blood to make it undetectable. However,\n"+
                                        "there is still a low chance of contracting the disease.");
                        
                        //(Re)Initialising the image graphic so it won't stay when changing page
                        // and to ensure that it also reloads upon changing back to the page.
                        String hivTreat = "img/HIV Medicine.png";
                        Image hivMed = new Image(hivTreat);
                        
                        this.hivImage1.setImage(null);
                        this.hivImage2.setImage(null);
                        this.treatHIV.setImage(hivMed);
                        
                        hivLabel.setPadding(new Insets(0,0,0,8));
                        hivText.setPadding(new Insets(0,0,0,15));
                break;
                
            }
            
            return new VBox(hivLabel,hivText);
        });
        
        
    }
    
}
