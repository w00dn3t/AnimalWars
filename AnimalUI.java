import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;


public class AnimalUI {
	private boolean player;
	Animal pl1 = new Animal("Player 1");
	Animal pl2 = new Animal("Player 2");
	String toPrint = "";
	JTextArea combatLog = new JTextArea(10,10);
	JTextField winnerTextField = new JTextField();
	private boolean turn = true;
	JTextArea player1Info = new JTextArea(10,5);
	JTextArea player2Info = new JTextArea(10,5);
	final JButton p1Move1Button = new JButton("1");
	final JButton p1Move2Button = new JButton("2");
	final JButton p1Move3Button = new JButton("3");
	final JButton p1Move4Button = new JButton("4");
	
	//P2
	final JButton p2Move1Button = new JButton("1");
	final JButton p2Move2Button = new JButton("2");
	final JButton p2Move3Button = new JButton("3");
	final JButton p2Move4Button = new JButton("4");


  public AnimalUI(String playerName1, String playerName2) {
		final JFrame frameMain = new JFrame("Animal Wars");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		frameMain.setSize(400, 750);
		frameMain.setVisible(true);
		frameMain.setLayout(layout);
		frameMain.addWindowListener(new WindowAdapter(){
			 public void windowClosing(WindowEvent e){
				 System.exit(0);
			 }
		});

		//Player1 label
		JLabel p1Label = new JLabel(playerName1, SwingConstants.CENTER);
		c.gridx=0;
		c.gridy=0;
		c.fill = GridBagConstraints.HORIZONTAL;
		frameMain.add(p1Label, c);

		//Player1 move 1 button
		p1Move1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (turn){
					setStats();
					toPrint = pl1.offAbilOne(pl2);
					combatLog.setText(toPrint);
					turn = false;
				} else
					winnerTextField.setText("NOT P1 TURN!");
				setStats();
			}
		});
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(p1Move1Button, c);

		//Player1 move 2 button
		p1Move2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (turn){
					setStats();
					toPrint = pl1.offAbilTwo(pl2);
					combatLog.setText(toPrint);
					turn = false;
				} else
					winnerTextField.setText("NOT P1 TURN!");
				setStats();
			}
		});
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(p1Move2Button, c);	

		//Player1 move 3 button
		p1Move3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (turn){
					setStats();
					toPrint = pl1.defAbilOne(pl2);
					combatLog.setText(toPrint);
					turn = false;
				} else
					winnerTextField.setText("NOT P1 TURN!");
				setStats();
			}
		});
		c.gridx = 0;
		c.gridy = 3;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(p1Move3Button, c);

		//Player1 move 4 button
		p1Move4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (turn){
					setStats();
					toPrint = pl1.defAbilTwo(pl2);
					combatLog.setText(toPrint);
					turn = false;
				} else
					winnerTextField.setText("NOT P1 TURN!");
				setStats();
			}
		});
		c.gridx = 0;
		c.gridy = 4;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(p1Move4Button, c);

		//Winner label and text field
		JLabel winnerLabel = new JLabel("Error Return", SwingConstants.CENTER);
		c.gridx=1;
		c.gridy=1;
		frameMain.add(winnerLabel, c);
		winnerTextField.setEditable(false);
		c.gridx=1;
		c.gridy=2;
		frameMain.add(winnerTextField, c);

		//Compute winner button
		JButton winnerButton = new JButton("Engage");
		winnerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStats();
			}
		});
		c.gridx = 1;
		c.gridy = 3;
		c.fill = GridBagConstraints.CENTER;
		frameMain.add(winnerButton, c);

		//Player2 label
		JLabel p2Label = new JLabel(playerName2, SwingConstants.CENTER);
		c.gridx=2;
		c.gridy=0;
		c.fill = GridBagConstraints.HORIZONTAL;
		frameMain.add(p2Label, c);

		//Player1 move 1 button
		p2Move1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!turn){
					setStats();
					toPrint = pl2.offAbilOne(pl1);
					combatLog.setText(combatLog.getText() + "\n" + toPrint);
					turn = true;
					
				} else
					winnerTextField.setText("NOT P2 TURN!");
				setStats();
			}
		});
		c.gridx = 2;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(p2Move1Button, c);

		//Player1 move 2 button
		p2Move2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!turn){
					setStats();
					toPrint = pl2.offAbilTwo(pl1);
					combatLog.setText(combatLog.getText() + "\n" + toPrint);
					turn = true;
				} else
					winnerTextField.setText("NOT P2 TURN!");
				setStats();
			}
		});
		c.gridx = 2;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(p2Move2Button, c);

		//Player1 move 3 button
		p2Move3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!turn){
					setStats();
					toPrint = pl2.defAbilOne(pl1);
					combatLog.setText(combatLog.getText() + "\n" + toPrint);
					turn = true;
				} else
					winnerTextField.setText("NOT P2 TURN!");
				setStats();
			}
		});
		c.gridx = 2;
		c.gridy = 3;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(p2Move3Button, c);

		//Player1 move 4 button
		p2Move4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!turn){
					setStats();
					toPrint = pl2.defAbilTwo(pl1);
					combatLog.setText(combatLog.getText() + "\n" + toPrint);
					turn = true;setStats();
				} else
					winnerTextField.setText("NOT P2 TURN!");
				setStats();
			}
		});
		c.gridx = 2;
		c.gridy = 4;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(p2Move4Button, c);

		//Player Animal selected textfield
		final JTextField player1SelectedTextField = new JTextField();
		player1SelectedTextField.setEditable(false);
		c.gridx = 0;
		c.gridy = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		frameMain.add(player1SelectedTextField, c);
		final JTextField player2SelectedTextField = new JTextField();
		player2SelectedTextField.setEditable(false);
		c.gridx = 2;
		c.gridy = 5;
		c.fill = GridBagConstraints.HORIZONTAL;
		frameMain.add(player2SelectedTextField, c);

		//Animal selected label
		JLabel selectedLabel = new JLabel("<=    Selected    =>", SwingConstants.CENTER);
		c.gridx=1;
		c.gridy=5;
		frameMain.add(selectedLabel, c);

		//Player Animal selection radio button
        ButtonGroup playerRadioButtonGroup = new ButtonGroup();
        final JRadioButton player1RadioButton = new JRadioButton("Player 1");
        final JRadioButton player2RadioButton = new JRadioButton("Player 2");
        player1RadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	player = true;
            	
            }
        });
        player2RadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	player = false;

            }
        });
        c.gridx = 0;
		c.gridy = 6;
		c.fill = GridBagConstraints.HORIZONTAL;
		frameMain.add(player1RadioButton, c);
		playerRadioButtonGroup.add(player1RadioButton);
		c.gridx = 2;
		c.gridy = 6;
		c.fill = GridBagConstraints.HORIZONTAL;
		frameMain.add(player2RadioButton, c);
		playerRadioButtonGroup.add(player2RadioButton);

		//Combat Log Label
		JLabel combatLogLabel = new JLabel("Combat Log", SwingConstants.CENTER);
		c.gridx=1;
		c.gridy=6;
		frameMain.add(combatLogLabel, c);

		//Combat Log
		combatLog.setEditable(false);
		combatLog.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		DefaultCaret caret = (DefaultCaret) combatLog.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		c.gridx=1;
		c.gridy=7;
		frameMain.add(combatLog, c);

		//Player 1 Info
		player1Info.setEditable(false);
		player1Info.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
		c.gridx=0;
		c.gridy=7;
		frameMain.add(player1Info, c);

		//Player 2 Info
		player2Info.setEditable(false);
		player2Info.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
		c.gridx=2;
		c.gridy=7;
		frameMain.add(player2Info, c);

		//Animal Label
		JLabel pokemonLabel = new JLabel("Animal", SwingConstants.CENTER);
		c.gridx=1;
		c.gridy=8;
		frameMain.add(pokemonLabel, c);

		// --- LIST OF POKEMON ---

		//Animal Placeholder Button
		JButton animalButton1 = new JButton("Aardvark");
		animalButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player){
					pl1 = new Aardvark("Player 1");
					player1RadioButton.setEnabled(false);
					player1SelectedTextField.setText(pl1.getType());
					engageP1Buttons(pl1);
				}
				if (!player){
					pl2 = new Aardvark("Player 2");
					player2RadioButton.setEnabled(false);
					player2SelectedTextField.setText(pl2.getType());
					engageP2Buttons(pl2);
				}
			}
		});
		c.gridx = 0;
		c.gridy = 9;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(animalButton1, c);

		//Animal Placeholder Button
		JButton animalButton2 = new JButton("Narwhal");
		animalButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player){
					pl1 = new Narwhal("Player 1");
					player1RadioButton.setEnabled(false);
					player1SelectedTextField.setText(pl1.getType());
					engageP1Buttons(pl1);
				}
				if (!player){
					pl2 = new Narwhal("Player 2");
					player2RadioButton.setEnabled(false);
					player2SelectedTextField.setText(pl2.getType());
					engageP2Buttons(pl2);
				}
			}
		});
		c.gridx = 1;
		c.gridy = 9;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(animalButton2, c);

		//Animal Placeholder Button
		JButton animalButton3 = new JButton("Ocelot");
		animalButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player){
					pl1 = new Ocelot("Player 1");
					player1RadioButton.setEnabled(false);
					player1SelectedTextField.setText(pl1.getType());
					engageP1Buttons(pl1);
				}
				if (!player){
					pl2 = new Ocelot("Player 2");
					player2RadioButton.setEnabled(false);
					player2SelectedTextField.setText(pl2.getType());
					engageP2Buttons(pl2);
				}
			}
		});
		c.gridx = 2;
		c.gridy = 9;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(animalButton3, c);

		//Animal Placeholder Button
		JButton animalButton4 = new JButton("Scimitar Oryx");
		animalButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player){
					pl1 = new ScimitarOryx("Player 1");
					player1RadioButton.setEnabled(false);
					player1SelectedTextField.setText(pl1.getType());
					engageP1Buttons(pl1);
				}
				if (!player){
					pl2 = new ScimitarOryx("Player 2");
					player2RadioButton.setEnabled(false);
					player2SelectedTextField.setText(pl2.getType());
					engageP2Buttons(pl2);
				}
			}
		});
		c.gridx = 0;
		c.gridy = 10;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(animalButton4, c);

		//Animal Placeholder Button
		JButton animalButton5 = new JButton("Three Toed Sloth");
		animalButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player){
					pl1 = new ThreeToedSloth("Player 1");
					player1RadioButton.setEnabled(false);
					player1SelectedTextField.setText(pl1.getType());
					engageP1Buttons(pl1);
				}
				if (!player){
					pl2 = new ThreeToedSloth("Player 2");
					player2RadioButton.setEnabled(false);
					player2SelectedTextField.setText(pl2.getType());
					engageP2Buttons(pl2);
				}
			}
		});
		c.gridx = 1;
		c.gridy = 10;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(animalButton5, c);

		//Animal Placeholder Button
		JButton animalButton6 = new JButton("placeholder6");
		animalButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		c.gridx = 2;
		c.gridy = 10;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(animalButton6, c);

		//Animal Placeholder Button
		JButton animalButton7 = new JButton("placeholder7");
		animalButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		c.gridx = 0;
		c.gridy = 11;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(animalButton7, c);

		//Animal Placeholder Button
		JButton animalButton8 = new JButton("placeholder8");
		animalButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		c.gridx = 1;
		c.gridy = 11;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(animalButton8, c);

		//Animal Placeholder Button
		JButton animalButton9 = new JButton("placeholder9");
		animalButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		c.gridx = 2;
		c.gridy = 11;
		c.fill = GridBagConstraints.HORIZONTAL; 
		frameMain.add(animalButton9, c);
		
		frameMain.setSize(400,750);
		frameMain.setSize(450,750);
	}
  	public void setStats(){
  		player1Info.setText(pl1.listStatus());
  		player2Info.setText(pl2.listStatus());
  		if(check())
  			getWinner();
  	}
  	public void endGame(){
  		//P1
  		p1Move1Button.setEnabled(false);
  		p1Move2Button.setEnabled(false);
  		p1Move3Button.setEnabled(false);
  		p1Move4Button.setEnabled(false);
  		//P2
  		p2Move1Button.setEnabled(false);
  		p2Move2Button.setEnabled(false);
  		p2Move3Button.setEnabled(false);
  		p2Move4Button.setEnabled(false);
  	}
  	public boolean check(){
  		if (pl1.getHealth() > 0 && pl2.getHealth() > 0)
  			return false;
  		return true;
  	}
  	public void getWinner(){
  		if (check() && pl2.getHealth() < 0){
  			endGame();
  			winnerTextField.setText("Player 2 Died");
  		} else if (check() && pl1.getHealth() < 0){
  			endGame();
  			winnerTextField.setText("Player 1 Died");
  		}

  	}
  	public void engageP1Buttons(Animal animal){
  		p1Move1Button.setText(animal.listAbil(0));
  		p1Move2Button.setText(animal.listAbil(1));
  		p1Move3Button.setText(animal.listAbil(2));
  		p1Move4Button.setText(animal.listAbil(3));
  	}
  	public void engageP2Buttons(Animal animal){
  		p2Move1Button.setText(animal.listAbil(0));
  		p2Move2Button.setText(animal.listAbil(1));
  		p2Move3Button.setText(animal.listAbil(2));
  		p2Move4Button.setText(animal.listAbil(3));
  	}
}
