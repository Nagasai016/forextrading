package saiii;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import javax.swing.JComboBox;
import java.util.Calendar;
import java.util.Date;

public class Interface extends JFrame {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USERNAME = "nagasai";
    private static final String DB_PASSWORD = "nagasai";

    private JButton adminButton;

    public Interface() {
        super("Java Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);

        initializeGUI();
    }

    private void initializeGUI() {
        // Create a panel with a background image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Load the background image from a URL
                    URL imageURL = new URL("https://images.moneycontrol.com/static-mcnews/2021/05/wallstreet-bull_04022021-770x433.jpg?impolicy=website&width=770&height=431");
                    Image image = new ImageIcon(imageURL).getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        // Set panel layout
        panel.setLayout(new FlowLayout());

        // Create the buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        // Rename Button 1 to Admin
        adminButton = button1;
        adminButton.setText("Admin");

        // Add action listeners to the buttons
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAdminInterface();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUserInterface();
            }
        });

        // Add the buttons to the panel
        panel.add(adminButton);
        panel.add(button2);

        // Add the panel to the frame
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void openUserInterface() {
    	JFrame adminFrame = new JFrame("Admin Interface");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(1000, 800);
    }
    
    private void openAdminInterface() {
        JFrame adminFrame = new JFrame("Admin Interface");
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setSize(1000, 800);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the "Clients" menu
        JMenu clientsMenu = new JMenu("Clients");

        // Create the menu items for the "Clients" menu
        JMenuItem viewClientsItem = new JMenuItem("View Clients");
        JMenuItem addClientsItem = new JMenuItem("Add Clients");
        JMenuItem updateClientsItem = new JMenuItem("Update Clients");
        JMenuItem deleteClientsItem = new JMenuItem("Delete Clients");

        // Add action listeners to the menu items
        viewClientsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayClientTable();
            }
        });

        addClientsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addClient();
            }
        });

        updateClientsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateClient();
            }
        });

        deleteClientsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteClient();
            }
        });

        // Add the menu items to the "Clients" menu
        clientsMenu.add(viewClientsItem);
        clientsMenu.add(addClientsItem);
        clientsMenu.add(updateClientsItem);
        clientsMenu.add(deleteClientsItem);

        // Create the "Transactions" menu
        JMenu transactionsMenu = new JMenu("Transactions");

        // Create the menu items for the "Transactions" menu
        JMenuItem viewTransactionsItem = new JMenuItem("View Transactions");
        JMenuItem addTransactionsItem = new JMenuItem("Add Transactions");
        JMenuItem updateTransactionsItem = new JMenuItem("Update Transactions");
        JMenuItem deleteTransactionsItem = new JMenuItem("Delete Transactions");

        // Add action listeners to the menu items
        viewTransactionsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayTransactionTable();
            }
        });

        addTransactionsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTransaction();
            }
        });

        updateTransactionsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTransaction();
            }
        });

        deleteTransactionsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTransaction();
            }
        });

        // Add the menu items to the "Transactions" menu
        transactionsMenu.add(viewTransactionsItem);
        transactionsMenu.add(addTransactionsItem);
        transactionsMenu.add(updateTransactionsItem);
        transactionsMenu.add(deleteTransactionsItem);

        // Create the "Trades" menu
        JMenu tradesMenu = new JMenu("Trades");

        // Create the menu items for the "Trades" menu
        JMenuItem viewTradesItem = new JMenuItem("View Trades");
        JMenuItem addTradesItem = new JMenuItem("Add Trades");
        JMenuItem updateTradesItem = new JMenuItem("Update Trades");
        JMenuItem deleteTradesItem = new JMenuItem("Delete Trades");

        // Add action listeners to the menu items
        viewTradesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayTradeTable();
            }
        });

        addTradesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTrade();
            }
        });

        updateTradesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTrade();
            }
        });

        deleteTradesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTrade();
            }
        });

        // Add the menu items to the "Trades" menu
        tradesMenu.add(viewTradesItem);
        tradesMenu.add(addTradesItem);
        tradesMenu.add(updateTradesItem);
        tradesMenu.add(deleteTradesItem);

        // Create the "Currency" menu
        JMenu currencyMenu = new JMenu("Currency");

        // Create the menu items for the "Currency" menu
        JMenuItem viewCurrencyItem = new JMenuItem("View Currency");
        JMenuItem addCurrencyItem = new JMenuItem("Add Currency");
        JMenuItem updateCurrencyItem = new JMenuItem("Update Currency");
        JMenuItem deleteCurrencyItem = new JMenuItem("Delete Currency");

        // Add action listeners to the menu items
        viewCurrencyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCurrencyTable();
            }
        });

        addCurrencyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCurrency();
            }
        });

        updateCurrencyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCurrency();
            }
        });

        deleteCurrencyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCurrency();
            }
        });

        // Add the menu items to the "Currency" menu
        currencyMenu.add(viewCurrencyItem);
        currencyMenu.add(addCurrencyItem);
        currencyMenu.add(updateCurrencyItem);
        currencyMenu.add(deleteCurrencyItem);

        // Create the "Accounts" menu
        JMenu accountsMenu = new JMenu("Accounts");

        // Create the menu items for the "Accounts" menu
        JMenuItem viewAccountsItem = new JMenuItem("View Accounts");
        JMenuItem addAccountsItem = new JMenuItem("Add Account");
        JMenuItem updateAccountsItem = new JMenuItem("Update Account");
        JMenuItem deleteAccountsItem = new JMenuItem("Delete Account");

        // Add action listeners to the menu items
        viewAccountsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAccountTable();
            }
        });

        addAccountsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addAccount();
            }
        });

        updateAccountsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateAccount();
            }
        });

        deleteAccountsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteAccount();
            }
        });

        // Add the menu items to the "Accounts" menu
        accountsMenu.add(viewAccountsItem);
        accountsMenu.add(addAccountsItem);
        accountsMenu.add(updateAccountsItem);
        accountsMenu.add(deleteAccountsItem);

        // Add the menus to the menu bar
        menuBar.add(clientsMenu);
        menuBar.add(transactionsMenu);
        menuBar.add(tradesMenu);
        menuBar.add(currencyMenu);
        menuBar.add(accountsMenu);

        // Set the menu bar on the admin frame
        adminFrame.setJMenuBar(menuBar);

        adminFrame.setVisible(true);
    }

    
    private void displayCurrencyTable() {
        JFrame currencyFrame = new JFrame("Currency Table");
        currencyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        currencyFrame.setSize(400, 300);

        // Create a JTextArea to display the Currency table rows
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(380, 250)); // Adjust the preferred size as needed

        // Establish a database connection
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the SELECT query on the Currency table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Currency");

            // Iterate through the result set and append the rows to the text area
            while (resultSet.next()) {
                int currencyId = resultSet.getInt("CURRENCY_ID");
                String currencyName = resultSet.getString("CURRENCY_NAME");
                double exchangeRate = resultSet.getDouble("EXCHANGE_RATE");

                textArea.append("CURRENCY_ID: " + currencyId + "\n");
                textArea.append("CURRENCY_NAME: " + currencyName + "\n");
                textArea.append("EXCHANGE_RATE: " + exchangeRate + "\n\n");
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Add the text area to the currencyFrame
        currencyFrame.getContentPane().add(new JScrollPane(textArea));

        currencyFrame.setVisible(true);
    }

    private void addCurrency() {
        JFrame addCurrencyFrame = new JFrame("Add Currency");
        addCurrencyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addCurrencyFrame.setSize(400, 300);

        // Create labels and text fields for currency information
        JLabel currencyIdLabel = new JLabel("Currency ID:");
        JTextField currencyIdField = new JTextField(10);
        JLabel currencyNameLabel = new JLabel("Currency Name:");
        JTextField currencyNameField = new JTextField(10);
        JLabel exchangeRateLabel = new JLabel("Exchange Rate:");
        JTextField exchangeRateField = new JTextField(10);

        // Create a button to add the currency
        JButton addButton = new JButton("Add");

        // Set the layout for the add currency panel
        JPanel addCurrencyPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the add currency panel
        addCurrencyPanel.add(currencyIdLabel);
        addCurrencyPanel.add(currencyIdField);
        addCurrencyPanel.add(currencyNameLabel);
        addCurrencyPanel.add(currencyNameField);
        addCurrencyPanel.add(exchangeRateLabel);
        addCurrencyPanel.add(exchangeRateField);
        addCurrencyPanel.add(addButton);

        // Add an action listener to the add button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                int currencyId = Integer.parseInt(currencyIdField.getText());
                String currencyName = currencyNameField.getText();
                double exchangeRate = Double.parseDouble(exchangeRateField.getText());

                // Insert the currency into the Currency table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO Currency (CURRENCY_ID, CURRENCY_NAME, EXCHANGE_RATE) VALUES (?, ?, ?)");
                    statement.setInt(1, currencyId);
                    statement.setString(2, currencyName);
                    statement.setDouble(3, exchangeRate);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the insertion
                    JOptionPane.showMessageDialog(addCurrencyFrame, "Currency added successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the add currency panel to the add currency frame
        addCurrencyFrame.getContentPane().add(addCurrencyPanel);

        addCurrencyFrame.setVisible(true);
    }

    private void updateCurrency() {
        JFrame updateCurrencyFrame = new JFrame("Update Currency");
        updateCurrencyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateCurrencyFrame.setSize(400, 300);

        // Create labels and text fields for update information
        JLabel currencyIdLabel = new JLabel("Currency ID to update:");
        JTextField currencyIdField = new JTextField(10);
        JLabel exchangeRateLabel = new JLabel("Updated Exchange Rate:");
        JTextField exchangeRateField = new JTextField(10);

        // Create a button to update the currency
        JButton updateButton = new JButton("Update");

        // Set the layout for the update currency panel
        JPanel updateCurrencyPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the update currency panel
        updateCurrencyPanel.add(currencyIdLabel);
        updateCurrencyPanel.add(currencyIdField);
        updateCurrencyPanel.add(exchangeRateLabel);
        updateCurrencyPanel.add(exchangeRateField);
        updateCurrencyPanel.add(updateButton);

        // Add an action listener to the update button
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                int currencyId = Integer.parseInt(currencyIdField.getText());
                double updatedExchangeRate = Double.parseDouble(exchangeRateField.getText());

                // Update the exchange rate in the Currency table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("UPDATE Currency SET EXCHANGE_RATE = ? WHERE CURRENCY_ID = ?");
                    statement.setDouble(1, updatedExchangeRate);
                    statement.setInt(2, currencyId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the update
                    JOptionPane.showMessageDialog(updateCurrencyFrame, "Currency updated successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the update currency panel to the update currency frame
        updateCurrencyFrame.getContentPane().add(updateCurrencyPanel);

        updateCurrencyFrame.setVisible(true);
    }

    private void deleteCurrency() {
        JFrame deleteCurrencyFrame = new JFrame("Delete Currency");
        deleteCurrencyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteCurrencyFrame.setSize(400, 300);

        // Create labels and text fields for delete information
        JLabel currencyIdLabel = new JLabel("Currency ID to delete:");
        JTextField currencyIdField = new JTextField(10);

        // Create a button to delete the currency
        JButton deleteButton = new JButton("Delete");

        // Set the layout for the delete currency panel
        JPanel deleteCurrencyPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the delete currency panel
        deleteCurrencyPanel.add(currencyIdLabel);
        deleteCurrencyPanel.add(currencyIdField);
        deleteCurrencyPanel.add(deleteButton);

        // Add an action listener to the delete button
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input value
                int currencyId = Integer.parseInt(currencyIdField.getText());

                // Delete the currency from the Currency table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("DELETE FROM Currency WHERE CURRENCY_ID = ?");
                    statement.setInt(1, currencyId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the deletion
                    JOptionPane.showMessageDialog(deleteCurrencyFrame, "Currency deleted successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the delete currency panel to the delete currency frame
        deleteCurrencyFrame.getContentPane().add(deleteCurrencyPanel);

        deleteCurrencyFrame.setVisible(true);
    }

    
    private void displayClientTable() {
        JFrame clientFrame = new JFrame("Client Table");
        clientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clientFrame.setSize(400, 300);

        // Create a JTextArea to display the Client table rows
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(380, 250)); // Adjust the preferred size as needed

        // Establish a database connection
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the SELECT query on the Client table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Client");

            // Iterate through the result set and append the rows to the text area
            while (resultSet.next()) {
                int clientId = resultSet.getInt("CLIENT_ID");
                String name = resultSet.getString("NAME");
                String accountNumber = resultSet.getString("ACCOUNT_NUMBER");

                textArea.append("CLIENT_ID: " + clientId + "\n");
                textArea.append("NAME: " + name + "\n");
                textArea.append("ACCOUNT_NUMBER: " + accountNumber + "\n\n");
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Add the text area to the clientFrame
        clientFrame.getContentPane().add(new JScrollPane(textArea));

        clientFrame.setVisible(true);
    }

    private void addClient() {
        JFrame addClientFrame = new JFrame("Add Client");
        addClientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addClientFrame.setSize(400, 300);

        // Create labels and text fields for client information
        JLabel clientIdLabel = new JLabel("Client ID:");
        JTextField clientIdField = new JTextField(10);
        JLabel clientNameLabel = new JLabel("Client Name:");
        JTextField clientNameField = new JTextField(10);
        JLabel accountNumberLabel = new JLabel("Account Number:");
        JTextField accountNumberField = new JTextField(10);
//        JLabel emailLabel = new JLabel("Email:");
//        JTextField emailField = new JTextField(10);

        // Create a button to add the client
        JButton addButton = new JButton("Add");

        // Set the layout for the add client panel
        JPanel addClientPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the add client panel
        addClientPanel.add(clientIdLabel);
        addClientPanel.add(clientIdField);
        addClientPanel.add(clientNameLabel);
        addClientPanel.add(clientNameField);
        addClientPanel.add(accountNumberLabel);
        addClientPanel.add(accountNumberField);
//        addClientPanel.add(emailLabel);
//        addClientPanel.add(emailField);
        addClientPanel.add(addButton);

        // Add an action listener to the add button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                int clientId = Integer.parseInt(clientIdField.getText());
                String clientName = clientNameField.getText();
                String accountNumber = accountNumberField.getText();
//                String email = emailField.getText();

                // Insert the client into the Client table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO Client (CLIENT_ID, NAME, ACCOUNT_NUMBER) VALUES (?, ?, ?)");
                    statement.setInt(1, clientId);
                    statement.setString(2, clientName);
                    statement.setString(3, accountNumber);
//                    statement.setString(3, email);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the insertion
                    JOptionPane.showMessageDialog(addClientFrame, "Client added successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the add client panel to the add client frame
        addClientFrame.getContentPane().add(addClientPanel);

        addClientFrame.setVisible(true);
    }

    private void updateClient() {
        JFrame updateClientFrame = new JFrame("Update Client");
        updateClientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateClientFrame.setSize(400, 300);

        // Create labels and text fields for update information
     // Create labels and text fields for update information
        JLabel clientIdLabel = new JLabel("Client ID to update:");
        JTextField clientIdField = new JTextField(10);
        JLabel nameLabel = new JLabel("Updated Name:");
        JTextField nameField = new JTextField(10);
        JLabel accountNumberLabel = new JLabel("Updated Account Number:");
        JTextField accountNumberField = new JTextField(10);

        // Create a button to update the client
        JButton updateButton = new JButton("Update");

        // Set the layout for the update client panel
        JPanel updateClientPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the update client panel
        updateClientPanel.add(clientIdLabel);
        updateClientPanel.add(clientIdField);
        updateClientPanel.add(nameLabel);
        updateClientPanel.add(nameField);
        updateClientPanel.add(accountNumberLabel);
        updateClientPanel.add(accountNumberField);
        updateClientPanel.add(updateButton);

        // Add an action listener to the update button
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                int clientId = Integer.parseInt(clientIdField.getText());
                String updatedName = nameField.getText();
                int updatedAccountNumber = Integer.parseInt(accountNumberField.getText());

                // Update the client in the Client table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("UPDATE Client SET NAME = ?, ACCOUNT_NUMBER = ? WHERE CLIENT_ID = ?");
                    statement.setString(1, updatedName);
                    statement.setInt(2, updatedAccountNumber);
                    statement.setInt(3, clientId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the update
                    JOptionPane.showMessageDialog(updateClientFrame, "Client updated successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the update client panel to the update client frame
        updateClientFrame.getContentPane().add(updateClientPanel);

        updateClientFrame.setVisible(true);

    }

    private void deleteClient() {
        JFrame deleteClientFrame = new JFrame("Delete Client");
        deleteClientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteClientFrame.setSize(400, 300);

        // Create labels and text fields for delete information
        JLabel clientIdLabel = new JLabel("Client ID to delete:");
        JTextField clientIdField = new JTextField(10);

        // Create a button to delete the client
        JButton deleteButton = new JButton("Delete");

        // Set the layout for the delete client panel
        JPanel deleteClientPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the delete client panel
        deleteClientPanel.add(clientIdLabel);
        deleteClientPanel.add(clientIdField);
        deleteClientPanel.add(deleteButton);

        // Add an action listener to the delete button
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input value
                int clientId = Integer.parseInt(clientIdField.getText());

                // Delete the client from the Client table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("DELETE FROM Client WHERE CLIENT_ID = ?");
                    statement.setInt(1, clientId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the deletion
                    JOptionPane.showMessageDialog(deleteClientFrame, "Client deleted successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the delete client panel to the delete client frame
        deleteClientFrame.getContentPane().add(deleteClientPanel);

        deleteClientFrame.setVisible(true);

    }

    
    private void displayTransactionTable() {
        JFrame transactionFrame = new JFrame("Transaction Table");
        transactionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        transactionFrame.setSize(400, 300);

        // Create a JTextArea to display the Transaction table rows
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(380, 250)); // Adjust the preferred size as needed

        // Establish a database connection
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the SELECT query on the Transaction table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Transaction");

            // Iterate through the result set and append the rows to the text area
            while (resultSet.next()) {
                int transactionId = resultSet.getInt("TRANSACTION_ID");
                String transactionType = resultSet.getString("TRANSACTION_TYPE");
                String currencyName = resultSet.getString("CURRENCY_NAME");
                double transactionAmount = resultSet.getDouble("TRANSACTION_AMOUNT");
                Date transactionDate = resultSet.getDate("TRANSACTION_DATE");
                int clientId = resultSet.getInt("CLIENT_ID");

                textArea.append("TRANSACTION_ID: " + transactionId + "\n");
                textArea.append("TRANSACTION_TYPE: " + transactionType + "\n");
                textArea.append("CURRENCY_NAME: " + currencyName + "\n");
                textArea.append("TRANSACTION_AMOUNT: " + transactionAmount + "\n");
                textArea.append("TRANSACTION_DATE: " + transactionDate + "\n");
                textArea.append("CLIENT_ID: " + clientId + "\n\n");
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Add the text area to the transactionFrame
        transactionFrame.getContentPane().add(new JScrollPane(textArea));

        transactionFrame.setVisible(true);
    }

    private void addTransaction() {
        JFrame addTransactionFrame = new JFrame("Add Transaction");
        addTransactionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addTransactionFrame.setSize(400, 400);

        // Create labels and text fields for transaction information
        JLabel transactionIdLabel = new JLabel("Transaction ID:");
        JTextField transactionIdField = new JTextField(10);
        JLabel transactionTypeLabel = new JLabel("Transaction Type:");
        JTextField transactionTypeField = new JTextField(10);
        JLabel currencyNameLabel = new JLabel("Currency Name:");
        JTextField currencyNameField = new JTextField(10);
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField(10);
        JLabel dateLabel = new JLabel("Transaction Date:");
        JComboBox<Integer> dayComboBox = new JComboBox<>();
        JComboBox<Integer> monthComboBox = new JComboBox<>();
        JComboBox<Integer> yearComboBox = new JComboBox<>();
        JLabel clientIdLabel = new JLabel("Client ID:");
        JTextField clientIdField = new JTextField(10);

        // Create a button to add the transaction
        
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Month is zero-based in Calendar
        int currentYear = calendar.get(Calendar.YEAR);

        // Populate day, month, and year JComboBoxes with appropriate values
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(i);
        }
        for (int i = currentYear - 10; i <= currentYear + 10; i++) {
            yearComboBox.addItem(i);
        }

        // Set the default values to today's date
        dayComboBox.setSelectedItem(currentDay);
        monthComboBox.setSelectedItem(currentMonth);
        yearComboBox.setSelectedItem(currentYear);
        
        JButton addButton = new JButton("Add");
        
        // Set the layout for the add transaction panel
        JPanel addTransactionPanel = new JPanel(new GridLayout(7, 2, 10, 10)); // 7 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the add transaction panel
        addTransactionPanel.add(transactionIdLabel);
        addTransactionPanel.add(transactionIdField);
        addTransactionPanel.add(transactionTypeLabel);
        addTransactionPanel.add(transactionTypeField);
        addTransactionPanel.add(currencyNameLabel);
        addTransactionPanel.add(currencyNameField);
        addTransactionPanel.add(amountLabel);
        addTransactionPanel.add(amountField);
        addTransactionPanel.add(dateLabel);
        addTransactionPanel.add(dayComboBox);
        addTransactionPanel.add(monthComboBox);
        addTransactionPanel.add(yearComboBox);
        addTransactionPanel.add(clientIdLabel);
        addTransactionPanel.add(clientIdField);
        addTransactionPanel.add(addButton);

        // Add an action listener to the add button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                int transactionId = Integer.parseInt(transactionIdField.getText());
                String transactionType = transactionTypeField.getText();
                String currencyName = currencyNameField.getText();
                double amount = Double.parseDouble(amountField.getText());
                int day = (int) dayComboBox.getSelectedItem();
                int month = (int) monthComboBox.getSelectedItem();
                int year = (int) yearComboBox.getSelectedItem();
                int clientId = Integer.parseInt(clientIdField.getText());
                
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month - 1, day); // Month is zero-based in Calendar

                // Get the selected date as a Date object
                Date selectedDate = calendar.getTime();
                // Insert the transaction into the Transaction table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO Transaction (TRANSACTION_ID, TRANSACTION_TYPE, CURRENCY_NAME, TRANSACTION_AMOUNT, TRANSACTION_DATE, CLIENT_ID) VALUES (?, ?, ?, ?, ?, ?)");
                    statement.setInt(1, transactionId);
                    statement.setString(2, transactionType);
                    statement.setString(3, currencyName);
                    statement.setDouble(4, amount);
                    statement.setDate(5, new java.sql.Date(selectedDate.getTime()));
                    statement.setInt(6, clientId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the insertion
                    JOptionPane.showMessageDialog(addTransactionFrame, "Transaction added successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the add transaction panel to the add transaction frame
        addTransactionFrame.getContentPane().add(addTransactionPanel);

        addTransactionFrame.setVisible(true);
    }
   
    private void updateTransaction() {
        JFrame updateTransactionFrame = new JFrame("Update Transaction");
        updateTransactionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateTransactionFrame.setSize(400, 300);

        // Create labels and text fields for update information
     // Create labels and text fields for update information
        JLabel transactionIdLabel = new JLabel("Transaction ID to update:");
        JTextField transactionIdField = new JTextField(10);
        JLabel amountLabel = new JLabel("Updated Amount:");
        JTextField amountField = new JTextField(10);
        JLabel clientIdLabel = new JLabel("Client ID:");
        JTextField clientIdField = new JTextField(10);

        // Create a button to update the transaction
        JButton updateButton = new JButton("Update");

        // Set the layout for the update transaction panel
        JPanel updateTransactionPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the update transaction panel
        updateTransactionPanel.add(transactionIdLabel);
        updateTransactionPanel.add(transactionIdField);
        updateTransactionPanel.add(amountLabel);
        updateTransactionPanel.add(amountField);
        updateTransactionPanel.add(clientIdLabel);
        updateTransactionPanel.add(clientIdField);
        updateTransactionPanel.add(updateButton);

        // Add an action listener to the update button
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                int transactionId = Integer.parseInt(transactionIdField.getText());
                double updatedAmount = Double.parseDouble(amountField.getText());
                int clientId = Integer.parseInt(clientIdField.getText());

                // Update the amount in the Transaction table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("UPDATE Transaction SET TRANSACTION_AMOUNT = ? WHERE TRANSACTION_ID = ? AND CLIENT_ID = ?");
                    statement.setDouble(1, updatedAmount);
                    statement.setInt(2, transactionId);
                    statement.setInt(3, clientId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the update
                    JOptionPane.showMessageDialog(updateTransactionFrame, "Transaction updated successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the update transaction panel to the update transaction frame
        updateTransactionFrame.getContentPane().add(updateTransactionPanel);

        updateTransactionFrame.setVisible(true);

    }

    private void deleteTransaction() {
        JFrame deleteTransactionFrame = new JFrame("Delete Transaction");
        deleteTransactionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteTransactionFrame.setSize(400, 300);

     // Create labels and text fields for delete information
        JLabel transactionIdLabel = new JLabel("Transaction ID to delete:");
        JTextField transactionIdField = new JTextField(10);

        // Create a button to delete the transaction
        JButton deleteButton = new JButton("Delete");

        // Set the layout for the delete transaction panel
        JPanel deleteTransactionPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the delete transaction panel
        deleteTransactionPanel.add(transactionIdLabel);
        deleteTransactionPanel.add(transactionIdField);
        deleteTransactionPanel.add(deleteButton);

        // Add an action listener to the delete button
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input value
                int transactionId = Integer.parseInt(transactionIdField.getText());

                // Delete the transaction from the Transaction table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("DELETE FROM Transaction WHERE TRANSACTION_ID = ?");
                    statement.setInt(1, transactionId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the deletion
                    JOptionPane.showMessageDialog(deleteTransactionFrame, "Transaction deleted successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the delete transaction panel to the delete transaction frame
        deleteTransactionFrame.getContentPane().add(deleteTransactionPanel);

        deleteTransactionFrame.setVisible(true);

    }

    
    private void displayTradeTable() {
        JFrame tradeFrame = new JFrame("Trade Table");
        tradeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tradeFrame.setSize(400, 300);

        // Create a JTextArea to display the Trade table rows
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(380, 250)); // Adjust the preferred size as needed

        // Establish a database connection
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the SELECT query on the Trade table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Trade");

            // Iterate through the result set and append the rows to the text area
            while (resultSet.next()) {
                int tradeId = resultSet.getInt("TRADE_ID");
                String tradeType = resultSet.getString("TRADE_TYPE");
                String currencyType = resultSet.getString("CURRENCY_TYPE");
                double tradeAmount = resultSet.getDouble("TRADE_AMOUNT");
                Date time = resultSet.getDate("TIME");
                int clientId = resultSet.getInt("CLIENT_ID");

                textArea.append("TRADE_ID: " + tradeId + "\n");
                textArea.append("TRADE_TYPE: " + tradeType + "\n");
                textArea.append("CURRENCY_TYPE: " + currencyType + "\n");
                textArea.append("TRADE_AMOUNT: " + tradeAmount + "\n");
                textArea.append("TIME: " + time + "\n");
                textArea.append("CLIENT_ID: " + clientId + "\n\n");
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Add the text area to the tradeFrame
        tradeFrame.getContentPane().add(new JScrollPane(textArea));

        tradeFrame.setVisible(true);
    }
    
    private void addTrade() {
        JFrame addTradeFrame = new JFrame("Add Trade");
        addTradeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addTradeFrame.setSize(400, 300);

     // Create labels and text fields for trade information
        JLabel tradeIdLabel = new JLabel("Trade ID:");
        JTextField tradeIdField = new JTextField(10);
        JLabel tradeTypeLabel = new JLabel("Trade Type:");
        JTextField tradeTypeField = new JTextField(10);
        JLabel currencyTypeLabel = new JLabel("Currency Type:");
        JTextField currencyTypeField = new JTextField(10);
        JLabel tradeAmountLabel = new JLabel("Trade Amount:");
        JTextField tradeAmountField = new JTextField(10);
        JLabel timeLabel = new JLabel("Time:");
        JTextField timeField = new JTextField(10);
        JLabel clientIdLabel = new JLabel("Client ID:");
        JTextField clientIdField = new JTextField(10);

        // Create a button to add the trade
        JButton addButton = new JButton("Add");

        // Set the layout for the add trade panel
        JPanel addTradePanel = new JPanel(new GridLayout(7, 2, 10, 10)); // 7 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the add trade panel
        addTradePanel.add(tradeIdLabel);
        addTradePanel.add(tradeIdField);
        addTradePanel.add(tradeTypeLabel);
        addTradePanel.add(tradeTypeField);
        addTradePanel.add(currencyTypeLabel);
        addTradePanel.add(currencyTypeField);
        addTradePanel.add(tradeAmountLabel);
        addTradePanel.add(tradeAmountField);
        addTradePanel.add(timeLabel);
        addTradePanel.add(timeField);
        addTradePanel.add(clientIdLabel);
        addTradePanel.add(clientIdField);
        addTradePanel.add(addButton);

        // Add an action listener to the add button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                int tradeId = Integer.parseInt(tradeIdField.getText());
                String tradeType = tradeTypeField.getText();
                String currencyType = currencyTypeField.getText();
                double tradeAmount = Double.parseDouble(tradeAmountField.getText());
                String time = timeField.getText();
                int clientId = Integer.parseInt(clientIdField.getText());

                // Insert the trade into the Trade table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO Trade (TRADE_ID, TRADE_TYPE, CURRENCY_TYPE, TRADE_AMOUNT, TIME, CLIENT_ID) VALUES (?, ?, ?, ?, ?, ?)");
                    statement.setInt(1, tradeId);
                    statement.setString(2, tradeType);
                    statement.setString(3, currencyType);
                    statement.setDouble(4, tradeAmount);
                    statement.setString(5, time);
                    statement.setInt(6, clientId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the insertion
                    JOptionPane.showMessageDialog(addTradeFrame, "Trade added successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the add trade panel to the add trade frame
        addTradeFrame.getContentPane().add(addTradePanel);

        addTradeFrame.setVisible(true);

    }

    private void updateTrade() {
        JFrame updateTradeFrame = new JFrame("Update Trade");
        updateTradeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateTradeFrame.setSize(400, 300);

        // Create labels and text fields for update information
        JLabel tradeIdLabel = new JLabel("Trade ID to update:");
        JTextField tradeIdField = new JTextField(10);
        JLabel clientIdLabel = new JLabel("Client ID:");
        JTextField clientIdField = new JTextField(10);
        JLabel amountLabel = new JLabel("Updated Amount:");
        JTextField amountField = new JTextField(10);

        // Create a button to update the trade
        JButton updateButton = new JButton("Update");

        // Set the layout for the update trade panel
        JPanel updateTradePanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the update trade panel
        updateTradePanel.add(tradeIdLabel);
        updateTradePanel.add(tradeIdField);
        updateTradePanel.add(clientIdLabel);
        updateTradePanel.add(clientIdField);
        updateTradePanel.add(amountLabel);
        updateTradePanel.add(amountField);
        updateTradePanel.add(updateButton);

        // Add an action listener to the update button
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                int tradeId = Integer.parseInt(tradeIdField.getText());
                int clientId = Integer.parseInt(clientIdField.getText());
                double updatedAmount = Double.parseDouble(amountField.getText());

                // Update the trade in the Trade table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("UPDATE Trade SET CLIENT_ID = ?, TRADE_AMOUNT = ? WHERE TRADE_ID = ?");
                    statement.setInt(1, clientId);
                    statement.setDouble(2, updatedAmount);
                    statement.setInt(3, tradeId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the update
                    JOptionPane.showMessageDialog(updateTradeFrame, "Trade updated successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the update trade panel to the update trade frame
        updateTradeFrame.getContentPane().add(updateTradePanel);

        updateTradeFrame.setVisible(true);
    }

    private void deleteTrade() {
        JFrame deleteTradeFrame = new JFrame("Delete Trade");
        deleteTradeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteTradeFrame.setSize(400, 300);

        // Create labels and text fields for delete information
        JLabel tradeIdLabel = new JLabel("Trade ID to delete:");
        JTextField tradeIdField = new JTextField(10);

        // Create a button to delete the trade
        JButton deleteButton = new JButton("Delete");

        // Set the layout for the delete trade panel
        JPanel deleteTradePanel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the delete trade panel
        deleteTradePanel.add(tradeIdLabel);
        deleteTradePanel.add(tradeIdField);
        deleteTradePanel.add(deleteButton);

        // Add an action listener to the delete button
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input value
                int tradeId = Integer.parseInt(tradeIdField.getText());

                // Delete the trade from the Trade table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("DELETE FROM Trade WHERE TRADE_ID = ?");
                    statement.setInt(1, tradeId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the deletion
                    JOptionPane.showMessageDialog(deleteTradeFrame, "Trade deleted successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the delete trade panel to the delete trade frame
        deleteTradeFrame.getContentPane().add(deleteTradePanel);

        deleteTradeFrame.setVisible(true);
    }

    
    
    private void displayAccountTable() {
        JFrame accountFrame = new JFrame("Account Table");
        accountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        accountFrame.setSize(400, 300);

        // Create a JTextArea to display the Account table rows
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(380, 250)); // Adjust the preferred size as needed

        // Establish a database connection
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the SELECT query on the Account table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Account");

            // Iterate through the result set and append the rows to the text area
            while (resultSet.next()) {
                String accountNumber = resultSet.getString("ACCOUNT_NUMBER");
                double balance = resultSet.getDouble("ACCOUNT_BALANCE");
                int clientId = resultSet.getInt("CLIENT_ID");

                textArea.append("ACCOUNT_TYPE: " + accountNumber + "\n");
                textArea.append("BALANCE: " + balance + "\n");
                textArea.append("CLIENT_ID: " + clientId + "\n\n");
            }

            // Close the result set and statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Add the text area to the accountFrame
        accountFrame.getContentPane().add(new JScrollPane(textArea));

        accountFrame.setVisible(true);
    }

    private void addAccount() {
        JFrame addAccountFrame = new JFrame("Add Account");
        addAccountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addAccountFrame.setSize(400, 300);

        // Create labels and text fields for account information
        JLabel accountNumberLabel = new JLabel("Account Number:");
        JTextField accountNumberField = new JTextField(10);
        JLabel accountBalanceLabel = new JLabel("Account Balance:");
        JTextField accountBalanceField = new JTextField(10);
        JLabel clientIdLabel = new JLabel("Client ID:");
        JTextField clientIdField = new JTextField(10);

        // Create a button to add the account
        JButton addButton = new JButton("Add");

        // Set the layout for the add account panel
        JPanel addAccountPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the add account panel
        addAccountPanel.add(accountNumberLabel);
        addAccountPanel.add(accountNumberField);
        addAccountPanel.add(accountBalanceLabel);
        addAccountPanel.add(accountBalanceField);
        addAccountPanel.add(clientIdLabel);
        addAccountPanel.add(clientIdField);
        addAccountPanel.add(addButton);

        // Add an action listener to the add button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                int accountNumber = Integer.parseInt(accountNumberField.getText());
                double accountBalance = Double.parseDouble(accountBalanceField.getText());
                int clientId = Integer.parseInt(clientIdField.getText());

                // Insert the account into the Account table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO Account (ACCOUNT_NUMBER, ACCOUNT_BALANCE, CLIENT_ID) VALUES (?, ?, ?)");
                    statement.setInt(1, accountNumber);
                    statement.setDouble(2, accountBalance);
                    statement.setInt(3, clientId);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the insertion
                    JOptionPane.showMessageDialog(addAccountFrame, "Account added successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the add account panel to the add account frame
        addAccountFrame.getContentPane().add(addAccountPanel);

        addAccountFrame.setVisible(true);
    }

    private void updateAccount() {
        JFrame updateAccountFrame = new JFrame("Update Account");
        updateAccountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateAccountFrame.setSize(400, 300);

        // Create labels and text fields for update information
        JLabel accountNumberLabel = new JLabel("Account Number to update:");
        JTextField accountNumberField = new JTextField(10);
        JLabel accountBalanceLabel = new JLabel("Updated Balance:");
        JTextField accountBalanceField = new JTextField(10);

        // Create a button to update the account
        JButton updateButton = new JButton("Update");

        // Set the layout for the update account panel
        JPanel updateAccountPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the update account panel
        updateAccountPanel.add(accountNumberLabel);
        updateAccountPanel.add(accountNumberField);
        updateAccountPanel.add(accountBalanceLabel);
        updateAccountPanel.add(accountBalanceField);
        updateAccountPanel.add(updateButton);

        // Add an action listener to the update button
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                int accountNumber = Integer.parseInt(accountNumberField.getText());
                double updatedBalance = Double.parseDouble(accountBalanceField.getText());

                // Update the balance in the Account table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("UPDATE Account SET ACCOUNT_BALANCE = ? WHERE ACCOUNT_NUMBER = ?");
                    statement.setDouble(1, updatedBalance);
                    statement.setInt(2, accountNumber);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the update
                    JOptionPane.showMessageDialog(updateAccountFrame, "Account updated successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the update account panel to the update account frame
        updateAccountFrame.getContentPane().add(updateAccountPanel);

        updateAccountFrame.setVisible(true);
    }

    private void deleteAccount() {
        JFrame deleteAccountFrame = new JFrame("Delete Account");
        deleteAccountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteAccountFrame.setSize(400, 300);

        // Create labels and text fields for delete information
        JLabel accountNumberLabel = new JLabel("Account Number to delete:");
        JTextField accountNumberField = new JTextField(10);

        // Create a button to delete the account
        JButton deleteButton = new JButton("Delete");

        // Set the layout for the delete account panel
        JPanel deleteAccountPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 rows, 2 columns with 10px horizontal and vertical gaps

        // Add components to the delete account panel
        deleteAccountPanel.add(accountNumberLabel);
        deleteAccountPanel.add(accountNumberField);
        deleteAccountPanel.add(deleteButton);

        // Add an action listener to the delete button
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input value
                int accountNumber = Integer.parseInt(accountNumberField.getText());

                // Delete the account from the Account table
                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    // Create a prepared statement
                    PreparedStatement statement = connection.prepareStatement("DELETE FROM Account WHERE ACCOUNT_NUMBER = ?");
                    statement.setInt(1, accountNumber);

                    // Execute the statement
                    int rowsAffected = statement.executeUpdate();

                    // Display a message indicating the success of the deletion
                    JOptionPane.showMessageDialog(deleteAccountFrame, "Account deleted successfully. Rows affected: " + rowsAffected);

                    // Close the statement
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add the delete account panel to the delete account frame
        deleteAccountFrame.getContentPane().add(deleteAccountPanel);

        deleteAccountFrame.setVisible(true);
    }

    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Interface forex = new Interface();
                forex.setVisible(true);
            }
        });
    }
}
