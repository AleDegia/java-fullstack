import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class VisualizzaDati {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("Nome del database non fornito. Uso 'database collegato' come nome di default");
            args = new String[]{"database_collegato"};
        }

        //Creo uno scanner per legger l'inpu dell'utente
        Scanner scanner = new Scanner(System.in);

        //Chiedi all'utente quale categoria vuole visualizzare
        // System.out.println("Inserisci l'ID della categoria che vuoi visualizzare:");
        int idCategoria = scanner.nextInt();

        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:database_collegato.db";
            conn = DriverManager.getConnection(url);

            String sql = "SELECT * FROM prodotti WHERE id_categoria = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idCategoria);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                System.out.println("ID: " + rs.getInt("id") + ", Nome:" + rs.getString("nome") + ", Quantita: " +
                rs.getInt("quantita") + ", Prezzo: " + rs.getDouble("prezzo") + ", ID_Categoria: " + rs.getInt("id_categoria"));
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}