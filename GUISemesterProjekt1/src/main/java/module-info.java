module sp1.guisemesterprojekt1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens sp1.guisemesterprojekt1 to javafx.fxml;
    exports sp1.guisemesterprojekt1;
}