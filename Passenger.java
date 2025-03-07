//package ProjetOOP;
//import java.sql.*;
//
//class Passenger {
//	 private static final String BDD = "jdbc:mysql://localhost:3306/airlines"; 
//	 private static final String USER = "root"; 
//	 private static final String PASSWORD = "Iambadrelafi3"; 
//   
//	 private int idclients;
//	 static int compteurclient= 0;
//	 
//	 private String name;
//    private String passportNumber;
//    private String contactNumber;
//
//    public Passenger(Connection connection, String nom, String  prenom, String email, String passport, String carte) throws SQLException {
//        String query = "INSERT INTO clients (user_id, nom, prenom, email, idPassport, Cartepaiment) VALUES (?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setInt(1, compteurclient++);
//            preparedStatement.setString(2, nom);
//            preparedStatement.setString(3, prenom);
//            preparedStatement.setString(4, email);
//            preparedStatement.setString(5, passport);
//            preparedStatement.setString(6, carte);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected > 0) {
//                System.out.println("Client inserted successfully.");
//            }
//        } 
//    }
//
//    
//    public static void getVols(Connection connection) throws SQLException {
//        String requete = "SELECT * FROM vols";
//        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(requete)) {
//            while (resultSet.next()) {
//                int idVol = resultSet.getInt("idvol");
//                String airline = resultSet.getString("airline");
//                String destination = resultSet.getString("");
//                String datedepart = resultSet.getString("date");
//
//                System.out.println("Flight ID: " + idVol + ", Airline: " + airline + ", Date: ");
//            }
//        }
//    }
//
//
//    
//    
//    public String getName() { return name; }
//
//
//    
//
//}