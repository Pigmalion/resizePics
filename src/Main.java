import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path  = "C:\\Users\\i323891\\Pictures\\Saved Pictures\\";
		String fileName = "128.png";
		File file= new File(path+fileName);
		System.out.println(file.isFile());
		try {
			
			BufferedImage img = ImageIO.read(file);
			int type = img.getType() == 0? BufferedImage.TYPE_INT_ARGB : img.getType();

			Converter converter = new Converter();
			img = converter.resizeImg(img);
			System.out.println(img.getHeight());
			ImageIO.write(img, "png", new File(path+"256.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
