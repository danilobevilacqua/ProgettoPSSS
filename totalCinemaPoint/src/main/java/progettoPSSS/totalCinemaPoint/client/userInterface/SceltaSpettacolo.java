package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.Color;
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
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(288, 65, 501, 341);
		contentPane.add(textArea);

		final JComboBox <String> filmComboBox  = new JComboBox<String>();
		filmComboBox.setBounds(142, 477, 272, 42);
		contentPane.add(filmComboBox);

		JLabel filmLabel = new JLabel("Nome Film");
		filmLabel.setBounds(12, 477, 159, 42);
		contentPane.add(filmLabel);

		JLabel dataLabel = new JLabel("Data");
		dataLabel.setBounds(461, 484, 71, 29);
		contentPane.add(dataLabel);

		final JComboBox dataComboBox = new JComboBox();
		dataComboBox.setBounds(525, 477, 104, 42);
		contentPane.add(dataComboBox);
		dataComboBox.setEnabled(false);

		final JComboBox oraComboBox = new JComboBox();
		oraComboBox.setBounds(775, 477, 104, 42);
		contentPane.add(oraComboBox);
		oraComboBox.setEnabled(false);

		JLabel oraLabel = new JLabel("ora");
		oraLabel.setBounds(681, 490, 56, 16);
		contentPane.add(oraLabel);

		final JButton confermaButton = new JButton("Conferma");
		confermaButton.setBounds(860, 587, 159, 72);
		contentPane.add(confermaButton);
		confermaButton.setEnabled(false);

		JLabel erroreLabel = new JLabel("Ci sono problemi di linea, Controlla la tua connessione!");
		erroreLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		erroreLabel.setForeground(Color.RED);
		erroreLabel.setBounds(142, 419, 737, 36);
		contentPane.add(erroreLabel);
		erroreLabel.setVisible(false);


		//LOGICA
		try {
			String titoliFilm = ControllerClientSingleton.getFilmTitles();
			textArea.setText(titoliFilm);

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



	}
}
