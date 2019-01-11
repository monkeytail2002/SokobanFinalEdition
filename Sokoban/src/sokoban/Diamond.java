/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.1 11/01/19
 */

package sokoban;

public class Diamond extends MapElements {

    boolean hasCrate = false;

    private String elementImage = "res/Diamond.png";

    /**
	 * Object returns co-ordinates for diamonds.
	 * @param x
	 * @param y
	 */
    public void createElement(int x, int y) {
        Coordinates diamondCoords = new Coordinates();
        diamondCoords.setX(x);
        diamondCoords.setY(y);
    }

    
    /**
     * Object returns if the diamond has a crate on it or not.
     * @return hasCrate
     */
    public boolean getHasCrate() {
        return hasCrate;
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
