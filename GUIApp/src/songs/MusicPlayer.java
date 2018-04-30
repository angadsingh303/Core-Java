package songs;


import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;
import songs.SongPath;
 
public class MusicPlayer extends JFrame {
	private DefaultListModel<String> listModel;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicPlayer frame = new MusicPlayer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void defaultSongs(){
		listModel.addElement("Haanikaarak Bapu - Dangal");
		listModel.addElement("Summer of 69");
		listModel.addElement("Blsck Beetles");
		listModel.addElement("Bang Bang");
		listModel.addElement("Bang Bang");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");
		listModel.addElement("It's My Life");


	}
	/**
	 * Create the frame.
	 */
	public MusicPlayer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listModel = new DefaultListModel<String>();
		this.defaultSongs();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 65, 353, 245);
		contentPane.add(scrollPane);
		
		JList list = new JList(listModel);
	/*	list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String songName=listModel.get(list.getSelectedIndex());
				playSong(songName);
			}
		});*/
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount()==2){
					String songName = listModel.get(list.getSelectedIndex());
					playSong(songName);
				}
			}
			
		});
		scrollPane.setViewportView(list);
	}
	private void playSong(String SongName){
		MP3Player mp3;
		if(SongName.equalsIgnoreCase("Haanikaarak Bapu - Dangal")){
			mp3 = new MP3Player(new File(SongPath.Song));
			mp3.play();
		}
	}
}
