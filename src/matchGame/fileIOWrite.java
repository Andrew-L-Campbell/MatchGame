/*
	Assignment: matchGame
	Program:    Ending
	

*/
/**
 * 
 */
package matchGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author andrew campbell
 *
 *This class allows to have the matched letter written to a file. 
 */
public class fileIOWrite {
	private static Formatter x;
	
	public void IO() {
		/**
		 *try statement with name of file
		 */
		try {
			x = new Formatter("Project_letters.txt");
		} 
		catch (Exception e) {
			System.out.printf("Error: %s%n" , e);
		}
	}
	/**
	 *adding letters to file using a generic method
	 */
	public static <T> void addRecords(Stack<String> excludedButtons) {
		x.format("Letter/s %s%n",excludedButtons);
		}
	/**
	 *closing file
	 */
	public void closeFile() {
		x.close();
	}
}
