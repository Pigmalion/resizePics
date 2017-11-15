import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.imageio.ImageIO;

public class Main {

	
private static  ArrayList<File> getAllFiles(File file ) {
ArrayList<File> arrayOfFiles = new ArrayList<File>();
	if(file.isDirectory()) {
		File[] list = file.listFiles();
		for(File f: list) {
			if(f.isDirectory()) {
				arrayOfFiles.addAll(getAllFiles(f));
			}else {
				
				if(f.getName().endsWith("png" ))
					arrayOfFiles.add(f);
			}
		}
	}
	return arrayOfFiles;
}


public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\i323891\\Pictures\\";
//		String path  = "C:\\Users\\i323891\\eclipse-oxygen\\eclipse\\configuration\\org.eclipse.osgi\\";
		File file= new File(path);
		
		
		 ArrayList<File> allFilesFound = getAllFiles(file);
		 System.out.println(allFilesFound.size() + "files found...");
	for (File fileFound: allFilesFound) {
	
		try {
			
			BufferedImage img = ImageIO.read(fileFound);
			if(img.getType() == 0)
				img = new BufferedImage(img.getWidth(), img.getHeight(),BufferedImage.TYPE_INT_ARGB);
			
			System.out.println("Before Change: "+fileFound.getPath()+" is =>> "+img.getHeight());
			
			if (img.getHeight()<=20 && img.getWidth()<=20 ){
				
			Converter converter = new Converter();
			img = converter.resizeImg(img);
			System.out.println("After Change: " + img.getHeight());
			String newPath = fileFound.getPath();
			System.out.println("Preparing to write: " + newPath);
			boolean success = ImageIO.write(img, "png", new File(newPath));
			if (success)
				System.out.println("File " + fileFound.getPath() + " Inlarged successfuly");
			else System.out.println("File " + fileFound.getAbsolutePath() + " Failed on process");
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
}
