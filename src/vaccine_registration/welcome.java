package vaccine_registration;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class welcome {
  private JFrame frame;
  String[] inputs = {};

  public welcome(final String[][] inputs) {
    //System.out.println(inputs[0][0]);
    Desktop desktop = Desktop.isDesktopSupported()
      ? Desktop.getDesktop()
      : null;
    GraphicsDevice device = GraphicsEnvironment
      .getLocalGraphicsEnvironment()
      .getScreenDevices()[0];
    frame = new JFrame("WELCOME");
    frame.setTitle("Welcome | Vaccine ");
    frame.getContentPane().setBackground(new Color(95, 158, 160));
    frame.getContentPane().setLayout(null);
    frame.setBounds(0, 0, 1437, 882);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    device.setFullScreenWindow(frame);

    Panel panel = new Panel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(531, 95, 519, 701);
    frame.getContentPane().add(panel);
    panel.setLayout(null);

    JLabel wel = new JLabel("Welcome");
    wel.setForeground(new Color(0, 128, 128));
    wel.setFont(new Font("SansSerif", Font.BOLD, 24));
    wel.setHorizontalAlignment(SwingConstants.CENTER);
    wel.setBounds(115, 289, 258, 44);
    panel.add(wel);

    JLabel img = new JLabel("New label");
    img.setIcon(
      new ImageIcon("C:\\Users\\hp\\Desktop\\files\\APJ\\welcome.png")
    );
    img.setBounds(63, -17, 409, 350);
    panel.add(img);

    JLabel label1 = new JLabel(
      "You can register 4 members with one mobile number"
    );
    label1.setFont(new Font("Perpetua", Font.PLAIN, 18));
    label1.setHorizontalAlignment(SwingConstants.CENTER);
    label1.setBounds(85, 343, 357, 44);
    panel.add(label1);

    JButton register = new JButton("Register Members");
    register.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          frame.dispose();
          new register(inputs, 0, false);
        }
      }
    );
    register.setBackground(Color.BLACK);
    register.setForeground(Color.WHITE);
    register.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
    register.setBounds(95, 397, 330, 44);
    panel.add(register);

    JLabel label3_1 = new JLabel(
      "Note: One registration per person is sufficient. Please do not "
    );
    label3_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
    label3_1.setBounds(29, 486, 459, 33);
    panel.add(label3_1);

    JLabel label3_2 = new JLabel(
      "register with multiple mobile numbers or different Photo "
    );
    label3_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
    label3_2.setBounds(29, 511, 459, 33);
    panel.add(label3_2);

    JLabel label3_3 = new JLabel("ID Proofs for same individual.");
    label3_3.setFont(new Font("Segoe UI", Font.PLAIN, 17));
    label3_3.setBounds(29, 536, 459, 33);
    panel.add(label3_3);

    JLabel label3_4 = new JLabel(
      "Scheduling of Second dose should be done from the same "
    );
    label3_4.setFont(new Font("Segoe UI", Font.PLAIN, 17));
    label3_4.setBounds(29, 561, 459, 33);
    panel.add(label3_4);

    JLabel label3_5 = new JLabel(
      "account (same mobile number) from which the first dose "
    );
    label3_5.setFont(new Font("Segoe UI", Font.PLAIN, 17));
    label3_5.setBounds(29, 586, 459, 33);
    panel.add(label3_5);

    JLabel label3_6 = new JLabel(
      "has been taken, for generation of final certificate. Separate "
    );
    label3_6.setFont(new Font("Segoe UI", Font.PLAIN, 17));
    label3_6.setBounds(29, 611, 459, 33);
    panel.add(label3_6);

    JLabel label3_7 = new JLabel(
      "registration for second dose is not necessary."
    );
    label3_7.setFont(new Font("Segoe UI", Font.PLAIN, 17));
    label3_7.setBounds(29, 636, 459, 33);
    panel.add(label3_7);

    JLabel label2 = new JLabel(
      "--------------------------------------------------------------------------------------------------------------------------"
    );
    label2.setBounds(10, 463, 519, 13);
    panel.add(label2);

    JMenuBar menuBar = new JMenuBar();
    menuBar.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
    menuBar.setForeground(Color.WHITE);
    menuBar.setBackground(Color.DARK_GRAY);
    menuBar.setBounds(0, 0, 57, 22);
    frame.getContentPane().add(menuBar);

    JMenu menu = new JMenu("HOME");
    menu.setHorizontalAlignment(SwingConstants.CENTER);
    menu.setBackground(Color.DARK_GRAY);
    menu.setForeground(Color.WHITE);
    menu.setFont(new Font("Serif", Font.BOLD, 15));
    menuBar.add(menu);

    JMenuItem item1 = new JMenuItem("LOGOUT");
    item1.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          frame.dispose();
          new login();
        }
      }
    );
    item1.setHorizontalAlignment(SwingConstants.CENTER);
    item1.setFont(new Font("Serif", Font.PLAIN, 15));
    menu.add(item1);

    JMenuItem item2 = new JMenuItem("EXIT");
    item2.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      }
    );
    item2.setHorizontalAlignment(SwingConstants.CENTER);
    item2.setFont(new Font("Serif", Font.PLAIN, 15));
    menu.add(item2);
  }
}
