import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JFrame;  
 

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 11.11.2024
 * @author 
 */

public class Baumtest extends JFrame {
  // Anfang Attribute
  private JTextField jTextField1 = new JTextField();
  private JButton beinfuegen1 = new JButton();
  private JButton bsuchen1 = new JButton();
  private JButton bloeschen1 = new JButton();
  private JButton bausgeben1 = new JButton();
  
  private JButton jButton1 = new JButton();
  Container cp;
  // eigene Attribute
  private JTextField[] visualBaum = new JTextField[64];
  private BinaerBaum meinBaum;
  private StapelObj elemente = new StapelObj(new PosKey(0,0));
  int breite = 40;
  int hoehe = 20;
  int abstandX = 10;
  int abstandY = 40;
  int starty = 300;
  int startx = 50;
   // Ende Attribute
  
  public Baumtest() { 
    // Frame init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1755; 
    int frameHeight = 946;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Baumtest");
    setResizable(false);
    cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTextField1.setBounds(96, 16, 96, 40);
    cp.add(jTextField1);
    beinfuegen1.setBounds(232, 16, 97, 41);
    beinfuegen1.setText("einfuegen");
    beinfuegen1.setMargin(new Insets(2, 2, 2, 2));
    beinfuegen1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        beinfuegen1_ActionPerformed(evt);
      }
    });
    cp.add(beinfuegen1);
    bsuchen1.setBounds(344, 16, 105, 41);
    bsuchen1.setText("suchen");
    bsuchen1.setMargin(new Insets(2, 2, 2, 2));
    bsuchen1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bsuchen1_ActionPerformed(evt);
      }
    });
    cp.add(bsuchen1);
    bloeschen1.setBounds(464, 16, 113, 41);
    bloeschen1.setText("loeschen");
    bloeschen1.setMargin(new Insets(2, 2, 2, 2));
    bloeschen1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bloeschen1_ActionPerformed(evt);
      }
    });
    cp.add(bloeschen1);
    bausgeben1.setBounds(592, 16, 89, 41);
    bausgeben1.setText("ausgeben");
    bausgeben1.setMargin(new Insets(2, 2, 2, 2));
    bausgeben1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bausgeben1_ActionPerformed(evt);
      }
    });
    cp.add(bausgeben1);
    jButton1.setBounds(824, 16, 105, 41);
    jButton1.setText("Button");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Baumtest
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Baumtest();
  } // end of main
  
  public void beinfuegen1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    int eingabe = Integer.parseInt(jTextField1.getText());
    if (meinBaum == null) {
      meinBaum = new BinaerBaum(eingabe);
    }
    else {
      meinBaum.einfuegen(eingabe);
    } // end of if-else
    
  } // end of beinfuegen1_ActionPerformed

  public void bsuchen1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bsuchen1_ActionPerformed

  public void bloeschen1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bloeschen1_ActionPerformed

  public void bausgeben1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    PosKey elem;
    for (int i = 0; i < 64; i++) {
      visualBaum[i].setVisible(false);
    }
    
    meinBaum.ausgabeInorder(elemente);
    elem = (PosKey) elemente.pop();
    while (elem != null) { 
      visualBaum[elem.getPos()].setText(elem.getKey()+"");
      visualBaum[elem.getPos()].setVisible(true);
      elem = (PosKey) elemente.pop();
    } // end of while
    cp.repaint();
  } // end of bausgeben1_ActionPerformed

  public void jButton1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    visualBaum[0] = new JTextField();
    int l = 1;
    for (int j = 5; j >= 0; j--) {
      int k = 0;
      for (int i = (int) Math.pow(2,j); i < Math.pow(2,j+1); i++) {
        visualBaum[i] = new JTextField(); 
        if (j< 5) {
          int myX = (visualBaum[2*i].getX() +  visualBaum[2*i+1].getX()) / 2;
          visualBaum[i].setBounds(myX, starty + j*(hoehe+abstandY), breite, hoehe);
         }
        else {
          visualBaum[i].setBounds(startx + k*(breite*l+abstandX), starty + j*(hoehe+abstandY), breite, hoehe); 
          int endeX = (int) (startx + k*(breite*l+abstandX) + startx + (k+1)*(breite*l+abstandX))/2;
        } // end of if-else
        cp.add(visualBaum[i]);
        cp.repaint();
        k++;
      }
      l = l*2;
    }
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class Baumtest
