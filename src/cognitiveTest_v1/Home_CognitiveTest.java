package cognitiveTest_v1;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Home_CognitiveTest extends JFrame {

	private CognitiveTest guiCognitiveTest;
	
	private JMenuBar jMenuBar1;
    
	private JMenu menuCognitiveTest;
    private JMenuItem menuItemInitTest;
    
    private JMenu menuAbout;
    
   
    private ImageHomePanel imgHomePanel;

    
    public Home_CognitiveTest() {
        super("Home :: Teste de Cognição");
        initComponents();
    }
    
    private void initComponents(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        
        jMenuBar1 = new JMenuBar();
        
        menuCognitiveTest = new JMenu();
        menuItemInitTest = new JMenuItem();
        

        menuCognitiveTest.setText("Teste");
        menuItemInitTest.setText("Iniciar Teste");
        menuItemInitTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuItemInitTestActionPerformed(evt);
            }
        });
        menuCognitiveTest.add(menuItemInitTest);
        
        jMenuBar1.add(menuCognitiveTest);
        
        menuAbout = new JMenu();
        menuAbout.setText("Sobre");

        
        jMenuBar1.add(menuAbout);


        setJMenuBar(jMenuBar1);
        
        imgHomePanel = new ImageHomePanel();
        imgHomePanel.setLayout(new GridLayout(1,1,50,50));
      
       
        this.getContentPane().add(imgHomePanel);
        

        setResizable(false);

        pack();
        this.setSize(637, 420);

	
    }
    
    private void menuItemInitTestActionPerformed(java.awt.event.ActionEvent evt){
    	guiCognitiveTest = new CognitiveTest();
    	
    	guiCognitiveTest.setLocationRelativeTo(null);
    	guiCognitiveTest.setVisible(true);
    }
    
    
    
    public static void main(String args[]) {
   	 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home_CognitiveTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_CognitiveTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_CognitiveTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_CognitiveTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_CognitiveTest().setVisible(true);
            }
        });
      }
    
 
}
