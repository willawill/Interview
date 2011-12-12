public class Bit{

public static void main(String[] args){

int i = -4;

//byte b0=100;
//System.out.println(-b0);
//Bit.toBinary(i);
//i=~i;

//int c = Bit.bitSet(i);
Bit.toBinary(-4);
//System.out.println(();
}

public static int bitSet(int var){
	int count = 0;
	while (var != 0) {
	toBinary(var);
		 if((var & 01)!= 0) {
			count ++;
	}
	var = var>>1;
}
	return count;

}

public static void toBinary(int i){
	String s = Integer.toBinaryString(i);
	
System.out.println(s);
	

}


}
