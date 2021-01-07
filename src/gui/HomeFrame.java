package gui;

import assets.Constants;
import assets.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Date and Times
 * HomeFrame.java
 *
 * The home frmae for the application.
 *
 * @author Henrik Berg
 * @version December 21, 2020
 */
public final class HomeFrame extends JFrame implements ActionListener {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel subHeaderPanel;
    private final JPanel buttonPanel;
    private final JPanel languagePanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel subHeaderLabel;
    private final JLabel descriptionLabel;
    private final JLabel extendedDescriptionLabel;
    private final JLabel languageLabel;

    private final JButton convertCurrencyButton;
    private final JButton dayOfWeekFinderButton;
    private final JButton currencyFormattingButton;
    private final JButton closeButton;

    private final JComboBox languageComboBox;

    /**
     * Constructor that creates the home frame.
     */
    public HomeFrame() {
        super("Date and Times | Home");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());
        subHeaderPanel = new JPanel(new GridBagLayout());
        buttonPanel = new JPanel(new GridBagLayout());
        languagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel(" Date and Times");
        subHeaderLabel = new JLabel("Welcome!");
        descriptionLabel = new JLabel("Convert currencies, check currency formats, and more.");
        extendedDescriptionLabel = new JLabel("Select one of the options below to navigate the application.");
        languageLabel = new JLabel("Language:");

        convertCurrencyButton = new JButton("Convert Currencies");
        dayOfWeekFinderButton = new JButton("Find Day Of Week");
        currencyFormattingButton = new JButton("Currency Formatting");
        closeButton = new JButton("Close");

        languageComboBox = new JComboBox(new String[] {"English", "Francais"});

        this.setSize(450, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        convertCurrencyButton.addActionListener(this);
        dayOfWeekFinderButton.addActionListener(this);
        currencyFormattingButton.addActionListener(this);
        closeButton.addActionListener(this);

        headerLabel.setFont(Constants.HEADER_FONT);
        subHeaderLabel.setFont(Constants.SUB_HEADER_FONT);
        languageLabel.setFont(Constants.SUB_SUB_HEADER_FONT);

        descriptionLabel.setFont(Constants.MAIN_FONT);
        extendedDescriptionLabel.setFont(Constants.MAIN_FONT);
        convertCurrencyButton.setFont(Constants.MAIN_FONT);
        dayOfWeekFinderButton.setFont(Constants.MAIN_FONT);
        currencyFormattingButton.setFont(Constants.MAIN_FONT);
        languageComboBox.setFont(Constants.MAIN_FONT);
        closeButton.setFont(Constants.MAIN_FONT);

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
        SwingUtils.addComponent(subHeaderPanel, descriptionLabel, 0, 1, 1, 1, GridBagConstraints.PAGE_END);
        SwingUtils.addComponent(subHeaderPanel, extendedDescriptionLabel, 0, 2, 1, 1, GridBagConstraints.PAGE_START);

        SwingUtils.addComponent(buttonPanel, convertCurrencyButton, 0, 0, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(buttonPanel, dayOfWeekFinderButton, 1, 0, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(buttonPanel, currencyFormattingButton, 0, 1, 1, 1, GridBagConstraints.PAGE_START);

        languagePanel.add(languageLabel);
        languagePanel.add(languageComboBox);

        SwingUtils.addComponent(contentPanel, subHeaderPanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, buttonPanel, 0, 1, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(contentPanel, languagePanel, 0, 2, 1, 1, GridBagConstraints.LAST_LINE_END);

        navigationPanel.add(closeButton);

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

        if (source != closeButton) {
            this.dispose();
            EventQueue.invokeLater(() -> {
                try {
                    if (source == convertCurrencyButton)
                        new CurrencyConversionFrame();
                    if (source == dayOfWeekFinderButton)
                        new DayOfWeekFinderFrame();
                    if (source == currencyFormattingButton)
                        new CurrencyFormattingFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } else {
            this.dispose();
        }
    }

    /**
     * Main method for the application.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new HomeFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
