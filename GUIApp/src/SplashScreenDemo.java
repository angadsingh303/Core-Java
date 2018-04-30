import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SplashScreenDemo extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//public class SplashScreenDemo extends JWindow {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					SplashScreenDemo frame = new SplashScreenDemo();
					frame.setVisible(true);
					frame.setSize(700,500);
					//frame.pack();
					
				
			
		}
	

	/**
	 * Create the frame.
	 */
	public SplashScreenDemo() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Icon icon = new ImageIcon(SplashScreenDemo.class.getResource("earth.gif"));
		lblNewLabel.setBounds(12, -159, 438, 1070);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(icon);
		 
		
		
		
		
		
	}
}
