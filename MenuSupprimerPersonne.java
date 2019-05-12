package sys;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MenuSupprimerPersonne extends JFrame{

    private PersonneDAO personneDAO;
	
	public static void main(String[] args) {

		EventQueue.invokeLater(()->
		{
			JFrame frame=new MenuSupprimerPersonne();
			frame.setTitle("Suppression Personne");
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
	
	public MenuSupprimerPersonne() {
		personneDAO=new PersonneDAO(); 
		
		JPanel panel;
		JLabel lbid;
		JTextField tfid;
		JButton btnsupprimer;
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(400,350);
		setContentPane(panel);
		setTitle("Suppression Personne");
		setLocationRelativeTo(null);
		
		lbid=new JLabel("ID");
		lbid.setFont(new Font("Arial", Font.PLAIN, 16));
		lbid.setBounds(50, 60, 70, 40);
		panel.add(lbid);
		
		tfid=new JTextField();
		tfid.setBounds(120, 60, 140, 40);
		tfid.setColumns(10);
		panel.add(tfid);
		
		btnsupprimer=new JButton("Supprimer");
		btnsupprimer.setFont(new Font("Arial", Font.PLAIN, 16));
		btnsupprimer.setBounds(100, 200, 160, 40);
		panel.add(btnsupprimer);
		btnsupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int retour;
				retour=personneDAO.supprimer(Integer.parseInt(tfid.getText()));
				System.out.println(""+retour+" personne supprim¨¦e");
			}
		});
	}
}
