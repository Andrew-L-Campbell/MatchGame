/*
	Assignment: matchGame
	Program:    MatchGameApp
	Andrew CAmpbell
	
	This is a matching letter game. You choose a button and it shows you what letter it is. You then have one more try to click on another one to see
	if you get a match. If there is a match it tells you, if there isnt it reverts back to button. 

*/
package matchGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;

public class MatchGameApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/////////////added
	
	/**
	 * initialized variables, declared objects, made arrays. 
	 */
	int count = 0;
	int counter = 0;


	int points = 0;

	fileIORead read = new fileIORead();
	fileIOWrite write = new fileIOWrite();
	
	Stack<String> stack = new Stack<>();
	Stack<String> excludedButtons = new Stack<>();
	
	JButton btnNewButton, btnNewButton_1, btnNewButton_2,btnNewButton_3,btnNewButton_4,btnNewButton_5,btnNewButton_6,
	btnNewButton_7,btnNewButton_8,btnNewButton_9,btnNewButton_10,btnNewButton_11;
	private JSplitPane splitPane;
	private JButton btnNewButton_12;
	private JLabel lblNewLabel_3;
/////////////////
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchGameApp frame = new MatchGameApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MatchGameApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		///////////////////////////////////////////////Starting what I added///////////////////////////////////
		/**
		 * Set up layout
		 */
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Matches:      ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Letter:      ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_2); 
		
		/////////////////////////////////////////////////Button 1 //////// AAAAA(linked to button 2)
		btnNewButton = new JButton("Button 1");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 *
			 */
			public void actionPerformed(ActionEvent e) {
				/**
				 * if statement to skip if matched
				 */
				if (btnNewButton.getText()!="Match") {
					/**
					 *changing text to A 
					 */	
				btnNewButton.setText("A");
				/**
				 * counting
				 */
				count++;
				counter++;

				/**
				 * if statement if stack is empty add letter. 
				 */
				if (stack.isEmpty()) {
					stack.add("A");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
				/**
				 * else if stack not empty and current letter does not match reset array and set everything not
				 * matched back to original button label.
				*/	
				} else if (stack.peek()!="A") {
					stack.add("A");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton.setText("Button 1");
					matched();
					/**
					 *else it reverts to matched and displays matched, it also writes to the file IO
					 */	
				} else 
				{
					stack.pop();
					points++;

					count = 0;
					btnNewButton.setText("Match");
					btnNewButton_1.setText("Match");
					excludedButtons.add("A");
					/**
					 * writing to file IO
					 */
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();
				}
				/**
				 *Displaying how many matches
				 */
				lblNewLabel_1.setText("Matches: " + points + "      ");
			}
		
			}
		});
		panel.add(btnNewButton);
		
/////////////////////////////////////////////////Button 2 //////// BBBBBBB ///(linked to button1)
		btnNewButton_1 = new JButton("Button 2");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_1.getText()!="Match") {
				btnNewButton_1.setText("A");
				count++;
				counter++;

				if (stack.isEmpty()) {
					stack.add("A");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
	
				} else if (stack.peek()!="A") {
					stack.add("A");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_1.setText("Button 2");	
					matched();
					
				} else
				{
					stack.pop();
					points++;
					count = 0;
					btnNewButton_1.setText("Match");
					btnNewButton.setText("Match");
					excludedButtons.add("A");
					
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();
					

				}
			
				lblNewLabel_1.setText("Matches: " + points + "      ");	
			}
			}
		});
		panel.add(btnNewButton_1);
		
/////////////////////////////////////////////////Button 3////////  (linked with button 7)    /////////////////
		btnNewButton_2 = new JButton("Button 3");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_2.getText()!="Match") {
				btnNewButton_2.setText("D");
				count++;
				counter++;


				if (stack.isEmpty()) {
					stack.add("D");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
			
				} else if (stack.peek()!="D") {
					stack.add("D");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_2.setText("Button 3");
					matched();
				} else {	
					stack.pop();
					points++;

					count = 0;
					btnNewButton_6.setText("Match");
					btnNewButton_2.setText("Match");
					excludedButtons.add("D");
					
					
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();
					


				}
				lblNewLabel_1.setText("Matches: " + points + "      ");
			}
			}
		});
		panel.add(btnNewButton_2);
		
