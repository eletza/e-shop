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


public class checkout extends JFrame{
    private JTextArea productListTextArea;
    private JLabel amountLabel;

    public checkout(String products, double totalAmount) {
        // Θέτει τον τίτλο του παραθύρου σε "Order Summary".
        setTitle("Order Summary");
        // Ορίζει την ενέργεια κατά το κλείσιμο του παραθύρου σε DISPOSE_ON_CLOSE, ώστε να κλείνει μόνο το συγκεκριμένο παράθυρο.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Θέτει το μέγεθος του παραθύρου σε 450x450 pixels.
        setSize(450, 450);
        // Κεντράρει το παράθυρο στην οθόνη.
        setLocationRelativeTo(null);

        // Δημιουργία του κύριου panel με διάταξη BorderLayout και απόσταση 10 pixels μεταξύ των στοιχείων.
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        // Προσθήκη του κύριου panel στο JFrame.
        add(mainPanel);

        // Δημιουργία του panel κεφαλίδας και ορισμός του χρώματος φόντου σε ανοιχτό γκρι.
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.CYAN);
        // Προσθήκη του panel κεφαλίδας στο κύριο panel στο βόρειο τμήμα.
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Δημιουργία και διαμόρφωση της ετικέτας τίτλου.
        JLabel headerLabel = new JLabel("Summary of your Purchase");
        // Θέτει τη γραμματοσειρά της ετικέτας σε Verdana, Bold, 20.
        headerLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        // Προσθήκη της ετικέτας τίτλου στο panel κεφαλίδας.
        headerPanel.add(headerLabel);

        // Δημιουργία του panel περιεχομένου με διάταξη BorderLayout και απόσταση 10 pixels.
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        // Προσθήκη του panel περιεχομένου στο κέντρο του κύριου panel.
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Δημιουργία JScrollPane για κύλιση του περιεχομένου.
        JScrollPane scrollPane = new JScrollPane();
        // Προσθήκη του JScrollPane στο κέντρο του panel περιεχομένου.
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Δημιουργία του panel καλαθιού .
        JPanel productPanel = new JPanel(new BorderLayout());
        // Ορίζει ένα περιγράμματος με τίτλο "Purchased Items".
        productPanel.setBorder(BorderFactory.createTitledBorder("Purchased Items"));
        // Ορίζει το cartPanel ως το ορατό τμήμα του JScrollPane.
        scrollPane.setViewportView(productPanel);


        productListTextArea = new JTextArea();
        // Κάνει το JTextArea μη επεξεργάσιμο, ώστε ο χρήστης να μην μπορεί να τροποποιήσει το κείμενο.
        productListTextArea.setEditable(false);
        // Θέτει το κείμενο του JTextArea στα προϊόντα που έχουν επιλεγεί.
        productListTextArea.setText(products);
        // Προσθέτει το JTextArea στο κέντρο του panel καλαθιού (cartPanel).
        productPanel.add(productListTextArea, BorderLayout.CENTER);

        // Δημιουργία ενός panel για το συνολικό ποσό με FlowLayout που στοιχίζει τα στοιχεία στη δεξιά πλευρά.
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Δημιουργεί μια ετικέτα με το συνολικό ποσό, ως χρηματική αξία.
        amountLabel = new JLabel(String.format("Total: $%.2f", totalAmount));
        // Προσθέτει την ετικέτα με το συνολικό ποσό στο panel.
        totalPanel.add(amountLabel);
        // Προσθέτει το panel με το συνολικό ποσό στο κάτω μέρος του panel καλαθιού.
        productPanel.add(totalPanel, BorderLayout.SOUTH);

        // Δημιουργία κουμπιού "Continue to Payment" για να συνεχίσει ο χρήστης στη διαδικασία πληρωμής.
        JButton proceedToPaymentButton = new JButton("Continue to Payment");
        // Εμφανίζει ένα μήνυμα για να ειδοποιήσει τον χρήστη να επιλέξει μια μέθοδο πληρωμής.
        proceedToPaymentButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(this, "Proceed to select your preferred payment method");

            // Δημιουργεί ένα νέο παράθυρο PaymentOptionsFrame και του περνάει τη λίστα προϊόντων και το συνολικό ποσό.
            PaymentOptionsFrame paymentOptionsFrame = new PaymentOptionsFrame(products, totalAmount);
            // Κάνει ορατό το νέο παράθυρο πληρωμών.
            paymentOptionsFrame.setVisible(true);

            // Close frame
            dispose();
        });
        // Προσθέτει το κουμπί για την πληρωμή στο κάτω μέρος του panel περιεχομένου.
        contentPanel.add(proceedToPaymentButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Δημιουργεί ένα νέο αντικείμενο τύπου checkout που αντιπροσωπεύει το παράθυρο "ordersummary".
        // Περνάει ως παράμετρο τη λίστα προϊόντων ("Product 1\nProduct 2\nProduct 3") και το συνολικό ποσό (100.0).
        checkout orderSummary = new checkout("Product 1\nProduct 2\nProduct 3", 100.0);
        // Κάνει ορατό το παράθυρο του billingDashboard στην οθόνη.
        orderSummary.setVisible(true);
    }
}
