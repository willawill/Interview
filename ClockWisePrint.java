public class ClockWisePrint{
	public static void printMatrix(int[][] a, int M, int N){
		int left = 0;
		int row = M-1;	
		int level = 0;
		int column = N-1;
		while ( left <= row && level <= column) {
		if (left == row) {
		  for (int i = level; i<=column; i++) System.out.print(a[i][left]);
		} else if (level == column) {
		  for (int i= left; i<=row; i++) System.out.print(a[left][i]);
		} else {
		  for (int i=l; i<r; i++) System.out.print(a[t][i]);
		  for (int i=t; i<b; i++) System.out.print(a[i][r]);
		  for (int i=r; i>l; i--) System.out.print(a[b][i]);
		  for (int i=b; i<t; i--) System.out.print(a[i][l]);
		}
		left++;r--;
		t++;b--;
		}
	}

	public static void main(String[] args){
		int[][] a = new int[][] {{1,2,3},
					 {4,5,6},
					 {7,8,9}};
		ClockWisePrint.printMatrix(a, 3, 3);
	}	
}

void print(int **a, int M, int N)
{
int l = 0;
int r = M-1;
int t = 0;
int b = N-1;
while (l<=r && t<=b) {
if (l==r) {
  for (int i=t; i<=b; i++) printf("%d ", a[i][l]);
} else if (t==b) {
  for (int i=l; i<=r; i++) printf("%d ", a[t][i]);
} else {
  for (int i=l; i<r; i++) printf("%d ", a[t][i]);
  for (int i=t; i<b; i++) printf("%d ", a[i][r]);
  for (int i=r; i>l; i--) printf("%d ", a[b][i]);
  for (int i=b; i<t; i--) printf("%d ", a[i][l]);
}
l++;r--;
t++;b--;
}
}




