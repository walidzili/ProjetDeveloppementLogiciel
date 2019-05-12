package sys;

import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;


/**
 * classe d'acces aux donnees contenues dans la table personne
 * @author Yuxiao - Zili
 *
 */
public class PersonneDAO {

	/**
	 * parametres de connexion
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "walid";
	final static String PASS = "walid";
	
	public PersonneDAO(){
		//chargement de pilote de base de donnees
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e){
			System.err.println("Impossible de charger le pilote de BDD,ne pas oublier d'importer le fichier .jar dans le projet ");
		}
	}
	
	/**
	 * permet d'ajouter une personne dans la table personne
	 * @param personne
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int ajouter(Personne personne) {
		Connection con=null;
		PreparedStatement ps=null;
		int retour=0;
		
		//connection a la base de donnees
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("INSERT INTO PERSONNE_P (p_nom,p_prenom,p_date,p_fonction,p_id) VALUES(?,?,?,?,?)");
			ps.setString(1, personne.getNom());
			ps.setString(2, personne.getPrenom());
			Date date=new Date(personne.getDateDeNaissance().getTime());
			ps.setDate(3, date);
			ps.setString(4, personne.getFonction());
			ps.setInt(5, personne.getIdPersonne());
			
			//execution de la requete
			retour=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//fermeture de la connexion et du preparedstatement
			try {
				if(con!=null)
					con.close();
			}catch(Exception ignore) {
				
			}
			try {
				if(ps!=null)
					ps.close();
			}catch(Exception ignore) {
				
			}
		}
		return retour;
	}
	
	public int supprimer(int id) {
		Connection con=null;
		PreparedStatement ps=null;
		int retour=0;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("DELETE FROM PERSONNE_P WHERE p_id = ?");
			ps.setInt(1, id);
			
			retour=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
			}catch(Exception ignore) {
				
			}
			try {
				if(ps!=null)
					ps.close();
			}catch(Exception ignore) {
				
			}
		}
		return retour;
	}
	
	public int modifier(Personne personne) {
		Connection con=null;
		PreparedStatement ps=null;
		int retour=0;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("UPDATE PERSONNE_P SET p_nom=?,p_prenom=?,p_date=?,p_fonction=? WHERE p_id=?");
			ps.setString(1, personne.getNom());
			ps.setString(2, personne.getPrenom());
			Date date=new Date(personne.getDateDeNaissance().getTime());
			ps.setDate(3, date);
			ps.setString(4, personne.getFonction());
			ps.setInt(5, personne.getIdPersonne());
			
			retour=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)
					con.close();
			}catch(Exception ignore) {
				
			}
			try {
				if(ps!=null)
					ps.close();
			}catch(Exception ignore) {
				
			}
		}
		return retour;
	}
	
	public ArrayList<Personne> getListPersonne(){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Personne> retour=new ArrayList<Personne>();
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM PERSONNE_P");
			rs=ps.executeQuery();
			while(rs.next()) {
				Personne personne=new Personne(rs.getString("p_nom"), rs.getString("p_prenom"), rs.getDate("p_date"), rs.getString("p_fonction"), rs.getInt("p_id"));
				personne.setNumeroBadge(rs.getInt("p_b_numero"));
				retour.add(personne);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;
		
	}
	
	public void Afficher() {
		ArrayList<Personne> list=new ArrayList<Personne>();
		PersonneDAO personneDAO=new PersonneDAO();
		list=personneDAO.getListPersonne();
		System.out.println("nom prenom dateDeNaissance fonction id numeroBadge");
		for(Personne personne:list) {
			System.out.println(personne.toString());
		}
	}
	
	public int creerBadge(int id) {
		Connection con=null;
		PreparedStatement ps=null;
		PersonneDAO personneDAO=new PersonneDAO();
		boolean same=false;
		int retour=0;
		Random random=new Random();
		int numero;
		do {
			String result="";
			same=false;
			for(int i=0;i<6;i++) {
				result+=random.nextInt(10);
			}
			numero=Integer.valueOf(result);
			ArrayList<Personne> list=new ArrayList<Personne>();
			for(Personne personne:list) {
				if(personne.getNumeroBadge()==numero)
					same=true;
			}
		}while(same==true);
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("INSERT INTO BADGE_B (b_numero) VALUES (?)");
			ps.setInt(1, numero);
			retour=ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("UPDATE PERSONNE_P set p_b_numero=? WHERE p_id=?");
			ps.setInt(1, numero);
			ps.setInt(2, id);
			retour=ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		System.out.println("Badge cree");
		return retour;
	}

}
