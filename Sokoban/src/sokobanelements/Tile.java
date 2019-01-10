/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 1.1 10/01/19
 */


package sokobanelements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sokobanmechanics.Coordinates;

public class Tile extends MapElements {
	
	/**
	 * Object that creates the image for the wall and then sets it.  Then it will @return the ImageView.
	 * @return
	 * @throws FileNotFoundException
	 */
	
	public ImageView setImage() throws FileNotFoundException {
		Image image = new Image(new FileInputStream("res/Tile.png"));
		ImageView imageView = new ImageView(image);
		return imageView;
	}
	
	
	/**
	 * Object returns co-ordinates for the tiles.
	 * 
	 * @param x
	 * @param y
	 */
    public void createElement(int x, int y) {
        Coordinates tileCoords = new Coordinates();
        tileCoords.setX(x);
        tileCoords.setY(y);
    }


}
