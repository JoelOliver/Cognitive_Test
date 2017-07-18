/* @author : Joel Oliveira Ribeiro
 * Student of Computer Engineering at the Federal University of Ceara from Brazil
 * Test of Cognition for general Activities and Monitoring
*/
package cognitiveTest_v1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;


public class CognitiveTest extends JFrame implements KeyListener {

	private JLabel testLabel,leftIconSetLabel,rightIconSetLabel,chronometreLabel;
	private JButton firstOption,secondOption,stopButton;
	private JPanel labelPanel,optionsPanel,setsPanel,stopPanel,generalPanel,chronometrePanel;
	
	// Numeros gerados para garantir a aleatoriedade do teste cognitivo
    private int numberRandom1,numberRandom2;
	
    // Quantidade de acertos
    private int hits,count;
    private ArrayList<Integer> vectorHitsMistakes;
    
    // Variaveis de tempo
    protected long startTime,stopTime,endTime;
    protected ArrayList<Long> timeResponsesHits,timeResponsesMistakes;
	
	public CognitiveTest(){
		super("Teste de Cognição");
		
		
		
		startTime = System.currentTimeMillis();
		
		timeResponsesHits = new ArrayList<Long>();
		timeResponsesMistakes = new ArrayList<Long>();

		vectorHitsMistakes = new ArrayList<Integer>();
		
		hits=0;
		count=0;
		
		labelPanel=new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    do{
	    	numberRandom1 = randomIntGenerate6();
	    	numberRandom2 = randomIntGenerate6();
	    	
	    }while(numberRandom1 == numberRandom2);
		
		testLabel=new JLabel(randomNameLabel(numberRandom1)); testLabel.setForeground(randomColorLabel(numberRandom2));
		testLabel.setFont(new Font("Dialog", Font.PLAIN, 50));
		labelPanel.add(testLabel);
		
		optionsPanel=new JPanel();
		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		String nameFirstOption=" "; String nameSecondOption=" ";
		if(randomIntGenerate2() == 0){
			nameFirstOption=randomNameLabel(numberRandom1);
			nameSecondOption=randomNameLabel(numberRandom2);
		}
		else{
		
			nameFirstOption=randomNameLabel(numberRandom2);
			nameSecondOption=randomNameLabel(numberRandom1);
		}
		firstOption = new JButton(nameFirstOption); 
		firstOption.setFocusPainted(false);
		firstOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstOptionActionPerformed(evt);
            }
        });
		firstOption.addKeyListener(this);
		
		secondOption = new JButton(nameSecondOption);
		secondOption.setFocusPainted(false);
		secondOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondOptionActionPerformed(evt);
            }
        });
		secondOption.addKeyListener(this);
		optionsPanel.add(firstOption); optionsPanel.add(secondOption);
		
		
		setsPanel = new JPanel();
		setsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		ImageIcon rightSetIcon = new ImageIcon("rightSetIcon.png");
		ImageIcon leftSetIcon = new ImageIcon("leftSetIcon.png");
		rightIconSetLabel=new JLabel();
		rightIconSetLabel.setIcon(rightSetIcon);
		leftIconSetLabel=new JLabel();
		leftIconSetLabel.setIcon(leftSetIcon);
		setsPanel.add(this.leftIconSetLabel);setsPanel.add(new JPanel());setsPanel.add(new JPanel());setsPanel.add(rightIconSetLabel);
		
		
		stopPanel = new JPanel ();
		stopPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		stopButton = new JButton ("Parar o teste");
		stopButton.setFont(new Font("Dialog", Font.BOLD, 15));
		stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	stopButtonActionPerformed(evt);
            }
        });
		stopPanel.add(this.stopButton);
		
		
		generalPanel=new JPanel();
		generalPanel.setLayout(new GridLayout(4,1,30,30));
		generalPanel.add(labelPanel);generalPanel.add(optionsPanel);generalPanel.add(setsPanel);generalPanel.add(stopPanel);

		this.getContentPane().add(generalPanel);
		
		setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        this.setSize(400, 400);
		
	}
	
	// Funcao que gera um numero aleatorio entre 0 e 7
	public int randomIntGenerate6(){
		Random r = new Random();
		int numberRandom = r.nextInt(8); 
	return numberRandom;}
	
	// Funcao que gera um numero aleatorio 0 ou 1
	public int randomIntGenerate2(){
		Random r = new Random();
		int numberRandom = r.nextInt(2); 
	return numberRandom;}
	
	// Funcao que retorna um nome do tipo String para ser alocada como String da label do Teste
	public String randomNameLabel(int numberName){
		String name="COR ALEATORIA";	
		
		if(numberName == 0)
			name="BRANCO";
		if(numberName == 1)
			name="AMARELO";
		if(numberName == 2)
			name="VERMELHO";
		if(numberName == 3)
			name="VERDE";
		if(numberName == 4)
			name="AZUL";
		if(numberName == 5)
			name="PRETO";
		if(numberName == 6)
			name="CINZA";
		if(numberName == 7)
			name="LARANJA";
		 
	return name;}
	
	// Funcao que retorna uma cor do tipo Color para ser alocada como Cor fonte da String da label do Teste
	public Color randomColorLabel(int numberColor){
		Color color=Color.DARK_GRAY; // DEFAULT;
		Random r = new Random();
		
		if(numberColor == 0)
			color=Color.WHITE;
		if(numberColor == 1)
			color=Color.YELLOW;
		if(numberColor == 2)
			color=Color.RED;
		if(numberColor == 3)
			color=Color.GREEN;
		if(numberColor == 4)
			color=Color.BLUE;
		if(numberColor == 5)
			color=Color.BLACK;
		if(numberColor == 6)
			color=Color.GRAY;
		if(numberColor == 7)
			color=Color.ORANGE;
		
		 
	return color;}
	
	// Funcoes para definir os eventos em cima dos botoes de opcoes
	
	private void firstOptionActionPerformed(java.awt.event.ActionEvent evt){
       
	  count+=1;	
		if(firstOption.getText() == testLabel.getText()){
			
			hits+=1;
			this.vectorHitsMistakes.add(1);
			this.registerTimeResponseHit(System.currentTimeMillis());
			
			do{
		    	numberRandom1 = randomIntGenerate6();
		    	numberRandom2 = randomIntGenerate6();
		    	
		    }while(numberRandom1 == numberRandom2);
			
			this.testLabel.setText(this.randomNameLabel(numberRandom1));
			this.testLabel.setForeground(this.randomColorLabel(numberRandom2));
			
			String nameFirstOption=" "; String nameSecondOption=" ";
			if(randomIntGenerate2() == 0){
			
				nameFirstOption=randomNameLabel(numberRandom1);
				nameSecondOption=randomNameLabel(numberRandom2);
			}
			else{
				
				nameFirstOption=randomNameLabel(numberRandom2);
				nameSecondOption=randomNameLabel(numberRandom1);
			}
			
			this.firstOption.setText(nameFirstOption);
			this.secondOption.setText(nameSecondOption);
			
	       // pack();

		}
		else{
			
			this.registerTimeResponseMistake(System.currentTimeMillis());
			this.vectorHitsMistakes.add(0);

			
			do{
		    	numberRandom1 = randomIntGenerate6();
		    	numberRandom2 = randomIntGenerate6();
		    	
		    }while(numberRandom1 == numberRandom2);
			
			this.testLabel.setText(this.randomNameLabel(numberRandom1));
			this.testLabel.setForeground(this.randomColorLabel(numberRandom2));
			
			String nameFirstOption=" "; String nameSecondOption=" ";
			if(randomIntGenerate2() == 0){
				
				nameFirstOption=randomNameLabel(numberRandom1);
				nameSecondOption=randomNameLabel(numberRandom2);
			}
			else{
				
				nameFirstOption=randomNameLabel(numberRandom2);
				nameSecondOption=randomNameLabel(numberRandom1);
			}
			
			this.firstOption.setText(nameFirstOption);
			this.secondOption.setText(nameSecondOption);
			
	       // pack();

		}
	}
	
	private void secondOptionActionPerformed(java.awt.event.ActionEvent evt){
	
		count+=1;	

		if(secondOption.getText() == testLabel.getText()){
			
			hits+=1;
            this.registerTimeResponseHit(System.currentTimeMillis());
			this.vectorHitsMistakes.add(1);

			
            do{
		    	numberRandom1 = randomIntGenerate6();
		    	numberRandom2 = randomIntGenerate6();
		    	
		    }while(numberRandom1 == numberRandom2);
			
			this.testLabel.setText(this.randomNameLabel(numberRandom1));
			this.testLabel.setForeground(this.randomColorLabel(numberRandom2));
			
			String nameFirstOption=" "; String nameSecondOption=" ";
			if(randomIntGenerate2() == 0){
				
				nameFirstOption=randomNameLabel(numberRandom1);
				nameSecondOption=randomNameLabel(numberRandom2);
			}
			else{
				
				nameFirstOption=randomNameLabel(numberRandom2);
				nameSecondOption=randomNameLabel(numberRandom1);
			}
			
			this.firstOption.setText(nameFirstOption);
			this.secondOption.setText(nameSecondOption);
			
	      //  pack();

			
		}
		else{
			
			this.registerTimeResponseMistake(System.currentTimeMillis());
			this.vectorHitsMistakes.add(0);

			
			do{
		    	numberRandom1 = randomIntGenerate6();
		    	numberRandom2 = randomIntGenerate6();
		    	
		    }while(numberRandom1 == numberRandom2);
			
			this.testLabel.setText(this.randomNameLabel(numberRandom1));
			this.testLabel.setForeground(this.randomColorLabel(numberRandom2));
			
			String nameFirstOption=" "; String nameSecondOption=" ";
			if(randomIntGenerate2() == 0){
				
				nameFirstOption=randomNameLabel(numberRandom1);
				nameSecondOption=randomNameLabel(numberRandom2);
			}
			else{
				
				nameFirstOption=randomNameLabel(numberRandom2);
				nameSecondOption=randomNameLabel(numberRandom1);
			}
			
			this.firstOption.setText(nameFirstOption);
			this.secondOption.setText(nameSecondOption);
			
	     //   pack();

		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		count+=1;	

		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			
			
			
			if(firstOption.getText() == testLabel.getText()){
				
				hits+=1;
                this.registerTimeResponseHit(System.currentTimeMillis());
    			this.vectorHitsMistakes.add(1);

				
                do{
			    	numberRandom1 = randomIntGenerate6();
			    	numberRandom2 = randomIntGenerate6();
			    	
			    }while(numberRandom1 == numberRandom2);
				
				this.testLabel.setText(this.randomNameLabel(numberRandom1));
				this.testLabel.setForeground(this.randomColorLabel(numberRandom2));
				
				String nameFirstOption=" "; String nameSecondOption=" ";
				if(randomIntGenerate2() == 0){
					
					nameFirstOption=randomNameLabel(numberRandom1);
					nameSecondOption=randomNameLabel(numberRandom2);
				}
				else{
					
					nameFirstOption=randomNameLabel(numberRandom2);
					nameSecondOption=randomNameLabel(numberRandom1);
				}
				
				this.firstOption.setText(nameFirstOption);
				this.secondOption.setText(nameSecondOption);
				
		     //   pack();

			}
			else{
				
				this.registerTimeResponseMistake(System.currentTimeMillis());
				this.vectorHitsMistakes.add(0);

				
				do{
			    	numberRandom1 = randomIntGenerate6();
			    	numberRandom2 = randomIntGenerate6();
			    	
			    }while(numberRandom1 == numberRandom2);
				
				this.testLabel.setText(this.randomNameLabel(numberRandom1));
				this.testLabel.setForeground(this.randomColorLabel(numberRandom2));
				
				String nameFirstOption=" "; String nameSecondOption=" ";
				if(randomIntGenerate2() == 0){
					
					nameFirstOption=randomNameLabel(numberRandom1);
					nameSecondOption=randomNameLabel(numberRandom2);
				}
				else{
					
					nameFirstOption=randomNameLabel(numberRandom2);
					nameSecondOption=randomNameLabel(numberRandom1);
				}
				
				this.firstOption.setText(nameFirstOption);
				this.secondOption.setText(nameSecondOption);
				
		   //     pack();

			}
	        

	    }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
	    	if(secondOption.getText() == testLabel.getText()){
				
	    		hits+=1;
                this.registerTimeResponseHit(System.currentTimeMillis());
    			this.vectorHitsMistakes.add(1);

	    		
				do{
			    	numberRandom1 = randomIntGenerate6();
			    	numberRandom2 = randomIntGenerate6();
			    	
			    }while(numberRandom1 == numberRandom2);
				
				this.testLabel.setText(this.randomNameLabel(numberRandom1));
				this.testLabel.setForeground(this.randomColorLabel(numberRandom2));
				
				String nameFirstOption=" "; String nameSecondOption=" ";
				if(randomIntGenerate2() == 0){
					
					nameFirstOption=randomNameLabel(numberRandom1);
					nameSecondOption=randomNameLabel(numberRandom2);
				}
				else{
					
					nameFirstOption=randomNameLabel(numberRandom2);
					nameSecondOption=randomNameLabel(numberRandom1);
				}
				
				this.firstOption.setText(nameFirstOption);
				this.secondOption.setText(nameSecondOption);
				
		      //  pack();

				
			}
			else{
				
				this.registerTimeResponseMistake(System.currentTimeMillis());
				this.vectorHitsMistakes.add(0);

				
				do{
			    	numberRandom1 = randomIntGenerate6();
			    	numberRandom2 = randomIntGenerate6();
			    	
			    }while(numberRandom1 == numberRandom2);
				
				this.testLabel.setText(this.randomNameLabel(numberRandom1));
				this.testLabel.setForeground(this.randomColorLabel(numberRandom2));
				
				String nameFirstOption=" "; String nameSecondOption=" ";
				if(randomIntGenerate2() == 0){
					
					nameFirstOption=randomNameLabel(numberRandom1);
					nameSecondOption=randomNameLabel(numberRandom2);
				}
				else{
					
					nameFirstOption=randomNameLabel(numberRandom2);
					nameSecondOption=randomNameLabel(numberRandom1);
				}
				
				this.firstOption.setText(nameFirstOption);
				this.secondOption.setText(nameSecondOption);
				
		       // pack();

			}
	        
	   }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	 
    protected void registerTimeResponseHit(long time){
    	if(count == 1){
    		stopTime = time;
    		long timeResponse = stopTime - startTime;
		    timeResponsesHits.add(timeResponse);
    	}
    	else{
    		long timeResponse = time - stopTime ;
		    timeResponsesHits.add(timeResponse);
		    stopTime = time;
    	}
    }
    protected void registerTimeResponseMistake(long time){
    	if(count == 1){
    		stopTime = time;
    		long timeResponse = stopTime - startTime;
    		timeResponsesMistakes.add(timeResponse);

    	}
    	else{
    		long timeResponse = time - stopTime ;
    		timeResponsesMistakes.add(timeResponse);
    		stopTime = time;
    	}
    	
    }
    
    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt){
    	
    	JTextArea textArea = new JTextArea("Numero de respostas realizadas = "+ this.getCount()+"\n"
    	                                  +"Numero de acertos = "+this.hits+"\n"
    	                                  +"Numero de erros = "  +(this.getCount() - this.hits)+"\n"
    			                          +"Tempo total de realização do teste = "+this.getTimeInAplication()+"\n"
    	                                    
    			                            +"--------------------------------------------------------------"+"\n\n"+
    			                            this.getGeneralAnalise()
    			
    		                           );
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 900, 600 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "------ Analise do Teste ------",  
		                                       JOptionPane.DEFAULT_OPTION);
		
		this.setVisible(false);

    	
    }
    
    
    protected int getCount(){
    	
    return count;}
    
    protected String getTimeInAplication(){
    	long totalSeconds = (System.currentTimeMillis() - this.startTime)/1000;
    	
    	int seconds = (int) totalSeconds % 60; 
    	int minutes = (int) (totalSeconds % 3600) / 60;    
    	
    return String.format("%02d minuto(s) e %02d segundo(s)", minutes, seconds); }
    
        
    protected String getGeneralAnalise(){
    	
    	int temp1=0;
    	int temp2=0;
    	String generalAnalise = "                                   ~ Analise geral ~   \n \n";
    	
    	for(int i=0;i<this.vectorHitsMistakes.size();i++){
    		if(vectorHitsMistakes.get(i) == 1){ 
    			// acertos
    			generalAnalise+="Resposta "+(i+1)+":\tACERTOU\t:"+this.timeResponsesHits.get(temp1)+" ms \n";
    			temp1+=1;
    		}
    		else{ 
    			//erros
    			generalAnalise+="Resposta "+(i+1)+":\tERROU\t:"+this.timeResponsesMistakes.get(temp2)+" ms \n";
    			temp2+=1;    		
    			}
    	  }
    	
    return generalAnalise;}
    
    //testing the class ...
    public static void main(String[] arg) {
    	
        
       CognitiveTest test = new CognitiveTest();
       
    }

}

