/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.1 11/01/19
 */

package sokoban;

public class WarehouseKeeper extends MoveableMapElements {

    private String elementImage;
    public Coordinates keeperCoords = new Coordinates();
    
    public WarehouseKeeper() {
    	this.elementImage = "res/WarehouseKeeper.png";
    }

    public void createElement(int x, int y) {
        keeperCoords.setX(x);
        keeperCoords.setY(y);
    }
    

	public String getElementImage() {
        return elementImage;
        }
}