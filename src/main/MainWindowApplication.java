package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindowApplication {

	private JFrame frame;
	private static JTextField tf_output;

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
		frame.setTitle("Smart Project");
		
		final PadDraw jp_drawing = new PadDraw();
		jp_drawing.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jp_drawing.setSize(350, 350);
		jp_drawing.setLocation(30, 50);
		frame.getContentPane().add(jp_drawing);
		
		JPanel jp_output = new JPanel();
		jp_output.setBorder(new LineBorder(new Color(0, 0, 0)));
		jp_output.setBounds(450, 200, 175, 80);
		frame.getContentPane().add(jp_output);
		jp_output.setLayout(null);
		
		tf_output = new JTextField();
		tf_output.setEditable(false);
		tf_output.setBounds(10, 30, 150, 20);
		jp_output.add(tf_output);
		tf_output.setColumns(10);
		
		JLabel lbl_output = new JLabel("Output :");
		lbl_output.setBounds(10, 10, 50, 15);
		jp_output.add(lbl_output);
		
		JButton btnClearLol = new JButton("Clear Drawing");
		btnClearLol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jp_drawing.clear();
			}
		});
		btnClearLol.setBounds(450, 119, 142, 23);
		frame.getContentPane().add(btnClearLol);
		
		JButton btnClearOutput = new JButton("Clear Output");
		btnClearOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tf_output.setText("");
			}
		});
		btnClearOutput.setBounds(600, 119, 142, 23);
		frame.getContentPane().add(btnClearOutput);
	}
	
	public static void addLetterOutput(char c) {
		tf_output.setText(tf_output.getText() + c);
	}
}
