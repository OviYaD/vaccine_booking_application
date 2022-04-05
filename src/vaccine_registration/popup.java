package vaccine_registration;

import java.awt.Dimension; 
import javax.swing.ImageIcon; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.SwingConstants; 
import javax.swing.UIManager; 
public class popup 
{    
	public String popup(final String nm)
	{       
		ImageIcon icon = new ImageIcon("E −\\new.PNG");       
		JPanel panel = new JPanel();       
		panel.setSize(new Dimension(100, 100));       
		panel.setLayout(null);       
		JLabel label1 = new JLabel(nm+" Now?");       
		label1.setVerticalAlignment(SwingConstants.BOTTOM);       
		label1.setBounds(0, 5, 200, 30);       
		label1.setHorizontalAlignment(SwingConstants.CENTER);       
		panel.add(label1);           
		UIManager.put("OptionPane.minimumSize", new Dimension(200, 100));       
		int res = JOptionPane.showConfirmDialog(null, panel, "File",       JOptionPane.YES_NO_CANCEL_OPTION,       JOptionPane.PLAIN_MESSAGE, icon);       
		if(res == 0) 
		{          
			return "Yes";       
		} 
		else if (res == 1) 
		{          
			return "No";         
		}
		else
		{         
			return "Cancel";      
		} 
	}
	
}