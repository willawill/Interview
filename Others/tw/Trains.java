
import java.util.*;
import java.io.*;

/*
Trains is the engine for all the questions.Output on the sample data:
*	INPUT :  AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
	OUTPUT: 
			OutPut: [A, B, C] 9
			OutPut: [A, D] 5
			OutPut: [A, D, C] 13
			OutPut: [A, E, B, C, D] 22
			OutPut: [A, E, D] NO SUCH ROUTE
			Cities [A, B, C, D, E]
			#6 Output 2
			#7 Output 3
			#8 Output 9
			#9 Output 9
			#10 Outout 7
*
*/
public class Trains{
	private  final static int INF = -1;
	
	private RouteMap routeMap;
	private List<City> cities;
	private GetRoute routeGetter;
	private GetShortest shortestRouteGetter;
	private ComputeDistance calculator;

	public Trains(List<City> c, List<Edge> t){
		cities = c;
		routeGetter = new GetRoute(c, t);
		routeMap = new RouteMap(c,t);
		shortestRouteGetter = new GetShortest(routeMap);
		calculator = new ComputeDistance(routeMap);
	}
/*
	Compute distance along a route. 
*/
	public String computeRouteDistance(ArrayList<City> route){
		int result = calculator.computeDistance(route);
		if (result == -1)
			return route.toString() + " NO SUCH ROUTE";
		else 
			return route.toString() + " " + Integer.toString(result);
	}

/**
* @return the number of routes as required. i.e. with exactly stops or maximum stops.
*/
	public int getRouteWithExactStops(City start, City end, int maxStop){
		routeGetter.getExactRoute(start, end, maxStop);
		ArrayList<ArrayList<City>> result1 = routeGetter.getResultForExactRoute();
		System.out.println(result1.toString());
		
		return result1.size();
	}
/**
* @return the number of routes starts from source city and reach target city at max stops.
*/	
	public int getRouteWithMaxStops(City start, City end, int maxStop){
		routeGetter.getAllRoute(start, end, maxStop);
		ArrayList<ArrayList<City>> result2 = routeGetter.getResultForAllRoute();
		System.out.println(result2.toString());
		return result2.size();		
	}
/**
* @return the shortest route between two distinct cities.
*/	
	public int getShortestRoute(City start, City end){
		ArrayList result =  shortestRouteGetter.execute(start, end);
		System.out.println(result.toString());
		return calculator.computeDistance(result);
}
/**
* @return the distance of shortest route between start and end cities. 
*/	

	public int getShortestRouteWithCycle(City start, City end){
		routeGetter.getAllRoute(start, end, cities.size());
		ArrayList<ArrayList<City>> allRoute = routeGetter.getResultForAllRoute();
		int minDis = Integer.MAX_VALUE;
		for(ArrayList<City> route:allRoute){
			int tempLen = calculator.computeDistance(route);
			if (tempLen < minDis){
				minDis = tempLen; 
			}
		}
		return minDis;
}
/**
* @return the number of routes with max distance.
*/	

public int getRoutesWithDistance(City start, City end, int maxDis){
	routeGetter.getRouteWithDis(start, end, maxDis);
	ArrayList<ArrayList<City>> route = routeGetter.getResultForRouteWithDis();
	System.out.println(route.toString());
	return route.size();
}


}   