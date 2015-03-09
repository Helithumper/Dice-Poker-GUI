
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ComandConsole extends JPanel {
	//Fields
	JLabel name = new JLabel("<html>CONTROL CONSOLE</html>");
	JButton rollAll,Exit,rollAllAlot,buildPerson,deletePerson;
	
	//Constructor
	public ComandConsole(){
		//setLayout(new GridLayout(2,2));
		setBackground(Color.LIGHT_GRAY);
		setGridLayout();
	}
	//Methods
	public void rollAll(){
		for(PlayerPanel p:Runner.panels){
			p.buttonAction();
		}
		Runner.checkWinner();
	
	}
	public void setGridLayout(){
		//setLayout(new GridLayout(2,2));
		setLayout(new BorderLayout());
		JPanel namePanel = new JPanel();
		name.setFont(new Font("Comic Sans MS",Font.ITALIC,24));
		namePanel.add(name);
		add(namePanel,BorderLayout.NORTH);
		
		
		
		//Buttons
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(3,2));
		rollAll = new JButton("Roll Dice On ALL Windows");
		Exit = new JButton("EXIT on all Windows");
		rollAllAlot = new JButton("<html><center>Roll Dice on ALL <br>Windows ALOT! [NotWorking]</html>");
		buildPerson = new JButton("Add a Player");
		deletePerson = new JButton("Delete a Player");
		
		rollAll.setPreferredSize(new Dimension(250,70));
		
		
		rollAll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rollAll();
			}});
		Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(JFrame f:Runner.frames){
					f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
				}
			}
		});
		rollAllAlot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "<html><font color = 'red'><center>THIS BUTTON DOES NOT WORK AT THE MOMENT!</font><br><font color = 'black'><center>Please Choose a Different Selection</font></html>","Button Warning",JOptionPane.ERROR_MESSAGE);
				/*Boolean isRunning = true;
				while(isRunning){
				for(PlayerPanel p:Runner.panels){
					p.buttonAction();
				}}*/
			}
		});
		buildPerson.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Runner.buildPlayer();
			}
		});
		deletePerson.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Runner.deletePerson();
			}
		});
		
		buttons.add(rollAll);
		buttons.add(Exit);
		buttons.add(rollAllAlot);
		buttons.add(buildPerson);
		buttons.add(deletePerson);
		add(buttons);
	}
	
}
