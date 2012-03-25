import java.util.*;
/*
	Implementation of Dijstra Algorithm for the shorest path between two distinct cities.
	Optimize the performance by using PriorityQueue for the unsettled node list. 
	As a greedy algorithm, Dijstra's time complecity should be O(|V|^2). With the optimization of PriorityQueue, 
	the time complexity should be O(|V|*log|V|)
*/
public class GetShortest{
	private final static int INF = Integer.MAX_VALUE;
	private final static int INITIAL_SIZE = 10;
	private RouteMap routeMap;
	private Map<City, Integer> shortestDistance;
	private Map<City, City>  predecessors;
	private ArrayList<City> settledCities;
	private final Comparator<City> shortestDisComparator = new Comparator<City>()
	{

		public int compare(City a, City b){
			int result = getShortestDistance(a) - getShortestDistance(b);
			return (result == 0) ? a.compareTo(b): result;
		}
	};
	private PriorityQueue<City> unsettledCities = new PriorityQueue<City>(5, shortestDisComparator);
	

	public GetShortest(RouteMap rp){
		shortestDistance = new HashMap<City, Integer>();
		predecessors = new HashMap<City, City>();
		settledCities = new ArrayList<City>();
		this.routeMap = rp;
	}

	public ArrayList<City> execute(City start, City end){
		if (start == null && end == null) return null;
		shortestDistance.put(start, 0);
		unsettledCities.add(start);
		
		while (unsettledCities.size() > 0){
			City temp = unsettledCities.poll();
			if (!isSettled(temp)){
				if (temp.equals(end)&&settledCities.size() >1)  {
					settledCities.add(temp);
					break;
				}
				
				settledCities.add(temp);
				
				
				setMinimum(temp);
				
			}
		}
		return getPath(end);
	
}
	public void setMinimum(City c){
		List<City> adj = routeMap.getNextAdjCities(c);
		for (City temp :adj){
			int tempDis = routeMap.getDistance(c,temp);
			int shortDistance = getShortestDistance(c) + routeMap.getDistance(c, temp);
			if (shortDistance < getShortestDistance(temp)){
				
				unsettledCities.remove(temp);
				shortestDistance.put(temp, shortDistance);
			//Rebalance the queue with shortest path.
				unsettledCities.add(temp);
				predecessors.put(temp, c);
				
			}
		}
	}

	public Integer getShortestDistance(City c){
		Integer dis = shortestDistance.get(c);
		return (dis == null) ? INF : dis;
	}

	public boolean isSettled(City c){
		return settledCities.contains(c);
	}
	private City getPredecessor(City c){
		return (City)predecessors.get(c);
	}
	/*
	Return the route from source to target.
	*/
	public ArrayList<City> getPath(City end){
		ArrayList<City> result = new ArrayList<City>();
		for (City c = end; c != null; c = this.getPredecessor(c)){
			result.add(c);
		}
		Collections.reverse(result);
		return result;
	}
}