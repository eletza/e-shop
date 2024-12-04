/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registration;

/**
 *
 * @author eleft
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class catalogsProducts extends JFrame {
    //δήλωση μεταβλητής για την εμφάνιση προϊόντων του καλαθιού
    private JTextArea cartDisplayArea;
    private double totalCost=0.0;
    private JLabel totalDisplayLabel;
    private List<Product> productList;

    public catalogsProducts() {
        //Ορίζει τον τίτλο του παραθύρου σε "Products"
        setTitle("Products");
        // Ορίζει τη συμπεριφορά κατά το κλείσιμο του παραθύρου. Η εφαρμογή θα τερματιστεί όταν ο χρήστης κλείσει το παράθυρο.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Ορίζει το αρχικό μέγεθος του παραθύρου σε πλάτος 800  και ύψος 600 .
        setSize(800, 600);
        // Τοποθετεί το παράθυρο στο κέντρο της οθόνης.
        setLocationRelativeTo(null);

        // Δημιουργία λίστας προϊόντων
        productList = new ArrayList<>();

        // Δημιουργία του κύριου panel με BorderLayout και να υπάρχει κενό 10 pixels τόσο οριζόντια όσο και κατακόρυφα από τα στοιχεία του.
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        //Προσθέτει το panel στο JFrame.
        add(mainPanel);


        // Δημιουργία του panel κεφαλίδας
        JPanel topPanel = new JPanel();
        // Ορίζει το χρώμα φόντου του πάνελ κεφαλίδας χρώμα κυανό.
        topPanel.setBackground(Color.CYAN);
        // Προσθέτει το topPanel στο κύριο πάνελ (mainPanel) στο πάνω μέρος χρησιμοποιώντας το BorderLayout.
        mainPanel.add(topPanel, BorderLayout.NORTH);


        // Δημιουργεί ένα JLabel με το κείμενο "Products List", που θα χρησιμοποιηθεί ως τίτλος στο πάνελ κεφαλίδας.
        JLabel header = new JLabel("Products List");
        // Ορίζει τη γραμματοσειρά του τίτλου σε "Arial", με έντονη γραφή (BOLD) και μέγεθος 24.
        header.setFont(new Font("Arial", Font.BOLD, 20));
        // Προσθέτει το JLabel (header) στο topPanel, εμφανίζοντας τον τίτλο στο πάνελ κεφαλίδας
        topPanel.add(header);


        // Δημιουργεί ένα νέο JPanel με BorderLayout και ορίζει περιθώρια 10 pixels οριζόντια και 10 pixels κάθετα μεταξύ των στοιχείων του panel.
        //Χρησιμοποιείται για να φιλοξενήσει το κύριο περιεχόμενο της εφαρμογής.
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        // Προσθέτει το contentPanel στο mainPanel στο κέντρο (CENTER) χρησιμοποιώντας το BorderLayout.
        mainPanel.add(contentPanel, BorderLayout.CENTER);


        // Create and add the categories combo box
        // Δημιουργεί ένα νέο JPanel που θα χρησιμοποιηθεί για την προβολή των επιλογών κατηγοριών προϊόντων.
        JPanel categoryPanel = new JPanel();
        // Δημιουργεί ένα JLabel με το κείμενο "Category:", ως ετικέτα για το JComboBox.
        JLabel categoryTitle = new JLabel("Choose Category:");
        // Δημιουργεί ένα JComboBox που επιτρέπει στον χρήστη να επιλέξει μια κατηγορία προϊόντων. Το JComboBox είναι τύπου String και θα περιέχει τις κατηγορίες των προϊόντων.
        JComboBox<String> categorySelector  = new JComboBox<>();
        // Προσθέτει διάφορες κατηγορίες προϊόντων στο JComboBox, όπως "All", "Electronics", "Clothing", "Books" και "Shoes".
         categorySelector.addItem("All");
         categorySelector.addItem("Electronics");
         categorySelector.addItem("Clothing");
         categorySelector.addItem("Books");
         categorySelector.addItem("Shoes");
        // Προσθέτει την ετικέτα (JLabel) στο categoryPanel.
        categoryPanel.add(categoryTitle);
        // Προσθέτει το categoryPanel στο contentPanel στο πάνω μέρος χρησιμοποιώντας το BorderLayout.
        // Τοποθετεί την επιλογή κατηγορίας στο πάνω μέρος του κεντρικού panel.
        categoryPanel.add( categorySelector);
        contentPanel.add(categoryPanel, BorderLayout.NORTH);

        // Δημιουργεί ένα νέο JScrollPane, το οποίο επιτρέπει την κύλιση (scrolling) του περιεχομένου.
        JScrollPane scrollableContent = new JScrollPane();
        // Προσθέτει το scrollableContent στο contentPanel στο κέντρο (CENTER) χρησιμοποιώντας το BorderLayout.
        // Το scrollableContent θα φιλοξενήσει το panel των προϊόντων.
        contentPanel.add(scrollableContent, BorderLayout.CENTER);


        // Δημιουργεί ένα νέο JPanel με GridLayout,που έχει 3 στήλες,έχει όσες γραμμές χρειάζονται, προσθέτονται κενά 10 pixels ανάμεσα στα στοιχεία, τόσο οριζόντια όσο και κατακόρυφα.
        JPanel productsPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        // Δημιουργεί ένα περίγραμμα (border) του productsPanel ώστε να έχει τίτλο "Products".
        // Ο τίτλος βοηθάει στην ομαδοποίηση των προϊόντων που θα εμφανίζονται μέσα στο panel.
        productsPanel.setBorder(BorderFactory.createTitledBorder("Available Products"));
        // Το productsPanel θα εμφανίζεται μέσα στο scrollPane και αν ο αριθμός των προϊόντων υπερβαίνει το διαθέσιμο χώρο, θα είναι δυνατή η κύλιση (scrolling) για να προβληθούν όλα.
        scrollableContent.setViewportView(productsPanel);


        //Προσθήκη προϊόντων στην λίστα
        productList.add(new Product("nike shoes", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\nike.png", "$120", 120, "Shoes"));
        productList.add(new Product("adidas shoes", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\adidas.png", "$150", 150, "Shoes"));
        productList.add(new Product("vans shoes", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\vans.png", "$90", 90, "Shoes"));
        productList.add(new Product("All stars", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\all_stars.png", "$80", 80, "Shoes"));
        productList.add(new Product("White shirt", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\white_shirt.png", "$99", 99, "Clothing"));
        productList.add(new Product("US polo formal shirt", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\US polo.png", "$199", 199, "Clothing"));
        productList.add(new Product("linen trouser", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\Linen.png", "$50", 50, "Clothing"));
        productList.add(new Product("Athlitismos", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\athlitismos.png", "$33", 33, "Books"));
        productList.add(new Product("Athlitismos Gia Pedia", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\bookkids.png", "$40", 40, "Books"));
        productList.add(new Product("H agapi gia ton athlitismo", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\agapi.png", "$22", 22, "Books"));
        productList.add(new Product("Diadromos", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\diadromos.png", "$1999", 1999, "Electronics"));
        productList.add(new Product("Hyperice", "C:\\Users\\eleft\\OneDrive\\Εικόνες\\e-shop\\hyperice.png", "$80", 80, "Electronics"));


        // Αυτή η μέθοδος ενημερώνει το productsPanel και εμφανίζονται όλα τα διαθέσιμα προϊόντα.
        // Η αρχική προβολή θα περιλαμβάνει όλα τα προϊόντα, πριν ο χρήστης επιλέξει κάποια συγκεκριμένη κατηγορία.
        updateProductPanel(productsPanel, "All");


        // Δημιουργεί ένα νέο JPanel με BorderLayout, το οποίο θα τοποθετηθεί στην αριστερή πλευρά (WEST) του contentPanel.
        // Αυτό το panel θα χρησιμοποιηθεί για να φιλοξενήσει το καλάθι αγορών.
        JPanel leftPanel = new JPanel(new BorderLayout());
        contentPanel.add(leftPanel, BorderLayout.WEST);


        // Δημιουργεί ένα νέο JPanel με BorderLayout, το οποίο θα χρησιμοποιηθεί ως το panel του καλαθιού αγορών (Cart).
        JPanel cartDisplayPanel = new JPanel(new BorderLayout());
        //καθορίζει τις διαστάσεις του panel που θα εμφανίζει το καλάθι αγορών. Ορίζει το μέγεθος του cartPanel σε πλάτος 200 pixels και ύψος 400 pixels.
        cartDisplayPanel.setPreferredSize(new Dimension(200, 400));
        // Δημιουργεί ένα περίγραμμα (border) γύρω από το cartPanel με τίτλο "Cart".
        cartDisplayPanel.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));
        // Προσθέτει το cartPanel στο leftPanel στο κέντρο(CENTER) του BorderLayout.Έτσι το καλάθι αγορών βρίσκεται στο κέντρο του αριστερού panel.
        leftPanel.add(cartDisplayPanel, BorderLayout.CENTER);


       // Δημιουργεί ένα νέο JTextArea, το οποίο θα χρησιμοποιηθεί για την εμφάνιση του περιεχομένου του καλαθιού αγορών.
        cartDisplayArea = new JTextArea();
        // Ορίζει το JTextArea ως μη επεξεργάσιμο (non-editable). Έτσι οι χρήστες δεν μπορούν να αλλάξουν το περιεχόμενο του καλαθιού αγορών.
        cartDisplayArea.setEditable(false);
        // Δημιουργεί ένα JScrollPane που περιέχει το cartTextArea. Αυτό επιτρέπει την κύλιση (scrolling) του περιεχομένου του cartTextArea αν το περιεχόμενο υπερβαίνει το ορατό μέγεθος.
        JScrollPane cartScroll = new JScrollPane(cartDisplayArea);
        // Προσθέτει το cartScroll στο  cartDisplayArea στο κέντρο (CENTER) του BorderLayout.
        // Το JScrollPane θα καταλάβει όλο το διαθέσιμο χώρο του  cartDisplayArea και θα επιτρέπει την κύλιση του κειμένου αν το καλάθι αγορών έχει μεγάλο περιεχόμενο.
        cartDisplayPanel.add(cartScroll, BorderLayout.CENTER);


        // Δημιουργεί ένα νέο JPanel με FlowLayout, το οποίο τοποθετεί τα στοιχεία του προς τα δεξιά (RIGHT) μέσα στο panel.
        // Αυτό το panel θα χρησιμοποιηθεί για την εμφάνιση της συνολικής αξίας των προϊόντων στο καλάθι αγορών.
        JPanel costDisplayPanel  = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Δημιουργεί ένα νέο JLabel με αρχικό κείμενο "Total: $0.00", που θα εμφανίζει τη συνολική αξία των προϊόντων στο καλάθι αγορών.
         totalDisplayLabel= new JLabel("Total: $0.00");
        // Προσθέτει το totalDisplayLabel στο costDisplayPanel
        costDisplayPanel.add(totalDisplayLabel);
        // Προσθέτει το costDisplayPanel στο cartDisplayPanel στην περιοχή του Νότου (SOUTH) χρησιμοποιώντας το BorderLayout.
        // Το costDisplayPanel θα τοποθετηθεί στο κάτω μέρος του cartDisplayPanel, εμφανίζοντας τη συνολική αξία των προϊόντων στο καλάθι αγορών.
         cartDisplayPanel.add(costDisplayPanel, BorderLayout.SOUTH);


        // Δημιουργεί ένα νέο JPanel με FlowLayout, το οποίο κεντρώνει τα στοιχεία του (CENTER) μέσα στο panel.
        // Αυτό το panel θα χρησιμοποιηθεί για να φιλοξενήσει τα κουμπιά ή άλλα στοιχεία στο κάτω μέρος του παραθύρου.
        JPanel  bottomButtonsPanel  = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Δημιουργεί ένα νέο JPanel με FlowLayout, το οποίο τοποθετεί τα στοιχεία του προς τα αριστερά (LEFT) μέσα στο panel.
        // Αυτό το panel θα χρησιμοποιηθεί για να φιλοξενήσει το κουμπί επαναφοράς.
        JPanel resetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // Δημιουργεί ένα νέο JButton με την ετικέτα "Clear Cart". Αυτό το κουμπί θα χρησιμοποιηθεί για να επαναφέρει το καλάθι αγορών.
        JButton clearCartButton  = new JButton("Clear Cart");
        // Προσθέτει το resetPanel στο bottomPanel στα δυτικά (WEST) χρησιμοποιώντας το BorderLayout.
         bottomButtonsPanel.add(resetPanel, BorderLayout.WEST);
        // Ορίζει έναν ActionListener για το κουμπί resetButton. Όταν το κουμπί πατηθεί, η μέθοδος resetCart() θα εκτελείται, η οποία επαναφέρει το καλάθι αγορών.
        clearCartButton .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetCart();// Καλεί τη μέθοδο resetCart όταν ο χρήστης κάνει κλικ στο κουμπί "Reset".
            }
        });
        // Προσθέτει το κουμπί clearCartButton στο resetPanel. Το κουμπί θα εμφανίζεται μέσα στο resetPanel, το οποίο βρίσκεται στην αριστερή πλευρά του bottomPanel.
        resetPanel.add(clearCartButton);


        // Δημιουργεί ένα νέο JButton με την ετικέτα "Complete Purchase". Αυτό το κουμπί θα χρησιμοποιηθεί για την ολοκλήρωση της διαδικασίας αγοράς.
        JButton checkoutButton = new JButton("Complete Purchase");
        // Ορίζει έναν ActionListener για το κουμπί checkoutButton. Όταν το κουμπί πατηθεί, η ενσωματωμένη μέθοδος actionPerformed() θα εκτελείται.
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ελέγχει αν η συνολική αξία (totalAmount) είναι 0.0, που σημαίνει ότι δεν έχουν επιλεγεί προϊόντα για αγορά.
                if (totalCost == 0.0) {
                    // Εμφανίζει ένα μήνυμα διαλόγου (dialog) που ενημερώνει τον χρήστη να επιλέξει προϊόντα πριν ολοκληρώσει την αγορά.
                    JOptionPane.showMessageDialog(catalogsProducts.this, "You must choose products before proceeding.");
                }else {
                    // Εμφανίζει ένα μήνυμα διαλόγου (dialog) που ενημερώνει τον χρήστη ότι η διαδικασία αγοράς έχει ολοκληρωθεί.
                    JOptionPane.showMessageDialog(catalogsProducts.this, "Purchase complete!");
                    // Καλεί τη μέθοδο showBillingDashboard() που προβάλλει μια οθόνη χρέωσης ή ολοκλήρωσης αγοράς.
                    openCheckout();
                }
            }
        });


        // Προσθέτει το κουμπί checkoutButton στο bottomPanel
        bottomButtonsPanel.add(checkoutButton);
        // Το bottomPanel θα τοποθετηθεί στο κάτω μέρος του κύριου παραθύρου, συμπεριλαμβάνοντας το κουμπί ολοκλήρωσης αγοράς (checkoutButton).
        mainPanel.add(bottomButtonsPanel, BorderLayout.SOUTH);
        // Ορίζει έναν ActionListener για το JComboBox categoryComboBox. Όταν ο χρήστης επιλέξει μια κατηγορία από το combo box,
        // η ενσωματωμένη μέθοδος actionPerformed() θα εκτελείται.
         categorySelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Παίρνει την επιλεγμένη κατηγορία από το JComboBox και την αποθηκεύει στη μεταβλητή selectedCategory ως String.
                String selectedCategory = (String)  categorySelector.getSelectedItem();
                // Αυτή η μέθοδος ενημερώνει το productsPanel για να εμφανίζει τα προϊόντα που ανήκουν στην επιλεγμένη κατηγορία.
                updateProductPanel(productsPanel, selectedCategory);
            }
        });
    }


    // Ορίζει μια ιδιωτική μέθοδο που ενημερώνει το productsPanel για να εμφανίζει μόνο τα προϊόντα που ανήκουν στην επιλεγμένη κατηγορία.
    private void updateProductPanel(JPanel productsPanel, String selectedCategory) {
        // Αφαιρεί όλα τα στοιχεία από το productsPanel, καθαρίζοντας το panel προτού προσθέσει τα νέα προϊόντα.
        // Αυτό διασφαλίζει ότι μόνο τα προϊόντα της τρέχουσας κατηγορίας θα είναι ορατά.
        productsPanel.removeAll();

        // Iterate over the products and add only those matching the selected category
        // Διατρέχει όλα τα προϊόντα στη λίστα productList.
        for (Product product : productList) {
            // Ελέγχει αν η επιλεγμένη κατηγορία είναι "All" ή αν η κατηγορία του προϊόντος ταιριάζει με την επιλεγμένη κατηγορία.
            // Αν η κατηγορία είναι "All", όλα τα προϊόντα θα εμφανίζονται. Αν όχι, εμφανίζονται μόνο τα προϊόντα που ανήκουν στην επιλεγμένη κατηγορία.
            if (selectedCategory.equals("All") || product.getCategory().equals(selectedCategory)) {
                // Καλεί τη μέθοδο addProductPanel για να προσθέσει το προϊόν στο productsPanel.
                // Αυτή η μέθοδος δημιουργεί μια αναπαράσταση για το προϊόν και το προσθέτει στο panel.
                addProductPanel(productsPanel, product);
            }
        }

        // Refresh the panel
        // Καλεί τη μέθοδο revalidate() στο productsPanel για να ενημερώσει τη διάταξη του panel.
        productsPanel.revalidate();
        // Καλεί τη μέθοδο repaint() στο productsPanel για να ανανεώσει την εμφάνιση του panel.
        productsPanel.repaint();
    }
    public void resetCart() {
        cartDisplayArea.setText("");
        totalCost = 0.0;
        totalDisplayLabel.setText("Total: $0.00");
    }


    // Ορίζει μια ιδιωτική μέθοδο που προσθέτει ένα panel προϊόντος στο productsPanel.
    private void addProductPanel(JPanel productsPanel, Product product) {
        try {
            // Διαβάζει την εικόνα του προϊόντος από το αρχείο που καθορίζεται από την διαδρομή (path) που παρέχεται από το αντικείμενο product.
            Image productImage = ImageIO.read(new File(product.getImageFile()));
            // Κλιμακώνει την εικόνα του προϊόντος σε διαστάσεις 150x150 pixels, χρησιμοποιώντας την τεχνική Image.SCALE_SMOOTH για καλύτερη ποιότητα.
            // Η μέθοδος getScaledInstance δημιουργεί μια νέα εικόνα με τις επιθυμητές διαστάσεις.
            Image  resizedImage = productImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            // Δημιουργεί ένα νέο JPanel με GridBagLayout, το οποίο θα χρησιμοποιηθεί για την τοποθέτηση των στοιχείων του προϊόντος.
            JPanel productPanel = new JPanel(new GridBagLayout());
            // Ορίζει το μέγεθος του productPanel σε πλάτος 200 pixels και ύψος 250 pixels.Έτσι, καθορίζει τις διαστάσεις του panel που θα εμφανίζει το προϊόν.
            productPanel.setPreferredSize(new Dimension(200, 250));
            // Δημιουργεί ένα περίγραμμα (border) γύρω από το productPanel με μαύρο γκρι .
            productPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            // Δημιουργεί ένα νέο JLabel που περιέχει μια ImageIcon. Η ImageIcon δημιουργείται από την κλιμακωμένη εικόνα του προϊόντος (scaledProductImage).
            // Το JLabel θα χρησιμοποιηθεί για να εμφανίζει την εικόνα του προϊόντος μέσα στο productPanel.
            JLabel imageLabel = new JLabel(new ImageIcon(resizedImage));
            // Δημιουργεί ένα νέο αντικείμενο GridBagConstraints, το οποίο χρησιμοποιείται για τη ρύθμιση της διάταξης των στοιχείων σε ένα JPanel που χρησιμοποιεί GridBagLayout.
            GridBagConstraints gbc = new GridBagConstraints();
            // Ορίζει την θέση της στήλης (column) όπου το στοιχείο θα τοποθετηθεί. Σε αυτήν την περίπτωση, το στοιχείο τοποθετείται στην πρώτη στήλη (0).
            gbc.gridx = 0;
            // Ορίζει την θέση της γραμμής (row) όπου το στοιχείο θα τοποθετηθεί. Σε αυτήν την περίπτωση, το στοιχείο τοποθετείται στην πρώτη γραμμή (0).
            gbc.gridy = 0;
            // Ορίζει πόσες στήλες θα καταλαμβάνει το στοιχείο. Σε αυτήν την περίπτωση, το στοιχείο θα επεκταθεί σε 2 στήλες.
            gbc.gridwidth = 2;
            // Ορίζει ότι το στοιχείο θα επεκταθεί και στις δύο κατευθύνσεις (οριζόντια και κάθετη) για να γεμίσει το διαθέσιμο χώρο μέσα στο cell του GridBagLayout.
            gbc.fill = GridBagConstraints.BOTH;
            // Ορίζει τη θέση του στοιχείου μέσα στο cell του GridBagLayout. Σε αυτήν την περίπτωση, το στοιχείο θα τοποθετηθεί στο κέντρο του cell.
            gbc.anchor = GridBagConstraints.CENTER;
            // Ορίζει τις εσωτερικές αποστάσεις (padding) γύρω από το στοιχείο. Σε αυτήν την περίπτωση, υπάρχει κενό 10 pixels μόνο στο κάτω μέρος του στοιχείου (bottom),
            // ενώ δεν υπάρχουν αποστάσεις στις άλλες πλευρές (top, left, right).
            gbc.insets = new Insets(0, 0, 10, 0);
            // Προσθέτει το JLabel (imageLabel) στο productPanel χρησιμοποιώντας τις καθορισμένες ρυθμίσεις διάταξης (GridBagConstraints).
            productPanel.add(imageLabel, gbc);



            // Δημιουργεί ένα νέο JLabel που εμφανίζει το όνομα του προϊόντος.
            // Το όνομα του προϊόντος ανακτάται από την μέθοδο getProductName() του αντικειμένου product και χρησιμοποιείται για την ετικέτα (label).
            JLabel nameLabel = new JLabel(product.getname());
            // Δημιουργεί ένα νέο αντικείμενο GridBagConstraints, το οποίο χρησιμοποιείται για να ρυθμίσει τη διάταξη του στοιχείου στο JPanel με GridBagLayout.
            // Το αντικείμενο gbc επαναχρησιμοποιείται για να ορίσει τις νέες ρυθμίσεις διάταξης για το nameLabel.
            gbc = new GridBagConstraints();
            // Ορίζει τη θέση της στήλης (column) όπου το στοιχείο θα τοποθετηθεί. Σε αυτήν την περίπτωση, το στοιχείο τοποθετείται στην πρώτη στήλη (0).
            gbc.gridx = 0;
            // Ορίζει τη θέση της γραμμής (row) όπου το στοιχείο θα τοποθετηθεί. Σε αυτήν την περίπτωση, το στοιχείο τοποθετείται στη δεύτερη γραμμή (1).
            gbc.gridy = 1;
            // Ορίζει πόσες στήλες θα καταλαμβάνει το στοιχείο. Σε αυτήν την περίπτωση, το στοιχείο θα επεκταθεί σε 2 στήλες.
            gbc.gridwidth = 2;
            // Ορίζει ότι το στοιχείο θα επεκταθεί μόνο οριζόντια (horizontal) για να γεμίσει το διαθέσιμο χώρο στο cell του GridBagLayout,
            // διασφαλίζοντας ότι το JLabel θα εκτείνεται πλήρως κατά μήκος της διαθέσιμης περιοχής.
            gbc.fill = GridBagConstraints.HORIZONTAL;
            // Ορίζει τη θέση του στοιχείου μέσα στο cell του GridBagLayout. Σε αυτήν την περίπτωση, το στοιχείο θα τοποθετηθεί στο κέντρο του cell.
            gbc.anchor = GridBagConstraints.CENTER;
            // Ορίζει τις εσωτερικές αποστάσεις (padding) γύρω από το στοιχείο. Σε αυτήν την περίπτωση, υπάρχει κενό 5 pixels μόνο στο κάτω μέρος του στοιχείου (bottom),
            // ενώ δεν υπάρχουν αποστάσεις στις άλλες πλευρές (top, left, right).
            gbc.insets = new Insets(0, 0, 5, 0);
            // Προσθέτει το JLabel (nameLabel) στο productPanel χρησιμοποιώντας τις καθορισμένες ρυθμίσεις διάταξης (GridBagConstraints).
            // Το JLabel θα εμφανίζεται σύμφωνα με τις ρυθμίσεις του GridBagConstraints στο productPanel, τοποθετώντας το όνομα του προϊόντος.
            productPanel.add(nameLabel, gbc);


            // Δημιουργεί ένα νέο JLabel που εμφανίζει την τιμή του προϊόντος.
            // Η τιμή του προϊόντος ανακτάται από την μέθοδο getPrice() του αντικειμένου product και χρησιμοποιείται για την ετικέτα (label).
            JLabel priceLabel = new JLabel(product.getPrice());
            // Δημιουργεί ένα νέο αντικείμενο GridBagConstraints, το οποίο χρησιμοποιείται για τη ρύθμιση της διάταξης του στοιχείου στο JPanel με GridBagLayout.
            gbc = new GridBagConstraints();
            // Ορίζει τη θέση της στήλης (column) όπου το στοιχείο θα τοποθετηθεί. Σε αυτήν την περίπτωση, το στοιχείο τοποθετείται στην πρώτη στήλη (0).
            gbc.gridx = 0;
            // Ορίζει τη θέση της γραμμής (row) όπου το στοιχείο θα τοποθετηθεί. Σε αυτήν την περίπτωση, το στοιχείο τοποθετείται στην τρίτη γραμμή (2).
            gbc.gridy = 2;
            // Ορίζει πόσες στήλες θα καταλαμβάνει το στοιχείο. Σε αυτήν την περίπτωση, το στοιχείο θα επεκταθεί σε 2 στήλες.
            gbc.gridwidth = 2;
            // Ορίζει ότι το στοιχείο θα επεκταθεί μόνο οριζόντια (horizontal) για να γεμίσει το διαθέσιμο χώρο στο cell του GridBagLayout,
            // διασφαλίζοντας ότι το JLabel θα εκτείνεται πλήρως κατά μήκος της διαθέσιμης περιοχής.
            gbc.fill = GridBagConstraints.HORIZONTAL;
            // Ορίζει τη θέση του στοιχείου μέσα στο cell του GridBagLayout. Σε αυτήν την περίπτωση, το στοιχείο θα τοποθετηθεί στο κέντρο του cell.
            gbc.anchor = GridBagConstraints.CENTER;
            // Ορίζει τις εσωτερικές αποστάσεις (padding) γύρω από το στοιχείο. Σε αυτήν την περίπτωση, υπάρχει κενό 5 pixels μόνο στο κάτω μέρος του στοιχείου (bottom),
            // ενώ δεν υπάρχουν αποστάσεις στις άλλες πλευρές (top, left, right).
            gbc.insets = new Insets(0, 0, 5, 0);
            // Προσθέτει το JLabel (priceLabel) στο productPanel χρησιμοποιώντας τις καθορισμένες ρυθμίσεις διάταξης (GridBagConstraints).
            // Το JLabel θα εμφανίζει την τιμή του προϊόντος σύμφωνα με τις ρυθμίσεις του GridBagConstraints στο productPanel.
            productPanel.add(priceLabel, gbc);


            // Δημιουργεί ένα νέο JButton με την ετικέτα "Add to Cart" που θα χρησιμοποιηθεί για την προσθήκη του προϊόντος
            JButton addToCartButton = new JButton("Add to Cart");
            // Δημιουργεί ένα νέο αντικείμενο GridBagConstraints για τη ρύθμιση της διάταξης του κουμπιού στο JPanel με GridBagLayout.
            gbc = new GridBagConstraints();
            // Ορίζει τη θέση της στήλης (column) όπου το κουμπί θα τοποθετηθεί. Σε αυτήν την περίπτωση, το κουμπί τοποθετείται στην πρώτη στήλη (0).
            gbc.gridx = 0;
            // Ορίζει τη θέση της γραμμής (row) όπου το κουμπί θα τοποθετηθεί. Σε αυτήν την περίπτωση, το κουμπί τοποθετείται στην τέταρτη γραμμή (3).
            gbc.gridy = 3;
            // Ορίζει πόσες στήλες θα καταλαμβάνει το κουμπί. Σε αυτήν την περίπτωση, το κουμπί θα επεκταθεί σε 2 στήλες.
            gbc.gridwidth = 2;
            // Ορίζει ότι το κουμπί θα επεκταθεί μόνο οριζόντια (horizontal) για να γεμίσει το διαθέσιμο χώρο στο cell του GridBagLayout,
            // διασφαλίζοντας ότι το κουμπί θα εκτείνεται πλήρως κατά μήκος της διαθέσιμης περιοχής.
            gbc.fill = GridBagConstraints.HORIZONTAL;
            // Ορίζει τη θέση του κουμπιού μέσα στο cell του GridBagLayout. Σε αυτήν την περίπτωση, το κουμπί θα τοποθετηθεί στο κέντρο του cell.
            gbc.anchor = GridBagConstraints.CENTER;
            // Προσθέτει το JButton (addToCartButton) στο productPanel χρησιμοποιώντας τις καθορισμένες ρυθμίσεις διάταξης (GridBagConstraints).
            // Το κουμπί θα εμφανίζεται σύμφωνα με τις ρυθμίσεις του GridBagConstraints στο productPanel.
            productPanel.add(addToCartButton, gbc);


            // Ορίζει έναν ActionListener για το κουμπί "Add to Cart". Όταν ο χρήστης πατήσει το κουμπί, η ενσωματωμένη μέθοδος actionPerformed() θα εκτελείται.
            addToCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Δημιουργεί μια συμβολοσειρά που περιλαμβάνει το όνομα του προϊόντος και την τιμή του, για την εμφάνιση στο καλάθι αγορών.
                    String cartItem = product.getname() + " - " + product.getPrice();
                    // Προσθέτει το cartItem (όνομα και τιμή του προϊόντος) στην περιοχή κειμένου cartTextArea, που αντιπροσωπεύει το καλάθι αγορών.
                    // Προσθέτει επίσης μια νέα γραμμή μετά την προσθήκη του προϊόντος για να ξεχωρίζει από τα υπόλοιπα προϊόντα.
                    cartDisplayArea.append(cartItem + "\n");
                    // Αυξάνει το συνολικό ποσό (totalAmount) με την τιμή του προϊόντος που προστέθηκε στο καλάθι αγορών.
                    // Η μέθοδος getAmount() του προϊόντος επιστρέφει την τιμή του προϊόντος ως αριθμητική τιμή.
                    totalCost += product.getAmount();
                    // Ενημερώνει την ετικέτα (totalDisplayLabel) με το νέο συνολικό ποσό (totalCost), με δύο δεκαδικά ψηφία.
                    // Το String.format() χρησιμοποιείται για να δημιουργήσει μια συμβολοσειρά με το συνολικό ποσό σε μορφή νομίσματος.
                    totalDisplayLabel.setText(String.format("Total: $%.2f", totalCost));
                }
            });

            // Δημιουργεί ένα νέο JButton με την ετικέτα "Remove" που θα χρησιμοποιηθεί για την αφαίρεση του προϊόντος από το καλάθι αγορών.
            JButton removeButton = new JButton("Remove");
            // Ορίζει έναν ActionListener για το κουμπί "Remove". Όταν ο χρήστης πατήσει το κουμπί, η ενσωματωμένη μέθοδος actionPerformed() θα εκτελείται.
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Δημιουργεί μια συμβολοσειρά που περιλαμβάνει το όνομα του προϊόντος και την τιμή του, για να ταυτοποιήσει το στοιχείο στο καλάθι αγορών.
                    String cartItem = product.getname() + " - " + product.getPrice();
                    // Ανακτά το πλήρες κείμενο από την περιοχή κειμένου cartTextArea, η οποία περιέχει τα στοιχεία του καλαθιού αγορών.
                    String cartText = cartDisplayArea.getText();
                    // Εντοπίζει τη θέση (index) της πρώτης εμφάνισης του cartItem στο κείμενο του cartTextArea.
                    int index = cartText.indexOf(cartItem);


                    // Ελέγχει αν το στοιχείο του καλαθιού υπάρχει
                    if (index >= 0) {
                        //  Βρίσκει την πρώτη εμφάνιση του στοιχείου του καλαθιού και το αφαιρεί
                        // Δημιουργεί ένα νέο κείμενο χωρίς το στοιχείο που αφαιρέθηκε
                        cartText = cartText.substring(0, index) + cartText.substring(index + cartItem.length());
                        // Ενημερώνει την περιοχή κειμένου cartTextArea με το νέο κείμενο που δεν περιέχει το αφαιρεθέν στοιχείο.
                        cartDisplayArea.setText(cartText);

                        // Ελέγχει αν το συνολικό ποσό είναι μεγαλύτερο από μηδέν πριν μειώσει την τιμή
                        if (totalCost > 0) {
                            // Μειώνει το συνολικό ποσό (totalCost) με την τιμή του προϊόντος που αφαιρέθηκε από το καλάθι αγορών.
                            totalCost -= product.getAmount();
                            // Ενημερώνει την ετικέτα (totalLabel) με το νέο συνολικό ποσό (totalAmount), μορφοποιημένο με δύο δεκαδικά ψηφία.
                            totalDisplayLabel.setText(String.format("Total: $%.2f", totalCost));
                        }
                    }
                }
            });


            // Δημιουργεί ένα νέο JPanel με διάταξη BorderLayout για την τοποθέτηση των κουμπιών "Remove" και "Add to Cart".
            JPanel buttonPanel = new JPanel(new BorderLayout());
            // Προσθέτει το κουμπί "Remove" στη δυτική πλευρά (West) του buttonPanel.
            buttonPanel.add(removeButton, BorderLayout.WEST);
            // Προσθέτει το κουμπί "Add to Cart" στην ανατολική πλευρά (East) του buttonPanel.
            buttonPanel.add(addToCartButton, BorderLayout.EAST);
            // Δημιουργεί ένα νέο αντικείμενο GridBagConstraints για τη ρύθμιση της διάταξης του buttonPanel στο JPanel με GridBagLayout.
            gbc = new GridBagConstraints();
            // Ορίζει τη θέση της στήλης (column) όπου το buttonPanel θα τοποθετηθεί. Σε αυτήν την περίπτωση, το buttonPanel τοποθετείται στην πρώτη στήλη (0).
            gbc.gridx = 0;
            // Ορίζει τη θέση της γραμμής (row) όπου το buttonPanel θα τοποθετηθεί. Σε αυτήν την περίπτωση, το buttonPanel τοποθετείται στην πέμπτη γραμμή (4).
            gbc.gridy = 4;
            // Ορίζει πόσες στήλες θα καταλαμβάνει το buttonPanel. Σε αυτήν την περίπτωση, το buttonPanel θα επεκταθεί σε 2 στήλες.
            gbc.gridwidth = 2;
            // Ορίζει ότι το buttonPanel θα επεκταθεί μόνο οριζόντια (horizontal) για να γεμίσει το διαθέσιμο χώρο στο cell του GridBagLayout,
            // διασφαλίζοντας ότι το panel θα εκτείνεται πλήρως κατά μήκος της διαθέσιμης περιοχής.
            gbc.fill = GridBagConstraints.HORIZONTAL;
            // Ορίζει τη θέση του buttonPanel μέσα στο cell του GridBagLayout. Σε αυτήν την περίπτωση, το panel θα τοποθετηθεί στο κέντρο του cell.
            gbc.anchor = GridBagConstraints.CENTER;
            // Προσθέτει το buttonPanel στο productPanel χρησιμοποιώντας τις καθορισμένες ρυθμίσεις διάταξης (GridBagConstraints).
           // Το buttonPanel περιέχει τα κουμπιά "Remove" και "Add to Cart" και τοποθετείται στην πέμπτη γραμμή του productPanel.
            productPanel.add(buttonPanel, gbc);

            productsPanel.add(productPanel);
        } catch (Exception e) {
            // Εντοπίζει και εκτυπώνει την εξαίρεση (exception) αν προκύψει κάποιο σφάλμα κατά την εκτέλεση του κώδικα μέσα στο try block.
            e.printStackTrace();
        }
    }

    // Αυτή η μέθοδος δημιουργεί μια νέα παρουσία της κλάσης checkout ( άλλο παράθυρο για την ολοκλήρωση της αγοράς).
    private void openCheckout() {
        // Στο κατασκευαστή της κλάσης checkout, περνάει το κείμενο του cartDisplayArea και το συνολικό ποσό (totalCost) για να εμφανιστούν στη νέα οθόνη.
        checkout checkoutScreen= new checkout(cartDisplayArea.getText(), totalCost);
        // Στη συνέχεια, ορίζει την ορατότητα της checkoutScreen σε true, ώστε το παράθυρο να εμφανιστεί στον χρήστη.
        checkoutScreen.setVisible(true);
    }

    // Κατασκευαστής της κλάσης Product που αρχικοποιεί όλα τα πεδία του προϊόντος.
    public class Product {
        private String name;
        private String imageFile;
        private String price;
        private double amount=0.0;
        private String category;

        public Product(String name, String imageFile, String price, double amount, String category) {
            this.name = name;
            this.imageFile = imageFile;
            this.price = price;
            this.amount = amount;
            this.category = category;
        }

        // Επιστρέφει το όνομα του προϊόντος.
        public String getname() {
            return name;
        }

        // Επιστρέφει τη διαδρομή της εικόνας του προϊόντος.
        public String getImageFile() {
            return imageFile;
        }

        // Επιστρέφει την τιμή του προϊόντος σε μορφή συμβολοσειράς.
        public String getPrice() {
            return price;
        }

        // Επιστρέφει την τιμή του προϊόντος σε μορφή double.
        public double getAmount() {
            return amount;
        }

        // Επιστρέφει την κατηγορία του προϊόντος
        public String getCategory() {
            return category;
        }
    }

    // Η κύρια μέθοδος του προγράμματος.
    public static void main(String[] args) {
        //Δημιουργεί μια νέα παρουσία της κλάσης catalogApp (την κύρια οθόνη του χρήστη)
        catalogsProducts catalogApp = new catalogsProducts();
        //θέτει την ορατότητά της σε true για να εμφανιστεί στον χρήστη.
        catalogApp.setVisible(true);
    }

}
