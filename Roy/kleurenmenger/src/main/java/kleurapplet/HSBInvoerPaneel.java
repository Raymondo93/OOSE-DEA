/*
 * HSBInvoerPaneel.java		13 maart 2003, Paul Bergervoet
 *
 */

package kleurapplet;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import kleurapplet.grnuminput.*;

class HSBInvoerPaneel extends Panel implements Observer
{
	private Kleur kleur;

	// Variables
	private NumberSlider hue;
	private NumberSlider sat;
	private NumberSlider bright;

	public HSBInvoerPaneel(Kleur kleur)
	{
		this.kleur = kleur;
		// NB: mwt klassieke awt, niet met behulp van Swing-componenten.
		setBackground(new Color(204, 204, 204));	
		GridLayout g = new GridLayout(3, 1);
		g.setHgap(10);
		setLayout(g);
						
		hue = new NumberSlider(0, 1, 0.5, 2, "Tint", "");
		hue.addNumberListener(kleur);
		add(hue);
		
		sat = new NumberSlider(0, 1, 0.5, 2, "Verzadiging", "");
		sat.addNumberListener(kleur);
		add(sat);

		bright = new NumberSlider(0, 1, 0.5, 2, "Helderheid", "");
		bright.addNumberListener(kleur);
		add(bright);
	}	

	public void setSliders(float h, float s, float b)
	{	hue.setValue(h);
		sat.setValue(s);
		bright.setValue(b);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(kleur == o) {
			setSliders(kleur.getHsbValues()[0], kleur.getHsbValues()[1], kleur.getHsbValues()[2]);
		}
	}
}
