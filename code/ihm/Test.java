package code.ihm;

import javax.swing.*;

import code.jeu.CollisionDetection;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import java.util.ArrayList;

public class Test
{
	public static void main(String[] args)
	{
		ArrayList<FrameAnimaux> lst = new ArrayList<FrameAnimaux>();
		CollisionDetection col = new CollisionDetection();
		
		lst.add( new FrameAnimaux("Mouton", 100, 0, 10) );
		lst.add( new FrameAnimaux("Mouton", 100, 0, 10) );
		
		lst.add( new FrameAnimaux("Loup", 100, 0, 10) );
		
		lst.add( new FrameAnimaux("Chien", 100, 0, 10) );
		
		Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                col.detecterCollition( lst );
            }
        }, 0, 100);
  
	}
}
