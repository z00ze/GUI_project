package GUI_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class UI implements ActionListener, MouseListener{
    // Taulukoiden modelit
    DefaultTableModel elokuvatmodel;
    DefaultTableModel naytoksetmodel;
    DefaultTableModel istuinpaikatmodel;
    ArrayList<Elokuva> elokuvat;
    ArrayList<Sali> salit;
    // Pääikkuna
    JFrame paa;
    public void luoUI(){
        /******************************************************
         * Luodaan elokuvat arraylist.        
        ******************************************************/
        elokuvat = new ArrayList<Elokuva>();
        elokuvat.add(new Elokuva("Pokemon",1999));
        elokuvat.get(0).setNaytokset(new ArrayList<Naytos>());
        elokuvat.get(0).getNaytokset().add(new Naytos(3,elokuvat.get(0).getNimi(),new Date(2017,3,4),1));
        elokuvat.get(0).getNaytokset().add(new Naytos(2,elokuvat.get(0).getNimi(),new Date(2017,3,4),2));
        elokuvat.get(0).getNaytokset().get(0).getVaraukset().add(new Varaus(666,15,elokuvat.get(0).getNaytokset().get(0)));
        
        /******************************************************
         * Luodaan salit arraylist.
         ******************************************************/
        salit = new ArrayList<Sali>();
        salit.add(new Sali(40,10,1));
        salit.add(new Sali(10,25,2));
        salit.add(new Sali(12,20,3));
        
        int leveys = 1200;
        int korkeus = 800;
        /******************************************************
         * Luodaan pääikkuna.
         ******************************************************/
        JFrame paaikkuna = new JFrame("KINO42 - The question is here!");
        paaikkuna.setResizable(false);
        paaikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paaikkuna.setBounds(0,0,leveys,korkeus);
        paaikkuna.setPreferredSize(new Dimension(leveys,korkeus));
        paaikkuna.setLayout(null);

        /******************************************************
         * Luodaan työkaluvalikko ja lisätään sinne tarvittavat asiat ja klikkauksien kuuntelijat.
         ******************************************************/
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(200, 20));
        JMenu menu = new JMenu("Start");
        JMenuItem menuItem1 = new JMenuItem("Quit");
        menu.add(menuItem1);
        menuBar.add(menu);
        menuItem1.addActionListener(this);
        paaikkuna.setJMenuBar(menuBar);
        
        /******************************************************
         * Luodaan ylätaustapaneeli.
         ******************************************************/
        JPanel ylapaneeli = new JPanel();
        int margin = 15;
        int tmargin = 5;
        ylapaneeli.setLayout(null);
        ylapaneeli.setBorder(BorderFactory.createLineBorder(Color.black));
        ylapaneeli.setBounds(margin, margin, leveys-margin*2,korkeus/2-margin*2);
        
        
        /******************************************************
         * Elokuvat taulukko.
         ******************************************************/
        elokuvatmodel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                   // Poistetaan editointi mahdollisuus
                   return false;
                }
        };
        JTable elokuvattaulukko = new JTable(elokuvatmodel); 
        elokuvattaulukko.setBounds(tmargin,tmargin, 200,korkeus/2-margin*2-tmargin*2);
        elokuvatmodel.addColumn("Elokuvat"); 
        for(int i = 0;i<elokuvat.size();i++){
        elokuvatmodel.addRow(new Object[]{ elokuvat.get(i).getNimi() });
        }
        ylapaneeli.add(elokuvattaulukko);
        
        /******************************************************
         * Elokuvataulukon kuuntelija, klikkauksen mukaan nuketetaan näytöksen taulukkoon kyseisen elokuvan näytökset.
         ******************************************************/
        elokuvattaulukko.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if(elokuvattaulukko.getSelectedRow()!=-1){
            naytoksetmodel.setRowCount(0);
                for(int i = 0;i<elokuvat.get(elokuvattaulukko.getSelectedRow()).getNaytokset().size();i++){
                    String naytosklo = null;
                    int naytosnro = elokuvat.get(elokuvattaulukko.getSelectedRow()).getNaytokset().get(i).getNaytoksenNro();
                    switch(naytosnro){
                        case 1: naytosklo = "12:00"; break;
                        case 2: naytosklo = "15:00"; break;
                        case 3: naytosklo = "18:00"; break;
                    }
                    
                    naytoksetmodel.addRow(new Object[]{ elokuvat.get(elokuvattaulukko.getSelectedRow()).getNaytokset().get(i).getNaytoksenNro(), elokuvat.get(elokuvattaulukko.getSelectedRow()).getNaytokset().get(i).getPaiva(), naytosklo });
                }
           }
        }
        });
        
        
        /******************************************************
         * Näytökset taulukko.
         ******************************************************/
                naytoksetmodel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                   // Poistetaan editointi mahdollisuus
                   return false;
                }
        };
        JTable naytoksettaulukko = new JTable(naytoksetmodel); 
        naytoksettaulukko.setBounds(200+tmargin*2,tmargin, 200,korkeus/2-margin*2-10);
        naytoksetmodel.addColumn("Sali");
        naytoksetmodel.addColumn("Päivämäärä");
        naytoksetmodel.addColumn("Näytös"); 
        ylapaneeli.add(naytoksettaulukko);

        /******************************************************
         * Naytoksettaulukon kuuntelija, klikkauksen mukaan nuketetaan näytöksen taulukkoon kyseisen elokuvan näytökset.
         ******************************************************/
        naytoksettaulukko.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if(naytoksettaulukko.getSelectedRow()!=-1){
                int rivinpituus = salit.get((int) naytoksettaulukko.getValueAt(naytoksettaulukko.getSelectedRow(), 0)-1).getRivinPituus();
                istuinpaikatmodel.setColumnCount(rivinpituus);
                int rivit = salit.get((int) naytoksettaulukko.getValueAt(naytoksettaulukko.getSelectedRow(), 0)-1).getRivit();
                istuinpaikatmodel.setRowCount(rivit);
                
                
            }
        }
        });
        
        
        /******************************************************
         * Istuinpaikat taulukko.
         ******************************************************/
                istuinpaikatmodel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                   // Poistetaan editointi mahdollisuus
                   return false;
                }
        };
        JTable istuinpaikattaulukko = new JTable(istuinpaikatmodel);
        istuinpaikattaulukko.setCellSelectionEnabled(true);
        istuinpaikattaulukko.setGridColor(Color.gray);
        istuinpaikattaulukko.setBounds(200*2+tmargin*3,tmargin, leveys-(200*2+4*tmargin+2*margin),korkeus/2-margin*2-10);
        istuinpaikatmodel.addColumn("Sali");

        ylapaneeli.add(istuinpaikattaulukko);
        
        /******************************************************
         * Admin alataulukko.
         ******************************************************/
        JPanel adminala = new JPanel();
        adminala.setLayout(null);
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Lisää elokuva");
        adminala.setBorder(title);
        adminala.setBounds(margin, margin+(korkeus/2-margin*2)+30, leveys-margin*2,korkeus/2-margin*2-40);
        
        // Rivi
        JLabel elokuvanimi = new JLabel("Elokuvan nimi");
        elokuvanimi.setBounds(tmargin*2, 30, 200, 20);
        adminala.add(elokuvanimi);
        
        JTextField elokuvalisaysnimi = new JTextField();
        elokuvalisaysnimi.setBounds(tmargin*2+200, 30, 150, 20);
        adminala.add(elokuvalisaysnimi);
        
        // Rivi
        JLabel elokuvavuosi = new JLabel("Elokuvan julkaisuvuosi");
        elokuvavuosi.setBounds(tmargin*2, 60, 200, 20);
        adminala.add(elokuvavuosi);
        
        JTextField elokuvalisaysvuosi = new JTextField();
        elokuvalisaysvuosi.setBounds(tmargin*2+200, 60, 150, 20);
        adminala.add(elokuvalisaysvuosi);
        
        JButton lisaaelokuva = new JButton("R");
        lisaaelokuva.setBounds(tmargin*2+200, 90 ,100,20);
        adminala.add(lisaaelokuva);
        
 
        
        
        
        
        
        
        /******************************************************
         * Pakataan pääikkuna ja näytetään se.
         ******************************************************/
        paaikkuna.add(ylapaneeli);
        paaikkuna.add(adminala);
        paaikkuna.pack();
        paaikkuna.setVisible(true);
        
    }

    /**
     * Seurataan actioneja. Menu yms.
     * @param e 
     */
   @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
       if(s.equals("New")) ;
       if(s.equals("Quit")) System.exit(0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
