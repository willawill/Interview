/*Need to figure out it's fit for one restaurant or it's a system with many restaurant--Only for one.
  Need to figure out the range of future reservation.--Next two weeks.
  
  Need to clarify buffet or entees?
  Suppose one group table = 
*/
public class Restaurant{
	Rinfo rinfo;
	TableManager tm;	

}

class TableManager{
	HashMap<String, Integer> resWithName;//Used to locate customers.
	HashMap<Date, HashMap<String, ArrayList>> resWithDate;//Used to check availiability. 
														//	e.g. Jan.5 -> <11:00 ->Table1>	
															//				  <11:30  ->Table1>										
	int Table tables;
	ArrayList<Request> waitingList;//Can be designed as a command pattern.When a cancelation request come, check if there is available spot for customer.

	int numOfTable;
	int numOfLarge;
	int numOfMedium;
	int numOfTable;

	public TableManager(){
		//TODO set numbers.

	}
	public void reservResult(Request r){
		if (processRequest(r)){
			System.out.println("Successed!");

		}
		else{
			"You are on the waiting list or please change your reservation information.";
		}
	}
	private boolean processRequest(Request r){
		HashMap<String, Integer> request = fitTable(r.seats);//Parse what type of request(Small, Medium, Large).
		boolean isReserved = isAvailable(r.date, request, r.ts);
		if (isReserved){
			//Update resWithName, resWithDate.
		}
	}

	private boolean isAvailable(Date date, HashMap<String, Integer> request, TimeSpan ts){
		boolean isReserved = false;
		
		//HashMap<String, ArrayList<Integer>> res = resWithDate.get(date);//Get a list of reserved tables at that time.
		//ArrayList<Integer> start, end;
		// start = res.get(ts.start);
		// end = res.get(ts.end);
		 Iterator i = request.iterator();
		 while (i.hasNext()){
		 	MapEntry temp = MapEntry(i.next());
		 	if (temp.key() == "Small"){
		 		int[] result = findTable("Small", temp.value());
		 	}
		 	else if(temp,key()=="Medium"){
		 		
		 	}
		 	else{
		 		
		 	}
		 	
		 	Update();
		 	
			//check each request can be satified or not. 
			//zhuo zi ke yi nuo de ya hun dan !!!
		}

	}
	private int[] findTable(String type, int num, Date date, TimeSpan ts){
		int[] result = new int[num];
		if (type == "Small"){
				for (int i = 0 ; i < smallNumber; i++){
					 HashMap<String, String> res = tables[i].getReserved().get(date);
					 while (res.hasNext()&&num!=0){
					 	if (isRange(res.key, res.value, ts.start, ts.end)){
					 		result[num] = i;//find a table
					 		num--;
				 	}
				 }
			}
		}
		else if(type == "Medium"){
			
		}
		else{
			
		}

		//Cant find a table for that.

		return result;
	}

	private boolean inRange(String s1, String e1, String s2, String e2){
		if (e1 < s2 || e2 < s1) return true;
		else return false;
	}

	private void Update()
}

class Rinfo{
	String name;
	String add;
	String phoneno;
}

class Table{
	int tableid;
	String type;
	HashMap<Date, HashMap<String,String>> reserved;//e.g. Jan5 -><1100, 1200> indicated <start end>.
	boolean isFitToRequest(TimeSpan ts){
		
	}
}

class fitTable(){
	HashMap<String, Integer> result = new HashMap<String, Integer>();
	public fitTable(int x){
		return result.add(...);
	}
}
abstract class Request{
	String name;
	TimeSpan ts;
	Date date;
	int seats;

	boolean canFitintoTable(Table t){
		
	}//If it's large then maybe we need two table.
}

class TimeSpan{
	String start;
	String end;
}