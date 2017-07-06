package GUI_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**Gui komponenttien määritykset.
*/
public class TeatteriGUI extends javax.swing.JFrame implements ActionListener{
    DefaultTableModel elokuvatmodel;
    DefaultTableModel naytoksetmodel;
    DefaultTableModel istuinpaikatmodel;
    JFrame addmovie;
    User user;
    boolean isadmin;
    /**
     * Ajetaan ja näytetään.
     */

   public void createAndShowGUI(){
        Admin user = new Admin("x");
        isadmin = true;
        System.out.println(isadmin);
        // Kikkaillaan semisti resoluutio
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = ((int) screenSize.getWidth())/2;
        int height = ((int) screenSize.getHeight())/2;
        
        // Luodaan ikkuna ja määritetään sulkeminen.
        JFrame frame = new JFrame("KINO42 - The question is here!");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(width/2, height/2, width, height);
        frame.setPreferredSize(new Dimension(width,height+height/2));
        frame.setLayout(null);
        //frame.setUndecorated(true);
        
        // Luodaan menubar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(200, 20));
        // Luodaan menu ja sille tarvittavat itemit
        JMenu menu = new JMenu("Start");
        JMenuItem menuItem1 = new JMenuItem("Quit");
        menu.add(menuItem1);

        
        // Lisätään menu menubaariin.
        menuBar.add(menu);
        // Luodaan kuuntelijat menuitemeille.
        menuItem1.addActionListener(this);
        
        // Asetetaan menubar
        frame.setJMenuBar(menuBar);
        
        
        // Luodaan ylätaustapaneeli
        int marg = 15;
        JPanel paneeli = new JPanel();
        paneeli.setLayout(null);
        paneeli.setBorder(BorderFactory.createLineBorder(Color.black));
        paneeli.setBounds(marg, marg, width-marg*2, height-marg*2-20);
        
        frame.add(paneeli);
        
        // Luodaan alataustapaneeli
        JPanel alapaneeli = new JPanel();
        alapaneeli.setLayout(null);
        alapaneeli.setBorder(BorderFactory.createLineBorder(Color.black));
        alapaneeli.setBounds(marg, marg+height-marg*2-10, width-marg*2, height-marg*2-20);
        frame.add(alapaneeli);
        // Jos admin niin näytetään admin asetukset, muussa tapauksessa asiakas asetukset.
        if(isadmin){
        JLabel alaotsikko = new JLabel("LOL");
        alaotsikko.setBounds(marg, marg, 300, 100);
        
        alapaneeli.add(alaotsikko);
        }
        // Elokuvat    
        elokuvatmodel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                   // Poistetaan editointi mahdollisuus
                   return false;
                }
        };
        JTable elokuvat = new JTable(elokuvatmodel); 
        elokuvat.setBounds(marg, marg, 200,300);
        // Create a couple of columns 
        elokuvatmodel.addColumn("Elokuvat"); 

        elokuvatmodel.addRow(new Object[]{"Pokemon"});
        elokuvatmodel.addRow(new Object[]{"Ikuisen teekkarin metsästys"});
        elokuvatmodel.addRow(new Object[]{"LOTR"});
        elokuvatmodel.addRow(new Object[]{"Swag vol2"});
        elokuvatmodel.addRow(new Object[]{"264U"});
        paneeli.add(elokuvat);
        
        // Kuunnellaan tuplaklikkauksia elokuvista
        elokuvat.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
           if (e.getClickCount() == 2) { 
             naytoksetmodel.setRowCount(0);
             System.out.println(elokuvat.getSelectedRow());
             String s = elokuvat.getValueAt(elokuvat.getSelectedRow(), 0)+"";
             System.out.println(s);
             for(int i = 0; i<s.length();i++){
                 naytoksetmodel.addRow(new Object[]{s.charAt(i)}); 
             }
           }
        }
        });
        
        // Näytökset
        naytoksetmodel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                   // Poistetaan editointi mahdollisuus
                   return false;
                }
        };
        
        JTable naytokset = new JTable(naytoksetmodel);
        naytokset.setBounds(marg+200+5, marg, 200, 300);
        naytoksetmodel.addColumn("Naytokset");
        naytoksetmodel.addRow(new Object[]{"ay"});
        paneeli.add(naytokset);
        naytokset.setVisible(true);
        
        // Kuunnellaan tuplaklikkauksia naytoksista
        naytokset.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
           if (e.getClickCount() == 2) { 
             
             System.out.println(naytokset.getSelectedRow());
           }
        }
        });
        
        // Istuinpaikat
        istuinpaikatmodel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                   // Poistetaan editointi mahdollisuus
                   return false;
                }
        };
        JTable istuinpaikat = new JTable(istuinpaikatmodel);
        istuinpaikat.setCellSelectionEnabled(true);
        istuinpaikat.setBounds(marg+200+5+200+5, marg, 200, 300);
        istuinpaikatmodel.addColumn("", new Object[]{"x"," ","x"});
        istuinpaikatmodel.addColumn("", new Object[]{"x"," ","x"});
        istuinpaikatmodel.addColumn("", new Object[]{"x"," ","x"});
        istuinpaikatmodel.addColumn("", new Object[]{"x"," ","x"});
        istuinpaikatmodel.addColumn("", new Object[]{"x"," ","x"});
        
        
        paneeli.add(istuinpaikat);
        istuinpaikat.setVisible(true);
        
        // Kuunnellaan klikkausta
        istuinpaikat.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
             System.out.println(istuinpaikat.getSelectedRow() + " " + istuinpaikat.getSelectedColumn());
        }
        });
        
        
        // Näytetään ikkuna.
        frame.pack();
        frame.setVisible(true);
        
        // Uuden elokuvan lisääminen
        addmovie = new JFrame("Character creation");
        addmovie.setResizable(false);
        addmovie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addmovie.setBounds(width/2, height/2, width, height);
        addmovie.setPreferredSize(new Dimension(width,height));
        addmovie.setLayout(null);
        addmovie.setUndecorated(true);
        
        JPanel movie_panel = new JPanel();
        movie_panel.setLayout(null);
        movie_panel.setBorder(BorderFactory.createLineBorder(Color.black));
        movie_panel.setBounds(marg, marg, width-marg*2, height-marg*2);
        addmovie.add(movie_panel);
        
        
        
    }
    
    /**
     * Seurataan actioneja. Menu yms.
     * @param e 
     */
   @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
       if(s.equals("New")) addmovie.setVisible(true);
       if(s.equals("Quit")) System.exit(0);
    }
    
    
    
    
    

}
