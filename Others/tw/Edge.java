/*
Edge present the route between two cities with a positive distance.
*/

public class Edge{
	private City start;
	private City end;
	private int distance;

	public Edge(City s, City e, int dis){
		this.start = s;
		this.end = e;
		this.distance = dis;
	}

	public City getStart(){
		return start;
	}

	public City getEnd(){
		return end;
	}

	public int getDistance(){
		return distance;
	}
@Override
	public String toString(){
		return start + " " + end + " " + distance;
	}

}