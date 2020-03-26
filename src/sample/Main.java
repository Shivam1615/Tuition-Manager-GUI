package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Is the main class for the GUI program of the TuitionManager.fxml and creates
 * the main event of the GUI.
 *
 * @author Kevin Shah
 * @author Shivam Patel
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TuitionManager.fxml"));
        primaryStage.setTitle("Program 3 - Tuition Manager");
        primaryStage.setScene(new Scene(root, 580, 600));
        primaryStage.show();
    }

    /**
     * Is the main method of the class.
     *
     * @param args Argument for launching the GUI.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
