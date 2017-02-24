package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MainWindowApplication {

	private JFrame frame;
	private JTextField tf_output;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowApplication window = new MainWindowApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindowApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel jp_drawing_bg = new JPanel();
		jp_drawing_bg.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jp_drawing_bg.setBackground(Color.WHITE);
		jp_drawing_bg.setBounds(30, 50, 350, 350);
		frame.getContentPane().add(jp_drawing_bg);
		
		JPanel jp_output = new JPanel();
		jp_output.setBorder(new LineBorder(new Color(0, 0, 0)));
		jp_output.setBounds(450, 200, 175, 80);
		frame.getContentPane().add(jp_output);
		jp_output.setLayout(null);
		
		tf_output = new JTextField();
		tf_output.setBounds(10, 30, 150, 20);
		jp_output.add(tf_output);
		tf_output.setText("TEST");
		tf_output.setColumns(10);
		
		JLabel lbl_output = new JLabel("Output :");
		lbl_output.setBounds(10, 10, 50, 15);
		jp_output.add(lbl_output);
	}
}
