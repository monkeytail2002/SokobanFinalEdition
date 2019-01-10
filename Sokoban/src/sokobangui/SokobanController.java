/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 1.1 10/01/19
 */


package sokobangui;

import java.io.IOException;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sokobanmechanics.Level;

public class SokobanController extends Application{
	
	 @Override
	    public void start(Stage primaryStage) throws Exception {
		 /**
		  * This loads in the FXML file for the GUI
		  */

	        try {
	            FXMLLoader fxmlLoader = new FXMLLoader();
	            String viewerFxml = "Sokoban.fxml";
	            VBox page = (VBox) fxmlLoader.load(this.getClass().getResource(viewerFxml).openStream());
	            Scene scene = new Scene(page);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException ex) {
	            Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
	            System.exit(1);
	        }

	    }

	Level level = new Level();

    @FXML
    private GridPane grid;

    @FXML
    private Button levelOneButton;

    @FXML
    private Button levelTwoButton;

    @FXML
    private Button levelThreeButton;

    @FXML
    private Button LevelFourButton;

    @FXML
    private Button levelFiveButton;
    
    /**
     * This section sets up the buttons that will load the separate level maps with the event @param for when the buttons are clicked.
     * @param event
     */

    @FXML
    void loadLevelFive(ActionEvent event) {
    	String mapLevel = "res/level5.txt"; //Initialises the string 
    	level.reader(mapLevel);  //Pushes the string through to the reader object in the Level class.
    }

    @FXML
    void loadLevelFour(ActionEvent event) {
    	String mapLevel = "res/level4.txt"; 
    	level.reader(mapLevel);
    }

    @FXML
    void loadLevelOne(ActionEvent event) {
    	String mapLevel = "res/level1.txt"; 
    	level.reader(mapLevel);    	
    }

    @FXML
    void loadLevelThree(ActionEvent event) {
    	String mapLevel = "res/level3.txt"; 
    	level.reader(mapLevel);
    }

    @FXML
    void loadLevelTwo(ActionEvent event) {
    	String mapLevel = "res/level2.txt";  
    	level.reader(mapLevel);

    }

}
