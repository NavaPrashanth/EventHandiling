import java.io.Serializable;

public class Event implements Serializable
{
	String name, description;
	int date, month, year, hour, minute ;
	
	Event(String name, int date, int month, int year, int hour, int minute ,String description)
	{
		this.name=name;
		this.date=date;
		this.month=month;
		this.year=year;
		this.hour=hour;
		this.description=description;
	}
}
