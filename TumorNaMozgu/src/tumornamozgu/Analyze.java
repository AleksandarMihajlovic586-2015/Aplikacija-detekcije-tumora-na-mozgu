package tumornamozgu;

import ij.IJ;
import ij.ImagePlus;
import ij.io.Opener;

public class Analyze {
	public Analyze() {	
	}
	public void analyzing(String ulaz) {
		Opener o = new Opener();
		ImagePlus slika = o.openImage(ulaz);
		slika.show(); 
		
                IJ.setThreshold(146.0, 262.0);
		
		
		IJ.run("Analyze Particles...", "size=150-Infinity pixel circularity=0.20-1.00 show=[Overlay Masks] exclude ");
	}
}

