import java.io.*;
import java.util.*;

public class StorageClass
{
	ArrayList<Event> al= new ArrayList<Event>();
	File f= new File("C:\\ecllipse\\EventRemainder\\src\\storeevent.txt");
	
	void intiate() throws IOException, ClassNotFoundException
	{
		boolean cont =true;
		FileInputStream fis= new FileInputStream(f);
		ObjectInputStream ois=new ObjectInputStream(fis);
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
		ois.close();
	}
	public void create() throws Exception
	{
		CreateEvent ce=new CreateEvent();
		Event event=ce.makeEvent();
		intiate();
		al.add(event);
		FileOutputStream fos=new FileOutputStream (f);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Iterator<Event> i=al.iterator();
		while(i.hasNext())
			oos.writeObject(i.next());
		oos.flush();
		oos.close();
	}

}
