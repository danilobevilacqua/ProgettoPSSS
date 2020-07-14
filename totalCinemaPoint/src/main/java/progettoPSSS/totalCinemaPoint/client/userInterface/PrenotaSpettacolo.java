package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledDocument;

import progettoPSSS.totalCinemaPoint.client.businessLogic.ControllerCliente;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

@SuppressWarnings("all")
public class PrenotaSpettacolo extends JFrame {
	
	private JPanel contentPane;
	private static String titolo = "TOTAL CINEMA POINT - Prenota Spettacolo";
	private static Map<String,String> mappa;
	private int size = 10;
	private JButton[][] buttons = new JButton[size][size];
	private static Set<String>postiPrenotati= new HashSet<String>();
	private static Set<String>postiCovid= new HashSet<String>();	
	private String sala;
	private JTextArea postiTextArea;
	private static Point p = new Point();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrenotaSpettacolo frame = new PrenotaSpettacolo(p,mappa);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrenotaSpettacolo(final Point p, Map<String, String> mappa) {
		super(titolo);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 721);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		if(p != null) {
			setLocation(p);
		}else {
			setLocationRelativeTo(null);
		}	
		
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/LOGO.png"));	
		setIconImage(imgIco.getImage());

		final JButton confermaButton = new JButton("Conferma");
		confermaButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confermaButton.setBounds(926, 620, 141, 49);
		contentPane.add(confermaButton);
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confermaButton.setEnabled(false);

		JButton indietroButton = new JButton("Indietro");
		indietroButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		indietroButton.setBounds(50, 620, 141, 49);
		contentPane.add(indietroButton);
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(999, 230, 71, 280);
		contentPane.add(scrollPane);

		postiTextArea = new JTextArea();
		postiTextArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(postiTextArea);
		postiTextArea.setEditable(false);
		
		ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/prenotaspettacolo.jpg"));


		sala = ControllerCliente.getNomeSala();

