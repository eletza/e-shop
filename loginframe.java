/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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


public class loginframe extends JFrame implements ActionListener {
    // Πεδίο εισαγωγής κειμένου για το όνομα χρήστη.
    private JTextField usernameField;
     // Πεδίο εισαγωγής για τον κωδικό πρόσβασης, με απόκρυψη χαρακτήρων.
    private JPasswordField passwordField;
    // Κουμπί για υποβολή της φόρμας σύνδεσης.
    private JButton loginButton;
    // Κουμπί για μετάβαση στη φόρμα εγγραφής
    private JButton registerButton;
    // Ετικέτα για εμφάνιση μηνυμάτων.
    private JLabel promptLabel;

    //Κατασκευαστής
    public loginframe() {
         // Τίτλος του παραθύρου σύνδεσης.
        setTitle("User Login");
         // Χρήση null layout, ώστε να τοποθετούνται χειροκίνητα οι συντεταγμένες των στοιχείων.
        setLayout(null);
         // Θέτει το μέγεθος του παραθύρου σε 350x300 pixels.
        setSize(350, 300);
        // Κεντράρει το παράθυρο στη μέση της οθόνης.
        setLocationRelativeTo(null);
        
        // Δημιουργία και τοποθέτηση των στοιχείων της διεπαφής (πεδία κειμένου, κουμπιά κ.λπ.).
        createUIComponents();
        
        // Καθορίζει ότι όταν ο χρήστης κλείσει το παράθυρο, η εφαρμογή θα τερματιστεί.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
          // Κάνει το παράθυρο ορατό στην οθόνη.
        setVisible(true);
    }

    private void createUIComponents() {
        // Δημιουργία ετικέτας τίτλου "LOGIN".
        JLabel titleLabel = new JLabel("LOGIN");
        // Ορισμός γραμματοσειράς Arial, με έντονη γραφή και μέγεθος 20.
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        // η ετικέτα θα ξεκινά 130 μονάδες pixel από την αριστερή πλευρά του παραθύρου.
        // η ετικέτα θα τοποθετηθεί 20 μονάδες pixel από την κορυφή.
        //η ετικέτα θα έχει πλάτος 100 μονάδες pixel.
        //η ετικέτα θα έχει ύψος 30 μονάδες pixel.
        titleLabel.setBounds(130, 20, 100, 30);
        // Προσθήκη της ετικέτας στο παράθυρο.
        add(titleLabel);

         //Κλήση βοηθητικής μεθόδου για την προσθήκη της ετικέτας "Username" στις συντεταγμένες (70, 60).
        addLabelAndField("Username:", 70, 60);
        // Δημιουργία πεδίου εισαγωγής κειμένου για το όνομα χρήστη.
        usernameField = new JTextField();
        // η ετικέτα θα ξεκινά 150 μονάδες pixel από την αριστερή πλευρά του παραθύρου.
        // η ετικέτα θα τοποθετηθεί 65 μονάδες pixel από την κορυφή.
        //η ετικέτα θα έχει πλάτος 150 μονάδες pixel.
        //η ετικέτα θα έχει ύψος 25 μονάδες pixel.
        usernameField.setBounds(150, 65, 150, 25);
        // Προσθήκη του πεδίου εισαγωγής κειμένου στο παράθυρο.
        add(usernameField);

        //Κλήση βοηθητικής μεθόδου για την προσθήκη της ετικέτας "Password" στις συντεταγμένες (70, 100).
        addLabelAndField("Password:", 70, 100);
        // Δημιουργία πεδίου εισαγωγής κωδικού πρόσβασης (απόκρυψη χαρακτήρων).
        passwordField = new JPasswordField();
        // η ετικέτα θα ξεκινά 150 μονάδες pixel από την αριστερή πλευρά του παραθύρου.
        // η ετικέτα θα τοποθετηθεί 105 μονάδες pixel από την κορυφή.
        //η ετικέτα θα έχει πλάτος 150 μονάδες pixel.
        //η ετικέτα θα έχει ύψος 25 μονάδες pixel.
        passwordField.setBounds(150, 105, 150, 25);
         // Προσθήκη του πεδίου εισαγωγής κωδικού στο παράθυρο.
        add(passwordField);

         // Δημιουργία κουμπιού "Login".
        loginButton = new JButton("Login");
        // η ετικέτα θα ξεκινά 80 μονάδες pixel από την αριστερή πλευρά του παραθύρου.
        // η ετικέτα θα τοποθετηθεί 160 μονάδες pixel από την κορυφή.
        //η ετικέτα θα έχει πλάτος 80 μονάδες pixel.
        //η ετικέτα θα έχει ύψος 30 μονάδες pixel.
        loginButton.setBounds(80, 160, 80, 30);
        // Προσθήκη ακροατή για το πάτημα του κουμπιού
        loginButton.addActionListener(this);
        add(loginButton);

        //  Δημιουργία κουμπιού "Sign Up".
        registerButton = new JButton("Sign Up");
        // η ετικέτα θα ξεκινά 200 μονάδες pixel από την αριστερή πλευρά του παραθύρου.
        // η ετικέτα θα τοποθετηθεί 160 μονάδες pixel από την κορυφή.
        //η ετικέτα θα έχει πλάτος 80 μονάδες pixel.
        //η ετικέτα θα έχει ύψος 30 μονάδες pixel
        registerButton.setBounds(200, 160, 80, 30);
         // Προσθήκη ακροατή για το πάτημα του κουμπιού
        registerButton.addActionListener(this);
        add(registerButton);

        // Δημιουργία ετικέτας για να ενημερώνει τον χρήστη ότι δεν έχει λογαριασμό.
        promptLabel = new JLabel("Don't have an account?");
         // η ετικέτα θα ξεκινά 90 μονάδες pixel από την αριστερή πλευρά του παραθύρου.
        // η ετικέτα θα τοποθετηθεί 200 μονάδες pixel από την κορυφή.
        //η ετικέτα θα έχει πλάτος 200 μονάδες pixel.
        //η ετικέτα θα έχει ύψος 30 μονάδες pixel
        promptLabel.setBounds(90, 200, 200, 30);
        add(promptLabel);
    }
    
