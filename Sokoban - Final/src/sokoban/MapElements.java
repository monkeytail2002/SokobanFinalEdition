/**
 * Angus MacDonald:  15009351
 * Tutor: Karen MacKay
 * Sokoban Assessment
 * Version 2.1 11/01/19
 */

package sokoban;

public abstract class MapElements { //Class was made abstract to provide a base for the subclasses extended to it.

    
	
	private String elementImage;
    
	
	public MapElements() {
		
	}
	
    public void createElement() {
    }
    
    public String getElementImage(){
        return elementImage;
    }

}
