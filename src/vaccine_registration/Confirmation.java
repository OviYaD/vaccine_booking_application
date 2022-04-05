package vaccine_registration;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class Confirmation {

	JLabel time;
	private JFrame frame;
	JButton confirm;
	public Confirmation(final String[][] inputs,final int i)  {
		Desktop desktop=Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		GraphicsDevice device = GraphicsEnvironment .getLocalGraphicsEnvironment().getScreenDevices()[0];
	
		frame = new JFrame("CONFIRMATION");
		frame.setForeground(UIManager.getColor("Button.darkShadow"));
		frame.setBackground(Color.DARK_GRAY);
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		Panel panel1 = new Panel();
		panel1.setBounds(377, 171, 862, 556);
		panel1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel1);
		frame.setBounds(100, 100, 1437, 882);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		device.setFullScreenWindow(frame);
		
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel1.setLayout(null);
		back.setBackground(Color.LIGHT_GRAY);
		back.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\back-arrow (1).png"));
		back.setBounds(10, 29, 41, 41);
		panel1.add(back);
		
		JLabel label1 = new JLabel("Select Time Slot");
		label1.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		label1.setBounds(88, 10, 464, 73);
		panel1.add(label1);
		
		JButton _9AM11AM = new JButton("9.00AM - 11.00AM");
		_9AM11AM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputs[i][9]="9.00AM-11.00AM";
				time.setText("Time: "+inputs[i][9]);
				confirm.setEnabled(true);
			}
		});
		_9AM11AM.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		_9AM11AM.setBackground(Color.DARK_GRAY);
		_9AM11AM.setForeground(Color.WHITE);
		_9AM11AM.setBounds(56, 93, 165, 41);
		panel1.add(_9AM11AM);
		
		JButton _11AM1PM = new JButton("11.00AM - 1.00PM");
		_11AM1PM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputs[i][9]="11.00AM-1.00PM";
				time.setText("Time: "+inputs[i][9]);
				confirm.setEnabled(true);
			}
		});
		_11AM1PM.setForeground(Color.WHITE);
		_11AM1PM.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		_11AM1PM.setBackground(Color.DARK_GRAY);
		_11AM1PM.setBounds(242, 93, 165, 41);
		panel1.add(_11AM1PM);
		
		JButton _1PM3PM = new JButton("1.00PM - 3.00PM");
		_1PM3PM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputs[i][9]="1.00PM-3.00PM";
				time.setText("Time: "+inputs[i][9]);
				confirm.setEnabled(true);
			}
		});
		_1PM3PM.setForeground(Color.WHITE);
		_1PM3PM.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		_1PM3PM.setBackground(Color.DARK_GRAY);
		_1PM3PM.setBounds(427, 93, 165, 41);
		panel1.add(_1PM3PM);
		
		JButton _3PM6PM = new JButton("3.00PM - 6.00PM");
		_3PM6PM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputs[i][9]="3.00PM-6.00PM";
				time.setText("Time: "+inputs[i][9]);
				confirm.setEnabled(true);
			}
		});
		_3PM6PM.setForeground(Color.WHITE);
		_3PM6PM.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		_3PM6PM.setBackground(Color.DARK_GRAY);
		_3PM6PM.setBounds(616, 93, 165, 41);
		panel1.add(_3PM6PM);
		
		JLabel label2 = new JLabel("Appointment Confirmation");
		label2.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		label2.setBounds(27, 182, 464, 73);
		panel1.add(label2);
		
		JLabel center = new JLabel(inputs[i][7]);
		center.setFont(new Font("SimSun", Font.PLAIN, 25));
		center.setBounds(25, 256, 507, 55);
		panel1.add(center);
		
		JLabel vacc = new JLabel("Vaccine Name: "+inputs[i][5]);
		vacc.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		vacc.setBounds(27, 321, 215, 31);
		panel1.add(vacc);
		
		JLabel cost = new JLabel("Vaccine Cost: nil");
		cost.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		cost.setBounds(279, 320, 187, 31);
		panel1.add(cost);
		
		JLabel date = new JLabel("Date: "+inputs[i][6]);
		date.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		date.setBounds(456, 320, 187, 31);
		panel1.add(date);
		
		time = new JLabel("Time: ");
		time.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		time.setBounds(637, 321, 215, 31);
		panel1.add(time);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(27, 369, 800, 104);
		panel1.add(panel);
		panel.setLayout(null);
		
		JLabel name = new JLabel(inputs[i][3]);
		name.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		name.setBounds(10, 10, 414, 38);
		panel.add(name);
		
		JLabel code = new JLabel("Reference code: "+inputs[i][8]);
		code.setForeground(Color.GRAY);
		code.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		code.setBounds(10, 58, 346, 28);
		panel.add(code);
		
		confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new successfull(inputs,i,false);
			}
		});
		confirm.setEnabled(false);
		confirm.setBackground(Color.BLACK);
		confirm.setForeground(Color.WHITE);
		confirm.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		confirm.setBounds(616, 485, 177, 41);
		panel1.add(confirm);
		
		
	}
}
