
package tugasprktkm5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Koneksi {
  private static final String URL = "jdbc:mysql://localhost:3306/db_modul5";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("terkoneksi");
        }catch (SQLException e){
            System.out.println("error bang : " + e.getMessage());
        }
        return conn;
    }
    
    public static void main(String[] args){
        getConnection();
    }
}