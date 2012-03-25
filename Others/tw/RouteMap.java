import java.util.*;

/*
RouteMap stores all the route on the graph.
*/
public class RouteMap{
	private  final static int INF = -1;
	private final List<City> towns;
	private final List<Edge> trains;
	private int[][] distances;
	/**
	*Construct N*N matrix to cache distance between cities.
	*/
	public RouteMap(List<City> cities, List<Edge> edges){
		this.towns = cities;
		this.trains = edges;
		distances = new int[cities.size()][cities.size()];
		for (int[] row :distances){
			Arrays.fill(row , INF);
			
		}
		for (Edge e: this.trains){
			distances[e.getStart().getIndex()][e.getEnd().getIndex()] = e.getDistance();
		}
		for (City c: this.towns){
			distances[c.getIndex()][c.getIndex()] = 0;
		}

	}
	/**
	* @return the list of towns names.
	*/
	public List<City> getTowns(){
		return towns;
	}
	/**
	* @return the list of edges
	*/
	public List<Edge> getTrains(){
		return trains;
	}
	/**	
	*   @return the distance between two cities, 
	*           INF indicates no such route. 0 means start and end are same place
	*/ 
	public int getDistance(City start, City end){
		return distances[start.getIndex()][end.getIndex()];
	}
	public int[][] getMatrix(){
		return distances;
	}
	/**
	* @return the list of cities that can be reached directly.
	*/
	public List<City> getNextAdjCities(City c){
		List<City> adj = new ArrayList<City>();
		for (int i = 0; i < distances.length; i++){
			if (distances[c.getIndex()][i] > 0){
				adj.add((City)(towns.get(i)));
			}
		}
		return adj;
	}
	public void printMatrix(){
		for (int i = 0; i < distances.length; i++){
			for (int j = 0; j< distances.length; j++){
				System.out.print(distances[i][j]+" ,");
			}
			System.out.println();
		}
	}

}