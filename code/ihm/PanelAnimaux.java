package code.ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanelAnimaux extends JPanel
{
	private Image img;
	
	public PanelAnimaux( String fichier )
	{
		this.img = getToolkit().getImage ( fichier );
		this.setBackground(new Color(0,0,0,0));
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//Image img = getToolkit().getImage ( "./images/BlobBocchi.gif" );
		g.drawImage( this.img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
