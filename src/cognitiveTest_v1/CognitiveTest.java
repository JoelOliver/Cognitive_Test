/* @author : Joel Oliveira Ribeiro
 * Student of Computer Engineering at the Federal University of Ceara from Brazil
 * Test of Cognition for general Activities and Monitoring
*/
package cognitiveTest_v1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;


public class CognitiveTest extends JFrame implements ActionListener {

	private JLabel testLabel,hitsLabel;
	private JButton firstOption,secondOption;
	private JPanel labelPanel,optionsPanel,hitsPanel,generalPanel;
	
	public CognitiveTest(){
		super("Teste de Cognição");
		
		labelPanel=new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Numeros gerados para garantir a aleatoriedade do teste cognitivo
	    int numberRandom1,numberRandom2;
	    
	    do{
	    	numberRandom1 = randomIntGenerate6();
	    	numberRandom2 = randomIntGenerate6();
	    	
	    }while(numberRandom1 == numberRandom2);
		
		testLabel=new JLabel(randomNameLabel(numberRandom1)); testLabel.setForeground(randomColorLabel(numberRandom2));
		testLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
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
		firstOption = new JButton(nameFirstOption); firstOption.addActionListener(this);
		secondOption = new JButton(nameSecondOption);secondOption.addActionListener(this);
		optionsPanel.add(firstOption); optionsPanel.add(secondOption);
		
		hitsPanel=new JPanel();
		hitsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		hitsLabel=new JLabel("Acertos :    ");
		hitsPanel.add(hitsLabel);
		
		generalPanel=new JPanel();
		generalPanel.setLayout(new GridLayout(3,1,30,30));
		generalPanel.add(labelPanel);generalPanel.add(optionsPanel);generalPanel.add(hitsPanel);

		this.getContentPane().add(generalPanel);
		
		setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
		
	}
	
	// Funcao que gera um numero aleatorio entre 0 e 5
	public int randomIntGenerate6(){
		Random r = new Random();
		int numberRandom = r.nextInt(6); 
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
		
		 
	return color;}
	
	
	@Override // Funcao para definir os eventos em cima dos obtoes de opcoes 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	
	 
	
	
	// TESTING!
	   public static void main(String arg[]){
		   CognitiveTest test=new CognitiveTest();
	   }

}

