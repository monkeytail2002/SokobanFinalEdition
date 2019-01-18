/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.9 11/01/19
 */


package sokoban;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


public class SokobanController{
	
	
    Level controlLevel = new Level();
    
    public SokobanController() {
    	
    }
   
    

    @FXML
    private Button levelOne;

    @FXML
    private GridPane grid;

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
    	controlLevel.Level(mapLevel);
    	setImage(controlLevel.getMap()); 
    }
    @FXML
    void startLevelFour(ActionEvent event) {
    	String mapLevel = "src/res/level4.txt"; 
    	controlLevel.Level(mapLevel);
    	setImage(controlLevel.getMap()); 
    }

    @FXML
    void startLevelOne(ActionEvent event) {
    	String mapLevel = "src/res/level1.txt"; 
    	controlLevel.Level(mapLevel);
    	setImage(controlLevel.getMap()); 
    }

    @FXML
    void startLevelThree(ActionEvent event) {
    	String mapLevel = "src/res/level3.txt"; 
    	controlLevel.Level(mapLevel);
    	setImage(controlLevel.getMap()); 
    }

    @FXML
    void startLevelTwo(ActionEvent event) {
    	String mapLevel = "src/res/level2.txt"; 
    	controlLevel.Level(mapLevel);
    	setImage(controlLevel.getMap());

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
                grid.add(new ImageView(imageElements), x, y);
            }
            x++;
            if (levelArray[x][y] == null) {
                y++;
                x = 0;
            }
        }
    }
    

}
