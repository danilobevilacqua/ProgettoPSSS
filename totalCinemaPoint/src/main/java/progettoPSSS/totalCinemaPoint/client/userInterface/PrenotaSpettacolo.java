package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

@SuppressWarnings("all")
public class PrenotaSpettacolo extends JFrame {

	private JPanel contentPane;
	private int size = 10;
	private JButton[][] buttons = new JButton[size][size];
	private Set<String>postiPrenotati= new HashSet<String>();
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

							setColorButton(buttons, index, jndex);

						}else {
							cancellazionePrenotazionePosto(index, jndex);							
						}			

					}});
			}
		}


	}

	private void setColorButton(JButton[][] buttons, int index, int jndex) {

		buttons[index][jndex].setBackground(Color.red);
		postiPrenotati.add(buttons[index][jndex].getText());

		if (index == 0 && jndex > 0 && jndex< size -1) {
			//non deve settare il posto a sinistra 	
			if(!buttons[index+1][jndex].getBackground().equals(Color.red)) {
				buttons[index+1][jndex].setBackground(Color.yellow);
			}
			if(!buttons[index][jndex-1].getBackground().equals(Color.red)) {
				buttons[index][jndex-1].setBackground(Color.yellow);
			}
			if(!buttons[index][jndex+1].getBackground().equals(Color.red)) {
				buttons[index][jndex+1].setBackground(Color.yellow);
			}
		}
		else if (index == 0 && jndex == 0) {
			//non deve settare il posto a sinistra e quello sopra
			if(!buttons[index+1][jndex].getBackground().equals(Color.red)) {
				buttons[index+1][jndex].setBackground(Color.yellow);
			}
			if(!buttons[index][jndex+1].getBackground().equals(Color.red)) {
				buttons[index][jndex+1].setBackground(Color.yellow);
			}
		}
		else if(index == 0 && jndex == size-1){
			//non deve settare il posto a sinistra e quello dietro
			if(!buttons[index+1][jndex].getBackground().equals(Color.red)) {
				buttons[index+1][jndex].setBackground(Color.yellow);
			}
			if(!buttons[index][jndex-1].getBackground().equals(Color.red)) {
				buttons[index][jndex-1].setBackground(Color.yellow);
			}
		}
		else if(index == size-1 && jndex > 0 && jndex < size-1) {
			//non deve settare il posto a destra
			if(!buttons[index-1][jndex].getBackground().equals(Color.red)) {
				buttons[index-1][jndex].setBackground(Color.yellow);
			}
			if(!buttons[index][jndex-1].getBackground().equals(Color.red)) {
				buttons[index][jndex-1].setBackground(Color.yellow);
			}
			if(!buttons[index][jndex+1].getBackground().equals(Color.red)) {
				buttons[index][jndex+1].setBackground(Color.yellow);
			}
		}
		else if(index == size-1 && jndex == 0) {
			//non deve settare il posto di sopra e a destra								
			if(!buttons[index-1][jndex].getBackground().equals(Color.red)) {
				buttons[index-1][jndex].setBackground(Color.yellow);
			}
			if(!buttons[index][jndex+1].getBackground().equals(Color.red)) {
				buttons[index][jndex+1].setBackground(Color.yellow);
			}
		}
		else if(index == size-1 && jndex == size-1) {
			//non deve settare il posto di dietro e a destra
			if(!buttons[index-1][jndex].getBackground().equals(Color.red)) {
				buttons[index-1][jndex].setBackground(Color.yellow);
			}
			if(!buttons[index][jndex-1].getBackground().equals(Color.red)) {
				buttons[index][jndex-1].setBackground(Color.yellow);
			}								
		}
		else if (jndex == 0 && index > 0 && index < size-1 ) {
			//non deve settare il posto avanti
			if(!buttons[index-1][jndex].getBackground().equals(Color.red)) {
				buttons[index-1][jndex].setBackground(Color.yellow);
			}
			if(!buttons[index+1][jndex].getBackground().equals(Color.red)) {
				buttons[index+1][jndex].setBackground(Color.yellow);
			}								
			if(!buttons[index][jndex+1].getBackground().equals(Color.red)) {
				buttons[index][jndex+1].setBackground(Color.yellow);
			}
		}
		else if(jndex == size-1 && index > 0 && index < size-1) {
			if(!buttons[index-1][jndex].getBackground().equals(Color.red)) {
				buttons[index-1][jndex].setBackground(Color.yellow);
			}
			if(!buttons[index+1][jndex].getBackground().equals(Color.red)) {
				buttons[index+1][jndex].setBackground(Color.yellow);
			}
			if(!buttons[index][jndex-1].getBackground().equals(Color.red)) {
				buttons[index][jndex-1].setBackground(Color.yellow);
			}								
		}else {

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
		}

	}
	
	private void setColorCloseButton(int index, int jndex) {
		if(!buttons[index+1][jndex].getBackground().equals(Color.red)) {
			buttons[index+1][jndex].setBackground(Color.yellow);
		}
	}
	
	private void cancellazionePrenotazionePosto(int index, int jndex) {
		postiPrenotati.remove(buttons[index][jndex].getText());
		for ( int i = 0; i < size; i++) {
			for ( int j = 0; j < size; j++) {
				if(buttons[i][j].isEnabled()==true) {
					buttons[i][j].setBackground(Color.green);
				}
			}
		}

		for ( int i = 0; i < size; i++) {
			for ( int j = 0; j < size; j++) {
				if(postiPrenotati.contains(buttons[i][j].getText())) {
					setColorButton(buttons, i, j);
				}
			}
		}
	}

}

