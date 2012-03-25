import java.util.*;
/*
Calculator for computing the length along one route.
*/
public class ComputeDistance{
	private  final static int INF = -1;
	
	private RouteMap routeMap;

	public ComputeDistance(RouteMap r){
		this.routeMap = r;
	}
/**
* @return the distance of given route. Questions 1-5.
*/	public int computeDistance(List<City> route){
	return this.computeDis(route);
}
	
	private int computeDis(List<City> route){
		if (route.size() == 0) return 0;
		else{
			int dis = 0;
			int tempDis = 0;
			City current = null;
			City previous = null;
			for (int i = 1; i<route.size();i++){
				current = route.get(i);
				previous = route.get(i-1);
				tempDis = routeMap.getDistance(previous, current);
				if (tempDis == INF) return -1;
				else{
					dis += tempDis;
				}
			}
			return dis;	
			}
		}

}