package splitfile.run;
import java.sql.*;

public class Connexion {
	
	public Connection openCo(String url) {
        try{
             
            //Charge le driver jdbc
            Class.forName("oracle.jdbc.driver.OracleDriver");
             
            //Connexion
            Connection c = DriverManager.getConnection(url);
             
            System.out.println("Connexion établie !");
            
            return c;
        }
         
        catch(ClassNotFoundException e){
            System.out.println("Impossible de charger le pilote!");
            return null;
        }
         
        catch(SQLException e){
            System.out.println("Connexion impossible !");
            return null;
        }
         
        }
	
	public static void main(String[] args) throws SQLException{
        String url="jdbc:oracle:thin:localhost:1521:mabase";
        Connexion bd = new Connexion ();
        Connection c =bd.openCo(url);
        
        Statement st = c.createStatement();
        ResultSet rest = st.executeQuery("SELECT Nom FROM XXXX");
        // rest est un curseur , il r´ef´erence la zone des n-uplets r´eponses
        while (rest.next())
        System.out.println (rest.getString(1));
        st.close();

     
}
	
	

}
