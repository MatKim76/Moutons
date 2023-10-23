package code.ihm;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.Timer;

//but du jeu, survir avec le plus de moutons

//le mouton s'arrete quand cursor dessus
//le chien ou chasseur qui tue les loups avance dans direction aleatoire quand cursor dessus
//le loup qui tue les moutons change de direction quand on clique dessus

public class FrameAnimaux extends JFrame implements ActionListener, MouseListener
{
    private PanelAnimaux panel;
    private int posX;
    private int posY;
    private int clickCount;
    
    private int screenWidth;
    private int screenHeight;
    
    private int dirX;
    private int dirY;
    
    Timer timer;
    
    private String nom;
	
	private int taille;
    private int vitesseMax;
    private int vitesseMin;

    public FrameAnimaux(String nom, int taille, int vitesseMin, int vitesseMax)
	{
		this.nom = nom;
        this.taille = taille;
        this.vitesseMax = vitesseMax;
        this.vitesseMin = vitesseMin;//voir si utile

        this.clickCount = 0;

        this.panel = new PanelAnimaux("./images/" + this.nom + ".gif");
        this.add(this.panel);

        this.setSize(this.taille, this.taille);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setAlwaysOnTop(true);

        this.addMouseListener(this);

        this.setVisible(true);

        // Obtenir la taille de l'écran
        this.screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        // Init direction
        this.dirX = (int)(Math.random() * this.vitesseMax) - this.vitesseMax/2;
        this.dirY = (int)(Math.random() * this.vitesseMax) - this.vitesseMax/2;

        // Coordonnées initiales sur un côté de l'écran
        this.posX = (int)(Math.random() * this.screenWidth) ;
        this.posY = (int)(Math.random() * this.screenHeight) ;
        
        this.setLocation(posX, posY);

		timer = new Timer(10, this);
		
		if(this.nom.equals("Mouton") || this.nom.equals("Loup"))
			timer.start();
		
		if(this.nom.equals("Chien") )
			timer.stop();
		
		//System.out.println(screenWidth + "   " + screenHeight );
	}
	
	public String getNom()
	{
		return this.nom;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if( this.posX > screenWidth )
			this.dirX = -(int)(Math.random() * this.vitesseMax/2);
		
		if( this.posY > screenHeight - 50 )
			this.dirY = -(int)(Math.random() * this.vitesseMax/2);
		
		if( this.posX < 0 - 50 )
			this.dirX = (int)(Math.random() * this.vitesseMax/2);
		
		if( this.posY < 0 )
			this.dirY = (int)(Math.random() * this.vitesseMax/2);
		
		this.posX += this.dirX;
		this.posY += this.dirY;
		
        this.setLocation(posX, posY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        /*if (this.clickCount < this.survie)
        {
            this.clickCount++;
        }
        else
        {
        	if( this.compteur != null )
        		this.compteur.ajouterScore(this.point);
        	
            dispose();
        }*/
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e)
    {
    	if(this.nom.equals("Mouton") )
    	{
    		timer.stop();
    	}
    	
    	if(this.nom.equals("Chien") )
    	{
    		timer.start();
    	}
    	
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
    	if(this.nom.equals("Mouton") )
    	{
    		timer.start();
    	}
    	
    	if(this.nom.equals("Chien") )
    	{
    		timer.stop();
    	}
    }
}
