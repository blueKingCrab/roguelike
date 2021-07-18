import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import src.ui.window.Window;
import src.maps.Map;

import java.io.FileWriter;
import java.io.IOException;

public class Roguelike extends JFrame {
 
   public Roguelike(Map m) {

      initUI(m);
   }

   private void initUI(Map m) {

	  getContentPane().add(new Window(), BorderLayout.CENTER);
      setSize(500, 500);
      setTitle("Roguelike");
      JLabel map =  new JLabel(m.toString());
      this.add(map);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setLocationRelativeTo(null);
      //this.pack();   
   }    

   public static void main(String[] args) {
   
      Map m = new Map();
      System.out.println(m.toString());
      
      try{
         FileWriter f = new FileWriter("test.txt");
         f.write(m.toString());
         f.close();
         
      
      } catch (IOException e) {
         System.out.println("Error in file editing: ");
         e.printStackTrace();
      
      }

      EventQueue.invokeLater(() -> {
         Roguelike ex = new Roguelike(m);
         ex.setVisible(true);
      });
   }
}