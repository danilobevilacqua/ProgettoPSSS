package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import progettoPSSS.totalCinemaPoint.client.businessLogic.ControllerClientSingleton;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;

@SuppressWarnings("all")
public class SceltaSpettacolo extends JFrame {

	private JPanel contentPane;
	private String oraSelezionata;
	private String dataSelezionata;
	private String filmSelezionato;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaSpettacolo frame = new SceltaSpettacolo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SceltaSpettacolo() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 721);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(288, 65, 501, 341);
		contentPane.add(textArea);*/

		final JComboBox <String> filmComboBox  = new JComboBox<String>();
		filmComboBox.setBounds(140, 50, 270, 40);
		contentPane.add(filmComboBox);
		filmComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		final JComboBox dataComboBox = new JComboBox();
		dataComboBox.setBounds(500, 50, 100, 40);
		contentPane.add(dataComboBox);
		dataComboBox.setEnabled(false);
		dataComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		final JComboBox oraComboBox = new JComboBox();
		oraComboBox.setBounds(690, 50, 100, 40);
		contentPane.add(oraComboBox);
		oraComboBox.setEnabled(false);
		oraComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel filmLabel = new JLabel("FILM");
		filmLabel.setForeground(Color.WHITE);
		filmLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		filmLabel.setBounds(75, 50, 60, 40);
		contentPane.add(filmLabel);
		
		JLabel dataLabel = new JLabel("DATA");
		dataLabel.setForeground(Color.WHITE);
		dataLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		dataLabel.setBounds(430, 50, 60, 40);
		contentPane.add(dataLabel);
	
		JLabel oraLabel = new JLabel("ORA");
		oraLabel.setForeground(Color.WHITE);
		oraLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		oraLabel.setBounds(620, 50, 60, 40);
		contentPane.add(oraLabel);
		
		final JButton confermaButton = new JButton("Conferma");
		confermaButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confermaButton.setBounds(926, 620, 141, 49);
		contentPane.add(confermaButton);
		confermaButton.setEnabled(false);
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		indietroButton.setBounds(50, 620, 141, 49);
		contentPane.add(indietroButton);
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel erroreLabel = new JLabel("Ci sono problemi di linea, Controlla la tua connessione!");
		erroreLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		erroreLabel.setForeground(Color.RED);
		erroreLabel.setBounds(142, 419, 737, 36);
		contentPane.add(erroreLabel);
		erroreLabel.setVisible(false);
		
		JLabel sfondoLabel = new JLabel("New label");
		ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/menucliente.jpg"));		
		sfondoLabel.setIcon(img);
		sfondoLabel.setBounds(0, 0, 1117, 686);
		contentPane.add(sfondoLabel);
		
		/*JTextPane textPane = new JTextPane();
		textPane.setBounds(140, 162, 270, 40);
		contentPane.add(textPane);*/


		//LOGICA
		try {
			String titoliFilm = ControllerClientSingleton.getFilmTitles();
		//	textArea.setText(titoliFilm);

			if(!titoliFilm.isEmpty()) {	
				filmComboBox.addItem("");
				for (String s : titoliFilm.split("\n")) {
					filmComboBox.addItem(s);
				}				
			}
			filmComboBox.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					dataComboBox.removeAllItems();
					dataComboBox.addItem("");
					dataComboBox.setEnabled(false);
					filmSelezionato = ((String)filmComboBox.getSelectedItem());
					if((filmSelezionato!= null) && (!filmSelezionato.isEmpty())) {
						Set<String> date = ControllerClientSingleton.getSpettacoliDate((String)filmComboBox.getSelectedItem());
						if(!date.isEmpty()) {
							for (String s : date) {
								dataComboBox.addItem(s);
							}
							dataComboBox.setEnabled(true);
						}
					}
				}
			});

			dataComboBox.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					oraComboBox.removeAllItems();
					oraComboBox.addItem("");
					oraComboBox.setEnabled(false);
					dataSelezionata = ((String)dataComboBox.getSelectedItem());
					if((dataSelezionata!=null)&&(!dataSelezionata.isEmpty())) {
						List<String> orari = ControllerClientSingleton.getSpettacoliOrari((String)dataComboBox.getSelectedItem());
						if(!orari.isEmpty()) {
							for (String s : orari) {
								oraComboBox.addItem(s);
							}		
							oraComboBox.setEnabled(true);
						}						
					}
				}
			});

			oraComboBox.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					confermaButton.setEnabled(false);
					oraSelezionata = ((String)oraComboBox.getSelectedItem());
					if((oraSelezionata != null) && (!oraSelezionata.isEmpty())) {	
						confermaButton.setEnabled(true);
					}						
				}
			});

		} catch (Exception e) {
			erroreLabel.setVisible(true);
			e.printStackTrace();
		}

		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String,String> mappa = ControllerClientSingleton.getPosti(dataSelezionata, oraSelezionata);
				PrenotaSpettacolo ps = new PrenotaSpettacolo(mappa);
				ps.setVisible(true);
				dispose();
			}
		});
		
		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuCliente m = new MenuCliente();
				m.setVisible(true);
				dispose();
			}
		});



	}
}
