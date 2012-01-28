import java.util.*;
public class findPath{
	

	
	
	public static void getPath(int size, int x, int y, ArrayList paths){
		if (x== size && y == size){
			Iterator i = paths.iterator();
			while (i.hasNext()){
				System.out.print(i.next()+"|");
			}
			System.out.println();
			//paths.clear();
		}
		if (x < size){
			paths.add('D');
			getPath(size, x+1,y,paths);
			paths.remove(paths.size()-1);
		}
		if (y < size){
			paths.add('R');
			getPath(size, x,y+1,paths);
			paths.remove(paths.size()-1);
		
		}
	}

	public static void main(String[] arg){
		ArrayList al = new ArrayList();
		findPath.getPath(1,0,0,al);
	}
}