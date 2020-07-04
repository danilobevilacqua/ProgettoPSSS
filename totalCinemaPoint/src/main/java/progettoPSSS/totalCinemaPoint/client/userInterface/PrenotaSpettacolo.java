package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PrenotaSpettacolo extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrenotaSpettacolo frame = new PrenotaSpettacolo();
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
	public PrenotaSpettacolo() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 721);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int size = 10;
		final JButton[][] buttons = new JButton[size][size];

		for ( int i = 0; i < size; i++) {
			for ( int j = 0; j < size; j++) {
				buttons[i][j] = new JButton("A "+(i+1+j*10));
				buttons[i][j].setBounds(58+i*77, 200+j*42, 75, 40);
				buttons[i][j].setBackground(Color.green);
				contentPane.add(buttons[i][j]);
				final int index = i;
				final int jndex = j;
				buttons[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(buttons[index][jndex].getBackground().equals(Color.green) || buttons[index][jndex].getBackground().equals(Color.yellow)) {
							buttons[index][jndex].setBackground(Color.red);
							if(!buttons[index-1][jndex].getBackground().equals(Color.red)) {
								buttons[index-1][jndex].setBackground(Color.yellow);
							}
							if(!buttons[index+1][jndex].getBackground().equals(Color.red)) {
								buttons[index+1][jndex].setBackground(Color.yellow);
							}
							if(!buttons[index][jndex-1].getBackground().equals(Color.red)) {
								buttons[index][jndex-1].setBackground(Color.yellow);
							}
							if(!buttons[index][jndex+1].getBackground().equals(Color.red)) {
								buttons[index][jndex+1].setBackground(Color.yellow);
							}
						}else {
							buttons[index][jndex].setBackground(Color.green);
						}			

					}});
			}
		}
	}

}

/*
	private void inizialize() {
		posti = new JPanel();
		posti.setLayout(new GridLayout(size, size));
		for(int i=0 ; i<5; i++) {
			for(int j=0;j<5; j++) {
				buttonMatrix[i][j]=new JButton();
				buttonMatrix[i][j].setBackground(new Color(20+i*2,2*40+j,255-i*10));
				buttonMatrix[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {}});

				buttonMatrix[i][j].setSize(20,20);
				posti.add(buttonMatrix[i][j]);
			}
		}
		validate();
	}*/
/*
	//@Override
	public void actionPerformed(ActionEvent ae) {
		for(int i=0 ; i<5; i++) {
			for(int j=0;j<5; j++) {
				if(ae.getSource()==buttonMatrix[i][j]) {
					buttonMatrix[i][j].setBackground(Color.red);
				}
			}
		}
	}
 */



