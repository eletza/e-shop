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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
// Δημιουργία μιας κλάσης PaymentOptionsFrame που επεκτείνει την JFrame και ως το παράθυρο για τις επιλογές πληρωμής.
public class PaymentOptionsFrame extends JFrame {
    // Ορίζονται δύο ιδιωτικά μέλη: deliveryAddressField και addressLabel, για την εισαγωγή και εμφάνιση της διεύθυνσης του χρήστη.
    private JTextField deliveryAddressField;
    private JLabel addressLabel;

    // Ο κατασκευαστής PaymentOptionsFrame λαμβάνει δύο παραμέτρους, products και totalAmount, που αναφέρονται στα προϊόντα που αγοράστηκαν και το συνολικό ποσό.
    public PaymentOptionsFrame(String products, double totalAmount) {
        //  Θέτουμε τον τίτλο του παραθύρου σε "Payment Methods".
        setTitle("Payment Methods");
        // Ορίζουμε το κλείσιμο του παραθύρου ως DISPOSE_ON_CLOSE, δηλαδή το παράθυρο θα κλείσει χωρίς να τερματιστεί η εφαρμογή.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Θέτουμε το μέγεθος του παραθύρου σε 450x450 pixels.
        setSize(450, 450);
        // Χρησιμοποιούμε τη μέθοδο setLocationRelativeTo(null) για να τοποθετήσουμε το παράθυρο στο κέντρο της οθόνης.
        setLocationRelativeTo(null);


        // Δημιουργούμε ένα κύριο panel mainPanel με διάταξη BorderLayout και περιθώρια 10 pixels.
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        // Προσθέτουμε το mainPanel στο περιεχόμενο του παραθύρου.
        add(mainPanel);

        // Δημιουργείται ένα JPanel με το όνομα header, το οποίο λειτουργεί ως κεφαλίδα του παραθύρου.
        JPanel header = new JPanel();
        // Ορίζεται το χρώμα φόντου του headerPanel σε ανοιχτό γκρι (LIGHT_GRAY).
        header.setBackground(Color.LIGHT_GRAY);
        // Προστίθεται το headerPanel στο πάνω μέρος (`BorderLayout.NORTH`) του κύριου panel .
        mainPanel.add(header, BorderLayout.NORTH);


        // Δημιουργείται ένα JLabel με το κείμενο "Choose Payment Method", το οποίο χρησιμοποιείται ως τίτλος του παραθύρου.
        JLabel titleLabel = new JLabel("Choose Payment Method");
        // Ορίζεται η γραμματοσειρά του τίτλου σε Arial, έντονη (BOLD) και με μέγεθος 18.
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        // Το titleLabel προστίθεται στο headerPanel.
        header.add(titleLabel);


        // Δημιουργείται ένα νέο JPanel με το όνομα optionsPanel, το οποίο χρησιμοποιεί τη διάταξη `GridBagLayout` για τοποθέτηση στοιχείων.
        JPanel paymentOptionsPanel = new JPanel(new GridBagLayout());
        // Ορίζεται ένα πλαίσιο τίτλου (TitledBorder) γύρω από το panel με το κείμενο "Available Payment Methods".
        paymentOptionsPanel.setBorder(BorderFactory.createTitledBorder("Available Payment Methods"));
        // Το optionsPanel προστίθεται στο κέντρο (BorderLayout.CENTER) του mainPanel.
        mainPanel.add(paymentOptionsPanel, BorderLayout.CENTER);

        // Δημιουργούνται δύο ραδιοκουμπιά (JRadioButton) με τις επιλογές "Card" και "Net Banking", τα οποία θα επιτρέπουν στον χρήστη να επιλέξει τη μέθοδο πληρωμής.
        JRadioButton cardOption = new JRadioButton("Credit/Debit Card");
        JRadioButton netBankingOption= new JRadioButton("Online Banking");

        // Δημιουργείται μια ομάδα κουμπιών (ButtonGroup) με το όνομα paymentOptionsGroup, ώστε να διασφαλίζεται ότι μόνο ένα από τα ραδιοκουμπιά μπορεί να επιλεγεί κάθε φορά
        ButtonGroup paymentOptionsGroup = new ButtonGroup();
        // Τα ραδιοκουμπιά  cardOption  και netBankingOption προστίθενται στην ομάδα κουμπιών paymentOptionsGroup.
        paymentOptionsGroup.add(cardOption);
        paymentOptionsGroup.add(netBankingOption);

        // Δημιουργείται ένα αντικείμενο GridBagConstraints με το όνομα gbc, το οποίο χρησιμοποιείται για τη ρύθμιση της θέσης και του στυλ των στοιχείων που προστίθενται στο `GridBagLayout`
        GridBagConstraints gbc = new GridBagConstraints();
        // Ορίζεται ότι το στοιχείο θα τοποθετηθεί στην πρώτη στήλη (`gridx = 0`) του layout.
        gbc.gridx = 0;
        // Ορίζεται ότι το στοιχείο θα τοποθετηθεί στην πρώτη γραμμή (`gridy = 0`) του layout.
        gbc.gridy = 0;
        // Το στοιχείο θα τοποθετηθεί στην αριστερή πλευρά με τη χρήση του GridBagConstraints.WEST.
        gbc.anchor = GridBagConstraints.WEST;
        // Προστίθεται εσωτερικό περιθώριο (Insets) 5 pixels γύρω από κάθε στοιχείο.
        gbc.insets = new Insets(5, 5, 5, 5);

        // Αυξάνεται η τιμή του gridy κατά 1, δηλαδή τοποθετείται το επόμενο στοιχείο στη δεύτερη γραμμή.
        gbc.gridy++;
        // Προστίθεται το option2RadioButton στο optionsPanel στη θέση που καθορίζεται από το gbc.
         paymentOptionsPanel.add(cardOption, gbc);

        // Αυξάνεται η τιμή του gridy κατά 1, τοποθετώντας έτσι το option3RadioButton στην επόμενη (τρίτη) γραμμή του optionsPanel.
        gbc.gridy++;
         paymentOptionsPanel.add(netBankingOption, gbc);

        // Δημιουργείται ένα πεδίο κειμένου JTextField με το όνομα deliveryAddressField για την εισαγωγή της διεύθυνσης του χρήστη.
        deliveryAddressField = new JTextField();
        // Ορίζεται το μέγεθος του addressTextField σε 300x50 pixels.
        deliveryAddressField.setPreferredSize(new Dimension(300, 50)); // Set preferred size
        // Δημιουργείται ένα JLabel με το όνομα addressLabel και το κείμενο "Address".
        addressLabel = new JLabel("Address");
        // Αυξάνεται η τιμή του gridy κατά 1 .
        gbc.gridy++;
        // προστίθεται το addressLabel στο optionsPanel στη νέα θέση.
         paymentOptionsPanel.add(addressLabel, gbc);

        // Αυξάνεται ξανά η τιμή του `gridy` κατά 1, και το πεδίο κειμένου `deliveryAddressField` προστίθεται στην επόμενη γραμμή του `optionsPanel`.
        gbc.gridy++;
         paymentOptionsPanel.add(deliveryAddressField, gbc);


        // Δημιουργείται ένα νέο `JPanel` με το όνομα `buttonPanel`, το οποίο χρησιμοποιεί το layout `FlowLayout` για την τοποθέτηση των κουμπιών.
        // Ορίζεται το FlowLayout να στοιχίζει τα κουμπιά στη δεξιά πλευρά (FlowLayout.RIGHT).
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Δημιουργείται ένα κουμπί JButton με το όνομα proceedButton και το κείμενο "Proceed".
        JButton proceedButton = new JButton("Proceed");

        // Δημιουργείται ένας ακροατής ενεργειών (ActionListener) για το κουμπί proceedButton.
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosenMethod = "";
                // Όταν ο χρήστης πατάει το κουμπί, ελέγχεται ποια επιλογή πληρωμής έχει επιλεγεί (κάρτα ή Net Banking).
                if (cardOption.isSelected()) {
                    chosenMethod = "Credit/Debit Card";
                } else if (netBankingOption.isSelected()) {
                    chosenMethod = "Online Banking";
                    // Αν δεν έχει επιλεγεί καμία επιλογή, εμφανίζεται ένα μήνυμα προτροπής στον χρήστη να επιλέξει μία.
                } else {
                    JOptionPane.showMessageDialog(PaymentOptionsFrame.this, "Please select a payment method.");
                    return;
                }

                // Λαμβάνεται η διεύθυνση από το πεδίο κειμένου `addressTextField`.
                String address = deliveryAddressField.getText();
                // Αν το πεδίο είναι κενό, εμφανίζεται ένα μήνυμα προτροπής στον χρήστη να εισάγει μια διεύθυνση.
                if (address.isEmpty()) {
                    JOptionPane.showMessageDialog(PaymentOptionsFrame.this,"Please enter your delivery address");
                    return;
                }

                // Εμφανίζονται διαδοχικά μηνύματα που ενημερώνουν τον χρήστη για την επιλεγμένη επιλογή και για την επιτυχή ολοκλήρωση της πληρωμής.
                JOptionPane.showMessageDialog(PaymentOptionsFrame.this, "Selected Option: " +  chosenMethod );
                JOptionPane.showMessageDialog(PaymentOptionsFrame.this,"Payment Successful.Receipt will be saved ");
                // Καλείται η μέθοδος `createReceipt` για τη δημιουργία της απόδειξης, χρησιμοποιώντας τα προϊόντα, το συνολικό ποσό και τη διεύθυνση.
                createReceipt(products, totalAmount, address);
                // Εμφανίζεται μήνυμα που ενημερώνει ότι η απόδειξη έχει ληφθεί και κλείνει το παράθυρο πληρωμών.
                JOptionPane.showMessageDialog(PaymentOptionsFrame.this, "Receipt Saved.Thank you!");
                dispose();
                // Δημιουργείται ένα νέο παράθυρο `catalogsProducts` και εμφανίζεται, επιτρέποντας στον χρήστη να συνεχίσει να ψωνίζει.
                catalogsProducts userDashboard = new catalogsProducts();
                userDashboard.setVisible(true);
            }
        });
        // Προστίθεται το κουμπί `proceedButton` στο `buttonPanel`.
        buttonPanel.add(proceedButton);
        // Το `buttonPanel` προστίθεται στο κάτω μέρος (`BorderLayout.SOUTH`) του `mainPanel`.
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }


    private void createReceipt(String products, double totalAmount, String address) {
        // Δημιουργία ενός JFileChooser για την επιλογή του αρχείου αποθήκευσης από τον χρήστη.
        JFileChooser fileSaver = new JFileChooser();
        // Εμφανίζει το παράθυρο διαλόγου για την αποθήκευση του αρχείου και αποθηκεύει την επιλογή του χρήστη.
        int userChoice = fileSaver.showSaveDialog(this);
        // Ελέγχει αν ο χρήστης έχει επιλέξει να αποθηκεύσει το αρχείο (APPROVE_OPTION).
        if (userChoice == JFileChooser.APPROVE_OPTION) {
            // Αποθηκεύει το μονοπάτι του αρχείου που επέλεξε ο χρήστης.
            String selectedFile = fileSaver.getSelectedFile().getPath();
            try {
                // Δημιουργία ενός BufferedWriter για να γράψει δεδομένα στο αρχείο.
                BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
                // Γράφει τον τίτλο "Receipt" στο αρχείο
                writer.write("Receipt\n\n");
                // Γράφει τη λίστα των προϊόντων στο αρχείο.
                writer.write("Products Purchased: \n");
                writer.write(products);
                writer.write("\n\n");
                // Γράφει το συνολικό ποσό στο αρχείο.
                writer.write("Total Amount: $" + totalAmount);
                writer.write("\n\n");
                // Γράφει τη διεύθυνση του πελάτη στο αρχείο.
                writer.write("Delivery Address: " + address);
                // Κλείνει τον BufferedWriter για να διασφαλίσει ότι τα δεδομένα έχουν αποθηκευτεί σωστά και να απελευθερώσει πόρους.
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
