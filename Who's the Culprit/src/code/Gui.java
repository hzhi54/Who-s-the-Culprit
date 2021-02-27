package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class will be all the graphic user interfaces. Such as the frame, panels, other components. There
 * will not be any form of game involving data, but will be action listeners for each different components.
 * All the game data will written in the code package, not here. Therefore, this class will instantiate the model
 * created in the code package, so that when running the driver class, we will be using the same model after 
 * we run it.
 * 
 * Gui are being observed by the model class. Whenever a player make a change of their movement, we will change it
 * in the model class. Then update the graphic user interfaces so that we can see what movement had been made.
 * 
 * Movements in this game are very strictly made. There are certain moves that are against the rules and 
 * illegal. Therefore, the commands on the side of the board is to show what can a player do during his/her turn.
 * This way there will be no one cheating from the game.
 * 
 * @author ZhiWen Huang
 *
 */

public class Gui implements Observer{

	private ClueModel model;
	private JFrame frame;
	private JPanel board;
	private JPanel command;
	private int steps;
	private Dice dice;
	private JButton button;
	private ArrayList<JButton> buttonList;
	
	public Gui(ClueModel m){
		model = m;
		model.setObserver(this); //This(Gui class) is where we want to notify the change.
		dice = new Dice();
		buttonList = new ArrayList<JButton>();
		createFrame();
	}
	
	//Creates the window.
	public void createFrame(){
		frame = new JFrame("Clue");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		createBoard();
		createCommands();
		frame.pack();
	}
	
