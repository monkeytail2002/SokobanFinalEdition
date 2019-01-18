/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.1 11/01/19
 */

package sokoban;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler<KeyEvent>{

	Level mapLevel = new Level();
	MoveableMapElements moveElement;
	SokobanController sokCont = new SokobanController();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    
    public void start(Stage primaryStage) throws Exception {

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
    
    /**
     * Series of objects that control movement via key press.
     */
    
    public void handle (KeyEvent event) {
    	if(event.getCode() == KeyCode.UP) {
    		moveElement.moveUp();
    		sokCont.setImage(mapLevel.getMap());
//    		System.out.println("Key pressed");
    	}
    	if(event.getCode() == KeyCode.DOWN) {
    		moveElement.moveDown();
    		sokCont.setImage(mapLevel.getMap());
    	}
    	if(event.getCode() == KeyCode.RIGHT) {
    		moveElement.moveRight();
    		sokCont.setImage(mapLevel.getMap());
    	}
    	if(event.getCode() == KeyCode.LEFT) {
    		moveElement.moveLeft();
    		sokCont.setImage(mapLevel.getMap());
    	}
    }


}
