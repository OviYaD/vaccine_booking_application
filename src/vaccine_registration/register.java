package vaccine_registration;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class register {

	private JFrame frame;
	JButton ok;
	private JTextField tf_idno;
	private JTextField tf_name;
	private JTextField tf_yob;
	int age=0,i=0,flag=0;
	String alt="";
	JLabel warning;
	JButton register;
	String temp;
	JButton conti;
	JButton return_home;
	public register(final String[][] inputs,int row,final boolean flg) {
		i=row;
		//System.out.println(inputs[0][0]);
		Desktop desktop=Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		GraphicsDevice device = GraphicsEnvironment .getLocalGraphicsEnvironment().getScreenDevices()[0];
		frame = new JFrame("REGISTERATION");
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		frame.setBounds(0, 0, 1437, 882);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		device.setFullScreenWindow(frame);
		
		Panel panel = new Panel();
		panel.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		panel.setBackground(Color.WHITE);
		panel.setBounds(506, 141, 590, 657);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Register for Vaccination");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tw Cen MT", Font.BOLD, 33));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(111, 25, 408, 58);
		panel.add(label);
		
		JButton back = new JButton("");
		back.setBackground(Color.WHITE);
		back.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\back-arrow (1).png"));
		back.setBounds(26, 30, 39, 32);
		panel.add(back);
		
		JLabel label1 = new JLabel("Your Photo ID will be verified at the time of your vaccination appointment.  Please ");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label1.setBounds(26, 86, 554, 39);
		panel.add(label1);
		
		JLabel label1_1 = new JLabel("provide the details of the Photo ID you will carry for vaccination.");
		label1_1.setHorizontalAlignment(SwingConstants.CENTER);
		label1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label1_1.setBounds(36, 108, 529, 39);
		panel.add(label1_1);
		
		String s[]= {"~select one","Aadhaar Card","Driving License","PAN Card","Passport","Pension Card","NPR Smart Card","Voter ID","Ration Card with Photo"};
		final JComboBox comboBox_id = new JComboBox(s);
		comboBox_id.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_id.getSelectedIndex()!=-1)
				{
					flag+=1;
				}
			}
		});
		comboBox_id.setFont(new Font("SimSun", Font.BOLD, 20));
		comboBox_id.setBackground(Color.WHITE);
		comboBox_id.setBounds(29, 197, 529, 39);
		panel.add(comboBox_id);
		
		JLabel label_id = new JLabel("Photo ID Proof");
		label_id.setForeground(Color.BLACK);
		label_id.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
		label_id.setBounds(29, 167, 179, 32);
		panel.add(label_id);
		
		JLabel label_idno = new JLabel("Photo ID Number");
		label_idno.setForeground(Color.BLACK);
		label_idno.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
		label_idno.setBounds(29, 260, 179, 32);
		panel.add(label_idno);
		
		tf_idno = new JTextField();
		tf_idno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if((tf_idno.getText()).length()>=10)
				{
					flag+=1;
				}
			}
		});
		tf_idno.setFont(new Font("SimSun", Font.BOLD, 20));
		tf_idno.setToolTipText("Your Photo ID Number");
		tf_idno.setBounds(29, 289, 529, 39);
		panel.add(tf_idno);
		tf_idno.setColumns(10);
		
		JLabel label_name = new JLabel("Name");
		label_name.setForeground(Color.BLACK);
		label_name.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
		label_name.setBounds(29, 345, 179, 32);
		panel.add(label_name);
		
		tf_name = new JTextField();
		tf_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if((tf_name.getText()).length()>=3)
				{
					flag+=1;
				}
			}
		});
		tf_name.setToolTipText("Enter your name");
		tf_name.setBackground(new Color(255, 255, 255));
		tf_name.setFont(new Font("SimSun", Font.BOLD, 20));
		tf_name.setColumns(10);
		tf_name.setBounds(29, 374, 529, 39);
		panel.add(tf_name);
		
		JRadioButton rb1_m = new JRadioButton("Male");
		rb1_m.setBackground(Color.WHITE);
		rb1_m.setHorizontalAlignment(SwingConstants.CENTER);
		rb1_m.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		rb1_m.setBounds(49, 457, 103, 32);
		panel.add(rb1_m);
		
		ButtonGroup btn=new ButtonGroup();
		
		JRadioButton rb2_f = new JRadioButton("Female");
		rb2_f.setHorizontalAlignment(SwingConstants.CENTER);
		rb2_f.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		rb2_f.setBackground(Color.WHITE);
		rb2_f.setBounds(172, 457, 103, 32);
		panel.add(rb2_f);
		
		JRadioButton rb3_o = new JRadioButton("Others");
		rb3_o.setHorizontalAlignment(SwingConstants.CENTER);
		rb3_o.setFont(new Font("Tw Cen MT", Font.PLAIN, 23));
		rb3_o.setBackground(Color.WHITE);
		rb3_o.setBounds(302, 457, 103, 32);
		panel.add(rb3_o);
		
		JLabel label_gender = new JLabel("Gender");
		label_gender.setForeground(Color.BLACK);
		label_gender.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
		label_gender.setBounds(29, 426, 179, 32);
		panel.add(label_gender);
		
		btn.add(rb1_m);
		btn.add(rb2_f);
		btn.add(rb3_o);
		
		JLabel label_yob = new JLabel("Year of Birth ( in YYYY Format )");
		label_yob.setForeground(Color.BLACK);
		label_yob.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
		label_yob.setBounds(29, 495, 314, 32);
		panel.add(label_yob);
		
		warning = new JLabel("Registration is open only for individuals with age 18 years or older");
		warning.setForeground(Color.RED);
		warning.setHorizontalAlignment(SwingConstants.CENTER);
		warning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		warning.setBounds(26, 625, 532, 22);
		warning.setVisible(false);
		panel.add(warning);
		
		tf_yob = new JTextField();
		tf_yob.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(tf_yob.getText().length()==4)
				{
					flag+=1;
				}
				if((comboBox_id.getSelectedIndex()!=-1) &&  ((tf_name.getText()).length()>=3) &&  ( (tf_yob.getText().length()==4)))
				{

					register.setEnabled(true);
				}
			}
		});
		tf_yob.setToolTipText("");
		tf_yob.setFont(new Font("SimSun", Font.BOLD, 20));
		tf_yob.setColumns(10);
		tf_yob.setBounds(29, 525, 529, 39);
		panel.add(tf_yob);
		
		register = new JButton("Register");
		register.setBackground(Color.BLACK);
		register.setForeground(Color.WHITE);
		register.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 temp=tf_yob.getText();
				int tem=Integer.parseInt(temp);
				age=2021-tem;
				
				if(age<18)
				{
					warning.setVisible(true);
					inputs[i][1]= "";
					ok.setVisible(true);
					register.setVisible(false);
				}
				else
				{   
					inputs[i][1]= comboBox_id.getSelectedItem().toString();
					//System.out.println(inputs[0][1]);
					//System.out.println(inputs);
					inputs[i][2]=tf_idno.getText();
					inputs[i][3]=tf_name.getText();
					inputs[i][4]=tf_yob.getText();
					frame.dispose();
					new account(inputs,i,flg);
					return;
				}
				
			}
		});
		register.setBounds(126, 574, 319, 41);
		panel.add(register);
		register.setEnabled(false);
		
		return_home = new JButton("Return Home");
		return_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new welcome(inputs);
			}
		});
		return_home.setForeground(Color.WHITE);
		return_home.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		return_home.setBackground(Color.BLACK);
		return_home.setBounds(26, 574, 260, 41);
		return_home.setVisible(false);
		panel.add(return_home);
		
		ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(false);
				return_home.setVisible(true);
				conti.setVisible(true);
			}
		});
		ok.setForeground(Color.WHITE);
		ok.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		ok.setBackground(Color.BLACK);
		ok.setBounds(126, 574, 319, 41);
		panel.add(ok);
		
		conti = new JButton("Continue");
		conti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_yob.setText("");
				conti.setVisible(false);
				return_home.setVisible(false);
				warning.setVisible(false);
				register.setVisible(true);
				
			}
		});
		conti.setBackground(Color.BLACK);
		conti.setForeground(Color.WHITE);
		conti.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		conti.setBounds(316, 574, 242, 41);
		conti.setVisible(false);
		panel.add(conti);
		
	}
}
