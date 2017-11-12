import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Converter {
	BufferedImage resizeImg(BufferedImage img){
	    int w = img.getWidth();
	    int h = img.getHeight();
	    BufferedImage dimg = new BufferedImage(2*w, 2*h, img.getType());
	    Graphics2D g = dimg.createGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(img, 0, 0, 2*w, 2*h, 0, 0, w, h, null);
	    g.dispose();
	    return dimg;      
	   }
	
}
