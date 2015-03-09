
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;


public class ScoreBoardPanel extends JPanel{
	//Field
	String[] columnNames = {"Player Name: ", "Score"};
	JLabel first,second,third,fourth,fifth;
	JLabel onescore,twoscore,threescore,fourscore,fivescore;
	ScoreBoardPanel(){
		setBorderLayout();
		setBackground(Color.WHITE);
	}
	//Method
	public void setBorderLayout(){
		setLayout(new BorderLayout());
		
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("SCOREBOARD");
		title.setFont(new Font("Comic Sans MS",Font.ITALIC,30));
		titlePanel.add(title);
		add(titlePanel,BorderLayout.NORTH);
		
		
		JPanel boardPanel = new JPanel();
		int topSpace = 50;
	//first = new JLabel()
		
		add(boardPanel,BorderLayout.SOUTH);
	}
}
