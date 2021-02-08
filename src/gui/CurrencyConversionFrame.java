package gui;

import assets.Constants;
import assets.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * Date and Times
 * CurrencyConversionFrame.java
 *
 * Frame for converting various currencies.
 *
 * @author Henrik Berg
 * @version December 21, 2020
 */
public final class CurrencyConversionFrame extends JFrame implements ActionListener {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel subHeaderPanel;
    private final JPanel conversionPanel;
    private final JPanel resultPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel subHeaderLabel;
    private final JLabel initialCurrencyLabel;
    private final JLabel initialAmountLabel;
    private final JLabel finalCurrencyLabel;
    private final JLabel finalAmountLabel;

    private final JComboBox<String> initialCurrencyComboBox;
    private final JComboBox<String> finalCurrencyComboBox;

    private final JTextField initialAmountField;

    private final JButton convertCurrencyButton;
    private final JButton backButton;

    /**
     * Constructor that creates the currency conversion frame.
     */
    public CurrencyConversionFrame(ResourceBundle resourceBundle) {
        super("Date and Times | Currency Conversion");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());
        subHeaderPanel = new JPanel(new GridBagLayout());
        conversionPanel = new JPanel(new GridBagLayout());
        resultPanel = new JPanel(new GridBagLayout());
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel(resourceBundle.getString("Header"));
        subHeaderLabel = new JLabel(resourceBundle.getString("CurrencyConversion"));
        initialCurrencyLabel = new JLabel(resourceBundle.getString("InitialCurrency"));
        initialAmountLabel = new JLabel(resourceBundle.getString("initialAmount"));
        finalCurrencyLabel = new JLabel(resourceBundle.getString("finalCurrency"));
        finalAmountLabel = new JLabel(resourceBundle.getString("finalAmount"));

        initialCurrencyComboBox = new JComboBox<>(new String[] {"", "USD", "GBP", "EUR", "CAD", "CNY", "JPY", "KRW", "TWD", "INR");
        finalCurrencyComboBox = new JComboBox<>(new String[] {"", "USD", "GBP", "EUR", "CAD", "CNY", "JPY", "KRW", "TWD", "INR");

        initialAmountField = new JTextField(10);

        convertCurrencyButton = new JButton("Convert Currency");
        backButton = new JButton(resourceBundle.getString("Back"));

        this.setSize(550, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        convertCurrencyButton.addActionListener(this);
        backButton.addActionListener(this);

        headerLabel.setFont(Constants.HEADER_FONT);
        subHeaderLabel.setFont(Constants.SUB_HEADER_FONT);

        finalAmountLabel.setFont(Constants.SUB_SUB_HEADER_FONT);

        initialCurrencyLabel.setFont(Constants.MAIN_FONT);
        initialAmountLabel.setFont(Constants.MAIN_FONT);
        finalCurrencyLabel.setFont(Constants.MAIN_FONT);

        convertCurrencyButton.setFont(Constants.MAIN_FONT);
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

        SwingUtils.addComponent(conversionPanel, initialCurrencyLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(conversionPanel, initialCurrencyComboBox, 1, 0, 1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(conversionPanel, initialAmountLabel, 0, 1, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(conversionPanel, initialAmountField, 1, 1, 1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(conversionPanel, finalCurrencyLabel, 0, 2, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(conversionPanel, finalCurrencyComboBox, 1, 2, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(resultPanel, finalAmountLabel, 0, 0, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(resultPanel, convertCurrencyButton, 0, 1, 1, 1, GridBagConstraints.PAGE_END);

        SwingUtils.addComponent(contentPanel, subHeaderPanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, conversionPanel, 0, 1, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, resultPanel, 0, 2, 1, 1, GridBagConstraints.CENTER);

        navigationPanel.add(backButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);

        this.setVisible(true);

        Locale.
    }

    /**
     * Action performed method used by ActionListener.
     *
     * @param ae the ActionEvent that occurred.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == convertCurrencyButton) {
            // TODO: Add implementation here
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

}
