package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;

public class LoadDoneEditing extends JFrame {

	private JPanel contentPane;
	public Quiz daQuiz;
	private JTextField txtQuizMakerPro;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadDoneEditing frame = new LoadDoneEditing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void setQuiz(Quiz daQuiz) {
		this.daQuiz=daQuiz;
	}
	
	public void saveToBinary(String fileName) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName+".bin"));
			os.writeObject(daQuiz);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LoadDoneEditing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoadDoneEditing.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		setTitle("Quiz Maker Pro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.setBounds(0, -1, 106, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Quiz");
		btnNewButton_1.setBounds(103, -1, 99, 25);
		contentPane.add(btnNewButton_1);
		
		txtQuizMakerPro = new JTextField();
		txtQuizMakerPro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtQuizMakerPro.setText("  Quiz Maker Pro");
		txtQuizMakerPro.setBounds(201, -1, 155, 25);
		contentPane.add(txtQuizMakerPro);
		txtQuizMakerPro.setColumns(10);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon(LoadDoneEditing.class.getResource("/Resources/icons8-quill-with-ink-50.png")));
		mntmNewMenuItem.setBounds(355, 0, 76, 56);
		contentPane.add(mntmNewMenuItem);
		
		JLabel lblWouldYouLike = new JLabel("Would you like to save the quiz?");
		lblWouldYouLike.setBounds(122, 76, 189, 16);
		contentPane.add(lblWouldYouLike);
		
		JLabel lblNewLabel = new JLabel("Or edit more?");
		lblNewLabel.setBounds(162, 92, 92, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblFilename = new JLabel("Filename:");
		lblFilename.setBounds(64, 121, 69, 16);
		contentPane.add(lblFilename);
		
		textField = new JTextField();
		textField.setBounds(145, 118, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fileName=textField.getText();
				saveToBinary(fileName);
				idk window = new idk();
				window.getjFrame().setVisible(true);
				dispose();
			}
		});
		btnSave.setBounds(309, 117, 97, 25);
		contentPane.add(btnSave);
		
		JButton btnEditMore = new JButton("Edit More");
		btnEditMore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadQuizOptionsFrame frame= new LoadQuizOptionsFrame();
				frame.setQuiz(daQuiz);
				frame.setVisible(true);
				dispose();
			}
		});
		btnEditMore.setBounds(157, 162, 97, 25);
		contentPane.add(btnEditMore);
		
		JLabel lblbin = new JLabel(".bin");
		lblbin.setBounds(266, 121, 47, 16);
		contentPane.add(lblbin);
	}

}
