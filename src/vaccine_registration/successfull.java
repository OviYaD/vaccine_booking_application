package vaccine_registration;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class successfull {
  private JFrame frame;
  int image;

  public successfull(final String[][] inputs, final int i, final boolean flag) {
    Random rand = new Random();
    image = rand.nextInt(10000);
    Desktop desktop = Desktop.isDesktopSupported()
      ? Desktop.getDesktop()
      : null;
    GraphicsDevice device = GraphicsEnvironment
      .getLocalGraphicsEnvironment()
      .getScreenDevices()[0];
    frame = new JFrame("SUCCUSSFUL");
    frame.getContentPane().setBackground(new Color(95, 158, 160));
    frame.setBounds(100, 100, 1437, 882);
    frame.setForeground(UIManager.getColor("Button.darkShadow"));
    frame.setBackground(Color.DARK_GRAY);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    device.setFullScreenWindow(frame);
    frame.getContentPane().setLayout(null);

    Panel panel1 = new Panel();
    panel1.setBounds(377, 171, 862, 556);
    panel1.setBackground(Color.WHITE);
    frame.getContentPane().add(panel1);
    frame.setBounds(100, 100, 1437, 882);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    device.setFullScreenWindow(frame);

    JButton back = new JButton("");
    back.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {}
      }
    );
    panel1.setLayout(null);
    back.setBackground(Color.LIGHT_GRAY);
    back.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\back-arrow (1).png"));
    back.setBounds(25, 24, 48, 41);
    panel1.add(back);

    JLabel label1 = new JLabel("Appointment Successful");
    label1.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
    label1.setBounds(102, 10, 464, 73);
    panel1.add(label1);

    JLabel label = new JLabel();
    label.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\checked ().png"));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setBounds(375, -33, 111, 131);
    panel1.add(label);

    JLabel img_download = new JLabel("");
    img_download.setIcon(
      new ImageIcon("C:\\Users\\hp\\Downloads\\download (1).png")
    );
    img_download.setBounds(662, 24, 38, 32);
    panel1.add(img_download);

    JLabel download_lb = new JLabel("Download");
    download_lb.addMouseListener(
      new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            Thread.sleep(120);

            Robot r = new Robot();

            // It saves screenshot to desired path

            String path =
              "C:\\Users\\hp\\Desktop\\files\\APJ\\eclipse-workspace\\vaccine_registration\\src\\vaccine_registration\\registrations\\confirmationcard" +
              image +
              ".jpg";

            // Used to get ScreenSize and capture image

            Rectangle capture = new Rectangle(
              Toolkit.getDefaultToolkit().getScreenSize()
            );

            BufferedImage Image = r.createScreenCapture(capture);

            ImageIO.write(Image, "jpg", new File(path));

            System.out.println("Screenshot saved as " + image + ".jpg");
          } catch (AWTException | IOException | InterruptedException ex) {
            System.out.println(ex);
          }
        }
      }
    );
    download_lb.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
    download_lb.setBounds(710, 24, 142, 35);
    panel1.add(download_lb);

    JLabel confirm_lb = new JLabel("Your vaccination appointment is confirm.");
    confirm_lb.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
    confirm_lb.setBounds(36, 93, 434, 48);
    panel1.add(confirm_lb);

    JLabel info_lb = new JLabel(
      "Your appointment details have been sent on your registered mobile number through an SMS."
    );
    info_lb.setForeground(Color.GRAY);
    info_lb.setFont(new Font("Tw Cen MT", Font.PLAIN, 19));
    info_lb.setBounds(34, 137, 717, 48);
    panel1.add(info_lb);

    JLabel center_lb = new JLabel("Center");
    center_lb.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    center_lb.setBounds(36, 195, 45, 13);
    panel1.add(center_lb);

    JLabel center = new JLabel(inputs[i][7]);
    center.setFont(new Font("SimSun", Font.BOLD, 20));
    center.setBounds(34, 218, 682, 41);
    panel1.add(center);

    Panel panel = new Panel();
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setBounds(36, 281, 794, 48);
    panel1.add(panel);
    panel.setLayout(null);

    JLabel sn = new JLabel("#");
    sn.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
    sn.setBounds(10, 10, 26, 28);
    panel.add(sn);

    JLabel name = new JLabel("Name");
    name.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
    name.setBounds(62, 10, 294, 28);
    panel.add(name);

    JLabel code = new JLabel("Reference Code");
    code.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
    code.setBounds(366, 10, 151, 28);
    panel.add(code);

    JLabel id = new JLabel("Photo Id to Carry");
    id.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
    id.setBounds(527, 10, 257, 28);
    panel.add(id);

    Panel panel_1 = new Panel();
    panel_1.setBounds(36, 335, 794, 48);
    panel1.add(panel_1);
    panel_1.setLayout(null);

    JLabel sno = new JLabel("1");
    sno.setForeground(Color.GRAY);
    sno.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
    sno.setBounds(10, 10, 26, 28);
    panel_1.add(sno);

    JLabel name_value = new JLabel(inputs[i][3]);
    name_value.setForeground(Color.GRAY);
    name_value.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
    name_value.setBounds(57, 10, 294, 28);
    panel_1.add(name_value);

    JLabel code_value = new JLabel(inputs[i][8]);
    code_value.setForeground(Color.GRAY);
    code_value.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
    code_value.setBounds(363, 10, 151, 28);
    panel_1.add(code_value);

    JLabel carry_id = new JLabel(inputs[i][1]);
    carry_id.setForeground(Color.GRAY);
    carry_id.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
    carry_id.setBounds(524, 10, 257, 28);
    panel_1.add(carry_id);

    JLabel instruct = new JLabel("Instructions:");
    instruct.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
    instruct.setBounds(36, 378, 283, 32);
    panel1.add(instruct);

    JLabel instruct_1 = new JLabel(
      "1.Please carry the Photo Id card mentioned in your appointment details for vaccination."
    );
    instruct_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    instruct_1.setBounds(46, 409, 771, 24);
    panel1.add(instruct_1);

    JLabel instruct_2 = new JLabel(
      "2.If you have any comorbidities, please carry a medical certificate with you for the vaccination center."
    );
    instruct_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    instruct_2.setBounds(46, 438, 771, 24);
    panel1.add(instruct_2);

    JLabel instruct_3 = new JLabel(
      "3.For more information, please call covid Toll Free number 1075"
    );
    instruct_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
    instruct_3.setBounds(46, 464, 771, 24);
    panel1.add(instruct_3);

    JButton close = new JButton("Close");
    close.addActionListener(
      new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          frame.dispose();
          new account(inputs, i, true);
          //new welcome(inputs);
        }
      }
    );
    close.setBackground(Color.DARK_GRAY);
    close.setForeground(Color.WHITE);
    close.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
    close.setBounds(615, 498, 150, 41);
    panel1.add(close);

    JLabel img = new JLabel();
    img.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\check (2).png"));
    img.addMouseListener(
      new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            Thread.sleep(120);

            Robot r = new Robot();

            // It saves screenshot to desired path

            String path =
              "C:\\Users\\hp\\Desktop\\files\\APJ\\registrations\\confirmationcard" +
              image +
              ".jpg";

            // Used to get ScreenSize and capture image

            Rectangle capture = new Rectangle(
              Toolkit.getDefaultToolkit().getScreenSize()
            );

            BufferedImage Image = r.createScreenCapture(capture);

            ImageIO.write(Image, "jpg", new File(path));

            System.out.println("Screenshot saved as " + image + ".jpg");
          } catch (AWTException | IOException | InterruptedException ex) {
            System.out.println(ex);
          }
        }
      }
    );
    img.setHorizontalAlignment(SwingConstants.CENTER);
    img.setBounds(783, 67, 111, 131);
    frame.getContentPane().add(img);
    frame.setBackground(Color.DARK_GRAY);
    frame.setBounds(100, 100, 1437, 882);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
