/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.8 10/01/19
 */

package sokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Level {

    private MapElements[][] levelArray = new MapElements[25][15];
    WarehouseKeeper wKeeper = new WarehouseKeeper();
    private MapElements[][] diamondArray = new MapElements[25][15];
    Coordinates coords = new Coordinates();

    /**
	 * Reads the level text files and uses the @param mapLevel pushed from the @Link SokobanController class button objects to supply the filepath.
	 * 
	 * @param mapLevel
	 * @link SokobanController
	 */

    public void Level(String mapLevel) {

    	String levelMap = mapLevel;	
    	FileReader reader = null;
        BufferedReader inputBuffer = null;
        try {

            reader = new FileReader(levelMap);
            inputBuffer = new BufferedReader(reader);
            String inputLine = inputBuffer.readLine();
            int x = 0;
            int y = 0;
            while (inputLine != null) {
//                System.out.println(inputLine);  //Tests the reader
                /**
            	 * For loop and switch/case that translate the characters via @char into the positional co-ordinates and images.
            	 */
                for (int i = 0; i < inputLine.length(); i++) {
                    char mapChar = inputLine.charAt(i);
                    switch (mapChar) {
                        case '*':
                            Crate crate = new Crate();
                            crate.createElement(x, y);
                            setMapElement(x, y, crate);
                            break;
                        case '.':
                            Diamond diamond = new Diamond();
                            diamond.createElement(x, y);
                            setMapElement(x, y, diamond);
                            setDiamondArrayElement(x, y, diamond);
                            break;
                        case 'X':
                            Wall wall = new Wall();
                            wall.createElement(x, y);
                            setMapElement(x, y, wall);
                            break;
                        case ' ':
                            Tile tile = new Tile();
                            tile.createElement();
                            setMapElement(x, y, tile);
                            break;
                        case '@':
                            wKeeper.createElement(x, y);
                            setMapElement(wKeeper.keeperCoords.getX(), wKeeper.keeperCoords.getY(), wKeeper);
                            break;
                        default:
                            System.out.println("Character not Recognised");
                            System.exit(0);
                    }
                    x++;
                    if (x >= inputLine.length()) {
                        y++;
                        x = 0;
                    }

                }
                inputLine = inputBuffer.readLine();
                }
        } catch (FileNotFoundException fnfe) {	
            fnfe.printStackTrace();
        } catch (IOException ioe) {	
        	ioe.printStackTrace();
        } finally {
        	try {
				inputBuffer.close();  //Close the buffer after use.
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

    }
    
    
    /**
	 * Returns the map multiarray
	 * @return levelArray
	 */
    public MapElements[][] getMap() {
        return levelArray;
    }
    
    
    /**
	 * Sets up the multiarray so that the text files and elements can be positioned correctly on the grid.
	 * 
	 * @param x
	 * @param y
	 * @param mapElement
	 */

    public void setMapElement(int x, int y, MapElements mapElement) {
        levelArray[x][y] = mapElement;
    }
    
    
    /**
	 * Sets up the diamond array to keep track of win condition.
	 * @param x
	 * @param y
	 * @param mapElement
	 */
       

    public void setDiamondArrayElement(int x, int y, MapElements mapElement) {
        diamondArray[x][y] = mapElement;
        System.out.println(diamondArray);

    }
    
    
    /**
     * A series of objects that control movement
     */
    public void moveUp() {
    	moveCrate(0, -1);
    }

    public void moveRight() {
    	moveCrate(1, 0);
    }

    public void moveDown() {
    	moveCrate(0, 1);
    }

    public void moveLeft() {
    	moveCrate(-1, 0);
    }
    
    /**
     * Object that checks and controls the warehouse keeper movement
     * @param moveX
     * @param moveY
     */
    
    public void wKeeperMove(int moveX, int moveY) {
        if (levelArray[wKeeper.keeperCoords.getX() + moveX][wKeeper.keeperCoords.getY() + moveY] instanceof Wall) {
        	
        } else {
            Tile tile = new Tile();
            setMapElement(wKeeper.keeperCoords.getX(), wKeeper.keeperCoords.getY(), tile);
            wKeeper.keeperCoords.setX(wKeeper.keeperCoords.getX() + moveX);
            wKeeper.keeperCoords.setY(wKeeper.keeperCoords.getY() + moveY);
            setMapElement(wKeeper.keeperCoords.getX(), wKeeper.keeperCoords.getY(), wKeeper);
            winCondition();
        }
    }
    
    
    
    /**
     * Object checks for crates and their movement 
     * @param moveX
     * @param moveY
     */

    public void moveCrate(int moveX, int moveY) {
        if (levelArray[wKeeper.keeperCoords.getX() + moveX][wKeeper.keeperCoords.getY() + moveY] instanceof Crate
                && levelArray[wKeeper.keeperCoords.getX() + moveX * 2][wKeeper.keeperCoords.getY() + moveY * 2] instanceof Wall
                || levelArray[wKeeper.keeperCoords.getX() + moveX][wKeeper.keeperCoords.getY() + moveY] instanceof Crate
                && levelArray[wKeeper.keeperCoords.getX() + moveX * 2][wKeeper.keeperCoords.getY() + moveY * 2] instanceof Crate) {
            //dont move
        } else if (levelArray[wKeeper.keeperCoords.getX() + moveX][wKeeper.keeperCoords.getY() + moveY] instanceof Crate) {
            //move crate
            Crate crate = new Crate();
            setMapElement(wKeeper.keeperCoords.getX() + moveX * 2, wKeeper.keeperCoords.getY() + moveY * 2, crate);
            wKeeperMove(moveX, moveY);
        } else {
        	wKeeperMove(moveX, moveY);
        }
    }
    
    
    /**
     * Object checks win conditions and keeps track of the number of crates on diamonds.
     */
    
   
    public void winCondition() { 
    	int cratesOnDiamonds = 0;
        int diamonds = 0;
        for (int x = 0; x < 25; x++) {
            for (int y = 0; y < 15; y++) {
                if (diamondArray[x][y] instanceof Diamond) {
                    diamonds++;
                }
            }
        }
        for (int x = 0; x < 25; x++) {
            for (int y = 0; y < 15; y++) {
                if (diamondArray[x][y] instanceof Diamond && levelArray[x][y] instanceof Crate) {
                    cratesOnDiamonds++;
                    if (cratesOnDiamonds == diamonds) {
                        
                    }
                }
            }
        }
    }

}
