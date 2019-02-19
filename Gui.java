

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gui implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JLabel label1 = new JLabel("Item name");
	JLabel label2 = new JLabel("Item name");
	JLabel label3 = new JLabel("Item name");
	JComboBox<String> itemsList = new JComboBox<String>();
	JButton add_button = new JButton("Add another item");
	JButton delete_button = new JButton("Delete an item");
	JButton bill_button= new JButton("Generate bill");
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints layout = new GridBagConstraints();

	public Gui() {
		frame.setLayout(gbl);
		
		//source-https://www.math.uni-hamburg.de/doc/java/tutorial/uiswing/layout/gridbag.html
		panel1 = new JPanel();
		//layout.fill = GridBagConstraints.CENTER;
		layout.gridx=0;
		layout.gridy=0;
		layout.gridwidth=1;
		panel1.setLayout(new BorderLayout(100,300));
		panel1.setPreferredSize(new Dimension(100,300));
		panel1.add(label1);
		//source - https://www.tutorialspoint.com/swingexamples/add_border_to_panel.html
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.add(panel1,layout);
		
		panel2 = new JPanel();
		//layout.fill = GridBagConstraints.CENTER;
		layout.gridx=1;
		layout.gridy=0;
		layout.gridwidth=3;
		//panel2.setLayout(new GridLayout(0, 1));
		//panel2.setPreferredSize(new Dimension(500,300));
		panel2.add(label2);
		frame.add(panel2,layout);
		
		panel3 = new JPanel();
		//layout.fill = GridBagConstraints.CENTER;
		//layout.weightx=1;
		layout.gridx=0;
		layout.gridy=2;
		layout.gridwidth=4;
		//panel3.setLayout(new GridLayout(0, 1));
		//panel3.setPreferredSize(new Dimension(600,600));
		panel3.add(label3);
		frame.add(panel3,layout);
		
		frame.pack();
		gbl.layoutContainer(frame);
		//frame.setSize(300, 300);
		frame.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add_button) {
			
		}
		if(e.getSource() == delete_button) {
			
		}
		if(e.getSource() == bill_button) {
			
		}
	}

}
