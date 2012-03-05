 public class Test{
 	public static void main(String[] args){
	double P = 0.5;
	// int R = Math.random();
	// int lvl=0; int levels = 1;
	// while ((R&1)==1){
	// 	lvl++;
	// 	if (lvl == levels) {levels++; break;}
	// }

	boolean[] x  = new boolean[5];
	System.out.println(x[1]);

	int N = 25;
	while (N!=0){
	System.out.print((Math.log(1.-Math.random())/Math.log(1.-0.5)));		
	System.out.println((Math.log(1-Math.random())/Math.log(1-0.5)));		
	
	N--;
}

}
}