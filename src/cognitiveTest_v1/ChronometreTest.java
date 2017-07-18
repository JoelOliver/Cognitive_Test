package cognitiveTest_v1;
	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
  
    
public class ChronometreTest {
	private long begin, end;
	 
    public void start(){
        begin = System.currentTimeMillis();
    }
 
    public void stop(){
        end = System.currentTimeMillis();
    }
 
    public long getTime() {
        return end-begin;
    }
 
    public long getMilliseconds() {
        return end-begin;
    }
 
    public double getSeconds() {
        return (end - begin) / 1000.0;
    }
 
    public double getMinutes() {
        return (end - begin) / 60000.0;
    }
 
    public double getHours() {
        return (end - begin) / 3600000.0;
    }
 
    
    public static void main(String[] arg) {
    	ChronometreTest ch = new ChronometreTest();
         
    	int ante=0;
    	int pro=0;
    	int min;
    	
        ch.start();
        while (pro != 120) {
        
        ch.stop();
        pro=(int)ch.getSeconds();
        if(ante!=pro){
        System.out.println((int)ch.getMinutes()+"::"+pro);
        ante=pro;
                   }
        }
        
       
 
    }
}



