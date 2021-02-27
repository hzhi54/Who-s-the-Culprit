package code;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * The EnterListener class is function when the JButton named enter was clicked. This will let the player enter
 * a room when they are near at the door. Players could choose not too enter if they are at the door. Once again,
 * the board has a very complicated design, each door will locate with a different location within the room. This 
 * way we could tell that each door will function properly.
 * 
 * @author ZhiWen Huang
 *
 */
public class EnterListener implements ActionListener {

	private ClueModel model;
	private JButton ent;
	private JButton lea;
	private JButton sec;
	private JButton sug;
	
	public EnterListener(ClueModel model, JButton enter, JButton leave, JButton secret, JButton suggest) {
		this.model = model;
		ent = enter;
		lea = leave;
		sec = secret;
		sug = suggest;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(Player player: model.getList()){
			if(player.getTurn()){
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 3 &&
						player.getLocation().y == 5){
					player.getLocation().x = 2;
					player.getLocation().y = 2;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 8 &&
						player.getLocation().y == 6){
					player.getLocation().x = 8;
					player.getLocation().y = 4;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 10 &&
						player.getLocation().y == 3){
					player.getLocation().x = 8;
					player.getLocation().y = 2;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 12 &&
						player.getLocation().y == 1){
					player.getLocation().x = 14;
					player.getLocation().y = 1;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 15 &&
						player.getLocation().y == 5){
					player.getLocation().x = 14;
					player.getLocation().y = 3;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 19 &&
						player.getLocation().y == 4){
					player.getLocation().x = 21;
					player.getLocation().y = 2;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 4 &&
						player.getLocation().y == 9){
					player.getLocation().x = 3;
					player.getLocation().y = 11;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 6 &&
						(player.getLocation().y == 11 ||
						player.getLocation().y == 12)){
					player.getLocation().x = 3;
					player.getLocation().y = 12;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 19 &&
						player.getLocation().y == 8){
					player.getLocation().x = 19;
					player.getLocation().y = 10;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 17 &&
						player.getLocation().y == 9){
					player.getLocation().x = 19;
					player.getLocation().y = 11;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 17 &&
						player.getLocation().y == 14){
					player.getLocation().x = 19;
					player.getLocation().y = 12;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 19 &&
						player.getLocation().y == 15){
					player.getLocation().x = 19;
					player.getLocation().y = 13;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 5 &&
						player.getLocation().y == 18){
					player.getLocation().x = 3;
					player.getLocation().y = 21;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 9 &&
						player.getLocation().y == 17){
					player.getLocation().x = 12;
					player.getLocation().y = 21;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 12 &&
						player.getLocation().y == 16){
					player.getLocation().x = 12;
					player.getLocation().y = 22;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
				if(player.getTile().getColor() == Color.PINK &&
						player.getLocation().x == 18 &&
						player.getLocation().y == 19){
					player.getLocation().x = 22;
					player.getLocation().y = 22;
					player.setTile();
					model.makeChange();
					ent.setEnabled(false);
					lea.setEnabled(false);
					sec.setEnabled(false);
					sug.setEnabled(true);
				}
			}
		}
	}

}
