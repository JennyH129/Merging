/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: 10
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
	    ray[i] = ray.length - i;
	}
    }

    public static void time(int[] ray){
	long counter = 0;
	for (int i = 0; i < 10; i++){
	    long start = System.nanoTime();
	    MergeSort.sort(ray);
	    long end = System.nanoTime();
	    long taken = end - start;
	    counter += taken;
	    System.out.println("\tTrial " + (i + 1) + ": " + taken + " nanoseconds.");
	}
	System.out.println("Average: " + (counter / 10) + " nanoseconds.");
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
	int[] descending1 = {0};
	int[] descending10 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	
	int[] descending100 = new int[100];
	int[] descending1000 = new int[1000];
	int[] descending10000 = new int[10000];

	fill(descending100);
	fill(descending1000);
	fill(descending10000);

	//--------------------------------------

        System.out.print( "Array in descending order:\n\n" );

        System.out.println( "n = 1:");
        time(descending1);

	System.out.println();
	
        System.out.println( "n = 10:");
        time(descending10);
	

	System.out.println();
	
        System.out.println( "n = 100:");
        time(descending100);
	

	System.out.println();
	
        System.out.println( "n = 1000:");
        time(descending1000);
	

	System.out.println();
	
        System.out.println( "n = 10000:");
        time(descending10000);
	
    }//end main

}//end class
