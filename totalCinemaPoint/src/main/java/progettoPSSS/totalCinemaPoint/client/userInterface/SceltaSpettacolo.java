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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;

@SuppressWarnings("all")
public class SceltaSpettacolo extends JFrame {

	private JPanel contentPane;
	private static String titolo = "TOTAL CINEMA POINT - Scelta Spettacolo";
	private String oraSelezionata;
	private String dataSelezionata;
	private String filmSelezionato;
	private List<String> orari;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaSpettacolo frame = new SceltaSpettacolo();
					frame.setVisible(true);
					ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/LOGO.png"));	
					frame.setIconImage(img.getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SceltaSpettacolo() {
		super(titolo);
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


		final JLabel locandinaLabel = new JLabel("");
		locandinaLabel.setBounds(791, 175, 300, 400);
		contentPane.add(locandinaLabel);

		final JLabel titoloLabel = new JLabel("");
		titoloLabel.setOpaque(false);
		titoloLabel.setBackground(Color.WHITE);
		titoloLabel.setForeground(Color.BLACK);
		titoloLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		titoloLabel.setBounds(462, 175, 305, 40);
		contentPane.add(titoloLabel);

		final JLabel titolo2Label = new JLabel("Titolo:");
		titolo2Label.setForeground(Color.BLACK);
		titolo2Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titolo2Label.setBounds(462, 139, 157, 40);
		contentPane.add(titolo2Label);
		titolo2Label.setVisible(false);

		final JLabel anno2Label = new JLabel("Anno:");
		anno2Label.setForeground(Color.BLACK);
		anno2Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		anno2Label.setBounds(462, 223, 88, 29);
		contentPane.add(anno2Label);
		anno2Label.setVisible(false);

		final JLabel annoLabel = new JLabel("");
		annoLabel.setForeground(Color.BLACK);
		annoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		annoLabel.setBounds(462, 252, 252, 40);
		contentPane.add(annoLabel);

		final JLabel regista2Label = new JLabel("Regista: ");
		regista2Label.setForeground(Color.BLACK);
		regista2Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regista2Label.setBounds(462, 338, 162, 29);
		contentPane.add(regista2Label);
		regista2Label.setVisible(false);

		final JLabel registaLabel = new JLabel("");
		registaLabel.setForeground(Color.BLACK);
		registaLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		registaLabel.setBounds(462, 370, 252, 34);
		contentPane.add(registaLabel);

		final JLabel descrizione2Label = new JLabel("Descrizione:");
		descrizione2Label.setForeground(Color.BLACK);
		descrizione2Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		descrizione2Label.setBounds(462, 413, 123, 29);
		contentPane.add(descrizione2Label);
		descrizione2Label.setVisible(false);

		final JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 20));
		textArea.setBounds(462, 451, 317, 134);
		textArea.setOpaque(false);
		textArea.setBackground(new Color(0,0,0,0));
		textArea.setLineWrap(true);
		contentPane.add(textArea);

		final JLabel prezzo2Label = new JLabel("Prezzo: ");
		prezzo2Label.setForeground(Color.BLACK);
		prezzo2Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prezzo2Label.setBounds(462, 590, 71, 29);
		prezzo2Label.setVisible(false);
		contentPane.add(prezzo2Label);

		final JLabel prezzoLabel = new JLabel("");
		prezzoLabel.setForeground(Color.BLACK);
		prezzoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		prezzoLabel.setBounds(545, 590, 105, 29);
		contentPane.add(prezzoLabel);

		JLabel sfondoLabel = new JLabel("");
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

						String[] datiFilmSplit = ControllerClientSingleton.getDatiFilm().split("\n");
						titoloLabel.setText(datiFilmSplit[0]);
						annoLabel.setText(datiFilmSplit[1]);
						registaLabel.setText(datiFilmSplit[2]);
						textArea.setText(datiFilmSplit[3]);
						prezzoLabel.setText(Double.toString(ControllerClientSingleton.getPrezzoSpettacolo())+" €");
						locandinaLabel.setIcon(getLocandinaImage(ControllerClientSingleton.getLocandinaFilm(), locandinaLabel.getHeight(), locandinaLabel.getWidth()));
						titolo2Label.setVisible(true);						
						anno2Label.setVisible(true);
						regista2Label.setVisible(true);
						descrizione2Label.setVisible(true);
						prezzo2Label.setVisible(true);

						if(!date.isEmpty()) {
							for (String s : date) {								
								String data = dataChange(s);
								dataComboBox.addItem(data);
							}
							dataComboBox.setEnabled(true);
						}
					}else {
						titoloLabel.setText("");
						annoLabel.setText("");
						registaLabel.setText("");
						textArea.setText("");
						prezzoLabel.setText("");
						locandinaLabel.setVisible(false);
						titolo2Label.setVisible(false);
						anno2Label.setVisible(false);
						regista2Label.setVisible(false);
						descrizione2Label.setVisible(false);
						prezzo2Label.setVisible(false);
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
						orari = ControllerClientSingleton.getSpettacoliOrari(dataSelezionata);
						if(!orari.isEmpty()) {
							for (String s : orari) {
								String oraFormatted = oraChange(s);
								oraComboBox.addItem(oraFormatted);
							}		
							oraComboBox.setEnabled(true);
						}						
					}
				}
			});

			oraComboBox.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					confermaButton.setEnabled(false);
					String oraSelezionataCb = (String) oraComboBox.getSelectedItem();
					if((oraSelezionataCb != null) && (!oraSelezionataCb.equals("--ORA--"))) {
						oraSelezionata = orari.get(oraComboBox.getSelectedIndex()-1);
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

	private String oraChange(String ora) {

		String oraReturn="";
		String[] split = ora.split(":");
		oraReturn = split[0]+":"+split[1];
		return oraReturn;
	}

	private ImageIcon getLocandinaImage(byte[] locandina, int height, int width) {
		ByteArrayInputStream bis = new ByteArrayInputStream(locandina);
		BufferedImage bImage2;
		ImageIcon image2= null;
		try {
			bImage2 = ImageIO.read(bis);
			Image image = new ImageIcon(bImage2).getImage();	
			//Image newImage = image.getScaledInstance(height, width, Image.SCALE_SMOOTH);
			image2 = new ImageIcon(image);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return image2;
	}
}
