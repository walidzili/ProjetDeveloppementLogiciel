package sys;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * classe d'acces aux donnees contenues dans la table personne
 * @author Yuxiao - Zili
 *
 */
public class MenuPersonne extends JFrame{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(()->
		{
			JFrame frame=new MenuPersonne();
			frame.setTitle("Gestion des personnes");
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
	
	public MenuPersonne() {
		
		/**
		 * conteneur
		 */
		JPanel panel;
		JButton btncreer;
		JButton btnsupprimer;
		JButton btnmodifier;
		JButton btnafficher;
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		setSize(400,450);
		setTitle("Gestion des personnes");
		setLocationRelativeTo(null);
		
		btncreer=new JButton("Creer une personne");
		panel.add(btncreer);
		btncreer.setBounds(100, 30, 200, 50);
		btncreer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame=new MenuCreerPersonne();
				frame.setVisible(true);
			}
		});
		
		btnsupprimer=new JButton("Supprimer une personne");
		panel.add(btnsupprimer);
		btnsupprimer.setBounds(100, 110, 200, 50);
		btnsupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame=new MenuSupprimerPersonne();
				frame.setVisible(true);
			}
		});
		
		btnmodifier=new JButton("Modifier une personne");
		panel.add(btnmodifier);
		btnmodifier.setBounds(100, 190, 200, 50);
		btnmodifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame=new MenuModifierPersonne();
				frame.setVisible(true);
			}
		});
		
		btnafficher=new JButton("Afficher");
		panel.add(btnafficher);
		btnafficher.setBounds(100, 270, 200, 50);
		btnafficher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PersonneDAO personneDAO=new PersonneDAO();
				personneDAO.Afficher();
			}
		});
		
		
	}
	
}
