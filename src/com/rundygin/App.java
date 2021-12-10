import java.util.Scanner;
import accountingSystem.AccountingSystem;
import interfaces.UserInterface;

public class App {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.handleQuery();
    }
}