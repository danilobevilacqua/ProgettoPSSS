package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import progettoPSSS.totalCinemaPoint.client.businessLogic.ControllerClientSingleton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class RiepilogoConPagamento extends JFrame {

	private JPanel contentPane;
	private static String titolo = "TOTAL CINEMA POINT - Riepilogo e Pagamento";
	private static Map<String,String> mappaPosti;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RiepilogoConPagamento frame = new RiepilogoConPagamento(mappaPosti);
					frame.setVisible(true);
					ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/LOGO.png"));	
					frame.setIconImage(img.getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RiepilogoConPagamento(final Map<String,String> mappaPosti) {
		super(titolo);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 721);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon img2 = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/riepilogoprenotazione.png")); 

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(445, 437, 294, 80);
		contentPane.add(scrollPane);

		JTextArea postiArea = new JTextArea();
		postiArea.setLineWrap(true);
		scrollPane.setViewportView(postiArea);
		postiArea.setEditable(false);
		postiArea.setFont(new Font("Tahoma", Font.PLAIN, 20));

		final JButton indietroButton = new JButton("Indietro");
		indietroButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		indietroButton.setBounds(50, 620, 141, 49);
		contentPane.add(indietroButton);
		indietroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		final JButton confermaButton = new JButton("Conferma");
		confermaButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confermaButton.setBounds(926, 620, 141, 49);
		contentPane.add(confermaButton);
		confermaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


		JLabel userLabel = new JLabel("New label");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userLabel.setBounds(450, 195, 238, 22);
		contentPane.add(userLabel);

		JLabel nomeLabel = new JLabel("New label");
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeLabel.setBounds(450, 224, 238, 22);
		contentPane.add(nomeLabel);

		JLabel cognomeLabel = new JLabel("New label");
		cognomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cognomeLabel.setBounds(450, 250, 251, 22);
		contentPane.add(cognomeLabel);

		JLabel titoloLabel = new JLabel("New label");
		titoloLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titoloLabel.setBounds(450, 303, 238, 22);
		contentPane.add(titoloLabel);

		JLabel dataLabel = new JLabel("New label");
		dataLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dataLabel.setBounds(450, 327, 238, 27);
		contentPane.add(dataLabel);

		JLabel oraLabel = new JLabel("New label");
		oraLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oraLabel.setBounds(450, 356, 238, 22);
		contentPane.add(oraLabel);

		JLabel salaLabel = new JLabel("");
		salaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salaLabel.setBounds(450, 413, 238, 22);
		contentPane.add(salaLabel);

		JLabel importoLabel = new JLabel("New label");
		importoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		importoLabel.setBounds(450, 547, 227, 22);
		contentPane.add(importoLabel);

		ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/riepilogoConPagamento.jpg"));		

		final Double prezzo = ControllerClientSingleton.calcolaImporto(mappaPosti);

		String[] datiUtenteSplit = ControllerClientSingleton.getDatiCliente().split("\n");

		userLabel.setText(datiUtenteSplit[0]);
		nomeLabel.setText(datiUtenteSplit[1]);
		cognomeLabel.setText(datiUtenteSplit[2]);

		titoloLabel.setText(ControllerClientSingleton.getDatiFilm().split("\n")[0]);
		String data = dataChange(ControllerClientSingleton.getDataSpettacoloSelezionato());
		dataLabel.setText(data);
		String ora = oraChange(ControllerClientSingleton.getOraSpettacoloSelezionato());
		oraLabel.setText(ora);

		String postiNumero="";
		List<Integer> posti = new ArrayList<Integer>();
		boolean flagSala = true;

		for(String s : mappaPosti.keySet()) {
			if(mappaPosti.get(s).equals("prenotato")) {
				posti.add(Integer.parseInt(s.split(" ")[1]));
				if(flagSala) {
					salaLabel.setText(s.split(" ")[0]);
					flagSala = false;
				}
			}
		}

		Collections.sort(posti);

		for(int i : posti) {
			postiNumero = postiNumero+i+" ";			
		}

		importoLabel.setText(Double.toString(ControllerClientSingleton.calcolaImporto(mappaPosti)));
		JLabel riepilogoLabel = new JLabel("");
		riepilogoLabel.setBounds(265, 31, 545, 626);
		riepilogoLabel.setIcon(img2);
		contentPane.add(riepilogoLabel);
		
		postiArea.setText(postiNumero);
		
		JLabel sfondoLabel = new JLabel("");
		sfondoLabel.setIcon(img);
		sfondoLabel.setBounds(0, 0, 1117, 686);
		contentPane.add(sfondoLabel);

		confermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int codice = ControllerClientSingleton.prenota(mappaPosti, prezzo);			
					confermaButton.setEnabled(false);
					indietroButton.setEnabled(false);

					JOptionPane.showMessageDialog(null, "Prenotazione effettuata con successo! \n Il codice della prenotazione è: "+codice, "Avviso", JOptionPane.INFORMATION_MESSAGE);

					MenuCliente mc = new MenuCliente();
					mc.setVisible(true);
					dispose();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					confermaButton.setEnabled(false);
					indietroButton.setEnabled(false);
					tornaSceltaPosto(false);
				} 
			}
		});

		indietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tornaSceltaPosto(true);
			}
		});		

	}

	private void tornaSceltaPosto(boolean indietroFlag) {

		String [] filmInfo = ControllerClientSingleton.getDatiFilm().split("\n");
		ControllerClientSingleton.getSpettacoliDate(filmInfo[0]);
		Map<String, String> mappa;
		try {

			mappa = ControllerClientSingleton.getPosti(ControllerClientSingleton.getDataSpettacoloSelezionato(), ControllerClientSingleton.getOraSpettacoloSelezionato());
			if(!indietroFlag) {
				JOptionPane.showMessageDialog(null, "Uno o più dei posti scelti risulta essere stato occupato!", "Avviso", JOptionPane.ERROR_MESSAGE);
			}
			PrenotaSpettacolo ps = new PrenotaSpettacolo(mappa);
			ps.setVisible(true);
			dispose();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Gli ultimi posti sono stati occupati \n prima della tua prenotazione!", "Avviso", JOptionPane.ERROR_MESSAGE);
			SceltaSpettacolo sc = new SceltaSpettacolo();
			sc.setVisible(true);
			dispose();
		}

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
}
