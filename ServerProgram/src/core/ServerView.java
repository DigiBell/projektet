package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerView extends JPanel {
	ServerController controller;
	
	private JTextArea currentInput = new JTextArea();
	private JTextArea currentOutput = new JTextArea();
	 
	private JTextField[] phoneIpAdressField = new JTextField[]{new JTextField("10.2.29.150"), new JTextField("")};
	private JTextField ardIpAdressField = new JTextField("192.168.0.12");
	
	private JLabel inputLabel = new JLabel("INPUT");
	private JLabel outputLabel = new JLabel("INPUT");
	private JLabel[] phoneIpAdressLabel = new JLabel[]{new JLabel("PHONE IP 1: "), new JLabel("PHONE IP 2: ")}; 
	private JLabel ardIpAdressLabel = new JLabel("ARDURINO IP: ");
	
	private JPanel[] phoneIpAdressesPanel = new JPanel[2];
	private JPanel ardIpAdressPanel = new JPanel();
	private JPanel inputPanel = new JPanel();
	private JPanel outputPanel = new JPanel();
	private JPanel ipAdressPanels = new JPanel();
	
	public ServerView(ServerController controller) {
		this.controller = controller;
		
		this.setLayout(new BorderLayout());
		
		for(int i = 0; i < 2; i++) {
			phoneIpAdressesPanel[i] = new JPanel();
			phoneIpAdressesPanel[i].setLayout(new GridLayout(0, 2));
			phoneIpAdressesPanel[i].add(phoneIpAdressLabel[i]);
			phoneIpAdressesPanel[i].add(phoneIpAdressField[i]);
			ipAdressPanels.add(phoneIpAdressesPanel[i]);
		}
		
		ardIpAdressPanel.setLayout(new GridLayout(0, 2));
		ardIpAdressPanel.add(ardIpAdressLabel);
		ardIpAdressPanel.add(ardIpAdressField);
		
		ipAdressPanels.add(ardIpAdressPanel);
		
		inputPanel.setLayout(new GridLayout(2, 0));
		inputPanel.add(inputLabel);
		inputPanel.add(currentInput);
		currentInput.setPreferredSize(new Dimension(250, 200));
		
		outputPanel.setLayout(new GridLayout(2, 0));
		outputPanel.add(outputLabel);
		outputPanel.add(currentOutput);
		currentOutput.setPreferredSize(new Dimension(250, 200));
		
		this.add(ipAdressPanels, BorderLayout.NORTH);
		
		this.add(inputPanel, BorderLayout.EAST);
		this.add(outputPanel, BorderLayout.WEST);
	}
}
