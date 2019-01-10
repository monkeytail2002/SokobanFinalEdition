/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 1.1 10/01/19
 */


package sokobanelements;

import javafx.scene.image.ImageView;

public abstract class MapElements {  //Class was made abstract to provide a base for the subclasses.
	
	private ImageView imageView;
	
	public ImageView getImage() {
		return imageView;
	}

}
