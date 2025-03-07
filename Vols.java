//package ProjetOOP;
//import java.time.LocalDate;
//import java.util.Date;
//import java.sql.*;
//
//
//
//class Vols {
//	 private static final String BDD = "jdbc:mysql://localhost:3306/airlines"; 
//	 private static final String USER = "root"; 
//	 private static final String PASSWORD = "Iambadrelafi3"; 
//	 
//    private String flightNumber;
//    private String source;
//    private String destination;
//    private int totalSeats;
//    private int availableSeats;
//
//    public Vols(String flightNumber, String source, String destination, int totalSeats) {
//        this.flightNumber = flightNumber;
//        this.source = source;
//        this.destination = destination;
//        this.totalSeats = totalSeats;
//        this.availableSeats = totalSeats;
//    }
//
//    public boolean checkAvailability() {
//        return availableSeats > 0;
//    }
//
//    public boolean bookSeat() {
//        if (checkAvailability()) {
//            availableSeats--;
//            return true;
//        }
//        return false;
//    }
//
//    public void cancelSeat() {
//        if (availableSeats < totalSeats) {
//            availableSeats++;
//        }
//    }
//
//    public static void getAllFlights(Connection connection) throws SQLException {
//        String query = "SELECT * FROM vols";
//        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
//            while (resultSet.next()) {
//                int idVol = resultSet.getInt("idvol");
//                String airline = resultSet.getString("airline");
//                String date = resultSet.getString("date");
//
//                System.out.println("Flight ID: " + idVol + ", Airline: " + airline + ", Date: " + date);
//            }
//        }
//    }
//
//    
//    
//    // Getters
//    public String getFlightNumber() { return flightNumber; }
//    public String getSource() { return source; }
//    public String getDestination() { return destination; }
//}