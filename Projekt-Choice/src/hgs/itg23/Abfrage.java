package hgs.itg23;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class Abfrage implements ActionListener {

	int i = 0;
	ImageIcon B1 = new ImageIcon("pac.png");
	ImageIcon B2 = new ImageIcon("wen.png");
	ImageIcon B3 = new ImageIcon("wa.png");
	ImageIcon B4 = new ImageIcon("cc.jpg");
	ImageIcon B5 = new ImageIcon("ll.jpg");
	ImageIcon B6 = new ImageIcon("nn.jpg");
	ImageIcon B7 = new ImageIcon("pac.png");
	
	
	String[] fragen = {			"Test1?",
								"Test?",
							    "Oder doch Test3?"
				      };
	
	String[][] moeglichkeiten = {
									{"ja","nein","vllt"},
									{"lol","ok","nein"},
									{"vv","bb","nn"}
								};
	
	String[] antworten = {
							"1",
							"2",
							"3",
							
					};
	
	ImageIcon[][] bilder  =  {		{B1,B3,B2,},
									{B2,B3,B1},
									{B3,B1,B2}
			
	};
	
	  String erraten;
	  String antwort;
	  int index;
	  int falscheantwort = 0;
	  int alle_fragen = fragen.length;
	  int ergebnis;
	  int sekunden = 10;
	  int sekunden_uebrig;
	  
	 
	 
	
	
	JFrame frame = new JFrame();
	JTextField textfeld = new JTextField();
	JTextArea textbereich = new JTextArea();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton resetbutton = new JButton("reset");
	JLabel resetbutton_label = new JLabel();
	JLabel Antwort1_label = new JLabel();
	JLabel Antwort2_label = new JLabel();
	JLabel Antwort3_label = new JLabel();
	JLabel zeit_label = new JLabel();
	JLabel rest_zeit = new JLabel();
	JTextField richtige_antworten = new JTextField();
	
	JLabel pic = new JLabel();
	JLabel Anzeige = new JLabel();
	
	public Abfrage() {
			
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920, 1080);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(true);
		frame.setBackground(Color.GREEN);
		
		
		
		textfeld.setBounds(155, 43, 650, 50);										//Höchste priorität
		textfeld.setBackground(Color.BLUE);										// Optional
		textfeld.setForeground(Color.WHITE);										// Optional
		textfeld.setFont(new Font("Ink Free", Font.BOLD,30));          				// WICHTIG! Ändern
		textfeld.setBorder(BorderFactory.createBevelBorder(1));						// So lassen
		textfeld.setHorizontalAlignment(textfeld.CENTER);							// Optional	
		textfeld.setEditable(false);												// So lassen90ßßßßßßßßßßßßßßßßß
		textfeld.setText("Test");													//	Ändern so bald fertig
										
		
		textbereich.setBounds(155, 93, 650, 50);	
		textbereich.setLineWrap(true);
		textbereich.setBackground(Color.BLUE);										
		textbereich.setForeground(Color.WHITE);										
		textbereich.setFont(new Font("Arial Black", Font.BOLD,30));          				
		textbereich.setBorder(BorderFactory.createBevelBorder(1));													
		textbereich.setEditable(false);											
		textbereich.setText("Test1");			
		
		
		button1.setBounds(200, 200, 500, 100); 										//ändern
		button1.setFont(new Font("Arial Black", Font.BOLD, 20)); 
		button1.setBackground(Color.BLUE);
		button1.setForeground(Color.WHITE);	
		button1.setFocusable(false);
		button1.addActionListener(this);
		button1.setText("1");
		
		
		button2.setBounds(200, 400, 500, 100); 										//ändern
		button2.setFont(new Font("Arial Black", Font.BOLD, 20)); 
		button2.setBackground(Color.BLUE);
		button2.setForeground(Color.WHITE);	
		button2.setFocusable(false);
		button2.addActionListener(this);
		button2.setText("2");
		
		button3.setBounds(200, 600, 500, 100); 										//ändern
		button3.setFont(new Font("Arial Black", Font.BOLD, 20)); 
		button3.setBackground(Color.BLUE);
		button3.setForeground(Color.WHITE);	
		button3.setFocusable(false);
		button3.addActionListener(this);
		button3.setText("3");
		
		resetbutton.setBounds(1640, 10, 250, 100); 										//ändern
		resetbutton.setFont(new Font("Arial Black", Font.BOLD, 20)); 
		resetbutton.setBackground(Color.BLUE);
		resetbutton.setForeground(Color.WHITE);	
		resetbutton.setFocusable(false);
		resetbutton.addActionListener(listener -> {

		      Antwort1_label.setText(moeglichkeiten[index][0]);
	            Antwort2_label.setText(moeglichkeiten[index][1]);
	            Antwort3_label.setText(moeglichkeiten[index][2]);
            index = 0;
            textfeld.setText("Frage " + (index + 1));
            i = 0;
            antwort = "";
            button3.setText("3");
            button2.setText("2");
            button1.setText("1");
            textbereich.setText("Test1");

        });
		resetbutton.setText("Reset");
		
		Antwort1_label.setBounds(440, 300, 500, 100);
		Antwort1_label.setBackground(Color.BLUE);
		Antwort1_label.setForeground(Color.WHITE);
		Antwort1_label.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		
		Antwort2_label.setBounds(430, 500, 500, 100);
		Antwort2_label.setBackground(Color.BLUE);
		Antwort2_label.setForeground(Color.WHITE);
		Antwort2_label.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		Antwort3_label.setBounds(430, 700, 500, 100);
		Antwort3_label.setBackground(Color.BLUE);
		Antwort3_label.setForeground(Color.WHITE);
		Antwort3_label.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		rest_zeit.setBounds(1200, 510, 100, 100);
		rest_zeit.setBackground(Color.BLACK);
		rest_zeit.setForeground(Color.BLUE);
		rest_zeit.setFont(new Font("Arial Black", Font.BOLD, 20));
		rest_zeit.setBorder(BorderFactory.createBevelBorder(1));
		rest_zeit.setText(String.valueOf(sekunden));
		rest_zeit.setHorizontalAlignment(rest_zeit.CENTER);
		
		
		
		
		
		richtige_antworten.setBounds(825, 225, 200, 100);
		richtige_antworten.setBackground(Color.BLUE);
		richtige_antworten.setForeground(Color.BLACK);
		richtige_antworten.setFont(new Font("Arial Black", Font.BOLD, 20));
		richtige_antworten.setBorder(BorderFactory.createBevelBorder(1));
		richtige_antworten.setHorizontalAlignment(richtige_antworten.CENTER); // JTextField.CENTER
		richtige_antworten.setEditable(false);
		
		pic.setBounds(950, 150, 500, 550);
		pic.setVisible(false);
		
		Anzeige.setBounds(1500, 10, 250, 100);
		frame.add(Anzeige);                                                               // Alex anschauen
		
		//frame.add(rest_zeit);
		frame.add(Antwort1_label);
		frame.add(Antwort2_label);
		frame.add(Antwort3_label);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(textbereich);
		frame.add(textfeld);
		frame.add(pic);
		frame.add(resetbutton);
        frame.add(resetbutton_label);
		frame.setVisible(true);
		
		
		
		
		N_Abfrage();
		
		}

	
		public void N_Abfrage() {
			
			if(index>= alle_fragen) {
				
				end();
				
			} 
			else {
				
				textfeld.setText("Frage "+ (index+1));
				textbereich.setText(fragen[index]);
				Antwort1_label.setText(moeglichkeiten[index][0]);
				Antwort2_label.setText(moeglichkeiten[index][1]);
				Antwort3_label.setText(moeglichkeiten[index][2]);
			}
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		
			button1.setEnabled(false);
			button2.setEnabled(false);
			button3.setEnabled(false);
			
			if(e.getSource()==button1) {
				
				antwort = "1";
							
			
			pic.setIcon(bilder[0][i]);
				
				
				
				
				if (antwort == antworten[index]) {
					
					falscheantwort++;
					
				}
				
				
				
			}
			
if(e.getSource()==button2) {
				
				antwort = "2";
				
				
				
				pic.setIcon(bilder[1][i]);		
						
				
				if (antwort == antworten[index]) {
					
					falscheantwort++;
					
				}
			}
if(e.getSource()==button3) {
	
	antwort = "3";
	
	
	
	
	pic.setIcon(bilder[2][i]);	
		
	
	if (antwort == antworten[index]) {
		
		falscheantwort++;
		
	}
}
		bild();
			
		}
		
		//g

		public void bild() {
			
			
			pic.setVisible(true);
			
			Timer m1 = new Timer(2000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource()==button1) {
						
						
					
						
					}
					pic.setVisible(false);
				}
			
			});
			
			
			
			pic.setVisible(true);
			
			Timer m2 = new Timer(2000, new ActionListener() {
			
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource()==button2) {
				
					
					
						
					}
					pic.setVisible(false);
					}		
				
			});
			
			m2.setRepeats(false);
			m2.start();
			
			
pic.setVisible(true);
			
			Timer m3 = new Timer(2000, new ActionListener() {
			
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource()==button3) {
				
					
					
						
						
					}
					pic.setVisible(false);
					}		
				
			});
			
			m3.setRepeats(false);
			m3.start();
				
				
		Anzeige();

		
		}


		
		public void Anzeige() {
			
			
			button1.setEnabled(false);
			button2.setEnabled(false);
			button3.setEnabled(false);
			
			Timer pause = new Timer(2000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
				i++;	
				index++;
				button1.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
				
				N_Abfrage();
					
				}
				
			});
			
			pause.setRepeats(false);
			pause.start();
			
			
		}
		
		
		public void end() {
			button1.setEnabled(false);
			button2.setEnabled(false);
			button3.setEnabled(false);
			
			ergebnis = (int)((falscheantwort/(double)alle_fragen)*100);
			
			textfeld.setText("Dein Ergebnis");
			textbereich.setText("");
			Antwort1_label.setText("");
			Antwort2_label.setText("");
			Antwort3_label.setText("");
			richtige_antworten.setText("("+falscheantwort+"/"+alle_fragen+ ")");
			
			frame.add(richtige_antworten);
			
		}
		

}
