package kleurapplet;

import kleurapplet.grnuminput.NumberListener;

import java.awt.*;
import java.util.Observable;

/**
 * Created by royho on 2-10-2016.
 */
public class Kleur extends Observable implements NumberListener {
    private int roodvalue = 127;
    private int groenvalue = 127;
    private int blauwvalue = 127;
    private float[] hsbvalues;

    public Kleur() {
        hsbvalues = Color.RGBtoHSB(roodvalue, groenvalue, blauwvalue, hsbvalues);
    }

    @Override
    public void numberChanged(String name, double value) {
        if ( name.equals("Rood") )
        {	roodvalue = (int)value;		// harde cast!! v loopt van 0 tot 255 met 0 decimalen!
            adjustHSBValues();
        } else if ( name.equals("Groen") )
        {	groenvalue = (int)value;
            adjustHSBValues();
        } else if ( name.equals("Blauw") )
        {	blauwvalue = (int)value;
            adjustHSBValues();
        } else if ( name.equals("Tint") )
        {	hsbvalues[0] = (float)value;	// harde cast!! v loopt van 0 tot 1 met 3 decimalen!
            adjustRGBValues();
        } else if ( name.equals("Verzadiging") )
        {	hsbvalues[1] = (float)value;
            adjustRGBValues();
        } else 	// must be "Helderheid"
        {	hsbvalues[2] = (float)value;
            adjustRGBValues();
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Bij verandering van RGB moet HSB worden aangepast
     */
    private void adjustHSBValues()
    {
        hsbvalues = Color.RGBtoHSB(roodvalue, groenvalue, blauwvalue, hsbvalues);
    }

    /**
     * Bij verandering van HSB moet RGB worden aangepast
     */
    private void adjustRGBValues()
    {	Color c = Color.getHSBColor(hsbvalues[0], hsbvalues[1], hsbvalues[2]);
        roodvalue = c.getRed();
        groenvalue = c.getGreen();
        blauwvalue = c.getBlue();
    }

    public int getRoodValue() {
        return roodvalue;
    }

    public int getGroenValue() {
        return groenvalue;
    }

    public int getBlauwValue() {
        return blauwvalue;
    }

    public float[] getHsbValues() {
        return hsbvalues;
    }
}
