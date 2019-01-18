/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.1 11/01/19
 */

package sokoban;

public class Wall extends MapElements {
	
	private String elementImage;
	
	public Wall() {
		
		this.elementImage = "res/Wall.png";
	}


 
    public void createElement(int x, int y) {
        Coordinates wallCoords = new Coordinates();
        wallCoords.setX(x);
        wallCoords.setY(y);
    }

    public String getElementImage() {
        return elementImage;
    }
}

