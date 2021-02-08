package gui;

import assets.Constants;
import assets.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Date and Times
 * CurrencyFormattingFrame.java
 *
 * Frame for checking the format of various currencies.
 *
 * @author Henrik Berg
 * @version December 21, 2020
 */
public final class CurrencyFormattingFrame extends JFrame implements ActionListener {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel subHeaderPanel;
    private final JPanel formattingPanel;
    private final JPanel resultPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel subHeaderLabel;
    private final JLabel amountLabel;
    private final JLabel currencyLabel;
    private final JLabel resultLabel;

    private final JComboBox<String> currencyComboBox;
    NumberFormat currentFormat; // Formatter for selected currency instance

    private final JTextField amountField;

    private final JButton formatCurrencyButton;
    private final JButton backButton;

    /**
     * Constructor that creates the currency formatting frame.
     */
    public CurrencyFormattingFrame(ResourceBundle resourceBundle) {

        super("Date and Times | Currency Formatting");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());
        subHeaderPanel = new JPanel(new GridBagLayout());
        formattingPanel = new JPanel(new GridBagLayout());
        resultPanel = new JPanel(new GridBagLayout());
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel(resourceBundle.getString("Header"));
        subHeaderLabel = new JLabel(resourceBundle.getString("CurrencyConversion"));
        amountLabel = new JLabel(resourceBundle.getString("Amount"));
        currencyLabel = new JLabel(resourceBundle.getString("Currency"));
        resultLabel = new JLabel(resourceBundle.getString("Formatted"));

        currencyComboBox = new JComboBox<>(new String[] {"", resourceBundle.getString("Euro"),
                resourceBundle.getString("BritishPound"),
                resourceBundle.getString("USDollar")});

        amountField = new JTextField(10);

        formatCurrencyButton = new JButton("Format Currency");
        backButton = new JButton(resourceBundle.getString("Back"));

        this.setSize(550, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        formatCurrencyButton.addActionListener(this);
        backButton.addActionListener(this);

        headerLabel.setFont(Constants.HEADER_FONT);
        subHeaderLabel.setFont(Constants.SUB_HEADER_FONT);

        resultLabel.setFont(Constants.SUB_SUB_HEADER_FONT);

        amountLabel.setFont(Constants.MAIN_FONT);
        currencyLabel.setFont(Constants.MAIN_FONT);
        formatCurrencyButton.setFont(Constants.MAIN_FONT);
        backButton.setFont(Constants.MAIN_FONT);

        headerPanel.setBackground(Constants.HEADER_BACKGROUND_COLOR);
        navigationPanel.setBackground(Constants.BACKGROUND_COLOR);

        headerPanel.setBorder(Constants.HEADER_BORDER);
        navigationPanel.setBorder(Constants.NAVIGATION_BORDER);

        logoLabel.setIcon(Constants.LOGO_64);

        headerLabel.setForeground(Constants.BLUE_COLOR);

        SwingUtils.addComponent(headerPanel, logoLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(headerPanel, headerLabel, 1, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 2, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 3, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 4, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 5, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 6, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 7, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 8, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 9, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 10, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 11, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 12, 0, 1, 1, GridBagConstraints.CENTER);

        SwingUtils.addComponent(subHeaderPanel, subHeaderLabel, 0, 0, 1, 1, GridBagConstraints.CENTER);

        SwingUtils.addComponent(formattingPanel, amountLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(formattingPanel, amountField, 1, 0, 1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(formattingPanel, currencyLabel, 0, 1, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(formattingPanel, currencyComboBox, 1, 1, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(resultPanel, resultLabel, 0, 0, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(resultPanel, formatCurrencyButton, 0, 1, 1, 1, GridBagConstraints.PAGE_END);

        SwingUtils.addComponent(contentPanel, subHeaderPanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, formattingPanel, 0, 1, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, resultPanel, 0, 2, 1, 1, GridBagConstraints.CENTER);

        navigationPanel.add(backButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    /**
     * Action performed method used by ActionListener.
     *
     * @param ae the ActionEvent that occurred.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == formatCurrencyButton) {
            resultLabel.setText("Formatted: " + formatCurrency());
        }
        if (source == backButton) {
            this.dispose();
            EventQueue.invokeLater(() -> {
                try {
                    new HomeFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public String formatCurrency() {
        currentFormat = NumberFormat.getCurrencyInstance(findFormat());
        return currentFormat.format(Double.parseDouble(amountField.getText()));

    }

    public Locale findFormat() {
        String currencyString = (String) currencyComboBox.getSelectedItem();

        switch(currencyString) {
            case "Euro":
                return Locale.FRANCE;
            case "British Pound":
                return Locale.UK;
            case "United States Dollar":
                return Locale.US;
            default:
                return null;
        }
    }

}
