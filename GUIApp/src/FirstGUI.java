import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FirstGUI extends JFrame {
	final int WIDTH =300;
	final int HEIGHT =300;
	
	public FirstGUI(){
		JButton okbutton = new JButton("Ok");
		ActionListener l = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(FirstGUI.this,"You clicked on ok ");
			}
		};
		okbutton.addActionListener(l);
		okbutton.setBounds(10,10, 100, 50);
		JButton cancelbutton = new JButton("Cancel");
		cancelbutton.setBounds(90,10, 100, 50);
		JButton hibutton = new JButton("Hi");
		hibutton.setBounds(10,70, 100, 50);
		JButton hellobutton = new JButton("HELLO");
		hellobutton.setBounds(90,70, 100, 50); 
		this.setLayout(null);
		//this.setLayout(new GridLayout(2,2));
		this.getContentPane().add(okbutton);
		this.getContentPane().add(cancelbutton);
		this.getContentPane().add(hibutton);
		this.getContentPane().add(hellobutton);
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("This is My First Frame..");
		this.setVisible(true);
		this.setExtendedState(MAXIMIZED_BOTH); 
		
	}
	/*public void paint(Graphics g){
	g.setColor(Color.RED);	
	g.setFont(new Font("Arial",Font.BOLD,20));	
	g.drawString("HELLO", 100, 100);	
	}*/

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
			FirstGUI obj =new FirstGUI();
	}

}
