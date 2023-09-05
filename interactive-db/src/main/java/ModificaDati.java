import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class ModificaDati {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[] { "database_collegato" };
        }

        Scanner scanner = new Scanner(System.in);

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            // Stampa la tabella "prodotti" affinché l'utente possa vedere i prodotti che
            // può modificare
            VisualizzaDati.main(args);

            // Ciclo while per scegliere il prodotto da modificare
            int productId = 0;

            while (true) {

                try {
                    System.out.println("Quale prodotto vuoi modificare (inserisci l'ID)?");
                    productId = scanner.nextInt();
                    scanner.nextLine();

                    String isContainedSql = "SELECT EXISTS (SELECT 1 FROM prodotti WHERE id = " + productId
                            + ") AS isContained;";
                    Statement isContainedStmt = conn.createStatement();
                    ResultSet isContainedRs = isContainedStmt.executeQuery(isContainedSql);
                    Integer isContained = isContainedRs.getInt("isContained");

                    if (isContained == 1) {
                        System.out.println("Hai scelto il prodotto con ID #" + productId);
                        break;
                    } else {
                        System.out.println("L'ID scelto non esiste. Riprovare.");
                        continue;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Non hai scelto un ID valido.");
                    scanner.next();
                }
            }

            // Ciclo while per scegliere la proprietà da modificare
            int choice = 0;

            while (true) {
                try {
                    System.out.println("Quale proprietà del prodotto vuoi modificare?");

                    System.out.println("1: Nome");
                    System.out.println("2: Quantità");
                    System.out.println("3: Prezzo");

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice >= 1 && choice <= 3) {
                        break;
                    } else {
                        continue;
                    }

                } catch (Exception e) {
                    System.out.println("Devi scegliere una delle opzioni disponibili.");
                    scanner.next();
                }
            }

            // Switch per inserire nuovi valori per la proprietà scelta
            switch (choice) {
                case 1:
                    System.out.println("Scegli il nuovo nome del prodotto:");
                    String productNewName = scanner.nextLine();

                    String sqlName = "UPDATE prodotti SET nome = ? WHERE id = " + productId;
                    PreparedStatement pstmtName = conn.prepareStatement(sqlName);
                    pstmtName.setString(1, productNewName);
                    pstmtName.executeUpdate();

                    break;

                case 2:
                    int productNewQty = 0;

                    while (true) {

                        try {
                            System.out.println("Scegli la nuovo quantità del prodotto:");
                            productNewQty = scanner.nextInt();
                            scanner.nextLine();
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Non hai inserito un valore valido.");
                            scanner.next();
                        }
                    }

                    String sqlQty = "UPDATE prodotti SET quantita = ? WHERE id = " + productId;
                    PreparedStatement pstmtQty = conn.prepareStatement(sqlQty);
                    pstmtQty.setInt(1, productNewQty);
                    pstmtQty.executeUpdate();

                    break;

                case 3:
                    double productNewPrice = 0;

                    while (true) {
                        try {
                            System.out.println("Scegli il nuovo prezzo del prodotto:");
                            productNewPrice = scanner.nextDouble();
                            scanner.nextLine();
                            break;

                        } catch (Exception e) {
                            System.out.println("Non hai inserito un valore valido.");
                            scanner.next();
                        }
                    }

                    String sqlPrice = "UPDATE prodotti SET prezzo = ? WHERE id = " + productId;
                    PreparedStatement pstmtPrice = conn.prepareStatement(sqlPrice);
                    pstmtPrice.setDouble(1, productNewPrice);
                    pstmtPrice.executeUpdate();

                    break;

                default:
                    System.out.println("Opzione non valida. Riprova.");
            }

            System.out.println("Dati aggiornati con successo.");
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
    }
}