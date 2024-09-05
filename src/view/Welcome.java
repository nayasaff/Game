package view;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Welcome extends JPanel {
	
	private Image backgroundImage;
	private JButton startButton;
	private JTextField nameField;
	private JLabel nameLabel;
	
	public Welcome() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;		
		
		this.setLayout(null);
		//background image
		ImageIcon originalImage = new ImageIcon(getClass().getResource("Welcome.jpeg"));
		 backgroundImage = originalImage.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
		 
		 //Start button
		int buttonWidth = 200;
		int buttonHeight = 70;
		startButton = new JButton("Start");
		startButton.setBackground(Color.decode("#03c04a"));  //color button
		startButton.setForeground(Color.WHITE); //text color
		startButton.setFont(new Font("Arial", Font.BOLD, 20)); //font
		startButton.setFocusPainted(false); //borders around text
		startButton.setBounds(screenWidth - (buttonWidth + 100) , screenHeight - (buttonHeight + 100) , buttonWidth, buttonHeight); // Adjusted for padding
		this.add(startButton);
       startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	handleButtonClicked();
            }
        });
		
		
		//name field
		int fieldWidth = 250;
		int fieldHeight = 25;
		nameField = new JTextField(20);
		nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//nameField.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
		//name labels
		nameLabel = new JLabel("Enter your name");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
		nameLabel.setForeground(Color.black);
		//panel to store field and label
		JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 2)); // Align left with horizontal and vertical gaps
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        
        inputPanel.setBounds(100 , 150, fieldWidth + 50, fieldHeight);
        inputPanel.setOpaque(false); // set background to transparent
        this.add(inputPanel);
	}
	
	private void handleButtonClicked() {
		if(nameField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter your name ");	
			nameField.setBorder(BorderFactory.createLineBorder(Color.decode("#CD3533"), 2));
			nameLabel.setForeground(Color.decode("#CD3533"));
		}
			
		
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
	
}
