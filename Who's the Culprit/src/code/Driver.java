package code;

/**
 * This class is a class where we can run the program. Seperating the driver class will
 * be easier for us to keep track our codes. A way of organizations. What it will run will
 * be the graphic user interfaces.
 * 
 * @author ZhiWen Huang
 *
 */
public class Driver {

	public static void main(String[] args){
		Gui gui = new Gui(new ClueModel());
	}
}
