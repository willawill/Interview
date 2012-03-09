public class sortContext{

private sort sorter = null;

public void sortInt(int[] list){
	sorter.sort(list);
}

public sort getSorter(){
	return sorter;
}

public void setSorter(sort s){
	this.sorter = s;
}
}
