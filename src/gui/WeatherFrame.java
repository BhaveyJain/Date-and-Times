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
 * WeatherFrame.java
 *
 * Frame for checking weather.
 *
 * @author Henrik Berg
 * @version February 8, 2020
 */
public final class WeatherFrame extends JFrame implements ActionListener {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel subHeaderPanel;
    private final JPanel weatherPanel;
    private final JPanel resultPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel subHeaderLabel;
    private final JLabel zipCodeLabel;
    private final JLabel orLabel;
    private final JLabel cityLabel;
    private final JLabel countryLabel;
    private final JLabel resultLabel;

    private final JTextField zipCodeField;
    private final JTextField cityField;
    private final JTextField countryField;

    private final JButton getWeatherButton;
    private final JButton backButton;

    /**
     * Constructor that creates the weather frame.
     */
    public WeatherFrame(ResourceBundle resourceBundle) {
        super("Date and Times | Weather");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());
        subHeaderPanel = new JPanel(new GridBagLayout());
        weatherPanel = new JPanel(new GridBagLayout());
        resultPanel = new JPanel(new GridBagLayout());
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel(resourceBundle.getString("Header"));
        subHeaderLabel = new JLabel(resourceBundle.getString("CurrencyConversion"));
        zipCodeLabel = new JLabel(resourceBundle.getString("ZipCode"));
        orLabel = new JLabel(resourceBundle.getString("Or"));
        cityLabel = new JLabel(resourceBundle.getString("City"));
        countryLabel = new JLabel(resourceBundle.getString("Country"));
        resultLabel = new JLabel(resourceBundle.getString("Weather"));

        zipCodeField = new JTextField(10);
        cityField = new JTextField(10);
        countryField = new JTextField(10);

        getWeatherButton = new JButton("Get Weather");
        backButton = new JButton(resourceBundle.getString("Back"));

        this.setSize(550, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        getWeatherButton.addActionListener(this);
        backButton.addActionListener(this);

        headerLabel.setFont(Constants.HEADER_FONT);
        subHeaderLabel.setFont(Constants.SUB_HEADER_FONT);

        resultLabel.setFont(Constants.SUB_SUB_HEADER_FONT);

        zipCodeLabel.setFont(Constants.MAIN_FONT);
        orLabel.setFont(Constants.MAIN_FONT);
        cityLabel.setFont(Constants.MAIN_FONT);
        countryLabel.setFont(Constants.MAIN_FONT);
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

        SwingUtils.addComponent(weatherPanel, zipCodeLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(weatherPanel, zipCodeField, 1, 0, 1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(weatherPanel, orLabel, 0, 1, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(weatherPanel, cityLabel, 0, 2, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(weatherPanel, cityField, 1, 2, 1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(weatherPanel, countryLabel, 0, 3, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(weatherPanel, countryField, 1, 3, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(resultPanel, resultLabel, 0, 0, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(resultPanel, getWeatherButton, 0, 1, 1, 1, GridBagConstraints.PAGE_END);

        SwingUtils.addComponent(contentPanel, subHeaderPanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, weatherPanel, 0, 1, 1, 1, GridBagConstraints.CENTER);
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

        if (source == getWeatherButton) {
            resultLabel.setText("Weather: " + getWeather());
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
