import java.io.*;
import java.util.*;

public class DisplayClass  
{

	ArrayList<Event> al= new ArrayList<Event>();
	File f= new File("C:\\ecllipse\\EventRemainder\\src\\storeevent.txt");
	Calendar today= Calendar.getInstance();
	Calendar eventdate= Calendar.getInstance();
	Event event;
	Iterator<Event> i=al.iterator();
	boolean contain=true;
	
	public void getevents() throws IOException, ClassNotFoundException
	{
		boolean cont =true;
		FileInputStream fis= new FileInputStream(f);
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(fis);
		}catch(EOFException e)
		{
			System.out.println("No events to display");
			contain=false;
		}
		while(cont)
		{
			Event event=null;
			if(fis.available()!=0) {
				event=(Event)ois.readObject();
				al.add(event);
			}
			else 
				cont=false;
		}
		if(ois!=null)
			ois.close();
		fis.close();
	}
	
	public void display_events() throws ClassNotFoundException, IOException
	{
		getevents();
		if(contain==true)
		{
			//displays all events stored in the file i.e completed events, current events and upcoming events
			System.out.println("The events saved are: ");
			System.out.println();
	
			while(i.hasNext())
			{
				event=i.next();
				System.out.println("Name: "+event.name);
				System.out.println("Saved for date: "+event.date+"/"+event.month+"/"+event.year+"  "+event.hour+":"+event.minute);
				System.out.println("Description: "+event.description);
			}
		}
	}

	public void events_today() throws ClassNotFoundException, IOException
	{
		getevents();
		boolean has=false;
		
		if(contain==true)
		{
			//to display events on that day
			System.out.println("Today's events are:");
			while(i.hasNext())
			{
				event=i.next();
				if(today.get(Calendar.DATE)==event.date||today.get(Calendar.MONTH)==event.month||today.get(Calendar.YEAR)==event.year)
				{
					has=true;
					System.out.println("Name: "+event.name);
					System.out.println("Saved for date: "+event.date+"/"+event.month+"/"+event.year+"  "+event.hour+":"+event.minute);
					System.out.println("Description: "+event.description);
					System.out.println();
				}
			}
			if(has==false)
				System.out.println("No events for today");
		}
	}

	public void events_completed() throws IOException, ClassNotFoundException 
	{
		getevents();
		boolean has=false;
		
		if(contain==true)
		{
			//to display events already completed
			System.out.println("Events that are completed are:");
			while(i.hasNext())
			{
				event=i.next();
				eventdate.set(event.year,event.month,event.date,event.hour,event.minute);
				if(today.after(eventdate))
				{
					has=true;
					System.out.println("Name: "+event.name);
					System.out.println("Saved for date: "+event.date+"/"+event.month+"/"+event.year+"  "+event.hour+":"+event.minute);
					System.out.println("Description: "+event.description);
					System.out.println();
				}
			}
			if(has==false)
				System.out.println("No events have been completed yet");
		}
	}

	public void events_upcoming() throws IOException, ClassNotFoundException
	{
		getevents();
		boolean has=false;
		
		if(contain==true)
		{
			///to display upcoming events
			System.out.println("Upcoming events are:");
			while(i.hasNext())
			{
				event=i.next();
				eventdate.set(event.year,event.month,event.date,event.hour,event.minute);
				if(today.before(eventdate))
				{
					has=true;
					System.out.println("Name: "+event.name);
					System.out.println("Saved for date: "+event.date+"/"+event.month+"/"+event.year+"  "+event.hour+":"+event.minute);
					System.out.println("Description: "+event.description);
					System.out.println();
				}
			}
			if(has==false)
				System.out.println("You're all caught up! No upcoming events");
		}
	}
}