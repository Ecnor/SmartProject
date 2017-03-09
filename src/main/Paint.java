package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paint {
	public static void main(String[] args){
		Icon iconB = new ImageIcon("blue.gif");
		//the blue image icon
		Icon iconM = new ImageIcon("magenta.gif");
		//magenta image icon
		Icon iconR = new ImageIcon("red.gif");
		//red image icon
		Icon iconBl = new ImageIcon("black.gif");
		//black image icon
		Icon iconG = new ImageIcon("green.gif");
		//finally the green image icon
		//These will be the images for our colors.
		
		JFrame frame = new JFrame("Paint It");
		//Creates a frame with a title of "Paint it"
		
		Container content = frame.getContentPane();
		//Creates a new container
		content.setLayout(new BorderLayout());
		//sets the layout
		
		final PadDraw drawPad = new PadDraw();
		//creates a new padDraw, which is pretty much the paint program
		
		content.add(drawPad, BorderLayout.CENTER);
		//sets the padDraw in the center
		
		JPanel panel = new JPanel();
		//creates a JPanel
		panel.setPreferredSize(new Dimension(32, 68));
		panel.setMinimumSize(new Dimension(32, 68));
		panel.setMaximumSize(new Dimension(32, 68));
		//This sets the size of the panel
		
		JButton clearButton = new JButton("Clear");
		//creates the clear button and sets the text as "Clear"
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.clear();
			}
		});
		//this is the clear button, which clears the screen.  This pretty
		//much attaches an action listener to the button and when the
		//button is pressed it calls the clear() method
		
		JButton redButton = new JButton(iconR);
		//creates the red button and sets the icon we created for red
		redButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.red();
			}

		});
		//when pressed it will call the red() method.  So on and so on =]
		
		JButton blackButton = new JButton(iconBl);
		//same thing except this is the black button
		blackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.black();
			}
		});
		
		JButton magentaButton = new JButton(iconM);
		//magenta button
		magentaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.magenta();
			}
		});
		
		JButton blueButton = new JButton(iconB);
		//blue button
		blueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.blue();
			}
		});
		
		JButton greenButton = new JButton(iconG);
		//green button
		greenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.green();
			}
		});
		blackButton.setPreferredSize(new Dimension(16, 16));
		magentaButton.setPreferredSize(new Dimension(16, 16));
		redButton.setPreferredSize(new Dimension(16, 16));
		blueButton.setPreferredSize(new Dimension(16, 16));
		greenButton.setPreferredSize(new Dimension(16,16));
		//sets the sizes of the buttons
		
		panel.add(greenButton);
		panel.add(blueButton);
		panel.add(magentaButton);
		panel.add(blackButton);
		panel.add(redButton);
		panel.add(clearButton);
		//adds the buttons to the panel
		
		content.add(panel, BorderLayout.WEST);
		//sets the panel to the left
		
		frame.setSize(300, 300);
		//sets the size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//makes it so you can close
		frame.setVisible(true);
		//makes it so you can see it
	}

}
