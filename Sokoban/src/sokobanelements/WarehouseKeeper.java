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

public class WarehouseKeeper extends MoveableElements { 

	/**
	 * Object that creates the image for the Warehouse Keeper and then sets it.  Then it will @return the ImageView.
	 * @return
	 * @throws FileNotFoundException
	 */
	public Coordinates warehouseCoords = new Coordinates();
	public ImageView setImage() throws FileNotFoundException {
		Image image = new Image(new FileInputStream("res/WarehouseKeeper.png"));
		ImageView imageView = new ImageView(image);
		return imageView;
	}
	
	/**
	 * 
	 * Object that returns the co-ordinates for the Warehouse Keeper.
	 * 
	 * @param x
	 * @param y
	 */
    public void createElement(int x, int y) {
        warehouseCoords.setX(x);
        warehouseCoords.setY(y);
    }


}
