//Keeping an interval tree for each room. if no intersects between given time and existing reservation, the request can be taken.

class Hotel{

private final static int MAX_KING 20;
private final static int MAX_QUEEN 20;

private Hashmap<room, boolean> reservedkingsRoom;
private Hashmap<room,boolean> reservedqueenssRoom;
private enum roomType{KING, QUEENS};

public Hotel(){
	Hashmap<room, IntervalTree> reservedkingsRoom  = new HashMap();
	Hashmap<room, IntervalTree> reservedqueensRoom  = new HashMap();

}
boolean isFull(Hashmap room, ResearveTime time){
	int count = 0;
	if (room.size() < MAX_KING)
	{
		return true;
}
	Iterator i = room.entrySet().Iterator();
	while(i.hasNext()){
		IntervalTree timeslot = (IntervalTree)i.next();
		if timeslot.contains(time){
			count++;		
}
}
	return (count == MAX_KING) ? true:false;
}


boolean isFullHotel(){
	return (isFull(kingsRoom) && isFull(queensRoom));
}

enum getRoomType(){
	return this.roomType;
}

}

class Customers{
	String name;
	
}

abstract class room{
	int price;
	private IntervalTree timeslot;
	public abstract void reserved();
}

class kingsRoom extends room{
private int price;

}

class queensRoom extends room{
private int price;
}

class reservedTime{
	String start;
	String end;

	reservedTime(String s1, String end){
	start= s1;
	end = end;
}

public String getStart(){
	return start;
}
public String getEnd(){
	return end;
}
}

class Request{
	private String type;
	private reservedTime;
}


}

class MakeReservation{
	private	Hotel h;
	private Request r;

	public void Book(){
		if (r.getType() instanceof KINGS){
			if (ifFull(h.getreservekingsroom()))
				return;

			else if (h.getreservekingsRoom().size() == 0){
				addRequest();}

			else{
				//find if existing node has time. else create new room for that.					
				Iterator i = h.getreservekingsroom.entrySet().Iterator;
				while (i.hasNext()){
					
				}
}
}

}

	public void addRequest(){
	//insert new interval to room.list.

}
	public void cancelBook()
}
}


