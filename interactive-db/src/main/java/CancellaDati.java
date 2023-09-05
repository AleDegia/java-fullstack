import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.util.Scanner;

public class CancellaDati {
    public static void main(String[] args) { 
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[] { "database_collegato" };
        }

        VisualizzaDati.main(args);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci l'ID del prodotto da cancellare:");
        String idProdotto = scanner.next();

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            String sql = "DELETE FROM prodotti WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(idProdotto)); // Cancella il prodotto con l'id inserito dall'utente
            pstmt.executeUpdate();

            System.out.println("Dati cancellati con successo.");
            VisualizzaDati.main(args);

        } catch (SQLException | ClassNotFoundException e) {
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
        // scanner.close();
    }
}