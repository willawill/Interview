import java.util.*;
/*
* GetRoute is an object that compute various routes as requirements.
* 
*/
public class GetRoute{
	private Map<City, LinkedHashSet<City>> graph = new HashMap();
	/*
		route that between two cities with exact number of stops.
	*/
	private ArrayList<ArrayList<City>> resultForExactRoute = new ArrayList<ArrayList<City>>();
	 /*
	 	route that between two cities with at most number of stops;
	 */
	private ArrayList<ArrayList<City>> resultForAllRoute = new ArrayList<ArrayList<City>>();
	/*
		route that between two cities with at most distance.
	*/
	private ArrayList<ArrayList<City>> resultForRouteWithDis = new ArrayList<ArrayList<City>>();

	/*
		Calculator for distance along one route.
	*/
	private ComputeDistance calculator ;
	private RouteMap rp;

	public GetRoute( List<City> cities, List<Edge> t){
		rp = new RouteMap(cities, t);
		calculator = new ComputeDistance(rp);
		for (Edge edge : t){
			LinkedHashSet<City> adj = graph.get(edge.getStart());
			if (adj == null){
				adj = new LinkedHashSet<City>();
				graph.put(edge.getStart(),adj);
			}
				adj.add(edge.getEnd());
			}
	}
	/**
	*	@return a list of cities that can be reached.
	*/
	private LinkedList<City> adjMatrix(City city){
		LinkedHashSet<City> adj = graph.get(city);
		return  (adj == null) ? new LinkedList(): new LinkedList<City>(adj);
		
	} 
	/*
		Initialize the results.
	*/
	private void init(){
		resultForExactRoute.clear();
		resultForAllRoute.clear();
		resultForRouteWithDis.clear();
	}
	/*
		public interface for getting route between two cities with exact number of stops;
	*/
	public  void getExactRoute(City start, City end, int maxStop){
			init();
			LinkedList visited = new LinkedList();
			visited.add(start);
			searchForExactRoute(graph, visited,end, maxStop);
		}
	/*
		public interface for getting route between two cities with at most number of stops;
	*/

	public  void getAllRoute(City start, City end, int maxStop){
			init();
			//System.out.println(start.getName());
			LinkedList visited = new LinkedList();

			visited.add(start);
			searchForAllRoute(graph, visited,end, maxStop);
		}

	/*
		public interface for getting route between two cities within limit distance;
	*/	
	public  void getRouteWithDis(City start, City end, int maxDistance){
			init();
			LinkedList visited = new LinkedList();
			visited.add(start);
			searchForRouteWithDistance(graph, visited,end, maxDistance);
		}
/*
	Helper for adding linkedList as an element into an ArrayList. 
	It's used for storing route when find one.
*/
	 private ArrayList add1(ArrayList r, LinkedList x){
		ArrayList temp = new ArrayList();
        for (Object i:x){
     		temp.add(i);
     	}
     	r.add(temp);
     	return r;
     }
  /*
  	Breadth-First-Search on the graph to get all the routes meet the requirement.
  	When the route is longer than given number of stops, return the result.
  	Since in the worst case all the cities and edges should be walked the time complexity 
  	is O(|V|+|E|) theoretically.
  */   
	private void searchForExactRoute(Map graph, LinkedList visited, City end, int maxStop){
		LinkedList<City> adj = adjMatrix((City)visited.getLast());
		for (City c : adj){
			if (c.equals(end)){
				visited.add(c);
				if (visited.size() == maxStop +1){
					resultForExactRoute = add1(resultForExactRoute, visited);
				}
				visited.removeLast();
				break;
			}
		}
		for (City c: adj){
			 if (visited.size() == maxStop+1){
			 	break;
			 }
			visited.addLast(c);
			searchForExactRoute(graph, visited, end, maxStop);
			visited.removeLast();
		}
	}
private void searchForAllRoute(Map graph, LinkedList visited, City end, int maxStop){
		LinkedList<City> adj = adjMatrix((City)visited.getLast());
		for (City c : adj){
			if (visited.size() >= maxStop+1) break;
			if (c.equals(end)){
				visited.add(c);
				if (visited.size() <= maxStop +1){
					resultForAllRoute = add1(resultForAllRoute, visited);
				}
				visited.removeLast();
		
			}
			else{
				visited.add(c);
				searchForAllRoute(graph, visited, end, maxStop);
				visited.removeLast();
			}
		}
	
	}
	 private void searchForRouteWithDistance(Map graph, LinkedList visited, City end, int maxDistance){
	 	LinkedList<City> adj = adjMatrix((City)visited.getLast());
	 	for (City c : adj){
			if (calculator.computeDistance(visited) > maxDistance) break;
			if (c.equals(end)){
				visited.add(c);
				if (calculator.computeDistance(visited) < maxDistance){
					resultForRouteWithDis = add1(resultForRouteWithDis, visited);
					searchForRouteWithDistance(graph, visited, end, maxDistance);
				}
				visited.removeLast();
			}

			else{
				visited.add(c);
				searchForRouteWithDistance(graph, visited, end, maxDistance);
				visited.removeLast();
			}	

		}
	 
	}
	public ArrayList<ArrayList<City>> getResultForAllRoute(){
		return resultForAllRoute;
	}

	public ArrayList<ArrayList<City>> getResultForExactRoute(){
		return resultForExactRoute;
	}

	public ArrayList<ArrayList<City>> getResultForRouteWithDis(){
		return resultForRouteWithDis;
	}

}
