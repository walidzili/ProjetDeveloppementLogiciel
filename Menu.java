package sys;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Menu extends JFrame{

	public static void main(String[] args) {
		EventQueue.invokeLater(()->
		{
	        JFrame frame=new Menu();
	        frame.setTitle("Menu");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
		});
	}
	
	public Menu(){
		JPanel panel;
		JButton btnpersonne;
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		setSize(400,450);
		setLocationRelativeTo(null);
		
		btnpersonne=new JButton("Gestion des personnes");
		panel.add(btnpersonne);
		btnpersonne.setBounds(100, 30, 200, 50);
		btnpersonne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame=new MenuPersonne();
				frame.setVisible(true);
			}
		});
	}
}
