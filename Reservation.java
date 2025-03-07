package ProjetOOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;



class Reservation {

	 private static final String BDD = "jdbc:mysql://localhost:3306/airlines"; 
	 private static final String USER = "root"; 
	 private static final String PASSWORD = "Iambadrelafi3"; 
	 
    static boolean saveReservationToDatabase(int userId, String firstName, String lastName, String email, String passportNumber, String cartepay,
    		String depart, String destinations, String datevol, int volId) {
        Random random = new Random();

        try (Connection connection = DriverManager.getConnection(BDD, USER, PASSWORD)) {
            // Insert into reservations table
            String reservationSQL = "INSERT INTO reservations (reservation_id, user_id, vol_id) VALUES (?, ?, ?)";
            String clientSQL = "INSERT INTO clients (user_id, prenom, nom, email, idPasseport, CartePaiment) VALUES (?, ?, ?, ?, ?, ?)";
            String VolSQL = "INSERT INTO vols(vol_id, origine, destination, tempdepart, temparrive, prix, placesdisponibles) VALUES (?, ?, ?, ?, ?, ?)";
            String getvolSQL = "SELECT vol_id FROM vols WHERE origine = ? AND destination = ? AND datedepart LIKE ?";
            String modificationVol = "UPDATE vols SET placesdisponibles = placesdisponibles - 1 where vol_id = ?";
            
            
            // Insert client
            try (PreparedStatement clientStmt = connection.prepareStatement(clientSQL)) {
            	clientStmt.setInt(1, Airline.userId++);
            	clientStmt.setString(2, firstName);
                clientStmt.setString(3, lastName);
                clientStmt.setString(4, email);
                clientStmt.setString(5, passportNumber);
                clientStmt.setString(6, cartepay);
                
                int clientRows = clientStmt.executeUpdate();
                if (clientRows > 0) {
                    System.out.println("Client inserted successfully.");
                } else {
                    System.err.println("Failed to insert client.");
                    return false;
                }
            }
            
        
            try (PreparedStatement stmt = connection.prepareStatement(getvolSQL)) {
               
                stmt.setString(1, depart);       
                stmt.setString(2, destinations); 
                stmt.setString(3, datevol + "%"); 
                
                try (ResultSet rs = stmt.executeQuery()) {
                    // Process the result set
                    while (rs.next()) {
                        volId = rs.getInt("vol_id");
                        System.out.println("Found vol_id: " + volId);
                    }
                }} catch (SQLException e) {
                    e.printStackTrace(); 
                }
            
            // Insert reservation
            try (PreparedStatement reservationStmt = connection.prepareStatement(reservationSQL)) {
                int reservationId = random.nextInt(100000);
                reservationStmt.setInt(1, reservationId);
                reservationStmt.setInt(2, userId++); 
                reservationStmt.setInt(3, volId); 

                int reservationRows = reservationStmt.executeUpdate();
                if (reservationRows > 0) {
                    System.out.println("Reservation saved successfully.");
                } else {
                    System.err.println("Failed to save reservation.");
                    return false;
                }
            }
            
            
            try (PreparedStatement volreq = connection.prepareStatement(modificationVol)) {
                
                volreq.setInt(1, volId); 
                
                int rowsAffected = volreq.executeUpdate();

                
                if (rowsAffected > 0) {
                    System.out.println("Successfully updated the number of available seats for vol_id: " + volId);
                } else {
                    System.out.println("No rows updated. Please check if the vol_id exists.");
                }
               
                }

            return true; 
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: avion inexistante pour la date definie"); 
               
            return false;
        }
    }
  
    
    
    
}
