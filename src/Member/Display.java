package Member;

import javax.swing.*;

public class Display {

	public static void main(String[] args) {
		JFrame frame = new JFrame("UWork");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,900);
		JButton button1 = new JButton("Navigation Bar");
		JButton button2 = new JButton("Announcements");
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		frame.setVisible(true);
	}

}
