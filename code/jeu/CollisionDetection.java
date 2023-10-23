package code.jeu;

import java.util.ArrayList;

import code.ihm.FrameAnimaux;

import java.awt.*;

public class CollisionDetection
{
	private ArrayList<FrameAnimaux> framesASupprimer;
	
	public CollisionDetection()
	{
		framesASupprimer = new ArrayList<>();
	}
	
	public void detecterCollition( ArrayList<FrameAnimaux> lst )
	{
		
		for(FrameAnimaux frame1 : lst)
		{
			for(FrameAnimaux frame2 : lst)
			{
				if( frame1 != null && frame2 != null && frame1 != frame2 )
				{
					if(frame1.isShowing() && frame2.isShowing() )
					{
						Point frame1Location = frame1.getLocationOnScreen();
						Point frame2Location = frame2.getLocationOnScreen();

						if (frame1Location.x < frame2Location.x + frame2.getWidth() &&
							frame1Location.x + frame1.getWidth() > frame2Location.x &&
							frame1Location.y < frame2Location.y + frame2.getHeight() &&
							frame1Location.y + frame1.getHeight() > frame2Location.y)
						{
							eliminer(frame1, frame2);
						}
					}
				}
			}
		}
		
		for (FrameAnimaux frame : framesASupprimer) {
			frame.dispose();
		}
	}
	
	public void eliminer(FrameAnimaux frame1, FrameAnimaux frame2)
	{
		if( frame1.getNom().equals("Mouton") && frame2.getNom().equals("Loup") ||
		    frame1.getNom().equals("Loup")   && frame2.getNom().equals("Chien") )
		{
			framesASupprimer.add(frame1);
		}
		
		if( frame1.getNom().equals("Loup")  && frame2.getNom().equals("Mouton") ||
		    frame1.getNom().equals("Chien") && frame2.getNom().equals("Loup") )
		{
			framesASupprimer.add(frame2);
		}
	}
	
}
