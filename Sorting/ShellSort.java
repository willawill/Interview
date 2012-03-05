public class ShellSort{


public static void ShellSort(int[] array, int size)
{
    final int hmax = size/9;
    int h;
    for(h = 1; h <= hmax; h = 3*h+1);
    for(; h > 0; h /= 3)
    {
        for(int i = h; i < size; ++i)
        {
            int v = array[i];
            int j = i;
            while(j >= h && v < array[j-h])
            {
                array[j] = array[j-h];
                j -= h;
            }
            array[j] = v;
        }
    }
}

public static void main(String[] args){
	int[] a = {5,6,2,7,8,10,3,4};
	ShellSort.ShellSort(a, a.length);
	System.out.println(a[0]);
}



}
/*Insertion sort compares every single item with all the rest elements of 
the list in order to find its place, while Shell sort compares items that lie far apart. 
This makes light elements to move faster to the front of the list.
*/