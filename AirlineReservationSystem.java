//package ProjetOOP;
//
//import java.util.ArrayList;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//
//public class AirlineReservationSystem extends JFrame {
//    // Flight Management
//    private ArrayList<Vols> flights = new ArrayList<>();
//    private ArrayList<Reservation> reservations = new ArrayList<>();
//
//    // GUI Components
//    private JTextField nameField, passportField, contactField;
//    private JComboBox<String> flightSelector;
//    private JTextArea outputArea;
//
//    public AirlineReservationSystem() {
//        // Frame Setup
//        setTitle("Airline Reservation System");
//        setSize(600, 500);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        // Initialize Flights
//        initializeFlights();
//
//        // Create Panels
//        JPanel inputPanel = createInputPanel();
//        JPanel actionPanel = createActionPanel();
//        JPanel outputPanel = createOutputPanel();
//
//        // Add Panels to Frame
//        add(inputPanel, BorderLayout.NORTH);
//        add(actionPanel, BorderLayout.CENTER);
//        add(new JScrollPane(outputPanel), BorderLayout.SOUTH);
//    }
//
//    // Initialize Sample Flights
//    private void initializeFlights() {
//        flights.add(new Vols("AI101", "Paris", "New York", 50));
//        flights.add(new Vols("BA202", "London", "Tokyo", 75));
//        flights.add(new Vols("QA303", "Dubai", "Sydney", 60));
//    }
//
//    // Create Input Panel
//    private JPanel createInputPanel() {
//        JPanel panel = new JPanel(new GridLayout(4, 2));
//        panel.setBorder(BorderFactory.createTitledBorder("Passenger Details"));
//
//        panel.add(new JLabel("Name:"));
//        nameField = new JTextField();
//        panel.add(nameField);
//
//        panel.add(new JLabel("Passport Number:"));
//        passportField = new JTextField();
//        panel.add(passportField);
//
//        panel.add(new JLabel("Contact Number:"));
//        contactField = new JTextField();
//        panel.add(contactField);
//
//        panel.add(new JLabel("Select Flight:"));
//        flightSelector = new JComboBox<>();
//        for (Vols flight : flights) {
//            flightSelector.addItem(flight.getFlightNumber() + " - " + 
//                                   flight.getSource() + " to " + 
//                                   flight.getDestination());
//        }
//        panel.add(flightSelector);
//
//        return panel;
//    }
//
//    // Create Action Panel
//    private JPanel createActionPanel() {
//        JPanel panel = new JPanel();
//        JButton bookButton = new JButton("Book Ticket");
//        JButton cancelButton = new JButton("Cancel Booking");
//
//        bookButton.addActionListener(e -> bookTicket());
//        cancelButton.addActionListener(e -> cancelTicket());
//
//        panel.add(bookButton);
//        panel.add(cancelButton);
//
//        return panel;
//    }
//
//    // Create Output Panel
//    private JPanel createOutputPanel() {
//        JPanel panel = new JPanel(new BorderLayout());
//        outputArea = new JTextArea();
//        outputArea.setEditable(false);
//        panel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
//        return panel;
//    }
//
//    // Book Ticket Method
//    private void bookTicket() {
//        // Validate Input
//        if (validateInput()) {
//            // Create Passenger
//            Passenger passenger = new Passenger(
//                nameField.getText(), 
//                passportField.getText(), 
//                contactField.getText()
//            );
//
//            // Get Selected Flight
//            Vols selectedFlight = flights.get(flightSelector.getSelectedIndex());
//
//            // Create Reservation
//            Reservation reservation = new Reservation(passenger, selectedFlight);
//
//            // Confirm Reservation
//            if (reservation.confirmReservation()) {
//                reservations.add(reservation);
//                updateOutput("Booking Successful!\n" +
//                             "Reservation ID: " + reservation.getReservationId() + "\n" +
//                             "Passenger: " + passenger.getName() + "\n" +
//                             "Flight: " + selectedFlight.getFlightNumber());
//                clearFields();
//            } else {
//                JOptionPane.showMessageDialog(this, 
//                    "Booking Failed. No seats available.", 
//                    "Reservation Error", 
//                    JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    // Cancel Ticket Method
//    private void cancelTicket() {
//        // Implement ticket cancellation logic
//        String reservationId = JOptionPane.showInputDialog(
//            this, "Enter Reservation ID to Cancel:"
//        );
//
//        if (reservationId != null && !reservationId.trim().isEmpty()) {
//            boolean found = false;
//            for (Reservation res : reservations) {
//                if (res.getReservationId().equals(reservationId)) {
//                    // Cancel logic
//                    res.getFlight().cancelSeat();
//                    reservations.remove(res);
//                    updateOutput("Reservation " + reservationId + " cancelled successfully.");
//                    found = true;
//                    break;
//                }
//            }
//
//            if (!found) {
//                JOptionPane.showMessageDialog(this, 
//                    "Reservation not found.", 
//                    "Cancellation Error", 
//                    JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    // Input Validation
//    private boolean validateInput() {
//        if (nameField.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please enter name");
//            return false;
//        }
//        if (passportField.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please enter passport number");
//            return false;
//        }
//        if (contactField.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please enter contact number");
//            return false;
//        }
//        return true;
//    }
//
//    // Update Output Area
//    private void updateOutput(String message) {
//        outputArea.append(message + "\n\n");
//    }
//
//    // Clear Input Fields
//    private void clearFields() {
//        nameField.setText("");
//        passportField.setText("");
//        contactField.setText("");
//    }
//
//    // Main Method
////    public static void main(String[] args) {
////        SwingUtilities.invokeLater(() -> {
////            new AirlineReservationSystem().setVisible(true);
////        });
////    }
//}