package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.util.ArrayList;
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
import javax.swing.JOptionPane;
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

		final JComboBox <String> filmComboBox  = new JComboBox<String>();
		filmComboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		filmComboBox.setBounds(100, 50, 350, 40);
		contentPane.add(filmComboBox);
		filmComboBox.addItem("--FILM--");
		filmComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		final JComboBox dataComboBox = new JComboBox();
		dataComboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dataComboBox.setBounds(500, 50, 150, 40);
		contentPane.add(dataComboBox);
		dataComboBox.setEnabled(false);
		dataComboBox.addItem("--DATA--");
		dataComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		final JComboBox oraComboBox = new JComboBox();
		oraComboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oraComboBox.setBounds(700, 50, 100, 40);
		contentPane.add(oraComboBox);
		oraComboBox.setEnabled(false);
		oraComboBox.addItem("--ORA--");
		oraComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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
		ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/menucliente.jpg"));		

		JLabel lblNewLabel = new JLabel("");
		ImageIcon img2 = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/sunset.gif"));		
		lblNewLabel.setIcon(img2);
		lblNewLabel.setBounds(868, 211, 212, 224);
		contentPane.add(lblNewLabel);

		JLabel sfondoLabel = new JLabel("New label");
		sfondoLabel.setIcon(img);
		sfondoLabel.setBounds(0, 0, 1117, 686);
		contentPane.add(sfondoLabel);
		
		//LOGICA
		try {
			String titoliFilm = ControllerClientSingleton.getFilmTitles();

			if(!titoliFilm.isEmpty()) {	
				for (String s : titoliFilm.split("\n")) {
					filmComboBox.addItem(s);
				}				
			}
			filmComboBox.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					dataComboBox.removeAllItems();
					dataComboBox.addItem("--DATA--");
					dataComboBox.setEnabled(false);
					filmSelezionato = ((String)filmComboBox.getSelectedItem());
					if((filmSelezionato!= null) && (!filmSelezionato.equals("--FILM--"))) {
						Set<String> date = ControllerClientSingleton.getSpettacoliDate((String)filmComboBox.getSelectedItem());
						if(!date.isEmpty()) {
							for (String s : date) {								
								String data = dataChange(s);
								dataComboBox.addItem(data);
							}
							dataComboBox.setEnabled(true);
						}
					}
				}
			});

			dataComboBox.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					oraComboBox.removeAllItems();
					oraComboBox.addItem("--ORA--");
					oraComboBox.setEnabled(false);
					String dataSelezionataCb = ((String)dataComboBox.getSelectedItem());
					System.out.println();
					if((dataSelezionataCb!=null)&&(!dataSelezionataCb.equals("--DATA--"))) {
						dataSelezionata = dataChange(dataSelezionataCb);
						 List<String> orari = ControllerClientSingleton.getSpettacoliOrari(dataSelezionata);
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
					oraSelezionata = (String) oraComboBox.getSelectedItem();
					if((oraSelezionata != null) && (!oraSelezionata.equals("--ORA--"))) {	
						confermaButton.setEnabled(true);
					}						
				}
			});

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Si sono verificati problemi di linea! \n Controlla la tua connessione", "Avviso", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, String> mappa;
				try {
					mappa = ControllerClientSingleton.getPosti(dataSelezionata, oraSelezionata);
					PrenotaSpettacolo ps = new PrenotaSpettacolo(mappa);
					ps.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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

	private String dataChange(String data) {
		String dataReturn ="";

		String[] split = data.split("-");
		dataReturn = split[2]+"-"+split[1]+"-"+split[0];

		return dataReturn;
	}

}
