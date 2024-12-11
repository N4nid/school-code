import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.lang.reflect.*; // fur die JTextField-Arrays
import java.util.*; // fur die Zufallszahlen

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 26.09.2010
 * @author
 */

public class Sortieralgorithmen_Quicksort extends JFrame {
  // Anfang Attribute
  JTextField tf_start[];
  JTextField tf_ziel[];
  // JTextField fertig;
  int[] originalarray;
  int[] zielarray;
  int arraylaenge = 20;
  int index, vergleich, original_index, gefunden, ziel_index, sortiert, methode, zwischenspeicher;

  private JButton anzeigen = new JButton();
  private JTextField fertig = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel11 = new JLabel();
  private JTextField tf_Vergleich = new JTextField();
  private JTextField tf_Index = new JTextField();
  private JButton Selection_2_Table = new JButton();
  private JButton sortieren11 = new JButton();
  // Ende Attribute

  public Sortieralgorithmen_Quicksort(String title) {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 476;
    int frameHeight = 812;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten

    anzeigen.setBounds(360, 32, 73, 33);
    anzeigen.setText("anzeigen");
    anzeigen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        anzeigen_ActionPerformed(evt);
      }
    });
    anzeigen.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(anzeigen);
    fertig.setBounds(360, 80, 89, 24);
    fertig.setText("");
    fertig.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(fertig);
    jLabel1.setBounds(32, 10, 58, 20);
    jLabel1.setText("Vergleich");
    jLabel1.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLabel1);
    jLabel11.setBounds(132, 10, 35, 20);
    jLabel11.setText("Index");
    jLabel11.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLabel11);
    tf_Vergleich.setBounds(32, 30, 81, 24);
    tf_Vergleich.setText("");
    tf_Vergleich.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tf_Vergleich);
    tf_Index.setBounds(132, 30, 81, 24);
    tf_Index.setText("");
    tf_Index.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(tf_Index);
    Selection_2_Table.setBounds(272, 120, 193, 41);
    Selection_2_Table.setText("Quicksort");
    Selection_2_Table.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Selection_2_Table_ActionPerformed(evt);
      }
    });
    Selection_2_Table.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(Selection_2_Table);
    sortieren11.setBounds(272, 176, 193, 41);
    sortieren11.setText("Umkopieren");
    sortieren11.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        sortieren11_ActionPerformed(evt);
      }
    });
    sortieren11.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(sortieren11);
    // Ende Komponenten
    // Anfang eigener Kram

    // alle Arrays fur das Programm werden erzeugt: zwei int-Arrays zum Arbeiten und
    // zwei TextField-Arrays zur Anzeige
    Object ar = Array.newInstance(JTextField.class, arraylaenge);
    tf_start = (JTextField[]) ar;
    ar = Array.newInstance(JTextField.class, arraylaenge);
    tf_ziel = (JTextField[]) ar;
    // man beachte die unterschiedliche Art der Erzeugung
    originalarray = new int[arraylaenge];
    zielarray = new int[arraylaenge];
    Random zufallszahl = new Random(); // Vorraussetzungen fur die Nutzung von Zufallszahlen wird geschaffen. Siehe
                                       // JavaBuch Kapitel 16.1
    for (int i = 0; i < arraylaenge; i++) {
      originalarray[i] = zufallszahl.nextInt(3 * arraylaenge);
    }
    for (int i = 0; i < arraylaenge; i++) {
      tf_start[i] = new JTextField(10);
      tf_start[i].setToolTipText("Start-Zelle Nr. " + i);
      tf_start[i].setText("Start" + i);
      tf_start[i].setBounds(32, (80 + i * 25), 81, 24);

      tf_ziel[i] = new JTextField(10);
      tf_ziel[i].setToolTipText("Ziel-Zelle Nr. " + i);
      tf_ziel[i].setText("Ziel" + i);
      tf_ziel[i].setBounds(132, (80 + i * 25), 81, 24);
      cp.add(tf_start[i]);
      cp.add(tf_ziel[i]);
    }
    setResizable(false);
    setVisible(true);
  }

  // Anfang Methoden
  public void anzeigen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfugen
    anzeigen();
  }

  public void anzeigen() {
    for (int i = 0; i < arraylaenge; i++) {
      tf_start[i].setText("" + originalarray[i]);
      tf_ziel[i].setText("" + zielarray[i]);
      tf_start[i].setBackground(Color.white);
      tf_ziel[i].setBackground(Color.white);
    }
  }

  public void sortit1() {
    quicksort(0, 19);
  }

  public void quicksort(int start, int ende) {
    if (start < ende) {
      int teiler = teile(start, ende);
      quicksort(start, teiler - 1);
      quicksort(teiler + 1, ende);
    }
    anzeigen();
  }

  public int teile(int start, int ende) {
    int links = start;
    int rechts = ende - 1;
    int pivot = originalarray[ende];
    // ab hier Debug-Informationen zur Bebobachtung der Sortierung
    // Die ods-Datei Quicksort Beispiele mit Grenzen hervorgehoben.ods markiert die
    // Grenzen des betrachteten Bereichs (Text in Tabelle, danach erst in leere
    // Tabelle umkopieren und anschliessend aus der leeren Tabelle in die ods-Datei
    System.out.print("teile start;" + start + "; ende;" + ende + "; Array: ");
    if (start < 10) {
      System.out.print(" ");
    } // end of if
    if (ende < 10) {
      System.out.print(" ");
    } // end of if
    System.out.print("; ");
    for (int i = 0; i < 20; i++) {
      if (originalarray[i] < 10) {
        System.out.print(" " + originalarray[i] + ";   ");
      } // end of if
      else {
        System.out.print(originalarray[i] + ";   ");
      } // end of if-else
    } // end of for
    System.out.println("");
    // ende Debug-Informationen
    while (links < rechts) { // solange i an j nicht vorbeigelaufen ist
      // Suche von links ein Element, welches grosser als das Pivotelement ist
      while ((originalarray[links] <= pivot) && (links < ende)) {
        links = links + 1;
      }
      // Suche von rechts ein Element, welches kleiner als das Pivotelement ist
      while ((originalarray[rechts] >= pivot) && (rechts > start)) {
        rechts = rechts - 1;
      }
      if (links < rechts) {
        int temp = originalarray[links];
        originalarray[links] = originalarray[rechts];
        originalarray[rechts] = temp;
      }
    }

    // Tausche Pivotelement (daten[rechts]) mit neuer endgultiger Position
    // (daten[i])

    if (originalarray[links] > pivot) {
      int temp = originalarray[links];
      originalarray[links] = originalarray[ende];
      originalarray[ende] = temp;
    }
    return links;// gib die Position des Pivotelements zuruck
  }

  public void sortit2() { // selection mit einer Tabelle
    for (int i = 0; i < arraylaenge; i++) {
      zielarray[i] = originalarray[i];
    }

  }

  public void Selection_2_Table_ActionPerformed(ActionEvent evt) {
    sortit1();
  }

  public void sortieren11_ActionPerformed(ActionEvent evt) {
    sortit2();
  }

  // Ende Methoden

  public static void main(String[] args) {
    new Sortieralgorithmen_Quicksort("Sortieralgorithmen_Quicksort");
  }
}
