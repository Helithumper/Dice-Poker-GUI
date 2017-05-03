

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StartPanel extends JPanel {
	//Fields
	JLabel titleLabel = new JLabel("<html><font color = 'blue'><font size = 15><font family = 'Comic Sans MS'>DICE POKER!</font></html>");
	JButton startButton = new JButton("Start Game");
	//Constructor
	public StartPanel(){
		setBackground(Color.WHITE);
		setBorderLayout();
	}
	//AM
	
	//MEthods
	public void setBorderLayout(){
		setLayout(new BorderLayout());
		JPanel titlePanel = new JPanel();
		titlePanel.add(titleLabel);
		add(titlePanel,BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(startButton);
		startButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				Runner.outofSF=true;
			}
		});
		add(buttonPanel,BorderLayout.SOUTH);
	}
}
