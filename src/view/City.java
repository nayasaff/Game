package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import engine.Game;

import java.awt.*;

@SuppressWarnings("serial")
public class City extends JPanel {
	
	private Image backgroundImage;
	private JLabel chooseCity;
	private JButton cairo;
	private JButton sparta;
	private JButton rome;
	private String name;
	Game game;
	
	public City(Dimension screenSize) {
		
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		//background image
		ImageIcon originalImage = new ImageIcon(getClass().getResource("map.jpeg"));
		backgroundImage = originalImage.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
		
		this.setLayout(null);
		
		//choose city text
		chooseCity = new JLabel("Choose a city to play with");
		chooseCity.setFont(new Font("Arial", Font.BOLD, 20));
		chooseCity.setForeground(Color.WHITE);
		int labelWidth = chooseCity.getPreferredSize().width;
		int labelHeight = chooseCity.getPreferredSize().height;
		chooseCity.setBounds((screenWidth - labelWidth) / 2, 10, labelWidth, labelHeight);
		
		ActionListener buttonListener = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	initializeGame(e);
				
		    }
		};
		cairo = new JButton("Cairo");
		sparta = new JButton("Sparta");
		rome = new JButton("Rome");
		int buttonWidth = 80;
		int buttonHeight = 55;
		cairo.setBounds(screenWidth/ 4, screenHeight/2 , buttonWidth, buttonHeight); //x and y
		sparta.setBounds(screenWidth /2, screenHeight/4, buttonWidth, buttonHeight);
		rome.setBounds(screenWidth * 5/7 , screenHeight/3, buttonWidth, buttonHeight);
		cairo.setBackground(Color.decode("#03c04a"));
		sparta.setBackground(Color.decode("#03c04a"));
		rome.setBackground(Color.decode("#03c04a"));
		cairo.setForeground(Color.WHITE);
		sparta.setForeground(Color.WHITE);
		rome.setForeground(Color.WHITE);
		cairo.addActionListener(buttonListener);
		sparta.addActionListener(buttonListener);
		rome.addActionListener(buttonListener);
		
		this.add(cairo);
		this.add(sparta);
		this.add(rome);
		this.add(chooseCity);
	}
	
	
	public void initializeGame(ActionEvent e) {
        String buttonText = (String)e.getActionCommand();
		try {
			game = new Game(name, buttonText);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Game getGame() {
		return game;
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
