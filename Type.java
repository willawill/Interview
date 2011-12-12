public class Type{
	enum type{
		 KING, QUEENS;
}

public static void main(String[] args){
		for(type t: type.values()){
			System.out.println(t);
	}
}
}
