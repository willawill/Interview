public class ClockWisePrint{
	
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