package cognitiveTest_v1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageHomePanel extends JPanel {
	
	private BufferedImage image;

    public ImageHomePanel() {
       try {                
          image = ImageIO.read(new File("cognitiveTest_image.jpg"));
          System.out.println("Imagem carregada na home com sucesso !!");
       } catch (IOException ex) {
            System.out.println("Nao esta pegando a imagem !!!");
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0,0, this); // see javadoc for more info on the parameters         
            }
    
   
}
