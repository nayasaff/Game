package view;
import javax.swing.*;
import engine.Game;
import java.awt.*;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private CardLayout cardLayout;
	private Game game;
	
	public MainFrame() {
        cardLayout = new CardLayout();
        
        ImageIcon icon = new ImageIcon((getClass().getResource("icon.jpeg")));
		this.setTitle("Empire Building");
		this.setIconImage(icon.getImage());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		JPanel mainPanel = new JPanel(cardLayout);
		City cityPanel = new City(screenSize);
        Welcome welcomePanel = new Welcome(screenSize, cardLayout, cityPanel);
        
		mainPanel.add(welcomePanel, "welcomePanel");
		mainPanel.add(cityPanel, "cityPanel");
		
        //frame.setUndecorated(true); // Removes window borders and title bar
		this.add(mainPanel);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

	
	public static void main(String [] args) {
		   MainFrame frame = new MainFrame();
			
	}

}
