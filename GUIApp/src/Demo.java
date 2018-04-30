import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Demo extends JFrame {
	
	//JLabel lblGreetApplication = new JLabel("Greet Application");
	
	JLabel lblGreetApplication = new JLabel("Greet Application");
    private JTextField textField;
	private JTextField textField_1;
	private JLabel error1;
	private JLabel error2;
	JLabel label = new JLabel("");
	final int ENTER = 10;
	private boolean isVisible = true;
	private int color = 1;
	JButton btnNewButton = new JButton("Submit");
	JButton btnNewButton_1 = new JButton("Reset");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo frame = new Demo();
					frame.setVisible(true);
					frame.doAnimation();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void askToClose(){
		int choice = JOptionPane.showConfirmDialog(this, "Do u really want to close this application","BMPL",JOptionPane.YES_NO_OPTION);
		System.out.println("UR CHOICE IS "+choice);
		if(choice == JOptionPane.YES_OPTION){
			this.setVisible(false);
			this.dispose();
		}
		else
		if(choice == JOptionPane.NO_OPTION){
			return ;
		}
	}
	private void sayHello(){
		textField.setText(textField.getText());
		textField_1.setText(textField_1.getText());
		label.setText("Welcome "+textField.getText()+" "+textField_1.getText());
		
	}
	//private String validateData(char x){
	private String validateData(String x){
		//if(!((x>='A' && x<='Z') || (x>='a' && x<='z'))){
		for(int i=0;i<x.length();i++){  
		if(!(Character.isAlphabetic(x.charAt(i)))){
			return "Only Char Allowed";
		}
		
			
}
		return "";
	}
	
	private void clearAll(){
		textField.setText("");
		textField_1.setText("");
		error1.setText("");
		error2.setText("");
		label.setText("");
		textField.requestFocus(true);
	}
	private void changeSize(){
		lblGreetApplication.setFont(new Font("Arial", Font.BOLD, 10+color));
	}
	
	private Color changeColor(){
		Color myColor = null;
		if(color>7){
			color = 1;
		}
		switch(color){
		case 1:
			myColor = Color.RED;
			break;
		case 7:
			myColor = Color.MAGENTA;
			break;
		case 2:
			myColor = Color.BLUE;
			break;
		case 3:
			myColor = Color.ORANGE;
			break;
		case 4:
			myColor = Color.GRAY;
			break;
		case 5:
			myColor = Color.CYAN;
			break;
		case 6:
			myColor = Color.GREEN;
			break;
			default :
				myColor = Color.YELLOW;
		}
		color++;
		return myColor;
	}
	
	private void doAnimation(){
		ActionListener l = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isVisible){
					lblGreetApplication.setForeground(changeColor());
					changeSize();
					}
				lblGreetApplication.setVisible(isVisible);
				isVisible = ! isVisible;
				
				
			}
		};
		int DELAY = 100;
		Timer timer = new Timer(DELAY, l);
		timer.start();
	}
	/**
	 * Create the frame.
	 */
	public Demo() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				askToClose();
			}
		}); 
		lblGreetApplication.setForeground(Color.RED);
		lblGreetApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreetApplication.setFont(new Font("Lucida Grande", Font.BOLD, 16));

		setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	//}
		
		
			
			ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sayHello();
			}
		};
		
		JLabel lblFirstName = new JLabel("First Name ");
		lblFirstName.setBounds(12, 65, 101, 15);
		contentPane.add(lblFirstName);
		
		JLabel lblSecondName = new JLabel("Second Name");
		lblSecondName.setBounds(12, 123, 101, 15);
		contentPane.add(lblSecondName);
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		
		
		label.setBounds(120, 165, 246, 48);
		contentPane.add(label);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Key Code "+e.getKeyCode());
				if(e.getKeyCode()==ENTER){
					System.out.println("Inside IF...");
					textField_1.requestFocus();
					return ;
				}
				error1.setText(validateData(textField.getText()));
				
				
			}
		}); 
		
		
		
		textField.setBounds(152, 63, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField.setText(textField.getText());
		textField_1 = new JTextField();
		
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Key Code "+e.getKeyCode());
				if(e.getKeyCode()==ENTER){
					System.out.println("Inside IF...");
					btnNewButton.requestFocus();
					return ;
				}
				error2.setText(validateData(textField_1.getText()));
				
				
			}
		}); 
		
		textField_1.setBounds(152, 121, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(textField_1.getText());
		
		btnNewButton.addActionListener(l);
		
		btnNewButton.setBounds(34, 212, 117, 25);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearAll();
				
			}
		});
		btnNewButton_1.setBounds(222, 212, 117, 25);
		contentPane.add(btnNewButton_1);
		
		error1 = new JLabel();
		error1.setForeground(Color.RED);
		error1.setBounds(284, 61, 154, 19);
		contentPane.add(error1);
		
		error2 = new JLabel();
		error2.setBackground(Color.WHITE);
		error2.setForeground(Color.RED);
		error2.setBounds(284, 121, 154, 19);
		contentPane.add(error2);
		
		
		lblGreetApplication.setBounds(67, 30, 315, 15);
		contentPane.add(lblGreetApplication);
		
		
	}
}
