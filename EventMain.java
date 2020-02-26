import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class EventMain {

	public static void main(String args[])throws Exception
	{
		Scanner in =new Scanner(System.in);
		System.out.println("Hello ! Welcome to Event Reminder");
		DateFormat current = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date dateobj = new Date();
	    System.out.println(current.format(dateobj));
	    System.out.println("1.Display Events\n2.Create an Event\n3.Exit Application");
	   	int ch=in.nextInt();
	   	int chd;
	   	StorageClass sc=new StorageClass();
	    DisplayClass dc1=new DisplayClass();
    	switch(ch)
    	{
	    	case 1:

	    		System.out.println("Proceeding with Display events");
	    		dc1.display_events();
	    		System.out.println("1.All events till date 2.Events today 3.Events completed 4.Upcoming Events");
	    		chd=in.nextInt();
	    		switch(chd)
	    		{
	    		case 1:
	    			dc1.display_events();
	    			break;
	    		case 2:
	    			dc1.events_today();
	    			break;
	    		case 3:
	    			dc1.events_completed();
	    			break;
	    		case 4:
	    			dc1.events_upcoming();
	    			break;
	    		default:
	    			System.out.println("Choice inappropriate");
	    			break;
	    		}
	    			break;

	    	case 2:
	    		System.out.println("Proceeding to Create event\n");
	    		sc.create();
	    		break;

	    	case 3:
	    		System.out.println("Exiting from the application");
	    		System.exit(0);
	    		break;

	    	default:
	    		System.out.println("Inappropriate choice");
	    		break;
	    	}

	    in.close();
	}

}
