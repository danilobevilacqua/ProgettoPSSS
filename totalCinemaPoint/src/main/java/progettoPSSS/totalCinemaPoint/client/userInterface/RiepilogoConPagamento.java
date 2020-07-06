package progettoPSSS.totalCinemaPoint.client.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class RiepilogoConPagamento extends JFrame {

	private JPanel contentPane;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 721);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel sfondoLabel = new JLabel("");
		ImageIcon img = new ImageIcon(getClass().getResource("/progettoPSSS/totalCinemaPoint/client/images/riepilogoConPagamento.jpg"));		
		
		final JLabel linkLabel = new JLabel("<HTML><U>RISELEZIONA I POSTI</U></HTML>");
		linkLabel.setForeground(Color.RED);
		linkLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		linkLabel.setBounds(738, 517, 202, 31);
		contentPane.add(linkLabel);
		linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		linkLabel.setVisible(false);
		
		
		final JLabel erroreLabel = new JLabel("TI HANNO FOTTUTO IL POSTO");
		erroreLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		erroreLabel.setForeground(Color.RED);
		erroreLabel.setBounds(432, 517, 281, 31);
		contentPane.add(erroreLabel);
		erroreLabel.setVisible(false);
		
		JLabel importoLabel = new JLabel("New label");
		importoLabel.setForeground(Color.WHITE);
		importoLabel.setBounds(926, 436, 71, 43);
		contentPane.add(importoLabel);
		
		JButton accessButton = new JButton("Conferma");
		accessButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		accessButton.setBounds(926, 620, 141, 49);
		contentPane.add(accessButton);
		accessButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sfondoLabel.setIcon(img);
		sfondoLabel.setBounds(0, 0, 1117, 686);
		contentPane.add(sfondoLabel);
		
		final Double prezzo = ControllerClientSingleton.calcolaImporto(mappaPosti);
		importoLabel.setText(prezzo.toString());
		
		accessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ControllerClientSingleton.prenota(mappaPosti, prezzo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					erroreLabel.setVisible(true);
					linkLabel.setVisible(true);
				} 
			}
		});
		
		
		
		linkLabel.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e)  
		    {
		    	String [] filmInfo = ControllerClientSingleton.getDatiFilm().split("\n");
		    	System.out.println(filmInfo[0]);
		    	ControllerClientSingleton.getSpettacoliDate(filmInfo[0]);
		    	Map<String,String> mappa = ControllerClientSingleton.getPosti(ControllerClientSingleton.getDataSpettacoloSelezionato(), ControllerClientSingleton.getOraSpettacoloSelezionato());
				PrenotaSpettacolo ps = new PrenotaSpettacolo(mappa);
				ps.setVisible(true);
				dispose();
		    }  
		});
		
		
		
	}
}
