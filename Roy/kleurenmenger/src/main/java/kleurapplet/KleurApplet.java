/*
 * KleurApplet.java		13 maart 2003, Paul Bergervoet
 *
 * Applet toont kleurenmenger 
 */

package kleurapplet;

import java.awt.*;
import java.applet.*;

public class KleurApplet extends Applet
{
	Kleur kleur;
	KleurCanvas kc;
	RGBInvoerPaneel rgbip;
	HSBInvoerPaneel hsbip;

	public void init()
	{	// NB: mwt klassieke awt, niet met behulp van Swing-componenten.
		setLayout(new BorderLayout());
		kleur = new Kleur();
		kc = new KleurCanvas(kleur);
		kleur.addObserver(kc);
		add(kc, "Center");
		rgbip = new RGBInvoerPaneel(kleur);
		kleur.addObserver(rgbip);
		add(rgbip, "East");
		hsbip = new HSBInvoerPaneel(kleur);
		kleur.addObserver(hsbip);
		add(hsbip, "West");
		setSize(600,340);
		setVisible(true);
	}
}

	


    
