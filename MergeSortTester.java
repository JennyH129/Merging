/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: 10000
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{

    //helper method for arrays
    public static void fill(int[] ray){
	for(int i = 0; i < ray.length; i++){
	    ray[i] = (int) (Math.random() * 10000);
	}
    }

    public static long time(int[] ray){
	long start = System.nanoTime();
	MergeSort.sort(ray);
	long end = System.nanoTime();
	return end - start; 
    }

    public static void averagePrint (int[] arr) {
	long counter = 0;
	for (int i = 0; i < 10000; i ++) {
	    counter += (time (arr));
	}
	System.out.println("Average: " + (counter / 10000) + " nanoseconds.");
    }

    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args )
    {
	//----------- Creating Arrays ----------
	int[] arr1 = new int [1];
	int[] arr10 = new int[10]; 
	
	int[] arr100 = new int[100];
	int[] arr1000 = new int[1000];
	int[] arr10000 = new int[10000];

	fill(arr1);
	fill(arr10);
	fill(arr100);
	fill(arr1000);
	fill(arr10000);

	//--------------------------------------

        System.out.print( "Array in descending order:\n\n" );

        System.out.println( "n = 1:");
        averagePrint(arr1);

	System.out.println();
	
        System.out.println( "n = 10:");
        averagePrint(arr10);
	

	System.out.println();
	
        System.out.println( "n = 100:");
        averagePrint(arr100);
	

	System.out.println();
	
        System.out.println( "n = 1000:");
        averagePrint(arr1000);
	

	System.out.println();
	
        System.out.println( "n = 10000:");
        averagePrint(arr10000);
	
    }//end main

}//end class
