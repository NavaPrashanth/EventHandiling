import java.util.Scanner;

public class CreateEvent 
{
	String name, description;
	int date, month, year, hour, minute ;
	
	CreateEvent()
	{
		readInputs();
	}

	
	void readInputs()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Creating an event...");
		System.out.print("Enter the event name: ");
		this.name=in.nextLine();
		System.out.print("Enter date, month and year of event: ");
		date=in.nextInt();
		month=in.nextInt();
		year=in.nextInt();
		System.out.print("enter time as hours and minutes , if no particular time give zeroes: ");
		hour=in.nextInt();
		minute=in.nextInt();
		System.out.print("Enter the event description: ");
		in.nextLine();
		this.description=in.nextLine();
		System.out.println("Data read");
		in.close();
	}

	public Event makeEvent()
	{
		Event e = new Event(name, date, month, year, hour, minute,description);
		return e;
	}
}
