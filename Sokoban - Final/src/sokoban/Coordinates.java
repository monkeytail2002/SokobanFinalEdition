/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.1 11/01/19
 */

package sokoban;

public class Coordinates {

    private int x;
    private int y;
	    
    public Coordinates() {
    	
    }
    

    public Coordinates(int x, int y) {
    	this.x = 0;
    	this.y = 0;
    	
    }

    public int getX() {  //gets the x position
        return x;
    }

    public int getY() {  //gets the y position
        return y;
    }

    public void setX(int newX) {  //sets the x position
        this.x = newX;
    }

    public void setY(int newY) {  //sets the y position
        this.y = newY;
    }

}