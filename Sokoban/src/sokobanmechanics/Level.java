/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 1.2 10/01/19
 */

package sokobanmechanics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import sokobanelements.Crate;
import sokobanelements.Diamond;
import sokobanelements.MapElements;
import sokobanelements.Tile;
import sokobanelements.Wall;
import sokobanelements.WarehouseKeeper;

public class Level {
	
	private MapElements[][] levelArray = new MapElements[25][15];
	Wall wall = new Wall();
	Coordinates Coord = new Coordinates();
	Crate crate = new Crate();
	Diamond diamond = new Diamond();
	Tile tile = new Tile();
	WarehouseKeeper wKeeper = new WarehouseKeeper();
	
	public Level() {
		
	}
	
	/**
	 * Reads the level text files and uses the @param mapLevel pushed from the @Link SokobanController class button objects to supply the filepath.
	 * 
	 * @param mapLevel
	 * @link SokobanController
	 */
	public void reader(String mapLevel) {
		String levelMap = mapLevel;
		
		File mapFile = new File(levelMap);
		
		FileReader reader = null;

        BufferedReader inputBuffer = null;
        int x = 0;
        int y = 0;

        try {

            reader = new FileReader(mapFile);
            inputBuffer = new BufferedReader(reader);
            String inputLine = inputBuffer.readLine();
            while (inputLine != null) {
            	System.out.println(inputLine);
            	/**
            	 * For loop and switchcase that translate the characters via @char into the positional co-ordinates and images.
            	 */
            	for (int i = 0; i < inputLine.length(); i++) {
                    char mapItem = inputLine.charAt(i);
                    switch (mapItem) {
                        case 'X':
                            wall.createElement(x, y);
                            setMapElement(x,y,wall);
                            break;
                        case '*':
                            //crate
                            crate.createElement(x, y);
                            setMapElement(x, y, crate);
                            break;
                        case '.':
                            //diamond
                            diamond.createElement(x, y);
                            setMapElement(x, y, diamond);
                            break;
                        case ' ':
                            //tile
                            tile.createElement();
                            setMapElement(x, y, tile);
                            break;
                        case '@':
                            //warehouseKeeper
                            wKeeper.createElement(x, y);
                            setMapElement(wKeeper.warehouseCoords.getX(), wKeeper.warehouseCoords.getY(), wKeeper);
                            break;
                        default:
                            System.out.println("Invalid character");
                            System.exit(0);
                    }
                    //increments x and y to fit the files to the grid
                    x++;
                    if (x >= inputLine.length()) {
                        y++;
                        x = 0;
                    }
            }
            	inputLine = inputBuffer.readLine();	
            }
        } catch (Exception e) {
            	e.printStackTrace();
            }
	}
	
	
	/**
	 * Returns the map multiarray so it can be passed into the reader object
	 * @return
	 */
	public MapElements[][] getMap() {
        return levelArray;
    }
	
	/**
	 * Sets up the multiarray so that the text files and elements can be positioned correctly on the grid.
	 * @param x
	 * @param y
	 * @param mapElement
	 */
	public void setMapElement(int x, int y, MapElements mapElement) {
	       levelArray[x][y] = mapElement;
	   }
	 
	 

	
	
	
}