    // Ιδιωτική μέθοδος που προσθέτει μια ετικέτα (label) στο πλαίσιο
    private void addLabelAndField(String labelText, int labelX, int labelY) {
        JLabel label = new JLabel(labelText);
        label.setBounds(labelX, labelY, 100, 25);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          // Έλεγχος αν το γεγονός (event) προήλθε από το κουμπί σύνδεσης (loginButton)
        if (e.getSource() == loginButton) {
             // Αν ναι, καλεί τη μέθοδο handleLogin() για να διαχειριστεί τη διαδικασία σύνδεση
            handleLogin();
            // // Έλεγχος αν το γεγονός (event) προήλθε από το κουμπί εγγραφής (registerButton)
        } else if (e.getSource() == registerButton) {
            // Αν ναι, καλεί τη μέθοδο handleRegister() για να διαχειριστεί τη διαδικασία εγγραφής
            handleRegister();
        }
    }

    private void handleLogin() {
         // Λαμβάνουμε το όνομα χρήστη και τον κωδικό πρόσβασης από τα αντίστοιχα πεδία
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        try {
             // Φορτώνουμε τον JDBC driver για τη σύνδεση με τη βάση δεδομένων MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
             // Δημιουργούμε τη σύνδεση με τη βάση δεδομένων
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_schema", "root", "password");
           // Δημιουργούμε το PreparedStatement για την εκτέλεση του SQL query
            PreparedStatement ps = con.prepareStatement("INSERT INTO login VALUES (?, ?, ?)");
           // Ορίζουμε τις τιμές του SQL query
            ps.setInt(1, 0);
            ps.setString(2, user);
            ps.setString(3, pass);
             // Εκτελούμε το SQL query 
            ps.execute();
             // Εμφανίζουμε μήνυμα επιτυχίας στον χρήστη
            JOptionPane.showMessageDialog(this, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Δημιουργούμε και εμφανίζουμε το παράθυρο προϊόντων
            new catalogsProducts().setVisible(true);
             // Κλείνουμε το τρέχον παράθυρο (login frame)
            dispose();
        } catch (Exception ex) {
             // Σε περίπτωση σφάλματος, εμφανίζουμε μήνυμα σφάλματος
            JOptionPane.showMessageDialog(this, "Invalid login!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleRegister() {
         // Δημιουργεί ένα νέο παράθυρο εγγραφής
        new Registration();
        // Ενημερώνει την κονσόλα ότι ξεκίνησε η διαδικασία εγγραφής
        System.out.println("Sign up initiated");
        // Κλείνει το παράθυρο 
        dispose();
    }

    public static void main(String[] args) {
        // Δημιουργεί ένα νέο αντικείμενο της κλάσης loginframe, το οποίο ανοίγει το παράθυρο σύνδεσης
        new loginframe();
        }
}
