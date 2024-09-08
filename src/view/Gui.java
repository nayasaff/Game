package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.City;
import engine.Game;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.FriendlyFireException;
import exceptions.MaxCapacityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;

public class Gui implements ActionListener, ItemListener, ListSelectionListener {
	private JFrame frame;
//	private JButton start;
//	private JTextArea name;
//	private JPanel panel1;
//	private JLabel name2;
//	private JLabel mapimg;
//	private JButton sparta;
//	private JButton cairo;
//	private JButton rome;
	private Game game;
	private JLabel cityimg;
	private JPanel panel2;
	private JLabel gold;
	private JLabel food;
	private JLabel username;
	private JLabel turn;
	private JButton build;
	private String city;
	private JButton archeryrange;
	private JButton farm;
	private JButton market;
	private JButton barracks;
	private JButton stable;
	private JButton endturn;
	private JLabel infoimg;
	private JTextArea buildinginfo;
	private JTextArea unitInfo2;
	private JButton upgradea;
	private JButton upgradeb;
	private JButton upgrades;
	private JButton upgradef;
	private JButton upgradem;	
	private JButton recruit;
	private JButton back;
	private JComboBox<String> unitInfo;
	private JButton unit;
	private JButton initiatearmy;
	private JButton army;
	private JTextArea idle;
	private JTextArea marching;
	private JTextArea beisiging;
	private JLabel armyimg;
	private JButton rome2;
	private JButton cairo2;
	private JButton sparta2;
	private JButton map;
	private JButton laysiege;
	private JButton attack;
	private JLabel battleimg;
	private JTextArea unit2;
	private JLabel unitimg;
	private JButton attack2;
	private JButton next;
	private JButton autoresolve;
	private JList<String> controlledcities2;
	private City targetcity;
	private JButton locateunit;
	private JButton defendingarmy;
	private JLabel defendingimg;
	private JTextArea defendingInfo;
	private JComboBox<String> enemyunit;
	private JTextArea enemyinfo;
	private JButton recruit2;
	private JButton build2;
	private JButton unit3;
	private JTextArea unitInfo3;
	private JComboBox<String> info3;
	private ImageIcon icon;
	private JButton defendingarmy2;

	
	public Gui() {
		frame = new JFrame();
		

		rome2 = new JButton("Rome");
		cairo2 = new JButton("Cairo");
		sparta2 = new JButton("Sparta");
		cityimg = new JLabel(new ImageIcon(getClass().getResource("city.jpeg")));
		panel2 = new JPanel();
		build = new JButton("Build");
		build2 = new JButton("Build");
		archeryrange = new JButton(new ImageIcon(getClass().getResource("b3.jpeg")));
		stable = new JButton(new ImageIcon(getClass().getResource("b5.jpeg")));
		barracks = new JButton(new ImageIcon(getClass().getResource("b2.jpeg")));
		farm = new JButton(new ImageIcon(getClass().getResource("b4.jpeg")));
		market = new JButton(new ImageIcon(getClass().getResource("b6.jpeg")));
		username = new JLabel("");
	    food = new JLabel("");
		gold = new JLabel("");
		turn = new JLabel("");
		endturn = new JButton("End Turn");
		infoimg = new JLabel(new ImageIcon(getClass().getResource("buildinfo.jpeg")));
		buildinginfo = new JTextArea("");
		unitInfo2 = new JTextArea("");
		upgradea = new JButton("Upgrade");
		upgradeb = new JButton("Upgrade");
		upgrades = new JButton("Upgrade");
		upgradef = new JButton("Upgrade");
		upgradem = new JButton("Upgrade");
		recruit = new JButton("Recruit");
		recruit2 = new JButton("Recruit");
		back = new JButton("Back");
		unit = new JButton("Unit");
		unit3 = new JButton("Unit");
		initiatearmy = new JButton("Initiate Army");
		army = new JButton("Army");
		idle = new JTextArea("");
		marching = new JTextArea("");
		beisiging = new JTextArea("");
		armyimg = new JLabel(new ImageIcon(getClass().getResource("armyinfo.jpeg")));
		map = new JButton("Map");
		laysiege = new JButton("Lay Siege");
		attack = new JButton("Attack");
		try {
			game = new Game("", "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		battleimg = new  JLabel(new ImageIcon(getClass().getResource("battle.jpeg")));
		attack2 = new JButton("Attack");
		unit2 = new JTextArea();
		unitimg = new JLabel(new ImageIcon(getClass().getResource("unitinfo.jpeg")));
		next = new JButton("Next");
		autoresolve = new JButton("Auto\nResolve");
		unitInfo = new JComboBox<String>(units());	
		unitInfo.setLayout(null);
		targetcity = new City("");
		controlledcities2 = new JList<String>();
		locateunit = new JButton("Relocate Unit");
		defendingarmy = new JButton("Defending\nArmy");
		defendingimg = new JLabel(new ImageIcon(getClass().getResource("armyInfo2.jpeg")));
		defendingInfo = new JTextArea("");
		enemyunit = new JComboBox<String>(units());
		enemyinfo = new JTextArea("");
		unitInfo3 = new JTextArea("");
		info3 = new JComboBox<String>(units());
		icon = new ImageIcon((getClass().getResource("icon.jpeg")));
		defendingarmy2 = new JButton("Defending\nArmy");		
		
		
//		start.setLayout(null);
//		name.setLayout(null);
//		panel1.setLayout(null);
//		name2.setLayout(new FlowLayout());
//		cairo.setLayout(null);
//		rome.setLayout(null);
//		sparta.setLayout(null);
		cairo2.setLayout(null);
		rome2.setLayout(null);
		sparta2.setLayout(null);
		panel2.setLayout(new GridLayout(4,1));  
		archeryrange.setLayout(null);
		stable.setLayout(null);
		barracks.setLayout(null);
		farm.setLayout(null);
		build2.setLayout(null);
		market.setLayout(null);
		endturn.setLayout(null);
		buildinginfo.setLayout(null);
		unitInfo2.setLayout(null);
		upgradea.setLayout(null);
		upgradeb.setLayout(null);
		upgrades.setLayout(null);
		upgradef.setLayout(null);
		upgradem.setLayout(null);
		recruit.setLayout(null);
		recruit2.setLayout(null);
		back.setLayout(null);
		unit.setLayout(null);
		unit3.setLayout(null);
		initiatearmy.setLayout(null);
		army.setLayout(null);
		idle.setLayout(null);
		marching.setLayout(null);
		beisiging.setLayout(null);
		map.setLayout(null);
		laysiege.setLayout(null);
		attack.setLayout(null);
		attack2.setLayout(null);
		unit2.setLayout(null);
		next.setLayout(null);
		autoresolve.setLayout(null);
		locateunit.setLayout(null);
		defendingarmy.setLayout(null);
		defendingInfo.setLayout(null);
		enemyunit.setLayout(null);
		enemyinfo.setLayout(null);
		info3.setLayout(null);
		defendingarmy2.setLayout(null);
		
	
		controlledcities2.setLayout(null);
		controlledcities2.setBounds(1100, 200, 200, 100);
		controlledcities2.setVisibleRowCount(2);
		controlledcities2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
			
	
				

		cairo2.setBounds(150, 200, 80, 55);
		sparta2.setBounds(850, 100, 80, 55);
		rome2.setBounds(560, 200, 80, 55);
		panel2.setBounds(1100, 0, 200, 200);
		build.setBounds(15, 25, 100, 50);
		build2.setBounds(15, 25, 100, 50);
		unitInfo.setBounds(0,0,120, 30);
		defendingarmy.setBounds(150, 25, 100, 50);
		defendingarmy2.setBounds(150, 25 ,100, 50);
		archeryrange.setBounds(600,450, 106,91);
		stable.setBounds(200,450, 96, 86);
		barracks.setBounds(480, 380, 108, 90);
		farm.setBounds(400,450, 81,89);
		market.setBounds(700, 400, 58, 84);
		endturn.setBounds(1100 ,505, 150, 80);
		buildinginfo.setBounds(380, 200, 480, 280);
		unitInfo2.setBounds(380, 200, 480, 280);
		info3.setBounds(380, 200, 480, 280);
		upgradea.setBounds(520, 450, 150, 70);
		upgrades.setBounds(520, 450, 150, 70);
		upgradeb.setBounds(520, 450, 150, 70);
		upgradef.setBounds(520, 450, 150, 70);
		upgradem.setBounds(520, 450, 150, 70);
		recruit.setBounds(15, 350, 100, 50);
		recruit2.setBounds(15, 350, 100, 50);
		back.setBounds(20, 555, 100, 50);
		unit.setBounds(15, 200, 100, 50);
		unit3.setBounds(15,200 , 100, 50);
		initiatearmy.setBounds(520, 480, 150,75);
		army.setBounds(15, 100, 100, 50);
		idle.setBounds(440, 200, 120, 280);
		marching.setBounds(560, 200, 120, 280);
		beisiging.setBounds(680, 200, 120, 280);
		map.setBounds(15, 555, 100, 50);
		laysiege.setBounds(15,420, 100, 50);
		attack.setBounds(15, 490, 100, 50);
		unit2.setBounds(0,30, 150, 115);
		attack2.setBounds(1100, 550, 150, 70);
		next.setBounds(1100, 450, 150, 70);
		autoresolve.setBounds(15, 280,100, 50 );
		locateunit.setBounds(520, 450, 150, 70);
		defendingInfo.setBounds(380, 200, 480, 280);
		enemyunit.setBounds(1160, 0, 120, 30);
		enemyinfo.setBounds(1120, 30, 150, 115);

		
		
		
		buildinginfo.setEditable(false);
		unitInfo2.setEditable(false);
		idle.setEditable(false);
		marching.setEditable(false);
		beisiging.setEditable(false);
		laysiege.setVisible(false);
		attack.setVisible(false);
		autoresolve.setVisible(false);
		unit2.setEditable(false);
		panel2.setBackground(Color.WHITE);
		controlledcities2.setFont(new Font(null, 0, 24));
		defendingInfo.setEditable(false);
		enemyinfo.setEditable(false);
		buildinginfo.setFont(new Font(null, 0, 16));
		unitInfo2.setFont(new Font(null, 0, 16));


	
		

		build.addActionListener(this);
		endturn.addActionListener(this);
		archeryrange.addActionListener(this);
		stable.addActionListener(this);
		barracks.addActionListener(this);
		farm.addActionListener(this);
		market.addActionListener(this);
		upgradea.addActionListener(this);
		upgrades.addActionListener(this);
		upgradeb.addActionListener(this);
		upgradef.addActionListener(this);
		upgradem.addActionListener(this);
		recruit.addActionListener(this);
		back.addActionListener(this);
		unit.addActionListener(this);
		initiatearmy.addActionListener(this);
		army.addActionListener(this);
		cairo2.addActionListener(this);
		rome2.addActionListener(this);
		sparta2.addActionListener(this);
		map.addActionListener(this);
		laysiege.addActionListener(this);
		attack.addActionListener(this);
		attack2.addActionListener(this);
		next.addActionListener(this);
		autoresolve.addActionListener(this);
		unitInfo.addItemListener(this);
		locateunit.addActionListener(this);
		defendingarmy.addActionListener(this);
		enemyunit.addItemListener(this);
		controlledcities2.addListSelectionListener(this);
		recruit2.addActionListener(this);
		build2.addActionListener(this);
		unit3.addActionListener(this);
		defendingarmy2.addActionListener(this);
		info3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				display3(info3.getSelectedIndex());
				
			}
			
		}
				
		);
		

