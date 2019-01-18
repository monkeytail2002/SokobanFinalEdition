/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.1 11/01/19
 */

package sokoban;


public class Tile extends MapElements {
	
	private String elementImage;
	
	public Tile() {
		
		this.elementImage = "res/Floor.png";
		
	}


    public void createElement() {

    }

    public String getElementImage() {
        return elementImage;
    }

}