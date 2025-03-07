package ProjetOOP;

import javax.swing.*;

import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Airline {
	


	
    private JPanel mainPanel; 
    private CardLayout cardLayout;
    private JLayeredPane layeredPane ;
    private JTextField Départ_Field ;
    private JTextField Destination_Field ;
    private JTextField DATE_Field ;
    private JTextField firstNameField  ;
    private JTextField lastNameField ;
    private JTextField cardField ;
    private JTextField emailField ;
    private JComboBox<String> flightClassCombo ;
    private JComboBox<String> flightDeatilsCombo ;
    private String selectedClass ;
    private String selectedpassenger ;
    private String selectedFlight ;
    
    
    
    
    
    private String depart;
    private String destinations;
    private String datevol;

    private String firstName;
    private String lastName;
    private String passportNumber;
    private String email;
    private String cartepay;
    static int userId = 100;
    int volId;
     
    
    
    
    public Airline() {
        
        JFrame MainFrame = new JFrame("FLY EEA");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setBounds(50, 0, 1400, 800);
        MainFrame.setLayout(new BorderLayout());
    	    
	    
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1400, 800);
        MainFrame.add(layeredPane);
         
        ImageIcon icone = new ImageIcon(Airline.class.getResource("avion.png"));
        MainFrame.setIconImage(icone.getImage());
        
        
        ImageIcon icon = new ImageIcon(Airline.class.getResource("imageAvion.png"));

        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, 1400, 800);
        layeredPane.add(background, Integer.valueOf(0)); 

        JLabel welcome_1 = new JLabel("Welcome to EEA");
        welcome_1.setBounds(50, 100, 400, 100);
        welcome_1.setFont(new Font("Arial", Font.BOLD, 32));
      
        layeredPane.add(welcome_1, Integer.valueOf(1));
        
	system.out.println("ce ligne est modifi�");

        JLabel welcome_2 = new JLabel("PREMIUM ECONOMY");
        welcome_2.setBounds(50, 100, 600, 200);
        welcome_2.setFont(new Font("Arial", Font.BOLD, 55));
     
        layeredPane.add(welcome_2, Integer.valueOf(1));
        
        JLabel welcome_3 = new JLabel("we fly better");
        welcome_3.setBounds(260, 200, 400, 100);
        welcome_3.setFont(new Font("Arial", Font.ITALIC, 34));
      //  welcome_3.setForeground(Color.WHITE);
        layeredPane.add(welcome_3, Integer.valueOf(1));
        
     
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBounds(80, 430, 1210, 150); 
        MainFrame.setLayout(null); 
        mainPanel.setOpaque(false); 
        layeredPane.add(mainPanel, Integer.valueOf(2)); 

        JLabel Message = new JLabel("Book flights across the world and Fly Better with Our AirLines");
        Message.setBounds(400, 600, 600, 40);
        Message.setFont(new Font("Arial", Font.BOLD, 20));
        layeredPane.add(Message,  Integer.valueOf(1));
        
        JLabel Message2= new JLabel("Enjoy the world's best in-flight experience with our multinational cabin crew");
        Message2.setBounds(350, 630, 720, 40);
        Message2.setFont(new Font("Arial", Font.BOLD, 20));
        layeredPane.add(Message2,  Integer.valueOf(1));

      
        addFirstPanel();

       
        MainFrame.setVisible(true);
    }

    private void addFirstPanel() {
    	JPanel panel = new JPanel(null); 
        panel.setBackground(Color.LIGHT_GRAY); 
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));

        // "Départ" label
        JLabel Départ = new JLabel("Departure");
        Départ.setBounds(10, 20, 100, 40);
        Départ.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Départ);

        // "Départ" text field
        Départ_Field = new JTextField(15);
        Départ_Field.setBounds(100, 20, 270, 40);
        Départ_Field.setHorizontalAlignment(SwingConstants.CENTER);
        Départ_Field.setFont(new Font("Arial", Font.ITALIC, 18));
        panel.add(Départ_Field);

        // "Destination" label
        JLabel Destination = new JLabel("Destination");
        Destination.setBounds(390, 20, 100, 40);
        Destination.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Destination);

        // "Destination" text field
        Destination_Field = new JTextField(15);
        Destination_Field.setBounds(490, 20, 270, 40);
        Destination_Field.setHorizontalAlignment(JTextField.CENTER);
        Destination_Field.setFont(new Font("Arial", Font.ITALIC, 18));
        panel.add(Destination_Field);

        // "Date" label and text field
        JLabel DATE = new JLabel("Date");
        DATE.setBounds(800, 20, 500, 40);
        DATE.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(DATE);

        DATE_Field = new JTextField(15);
        DATE_Field.setBounds(850, 20, 270, 40);
        DATE_Field.setText("YYYY-MM-DD");
        DATE_Field.setHorizontalAlignment(JTextField.CENTER);
        DATE_Field.setFont(new Font("Arial", Font.ITALIC, 18));
        panel.add(DATE_Field);

        // "Continue" button
        JButton Continue = new JButton("Continue");
        Continue.setBounds(490, 80, 150, 40);
        Continue.setBackground(Color.RED);
        Continue.setForeground(Color.WHITE);
        Continue.setFont(new Font("Arial", Font.BOLD, 16));
        Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                depart =  Départ_Field.getText();
                destinations = Destination_Field.getText();
                datevol = DATE_Field.getText();
                cardLayout.next(mainPanel);
                addSecondPanel();
            }
        });
        panel.add(Continue);

        // Add the first panel to the CardLayout
        mainPanel.add(panel, "FirstPanel");
    }

    private void addSecondPanel() {
        JPanel secondPanel = new JPanel(null); 
        secondPanel.setBackground(Color.LIGHT_GRAY);

        // "Passengers" label
        JLabel Passengers = new JLabel("Passengers");
        Passengers.setBounds(25, 20, 120, 40);
        Passengers.setFont(new Font("Arial", Font.BOLD, 18));
        secondPanel.add(Passengers);

     
     
        JComboBox<String> passengersCombo = new JComboBox<>(getpasseger());
        passengersCombo.setBounds(150, 20, 180, 40);
        passengersCombo.setFont(new Font("Arial", Font.ITALIC, 16));
        secondPanel.add(passengersCombo);
        passengersCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the JComboBox
                selectedpassenger = (String) passengersCombo.getSelectedItem();
        
            }
        });

        // "Class" label
        JLabel ClassLabel = new JLabel("Class");
        ClassLabel.setBounds(420, 20, 100, 40);
        ClassLabel.setFont(new Font("Arial", Font.BOLD, 18));
        secondPanel.add(ClassLabel);

        // "Class" dropdown
        flightClassCombo = new JComboBox<>(getFlightClasses());
        flightClassCombo.setBounds(490, 20, 190, 40);
        flightClassCombo.setFont(new Font("Arial", Font.ITALIC, 16));
        secondPanel.add(flightClassCombo);
        flightClassCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the JComboBox
                selectedClass = (String) flightClassCombo.getSelectedItem();
            }
        });
        // Fliht deatils
        JLabel FlightLabel = new JLabel("Filght");
        FlightLabel.setBounds(780, 20, 100, 40);
        FlightLabel.setFont(new Font("Arial", Font.BOLD, 18));
        secondPanel.add(FlightLabel);

        // "Class" dropdown
        flightDeatilsCombo = new JComboBox<>(getFlight());
        flightDeatilsCombo.setBounds(860, 20, 250, 40);
        flightDeatilsCombo.setFont(new Font("Arial", Font.ITALIC, 16));
        secondPanel.add(flightDeatilsCombo);
        flightDeatilsCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                selectedFlight = (String) flightDeatilsCombo.getSelectedItem();
            }
        });
        
        JButton Search = new JButton("Search");
        Search.setBounds(490, 80, 150, 40);
        Search.setBackground(Color.RED);
        Search.setForeground(Color.WHITE);
        Search.setFont(new Font("Arial", Font.BOLD, 16));
        Search.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {

            	addThirdPanel();
   
            }
        });
        secondPanel.add(Search);

       
        mainPanel.add(secondPanel, "SecondPanel");

        
        cardLayout.show(mainPanel, "SecondPanel");
    }

    
    private void addThirdPanel() {
        JPanel thirdPanel = new JPanel(null);
        thirdPanel.setBackground(Color.LIGHT_GRAY);
   
        
        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(20, 15, 120, 35);
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        thirdPanel.add(firstNameLabel);

        firstNameField = new JTextField(15);
        firstNameField.setBounds(130, 15, 300, 35);
        firstNameField.setFont(new Font("Arial", Font.ITALIC, 18));
        thirdPanel.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(20, 57, 120, 35);
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        thirdPanel.add(lastNameLabel);

        lastNameField = new JTextField(15);
        lastNameField.setBounds(130, 57, 300, 35);
        lastNameField.setFont(new Font("Arial", Font.ITALIC, 18));
        thirdPanel.add(lastNameField);

        JLabel cinLabel = new JLabel("Passport N°");
        cinLabel.setBounds(680, 15, 120, 35);
        cinLabel.setFont(new Font("Arial", Font.BOLD, 18));
        thirdPanel.add(cinLabel);

        cardField = new JTextField(15);
        cardField.setBounds(785, 15, 350, 35);
        cardField.setFont(new Font("Arial", Font.ITALIC, 18));
        thirdPanel.add(cardField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(680, 57, 120, 35);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));
        thirdPanel.add(emailLabel);

        emailField = new JTextField(15);
        emailField.setBounds(785, 57, 350, 35);
        emailField.setFont(new Font("Arial", Font.ITALIC, 18));
        thirdPanel.add(emailField);

        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(490, 100, 180, 40);
        continueButton.setBackground(Color.RED);
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(new Font("Arial", Font.BOLD, 16));
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                
                passportNumber = cardField.getText();
                email = emailField.getText();

            	
            	addFourthPanel();
            }
        });
        thirdPanel.add(continueButton);

        mainPanel.add(thirdPanel, "ThirdPanel");
        cardLayout.show(mainPanel, "ThirdPanel");
    }
    
    private void addFourthPanel() {
        JPanel thirdPanel = new JPanel(null);
        thirdPanel.setBackground(Color.LIGHT_GRAY);
   
        
        JLabel cardNameLabel = new JLabel("Name on Card");
        cardNameLabel.setBounds(20, 15, 220, 35);
        cardNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        thirdPanel.add(cardNameLabel);

        JTextField cardNameField = new JTextField(15);
        cardNameField.setBounds(160, 15, 300, 35);
        cardNameField.setFont(new Font("Arial", Font.ITALIC, 18));
        thirdPanel.add(cardNameField);

        JLabel ExpiryLabel = new JLabel("Expiry Date");
        ExpiryLabel.setBounds(20, 57, 120, 35);
        ExpiryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        thirdPanel.add(ExpiryLabel);

        JTextField ExpiryField = new JTextField(15);
        ExpiryField.setBounds(160, 57, 300, 35);
        ExpiryField.setFont(new Font("Arial", Font.ITALIC, 18));
        thirdPanel.add(ExpiryField);

        JLabel cardLabel = new JLabel("Card Number");
        cardLabel.setBounds(680, 15, 120, 35);
        cardLabel.setFont(new Font("Arial", Font.BOLD, 16));
        thirdPanel.add(cardLabel);

        cardField = new JTextField(15);
        cardField.setBounds(790, 15, 350, 35);
        cardField.setFont(new Font("Arial", Font.ITALIC, 18));
        thirdPanel.add(cardField);

        JLabel cvcLabel = new JLabel("CVC/CVV");
        cvcLabel.setBounds(680, 57, 120, 35);
        cvcLabel.setFont(new Font("Arial", Font.BOLD, 16));
        thirdPanel.add(cvcLabel);

        JTextField cvcField = new JTextField(15);
        cvcField.setBounds(790, 57, 350, 35);
        cvcField.setFont(new Font("Arial", Font.ITALIC, 18));
        thirdPanel.add(cvcField);

        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(490, 100, 180, 40);
        continueButton.setBackground(Color.RED);
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(new Font("Arial", Font.BOLD, 16));
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cartepay = cardField.getText();
                if (validateInput()) {
                    if (Reservation.saveReservationToDatabase(userId,firstName,lastName,email,passportNumber, cartepay,depart, destinations, datevol, volId)) {
                        cardLayout.next(mainPanel);
                    }
                }
            	addFifthPanel();
            }
        });
        thirdPanel.add(continueButton);

        mainPanel.add(thirdPanel, "ThirdPanel");
        cardLayout.show(mainPanel, "ThirdPanel");
    }
    private void addFifthPanel() {
        JPanel fourthPanel = new JPanel(null);
        fourthPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel SuccessLabel = new JLabel("Your Tecket Has been Successfuly Booked !!");
        SuccessLabel.setBounds(370, 25, 500, 35);
        SuccessLabel.setFont(new Font("Arial", Font.BOLD, 20));
        fourthPanel.add(SuccessLabel);
        
        JLabel NiceLabel = new JLabel("Enjoy your Flight ");
        NiceLabel.setBounds(500, 65, 250, 35);
        NiceLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        fourthPanel.add(NiceLabel);
        
        JButton tecketButton = new JButton("Tecket");
        tecketButton.setBounds(490, 100, 180, 40);
        tecketButton.setBackground(Color.GREEN);
        tecketButton.setForeground(Color.WHITE);
        tecketButton.setFont(new Font("Arial", Font.BOLD, 16));
        tecketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Booking();
            }
        });
        fourthPanel.add(tecketButton);
   
        mainPanel.add(fourthPanel, "ThirdPanel");
        cardLayout.show(mainPanel, "ThirdPanel");
    }
    
   
    private void Booking() {
        // Create an internal frame (child window)
        JInternalFrame internalFrame = new JInternalFrame("Tecket", true, true, true, true);
        internalFrame.setBounds(400, 300, 500, 340);
        internalFrame.setLayout(null); // Set layout to null for absolute positioning
        internalFrame.setBackground(Color.white);
        internalFrame.setVisible(true);

        JLabel FlightLabel = new JLabel(selectedFlight);
        FlightLabel.setBounds(20, 12, 200, 35);
        FlightLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        internalFrame.add(FlightLabel);

        JLabel ClassValue = new JLabel(selectedClass);
        ClassValue.setBounds(300, 12, 250, 35);
        ClassValue.setFont(new Font("Arial", Font.ITALIC, 18));
        internalFrame.add(ClassValue);
        
     // Flight Details
        JLabel flightLabel = new JLabel("From");
        flightLabel.setBounds(20, 42, 70, 35);
        flightLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        internalFrame.add(flightLabel);

        JLabel flightDetails = new JLabel(Départ_Field.getText() + " to " + Destination_Field.getText() + " on " + DATE_Field.getText());
        flightDetails.setBounds(70, 42, 400, 35);
        flightDetails.setFont(new Font("Arial", Font.ITALIC, 16));
        internalFrame.add(flightDetails);
        
        // First Name Label and Field
        JLabel firstNameLabel = new JLabel("First Name :");
        firstNameLabel.setBounds(20, 105, 120, 35);
        firstNameLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        internalFrame.add(firstNameLabel);

        JLabel firstNameValue = new JLabel(firstNameField.getText());
        firstNameValue.setBounds(130, 105, 300, 35);
        firstNameValue.setFont(new Font("Arial", Font.ITALIC, 16));
        internalFrame.add(firstNameValue);

        // Last Name Label and Field
        JLabel lastNameLabel = new JLabel("Last Name :");
        lastNameLabel.setBounds(20, 135, 120, 35);
        lastNameLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        internalFrame.add(lastNameLabel);

         // Access or add the relevant field to the class
        JLabel lastNameValue = new JLabel(lastNameField.getText());
        lastNameValue.setBounds(130, 135, 300, 35);
        lastNameValue.setFont(new Font("Arial", Font.ITALIC, 16));
        internalFrame.add(lastNameValue);

        // CIN Label and Field
        JLabel cinLabel = new JLabel("Passport N° :");
        cinLabel.setBounds(20, 165, 120, 35);
        cinLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        internalFrame.add(cinLabel);

        // Add this field to the main class
        JLabel cinValue = new JLabel(cardField.getText());
        cinValue.setBounds(130, 165, 300, 35);
        cinValue.setFont(new Font("Arial", Font.ITALIC, 16));
        internalFrame.add(cinValue);
        
        JLabel passangerLabel = new JLabel("Passanger :");
        passangerLabel.setBounds(20, 195, 120, 35);
        passangerLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        internalFrame.add(passangerLabel);

        // Add this field to the main class
        JLabel passangerValue = new JLabel(selectedpassenger);
        passangerValue.setBounds(130, 195, 300, 35);
        passangerValue.setFont(new Font("Arial", Font.ITALIC, 16));
        internalFrame.add(passangerValue);
        
       
        JButton CancelButton = new JButton("Cancel");
        CancelButton.setBounds(150, 260, 180, 35);
        CancelButton.setBackground(Color.RED);
        CancelButton.setForeground(Color.WHITE);
        CancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        CancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 cardLayout.show(mainPanel, "FirstPanel");
            	 internalFrame.setVisible(false);
            }
        });
        internalFrame.add(CancelButton);
        

        // Add the internal frame to the layered pane at a higher layer
        layeredPane.add(internalFrame, Integer.valueOf(3));
    }
    
    // Helper method to get flight classes
    private String[] getFlightClasses() {
        return new String[]{"Select Class","Business Class", "First Class", "Premium Economy" , "Economy Class"};
    }
    private String[] getpasseger() {
        return new String[]{"Select Age","Infant", "Child", "Adult" };
    }
    private String[] getFlight() {
        return new String[]{"Select your Flight","A1001 Royal Airline", "A2010 Fly Emmarits", "A3001 Qatar Airways" };
    }


     
    private boolean validateInput() {
        if (firstName.isEmpty() || lastName.isEmpty() || passportNumber.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    
    public static void main(String[] args) {
    
            new Airline();

 
    }
}
