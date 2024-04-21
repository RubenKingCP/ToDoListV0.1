import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RightbarGui {
    private JPanel sidebarPanel;
    private JPanel topSidebarPanel;
    private JPanel bottomSidebarPanel;
    private JLabel monthDayLabel;
    private JLabel dayLabel;

    public RightbarGui(){
        // Create sidebar panel
        sidebarPanel = new JPanel(new BorderLayout());
        sidebarPanel.setPreferredSize(new Dimension(200, 0));

        // Create top part of sidebar
        topSidebarPanel = new JPanel(new GridLayout(2, 1));
        
        //CUstomize monthDayLabel
        monthDayLabel = new JLabel();
        monthDayLabel.setFont(new Font("Arial", Font.BOLD, 20));
        monthDayLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //CUstomize dayLabel
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dayLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //Add them to top part
        topSidebarPanel.add(monthDayLabel);
        topSidebarPanel.add(dayLabel);
        topSidebarPanel.setBackground(Color.YELLOW);

        //Add padding
        topSidebarPanel.setBorder(new EmptyBorder(40, 10, 40, 30));
        sidebarPanel.add(topSidebarPanel, BorderLayout.NORTH);

        // Create bottom part of sidebar
        bottomSidebarPanel = new JPanel();
        bottomSidebarPanel.setPreferredSize(new Dimension(200, 0));
        bottomSidebarPanel.setBackground(Color.red);
        sidebarPanel.add(bottomSidebarPanel, BorderLayout.CENTER);

        //Get Local Date
        LocalDate currenDate = LocalDate.now();
        
        //Set the dayMonthLabel
        String monthString = currenDate.getMonth().toString();
        monthString = monthString.substring(0, 1).toUpperCase() + monthString.substring(1).toLowerCase();
        monthDayLabel.setText(currenDate.getDayOfMonth() + " " + monthString);

        //Set the Day Label
        String dayString = currenDate.getDayOfWeek().toString();
        dayString = dayString.substring(0,1).toUpperCase() + dayString.substring(1).toLowerCase();
        dayLabel.setText(dayString);
    }


    public JPanel getContainerPanel(){
        return sidebarPanel;
    }
}
