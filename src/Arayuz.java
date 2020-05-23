import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Label;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;



public class Arayuz {

	private JFrame frmUuPlanla;
	private Choice choice_varisy;
	private Label label;
	private Label label_1;
	private Label label_2;
	private JTextField text_kalkisz;
	private JTextField text_varisz;
	private Label label_3;
	private Choice choice_ucak;
	private JLabel lblNewLabel;
	private Button button;
	private TextArea text_sonuc;
	private JLabel lblNewLabel_1;
	private JTextField text_yenisehir;
	private Choice choice_sehir;
	private Choice choice_kalkisy;
	private Button button_sehirekle;
	private JLabel lblNewLabel_2;
	private Button button_sehirsil;
	private Button button_bilgigetir;
	private Label label_4;
	private Choice choice_ucuslar;
	private Button button_guncelle;
	private Button button_sil;
	private Choice choice_sirket;
	private Button button_start;
	private TextField text_hour;
	private TextField text_min;
	private Button button_pause;
	private Button button_stop;
	private Label label_6;
	private Label label_5;
	private Button button_inisizni;
	private Label label_7;
	private TextField text_rotar;
	private Button button_rotar;
	private Choice choice_izin;
	
	boolean flag=true;
	private TextArea text_ucusdurum;
	private JLabel label_8;
	private Button button_yazdir;
	public static int min;
	public static int hour;
	static boolean state  = true;
	Image icon;
	
	public static int getMin() {
		return min;
	}

	public static void setMin(int min) {
		Arayuz.min = min;
	}

	public static int getHour() {
		return hour;
	}

	public static void setHour(int hour) {
		Arayuz.hour = hour;
	}
	
	
			/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arayuz window = new Arayuz();
					window.frmUuPlanla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Arayuz() {
		initialize();
	}
	
