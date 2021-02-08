package gui;

import assets.Constants;
import assets.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

/**
 * Date and Times
 * HomeFrame.java
 *
 * The home frame for the application.
 *
 * @author Henrik Berg
 * @version December 21, 2020
 */
public final class HomeFrame extends JFrame implements ActionListener, ItemListener {
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
    private static final Locale english = Locale.ENGLISH;
    private static final Locale french = Locale.FRENCH;
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("gui/Currency", english);


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
        headerLabel = new JLabel(resourceBundle.getString("Header"));
        subHeaderLabel = new JLabel(resourceBundle.getString("welcome"));
        descriptionLabel = new JLabel(resourceBundle.getString("description"));
        extendedDescriptionLabel = new JLabel(resourceBundle.getString("extendedDescription"));
        languageLabel = new JLabel("Language:");

        convertCurrencyButton = new JButton(resourceBundle.getString("ConvertCurrencies"));
        dayOfWeekFinderButton = new JButton(resourceBundle.getString("DayOfWeek"));
        currencyFormattingButton = new JButton(resourceBundle.getString("CurrencyFormatting"));
        closeButton = new JButton(resourceBundle.getString("Close"));

        languageComboBox = new JComboBox(new String[] {"English", "Francais"});
        setLangOption(resourceBundle.getLocale().getDisplayLanguage());
        this.setSize(550, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        convertCurrencyButton.addActionListener(this);
        dayOfWeekFinderButton.addActionListener(this);
        currencyFormattingButton.addActionListener(this);
        closeButton.addActionListener(this);
        languageComboBox.addItemListener(this);
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
                        new CurrencyConversionFrame(resourceBundle);
                    if (source == dayOfWeekFinderButton)
                        new DayOfWeekFinderFrame(resourceBundle);
                    if (source == currencyFormattingButton)
                        new CurrencyFormattingFrame(resourceBundle);
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

    /**
     * Item state changed method used by ItemListener.
     *
     * @param ie the ItemEvent that occurred.
     */
    @Override
    public void itemStateChanged(ItemEvent ie) {
        String item = (String) languageComboBox.getSelectedItem();

        if (item.equals("English")) {
           // Nothing needs to be done
            resourceBundle = ResourceBundle.getBundle("gui/Currency", english);
            setLabels();
        }
        if (item.equals("Francais")) {
            resourceBundle = ResourceBundle.getBundle("gui/Currency", french);
            setLabels();

        }

        this.revalidate();
        this.repaint();
    }

    public void setLabels() {
        headerLabel.setText(resourceBundle.getString("Header"));
        subHeaderLabel.setText(resourceBundle.getString("welcome"));
        descriptionLabel.setText(resourceBundle.getString("description"));
        extendedDescriptionLabel.setText(resourceBundle.getString("extendedDescription"));
        convertCurrencyButton.setText(resourceBundle.getString("ConvertCurrencies"));
        dayOfWeekFinderButton.setText(resourceBundle.getString("DayOfWeek"));
        currencyFormattingButton.setText(resourceBundle.getString("CurrencyFormatting"));
        closeButton.setText(resourceBundle.getString("Close"));


    }

    protected final void setLangOption(String language) {
        switch (language) {
            case "English":
                languageComboBox.setSelectedItem("English");
                break;
            case "French":
                languageComboBox.setSelectedItem("Francais");
                break;
            default:
                System.out.println("didn't work");
        }
    }
}
