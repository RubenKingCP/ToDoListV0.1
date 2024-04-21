import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("ToDoList");
        frame.setSize(1000,700);
        frame.setVisible(true);
        frame.getContentPane().add(new GuiCalendar().getContainerPanel(), BorderLayout.CENTER);
        frame.getContentPane().add(new RightbarGui().getContainerPanel(), BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
