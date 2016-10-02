package kleurapplet;

import kleurapplet.grnuminput.NumberListener;

import java.awt.*;
import java.util.*;

public class Kleur extends Observable implements NumberListener {

    // Variables
    private int roodval;
    private int groenval;
    private int blauwval;
    private float[] hsbvalues;

    public Kleur()
    {
        roodval = 127;
        groenval = 127;
        blauwval = 127;
        hsbvalues = Color.RGBtoHSB(roodval, groenval, blauwval, hsbvalues);
    }

    public int getRoodval() {
        return roodval;
    }

    public int getGroenval() {
        return groenval;
    }

    public int getBlauwval() {
        return blauwval;
    }

    public float[] getHsbvalues() {
        return hsbvalues;
    }

    /**
     * Bij verandering van RGB moet HSB worden aangepast
     */
    private void adjustHSBValues()
    {
        hsbvalues = Color.RGBtoHSB(roodval, groenval, blauwval, hsbvalues);
        setChanged();
    }

    /**
     * Bij verandering van HSB moet RGB worden aangepast
     */
    private void adjustRGBValues()
    {
        Color c = Color.getHSBColor(hsbvalues[0], hsbvalues[1], hsbvalues[2]);
        roodval = c.getRed();
        groenval = c.getGreen();
        blauwval = c.getBlue();
        setChanged();
    }

    public void numberChanged(String naam, double v)
    {	if ( naam.equals("Rood") )
    {	roodval = (int)v;		// harde cast!! v loopt van 0 tot 255 met 0 decimalen!
        adjustHSBValues();
    } else if ( naam.equals("Groen") )
    {	groenval = (int)v;
        adjustHSBValues();
    } else if ( naam.equals("Blauw") )
    {	blauwval = (int)v;
        adjustHSBValues();
    } else if ( naam.equals("Tint") )
    {	hsbvalues[0] = (float)v;	// harde cast!! v loopt van 0 tot 1 met 3 decimalen!
        adjustRGBValues();
    } else if ( naam.equals("Verzadiging") )
    {	hsbvalues[1] = (float)v;
        adjustRGBValues();
    } else 	// must be "Helderheid"
    {	hsbvalues[2] = (float)v;
        adjustRGBValues();
    }
        //repaint();
        //Notify
        if(hasChanged())
            notifyObservers();
    }

    /**
     * Vertaalt een RGB-component in een tweecijferige hexamdecimale waarde.
     * @param c
     */
        public String hexValue(int c)
        {	String h = Integer.toHexString(c);
            if ( h.length() == 1 )			// add zero voor eencijferige string
            {	h = "0".concat(h);
            }
            return h;
        }
}