		//LOGICA
		for ( int i = 0; i < size; i++) {
			for ( int j = 0; j < size; j++) {
				buttons[i][j] = new JButton(sala+" "+(i+1+j*10));
				buttons[i][j].setBounds(220+i*71, 125+j*38, 69, 36);
				buttons[i][j].setBackground(Color.green);
				contentPane.add(buttons[i][j]);
				if(mappa.containsKey(buttons[i][j].getText()) && mappa.get(buttons[i][j].getText()).equals("prenotato")) {
					buttons[i][j].setEnabled(false);
					buttons[i][j].setBackground(Color.red);
				}
				else if(mappa.containsKey(buttons[i][j].getText()) && mappa.get(buttons[i][j].getText()).equals("covid")) {
					buttons[i][j].setEnabled(false);
					buttons[i][j].setBackground(Color.yellow);
				}
				else {
					final int index = i;
					final int jndex = j;
					buttons[i][j].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							if(buttons[index][jndex].getBackground().equals(Color.green) || buttons[index][jndex].getBackground().equals(Color.yellow)) {
								setColorButton(buttons, index, jndex);								
								setPostiTextArea();
								enableConfermaButton(confermaButton);
							}else {
								cancellazionePrenotazionePosto(index, jndex);
								setPostiTextArea();
								enableConfermaButton(confermaButton);								
							}			

						}});
				}
			}
		}

		JLabel sfondoLabel = new JLabel("");		
		sfondoLabel.setIcon(img);
		sfondoLabel.setBounds(0, 0, 1117, 686);

		contentPane.add(sfondoLabel);

		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map <String,String> mappaPosti = new HashMap<String, String>();

				for(String s : postiPrenotati) {
					mappaPosti.put(s, "prenotato");
				}
				for(String s : postiCovid) {
					mappaPosti.put(s, "covid");
				}

				postiPrenotati.clear();
				postiCovid.clear();				
				RiepilogoConPagamento rcp = new RiepilogoConPagamento(getLocation(), mappaPosti);
				rcp.setVisible(true);
				dispose();
			}
		});



		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SceltaSpettacolo s = new SceltaSpettacolo(getLocation());
				s.setVisible(true);
				dispose();
			}
		});


	}

	private void setColorButton(JButton[][] buttons, int index, int jndex) {

		if(buttons[index][jndex].getBackground().equals(Color.yellow) ) {
			boolean flag = postiCovid.remove(buttons[index][jndex].getText());
		}

		buttons[index][jndex].setBackground(Color.blue);
		buttons[index][jndex].setForeground(Color.white);
		postiPrenotati.add(buttons[index][jndex].getText());


		if (index == 0 && jndex > 0 && jndex< size -1) {
			//non deve settare il posto a sinistra 	
			setColorCloseButton(index+1,jndex);
			setColorCloseButton(index,jndex-1);
			setColorCloseButton(index,jndex+1);
		}
		else if (index == 0 && jndex == 0) {
			//non deve settare il posto a sinistra e quello sopra
			setColorCloseButton(index+1,jndex);
			setColorCloseButton(index,jndex+1);
		}
		else if(index == 0 && jndex == size-1){
			//non deve settare il posto a sinistra e quello dietro
			setColorCloseButton(index+1,jndex);
			setColorCloseButton(index,jndex-1);
		}
		else if(index == size-1 && jndex > 0 && jndex < size-1) {
			//non deve settare il posto a destra
			setColorCloseButton(index-1,jndex);
			setColorCloseButton(index,jndex-1);
			setColorCloseButton(index,jndex+1);
		}
		else if(index == size-1 && jndex == 0) {
			//non deve settare il posto di sopra e a destra								
			setColorCloseButton(index-1,jndex);
			setColorCloseButton(index,jndex+1);
		}
		else if(index == size-1 && jndex == size-1) {
			//non deve settare il posto di dietro e a destra
			setColorCloseButton(index-1,jndex);
			setColorCloseButton(index,jndex-1);								
		}
		else if (jndex == 0 && index > 0 && index < size-1 ) {
			//non deve settare il posto avanti
			setColorCloseButton(index-1,jndex);
			setColorCloseButton(index+1,jndex);							
			setColorCloseButton(index,jndex+1);
		}
		else if(jndex == size-1 && index > 0 && index < size-1) {
			//non deve settare il posto dietro
			setColorCloseButton(index-1,jndex);
			setColorCloseButton(index+1,jndex);
			setColorCloseButton(index,jndex-1);								
		}else {
			//setta tutti i posti
			setColorCloseButton(index-1,jndex);
			setColorCloseButton(index+1,jndex);
			setColorCloseButton(index,jndex-1);
			setColorCloseButton(index,jndex+1);
		}

	}

	private void setColorCloseButton(int index, int jndex) {
		if(!buttons[index][jndex].getBackground().equals(Color.blue) && buttons[index][jndex].isEnabled()) {
			buttons[index][jndex].setBackground(Color.yellow);
			postiCovid.add(buttons[index][jndex].getText());
		}
	}

	private void cancellazionePrenotazionePosto(int index, int jndex) {
		postiPrenotati.remove(buttons[index][jndex].getText());
		postiCovid.clear();
		buttons[index][jndex].setForeground(Color.black);
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

	private void setPostiTextArea() {
		String postiOccupati=" ";
		List<Integer> sortedList = new ArrayList<Integer>();
		for(String s : postiPrenotati) {
			sortedList.add((Integer.parseInt(s.split(" ")[1]))); 
		}
		Collections.sort(sortedList);
		for(int s : sortedList) {
			postiOccupati = postiOccupati+sala+" "+s+"\n "; 
		}
		postiTextArea.removeAll();
		postiTextArea.setText(postiOccupati);
	}

	private void enableConfermaButton(JButton confermaButton) {
		if(postiPrenotati.size()>0) {
			confermaButton.setEnabled(true);
		}else {
			confermaButton.setEnabled(false);
		}
	}
}


