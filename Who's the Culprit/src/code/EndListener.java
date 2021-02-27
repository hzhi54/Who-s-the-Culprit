package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The EndListener class functions when the button named end had been click. The main purpose of this class
 * is to go to the next player turn.
 * 
 * @author ZhiWen Huang
 *
 */
public class EndListener implements ActionListener {
	
	private JFrame f;
	private JPanel p;
	private ClueModel clue;
	private Gui g;
	
	public EndListener(JFrame frame, JPanel command, ClueModel model, Gui gui) {
		f = frame;
		p = command;
		clue = model;
		g = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(clue.getList().get(0).getTurn()){
			clue.getList().get(0).setTurn(false);
			clue.getNextPlayer(clue.getList().get(0)).setTurn(true);
		}
		else if(clue.getList().get(1).getTurn()){
			clue.getList().get(1).setTurn(false);
			clue.getNextPlayer(clue.getList().get(1)).setTurn(true);
		}
		else if(clue.getList().get(2).getTurn()){
			clue.getList().get(2).setTurn(false);
			clue.getNextPlayer(clue.getList().get(2)).setTurn(true);
		}
		else if(clue.getList().get(3).getTurn()){
			clue.getList().get(3).setTurn(false);
			clue.getNextPlayer(clue.getList().get(3)).setTurn(true);
		}
		else if(clue.getList().get(4).getTurn()){
			clue.getList().get(4).setTurn(false);
			clue.getNextPlayer(clue.getList().get(4)).setTurn(true);
		}
		else if(clue.getList().get(5).getTurn()){
			clue.getList().get(5).setTurn(false);
			clue.getNextPlayer(clue.getList().get(5)).setTurn(true);
		}
		f.remove(p);				
		g.createCommands();
		f.validate();
		f.repaint();

	}

}