/////////////////////////////////////////////////Button 4 /////////////////////////
		btnNewButton_3 = new JButton("Button 4");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_3.getText()!="Match") {
				btnNewButton_3.setText("E");
				count++;
				counter++;


				if (stack.isEmpty()) {
					stack.add("E");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
				
				} else if (stack.peek()!="E") {
					stack.add("E");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_3.setText("Button 4");
					matched();
				} else {	
					stack.pop();
					points++;

					count = 0;
					btnNewButton_3.setText("Match");
					btnNewButton_5.setText("Match");
					excludedButtons.add("D");
					
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();


				}
				lblNewLabel_1.setText("Matches: " + points + "      ");	
			}
			}
		});
		panel.add(btnNewButton_3);
		
/////////////////////////////////////////////////Button 5 ///////////BBBBB(Linked to button 9)
		btnNewButton_4 = new JButton("Button 5");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_4.getText()!="Match") {

				btnNewButton_4.setText("B");
				count++;
				counter++;


				if (stack.isEmpty()) {
					stack.add("B");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
			
				} else if (stack.peek()!="B") {
					stack.add("B");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_4.setText("Button 5");	
					matched();
//				
				} else 
				{
					stack.pop();
					points++;

					count = 0;
					btnNewButton_8.setText("Match");
					btnNewButton_4.setText("Match");
					excludedButtons.add("B");
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();

				}
				lblNewLabel_1.setText("Matches: " + points + "      ");
			}
				
			}
		}); 
		panel.add(btnNewButton_4); 
		
/////////////////////////////////////////////////Button 6 ////////(linked to button 4 /////////////////
		btnNewButton_5 = new JButton("Button 6");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_5.getText()!="Match") {
				btnNewButton_5.setText("E");
				count++;
				counter++;


				if (stack.isEmpty()) {
					stack.add("E");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
				
				} else if (stack.peek()!="E") {
					stack.add("E");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_5.setText("Button 6");
					matched();
				} else {	
					stack.pop();
					points++;

					count = 0;
					btnNewButton_3.setText("Match");
					btnNewButton_5.setText("Match");
					excludedButtons.add("E");
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();


				}
				lblNewLabel_1.setText("Matches: " + points + "      ");
			}
			}
		});
		panel.add(btnNewButton_5);
		
/////////////////////////////////////////////////Button 7(linked to button 3) //////// /////////////////
		btnNewButton_6 = new JButton("Button 7");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_6.getText()!="Match") {
				btnNewButton_6.setText("D");
				count++;
				counter++;


				if (stack.isEmpty()) {
					stack.add("D");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
				
				} else if (stack.peek()!="D") {
					stack.add("D");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_6.setText("Button 7");
					matched();
				} else {	
					stack.pop();
					points++;

					count = 0;
					btnNewButton_6.setText("Match");
					btnNewButton_2.setText("Match");
					excludedButtons.add("D");
					
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();

				}
				lblNewLabel_1.setText("Matches: " + points + "      ");
			}
			}
		});
		panel.add(btnNewButton_6);
		
/////////////////////////////////////////////////Button 8 ////////(linked to button  11)/////////////////
		btnNewButton_7 = new JButton("Button 8");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_7.getText()!="Match") {
				btnNewButton_7.setText("F");
				count++;
				counter++;


				if (stack.isEmpty()) {
					stack.add("F");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					
				} else if (stack.peek()!="F") {
					stack.add("F");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_7.setText("Button 8");
					matched();
				} else {	
					stack.pop();
					points++;

					count = 0;
					btnNewButton_10.setText("Match");
					btnNewButton_7.setText("Match");
					excludedButtons.add("F");
					
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();


				}
				lblNewLabel_1.setText("Matches: " + points + "      ");
			}
			}
		});
		panel.add(btnNewButton_7);
		
/////////////////////////////////////////////////Button 9 //////// BBBBBBBBB (linked to button 5)
		btnNewButton_8 = new JButton("Button 9");
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_8.getText()!="Match") {

				btnNewButton_8.setText("B");
				count++;
				counter++;


				if (stack.isEmpty()) {
					stack.add("B");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					
				} else if (stack.peek()!="B") {
					stack.add("B");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_8.setText("Button 9");	
					matched();

				} else {
					stack.pop();
					points++;

					count = 0;
					btnNewButton_8.setText("Match");
					btnNewButton_4.setText("Match");
					excludedButtons.add("B");
					
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();

				}
				lblNewLabel_1.setText("Matches: " + points + "      ");
			}
				
			}
		});
		panel.add(btnNewButton_8);
		
