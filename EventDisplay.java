import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.*;

public class EventDisplay
{
	public static void main(String args[]) throws ClassNotFoundException, IOException
	{
		ArrayList<Event> ale;
		Event eve;
		Calendar tod= Calendar.getInstance();
		DisplayClass dc= new DisplayClass();
		dc.getevents();
		ale=dc.al;
		Iterator<Event> i=ale.iterator();
		while(i.hasNext())
		{
			eve=i.next();
			//System.out.println();
			if(tod.get(Calendar.DATE)==eve.date&&(tod.get(Calendar.MONTH)+1)==eve.month&&tod.get(Calendar.YEAR)==eve.year)
			{
				new DisplayCard(eve);
			}
		}
	}
}

class DisplayCard
{
	JFrame f;
	JLabel header,name,date,time,describe;
	JPanel pane;
	
	DisplayCard(Event eve)
	{
		f=new JFrame("Event Remainder");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
		
		pane= (JPanel) f.getContentPane();
		pane.setLayout(null);//new FlowLayout());
		pane.setBackground(Color.cyan);
		
		header = new JLabel("Today's event is: ");
		name = new JLabel(eve.name);
		date = new JLabel(eve.date+"/"+eve.month+"/"+eve.year);
		describe = new JLabel(eve.description);
		if(eve.minute==0&&eve.hour==0)
			time = new JLabel("No particular Time");
		else
			time = new JLabel(eve.hour+":"+eve.minute);
		
		header.setForeground(Color.black);
		header.setFont(new Font("Serif", Font.PLAIN, 50));
		name.setForeground(Color.BLUE);
		name.setFont(new Font("Serif", Font.PLAIN, 36));
		date.setForeground(Color.BLUE);
		date.setFont(new Font("Serif", Font.PLAIN, 36));
		time.setForeground(Color.BLUE);
		time.setFont(new Font("Serif", Font.PLAIN, 36));
		describe.setForeground(Color.ORANGE);
		describe.setFont(new Font("Serif",Font.PLAIN, 25));
		
		pane.add(header);
		pane.add(name);
		pane.add(date);
		pane.add(time);
		pane.add(describe);
	
		header.setLocation(240,60);
		header.setSize(500, 55);
		name.setBounds(50, 150, 500,50);
		date.setBounds(50, 200, 500,50);
		time.setBounds(50, 250, 500,50);
		describe.setBounds(60, 300, 650, 150);
		f.setVisible(true);	
	}
}










