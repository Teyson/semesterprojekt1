package semesterprojekt1;

import java.util.ArrayList;
import java.util.Scanner;

public class Interaction {
    //Attributes
    private String option;
    private String message;
    private ArrayList<Interaction> children;
    private Scanner sc = new Scanner(System.in);
    private int input;
    
    //Constructors
    public Interaction(){
    }
    
    public Interaction(String option, String message){
        this.option = option;
        this.message = message;
        this.children = new ArrayList<>();
    }
    
    //Methods
    public void addChild(Interaction child){
        this.children.add(child);
    }
    
    public String getOption(){
        return option;
    }
    
    public void printOptions(){
        if (children == null) {
            System.out.println("No children found");
        }
        else{
            for (int i = 0; i < this.children.size(); i++) {
                System.out.println(i + ") " + this.children.get(i).getOption());
            }
        }
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public void start(Interaction node){
        System.out.println(node.message);
        
        node.printOptions();
        
        if(!node.children.isEmpty()){
            input = sc.next().charAt(0) - 48;
            start(node.children.get(input));
        }   
    }
}
