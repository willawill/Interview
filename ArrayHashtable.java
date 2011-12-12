public class ArrayHashtable{

	private HashtableEntry[] hashtable;
	private static final DEFAULT_CAPACITY = 128;
	
	public ArrayHashtable(){
		HashtableEntry[] hashtable = new HashtableEntry[DEFAULT_CAPACITY];
		for (int i = 0; i< DEFAULT_CAPACITY ;i++){
			hashtable[i] = new HashstableEntry();

}
}

	public void put(HashtableEntry<K,V> e){
		int hash = hashcoding(e.getKey());
		int i = 1;
		while (hashtable[hash] != null && hashtable[hash].getKey() != e.getKey()){//Ensure there is no collision and no duplicated.
			hash = newhashcoding(hash, i);
			i++;
}
		hashtable[hash] = e;

}
	public HashtableEntry<K,V> get(K k){
		int hash = hashcoding(k);
		int i = 1;
		while(hashtable[]

}

	public boolean isContains(K k){
		int hash = hashcoding(k);
		int i = 1;
		while (hashtable[hash] != null && hashtable[hash].getKey() != e.getKey()){//Ensure there is no collision and no duplicated.
			hash = newhashcoding(hash, i);
			i++;
}


	public  int hashcoding(K e){
		return int(e) % DEFAULT_CAPACITY;
}
	public int newhashcoding(int h, int i){
		return h + Math.pow((-1),(i - 1)) * (Math.pow((i + 1)/2),2);

}


class HashtableEntry<K,V>{
	private K key;
	private V value;
	
	public HashtableEntry<K,V>(K k, V v){
		this.key = k;
		this.value =v;
}
	public K getKey(){
		return key;
}
	public V getValue(){
		return value;
}
	public void setKey(K k){
		this.key =k ;
}
	public void setValue(V v){
		this.value = v;
}


}