	/**
	  Initialize the contents of the frame.
	 */
	public void initialize() {
		
			ArrayList<String> sehirler = new ArrayList<String>();
			ArrayList<Rota> rotalar = new ArrayList<Rota>();
			HashMap<Integer,String> hmap = new HashMap<Integer,String>();	
			
			String ucak1 = "BOEING 727";
			String ucak2 = "BOEING 507";
			String ucak3 = "BOEING 303";
			
			String sirket1 = "THY";
			String sirket2 = "Pegasus";
			String sirket3 = "AnadoluJet"; 
			
			sehirler.add("New York");
			sehirler.add("Sydney");
			sehirler.add("Istanbul");
			sehirler.add("Tokyo");
			sehirler.add("Paris");
			
		frmUuPlanla = new JFrame();
		frmUuPlanla.setTitle("FLIGHT TRACK");
		Image icon = new ImageIcon(this.getClass().getResource("simge.png")).getImage();
		frmUuPlanla.setIconImage(icon);
		frmUuPlanla.setBounds(100, 100, 1051, 546);
		frmUuPlanla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUuPlanla.getContentPane().setLayout(null);
		
		label = new Label("Kalkis Yeri");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setBounds(20, 99, 70, 24);
		frmUuPlanla.getContentPane().add(label);
		
		label_1 = new Label("Varis Yeri");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(140, 99, 70, 24);
		frmUuPlanla.getContentPane().add(label_1);
		
		choice_kalkisy = new Choice();
		choice_kalkisy.add(sehirler.get(0));
		choice_kalkisy.add(sehirler.get(1));
		choice_kalkisy.add(sehirler.get(2));
		choice_kalkisy.add(sehirler.get(3));
		choice_kalkisy.add(sehirler.get(4));
		choice_kalkisy.setBounds(20, 129, 75, 22);
		frmUuPlanla.getContentPane().add(choice_kalkisy);
		
		choice_varisy = new Choice();
		choice_varisy.add(sehirler.get(0));
		choice_varisy.add(sehirler.get(1));
		choice_varisy.add(sehirler.get(2));
		choice_varisy.add(sehirler.get(3));
		choice_varisy.add(sehirler.get(4));
		choice_varisy.select(1);
		choice_varisy.setBounds(140, 129, 75, 22);
		frmUuPlanla.getContentPane().add(choice_varisy);
		
		label_2 = new Label("Kalkis Zamani");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(252, 99, 96, 24);
		frmUuPlanla.getContentPane().add(label_2);
		
		text_kalkisz = new JTextField();
		text_kalkisz.setText("09:00");
		text_kalkisz.setBounds(252, 129, 62, 22);
		frmUuPlanla.getContentPane().add(text_kalkisz);
		text_kalkisz.setColumns(10);
		
		text_varisz = new JTextField();
		text_varisz.setText("10:00");
		text_varisz.setBounds(27, 212, 56, 22);
		frmUuPlanla.getContentPane().add(text_varisz);
		text_varisz.setColumns(10);
		
		label_3 = new Label("Varis Zamani");
		label_3.setFont(new Font("Dialog", Font.BOLD, 12));
		label_3.setBounds(26, 177, 87, 24);
		frmUuPlanla.getContentPane().add(label_3);
		
		choice_ucak = new Choice();
		choice_ucak.add(ucak1);
		choice_ucak.add(ucak2);
		choice_ucak.add(ucak3);
		choice_ucak.setBounds(119, 212, 130, 22);
		frmUuPlanla.getContentPane().add(choice_ucak);
		
		lblNewLabel = new JLabel("Ucak Modeli");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(145, 185, 85, 16);
		frmUuPlanla.getContentPane().add(lblNewLabel);
		
		text_sonuc = new TextArea();
		text_sonuc.setEditable(false);
		text_sonuc.setBackground(Color.white);
		text_sonuc.setBounds(372, 309, 651, 180);
		frmUuPlanla.getContentPane().add(text_sonuc);
		
		button = new Button("Planla");
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				text_sonuc.setText(null);
				int value=(int) (1000+Math.random()*8999);
				rotalar.add(new Rota(choice_kalkisy.getSelectedItem(),choice_varisy.getSelectedItem(),text_kalkisz.getText(),text_varisz.getText(),
						choice_ucak.getSelectedItem(),value,choice_sirket.getSelectedItem()));
				choice_ucuslar.add(Integer.toString(value));
				
				rotalar.get(rotalar.size()-1).Uc();
				
				hmap.put(value,choice_kalkisy.getSelectedItem());
				hmap.put(value+1,choice_varisy.getSelectedItem());
				hmap.put(value+2,text_kalkisz.getText());
				hmap.put(value+3, text_varisz.getText());
				hmap.put(value+4, choice_ucak.getSelectedItem());
				hmap.put(value+5, choice_sirket.getSelectedItem());
				hmap.put(value+6, Integer.toString(value));
				
				for(int i=0;i<rotalar.size();i++) {
					text_sonuc.append(rotalar.get(i).Yazdir());
					text_sonuc.append("\n");
				}
				
				set_default();
				button_bilgigetir.setEnabled(true);
			}
				
		});
		button.setBounds(140, 260, 79, 24);
		frmUuPlanla.getContentPane().add(button);
		
		lblNewLabel_1 = new JLabel("Sehir Ekle");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(753, 37, 70, 16);
		frmUuPlanla.getContentPane().add(lblNewLabel_1);
		
		text_yenisehir = new JTextField();
		text_yenisehir.setBounds(753, 66, 116, 22);
		frmUuPlanla.getContentPane().add(text_yenisehir);
		text_yenisehir.setColumns(10);
		
		choice_sehir = new Choice();
		choice_sehir.add(sehirler.get(0));
		choice_sehir.add(sehirler.get(1));
		choice_sehir.add(sehirler.get(2));
		choice_sehir.add(sehirler.get(3));
		choice_sehir.add(sehirler.get(4));
		choice_sehir.setBounds(753, 126, 116, 22);
		frmUuPlanla.getContentPane().add(choice_sehir);
		
		button_sehirekle = new Button("Ekle");
		button_sehirekle.setFont(new Font("Dialog", Font.BOLD, 12));
		button_sehirekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sehirler.add(text_yenisehir.getText());
				choice_kalkisy.add(text_yenisehir.getText());
				choice_varisy.add(text_yenisehir.getText());
				choice_sehir.add(text_yenisehir.getText());
				text_yenisehir.setText(null);
			}
		});
		button_sehirekle.setBounds(893, 65, 98, 24);
		frmUuPlanla.getContentPane().add(button_sehirekle);
		
		lblNewLabel_2 = new JLabel("Sehir Sil");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(753, 104, 56, 16);
		frmUuPlanla.getContentPane().add(lblNewLabel_2);
		
		
		button_sehirsil = new Button("Sil");
		button_sehirsil.setFont(new Font("Dialog", Font.BOLD, 12));
		button_sehirsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choice_kalkisy.remove(choice_sehir.getSelectedItem());
				choice_varisy.remove(choice_sehir.getSelectedItem());
				choice_sehir.remove(choice_sehir.getSelectedItem());
			}
		});
		button_sehirsil.setBounds(893, 124, 98, 24);
		frmUuPlanla.getContentPane().add(button_sehirsil);
		
		button_bilgigetir = new Button("Bilgileri Getir");
		button_bilgigetir.setFont(new Font("Dialog", Font.BOLD, 12));
		button_bilgigetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = hmap.get(Integer.parseInt(choice_ucuslar.getSelectedItem()));
				choice_kalkisy.select(temp);
				String temp2 = hmap.get(Integer.parseInt(choice_ucuslar.getSelectedItem())+1);
				choice_varisy.select(temp2);
				String temp3 = hmap.get(Integer.parseInt(choice_ucuslar.getSelectedItem())+2);
				text_kalkisz.setText(temp3);
				String temp4 = hmap.get(Integer.parseInt(choice_ucuslar.getSelectedItem())+3);
				text_varisz.setText(temp4);
				String temp5 = hmap.get(Integer.parseInt(choice_ucuslar.getSelectedItem())+4);
				choice_ucak.select(temp5);
				String temp6 = hmap.get(Integer.parseInt(choice_ucuslar.getSelectedItem())+5);
				choice_sirket.select(temp6);
				
				button_bilgigetir.setEnabled(false);
				button_guncelle.setEnabled(true);
				button_sil.setEnabled(true);
				button_rotar.setEnabled(true);
				choice_ucuslar.setEnabled(false);
				button.setEnabled(false);
			}
		});
		button_bilgigetir.setBounds(242, 375, 87, 24);
		frmUuPlanla.getContentPane().add(button_bilgigetir);
		
		label_4 = new Label("Duzenlenecek Ucus Secin:");
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(27, 333, 182, 24);
		frmUuPlanla.getContentPane().add(label_4);
		
		choice_ucuslar = new Choice();
		choice_ucuslar.setBounds(242, 335, 87, 22);
		frmUuPlanla.getContentPane().add(choice_ucuslar);
		
		button_guncelle = new Button("Guncelle");
		button_guncelle.setFont(new Font("Dialog", Font.BOLD, 12));
		button_guncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = Integer.parseInt(choice_ucuslar.getSelectedItem());
				
				for(int i = 0; i<rotalar.size();i++) {
					if(value==rotalar.get(i).getUcusNo()) {
						rotalar.get(i).setKalkisYeri(choice_kalkisy.getSelectedItem());
						rotalar.get(i).setVarisYeri(choice_varisy.getSelectedItem());
						rotalar.get(i).setKalkisZamani(text_kalkisz.getText());
						rotalar.get(i).setVarisZamani(text_varisz.getText());
						rotalar.get(i).setModel(choice_ucak.getSelectedItem());
						rotalar.get(i).setSirket(choice_sirket.getSelectedItem());
					}
				}
				
				hmap.put(value,choice_kalkisy.getSelectedItem());
				hmap.put(value+1,choice_varisy.getSelectedItem());
				hmap.put(value+2,text_kalkisz.getText());
				hmap.put(value+3, text_varisz.getText());
				hmap.put(value+4, choice_ucak.getSelectedItem());
				hmap.put(value+5, choice_sirket.getSelectedItem());
				
				text_sonuc.setText(null);
				for(int i=0;i<rotalar.size();i++) {
					text_sonuc.append(rotalar.get(i).Yazdir());
					text_sonuc.append("\n");
				}
				set_default();
				
				button_bilgigetir.setEnabled(true);
				button_guncelle.setEnabled(false);
				button_sil.setEnabled(false);
				button_rotar.setEnabled(false);
				choice_ucuslar.setEnabled(true);
				button.setEnabled(true);
			}
		});
		button_guncelle.setEnabled(false);
		button_guncelle.setBounds(35, 375, 79, 24);
		frmUuPlanla.getContentPane().add(button_guncelle);
		
		button_sil = new Button("Sil");
		button_sil.setFont(new Font("Dialog", Font.BOLD, 12));
		button_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i<rotalar.size();i++) {
					if(Integer.parseInt(choice_ucuslar.getSelectedItem())==rotalar.get(i).getUcusNo()) {
						rotalar.remove(i);
					}
				}
				
				choice_ucuslar.remove(choice_ucuslar.getSelectedIndex());
				
				text_sonuc.setText(null);
				for(int i=0;i<rotalar.size();i++) {
					text_sonuc.append(rotalar.get(i).Yazdir());
					text_sonuc.append("\n");
				}
				
				button_bilgigetir.setEnabled(true);
				button_guncelle.setEnabled(false);
				button_sil.setEnabled(false);
				button_rotar.setEnabled(false);
				choice_ucuslar.setEnabled(true);
				button.setEnabled(true);
				
				set_default();
			}
		});
		button_sil.setEnabled(false);
		button_sil.setBounds(137,375, 79, 24);
		frmUuPlanla.getContentPane().add(button_sil);
		
		JLabel lblNewLabel_3 = new JLabel("Ucus Sirketi");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(299, 185, 80, 16);
		frmUuPlanla.getContentPane().add(lblNewLabel_3);
		
		choice_sirket = new Choice();
		choice_sirket.add(sirket1);
		choice_sirket.add(sirket2);
		choice_sirket.add(sirket3);
		choice_sirket.setBounds(294, 212, 75, 22);
		frmUuPlanla.getContentPane().add(choice_sirket);
		
		text_hour = new TextField();
		text_hour.setFont(new Font("Dialog", Font.BOLD, 40));
		text_hour.setText("00");
		text_hour.setBounds(20, 22, 52, 54);
		frmUuPlanla.getContentPane().add(text_hour);
		
		text_min = new TextField();
		text_min.setFont(new Font("Dialog", Font.BOLD, 40));
		text_min.setText("00");
		text_min.setBounds(92, 22, 52, 51);
		frmUuPlanla.getContentPane().add(text_min);
		
		button_start = new Button("Start");
		button_start.setFont(new Font("Dialog", Font.BOLD, 12));
		button_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_hour.setEditable(false);
				text_min.setEditable(false);
				state= true;
				hour=Integer.parseInt(text_hour.getText());
				min=Integer.parseInt(text_min.getText());
				
				Thread t = new Thread() {
					
					public void run() {
						for(;;) {
							if(state==true) {
							try {
								sleep(1000);
								
								for(int j=0;j<choice_ucuslar.getItemCount();j++) {
									for(int i=0;i<rotalar.size();i++){
										if(rotalar.get(i).getUcusNo()==Integer.parseInt(choice_ucuslar.getItem(j))) {
											if(check_kalkis(hmap,j)) {
												rotalar.get(i).setDurum("Ucusta");
												text_ucusdurum.append(rotalar.get(i).getDurum());
												text_ucusdurum.append("\n");
												}
											}
										}	
									}
								for(int j=0;j<choice_ucuslar.getItemCount();j++) {
									for(int i=0;i<rotalar.size();i++){
										if(rotalar.get(i).getUcusNo()==Integer.parseInt(choice_ucuslar.getItem(j))) {
											if(check_inis(hmap,j)) {
												button_inisizni.setEnabled(true);
												rotalar.get(i).setDurum("Ýzin_Bekleniyor");
												text_ucusdurum.append(rotalar.get(i).getDurum());
												text_ucusdurum.append("\n");
												}
											}
										}	
									}
								if(min==60) {
									min=0;
									hour++;
								}
								if(hour==24) {
									min=0;
									hour=0;
								}
								if(min <10) {
									text_min.setText("0"+min);
								}
								else {
									text_min.setText(""+min);
								}
								
								if(hour <10) {
									text_hour.setText("0"+hour);
								}
								else {
									text_hour.setText(""+hour);
								}
								min++;
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
							else {
								break;
							}
						}
						
					}
				};
				t.start();
			}
		});
		button_start.setBounds(157, 37, 79, 24);
		frmUuPlanla.getContentPane().add(button_start);
		
		button_pause = new Button("Pause");
		button_pause.setFont(new Font("Dialog", Font.BOLD, 12));
		button_pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_start.setLabel("Resume");
				text_hour.setEditable(true);
				text_min.setEditable(true);
				state=false;
			}
		});
		button_pause.setBounds(256, 37, 79, 24);
		frmUuPlanla.getContentPane().add(button_pause);
		
		button_stop = new Button("Stop");
		button_stop.setFont(new Font("Dialog", Font.BOLD, 12));
		button_stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_hour.setEditable(true);
				text_min.setEditable(true);
				state=false;
				text_min.setText("0"+0);
				text_hour.setText("0"+0);
				min=0;
				hour=0;
				button_start.setLabel("Start");
			}
		});
		button_stop.setBounds(353, 37, 79, 24);
		frmUuPlanla.getContentPane().add(button_stop);
		
		label_5 = new Label(":");
		label_5.setFont(new Font("Dialog", Font.BOLD, 40));
		label_5.setBounds(73, 20, 17, 53);
		frmUuPlanla.getContentPane().add(label_5);
		
		label_6 = new Label("Ýnis Ýzni Ýste:");
		label_6.setFont(new Font("Dialog", Font.BOLD, 12));
		label_6.setBounds(690, 263, 90, 24);
		frmUuPlanla.getContentPane().add(label_6);
		
		button_inisizni = new Button("Ýzin Ýste");
		button_inisizni.setFont(new Font("Dialog", Font.BOLD, 12));
		button_inisizni.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String ucusno = (""+choice_izin.getSelectedItem().charAt(5)+choice_izin.getSelectedItem().charAt(6)+choice_izin.getSelectedItem().charAt(7)+
						choice_izin.getSelectedItem().charAt(8));
				
				for(int i = 0; i<rotalar.size();i++) {
					if(Integer.parseInt(ucusno)==rotalar.get(i).getUcusNo()){
						rotalar.get(i).setDurum("Ucus_Bitti");
						text_ucusdurum.append("No: "+ucusno+" "+rotalar.get(i).getDurum());
						text_ucusdurum.append("\n");
						break;
					}
				}
				
				for(int i = 0; i<choice_ucuslar.getItemCount();i++) {
					if(Integer.parseInt(ucusno)==Integer.parseInt(choice_ucuslar.getItem(i))){
						choice_ucuslar.remove(i);
						break;
					}
				}
				
				choice_izin.remove(choice_izin.getSelectedItem());
				Rota.t2.stop();
				
				if(choice_izin.getItemCount()==0){
					button_inisizni.setEnabled(false);
				}
				
				button_guncelle.setEnabled(false);
				button_sil.setEnabled(false);
				button_bilgigetir.setEnabled(true);
				button_rotar.setEnabled(false);
				
				set_default();
				
			}
		});
		button_inisizni.setEnabled(false);
		button_inisizni.setBounds(936, 263, 87, 24);
		frmUuPlanla.getContentPane().add(button_inisizni);
		
		label_7 = new Label("Rötar Ayarla:");
		label_7.setFont(new Font("Dialog", Font.BOLD, 12));
		label_7.setBounds(690, 223, 85, 24);
		frmUuPlanla.getContentPane().add(label_7);
		
		text_rotar = new TextField();
		text_rotar.setBounds(810, 223, 85, 24);
		frmUuPlanla.getContentPane().add(text_rotar);
		
		button_rotar = new Button("Rotar Ayarla");
		button_rotar.setFont(new Font("Dialog", Font.BOLD, 12));
		button_rotar.setEnabled(false);
		button_rotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str1 = set_rotar(text_kalkisz.getText());
				String str2 = set_rotar(text_varisz.getText());
			
				for(int i = 0; i<rotalar.size();i++) {
					if(Integer.parseInt(choice_ucuslar.getSelectedItem())==rotalar.get(i).getUcusNo()) {
						rotalar.get(i).setRotar(text_rotar.getText());
					}
				}
				
				text_rotar.setText(null);
				text_kalkisz.setText(str1);
				text_varisz.setText(str2);
				button_rotar.setEnabled(false);
			}
		});
		button_rotar.setBounds(910, 223, 85, 24);
		frmUuPlanla.getContentPane().add(button_rotar);
		
		choice_izin = new Choice();
		choice_izin.setBounds(786, 263, 130, 22);
		frmUuPlanla.getContentPane().add(choice_izin);
		
		text_ucusdurum = new TextArea();
		text_ucusdurum.setBackground(Color.white);
		text_ucusdurum.setEditable(false);
		text_ucusdurum.setBounds(475, 65, 170, 220);
		frmUuPlanla.getContentPane().add(text_ucusdurum);
		
		label_8 = new JLabel("Ucus Durumlarý");
		label_8.setBounds(515, 37, 100, 24);
		frmUuPlanla.getContentPane().add(label_8);
		
		button_yazdir = new Button("Dosyaya Yazdir");
		button_yazdir.setFont(new Font("Dialog", Font.BOLD, 12));
		button_yazdir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_sonuc.setText(null);
                LocalDate date = LocalDate.now();

                for(int i=0;i<rotalar.size();i++) {
                    text_sonuc.append(rotalar.get(i).Yazdir());
                    String day = (date.getDayOfWeek().toString()+" - "+date.getMonth().toString()+" - "+date.getYear());
                    text_sonuc.append(" | ");
                    text_sonuc.append(day);
                    text_sonuc.append("\n");
                }

                PrintWriter yazici = null;
                try {
                    yazici = new PrintWriter("Output.txt");
                    yazici.println(text_sonuc.getText());
                    yazici.close();
                    text_sonuc.append("Dosyaya Basarýyla Yazýldý.");
                } catch (FileNotFoundException e2) {
                    text_sonuc.append("Dosyaya Yazarken Hata");
                }
		}});
		button_yazdir.setBounds(130, 430, 100, 25);
		frmUuPlanla.getContentPane().add(button_yazdir);
		
	}
	
	public boolean check_kalkis(HashMap<Integer, String> hmap, int i) {
		
		int hour1=hour, min1=min;
		int temp = Integer.parseInt(choice_ucuslar.getItem(i)); 
		String zaman = hmap.get(temp+2);
		String shour = (""+zaman.charAt(0)+zaman.charAt(1));
		String smin = (""+zaman.charAt(3)+zaman.charAt(4));
		
		if(Integer.parseInt(shour)<10) {
			shour = (""+zaman.charAt(1));
		}
		
		if(Integer.parseInt(smin)<10) {
			smin = (""+zaman.charAt(4));
		}
		if(min1==60) {
			min1=0;
			hour1++;
		}
		
		if(Integer.parseInt(shour)==(hour1) && Integer.parseInt(smin)==min1){
			text_ucusdurum.append(" No: "+hmap.get(temp+6)+" ");
			return true;
		}
		
		return false;
	}
	public boolean check_inis(HashMap<Integer, String> hmap, int i) {
		
			int hour1=hour,min1=min;
			int temp = Integer.parseInt(choice_ucuslar.getItem(i)); 
			String zaman = hmap.get(temp+3);
			String shour = (""+zaman.charAt(0)+zaman.charAt(1));
			String smin = (""+zaman.charAt(3)+zaman.charAt(4));
			
			if(Integer.parseInt(shour)<10) {
				shour = (""+zaman.charAt(1));
			}
			
			if(Integer.parseInt(smin)<10) {
				smin = (""+zaman.charAt(4));
			}
			if(min1==60) {
				min1=0;
				hour1++;
			}
			if(Integer.parseInt(shour)==(hour1) && Integer.parseInt(smin)==min1){
				choice_izin.add(" No: "+hmap.get(temp+6));
				text_ucusdurum.append(" No: "+hmap.get(temp+6)+" ");
				return true;
			}
			
			
			return false;
		
	}
	public String set_rotar(String zaman1) {
		String zaman = text_rotar.getText();
		int min = Integer.parseInt(zaman);
		int hour=0;
		String temp3 = "";
		
		temp3=(""+zaman1.charAt(3)+zaman1.charAt(4));
		int dk = Integer.parseInt(temp3)+min;
		
		while(dk>=60){
			hour++;
			dk -= 60;
		} 
		
		String temp2=(""+zaman1.charAt(0)+zaman1.charAt(1)); 
		
		int saat = Integer.parseInt(temp2)+hour; 
		
		if(saat>=24) saat-=24;
		
		if(saat<10 || dk==0 || dk<10) {
			if(saat<10 && dk==0) {
				String temp4=('0'+Integer.toString(saat)+":"+Integer.toString(dk)+'0');
				return temp4;
			}
			else if(dk==0) {
				String temp4=(Integer.toString(saat)+":"+Integer.toString(dk)+'0');
				return temp4;
			}
			else if(dk<10 && saat<10) {
				String temp4=('0'+Integer.toString(saat)+":"+'0'+Integer.toString(dk));
				return temp4;
			}
			else if(dk<10) {
				String temp4=(Integer.toString(saat)+":"+'0'+Integer.toString(dk));
				return temp4;
			}
			String temp4=('0'+Integer.toString(saat)+":"+Integer.toString(dk));
			return temp4;
		}
		String temp4=(Integer.toString(saat)+":"+Integer.toString(dk));
		
		return temp4;
	}
	
	public void set_default() {
		text_kalkisz.setText(null);
		text_varisz.setText(null);
		choice_kalkisy.select(0);
		choice_varisy.select(1);
		choice_ucak.select(0);
		choice_sirket.select(0);
		text_kalkisz.setText("09:00");
		text_varisz.setText("10:00");
	}
	}
