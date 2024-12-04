/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registration;

/**
 *
 * @author eleft
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class Registration extends JFrame implements ActionListener {
    //Δήλωση πεδίων κειμένου για εισαγωγή ονόματος χρήστη,τ.κ.,αριθμού τηλ.,διεύθυνσης,Ημερομηνία Γεν. και email 
    private JTextField usernameField, postcodeField, phoneField, addressField, dobField, emailField;
    //Δήλωση JPasswordField για εισαγωγή κωδικού
    private JPasswordField passField;
    //Δήλωση  JButton για δημιουργία κουμπιού
    private JButton submitButton;

    //Κατασκευαστής
    public Registration() {
        //Δημιουργία τίτλου Registration Form
        setTitle("Registration Form");
        //Η εφαρμογή θα τερματιστεί όταν ο χρήστης κλείσει το παράθυρο
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //// Ορίζει το αρχικό μέγεθος του παραθύρου σε πλάτος 350 pixels και ύψος 250 pixels.
        setSize(350, 250);
        // Τοποθετεί το παράθυρο στο κέντρο της οθόνης.
        setLocationRelativeTo(null);
       // Χρησιμοποιεί ένα GridLayout για να διατάξει τα στοιχεία σε 8 γραμμές και 2 στήλες
        setLayout(new GridLayout(8, 2));

        //Δημιουργεί και προσθέτει μια ετικέτα με όνομα "Username:" στο frame
        add(new JLabel("Username:"));
        // Δημιουργεί ένα JTextField για την εισαγωγή του ονόματος χρήστη και το προσθέτει στο frame.
        usernameField = new JTextField();
        add(usernameField);

        //Δημιουργεί και προσθέτει μια ετικέτα με όνομα "Password:" στο frame
        add(new JLabel("Password:"));
        // Δημιουργεί ένα JPasswordField για την εισαγωγή του κωδικού πρόσβασης και το προσθέτει στο frame
        passField = new JPasswordField();
        add(passField);

        //Δημιουργεί και προσθέτει μια ετικέτα με όνομα "Email:" στο frame
        add(new JLabel("Email:"));
        // Δημιουργεί ένα JTextField για την εισαγωγή του email και το προσθέτει στο frame.
        emailField = new JTextField();
        add(emailField);

        //Δημιουργεί και προσθέτει μια ετικέτα με όνομα "Phone:" στο frame
        add(new JLabel("Phone:"));
        // Δημιουργεί ένα JTextField για την εισαγωγή του αριθμού τηλεφώνου και το προσθέτει στο frame.
        phoneField = new JTextField();
        add(phoneField);

        //Δημιουργεί και προσθέτει μια ετικέτα με όνομα "Date of Birth:" στο frame
        add(new JLabel("Date of Birth:"));
        // Προσθέτει ένα JLabel με το κείμενο "Date of Birth:" στο frame για την ετικέτα του πεδίου ημερομηνίας γέννησης.
        dobField = new JTextField();
        add(dobField);

         //Δημιουργεί και προσθέτει μια ετικέτα με όνομα "Address:" στο frame
        add(new JLabel("Address:"));
        // Δημιουργεί ένα JTextField για την εισαγωγή της διεύθυνσης και το προσθέτει στο frame.
        addressField = new JTextField();
        add(addressField);

         //Δημιουργεί και προσθέτει μια ετικέτα με όνομα "Postcode:" στο frame
        add(new JLabel("Postcode:"));
        // Δημιουργεί ένα JTextField για την εισαγωγή του ταχυδρομικού κώδικα και το προσθέτει στο frame.
        postcodeField = new JTextField();
        add(postcodeField);

        // Δημιουργεί ένα JButton με την ετικέτα "Submit" για την υποβολή της φόρμας.
        submitButton = new JButton("Submit");
        // Προσθέτει έναν ActionListener στο κουμπί υποβολής, ο οποίος θα εκτελείται όταν ο χρήστης κάνει κλικ στο κουμπί.
        submitButton.addActionListener(this);
        // Προσθέτει το κουμπί υποβολής (submitButton) στο frame.
        add(submitButton);
        // Ορίζει το frame ως ορατό, ώστε να εμφανιστεί η φόρμα όταν η εφαρμογή εκτελεστεί
        setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
         // Έλεγχος εάν το συμβάν προέρχεται από το κουμπί υποβολής (submitButton).
        if (e.getSource() == submitButton) {
             // Λήψη των δεδομένων που εισήγαγε ο χρήστης από τα πεδία κειμένου.
            String username = usernameField.getText();
            String password = new String(passField.getPassword());
            String email = emailField.getText();
            String phone = phoneField.getText();
            String dob = dobField.getText();
            String address = addressField.getText();
            String postcode = postcodeField.getText();

            try {
                // Φόρτωση του MySQL JDBC driver.
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Σύνδεση με τη βάση δεδομένων MySQL μέσω της JDBC.
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_schema", "root", "password");
                // Προετοιμασία ενός SQL insert ερωτήματος για την καταχώρηση των δεδομένων στη βάση.
                PreparedStatement stmt = con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?)");
                // Θέτει τις τιμές για κάθε στήλη του πίνακα. Η πρώτη στήλη (id) είναι 0, καθώς προφανώς είναι το primary key.
                stmt.setInt(1, 0);
                stmt.setString(2, username);
                stmt.setString(3, password);
                stmt.setString(4, email);
                stmt.setString(5, phone);
                stmt.setString(6, dob);
                stmt.setString(7, address);
                stmt.setString(8, postcode);
                 // Εκτέλεση του ερωτήματος για την αποθήκευση των δεδομένων στη βάση.
                stmt.executeUpdate();
                // Κλείσιμο της σύνδεσης με τη βάση δεδομένων.
                con.close();
            } catch (Exception ex) {
                  // Σε περίπτωση εξαίρεσης, εκτυπώνεται το stack trace για να εντοπιστεί το πρόβλημα
                ex.printStackTrace();
            }

            //Εμφάνιση των πληροφοριών του χρήστη στην κονσόλα για επιβεβαίωση.
            System.out.println("User Registered: " + username);
            System.out.println("Password: " + password);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("Date of Birth: " + dob);
            System.out.println("Address: " + address);
            System.out.println("Postcode: " + postcode);
            
            // Καθαρισμός πεδίων
            usernameField.setText("");
            passField.setText("");
            emailField.setText("");
            phoneField.setText("");
            dobField.setText("");
            addressField.setText("");
            postcodeField.setText("");

            // Άνοιγμα παραθύρου login μετά την επιτυχή εγγραφή
            new loginframe();
            //κλείσιμο του παραθύρου
            this.dispose();
        }
    }

     public static void main(String[] args) {
                // Εκκίνηση της φόρμας εγγραφής όταν ξεκινήσει η εφαρμογή.
                new Registration();
     } 
}