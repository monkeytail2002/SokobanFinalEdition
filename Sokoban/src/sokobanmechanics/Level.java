/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 1.1 10/01/19
 */

package sokobanmechanics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Level {
	
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

        try {

            reader = new FileReader(mapFile);
            inputBuffer = new BufferedReader(reader);
            String inputLine = inputBuffer.readLine();
            while (inputLine != null) {
            	System.out.println(inputLine);
            	inputLine = inputBuffer.readLine();	
            	
            }
        } catch (Exception e) {
            	e.printStackTrace();
            }
	}

}
