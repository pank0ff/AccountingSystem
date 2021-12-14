import interfaces.UserInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("log.txt",true);
            Date date = new Date();
            writer.write("NEW SESSION started on " + date +" :\n\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserInterface userInterface = new UserInterface();
        userInterface.handleQuery();
    }
}