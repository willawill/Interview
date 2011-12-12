public class FloydWarshall {

  int numVertices;                   // Number of vertices (when initialized).
  double[][] adjMatrix;              // The adjacency matrix (given as input).
  double[][] Dk, Dk_minus_one;       // Matrices used in dynamic programming.


  public void initialize (int numVertices)
  {
    this.numVertices = numVertices;
    Dk = new double [numVertices][];
    Dk_minus_one = new double [numVertices][];
    for (int i=0; i < numVertices; i++){
      Dk[i] = new double [numVertices];
      Dk_minus_one[i] = new double [numVertices];
    }
  }

  public void allPairsShortestPaths (double[][] adjMatrix)
  {
    // Dk_minus_one = weights when k = -1
    for (int i=0; i<numVertices; i++) {
      for (int j=0; j<numVertices; j++) {
          Dk_minus_one[i][j] = adjMatrix[i][j];
      }
    }
    
    // Now iterate over k.
    for (int k=0; k<numVertices; k++) {

      // Compute Dk[i][j], for each i,j
      for (int i=0; i<numVertices; i++) {
        for (int j=0; j<numVertices; j++) {
          if (i != j) {

            // D_k[i][j] = min ( D_k-1[i][j], D_k-1[i][k] + D_k-1[k][j].
            if (Dk_minus_one[i][j] < Dk_minus_one[i][k] + Dk_minus_one[k][j])
              Dk[i][j] = Dk_minus_one[i][j];
            else 
              Dk[i][j] = Dk_minus_one[i][k] + Dk_minus_one[k][j];

          }
        }
      }

      // Now store current Dk into D_k-1
      System.out.println("D(K) is :" + (k+1));	
      for (int i=0; i<numVertices; i++) {
        for (int j=0; j<numVertices; j++) {
          Dk_minus_one[i][j] = Dk[i][j];
	 System.out.print(Dk_minus_one[i][j]+" ");
        }
	System.out.println();
      }
	System.out.println();
    }
  }
  //---------------- Test case  -----------------------------------------------
  public static void main (String[] argv)
  {
	double x = Double.MAX_VALUE;
System.out.println(x);
    // A test case.
      double[][] adjMatrix = {
        {0, 4, x, 2, 5, x},
        {4, 0, 2, x, 2, 6},
        {x, 2, 0, 1,  x, 2},
        {2, x, 1, 0, -3, x},
        {5, 2, x, -3, 0, -1},
        {x, 6, 2, x, -1, 0},


      };

      int n = adjMatrix.length;
      FloydWarshall fwAlg = new FloydWarshall ();
      fwAlg.initialize (n);
      fwAlg.allPairsShortestPaths (adjMatrix);
      
  }
  

}
