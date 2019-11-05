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
    public Interaction() {
    }

    public Interaction(String option, String message) {
        this.option = option;
        this.message = message;
        this.children = new ArrayList<>();
    }

    //Methods
    public void addChild(Interaction child) {
        this.children.add(child);
    }

    public void addTreat() {
        addChild(new Interaction("HIV", "pills"));
        addChild(new Interaction("Tuberculosis", "test2"));
    }

    public String getOption() {
        return option;
    }

    public void printOptions() {
        if (children == null) {
            System.out.println("No children found");
        } else {
            for (int i = 0; i < this.children.size(); i++) {
                System.out.println(i + ") " + this.children.get(i).getOption());
            }
        }
    }

    public String getMessage() {
        return this.message;
    }

    public void start() {
        System.out.println(this.message);

        this.printOptions();

        try {
            if (!this.children.isEmpty()) {
                input = sc.next().charAt(0) - 48;
                this.children.get(input).start();
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid input.");
        }
    }
}
