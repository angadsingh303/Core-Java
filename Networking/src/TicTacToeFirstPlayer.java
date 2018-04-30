import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TicTacToeFirstPlayer extends JFrame {
	private JLabel msglbl = new JLabel("");
	private boolean isXorZero = true;
	private boolean yourTurn = false;
	ServerSocket server;
	final String SERVER_NAME = "localhost";
	private JPanel contentPane;
	final int PORT=9001;
	DataInputStream input;
	DataOutputStream output;
	
	private void Initialize() throws IOException{
		server= new ServerSocket(PORT);
		msglbl.setText("Waiting For Second Player TO Join The Game");
		Socket socket= server.accept();
		msglbl.setText("New Player Joined,Starting the game.");
		input= new DataInputStream(socket.getInputStream());
		output= new DataOutputStream(socket.getOutputStream());
		
	}
	private void receiveInput() throws IOException{
		String recInput = "";
		while(!recInput.equalsIgnoreCase("exit") ){
			yourTurn= true;
			
			msglbl.setText("Now Your Turn ");
			recInput = input.readUTF();
			System.out.println("Rec Input "+recInput);
			placeX(recInput);
		}
}
	
	private void placeX(String recInput){
		System.out.println("Server Side PlaceX Call "+recInput);
		if(recInput.trim().length()>0){
			String array[]=recInput.split(",");
			int position = Integer.parseInt(array[0]);
			String buttonValue = array[1];
			switch(position){
			case 1:
				button1.setText("X");
				break;
			case 2:
				button2.setText("X");
				break;
			case 3:
				button3.setText("X");
				break;
			case 4:
				button4.setText("X");
				break;
			case 5:
				button5.setText("X");
				break;
			case 6:
				button6.setText("X");
				break;
			case 7:
				button7.setText("X");
				break;
			case 8:
				button8.setText("X");
				break;
			case 9:
				button9.setText("X");
				break;	
			}
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{
		
					TicTacToeFirstPlayer frame = new TicTacToeFirstPlayer();
					frame.setVisible(true);
					frame.Initialize();
					frame.receiveInput();
					
	}

	/**
	 * Create the frame.
	 */
	
	JButton button1 = new JButton("");
	JButton button2 = new JButton("");
	JButton button3 = new JButton("");
	JButton button4 = new JButton("");
	JButton button5 = new JButton("");
	JButton button6 = new JButton("");
	JButton button7 = new JButton("");
	JButton button8 = new JButton("");
	JButton button9 = new JButton("");

	
	public TicTacToeFirstPlayer() {
		
		setTitle("TicTacToe- Player- ONE");
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendO(1,button1);
			}
		});
		button1.setBounds(31, 67, 93, 50);
		button1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(button1);
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendO(2,button2);
			}
		});
		button2.setBounds(181, 67, 93, 50);
		button2.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(button2);
		
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendO(3,button3);
			}
		});
		button3.setBounds(332, 67, 93, 50);
		button3.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(button3);
		
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendO(4,button4);
			}
		});
		button4.setBounds(31, 161, 93, 50);
		button4.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(button4);
		
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendO(5,button5);
			}
		});
		button5.setBounds(181, 161, 93, 50);
		button5.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(button5);
		
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendO(6,button6);
			}
		});
		button6.setBounds(332, 161, 93, 50);
		button6.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(button6);
		
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendO(7,button7);
			}
		});
		button7.setBounds(31, 255, 93, 50);
		button7.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(button7);
		
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendO(8,button8);
			}
		});
		button8.setBounds(181, 255, 93, 50);
		button8.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(button8);
		
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendO(9,button9);
			}
		});
		button9.setBounds(332, 255, 93, 50);
		button9.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(button9);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPane.add(panel);
		
		msglbl.setBounds(31, 10, 387, 30);
		contentPane.add(msglbl);
	}
	
	private void sendO(int buttonPosition, JButton button){
		if(button.getText().trim().length()==0){
			if(yourTurn){
				button.setText("O");
				yourTurn=false;
				msglbl.setText("Now Player Two Turn....Wait for Your Turn...");
				try {
					output.writeUTF(buttonPosition+","+"O");
					System.out.println("SendZero Call Pos "+buttonPosition+" Value X "+" Your Turn "+yourTurn);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
