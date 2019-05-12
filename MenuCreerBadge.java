package sys;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class MenuCreerBadge extends JFrame{

    private PersonneDAO personneDAO;
	
	public MenuCreerBadge(int id) {
		personneDAO=new PersonneDAO();

		JPanel panel;
		JLabel label;
		JButton btnyes,btnno;
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(300, 200);
		setContentPane(panel);
		setLocationRelativeTo(null);
		setTitle("Creation Badge");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		label=new JLabel("Voulez-vous creer un badge?");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBounds(40, 30, 250, 40);
		panel.add(label);
		
		btnyes=new JButton("OUI");
		btnyes.setFont(new Font("Arial", Font.PLAIN, 16));
		btnyes.setBounds(40, 100, 80, 30);
		panel.add(btnyes);
		btnyes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					personneDAO.creerBadge(id);
					System.exit(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btnno=new JButton("NON");
		btnno.setFont(new Font("Arial", Font.PLAIN, 16));
		btnno.setBounds(170, 100, 80, 30);
		panel.add(btnno);
		btnno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
	}
}
