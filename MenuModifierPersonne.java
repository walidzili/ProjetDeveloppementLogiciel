package sys;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MenuModifierPersonne extends JFrame{

    private PersonneDAO personneDAO;
	
	public static void main(String[] args) {

		EventQueue.invokeLater(()->
		{
			JFrame frame=new MenuModifierPersonne();
			frame.setTitle("Modification Personne");
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
	
	public MenuModifierPersonne() {
		personneDAO=new PersonneDAO();
		SimpleDateFormat format=new SimpleDateFormat("ddMMyyyy");
		
		JPanel panel;
		JLabel lbnom,lbprenom,lbdate,lbfonction,lbid;
		JTextField tfnom,tfprenom,tfdate,tffonction,tfid;
		JButton btnmodifier;
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1600,700);
		setContentPane(panel);
		setLocationRelativeTo(null);
		
		lbnom=new JLabel("Nom");
		lbnom.setFont(new Font("Arial", Font.PLAIN, 16));
		lbnom.setBounds(100, 30, 100, 40);
		panel.add(lbnom);
		
		tfnom=new JTextField();
		tfnom.setBounds(250, 30, 300, 40);
		tfnom.setColumns(10);
		panel.add(tfnom);
		
		lbprenom=new JLabel("Prenom");
		lbprenom.setFont(new Font("Arial", Font.PLAIN, 16));
		lbprenom.setBounds(100, 110, 100, 40);
		panel.add(lbprenom);
		
		tfprenom=new JTextField();
		tfprenom.setBounds(250, 110, 300, 40);
		tfprenom.setColumns(10);
		panel.add(tfprenom);
		
		lbdate=new JLabel("Date de naissance");
		lbdate.setFont(new Font("Arial", Font.PLAIN, 16));
		lbdate.setBounds(100, 190, 200, 40);
		panel.add(lbdate);
		
		tfdate=new JTextField();
		tfdate.setBounds(250, 190, 300, 40);
		tfdate.setColumns(10);
		panel.add(tfdate);
		
		lbfonction=new JLabel("Fonction");
		lbfonction.setBounds(100, 280, 100, 40);
		lbfonction.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(lbfonction);
		
		tffonction=new JTextField();
		tffonction.setBounds(250, 280, 300, 40);
		tffonction.setColumns(10);
		panel.add(tffonction);
		
		lbid=new JLabel("ID");
		lbid.setBounds(100, 360, 100, 40);
		lbid.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(lbid);
		
		tfid=new JTextField();
		tfid.setBounds(250, 360, 300, 40);
		tfid.setColumns(10);
		panel.add(tfid);
		
		btnmodifier=new JButton("Modifier");
		btnmodifier.setFont(new Font("Arial", Font.PLAIN, 16));
		btnmodifier.setBounds(100, 500, 200, 40);
		panel.add(btnmodifier);
		btnmodifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int retour;
					Date date;
					date = format.parse(tfdate.getText());
					Personne personne=new Personne(tfnom.getText(), tfprenom.getText(), date, tffonction.getText(), Integer.parseInt(tfid.getText()));
					retour=personneDAO.modifier(personne);
					if(retour!=0)
						System.out.println(""+retour+" personne modifi¨¦e");
					else
						System.out.println("personne non trouv¨¦e");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
}
