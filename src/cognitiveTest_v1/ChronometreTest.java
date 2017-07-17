package cognitiveTest_v1;
	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
  
    
public class ChronometreTest  {
	public static void main(String arg[]){
		
		long inicio = System.currentTimeMillis();
        long t;
         
        for (int i = 1;i<1000000000;i++) {
         t = System.currentTimeMillis() - inicio;
           
           System.out.println((t / 1000));
           
          
        }
		
	}
}



