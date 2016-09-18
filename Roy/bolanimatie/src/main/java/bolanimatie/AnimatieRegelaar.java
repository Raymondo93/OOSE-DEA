package bolanimatie;

/**
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import javax.swing.*;

class AnimatieRegelaar extends JPanel
		implements ActionListener
{	// Variables
	private BolAnimatie ba;

    private boolean threadstarted = false;
	
	private JLabel richtingLabel;
	private JTextField richtingInput;
	private JButton richtingOk;
	
	private JButton stapbutton;
    private JButton startbutton;
	
	private JLabel snelheidLabel;
	private JTextField snelheidInput;
	private JButton snelheidOk;
	
	public AnimatieRegelaar(BolAnimatie b, Color bg)
	{	ba = b;
		Font display = new Font("SansSerif", Font.PLAIN, 12);
		setBackground(bg);
	
		setSize(250, 400);
		setLayout(null);
		
		richtingLabel = new JLabel("Richting (0-90)");
		richtingLabel.setFont(display);
		richtingLabel.setVisible(true);
		richtingLabel.setSize(100, 20);
		richtingLabel.setLocation(5, 20);
		add(richtingLabel);
		richtingInput = new JTextField(Integer.toString(BolAnimatie.STARTRICHTING), 5);
		richtingInput.setFont(display);
		richtingInput.setVisible(true);
		richtingInput.setSize(60, 24);
		richtingInput.setLocation(110, 20);
		add(richtingInput);
		richtingOk = new JButton( "Ok");
		richtingOk.addActionListener(this);
		richtingOk.setFont(display);
		richtingOk.setVisible(true);
		richtingOk.setEnabled(true);
		richtingOk.setSize(60, 24);
		richtingOk.setLocation(180, 20);
		add(richtingOk);
		
		stapbutton = new JButton( "Step" );
		stapbutton.addActionListener(this);
		stapbutton.setFont(display);
		stapbutton.setVisible(true);
		stapbutton.setEnabled(true);
		stapbutton.setSize(120, 25);
		stapbutton.setLocation(5, 200);
		add(stapbutton);

        startbutton = new JButton("Start");
        startbutton.addActionListener(this);
        startbutton.setFont(display);
        startbutton.setVisible(true);
        startbutton.setEnabled(true);
        startbutton.setSize(120, 25);
        startbutton.setLocation(5, 250);
        add(startbutton);
						
		snelheidLabel = new JLabel("Snelheid (1-50)");
		snelheidLabel.setFont(display);
		snelheidLabel.setVisible(true);
		snelheidLabel.setSize(100, 20);
		snelheidLabel.setLocation(5, 300);
		add(snelheidLabel);
		snelheidInput = new JTextField(Integer.toString(BolAnimatie.STARTSNELHEID), 5);
		snelheidInput.setFont(display);
		snelheidInput.setVisible(true);
		snelheidInput.setSize(60, 24);
		snelheidInput.setLocation(110, 300);
		add(snelheidInput);
		snelheidOk = new JButton( "Ok");
		snelheidOk.addActionListener(this);
		snelheidOk.setFont(display);
		snelheidOk.setVisible(true);
		snelheidOk.setEnabled(true);
		snelheidOk.setSize(60, 24);
		snelheidOk.setLocation(180, 300);
		add(snelheidOk);
	}

// ----- Listeners, ActionListener -------
	
	public void actionPerformed(ActionEvent e)
	{	if ( e.getSource() == stapbutton )
		{	ba.paintStep();
		}
		if (e.getSource() == startbutton) {
            if(startbutton.getText() == "Stop") {
                startbutton.setText("Start");
                ba.pauseThread();
                ba.threadHasStopped(false);
                System.out.println(ba.running);

            }
            else if(startbutton.getText() == "Start") {
                if(ba.stopped || ba.dead) {
                    startbutton.setText("Stop");
                    ba.resumeThread();
                    System.out.println(ba.running);
                    if(ba.dead) {
                        ba.xpos = (ba.SIZE-ba.BOLSIZE)/2;		// zet balletje in het midden
                        ba.ypos = (ba.SIZE-ba.BOLSIZE)/2;
                    }
                    ba.dead = false;
                }
            }
        }
		else if ( e.getSource() == richtingOk )
		{	try
			{	int ri = Integer.parseInt(richtingInput.getText());
				ba.setRichting(ri);
			} catch ( NumberFormatException e1 )
			{}								// niks doen als input niet ok is...
		} else if ( e.getSource() == snelheidOk )
		{	int v = 0;
			try
			{	int s = Integer.parseInt(snelheidInput.getText());
				ba.setSnelheid(s);
			} catch ( NumberFormatException e2 )
			{}
		}
	}

}