		infoimg.add(upgradea);
		infoimg.add(upgrades);
		infoimg.add(upgradeb);
		infoimg.add(upgradef);
		infoimg.add(upgradem);
		frame.setTitle("Empire Building");
		frame.setIconImage(icon.getImage());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//        frame.pack();
        //frame.setUndecorated(true); // Removes window borders and title bar
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    BufferedImage bufferedImage;
		try {
		    bufferedImage = ImageIO.read(getClass().getResource("Welcome.jpeg"));
		    // Create a JLabel
		    JLabel imageLabel = new JLabel() {
		        @Override
		        protected void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            // Scale the image to fit the JLabel's size
		            Image scaledImage = bufferedImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		            g.drawImage(scaledImage, 0, 0, this);
		        }
		    };
		
		    // Add a ComponentListener to resize the image when the frame is resized
		    frame.addComponentListener(new java.awt.event.ComponentAdapter() {
		        @Override
		        public void componentResized(java.awt.event.ComponentEvent e) {
		            imageLabel.repaint();
		        }
		    });
		
		    frame.add(imageLabel);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    

	}
	
	
	@SuppressWarnings("unused")
	public static void main(String [] args) {
		   Gui gui = new Gui();
			
	}


	
	public void actionPerformed(ActionEvent e) {

		String buildings[] = {"ArcheryRange", "Barracks", "Stable", "Farm" ,"Market"};
		if(e.getSource() == build) {
			int n = JOptionPane.showOptionDialog(frame, "ArcheryRange 1500, Barracks 2000, Stable 2500, Farm 1000, Market 1500", "Choose a building to build", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buildings, buildings[0]);
			try {
				if(n != -1) {
				  game.getPlayer().build(buildings[n], game.getPlayer().getControlledCities().get(0).getName());
				  city();
				}
			} catch (NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage());
	
			}
		
	
		}
		
		if(e.getSource() == build2) {
			int n = JOptionPane.showOptionDialog(frame, "ArcheryRange 1500, Barracks 2000, Stable 2500, Farm 1000, Market 1500", "Choose a building to build", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buildings, buildings[0]);
			if(n != -1) {
				try {
					game.getPlayer().build(buildings[n], game.getPlayer().getControlledCities().get(1).getName());
					city2();
				} catch (NotEnoughGoldException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
					
				}
			}
	
		}
		
		if(e.getSource() == endturn) {
				game.endTurn();
				updateEndturn();
				if(game.getPlayer().getControlledCities().size() == 3) {
					frame.dispose();
					JOptionPane.showMessageDialog(null, "Congrats you have won");
				}	
			
		}
		if(e.getSource() == barracks) {
			frame.setContentPane(infoimg);
			buildingsInfo("barracks");			
			frame.add(buildinginfo);
			frame.add(panel2);
			frame.add(back);
			frame.revalidate();
		}
		if(e.getSource() == stable) {
			frame.setContentPane(infoimg);
			buildingsInfo("stable");			
			frame.add(buildinginfo);
			frame.add(back);
			frame.add(panel2);
			frame.revalidate();
		}
		if(e.getSource() == archeryrange) {
			frame.setContentPane(infoimg);
			buildingsInfo("archeryrange");			
			frame.add(buildinginfo);
			frame.add(back);
			frame.add(panel2);
			frame.revalidate();
		}		
		if(e.getSource() == farm) {
			frame.setContentPane(infoimg);
			buildingsInfo("farm");			
			frame.add(buildinginfo);
			frame.add(back);
			frame.add(panel2);
			frame.revalidate();
		}
		if(e.getSource() == market) {
			frame.setContentPane(infoimg);
			buildingsInfo("market");			
			frame.add(buildinginfo);
			frame.add(back);
			frame.add(panel2);
            frame.revalidate();
		}
		if(e.getSource() == upgradea) {
			try {
				game.getPlayer().upgradeBuilding(getbuilding("a"));
			} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage());
			}
			buildingsInfo("archeryrange");			
		}	
		if(e.getSource() == upgradeb) {
			try {
				game.getPlayer().upgradeBuilding(getbuilding("b"));
			} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage());
			}
			buildingsInfo("barracks");
		}		
		if(e.getSource() == upgrades) {
			try {
				game.getPlayer().upgradeBuilding(getbuilding("s"));
			} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage());
			}
			buildingsInfo("stable");			
		}		
		if(e.getSource() == upgradef) {
			try {
				game.getPlayer().upgradeBuilding(getbuilding2("f"));
			} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage());
			}
			buildingsInfo("farm");			
		}
		if(e.getSource() == upgradem) {
			try {
				game.getPlayer().upgradeBuilding(getbuilding2("m"));
			} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage());
			}
			buildingsInfo("market");			
		}
	
		String[]units = {"Archer", "Cavalry", "Infantry"};
		
		if(e.getSource() == recruit) {
			int x = JOptionPane.showOptionDialog(frame, recruitcost(), "Choose unit to recruit", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, units, "Archer");
			try {
				if(x != -1) {
				  game.getPlayer().recruitUnit(units[x], city);
				}
				updateEndturn();
			} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage());
			}
		}
	
		if(e.getSource() == recruit2) {
			int x = JOptionPane.showOptionDialog(frame, recruitcost(), "Choose unit to recruit", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, units, "Archer");
			if(x != -1) {
				try {
					game.getPlayer().recruitUnit(units[x], game.getPlayer().getControlledCities().get(1).getName());
				} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}
			}

		}
		
		if(e.getSource() == back)
			city();
		
		if(e.getSource() == unit) {
			information();
		
		}
		
		if(e.getSource() == unit3) {
			frame.setContentPane(new JLabel(new ImageIcon(getClass().getResource("armyinfo.jpeg")) ));
			frame.add(back);
			frame.add(unitInfo3);
			frame.revalidate();
		}
		
		
		if(e.getSource() == army) {
			frame.setContentPane(armyimg);
			frame.add(back);
			frame.add(locateunit);
			frame.add(idle);
			frame.add(marching);
			frame.add(beisiging);
			frame.add(panel2);
			armyInfo();
			frame.revalidate();
		}
		
		
	try {
		if(e.getSource() == initiatearmy) {
			unitInfo2.setText("");
			game.getPlayer().initiateArmy(game.getPlayer().getControlledCities().get(0), game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(unitInfo.getSelectedIndex()) );
			display(unitInfo.getSelectedIndex());
		}
	}
	catch(IndexOutOfBoundsException s) {
		
	}
		ArrayList<JButton> cities = new ArrayList<JButton>();
		cities.add(rome2); cities.add(cairo2); cities.add(sparta2);	
		if(e.getSource() == map) {
//			frame.setContentPane(mapimg);
//			frame.add(panel2);
//			cairo.setVisible(false);
//			sparta.setVisible(false);
//			rome.setVisible(false);
			frame.add(rome2);
			frame.add(cairo2);
			frame.add(sparta2);
			for(int i =0; i < cities.size(); i++) {
				for(int j = 0; j < game.getPlayer().getControlledCities().size(); j++) {
					if(game.getPlayer().getControlledCities().get(j).getName().toLowerCase().equals(cities.get(i).getText().toLowerCase()))
						frame.remove(cities.get(i));
				}
					
				
					
			}
			frame.add(back);
		}
	try {	
		if(e.getSource() == rome2 || e.getSource() == sparta2 || e.getSource() == cairo2) {
			game.targetCity(targetArmy(), (String)e.getActionCommand());
			targetcity = getcity((String)e.getActionCommand());
		}
	}
	catch(IndexOutOfBoundsException d) {
		
	}
	catch(NullPointerException d) {
		
	}

		for(int i =0; i < game.getPlayer().getControlledArmies().size(); i++) {
			if(game.getPlayer().getControlledArmies().get(i).getDistancetoTarget() == 0) {
				laysiege.setVisible(true);
				attack.setVisible(true);
			}
		}
		try {
		if(e.getSource() == laysiege) {
			try {
				game.getPlayer().laySiege(rightArmy(), targetcity);
			} catch (TargetNotReachedException | FriendlyCityException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMessage());
			}
		}
		}
		catch(NullPointerException f) {
			
		}
	
		if(e.getSource() == attack) {
			frame.setContentPane(battleimg);
			frame.add(unitInfo);
			frame.add(unit2);
			frame.add(attack2);
			frame.add(enemyinfo);
			frame.add(enemyunit);
			frame.add(next);
			frame.revalidate();
		}
		try {
		int r1 = (int)(Math.random() * targetcity.getDefendingArmy().getUnits().size());
		int soldier = targetcity.getDefendingArmy().getUnits().get(r1).getMaxSoldierCount() - targetcity.getDefendingArmy().getUnits().get(r1).getCurrentSoldierCount();
		if(e.getSource() == attack2) {
			if(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().size() >= unitInfo.getSelectedIndex()) {
				try {
					game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(unitInfo.getSelectedIndex()).attack(targetcity.getDefendingArmy().getUnits().get(r1));
					JOptionPane.showMessageDialog(frame, "The enemy has lost " + soldier + " soldiers from unit " + (r1+1) + "\nCurrent Soldier " + targetcity.getDefendingArmy().getUnits().get(r1).getCurrentSoldierCount());
					if(check())
						city();
				} catch (FriendlyFireException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
					city();
				}
			}
			attack2.setEnabled(false);
		    next.setEnabled(true);
		}
		}
		catch(IndexOutOfBoundsException a) {
	

		}
		
		try {
			int r2 = (int)(Math.random() * game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().size());
			int soldier2 = game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(r2).getMaxSoldierCount() - game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(r2).getCurrentSoldierCount();
			
			if(e.getSource() == next) {
				try {
					targetcity.getDefendingArmy().getUnits().get( (int)(Math.random() * targetcity.getDefendingArmy().getUnits().size())).attack(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(r2) );
					JOptionPane.showMessageDialog(frame, "You have lost " + soldier2 + " soldiers from unit " + (r2+1) + "\nCurrent Soldier " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(r2).getCurrentSoldierCount());
					if(check())
						city();
				} catch (FriendlyFireException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
					city();
				}
				attack2.setEnabled(true);
				next.setEnabled(false);
			}
		}
		catch(IndexOutOfBoundsException a) {
		}
		
	   for(int i =0; i < game.getAvailableCities().size(); i++) {
		   if(game.getAvailableCities().get(i).getTurnsUnderSiege() == 3) {
			   autoresolve.setVisible(true);
		   }
		   
	   }
	   
	   if(e.getSource() == autoresolve) {
		   try {
			game.autoResolve(game.getPlayer().getControlledCities().get(0).getDefendingArmy(), targetcity.getDefendingArmy());
			message();
			

		} catch (FriendlyFireException e1) {
			JOptionPane.showMessageDialog(frame, e1.getMessage());
		}  
 
	   }
	   
	   try {
		   if(e.getSource() == locateunit)
		   try {
			game.getPlayer().getControlledCities().get(0).getDefendingArmy().relocateUnit(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(0));
		} catch (MaxCapacityException e1) {
			JOptionPane.showMessageDialog(frame, e1.getMessage());
		}
	   }
	   catch(IndexOutOfBoundsException s) {
		   
	   }
	   
	   if(e.getSource() == defendingarmy) {
		   frame.setContentPane(defendingimg);
		   frame.add(defendingInfo);
		   defendingarmyy();
		   frame.add(back);
		   frame.revalidate();
	   }
	   
	   if(e.getSource() == defendingarmy2) {
		   frame.setContentPane(defendingimg);
		   frame.add(defendingInfo);
		   defendingarmyy2();
		   frame.add(back);
		   frame.revalidate();
	   }
	   if(frame.getContentPane() == battleimg) {
		   try {
			   if(check())
				   city();
		   }
		   catch(Exception error){
			   
		   }
	   }

	}
	
	
	private City getcity(String actionCommand) {
		for(int i =0 ;i < game.getAvailableCities().size(); i++) {
			if(game.getAvailableCities().get(i).getName().toLowerCase().equals(actionCommand.toLowerCase()))
				return game.getAvailableCities().get(i);
		}
		return null;
	}


	public void city() {
		
		username.setText("Naya");
		food.setText("Food :" + game.getPlayer().getFood());
		gold.setText("Gold : " + game.getPlayer().getTreasury());
		turn.setText("Turn : " + game.getCurrentTurnCount());
		username.setFont(new Font(null, 0, 24));
		food.setFont(new Font(null, 0, 24));
		gold.setFont(new Font(null, 0, 24));
		turn.setFont(new Font(null, 0, 24));
		
		
		panel2.add(username);
		panel2.add(food);
		panel2.add(gold);
		panel2.add(turn);
		
		frame.setContentPane(cityimg);
		
			for(int j =0; j < game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().size();j++) {
				if(game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j) instanceof ArcheryRange)
					frame.add(archeryrange);
				if(game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j) instanceof Stable)
					frame.add(stable);
				if(game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j) instanceof Barracks)
					frame.add(barracks);
			}
		
		
	
			for(int j = 0; j < game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().size(); j++) {
				if(game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j) instanceof Farm)
					frame.add(farm);
				if(game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j) instanceof Market)
					frame.add(market);
			}
		
		frame.add(recruit);
		frame.add(endturn);
		frame.add(panel2);
		frame.add(unit);
		frame.add(map);
		frame.add(defendingarmy);
		frame.add(laysiege);
		frame.add(attack);
		frame.add(build);
		frame.add(army);
		frame.add(autoresolve);
		frame.add(controlledcities2);

		frame.revalidate();
	}
	
	public void city2() {
		frame.setContentPane(new JLabel(new ImageIcon(getClass().getResource("city2.jpeg"))) );
		
		for(int j =0; j < game.getPlayer().getControlledCities().get(1).getMilitaryBuildings().size();j++) {
			if(game.getPlayer().getControlledCities().get(1).getMilitaryBuildings().get(j) instanceof ArcheryRange)
				frame.add(archeryrange);
			if(game.getPlayer().getControlledCities().get(1).getMilitaryBuildings().get(j) instanceof Stable)
				frame.add(stable);
			if(game.getPlayer().getControlledCities().get(1).getMilitaryBuildings().get(j) instanceof Barracks)
				frame.add(barracks);
		}
	
	

		for(int j = 0; j < game.getPlayer().getControlledCities().get(1).getEconomicalBuildings().size(); j++) {
			if(game.getPlayer().getControlledCities().get(1).getEconomicalBuildings().get(j) instanceof Farm)
				frame.add(farm);
			if(game.getPlayer().getControlledCities().get(1).getEconomicalBuildings().get(j) instanceof Market)
				frame.add(market);
		}		
		frame.add(panel2);
		frame.add(controlledcities2);
		frame.add(map);
		frame.add(army);
		frame.add(defendingarmy2);
		frame.add(recruit2);
		frame.add(unit3);
		frame.add(build2);
		frame.add(endturn);
		frame.revalidate();
		
		
	}
	
	
	public void updateEndturn() {
		food.setText("Food : " + game.getPlayer().getFood());
		gold.setText("Gold : " + game.getPlayer().getTreasury());
		turn.setText("Turn : " + game.getCurrentTurnCount());
		if(game.getCurrentTurnCount() == 50) {
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Game over");
		}
		
	}
	
	public void buildingsInfo(String type) {

		
		buildinginfo.setText(type);
		
		
			for(int j =0 ; j < game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().size(); j++) {
				if(game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j) instanceof ArcheryRange && type.equals("archeryrange")) {
					buildinginfo.setText("Archery Range\n" +"Level : " + game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j).getLevel() +  "\nRecruitment Cost : " + game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j).getRecruitmentCost() + "\nUpgrade Cost : " + game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j).getUpgradeCost());

					upgrades.setVisible(false);
					upgradeb.setVisible(false);
					upgradem.setVisible(false);
					upgradef.setVisible(false);
					upgradea.setVisible(true);
				}	
				if(game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j) instanceof Stable && type.equals("stable")) {
					buildinginfo.setText("Stable\n" + "Level : " + game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j).getLevel() +  "\nRecruitment Cost : " + game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j).getRecruitmentCost() + "\nUpgrade Cost : " + game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j).getUpgradeCost());
					upgrades.setVisible(true);
					upgradea.setVisible(false);
					upgradeb.setVisible(false);
					upgradem.setVisible(false);
					upgradef.setVisible(false);
				}
				if(game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j) instanceof Barracks && type.equals("barracks")) {
					buildinginfo.setText("Barracks\n" + "Level : " + game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j).getLevel() + "\nRecruitment Cost : " + game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j).getRecruitmentCost() + "\nUpgrade Cost : " + game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j).getUpgradeCost());
					upgradeb.setVisible(true);
					upgradea.setVisible(false);
					upgrades.setVisible(false);
					upgradem.setVisible(false);
					upgradef.setVisible(false);
				}				
			}
			for(int j =0; j < game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().size(); j++) {
				if(game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j) instanceof Farm && type.equals("farm")) {
					buildinginfo.setText("Farm" +"\nLevel : " + game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j).getLevel()  + "\nUpgrade Cost : " + game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j).getUpgradeCost());
					upgradef.setVisible(true);
					upgradea.setVisible(false);
					upgrades.setVisible(false);
					upgradeb.setVisible(false);
					upgradem.setVisible(false);
				}
				if(game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j) instanceof Market && type.equals("market")) {
					buildinginfo.setText("Market" + "\nLevel : " + game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j).getLevel() + "\nUpgrade Cost : " + game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j).getUpgradeCost());	
					upgradem.setVisible(true);
					upgradea.setVisible(false);
					upgrades.setVisible(false);
					upgradeb.setVisible(false);
					upgradef.setVisible(false);
				}	
			}
		



		
		
	}
	
	public MilitaryBuilding getbuilding(String b) {
		MilitaryBuilding a = null;
	
			for(int j =0; j < game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().size(); j++) {
				if(game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j) instanceof ArcheryRange && b.equals("a"))
					a = game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j);
				if(game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j) instanceof Stable && b.equals("s"))
					a = game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j);
				if(game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j) instanceof Barracks && b.equals("b"))
					a = game.getPlayer().getControlledCities().get(0).getMilitaryBuildings().get(j);				
			}
		
		return a;
	}
	
	public EconomicBuilding getbuilding2(String b) {
		EconomicBuilding a = null;
			for(int j = 0; j < game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().size(); j++) {
				if(game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j) instanceof Farm && b.equals("f"))
					a = game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j);
				if(game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j) instanceof Market && b.equals("m"))
					a = game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().get(j);
			}
		
		return a;
		
	}
	
	public String recruitcost() {
		String s = "";
		for(int i =0 ;i < game.getPlayer().getControlledCities().size(); i++) {
			for(int j =0; j < game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size(); j++) {
				if(game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof ArcheryRange)
					s += "Archer : " + game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getRecruitmentCost() + "\n";
				if(game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Barracks)
					s += "Infantry : " +game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getRecruitmentCost() + "\n";
				if(game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Stable)
					s += "Cavalry : " + game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getRecruitmentCost() + "\n";
			}
		}
		return s;
	}
	
	public String[] units() {
		String[] arr = new String[50];
		int x = 1;
		for(int i =0; i < arr.length; i++) {
			arr[i] = "" + x;
			x++;
		}
		return arr;
	}

	public void display(int n) {
		unitInfo2.setText("");
		unit2.setText("");
		if(n == -1 || game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().size() <= n)
			return;

			if(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n) instanceof Archer) {
			   unitInfo2.setText("Archer\n" + "Level : " +  game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getMaxSoldierCount());
			   unit2.setText("Archer\n" + "Level : " +  game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getMaxSoldierCount());
			} 
			if(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n) instanceof Cavalry) {
				unitInfo2.setText("Cavalry\n" + "Level : " +  game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getMaxSoldierCount());
				 unit2.setText("Cavalry\n" + "Level : " +  game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getMaxSoldierCount());
			}
			if(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n) instanceof Infantry) {
				unitInfo2.setText("Infantry\n" + "Level : " +  game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getMaxSoldierCount()) ;
				unit2.setText("Infantry\n" + "Level : " +  game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().get(n).getMaxSoldierCount());
			}
		
	}
	public void armyInfo() {
		String idle2 = "Idle\n";
		String marching2 = "Marching\n";
		String besiging = "Besieging\n";
		int x = 1;
		for(int i =0; i < game.getPlayer().getControlledArmies().size(); i++) {
			if(game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.IDLE) {
				idle2 += "Army " +  x + "\n"  + "Loacation : " + game.getPlayer().getControlledArmies().get(i).getCurrentLocation() + "\nTarget : " + game.getPlayer().getControlledArmies().get(i).getTarget() + "\n"; 
				x++;
			}
			if(game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.MARCHING)
				marching2 += "Target : " + game.getPlayer().getControlledArmies().get(i).getTarget() +"\nDistance : " + game.getPlayer().getControlledArmies().get(i).getDistancetoTarget() + "\n";
			if(game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.BESIEGING)
				besiging += "Location : " + game.getPlayer().getControlledArmies().get(i).getCurrentLocation() + "\nTurn " + undersige().getTurnsUnderSiege();
		}
		
		idle.setText(idle2);
		marching.setText(marching2);
		beisiging.setText(besiging);
		
	}
	public City targetcity() {
		City c = game.getAvailableCities().get(0);
		for(int i =0; i < game.getAvailableCities().size(); i++) {
			if(game.getPlayer().getControlledArmies().size() >= 1  && game.getPlayer().getControlledArmies().get(0).getCurrentLocation().toLowerCase().equals(game.getAvailableCities().get(i).getName().toLowerCase()))
				c = game.getAvailableCities().get(i);
		}
		return c;
	}
	public City undersige() {
		City c = game.getAvailableCities().get(0);
		for(int i =0; i < game.getAvailableCities().size(); i++) {
			if(game.getAvailableCities().get(i).isUnderSiege())
				c = game.getAvailableCities().get(i);
		}
		return c;
	}
	public boolean check() {
		if(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().size() ==0) {
			JOptionPane.showMessageDialog(frame, "You have lost");
			return true;
		}
		else if(targetcity.getDefendingArmy().getUnits().size() == 0 ) {
			JOptionPane.showMessageDialog(frame, "You have won");
			game.occupy(rightArmy(), targetcity.getName());
			String control [] = new String[3];

			for(int i =0; i < game.getPlayer().getControlledCities().size(); i++) {
				control[i] = game.getPlayer().getControlledCities().get(i).getName();
			}
			controlledcities2.setListData(control);
			return true;
		}	
		else
			return false;
	}

	public void message() {
		if(game.getPlayer().getControlledCities().get(0).getDefendingArmy().getUnits().size() == 0)
			JOptionPane.showMessageDialog(frame, "You have lost ");
		if(targetcity.getDefendingArmy().getUnits().size() == 0) {
			JOptionPane.showMessageDialog(frame, "You have won");
			String control [] = new String[3];

			for(int i =0; i < game.getPlayer().getControlledCities().size(); i++) {
				control[i] = game.getPlayer().getControlledCities().get(i).getName();
			}
			controlledcities2.setListData(control);

			
		}	
	}
	



	
	public void itemStateChanged(ItemEvent e) {
		display(unitInfo.getSelectedIndex());
		display2(enemyunit.getSelectedIndex());
	}
	
	public void information() {
		frame.setContentPane(unitimg);
		frame.add(unitInfo2);
		frame.add(back);
		frame.add(unitInfo);
		frame.add(panel2);
		frame.add(initiatearmy);
		frame.revalidate();
	}
	
	public Army rightArmy() {
		Army a = game.getPlayer().getControlledArmies().get(0);
		for(int i =0; i < game.getPlayer().getControlledArmies().size(); i++) {
			if(!game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equals(""))
				return game.getPlayer().getControlledArmies().get(i);
		}
		return a;
	}
	
	public Army targetArmy() {
		for(Army a : game.getPlayer().getControlledArmies()) {
			if(a.getTarget().equals("") && !a.getCurrentLocation().equals(""))
				return a;
		}
		return null;
	}
	public City getcity() {
		for(City c : game.getAvailableCities()) {
			if(c.getName().toLowerCase().equals(targetArmy().getTarget()))
				return c;
		}
		return null;
		                                       
	}
	
	public Army rightArmy2() {
		for(Army a : game.getPlayer().getControlledArmies()) {
			if(a.getCurrentStatus() == Status.BESIEGING)
				return a;
		}
		return null;
	}
	
	public void defendingarmyy() {
	     defendingInfo.setText("Current Location : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getCurrentLocation() + "\nTarget : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getTarget() + "\nStatus : " + game.getPlayer().getControlledCities().get(0).getDefendingArmy().getCurrentStatus());
	}
	
	public void defendingarmyy2() {
	     defendingInfo.setText("Current Location : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getCurrentLocation() + "\nTarget : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getTarget() + "\nStatus : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getCurrentStatus());

	}
	
	public void display2(int n) {
		enemyinfo.setText("");
		if(n == -1 || targetcity.getDefendingArmy().getUnits().size() <= n)
			return;

			if(targetcity.getDefendingArmy().getUnits().get(n) instanceof Archer) {
			   enemyinfo.setText("Archer\n" + "Level : " +  targetcity.getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + targetcity.getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + targetcity.getDefendingArmy().getUnits().get(n).getMaxSoldierCount());
			} 
			if(targetcity.getDefendingArmy().getUnits().get(n) instanceof Cavalry) {
				enemyinfo.setText("Cavalry\n" + "Level : " +  targetcity.getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + targetcity.getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + targetcity.getDefendingArmy().getUnits().get(n).getMaxSoldierCount());
			}
			if(targetcity.getDefendingArmy().getUnits().get(n) instanceof Infantry) {
				enemyinfo.setText("Infantry\n" + "Level : " +  targetcity.getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + targetcity.getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + targetcity.getDefendingArmy().getUnits().get(n).getMaxSoldierCount());
			}
	}



	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(controlledcities2.getSelectedIndex() == 1)
			city2();
		if(controlledcities2.getSelectedIndex() == 0)
			city();
		
	}
	
	public void display3(int n) {
		unitInfo3.setText("");
		
		if(n == -1 || game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().size() <= n)
			return;
		
		if(game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n) instanceof Archer)
			unitInfo3.setText("Archer\n" + "Level : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n).getMaxSoldierCount() );
		if(game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n) instanceof Cavalry)
			unitInfo3.setText("Cavalry\n" + "Level : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n).getMaxSoldierCount() );
		if(game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n) instanceof Infantry)
		   unitInfo3.setText("Infantry\n" + "Level : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n).getLevel() + "\nCurrent Soldier Count : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n).getCurrentSoldierCount() + "\nMax Soldier Count : " + game.getPlayer().getControlledCities().get(1).getDefendingArmy().getUnits().get(n).getMaxSoldierCount() );		
	}
// handle all exceptions, add everything to city2 (unit, defending army)

}
