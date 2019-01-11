/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.1 10/01/19
 */

package sokoban;

public class Crate extends MoveableMapElements {

    private String elementImage = "res/Crate.png";

    /**
	 * Object returns co-ordinates for crates
	 * @param x
	 * @param y
	 */
    public void createElement(int x, int y) {
        Coordinates crateCoords = new Coordinates();
        crateCoords.setX(x);
        crateCoords.setY(y);
    }

    
	/**
	 * Object that will @return the image as a @String.
	 * @return
	 * 
	 */
    public String getElementImage() {
        return elementImage;
    }
}