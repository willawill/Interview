/*
City is the node on the graph. 
City is presented by the initial letter of its name.
*/
public class City implements Comparable<City>{

	private String name;

	public City(String n){
		this.name = n;

	}
	public String getName(){
		return this.name;
	}
	
	public int getIndex(){
		return name.charAt(0)-'A';
	}

	public String toString(){
		return this.name;
	}

	@Override
	public boolean equals(Object o){
		return this == o || this.name.equals(((City)o).getName());
	}
	
	@Override
	public int hashCode() { 
    int hash = 1;
    hash = hash * 31 + name.hashCode();
    hash = hash * 31 
                + (name == null ? 0 : name.hashCode());
    return hash;
  }
	public int compareTo(City c){
		return this.name.charAt(0) - c.getName().charAt(0);
	}
}

