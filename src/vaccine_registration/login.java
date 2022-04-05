package vaccine_registration;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URLEncoder;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class login {
  Random rand = new Random();
  JButton getotp;
  public int OTP = rand.nextInt(10000);
  public String[][] inputs = new String[4][10];
  JLabel label3;
  private JFrame frame;
  private JTextField ph_no;
  private String m_number;
  int flag = 0;

  public static void main(String[] args) {
    EventQueue.invokeLater(
      new Runnable() {

        public void run() {
          try {
            login window = new login();
            window.frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    );
  }

  login() {
    Desktop desktop = Desktop.isDesktopSupported()
      ? Desktop.getDesktop()
      : null;
    GraphicsDevice device = GraphicsEnvironment
      .getLocalGraphicsEnvironment()
      .getScreenDevices()[0];
    frame = new JFrame("Signup|Signin");
    frame.setForeground(UIManager.getColor("Button.darkShadow"));
    frame.setBackground(new Color(72, 61, 139));
    frame.getContentPane().setBackground(new Color(95, 158, 160));
    frame.setBounds(100, 100, 1437, 882);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    device.setFullScreenWindow(frame);

    Panel panel = new Panel();
    panel.setBounds(594, 171, 409, 556);
    panel.setBackground(Color.WHITE);
    frame.getContentPane().add(panel);
    panel.setLayout(null);

    JLabel label1 = new JLabel("REGISTER OR SIGN IN FOR VACCINATION");
    label1.setForeground(new Color(0, 0, 0));
    label1.setBackground(Color.WHITE);
    label1.setHorizontalAlignment(SwingConstants.CENTER);
    label1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
    label1.setBounds(0, 39, 409, 57);
    panel.add(label1);

    JLabel label2 = new JLabel(
      "An OTP will be sent to your mobile number for verification"
    );
    label2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
    label2.setBounds(10, 140, 399, 57);
    panel.add(label2);

    ph_no = new JTextField("91+");
    ph_no.addMouseListener(
      new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
          if (flag == 0) {
            ph_no.setText("");
            flag = 1;
          }
        }
      }
    );
    ph_no.addKeyListener(
      new KeyAdapter() {

        @Override
        public void keyTyped(KeyEvent e) {
          label3.setVisible(true);
          if ((ph_no.getText()).length() == 9) {
            getotp.setEnabled(true);
            label3.setVisible(false);
          }
        }
      }
    );
    ph_no.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {}
      }
    );
    ph_no.setToolTipText("ENTER YOUR MOBILE NUMBER");
    ph_no.setHorizontalAlignment(SwingConstants.LEFT);
    ph_no.setForeground(new Color(0, 0, 0));
    ph_no.setBackground(SystemColor.menu);
    ph_no.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 25));
    ph_no.setBounds(38, 232, 331, 57);
    panel.add(ph_no);
    ph_no.setColumns(10);

    getotp = new JButton("Get OTP");
    getotp.setEnabled(false);
    getotp.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          try {
            // Construct data
            String apiKey =
              "apikey=" + "Nzg3NTcxNDY0ZjRmNzkzNzMyNTM0YjZlMzg2NDc3NmU=";
            String message = "&message=" + "hello, this is oviya";
            String sender = "&sender=" + "txtlcl";
            String numbers = "&numbers=" + ph_no.getText();
            //System.out.println(numbers);
            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL(
              "https://api.textlocal.in/send/?"
            )
            .openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty(
              "Content-Length",
              Integer.toString(data.length())
            );
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(
              new InputStreamReader(conn.getInputStream())
            );
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
              //stringBuffer.append(line);
              JOptionPane.showMessageDialog(null, "Send OTP");
              System.out.println("OTP IS " + OTP);
            }
            rd.close();

            return;
          } catch (Exception e1) {
            //System.out.println("Error SMS "+e1);

            return;
          } finally {
            frame.dispose();
            m_number = ph_no.getText();
            inputs[0][0] = m_number;
            if (m_number.length() > 3) {
              m_number =
                m_number.substring(m_number.length() - 3, m_number.length());
            }
            new verification(m_number, inputs, OTP);
          }
        }
      }
    );
    getotp.setBackground(Color.BLACK);
    getotp.setForeground(Color.WHITE);
    getotp.setFont(new Font("Javanese Text", Font.BOLD, 20));
    getotp.setBounds(38, 315, 331, 46);
    panel.add(getotp);

    JButton aarogyaSetu = new JButton("");
    aarogyaSetu.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          String url = "https://www.aarogyasetu.gov.in/";
          try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
          } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }
      }
    );
    aarogyaSetu.setBackground(Color.WHITE);
    aarogyaSetu.setIcon(
      new ImageIcon("C:\\Users\\hp\\Desktop\\files\\APJ\\aarogya_setu.jpg")
    );
    aarogyaSetu.setBounds(27, 437, 160, 95);
    panel.add(aarogyaSetu);

    JLabel label4 = new JLabel(
      "-------------- OR BOOK APPOINTMENT USING ---------------"
    );
    label4.setFont(new Font("Garamond", Font.BOLD, 15));
    label4.setBounds(0, 371, 409, 41);
    panel.add(label4);

    JButton umang = new JButton("New button");
    umang.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          String url =
            "https://web.umang.gov.in/web_new/login?redirect_to=department%3Furl%3Dcowin%2F%26dept_id%3D355%26dept_name%3DCo-WIN";
          try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
          } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }
      }
    );
    umang.setIcon(
      new ImageIcon("C:\\Users\\hp\\Desktop\\files\\APJ\\UMANG-Logo.png")
    );
    umang.setBounds(218, 437, 166, 95);
    panel.add(umang);

    label3 = new JLabel("Enter 10 digits number");
    label3.setForeground(Color.RED);
    label3.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    label3.setBounds(38, 207, 211, 15);
    panel.add(label3);
    label3.setVisible(false);
    JLabel img_lab = new JLabel();
    img_lab.setBounds(762, 85, 80, 80);
    frame.getContentPane().add(img_lab);
    img_lab.setIcon(
      new ImageIcon(
        "C:\\Users\\hp\\Desktop\\files\\APJ\\eclipse-workspace\\vaccine_booking\\src\\login.png"
      )
    );

    JList list = new JList();
    list.setBackground(new Color(95, 158, 160));
    list.setBounds(116, 141, 98, -55);
    frame.getContentPane().add(list);
  }
}
