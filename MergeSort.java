/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: Crutches on the merge algorithm which will sort two already sorted arrays into one array in n time. The sort algo splits the array in half until it is guarenteed to be sorted (length = 1), then uses the merge algorithm to piece them all together.

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int[] ret = new int[a.length + b.length];
	
	//indexes of a and b
	int iA = 0;
	int iB = 0;

	//sort, O(n)
	for(int i = 0; i < a.length + b.length; i++){
	    if ( iA >= a.length && iB < b.length ){
		ret[i] = b[iB];
		iB += 1;
	    }
	    else if ( iB >= b.length && iA < a.length ){
		ret[i] = a[iA];
		iA += 1;
	    }
	    
	    else if (a[iA] <= b[iB]){
		ret[i] = a[iA];
		iA += 1;
	    }
	    else{
		ret[i] = b[iB];
		iB += 1;
	    }
	}

	return ret;
    }//end merge()

    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	//base case
	if (arr.length == 1) return arr;
	
	int mid = arr.length / 2;

	int[] left = new int[mid];
	int[] right = new int[mid + (arr.length % 2)];

	//split the array in two, both O(n)
	for (int i = 0; i < mid; i++){
	    left[i] = arr[i];
	}

	for (int j = mid; j < arr.length; j++){
	    right[j - mid] = arr[j]; 
	}

	//sort the two halves
	left = sort(left);
	right = sort(right);

	arr = merge(left, right);

	return arr;
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: "); //precond not met
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort

