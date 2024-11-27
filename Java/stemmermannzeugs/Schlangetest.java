import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 21.10.2024
 * @author 
 */

public class Schlangetest extends JFrame {
  // Anfang Attribute
  private JButton bpush1 = new JButton();
  private JButton bpop1 = new JButton();
  private JButton bausgeben1 = new JButton();
  private JTextField jTextField1 = new JTextField();
  private JTextArea jTextArea1 = new JTextArea();
  private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  Schlange queue = new Schlange();
  private JButton benqueue1 = new JButton();
  private JButton bdequeue1 = new JButton();
  // Ende Attribute
  
  public Schlangetest() { 
    // Frame init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 691; 
    int frameHeight = 552;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Stapeltest");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    bpush1.setBounds(40, 32, 80, 24);
    bpush1.setText("push");
    bpush1.setMargin(new Insets(2, 2, 2, 2));
    bpush1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bpush1_ActionPerformed(evt);
      }
    });
    cp.add(bpush1);
    bpop1.setBounds(136, 32, 80, 24);
    bpop1.setText("pop");
    bpop1.setMargin(new Insets(2, 2, 2, 2));
    bpop1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bpop1_ActionPerformed(evt);
      }
    });
    cp.add(bpop1);
    bausgeben1.setBounds(240, 32, 80, 24);
    bausgeben1.setText("ausgeben");
    bausgeben1.setMargin(new Insets(2, 2, 2, 2));
    bausgeben1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bausgeben1_ActionPerformed(evt);
      }
    });
    cp.add(bausgeben1);
    jTextField1.setBounds(56, 120, 136, 40);
    cp.add(jTextField1);
    jTextArea1ScrollPane.setBounds(296, 128, 185, 161);
    cp.add(jTextArea1ScrollPane);
    benqueue1.setBounds(368, 40, 89, 25);
    benqueue1.setText("enqueue");
    benqueue1.setMargin(new Insets(2, 2, 2, 2));
    benqueue1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        benqueue1_ActionPerformed(evt);
      }
    });
    cp.add(benqueue1);
    bdequeue1.setBounds(488, 32, 97, 33);
    bdequeue1.setText("dequeue");
    bdequeue1.setMargin(new Insets(2, 2, 2, 2));
    bdequeue1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bdequeue1_ActionPerformed(evt);
      }
    });
    cp.add(bdequeue1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Schlangetest
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Schlangetest();
  } // end of main
  
  public void bpush1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of bpush1_ActionPerformed

  public void bpop1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of bpop1_ActionPerformed

  public void bausgeben1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen


    
  } // end of bausgeben1_ActionPerformed

  public void benqueue1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen

    int zahl = Integer.parseInt(jTextField1.getText());         
    System.out.println(zahl);
    queue.enqueue(zahl);
    
  } // end of benqueue1_ActionPerformed

  public void bdequeue1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    if (!queue.isEmpty()) {
      int ausgabe = queue.dequeue();
      System.out.println(ausgabe);
    }
    else {
      System.out.println("ist doch leer, du Daggel");
    } // end of if-else
    
  } // end of bdequeue1_ActionPerformed

  // Ende Methoden
} // end of class Stapeltest
