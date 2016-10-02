/*
 * KleurCanvas.java		13 maart 2003, Paul Bergervoet
 *
 */

package kleurapplet;
		 
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

class KleurCanvas extends Canvas implements Observer
{
    private Kleur kleur;

    // Variables for double buffering
	Dimension dd;
	private Image bufferTekening;		// Image tbv offline painting
	private Graphics bufferGraphics; 		// Graphics object van bufferTekening
	private Dimension bufferGrootte = new Dimension(0, 0); 	
    								// Size of Image, check with Frame size

    // Constants
    private static Color echtRood = new Color(255, 0, 0);
    private static Color echtGroen = new Color(0, 255, 0);
    private static Color echtBlauw = new Color(0, 0, 255);
    private static Font displayfont = new Font("SansSerif", Font.PLAIN, 12);
	
	public KleurCanvas(Kleur kleur)
	{
        this.kleur = kleur;
        kleur.addObserver(this);
		setBackground(Color.white);
		setSize(360, 340);
	}

    /**
 * Tekent naam van de kleurcomponent plus vlakje gekleurd in die component.
 * bij RGB  zetten we klein blokje in volle kleur voor de naam (argument fc)
 * Bij HSB niet, dan is dat arg null.
 *
 * @param naam Naam van de Kleurcomponent (Tint, Verzadiging, .., Rood ...)
 * @param c De te tekenen Kleurcomponent
 * @param fc Kleur van het blokje met volle kleur R, G of B. ja/nee
 * @param x De x-positie
 * @param y De y-positie
 * @param g De Graphics-context
 */
	private void paintKleurComponent(String naam, Color c, Color fc, int x, int y, Graphics g)
	{	int schuifx = 0;
		if ( fc != null )				// blokje echt rood/groen/blauw
		{	g.setColor(fc);
			g.fillRect(x, y+5, 10, 10);
			schuifx = 15;			// naam zometeen 15 pixels naar rechts
		}
		g.setColor(c);
		g.fillRoundRect(x, y+20, 60, 40, 5, 5);
		g.setColor(Color.black);
		g.drawString(naam, x+schuifx, y+15);
		g.drawRoundRect(x, y+20, 60, 40, 5, 5);
	}

	public void paint(Graphics g)
	{	g.setFont(displayfont);
		Color c;
		// --- tint ----
		c = Color.getHSBColor(kleur.getHsbvalues()[0], 1, 1);				// helderheid, verzadiging vol
		paintKleurComponent("Tint", c, null, 30, 20, g);
		// --- verzadiging ----
		c = Color.getHSBColor(kleur.getHsbvalues()[0], kleur.getHsbvalues()[1], 1);		// helderheid vol
		paintKleurComponent("Verzadiging", c, null, 30, 100, g);
		// --- helderheid ----
		c = Color.getHSBColor(kleur.getHsbvalues()[0], 0, kleur.getHsbvalues()[2]);		// verzadiging 0: grijs dus
		paintKleurComponent("Helderheid", c, null, 30, 180, g);
		
		// --- rood ----
		c = new Color(kleur.getRoodval(), 0, 0);
		paintKleurComponent("Rood", c, echtRood, 270, 20, g);
		// --- groen ----
		c = new Color(0, kleur.getGroenval(), 0);
		paintKleurComponent("Groen", c, echtGroen, 270, 100, g);
		// --- blauw ----
		c = new Color(0, 0, kleur.getBlauwval());
		paintKleurComponent("Blauw", c, echtBlauw, 270, 180, g);
		
		// --- menging ----
		g.setColor(new Color(kleur.getRoodval(), kleur.getGroenval(), kleur.getBlauwval()));
		g.fillRoundRect(120, 40, 120, 280, 5, 5);		
		g.setColor(Color.black);
		g.drawString("De kleur", 120, 35);
		g.drawRoundRect(120, 40, 120, 280, 5, 5);		
		
		// --- hexadecimaal RGB  ---
		g.setColor(Color.black);
		g.drawString("Hex. RGB:", 270, 300);
		String hrgb = "#";
		hrgb = hrgb.concat(kleur.hexValue(kleur.getRoodval()));
		hrgb = hrgb.concat(kleur.hexValue(kleur.getGroenval()));
		hrgb = hrgb.concat(kleur.hexValue(kleur.getBlauwval()));
		g.drawString(hrgb, 270, 315);		
	}
	
// ----- tbv double buffering
	public void update(Graphics g)
	{	dd = getSize();							// check eventuele resize...
		if ( 	bufferTekening == null || 				// Image is er nog niet of ..
				bufferGrootte.width != dd.width ||		// breedte/lengte van Canvas
				bufferGrootte.height != dd.height		// veranderd: dan nieuwe!
		   )
		{   bufferTekening = createImage(dd.width, dd.height);
	    	bufferGrootte = dd;
	    	bufferGraphics = bufferTekening.getGraphics();
		}
		//  Teken het nieuwe plaatje...
		bufferGraphics.setColor(Color.white);			// background vullen
		bufferGraphics.fillRect(0, 0, bufferGrootte.width, bufferGrootte.height);
		paint(bufferGraphics);					// laat paint in Image werken!
		g.drawImage(bufferTekening, 0, 0, null);		// zet Image op Canvas....
	}

	@Override
	public void update(Observable o, Object arg) {
        if(o == kleur)
            repaint();
	}
}
