package Kympu.KympBot.Console;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Kympu.KympBot.Commands.Other.GoogleFetch;

import java.awt.Color;
import javax.swing.JTextArea;

public class mainConsole {

	private JFrame frmKympbotConsole;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainConsole window = new mainConsole();
					window.frmKympbotConsole.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainConsole() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void sendToConsole(){
		GoogleFetch Console = new GoogleFetch();
		//textField.setText("from console"+Console.toConsole());
		//textField.add(null, Console.toConsole());
	}
	
	private void initialize() {
		frmKympbotConsole = new JFrame();
		frmKympbotConsole.setBackground(Color.WHITE);
		frmKympbotConsole.getContentPane().setBackground(Color.BLACK);
		frmKympbotConsole.setTitle("KympBot Console");
		frmKympbotConsole.setBounds(100, 100, 594, 431);
		frmKympbotConsole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		
		JTextArea mainTextArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(frmKympbotConsole.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(mainTextArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(mainTextArea, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
					.addContainerGap())
		);
		frmKympbotConsole.getContentPane().setLayout(groupLayout);
	}
}
