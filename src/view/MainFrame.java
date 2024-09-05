package view;
import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
	
	private CardLayout cardLayout;
	public MainFrame() {
        cardLayout = new CardLayout();
        
        Welcome welcomePanel = new Welcome();
        
        JPanel mainPanel = new JPanel(cardLayout);
		ImageIcon icon = new ImageIcon((getClass().getResource("icon.jpeg")));
		
		mainPanel.add(welcomePanel);
		
		this.setContentPane(mainPanel);
		this.setTitle("Empire Building");
		this.setIconImage(icon.getImage());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //frame.setUndecorated(true); // Removes window borders and title bar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public static void main(String [] args) {
		   MainFrame frame = new MainFrame();
			
	}

}
