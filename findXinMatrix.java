public class findXinMatrix{
	public int[][] matrix;

	public findXinMatrix(int[][] x){
		matrix = x;
	}
//recursively return the element along the diagonal
	public int partitionSearch(int[][] matrix, int start, int end, int x){
		int lenR = matrix[0].length;
		int lenC = matrix.length; 
		if (matrix == null || end < start) return null;
		for (int i = 0; i < )
	}
	class element{
		int row;
		int column;

		boolean isValid(int[][])
	}
	public static void main(String[] args){
		int[][] matrix = { {15,20,70,85},	
				{20,35,80,95},
				{30,55,95,105},
				{40,80,100,120}
			};
		findXinMatrix fxm = new findXinMatrix(matrix);
			
		System.out.println(fxm.matrix[0].length);
	}
}