/////////////////////////////////////////////////Button 10 //////// (linked to button 12)
		btnNewButton_9 = new JButton("Button 10");
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_9.getText()!="Match") {
				btnNewButton_9.setText("C");
				count++;
				counter++;


				if (stack.isEmpty()) {
					stack.add("C");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					
				} else if (stack.peek()!="C") {
					stack.add("C");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_9.setText("Button 10");
					matched();
				}
				else{
					stack.pop();
					points++;

					count = 0;
					btnNewButton_11.setText("Match");
					btnNewButton_9.setText("Match");
					excludedButtons.add("C");
					
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();
				
				}
				lblNewLabel_1.setText("Matches: " + points + "      ");
			}
			}
		});
		panel.add(btnNewButton_9);
		
/////////////////////////////////////////////////Button 11 ////////(linked to button ) /////////////////
		btnNewButton_10 = new JButton("Button 11");
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_10.getText()!="Match") {
				btnNewButton_10.setText("F");
				count++;
				counter++;
				if (stack.isEmpty()) {
					stack.add("F");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					
				} else if (stack.peek()!="F") {
					stack.add("F");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_10.setText("Button 11");
					matched();
				} else {	
					stack.pop();
					points++;

					count = 0;
					btnNewButton_10.setText("Match");
					btnNewButton_7.setText("Match");
					excludedButtons.add("F");
					
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();


				}
				lblNewLabel_1.setText("Matches: " + points + "      ");
			}
			}
		});
		panel.add(btnNewButton_10);
		
/////////////////////////////////////////////////Button 12 //////// (linked to Button 10)
		btnNewButton_11 = new JButton("Button 12");
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_11.getText()!="Match") {
				btnNewButton_11.setText("C");
				count++;
				counter++;


				if (stack.isEmpty()) {
					stack.add("C");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					
				} else if (stack.peek()!="C") {
					stack.add("C");
					lblNewLabel_2.setText("Letter: " + stack + "     ");
					stack.pop();
					stack.pop();
					btnNewButton_11.setText("Button 12");
					matched();
				} else {	
					stack.pop();
					points++;

					count = 0;
					btnNewButton_11.setText("Match");
					btnNewButton_9.setText("Match");
					excludedButtons.add("C");
					
					write.IO();
					fileIOWrite.addRecords(excludedButtons);
					write.closeFile();
					

				}
				lblNewLabel_1.setText("Matches: " + points + "      ");
			}
			}
		});
		panel.add(btnNewButton_11);

		JLabel lblNewLabel = new JLabel("The Match Game");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);		
		
		splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.SOUTH);
		
		lblNewLabel_3 = new JLabel("");
		splitPane.setRightComponent(lblNewLabel_3);
		
		btnNewButton_12 = new JButton("Check Matched: ");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 *Here is where I read from fileIOread
				 */
				read.openFile();
				lblNewLabel_3.setText(read.openFile());
				read.closeFile();
			}
		});
		btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, 25));
		splitPane.setLeftComponent(btnNewButton_12);
	}
	
	public void matched() {
		if(excludedButtons.isEmpty()) {
			btnNewButton.setText("Button 1");
			btnNewButton_1.setText("Button 2");
			btnNewButton_2.setText("Button 3");
			btnNewButton_6.setText("Button 7");
			btnNewButton_8.setText("Button 9");
			btnNewButton_4.setText("Button 5");
			btnNewButton_9.setText("Button 10");
			btnNewButton_11.setText("Button 12");
			btnNewButton_5.setText("Button 6");
			btnNewButton_3.setText("Button 4");
			btnNewButton_10.setText("Button 11");
			btnNewButton_7.setText("Button 8");
		}else {
			if(!excludedButtons.contains("A")) {
				btnNewButton.setText("Button 1");
				btnNewButton_1.setText("Button 2");
			}
			if(!excludedButtons.contains("D")) {
				btnNewButton_2.setText("Button 3");
				btnNewButton_6.setText("Button 7");
			}
			if(!excludedButtons.contains("B")) {
				btnNewButton_8.setText("Button 9");
				btnNewButton_4.setText("Button 5");
				
			}
			if(!excludedButtons.contains("C")) {
				btnNewButton_9.setText("Button 10");
				btnNewButton_11.setText("Button 12");
			}
			if(!excludedButtons.contains("E")) {
				btnNewButton_5.setText("Button 6");
				btnNewButton_3.setText("Button 4");
			}
			if(!excludedButtons.contains("F")) {
				btnNewButton_10.setText("Button 11");
				btnNewButton_7.setText("Button 8");
			}
		}
		
		
			
	}

}
