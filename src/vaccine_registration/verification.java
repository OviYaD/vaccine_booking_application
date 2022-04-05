package vaccine_registration;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class verification {
  JLabel error_msg;
  JButton verify_and_proceed;
  JButton resend;
  Random rand = new Random();
  private JFrame frame;
  private JTextField otp_tf;
  int otp = 0;
  String[] inputs = null;

  public verification(String num, final String[][] inputs, int OTP) {
    otp = OTP;
    //System.out.println(inputs[0][0]);
    num = "xxxxxxxxxx" + num;
    Desktop desktop = Desktop.isDesktopSupported()
      ? Desktop.getDesktop()
      : null;
    GraphicsDevice device = GraphicsEnvironment
      .getLocalGraphicsEnvironment()
      .getScreenDevices()[0];
    frame = new JFrame("OTP");
    frame.getContentPane().setBackground(new Color(95, 158, 160));
    frame.getContentPane().setLayout(null);
    frame.setBounds(0, 0, 1437, 882);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    device.setFullScreenWindow(frame);

    Panel panel = new Panel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(594, 217, 409, 410);
    frame.getContentPane().add(panel);
    panel.setLayout(null);

    JLabel label1 = new JLabel("OTP Verification");
    label1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
    label1.setHorizontalAlignment(SwingConstants.CENTER);
    label1.setBounds(31, 63, 354, 52);
    panel.add(label1);

    JLabel label2 = new JLabel("An OTP has been sent to");
    label2.setHorizontalAlignment(SwingConstants.CENTER);
    label2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
    label2.setBounds(55, 137, 296, 38);
    panel.add(label2);

    resend = new JButton("Resend");
    resend.setBackground(Color.BLACK);
    resend.setForeground(Color.WHITE);
    resend.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
    resend.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          otp = rand.nextInt(10000);
          System.out.println(otp);
          resend.setVisible(false);
          error_msg.setVisible(false);
          verify_and_proceed.setEnabled(true);
        }
      }
    );
    resend.setBounds(107, 291, 194, 45);
    resend.setVisible(false);
    panel.add(resend);

    error_msg = new JLabel("Invalid verify again");
    error_msg.setForeground(Color.RED);
    error_msg.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    error_msg.setBounds(63, 268, 164, 20);
    error_msg.setVisible(false);
    panel.add(error_msg);

    otp_tf = new JTextField();
    otp_tf.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
    otp_tf.setBounds(68, 217, 283, 52);
    panel.add(otp_tf);
    otp_tf.setColumns(10);

    verify_and_proceed = new JButton("Verify & Proceed");
    verify_and_proceed.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          if (otp == Integer.parseInt(otp_tf.getText())) {
            frame.dispose();
            new welcome(inputs);
          } else {
            otp = 0;
            resend.setVisible(true);
            error_msg.setVisible(true);
            verify_and_proceed.setEnabled(false);
          }
        }
      }
    );
    verify_and_proceed.setForeground(Color.WHITE);
    verify_and_proceed.setBackground(Color.BLACK);
    verify_and_proceed.setFont(new Font("Javanese Text", Font.BOLD, 20));
    verify_and_proceed.setBounds(0, 346, 409, 64);
    panel.add(verify_and_proceed);

    JLabel label3 = new JLabel(num);
    label3.setHorizontalAlignment(SwingConstants.CENTER);
    label3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
    label3.setBounds(55, 169, 296, 38);
    label3.setVisible(true);
    panel.add(label3);

    JLabel img_lab = new JLabel();
    img_lab.setIcon(
      new ImageIcon(
        "C:\\Users\\hp\\Desktop\\files\\APJ\\eclipse-workspace\\vaccine_booking\\src\\login.png"
      )
    );
    img_lab.setBounds(763, 131, 80, 80);
    frame.getContentPane().add(img_lab);
    frame.setVisible(true);
  }
}
