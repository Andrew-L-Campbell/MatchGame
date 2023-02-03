/*
	Assignment: matchGame
	Program:    Intro
	

*/
/**
 * 
 */
package matchGame;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author andrew campbell
 * This class allows the user to read from the text file that was written to and displa it from a button in the maingameapp class
 *
 */
public class fileIORead {
	/**
	 *declaring scanner
	 */
	private Scanner scan;
	
	public String openFile() {
		/**
		 *try/catch statement for file 
		 */
		try {
			scan = new Scanner(new File("Project_letters.txt"));
		}
		catch(Exception e) {
			System.out.println("could not find file");
		}
		return scan.nextLine();
	}
	/**
	 *outputs the letters
	 */
	public String readFile() {
		while(scan.hasNext()) {
			System.out.println(scan.nextLine());
		}	
		return null;
	}
	/**
	 *closing
	 */
	public void closeFile() {
		scan.close();
	}


}
