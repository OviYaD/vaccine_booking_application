package vaccine_registration;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import java.awt.Panel;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class schedule {
	private JFrame frame;
	private JTextField txtEnterThePincode;
	JFormattedTextField formattedTextField=null;
	private JTable table;
	private JTable table_1;
	Panel panel_1;
	String temp="";
	JComboBox<String> districts;
	JLabel error;
	JButton search;
	JButton search1;
	public schedule(final String[][] inputs,final int i) {
		Desktop desktop=Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		GraphicsDevice device = GraphicsEnvironment .getLocalGraphicsEnvironment().getScreenDevices()[0];
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 1437, 882);
		frame.setForeground(UIManager.getColor("Button.darkShadow"));
		frame.setBackground(Color.DARK_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		device.setFullScreenWindow(frame);
		frame.getContentPane().setLayout(null);
		
		final Panel panel = new Panel();
		panel.setBounds(260, 128, 1014, 622);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		back.setBackground(Color.LIGHT_GRAY);
		back.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\back-arrow (1).png"));
		back.setBounds(26, 30, 32, 32);
		panel.add(back);
		
		JLabel label = new JLabel("Book Appointment for Vaccination");
		label.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		label.setBounds(88, 10, 464, 73);
		panel.add(label);		
		
		String s[]= {"States","Tamil Nadu","Maharastra","Andhra Pradesh","Kerala","Karnataka"};
		final JComboBox states = new JComboBox(s);
		states.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if((states.getSelectedItem().toString())=="Tamil Nadu")
				{
					districts.removeAllItems();
					districts.addItem("Erode");
					districts.addItem("Madurai");
					districts.addItem("Coimbatore");
					districts.addItem("Chennai");
					districts.addItem("Theni");
					//String s1[]= {"District","Erode","Madurai","Coimbatore","Chennai","Theni"};
					
				}
				else if((states.getSelectedItem().toString())=="Maharastra")
				{
					districts.removeAllItems();
					districts.addItem("Ahmednagar");
					districts.addItem("Akola");
					districts.addItem("Amravati");
					districts.addItem("Aurangabad");
					districts.addItem("Beed");
				}
				else if((states.getSelectedItem().toString())=="Andhra Pradesh")
				{
					districts.removeAllItems();
					districts.addItem("Anantapur");
					districts.addItem("chitoor");
					districts.addItem("Gundur");
					districts.addItem("kadapa");
					districts.addItem("kurnool");
				}
				else if((states.getSelectedItem().toString())=="Kerala")
				{
					districts.removeAllItems();
					districts.addItem("Thiruvananthapuram");
					districts.addItem("Kollam");
					districts.addItem("Alappuzha");
					districts.addItem("Pathanamthitta");
					districts.addItem("Kottayam");
					districts.addItem("Idukki");
				}
				else if((states.getSelectedItem().toString())=="Karnataka")
				{
					districts.removeAllItems();
					districts.addItem("Bagalkot");
					districts.addItem("Ballari");
					districts.addItem("Belagavi");
					districts.addItem("engaluru");
					districts.addItem("Bidar");
				}
				else
				{
					districts.removeAllItems();
					districts.addItem("No Result");
				}
			}
		});
		
		states.setForeground(Color.WHITE);
		states.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		states.setBackground(new Color(102, 205, 170));
		states.setBounds(56, 173, 234, 45);
		states.setVisible(false);
		panel.add(states);
		
		districts = new JComboBox<String>();
		
		districts.setForeground(Color.WHITE);
		districts.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		districts.setBackground(new Color(102, 205, 170));
		districts.setBounds(318, 173, 234, 45);
		districts.setVisible(false);
		panel.add(districts);
		
		
		try{
			formattedTextField = new JFormattedTextField(new MaskFormatter("######"));
			formattedTextField.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		}
		catch(ParseException e)
		{
			
		}
		
		finally
		{
			
		}
		formattedTextField.setBounds(56, 173, 546, 50);
		panel.add(formattedTextField);
		
		final JLabel warning = new JLabel("Enter your Pin");
		warning.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		warning.setBounds(56, 217, 168, 37);
		panel.add(warning);
		
		JButton pin = new JButton("Search by Pin");
		pin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search.setVisible(true);
				search1.setVisible(false);
				formattedTextField.setVisible(true);
				warning.setVisible(true);
				states.setVisible(false);
				districts.setVisible(false);
				panel_1.setVisible(false);
			}
		});
		pin.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		pin.setBackground(Color.BLACK);
		pin.setForeground(Color.WHITE);
		pin.setBounds(56, 105, 198, 45);
		panel.add(pin);
		
		JButton district = new JButton("Search by District");
		district.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search.setVisible(false);
				search1.setVisible(true);
				formattedTextField.setVisible(false);
				warning.setVisible(false);
				states.setVisible(true);
				districts.setVisible(true);
				panel_1.setVisible(false);
				
			}
		});
		district.setForeground(Color.WHITE);
		district.setBackground(Color.BLACK);
		district.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		district.setBounds(250, 105, 191, 45);
		panel.add(district);
		
		panel_1 = new Panel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(56, 284, 931, 296);panel_1.setLayout(null);
		panel_1.setVisible(false);
		panel.add(panel_1);

	        
	        JLabel date1 = new JLabel("11, Aug");
	        date1.setHorizontalAlignment(SwingConstants.CENTER);
	        date1.setBackground(Color.GREEN);
	        date1.setFont(new Font("Yu Gothic Light", Font.BOLD, 19));
	        date1.setBounds(364, 0, 104, 56);
	        panel_1.add(date1);
	        
	        JLabel center1 = new JLabel("Govt Hr.sec school, P .Mettupalayam");
	        center1.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	        center1.setForeground(Color.BLACK);
	        center1.setBackground(Color.GREEN);
	        center1.setBounds(0, 66, 358, 34);
	        panel_1.add(center1);
	        
	        JLabel center2 = new JLabel("PU Middle school, Vaduganpalayam");
	        center2.setForeground(Color.BLACK);
	        center2.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	        center2.setBackground(Color.LIGHT_GRAY);
	        center2.setBounds(0, 110, 358, 34);
	        panel_1.add(center2);
	        
	        JLabel center3 = new JLabel("Diamond Jubilee Hr.sec school");
	        center3.setForeground(Color.BLACK);
	        center3.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	        center3.setBackground(Color.LIGHT_GRAY);
	        center3.setBounds(0, 154, 358, 34);
	        panel_1.add(center3);
	        
	        JLabel center4 = new JLabel("Govt Hr.sec school, Bommanaickanpalayam");
	        center4.setForeground(Color.BLACK);
	        center4.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	        center4.setBackground(Color.LIGHT_GRAY);
	        center4.setBounds(0, 198, 358, 34);
	        panel_1.add(center4);
	        
	        JLabel center5 = new JLabel("PU Middle school, Perunthalaiyur");
	        center5.setForeground(Color.BLACK);
	        center5.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
	        center5.setBackground(Color.LIGHT_GRAY);
	        center5.setBounds(0, 242, 358, 34);
	        panel_1.add(center5);
	        
	        JLabel btn1_na = new JLabel("NA");
	        btn1_na.setBackground(new Color(0, 191, 255));
	        btn1_na.setForeground(new Color(255, 0, 0));
	        btn1_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn1_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn1_na.setBounds(364, 66, 104, 34);
	        panel_1.add(btn1_na);
	        
	        final JButton cs11 = new JButton("105");
	        cs11.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		inputs[i][5]="CoviShield";
	        		inputs[i][6]="11 Aug 2021";
	        		inputs[i][7]="PU Middle school, Vaduganpalayam";
	        		inputs[i][8]="1234567890123"+i;
	        		frame.dispose();
	        		new Confirmation(inputs,i);
	        		
	        	}
	        });
	        cs11.setForeground(Color.WHITE);
	        cs11.setBackground(new Color(0, 128, 0));
	        cs11.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        cs11.setBounds(364, 110, 104, 21);
	        panel_1.add(cs11);
	        JLabel lblNewLabel_2_1_1_5 = new JLabel("COVISHIELD");
	        lblNewLabel_2_1_1_5.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2_1_1_5.setVerticalAlignment(SwingConstants.BOTTOM);
	        lblNewLabel_2_1_1_5.setBounds(364, 110, 104, 34);
	        panel_1.add(lblNewLabel_2_1_1_5);
	        
	        JLabel date2 = new JLabel("12, Aug");
	        date2.setHorizontalAlignment(SwingConstants.CENTER);
	        date2.setFont(new Font("Yu Gothic Light", Font.BOLD, 19));
	        date2.setBackground(Color.GREEN);
	        date2.setBounds(478, 0, 104, 56);
	        panel_1.add(date2);
	        
	        JLabel date3 = new JLabel("13, Aug");
	        date3.setHorizontalAlignment(SwingConstants.CENTER);
	        date3.setFont(new Font("Yu Gothic Light", Font.BOLD, 19));
	        date3.setBackground(Color.GREEN);
	        date3.setBounds(592, 0, 104, 56);
	        panel_1.add(date3);
	        
	        JLabel date4 = new JLabel("14, Aug");
	        date4.setHorizontalAlignment(SwingConstants.CENTER);
	        date4.setFont(new Font("Yu Gothic Light", Font.BOLD, 19));
	        date4.setBackground(Color.GREEN);
	        date4.setBounds(706, 0, 104, 56);
	        panel_1.add(date4);
	        
	        JLabel date5 = new JLabel("15, Aug");
	        date5.setHorizontalAlignment(SwingConstants.CENTER);
	        date5.setFont(new Font("Yu Gothic Light", Font.BOLD, 19));
	        date5.setBackground(Color.GREEN);
	        date5.setBounds(817, 0, 104, 56);
	        panel_1.add(date5);
	        
	        JLabel btn2_na = new JLabel("NA");
	        btn2_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn2_na.setForeground(Color.RED);
	        btn2_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn2_na.setBounds(478, 66, 104, 34);
	        panel_1.add(btn2_na);
	        
	        JLabel btn3_na = new JLabel("NA");
	        btn3_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn3_na.setForeground(Color.RED);
	        btn3_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn3_na.setBounds(592, 66, 104, 34);
	        panel_1.add(btn3_na);
	        
	        JLabel btn4_na = new JLabel("NA");
	        btn4_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn4_na.setForeground(Color.RED);
	        btn4_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn4_na.setBounds(706, 66, 104, 34);
	        panel_1.add(btn4_na);
	        
	        JLabel btn5_na = new JLabel("NA");
	        btn5_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn5_na.setForeground(Color.RED);
	        btn5_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn5_na.setBounds(819, 66, 104, 34);
	        panel_1.add(btn5_na);
	        
	        JButton cv13 = new JButton("50");
	        cv13.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		inputs[i][5]="Covaxin";
	        		inputs[i][6]="13 Aug 2021";
	        		inputs[i][7]="PU Middle school, Vaduganpalayam";
	        		inputs[i][8]="1234567890123"+i;
	        		frame.dispose();
	        		new Confirmation(inputs,i);
	        		
	        	}
	        });
	        cv13.setForeground(Color.WHITE);
	        cv13.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        cv13.setBackground(new Color(0, 128, 0));
	        cv13.setBounds(592, 111, 104, 21);
	        panel_1.add(cv13);
	        
	        JLabel lblNewLabel_2_1_1_5_1 = new JLabel("COVAXIN");
	        lblNewLabel_2_1_1_5_1.setVerticalAlignment(SwingConstants.BOTTOM);
	        lblNewLabel_2_1_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2_1_1_5_1.setBounds(592, 110, 104, 34);
	        panel_1.add(lblNewLabel_2_1_1_5_1);
	        
	        JLabel btn7_na = new JLabel("NA");
	        btn7_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn7_na.setForeground(Color.RED);
	        btn7_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn7_na.setBounds(706, 110, 104, 34);
	        panel_1.add(btn7_na);
	        
	        JLabel btn8_na = new JLabel("NA");
	        btn8_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn8_na.setForeground(Color.RED);
	        btn8_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn8_na.setBounds(817, 110, 104, 34);
	        panel_1.add(btn8_na);
	        
	        JButton cv11 = new JButton("100");
	        cv11.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		inputs[i][5]="Covaxin";
	        		inputs[i][6]="11 Aug 2021";
	        		inputs[i][7]="Diamond Jubilee Hr.sec school";
	        		inputs[i][8]="1234567890123"+i;
	        		frame.dispose();
	        		new Confirmation(inputs,i);
	        	}
	        });
	        cv11.setForeground(Color.WHITE);
	        cv11.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        cv11.setBackground(new Color(0, 128, 0));
	        cv11.setBounds(364, 154, 104, 21);
	        panel_1.add(cv11);
	        
	        JButton cs15 = new JButton("250");
	        cs15.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		inputs[i][5]="CoviShield";
	        		inputs[i][6]="15 Aug 2021";
	        		inputs[i][7]="Diamond Jubilee Hr.sec school";
	        		inputs[i][8]="1234567890123"+i;
	        		frame.dispose();
	        		new Confirmation(inputs,i);
	        	}
	        });
	        cs15.setForeground(Color.WHITE);
	        cs15.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        cs15.setBackground(new Color(0, 128, 0));
	        cs15.setBounds(817, 155, 104, 21);
	        panel_1.add(cs15);
	        
	        JButton cv14 = new JButton("200");
	        cv14.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		inputs[i][5]="Covaxin";
	        		inputs[i][6]="14 Aug 2021";
	        		inputs[i][7]="Govt Hr.sec school, Bommanaickanpalayam";
	        		inputs[i][8]="1234567890123"+i;
	        		frame.dispose();
	        		new Confirmation(inputs,i);
	        	}
	        });
	        cv14.setForeground(Color.WHITE);
	        cv14.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        cv14.setBackground(new Color(0, 128, 0));
	        cv14.setBounds(706, 198, 104, 21);
	        panel_1.add(cv14);
	        
	        JButton cs11_1 = new JButton("50");
	        cs11_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		inputs[i][5]="CoviShield";
	        		inputs[i][6]="11 Aug 2021";
	        		inputs[i][7]="Govt Hr.sec school, Bommanaickanpalayam";
	        		inputs[i][8]="1234567890123"+i;
	        		frame.dispose();
	        		new Confirmation(inputs,i);
	        	}
	        });
	        cs11_1.setForeground(Color.WHITE);
	        cs11_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        cs11_1.setBackground(new Color(0, 128, 0));
	        cs11_1.setBounds(364, 198, 104, 21);
	        panel_1.add(cs11_1);
	        
	        JButton cs12 = new JButton("130");
	        cs12.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		inputs[i][5]="CoviShield";
	        		inputs[i][6]="12 Aug 2021";
	        		inputs[i][7]="PU Middle school, Perunthalaiyur";
	        		inputs[i][8]="1234567890123"+i;
	        		frame.dispose();
	        		new Confirmation(inputs,i);
	        	}
	        });
	        cs12.setForeground(Color.WHITE);
	        cs12.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        cs12.setBackground(new Color(0, 128, 0));
	        cs12.setBounds(478, 242, 104, 21);
	        panel_1.add(cs12);
	        
	        JButton cs14 = new JButton("110");
	        cs14.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		inputs[i][5]="CoviShield";
	        		inputs[i][6]="14 Aug 2021";
	        		inputs[i][7]="PU Middle school, Perunthalaiyur";
	        		inputs[i][8]="1234567890123"+i;
	        		frame.dispose();
	        		new Confirmation(inputs,i);
	        	}
	        });
	        cs14.setForeground(Color.WHITE);
	        cs14.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        cs14.setBackground(new Color(0, 128, 0));
	        cs14.setBounds(706, 243, 104, 21);
	        panel_1.add(cs14);
	        
	        JLabel lblNewLabel_2_1_1_5_2 = new JLabel("COVAXIN");
	        lblNewLabel_2_1_1_5_2.setVerticalAlignment(SwingConstants.BOTTOM);
	        lblNewLabel_2_1_1_5_2.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2_1_1_5_2.setBounds(364, 154, 104, 34);
	        panel_1.add(lblNewLabel_2_1_1_5_2);
	        
	        JLabel lblNewLabel_2_1_1_5_3 = new JLabel("COVISHIELD");
	        lblNewLabel_2_1_1_5_3.setVerticalAlignment(SwingConstants.BOTTOM);
	        lblNewLabel_2_1_1_5_3.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2_1_1_5_3.setBounds(364, 198, 104, 34);
	        panel_1.add(lblNewLabel_2_1_1_5_3);
	        
	        JLabel lblNewLabel_2_1_1_5_5 = new JLabel("COVISHIELD");
	        lblNewLabel_2_1_1_5_5.setVerticalAlignment(SwingConstants.BOTTOM);
	        lblNewLabel_2_1_1_5_5.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2_1_1_5_5.setBounds(817, 154, 104, 34);
	        panel_1.add(lblNewLabel_2_1_1_5_5);
	        
	        JLabel lblNewLabel_2_1_1_5_6 = new JLabel("COVISHIELD");
	        lblNewLabel_2_1_1_5_6.setVerticalAlignment(SwingConstants.BOTTOM);
	        lblNewLabel_2_1_1_5_6.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2_1_1_5_6.setBounds(706, 242, 104, 34);
	        panel_1.add(lblNewLabel_2_1_1_5_6);
	        
	        JLabel lblNewLabel_2_1_1_5_7 = new JLabel("COVISHIELD");
	        lblNewLabel_2_1_1_5_7.setVerticalAlignment(SwingConstants.BOTTOM);
	        lblNewLabel_2_1_1_5_7.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2_1_1_5_7.setBounds(478, 242, 104, 34);
	        panel_1.add(lblNewLabel_2_1_1_5_7);
	        
	        JLabel lblNewLabel_2_1_1_5_4 = new JLabel("COVAXIN");
	        lblNewLabel_2_1_1_5_4.setVerticalAlignment(SwingConstants.BOTTOM);
	        lblNewLabel_2_1_1_5_4.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2_1_1_5_4.setBounds(706, 198, 104, 34);
	        panel_1.add(lblNewLabel_2_1_1_5_4);
	        
	        
	        
	        JLabel btn6_na = new JLabel("NA");
	        btn6_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn6_na.setForeground(Color.RED);
	        btn6_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn6_na.setBounds(478, 110, 104, 34);
	        panel_1.add(btn6_na);
	        
	        JLabel btn9_na = new JLabel("NA");
	        btn9_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn9_na.setForeground(Color.RED);
	        btn9_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn9_na.setBounds(478, 154, 104, 34);
	        panel_1.add(btn9_na);
	        
	        JLabel btn12_na = new JLabel("NA");
	        btn12_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn12_na.setForeground(Color.RED);
	        btn12_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn12_na.setBounds(478, 198, 104, 34);
	        panel_1.add(btn12_na);
	        
	        JLabel btn15_na = new JLabel("NA");
	        btn15_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn15_na.setForeground(Color.RED);
	        btn15_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn15_na.setBounds(364, 242, 104, 34);
	        panel_1.add(btn15_na);
	        
	        JLabel btn10_na = new JLabel("NA");
	        btn10_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn10_na.setForeground(Color.RED);
	        btn10_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn10_na.setBounds(592, 154, 104, 34);
	        panel_1.add(btn10_na);
	        
	        JLabel btn11_na = new JLabel("NA");
	        btn11_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn11_na.setForeground(Color.RED);
	        btn11_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn11_na.setBounds(706, 154, 104, 34);
	        panel_1.add(btn11_na);
	        
	        JLabel btn13_na = new JLabel("NA");
	        btn13_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn13_na.setForeground(Color.RED);
	        btn13_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn13_na.setBounds(592, 198, 104, 34);
	        panel_1.add(btn13_na);
	        
	        JLabel btn16_na = new JLabel("NA");
	        btn16_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn16_na.setForeground(Color.RED);
	        btn16_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn16_na.setBounds(592, 242, 104, 34);
	        panel_1.add(btn16_na);
	        
	        JLabel btn14_na = new JLabel("NA");
	        btn14_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn14_na.setForeground(Color.RED);
	        btn14_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn14_na.setBounds(817, 198, 104, 34);
	        panel_1.add(btn14_na);
	        
	        JLabel btn17_na = new JLabel("NA");
	        btn17_na.setHorizontalAlignment(SwingConstants.CENTER);
	        btn17_na.setForeground(Color.RED);
	        btn17_na.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
	        btn17_na.setBounds(817, 242, 104, 34);
	        panel_1.add(btn17_na);
			
	        search = new JButton("Search");
			search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String num=(String) formattedTextField.getValue();
					int i=Integer.parseInt(num);
					if(i==638455)
					{
						panel_1.setVisible(true);
						error.setVisible(false);
						
					}
					else
					{
						panel_1.setVisible(false);
						error.setVisible(true);
					}
					
					formattedTextField.setText("");
				}
			});
			search.setForeground(Color.WHITE);
			search.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
			search.setBackground(Color.BLACK);
			search.setBounds(627, 173, 191, 45);
			search.setVisible(true);
			panel.add(search);
			
			error = new JLabel("No Vaccination Center found");
			error.setForeground(new Color(255, 0, 0));
			error.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
			error.setHorizontalAlignment(SwingConstants.CENTER);
			error.setBounds(56, 246, 546, 32);
			error.setVisible(false);
			panel.add(error);
			
			search1 = new JButton("Search");
			search1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str=districts.getSelectedItem().toString();
					if(str=="Erode")
					{
						panel_1.setVisible(true);
						error.setVisible(false);
						
					}
					else
					{
						panel_1.setVisible(false);
						error.setVisible(true);
					}
					
				}
			});
			search1.setForeground(Color.WHITE);
			search1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
			search1.setBackground(Color.BLACK);
			search1.setBounds(627, 173, 191, 45);
			search1.setVisible(false);
			panel.add(search1);
			
			
	       
		
		
		
	}

	protected Double Double(Object value) {
		// TODO Auto-generated method stub
		return null;
	}
}