	//Creates the board.
	public void createBoard(){
		board = new JPanel();
		board.setFocusable(false);
		board.setLayout(new GridLayout(ClueModel.ROW,ClueModel.COL));
		for(int c = 0; c < ClueModel.COL; c++){
			for(int r = 0; r < ClueModel.ROW; r++){
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(30,30));
				board.add(button);
			}
		}
		frame.add(board);
		update();
	}
	
	//Add the tiles to the board.
	public void addTiles(){
		for(int c = 0; c < ClueModel.COL; c++){
			for(int r = 0; r < ClueModel.ROW; r++){
				button = (JButton) board.getComponent(ClueModel.COL*r+c);
				button.setBackground(ClueModel.board[r][c].getColor());
				button.setOpaque(true);
				button.setText("");
				buttonList.add(button);
				button.setEnabled(false);
			}
		}
	}
	
	//Add the players to the board.
	public void addPlayers(){
		for(int i = 0; i < model.getList().size(); i++){
			JButton button = (JButton) board.getComponent(25*
					model.getList().get(i).getLocation().x
					+ model.getList().get(i).getLocation().y);
			button.setBackground(model.getList().get(i).getColor());
			button.setText(model.getList().get(i).getToken());
		}
	}

	//Updates with all the tiles and players on the right place.
	@Override
	public void update() {
		addTiles();
		addPlayers();
		frame.repaint();
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	//Commands are what we will be using to tell a player to do something.
	public void createCommands(){
		// Below are commands added in to the JPanel.
		command = new JPanel();
		command.setFocusable(false);
		command.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JButton start = new JButton("Start");
		c.gridx = 1;
		c.gridy = 0;
		command.add(start,c);
		JLabel name = new JLabel("Name");
		c.gridx = 2;
		c.gridy = 0;
		command.add(name, c);
		JButton roll = new JButton("Roll");
		c.gridx = 0;
		c.gridy = 1;
		command.add(roll,c);
		JLabel number = new JLabel("number");
		c.gridx = 1;
		c.gridy = 1;
		command.add(number,c);
		JButton player = new JButton();
		player.setOpaque(true);
		player.setBackground(Color.BLACK);
		player.setEnabled(false);
		player.setPreferredSize(new Dimension(50,50));
		c.gridx = 2;
		c.gridy = 1;
		command.add(player,c);
		Image img0 = new ImageIcon(this.getClass().getResource("up_1.png")).getImage();
		Image img1 = new ImageIcon(this.getClass().getResource("left_1.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("down_1.png")).getImage();
		Image img3 = new ImageIcon(this.getClass().getResource("right_1.png")).getImage();
		JButton up = new JButton();
		up.setIcon(new ImageIcon(img0));
		c.gridx = 1;
		c.gridy = 2;
		command.add(up,c);
		JButton left = new JButton();
		left.setIcon(new ImageIcon(img1));
		c.gridx = 0;                                                                                               
		c.gridy = 3;
		command.add(left,c);
		JButton down = new JButton();
		down.setIcon(new ImageIcon(img2));
		c.gridx = 1;
		c.gridy = 3;
		command.add(down,c);
		JButton right = new JButton();
		right.setIcon(new ImageIcon(img3));
		c.gridx = 2;
		c.gridy = 3;
		command.add(right,c);
		JButton enter = new JButton("Enter");
		c.gridx = 0;
		c.gridy = 4;
		command.add(enter,c);
		JButton secret = new JButton("Secret");
		c.gridx = 2;
		c.gridy = 4;
		command.add(secret,c);
		JButton leave = new JButton("Leave");
		c.gridx = 1;
		c.gridy = 4;
		command.add(leave,c);
		JButton end = new JButton("End");
		c.gridx = 1;
		c.gridy = 8;
		command.add(end, c);
		JLabel playerCard = new JLabel("Player's Hand");
		c.gridx = 0;
		c.gridy = 9;
		command.add(playerCard,c);
		JLabel cardone = new JLabel("Card");
		c.gridx = 0;
		c.gridy = 10;
		command.add(cardone, c);
		JLabel cardtwo = new JLabel("Card");
		c.gridx = 0;
		c.gridy = 11;
		command.add(cardtwo, c);
		JLabel cardthree = new JLabel("Card");
		c.gridx = 0;
		c.gridy = 12;
		command.add(cardthree, c);
		JButton suggest = new JButton("Suggest");
		c.gridx = 1;
		c.gridy = 9;
		command.add(suggest, c);
		JLabel envelope = new JLabel("Envelope");
		c.gridx = 2;
		c.gridy = 9;
		command.add(envelope, c);
		JLabel envelopeone = new JLabel("Card");
		c.gridx = 2;
		c.gridy = 10;
		command.add(envelopeone, c);
		JLabel envelopetwo = new JLabel("Card");
		c.gridx = 2;
		c.gridy = 11;
		command.add(envelopetwo, c);
		JLabel envelopethree = new JLabel("Card");
		c.gridx = 2;
		c.gridy = 12;
		command.add(envelopethree, c);
		JButton accusation = new JButton("Make Accusation");
		c.gridx = 1;
		c.gridy = 13;
		command.add(accusation, c);
	
		// Down below is to test if the envelope cards never matches with the player cards.
		envelopeone.setText(model.getCardModel().getEnvelope().get(0).getName());
		envelopetwo.setText(model.getCardModel().getEnvelope().get(1).getName());
		envelopethree.setText(model.getCardModel().getEnvelope().get(2).getName());
		
		roll.setEnabled(false);
		up.setEnabled(false);
		left.setEnabled(false);
		down.setEnabled(false);
		right.setEnabled(false);
		enter.setEnabled(false);
		secret.setEnabled(false);
		leave.setEnabled(false);
		end.setEnabled(false);
		suggest.setEnabled(false);
		frame.add(command);
		
		// To start the current player turn.
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start.setEnabled(false);
				roll.setEnabled(true);
				end.setEnabled(true);
				for(int i = 0; i < model.getList().size(); i++){
					if(model.getList().get(i).getTurn()){
						player.setBackground(model.getList().get(i).getColor());
						player.setText(model.getList().get(i).getToken());
						name.setText(model.getList().get(i).getName());
						if(model.getList().get(i).getTile().getColor() == Color.BLACK){
							leave.setEnabled(true);
							secret.setEnabled(true);
						}
						if(model.getList().get(i).getTile().getColor() == Color.PINK){
							enter.setEnabled(true);
						}
						cardone.setText(model.getList().get(i).getHand().get(0).getName());
						cardtwo.setText(model.getList().get(i).getHand().get(1).getName());
						cardthree.setText(model.getList().get(i).getHand().get(2).getName());
					}
				}
				frame.pack();
			}
		});
		
		// Rolls the dice. Generates a random number 1-6.
		roll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				steps = dice.roll();
				number.setText(""+steps);
				roll.setEnabled(false);
				up.setEnabled(true);
				left.setEnabled(true);
				down.setEnabled(true);
				right.setEnabled(true);
			}
		});
		
		// Move up legally.
		up.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(Player player: model.getList()){
					if(steps != 0){
						if(player.getTurn()){
							if(player.getLocation().x == 0){
							}
							else{
								player.getLocation().x = player.getLocation().x - 1;
								steps = steps - 1;
								number.setText(""+steps);
							}
							player.setTile();
							if(player.getTile().getColor() == Color.PINK){
								enter.setEnabled(true);
							}
							else{
								enter.setEnabled(false);
							}
							if(!player.getTile().walkable()){
								player.getLocation().x = player.getLocation().x + 1;
								steps = steps + 1;
								number.setText(""+steps);
								player.setTile();
							}
							model.makeChange();
						}
					}
				}
			}
		});
		
		// Move left legally.
		left.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				for(Player player: model.getList()){
					if(steps != 0){
						if(player.getTurn()){
							if(player.getLocation().y == 0){
							}
							else{
								player.getLocation().y = player.getLocation().y - 1;
								steps = steps - 1;
								number.setText(""+steps);
							}
							player.setTile();
							if(player.getTile().getColor() == Color.PINK){
								enter.setEnabled(true);
							}
							else{
								enter.setEnabled(false);
							}
							if(!player.getTile().walkable()){
								player.getLocation().y = player.getLocation().y + 1;
								steps = steps + 1;
								number.setText(""+steps);
								player.setTile();
							}
							model.makeChange();
						}
					}
				}
			}
		});
		
		// Move down legally.
		down.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(Player player: model.getList()){
					if(steps != 0){
						if(player.getTurn()){
							if(player.getLocation().x == 23){
							}
							else{
								player.getLocation().x = player.getLocation().x + 1;
								steps = steps - 1;
								number.setText(""+steps);
							}
							player.setTile();
							if(player.getTile().getColor() == Color.PINK){
								enter.setEnabled(true);
							}
							else{
								enter.setEnabled(false);
							}
							if(!player.getTile().walkable()){
								player.getLocation().x = player.getLocation().x - 1;
								steps = steps + 1;
								number.setText(""+steps);
								player.setTile();
							}
							model.makeChange();
						}
					}
				}
			}
		});
		
		// Move right legally.
		right.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(Player player: model.getList()){
					if(steps != 0){
						if(player.getTurn()){
							if(player.getLocation().y == 24){
							}
							else{
								player.getLocation().y = player.getLocation().y + 1;
								steps = steps - 1;
								number.setText(""+steps);
							}
							player.setTile();
							if(player.getTile().getColor() == Color.PINK){
								enter.setEnabled(true);
							}
							else{
								enter.setEnabled(false);
							}
							if(!player.getTile().walkable()){
								player.getLocation().y = player.getLocation().y - 1;
								steps = steps + 1;
								number.setText(""+steps);
								player.setTile();
							}
							model.makeChange();
						}
					}
				}
			}
		});
		enter.addActionListener(new EnterListener(model,enter,leave,secret,suggest));
		secret.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				secret.setEnabled(false);
				for(Player player: model.getList()){
					if(player.getTurn()){
						if(player.getTile().getName() == "The Android's Dungeon"){
							player.getLocation().x = 22;
							player.getLocation().y = 22;
							model.makeChange();
						}
						if(player.getTile().getName() == "Kwik-E-Mart"){
							player.getLocation().x = 2;
							player.getLocation().y = 2;
							model.makeChange();
						}
						if(player.getTile().getName() == "Krustylu Studios"){
							player.getLocation().x = 22;
							player.getLocation().y = 2;
							model.makeChange();
						}
						if(player.getTile().getName() == "Springfield Retirement Castle"){
							player.getLocation().x = 2;
							player.getLocation().y = 22;
							model.makeChange();
						}
					}
				}
			}
			
		});
		leave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				leave.setEnabled(false);
				for(Player player: model.getList()){
					if(player.getTurn()){
						if(player.getTile().getName() == "The Android's Dungeon"){
							board.getComponent(ClueModel.COL*3+5).setEnabled(true);
							for(JButton b: buttonList){
								if(b.isEnabled()){
									b.addActionListener(new ActionListener(){
										@Override
										public void actionPerformed(ActionEvent e) {
											player.getLocation().x = 3;
											player.getLocation().y = 5;
											model.makeChange();
										}
									});
								}
							}
						}
						if(player.getTile().getName() == "The Frying Dutchman"){
							board.getComponent(ClueModel.COL*8+6).setEnabled(true);
							board.getComponent(ClueModel.COL*10+3).setEnabled(true);
							for(JButton b: buttonList){
								if(b.isEnabled()){
									b.addActionListener(new ActionListener(){
										@Override
										public void actionPerformed(ActionEvent e) {
											if(e.getSource() == 
												board.getComponent(ClueModel.COL*8+6)){
												player.getLocation().x = 8;
												player.getLocation().y = 6;
												model.makeChange();
											}
											if(e.getSource() == 
													board.getComponent(ClueModel.COL*10+3)){
													player.getLocation().x = 10;
													player.getLocation().y = 3;
													model.makeChange();
												}
										}
									});
								}
							}
						}
						if(player.getTile().getName() == "The Simpson House"){
							board.getComponent(ClueModel.COL*12+1).setEnabled(true);
							board.getComponent(ClueModel.COL*15+5).setEnabled(true);
							for(JButton b: buttonList){
								if(b.isEnabled()){
									b.addActionListener(new ActionListener(){
										@Override
										public void actionPerformed(ActionEvent e) {
											if(e.getSource() == 
												board.getComponent(ClueModel.COL*12+1)){
												player.getLocation().x = 12;
												player.getLocation().y = 1;
												model.makeChange();
											}
											if(e.getSource() == 
												board.getComponent(ClueModel.COL*15+5)){
												player.getLocation().x = 15;
												player.getLocation().y = 5;
												model.makeChange();
											}
										}
									});
								}
							}
							
						}
						if(player.getTile().getName() == "Springfield Retirement Castle"){
							board.getComponent(ClueModel.COL*19+4).setEnabled(true);
							for(JButton b: buttonList){
								if(b.isEnabled()){
									b.addActionListener(new ActionListener(){
										@Override
										public void actionPerformed(ActionEvent e) {
											player.getLocation().x = 19;
											player.getLocation().y = 4;
											model.makeChange();
										}
									});
								}
							}
						}
						if(player.getTile().getName() == "Burns Manor"){
							board.getComponent(ClueModel.COL*4+9).setEnabled(true);
							board.getComponent(ClueModel.COL*6+11).setEnabled(true);
							board.getComponent(ClueModel.COL*6+12).setEnabled(true);
							for(JButton b: buttonList){
								if(b.isEnabled()){
									b.addActionListener(new ActionListener(){
										@Override
										public void actionPerformed(ActionEvent e) {
											if(e.getSource() == 
												board.getComponent(ClueModel.COL*4+9)){
												player.getLocation().x = 4;
												player.getLocation().y = 9;
												model.makeChange();
											}
											if(e.getSource() == 
												board.getComponent(ClueModel.COL*6+11)){
												player.getLocation().x = 6;
												player.getLocation().y = 11;
												model.makeChange();
											}
											if(e.getSource() == 
												board.getComponent(ClueModel.COL*6+12)){
												player.getLocation().x = 6;
												player.getLocation().y = 12;
												model.makeChange();
											}
										}
									});
								}
							}
							
						}
						if(player.getTile().getName() == "Nuclear Power Plant"){
							board.getComponent(ClueModel.COL*17+9).setEnabled(true);
							board.getComponent(ClueModel.COL*17+14).setEnabled(true);
							board.getComponent(ClueModel.COL*19+8).setEnabled(true);
							board.getComponent(ClueModel.COL*19+15).setEnabled(true);
							for(JButton b: buttonList){
								if(b.isEnabled()){
									b.addActionListener(new ActionListener(){
										@Override
										public void actionPerformed(ActionEvent e) {
											if(e.getSource() == 
												board.getComponent(ClueModel.COL*17+9)){
												player.getLocation().x = 17;
												player.getLocation().y = 9;
												model.makeChange();
											}
											if(e.getSource() == 
												board.getComponent(ClueModel.COL*17+14)){
												player.getLocation().x = 17;
												player.getLocation().y = 14;
												model.makeChange();
											}
											if(e.getSource() == 
												board.getComponent(ClueModel.COL*19+8)){
												player.getLocation().x = 19;
												player.getLocation().y = 8;
												model.makeChange();
											}
											if(e.getSource() == 
													board.getComponent(ClueModel.COL*19+15)){
													player.getLocation().x = 19;
													player.getLocation().y = 15;
													model.makeChange();
												}
										}
									});
								}
							}
						}
						if(player.getTile().getName() == "Krustylu Studios"){
							board.getComponent(ClueModel.COL*5+18).setEnabled(true);
							for(JButton b: buttonList){
								if(b.isEnabled()){
									b.addActionListener(new ActionListener(){
										@Override
										public void actionPerformed(ActionEvent e) {
											player.getLocation().x = 5;
											player.getLocation().y = 18;
											model.makeChange();
										}
									});
								}
							}
							
						}
						if(player.getTile().getName() == "Barney's Bowl-A-Rama"){
							board.getComponent(ClueModel.COL*9+17).setEnabled(true);
							board.getComponent(ClueModel.COL*12+16).setEnabled(true);
							for(JButton b: buttonList){
								if(b.isEnabled()){
									b.addActionListener(new ActionListener(){
										@Override
										public void actionPerformed(ActionEvent e) {
											if(e.getSource() == 
													board.getComponent(ClueModel.COL*9+17)){
													player.getLocation().x = 9;
													player.getLocation().y = 17;
													model.makeChange();
												}
												if(e.getSource() == 
													board.getComponent(ClueModel.COL*12+16)){
													player.getLocation().x = 12;
													player.getLocation().y = 16;
													model.makeChange();
												}
										}
									});
								}
							}
						}
						if(player.getTile().getName() == "Kwik-E-Mart"){
							board.getComponent(ClueModel.COL*18+19).setEnabled(true);
							for(JButton b: buttonList){
								if(b.isEnabled()){
									b.addActionListener(new ActionListener(){
										@Override
										public void actionPerformed(ActionEvent e) {
											player.getLocation().x = 18;
											player.getLocation().y = 19;
											model.makeChange();
										}
									});
								}
							}
						}
					}
				}
			}
			
		});
		end.addActionListener(new EndListener(frame,command,model,this));
		
		// Lets player to suggest when inside a room.
		suggest.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				suggest.setEnabled(false);
				frame.setEnabled(false);
				JFrame suggestFrame = new JFrame("Suggest Frame");
				suggestFrame.setLayout(new GridLayout(3,0));
				suggestFrame.setVisible(true);
				suggestFrame.setFocusable(true);
				suggestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JPanel suggestPanel = new JPanel();
				suggestPanel.setLayout(new GridBagLayout());
				GridBagConstraints c = new GridBagConstraints();
				
				JPanel dialogPanel = new JPanel();
				dialogPanel.setLayout(new GridLayout(3,3));
				JLabel pick = new JLabel("Pick a card from each category");
				pick.setOpaque(true);
				dialogPanel.add(new JLabel());
				dialogPanel.add(pick);
				dialogPanel.add(new JLabel());
				suggestFrame.add(dialogPanel);
				
				JPanel provePanel = new JPanel();
				provePanel.setLayout(new GridLayout(2,3));
				suggestFrame.add(provePanel);
				JLabel proveOne = new JLabel("prove");
				JLabel proveTwo = new JLabel("prove");
				JLabel proveThree = new JLabel("prove");
				JButton answerOne = new JButton();
				answerOne.setEnabled(false);
				answerOne.setOpaque(true);
				JButton answerTwo = new JButton();
				answerTwo.setEnabled(false);
				answerTwo.setOpaque(true);
				JButton answerThree = new JButton();
				answerThree.setEnabled(false);
				answerThree.setOpaque(true);
				provePanel.add(proveOne);
				provePanel.add(proveTwo);
				provePanel.add(proveThree);
				provePanel.add(answerOne);
				provePanel.add(answerTwo);
				provePanel.add(answerThree);
				
				JLabel suggestone = new JLabel("Character Card");
				JLabel suggesttwo = new JLabel("Room Card");
				JLabel suggestthree = new JLabel("Weapon Card");
				dialogPanel.add(suggestone);
				dialogPanel.add(suggesttwo);
				dialogPanel.add(suggestthree);
				dialogPanel.add(new JLabel());
				
				JButton confirmed = new JButton("Confirmed");
				confirmed.setEnabled(false);
				dialogPanel.add(confirmed);
				
				// Confirmed button enable when player choose the suggested cards they want.
				JLabel cName = new JLabel("Character:  ");
				c.gridy = 0;
				c.gridx = 0;
				suggestPanel.add(cName, c);
				for(int x0 = 0; x0 < Card.characterCards; x0++){
					c.gridx = x0+1;
					JButton button = new JButton();
					button.setText(model.getCardModel().getUni().get(x0).getName());
					button.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							suggestone.setText(button.getText());
							if(suggestone.getText() != "Character Card" &&
									suggesttwo.getText() != "Room Card" &&
									suggestthree.getText() != "Weapon Card"){
								confirmed.setEnabled(true);
							}
						}
						
					});
					suggestPanel.add(button, c);
				}
						
				JLabel wName = new JLabel("Weapon:  ");
				c.gridy = 2;
				c.gridx = 0;
				suggestPanel.add(wName, c);
				for(int x2 = 0; x2 < Card.weaponCards; x2++){
					c.gridx = x2 + 1;
					JButton button = new JButton();
					button.setText(model.getCardModel().getUni().get(Card.characterCards+Card.roomCards+x2).getName());
					button.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							suggestthree.setText(button.getText());
							if(suggestone.getText() != "Character Card" &&
									suggesttwo.getText() != "Room Card" &&
									suggestthree.getText() != "Weapon Card"){
								confirmed.setEnabled(true);
							}
						}
						
					});
					suggestPanel.add(button, c);
				}
				for(Player player: model.getList()){
					if(player.getTurn()){
						suggesttwo.setText(player.getTile().getName()+"");
					}
				}
				
				suggestFrame.add(suggestPanel);
				suggestFrame.pack();
				
				// Close the suggest frame after 5 seconds when confirmed button is press.
				ActionListener timerListener = new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						suggestFrame.dispose();
						frame.setEnabled(true);
						frame.pack();
					}
					
				};
				
				Timer timer = new Timer(5000,timerListener);
				
				// To confirmed what is being suggested.
				confirmed.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						timer.start(); // Timer starts here.
						proveOne.setText("FALSE");
						proveTwo.setText("FALSE");
						proveThree.setText("FALSE");
						answerOne.setBackground(Color.RED);
						answerTwo.setBackground(Color.RED);
						answerThree.setBackground(Color.RED);
						for(Player player: model.getList()){
							if(player.getHand().get(0).getName().equals(suggestone.getText()) ||
									player.getHand().get(1).getName().equals(suggestone.getText()) ||
									player.getHand().get(2).getName().equals(suggestone.getText())){
								proveOne.setText(player.getName() + " prove this");
								answerOne.setBackground(Color.GREEN);
							}
							if(player.getHand().get(0).getName().equals(suggesttwo.getText()) ||
									player.getHand().get(1).getName().equals(suggesttwo.getText()) ||
									player.getHand().get(2).getName().equals(suggesttwo.getText())){
								proveTwo.setText(player.getName() + " prove this");
								answerTwo.setBackground(Color.GREEN);
							}
							if(player.getHand().get(0).getName().equals(suggestthree.getText()) ||
									player.getHand().get(1).getName().equals(suggestthree.getText()) ||
									player.getHand().get(2).getName().equals(suggestthree.getText())){
								proveThree.setText(player.getName() + " prove this");
								answerThree.setBackground(Color.GREEN);
							}
							if(player.getTurn()){
								if(player.getHand().get(0).getName().equals(suggestone.getText()) ||
										player.getHand().get(1).getName().equals(suggestone.getText()) ||
										player.getHand().get(2).getName().equals(suggestone.getText())){
									proveOne.setText("FALSE");
									answerOne.setBackground(Color.RED);
								}
								if(player.getHand().get(0).getName().equals(suggesttwo.getText()) ||
										player.getHand().get(1).getName().equals(suggesttwo.getText()) ||
										player.getHand().get(2).getName().equals(suggesttwo.getText())){
									proveTwo.setText("FALSE");
									answerTwo.setBackground(Color.RED);
								}
								if(player.getHand().get(0).getName().equals(suggestthree.getText()) ||
										player.getHand().get(1).getName().equals(suggestthree.getText()) ||
										player.getHand().get(2).getName().equals(suggestthree.getText())){
									proveThree.setText("FALSE");
									answerThree.setBackground(Color.RED);
								}
							}
						}
					}
					
				});
			}
		});
	}

}