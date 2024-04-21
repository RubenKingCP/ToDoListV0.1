import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


public class GuiCalendar {
    private JPanel calendarContainer;
    private JLabel monthLabel;
    private JPanel calendarPanel;
    private int currentMonth;
    private int currentYear;

    public GuiCalendar() {
        // Get current month and year
        Calendar calendar = Calendar.getInstance();
        currentMonth = calendar.get(Calendar.MONTH);
        currentYear = calendar.get(Calendar.YEAR);

        // Create main panel
        calendarContainer = new JPanel();
        calendarContainer.setLayout(new BorderLayout());

        // Create month label
        monthLabel = new JLabel();
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateMonthLabel();
        calendarContainer.add(monthLabel, BorderLayout.NORTH);

        // Create calendar panel
        calendarPanel = new JPanel(new GridLayout(0, 7));
        updateCalendar();
        calendarContainer.add(calendarPanel, BorderLayout.CENTER);

        // Create buttons panel
        JPanel buttonsPanel = new JPanel();
        JButton prevButton = new JButton("Prev");
        JButton nextButton = new JButton("Next");
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMonth--;
                if (currentMonth < 0) {
                    currentMonth = 11;
                    currentYear--;
                }
                updateCalendar();
            }
        });
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMonth++;
                if (currentMonth > 11) {
                    currentMonth = 0;
                    currentYear++;
                }
                updateCalendar();
            }
        });
        buttonsPanel.add(prevButton);
        buttonsPanel.add(nextButton);
        calendarContainer.add(buttonsPanel, BorderLayout.SOUTH);

    }

    private void updateMonthLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.set(currentYear, currentMonth, 1);
        monthLabel.setText(sdf.format(calendar.getTime()));
    }

    private void updateCalendar() {
        calendarPanel.removeAll();

        Calendar calendar = Calendar.getInstance();
        calendar.set(currentYear, currentMonth, 1);

        // Add day labels
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        for (int i = 0; i < 7; i++) {
            calendarPanel.add(new JLabel(sdf.format(calendar.getTime())));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        // Fill in days
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        for (int i = 1; i < startDayOfWeek; i++) {
            calendarPanel.add(new JLabel(""));
        }
        while (calendar.get(Calendar.MONTH) == currentMonth) {
            JLabel dayLabel = new JLabel(Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)));
            calendarPanel.add(dayLabel);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
        updateMonthLabel();
    }

    public JPanel getContainerPanel(){
        return calendarContainer;
    }
}
