/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.9 11/01/19
 */


package sokoban;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SokobanController extends Application implements EventHandler<KeyEvent>{
	
	
    Level level = new Level();
    
    /**
	  * This loads in the FXML file for the GUI
	  */

    @Override
    public void start(Stage primaryStage) throws Exception {  //load the javafx document

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            String viewerFxml = "sokobanMenu.fxml";
            VBox page = (VBox) fxmlLoader.load(this.getClass().getResource(viewerFxml).openStream());
            Scene scene = new Scene(page);
            scene.setOnKeyPressed(this);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.exit(1);
        }

    }	
    
    
   
    

    @FXML
    private Button levelOne;

    @FXML
    private GridPane gameGrid;

    @FXML
    private Button startButton2;

    @FXML
    private Button startButton3;

    @FXML
    private Button startButtonFour;

    @FXML
    private Button startButton5;
    
    /**
     * This section sets up the buttons that will load the separate level maps with the event @param for when the buttons are clicked.
     * @param event
     */


    @FXML
    void startLevelFive(ActionEvent event) {
    	String mapLevel = "src/res/level5.txt"; 
    	level.Level(mapLevel);
    	setImage(level.getMap()); 
    }
    @FXML
    void startLevelFour(ActionEvent event) {
    	String mapLevel = "src/res/level4.txt"; 
    	level.Level(mapLevel);
    	gameGrid.getChildren().clear();
    	setImage(level.getMap()); 
    }

    @FXML
    void startLevelOne(ActionEvent event) {
    	String mapLevel = "src/res/level1.txt"; 
    	level.Level(mapLevel);
    	setImage(level.getMap()); 
    }

    @FXML
    void startLevelThree(ActionEvent event) {
    	String mapLevel = "src/res/level3.txt"; 
    	level.Level(mapLevel);
    	setImage(level.getMap()); 
    }

    @FXML
    void startLevelTwo(ActionEvent event) {
    	String mapLevel = "src/res/level2.txt"; 
    	level.Level(mapLevel);
    	setImage(level.getMap());

    }
    
    /**
     * Sets up the images into the gridPane in the correct positions.
     * @param levelArray
     */
    
    public void setImage(MapElements[][] levelArray) {
        int y = 0;
        int x = 0;
        while (levelArray[x][y] != null) {
            if (levelArray[x][y] != null) {
                Image imageElements = new Image(levelArray[x][y].getElementImage(), 32, 32, false, false);
                gameGrid.add(new ImageView(imageElements), x, y);
            }
            x++;
            if (levelArray[x][y] == null) {
                y++;
                x = 0;
            }
        }
    }
    
    /**
     * Series of objects that control movement via key press.
     */
    
    public void handle (KeyEvent event) {
    	if(event.getCode() == KeyCode.UP) {
    		level.moveUp();
    		setImage(level.getMap());
//    		System.out.println("Key pressed");
    	}
    	if(event.getCode() == KeyCode.DOWN) {
    		level.moveUp();
    		setImage(level.getMap());
    	}
    	if(event.getCode() == KeyCode.RIGHT) {
    		level.moveUp();
    		setImage(level.getMap());
    	}
    	if(event.getCode() == KeyCode.LEFT) {
    		level.moveUp();
    		setImage(level.getMap());
    	}
    }

    

}
