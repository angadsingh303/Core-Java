import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class CrashGame extends JFrame {

	private JPanel contentPane;
	private JLabel label = new JLabel("");
	private JLabel label_1 = new JLabel("");
	int x = 24;
	private Timer timer;
	private  JLabel label_2 = new JLabel(""); 
	
	
	private void doAnimation(){
		 timer = new Timer(10,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				label.setBounds(x, 71, 116, 90);
				if(x< 225){
					x++;
				}
				else
				if(x>=225)	
				{
					label_1.setVisible(false);
					label_2.setVisible(true);
					
					
					
				}
				
				else{
					timer.stop();
					CrashGame.this.setVisible(false);
					CrashGame.this.dispose();
					
					//app.setVisible(true);
				}
			}
			
		});
		timer.start();
	}
		
		
	

	
		
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		CrashGame frame = new CrashGame();
		frame.setVisible(true);
		frame.setBackground(Color.WHITE);
		frame.doAnimation();
				
	}
		
		
		
	

	/**
	 * Create the frame.
	 */
	public CrashGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Icon icon = new ImageIcon(CrashGame.class.getResource("aeroplane.gif"));
		label.setBounds(48, 71, 365, 296);
		contentPane.add(label);
		label.setIcon(icon);
		
		
		
		Icon icon1 = new ImageIcon(CrashGame.class.getResource("building.jpg"));
		label_1.setBounds(811, 63, 381, 546);
		contentPane.add(label_1);
		label_1.setIcon(icon1);
		
		Icon icon2 = new ImageIcon(CrashGame.class.getResource("boom.png"));
		label_2.setVisible(false);
		label_2.setBounds(228, 473, 185, 59);
		contentPane.add(label_2);
		label_2.setIcon(icon2);
	}
}
