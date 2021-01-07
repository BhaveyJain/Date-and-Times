package gui;

import assets.Constants;
import assets.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;

/**
 * Date and Times
 * DayOfWeekFinderFrame.java
 *
 * Frame for finding what day of week a given day, month, and year is.
 *
 * @author Henrik Berg
 * @version December 21, 2020
 */
public final class DayOfWeekFinderFrame extends JFrame implements ActionListener {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel subHeaderPanel;
    private final JPanel finderPanel;
    private final JPanel resultPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel subHeaderLabel;
    private final JLabel monthLabel;
    private final JLabel dayLabel;
    private final JLabel yearLabel;
    private final JLabel dayOfWeekLabel;
    private final JLabel answerLabel;

    private final JComboBox<String> monthComboBox;
    private final JComboBox<String> dayComboBox;
    private final JComboBox<String> yearComboBox;

    private final JButton findDayOfWeekButton;
    private final JButton backButton;

    /**
     * Constructor that creates the day of week finder frame.
     */
    public DayOfWeekFinderFrame() {
        super("Date and Times | Day of Week Finder");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());
        subHeaderPanel = new JPanel(new GridBagLayout());
        finderPanel = new JPanel(new GridBagLayout());
        resultPanel = new JPanel(new GridBagLayout());
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel(" Date and Times");
        subHeaderLabel = new JLabel("Day of Week Finder");
        monthLabel = new JLabel("Month:");
        dayLabel = new JLabel("Day:");
        yearLabel = new JLabel("Year:");
        dayOfWeekLabel = new JLabel("Day of Week:");

        monthComboBox = new JComboBox<>(populateComboBox(1, 12));
        dayComboBox = new JComboBox<>(populateComboBox(1, 31));
        yearComboBox = new JComboBox<>(populateComboBox(2015, 2030));

        findDayOfWeekButton = new JButton("Find Day of Week");
        answerLabel = new JLabel();
        backButton = new JButton("Back");

        this.setSize(450, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        findDayOfWeekButton.addActionListener(this);
        backButton.addActionListener(this);

        headerLabel.setFont(Constants.HEADER_FONT);
        subHeaderLabel.setFont(Constants.SUB_HEADER_FONT);

        dayOfWeekLabel.setFont(Constants.SUB_SUB_HEADER_FONT);

        monthLabel.setFont(Constants.MAIN_FONT);
        dayLabel.setFont(Constants.MAIN_FONT);
        yearLabel.setFont(Constants.MAIN_FONT);
        findDayOfWeekButton.setFont(Constants.MAIN_FONT);
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

        SwingUtils.addComponent(finderPanel, monthLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(finderPanel, monthComboBox, 1, 0, 1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(finderPanel, dayLabel, 0, 1, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(finderPanel, dayComboBox, 1, 1, 1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(finderPanel, yearLabel, 0, 2, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(finderPanel, yearComboBox, 1, 2, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(resultPanel, dayOfWeekLabel, 0, 0, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(resultPanel, findDayOfWeekButton, 0, 1, 1, 1, GridBagConstraints.PAGE_END);
        SwingUtils.addComponent(resultPanel, answerLabel, 0, 3, 1, 1, GridBagConstraints.PAGE_END);

        SwingUtils.addComponent(contentPanel, subHeaderPanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, finderPanel, 0, 1, 1, 1, GridBagConstraints.CENTER);
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

        if (source == findDayOfWeekButton) {
            // TODO: Add implementation here
            findDayOfWeek();
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

    /**
     * Method used to populate JComboBox with numbers, filling it from the start to end, inclusive.
     *
     * @param start the start number
     * @param end the end number
     */
    public String[] populateComboBox(int start, int end) {
        String[] list = new String[end - start + 1];

        for (int i = start; i <= end; i++) {
            list[i - start] = Integer.toString(i);
        }

        return list;
    }

    /**
     * This method is to be used to find the day of the week that a date falls on
     *
     */
    public void findDayOfWeek() {
        LocalDate date = LocalDate.of(yearComboBox.getSelectedIndex() + 2015, // Year is hard coded, changes with setting
                monthComboBox.getSelectedIndex() + 1,
                dayComboBox.getSelectedIndex() + 1);
        answerLabel.setText(date.getDayOfWeek().toString());

    }

}
