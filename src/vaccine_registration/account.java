package vaccine_registration;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class account {
  JFrame f;
  private JFrame frame;
  Panel panel_1;
  Panel panel;
  JButton schedule1;
  JLabel lblNewLabel_8_1;
  private JLabel label1;
  private JLabel label2;
  private JLabel phno;
  private JLabel yob;
  private JLabel photoid;
  private JLabel id_no;
  private JLabel label3;
  private JLabel doseno;
  private JLabel app;
  private JPanel panel2_1;
  private JLabel lblNewLabel_9;
  private JLabel yob1;
  private JLabel photoid1;
  private JLabel label4;
  private JLabel lblNewLabel_13;
  private JLabel doseno1;
  private JLabel app1;
  private JButton schedule2;
  JLabel slot_1;
  JLabel slot_2;
  JButton add;
  private JLabel home;

  public account(final String[][] inputs, final int i, final boolean flag) {
    Desktop desktop = Desktop.isDesktopSupported()
      ? Desktop.getDesktop()
      : null;
    GraphicsDevice device = GraphicsEnvironment
      .getLocalGraphicsEnvironment()
      .getScreenDevices()[0];
    frame = new JFrame("ACCOUNTS");
    frame.getContentPane().setBackground(new Color(95, 158, 160));
    frame.getContentPane().setLayout(null);
    frame.setBounds(0, 0, 1437, 882);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    device.setFullScreenWindow(frame);

    panel_1 = new Panel();
    panel_1.setBackground(Color.WHITE);
    panel_1.setBounds(250, 184, 1095, 378);
    frame.getContentPane().add(panel_1);
    panel_1.setLayout(null);

    JPanel panel2 = new JPanel();
    panel2.setBounds(22, 117, 1047, 181);
    panel_1.add(panel2);
    panel2.setBackground(Color.WHITE);
    TitledBorder border = new TitledBorder(
      new EtchedBorder(EtchedBorder.LOWERED),
      "Not Vaccinated",
      TitledBorder.LEADING,
      TitledBorder.TOP,
      null,
      new Color(0, 0, 128)
    );
    border.setTitleFont(new Font("Tw Cen MT", Font.BOLD, 20));
    panel2.setBorder(border);
    panel2.setLayout(null);

    phno = new JLabel(inputs[0][3]);
    phno.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
    phno.setBounds(20, 24, 499, 36);
    panel2.add(phno);

    yob = new JLabel("Year of Birth: " + inputs[0][4]);
    yob.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    yob.setBounds(20, 72, 124, 29);
    panel2.add(yob);

    photoid = new JLabel("Photo ID : " + inputs[0][1]);
    photoid.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    photoid.setBounds(370, 72, 211, 29);
    panel2.add(photoid);

    String m_number = inputs[0][2];
    if (m_number.length() > 4) {
      m_number = m_number.substring(m_number.length() - 4, m_number.length());
    }

    id_no = new JLabel("ID Number: xxxx-" + m_number);
    id_no.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    id_no.setBounds(768, 72, 189, 29);
    panel2.add(id_no);

    label3 =
      new JLabel(
        "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
      );
    label3.setForeground(Color.LIGHT_GRAY);
    label3.setBounds(10, 98, 1027, 13);
    panel2.add(label3);

    doseno = new JLabel("Dose 1");
    doseno.setForeground(new Color(255, 0, 0));
    doseno.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    doseno.setBounds(20, 111, 137, 23);
    panel2.add(doseno);

    schedule1 = new JButton("Schedule");
    schedule1.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          String nm = schedule1.getText();
          popup pop = new popup();
          String temp = pop.popup(nm);
          if (temp == "Yes") {
            frame.dispose();
            new schedule(inputs, 0);
          }
        }
      }
    );

    schedule1.setBackground(Color.BLACK);
    schedule1.setForeground(Color.WHITE);
    schedule1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
    schedule1.setBounds(752, 131, 205, 36);
    panel2.add(schedule1);

    app = new JLabel("Appointment Not Scheduled");
    app.setForeground(new Color(255, 0, 0));
    app.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    app.setBounds(30, 144, 513, 23);
    panel2.add(app);

    slot_1 = new JLabel();
    slot_1.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
    slot_1.setBounds(732, 24, 268, 36);
    slot_1.setVisible(false);
    panel2.add(slot_1);

    label1 = new JLabel("Account Details");
    label1.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
    label1.setBounds(28, 21, 206, 50);
    panel_1.add(label1);

    m_number = inputs[0][0];
    if (m_number.length() > 3) {
      m_number = m_number.substring(m_number.length() - 3, m_number.length());
    }

    label2 = new JLabel("Registered Mobile Number: xxxx-xxxx-" + m_number);
    label2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
    label2.setBounds(22, 66, 372, 41);
    panel_1.add(label2);

    add = new JButton("+ Add Members");
    add.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          frame.dispose();
          new register(inputs, 1, flag);
        }
      }
    );
    add.setBounds(386, 330, 273, 36);
    panel_1.add(add);
    add.setForeground(Color.WHITE);
    add.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
    add.setBackground(Color.BLACK);

    panel2_1 = new JPanel();
    panel2_1.setLayout(null);
    panel2_1.setBackground(Color.WHITE);
    TitledBorder border1 = new TitledBorder(
      new EtchedBorder(EtchedBorder.LOWERED),
      "Not Vaccinated",
      TitledBorder.LEADING,
      TitledBorder.TOP,
      null,
      new Color(0, 0, 128)
    );
    border1.setTitleFont(new Font("Tw Cen MT", Font.BOLD, 20));
    panel2_1.setBorder(border1);
    panel2_1.setBounds(22, 308, 1047, 181);
    panel2_1.setVisible(false);
    panel_1.add(panel2_1);

    lblNewLabel_9 = new JLabel();
    lblNewLabel_9.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
    lblNewLabel_9.setBounds(20, 24, 499, 36);
    panel2_1.add(lblNewLabel_9);

    yob1 = new JLabel("Year of Birth: ");
    yob1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    yob1.setBounds(20, 72, 124, 29);
    panel2_1.add(yob1);

    photoid1 = new JLabel("Photo ID : ");
    photoid1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    photoid1.setBounds(370, 72, 211, 29);
    panel2_1.add(photoid1);

    label4 = new JLabel("ID Number: xxxx-");
    label4.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    label4.setBounds(768, 72, 189, 29);
    panel2_1.add(label4);

    lblNewLabel_13 =
      new JLabel(
        "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
      );
    lblNewLabel_13.setForeground(Color.LIGHT_GRAY);
    lblNewLabel_13.setBounds(10, 98, 1027, 13);
    panel2_1.add(lblNewLabel_13);

    doseno1 = new JLabel("Dose 1");
    doseno1.setForeground(Color.RED);
    doseno1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    doseno1.setBounds(20, 111, 137, 23);
    panel2_1.add(doseno1);

    app1 = new JLabel("Appointment Not Scheduled");
    app1.setForeground(Color.RED);
    app1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    app1.setBounds(30, 144, 513, 23);
    panel2_1.add(app1);

    schedule2 = new JButton("Schedule");
    schedule2.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          String nm = schedule2.getText();
          popup pop = new popup();
          String temp = pop.popup(nm);
          if (temp == "Yes") {
            frame.dispose();
            new schedule(inputs, 1);
          }
        }
      }
    );

    schedule2.setForeground(Color.WHITE);
    schedule2.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
    schedule2.setBackground(Color.BLACK);
    schedule2.setBounds(752, 131, 205, 36);
    panel2_1.add(schedule2);

    slot_2 = new JLabel();
    slot_2.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
    slot_2.setBounds(731, 24, 268, 36);
    panel2_1.add(slot_2);

    home = new JLabel("");
    home.addMouseListener(
      new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
          frame.dispose();
          new welcome(inputs);
        }
      }
    );
    home.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\files\\APJ\\home.png"));
    home.setBounds(1034, 10, 85, 61);
    panel_1.add(home);
    panel_1.setVisible(false);

    if (i == 1 && flag == false) {
      panel2_1.setVisible(true);
      add.setBounds(377, 521, 273, 36);
      panel_1.setBounds(253, 136, 1095, 586);
      lblNewLabel_9.setText(inputs[1][3]);
      yob1.setText("Year of Birth: " + inputs[1][4]);
      photoid1.setText("Photo ID : " + inputs[1][1]);
      m_number = inputs[1][2];
      if (m_number.length() > 4) {
        m_number = m_number.substring(m_number.length() - 4, m_number.length());
      }
      label4.setText("ID Number: xxxx-" + m_number);
    } else if (i == 1 && flag == true) {
      panel2_1.setVisible(true);
      add.setBounds(377, 521, 273, 36);
      panel_1.setBounds(253, 136, 1095, 586);
      lblNewLabel_9.setText(inputs[1][3]);
      yob1.setText("Year of Birth: " + inputs[1][4]);
      photoid1.setText("Photo ID : " + inputs[1][1]);
      m_number = inputs[1][2];
      if (m_number.length() > 4) {
        m_number = m_number.substring(m_number.length() - 4, m_number.length());
      }
      label4.setText("ID Number: xxxx-" + m_number);
      app1.setText("Appointment is scheduled");
      app1.setForeground(Color.BLUE);
      doseno1.setForeground(Color.BLUE);
      schedule2.setText("RESCHEDULE");
      slot_2.setVisible(true);
      slot_2.setText("Slot:" + inputs[i][9]);
    } else if (i == 0 && flag == true) {
      try {
        slot_1.setVisible(true);
        slot_1.setText("Slot:" + inputs[0][9]);

        if (!(inputs[1][0] == null)) {
          panel2_1.setVisible(true);
          add.setBounds(377, 521, 273, 36);
          panel_1.setBounds(253, 136, 1095, 586);
          lblNewLabel_9.setText(inputs[1][3]);
          yob1.setText("Year of Birth: " + inputs[1][4]);
          photoid1.setText("Photo ID : " + inputs[1][1]);
          m_number = inputs[1][2];
          if (m_number.length() > 4) {
            m_number =
              m_number.substring(m_number.length() - 4, m_number.length());
          }
          label4.setText("ID Number: xxxx-" + m_number);
        }
      } catch (Exception e) {
        slot_1.setText("Slot:" + inputs[0][9]);
      } finally {
        app.setText("Appointment is scheduled");
        app.setForeground(Color.BLUE);
        doseno.setForeground(Color.BLUE);
        schedule1.setText("RESCHEDULE");
      }
    }

    panel = new Panel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(594, 217, 409, 410);
    frame.getContentPane().add(panel);
    panel.setVisible(true);

    panel.setLayout(null);

    JLabel lblNewLabel = new JLabel("REGISTERED SUCCESSFULLY");
    lblNewLabel.setForeground(new Color(154, 205, 50));
    lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(33, 177, 352, 53);
    panel.add(lblNewLabel);

    JButton btnNewButton = new JButton("NEXT");
    btnNewButton.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          panel.setVisible(false);
          panel_1.setVisible(true);
        }
      }
    );
    btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
    btnNewButton.setForeground(Color.WHITE);
    btnNewButton.setBackground(Color.BLACK);
    btnNewButton.setBounds(70, 270, 276, 53);
    panel.add(btnNewButton);

    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setIcon(
      new ImageIcon("C:\\Users\\hp\\Desktop\\files\\APJ\\success.jpg")
    );
    lblNewLabel_1.setBounds(70, 30, 299, 146);
    panel.add(lblNewLabel_1);
  }
}
