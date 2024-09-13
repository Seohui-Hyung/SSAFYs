package Main;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.awt.*;

public class 이화정 extends JFrame{
	private JLabel label = new JLabel("서히 언니는 바보야");
	
	public 이화정() {
		setTitle("서히언니");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ravie", Font.ITALIC, 30));
		c.add(label, BorderLayout.CENTER);
		createMenu();
		setSize(250, 200);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem colormenuitem = new JMenuItem("color");
		JMenu filemenu = new JMenu("text");
		
		colormenuitem.addActionListener(new menuActionListner());
		
		filemenu.add(colormenuitem);
		mb.add(filemenu);
		this.setJMenuBar(mb);
		
	}
	
	class menuActionListner implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("color")) {
				Color selectedColor = JColorChooser.showDialog(null, "color", Color.black);
				if(selectedColor != null) 
					label.setForeground(selectedColor);
			}
		}
	}
	
	public static void main(String[] args) {
		new 이화정();
	}
}