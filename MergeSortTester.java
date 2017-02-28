/*======================================
  class MergeSortTester

  ALGORITHM:
    1) Run averagePrint() on numbers 0 -- 10,000 with an interval of 100 -- batch size up to
        10000
        a) averagePrint(i) returns average runtime on batch size i -- runs 10000 times and then averages the MergeSort times to give an accurate measure of the average time it takes to sort an array of that size
            b) uses time() which gives one single time
                c) uses fill(), which makes the array first
            

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(nlogn)

  Mean execution times for dataset of size n:
  Batch size: 10000
  n=1       time (nanoseconds): 57
  n=10      time: 990
  n=100     time: 10682
  ...
  n=10000  time: 1696798

  ANALYSIS:
  Looking at the values of both the MergeSort algorithm and putting in a graph, it does seem to meet the O(nlogn) classification best. When comparing its values to a known linear time algorithm, its graph is significantly steeper and its values higher -- thus, it cannot possibly be either of linear time nor logarithmic time (purely O(n)) since O(n) would result in even lesser values. At the same time, however, its graph is not quite as steep, curved, and parabolic as a O(n^2) graph and definitely not as steep compared to the O(n) line as a O(2^n) curve. Thus, the logical conclusion would be to assume that the runtime efficiency is somewhere between O(n) and O(n^2) -- O(nlogn), as hypothesized.
  ======================================*/

public class MergeSortTester 
{

   // ============================== HELPERS ===================================//
    
    /*
       * Makes a random array to be sorted
       * int ray = size of randomly filled array
       * returns int[] filled with random numbers <= ray in a random order
    */
    public static int[] fill(int ray){
        int[] ary = new int[ray];
        for(int i = 0; i < ary.length; i++){
            ary[i] = (int) (Math.random() * ray);
        }
        return ary;
    }
    
    /*
        * Helper method to measure the amount of time it takes to do mergesort
        * Takes in an int ray = array size for merge sort to be performed on
        * Returns the amount of time it took to perform mergesort in nanoseconds
    */
    public static long time(int ray){
        //Makes randomly filled array
        int[] newAry = fill(ray);
        
        //Starts time
        long start = System.nanoTime();
        
        //Sorts it w/ MergeSort on newly filled array
        MergeSort.sort(newAry);
        
        // Ends time
        long end = System.nanoTime();
        
        //Returns total time
        return end - start;  
    }
    
    //Times how long it takes to fill an array
    public static long ntime(int ray){
        
        //Starts time
        long start = System.nanoTime();
        
        //Fills array
        fill(ray);
        // Ends time
        long end = System.nanoTime();
        
        //Returns total time
        return end - start;  
    }
    
    /*
        * Helper method to find the average time it takes to perform mergesort 
        * int arr = desired batch size 
        * Returns average of mergesort on 10,000 arr-sized int[]s
    */
    public static long averagePrint (int arr) {
        
       // counter is used to add up all the mergesort times
	   long counter = 0;
        
       // Performs merge sort on 10000 arr-sized arrays and gets the times -- 10,000 repetitions
	   for (int i = 0; i < 100000; i ++) {
	    counter += (time (arr));
	   }
        
       // Returns average of these times
	   return (counter / 100000);
    }
    
    
    //
    public static long averagePrintn (int arr) {
        
       // counter is used to add up all the times
	   long counter = 0;
        
       // Performs linear process - filling an array - on 10000 arr-sized arrays and gets the times -- 10,000 repetitions
	   for (int i = 0; i < 100000; i ++) {
	    counter += (ntime (arr));
	   }
        
       // Returns average of these times
	   return (counter / 100000);
    }
    
//====================================== MAIN METHOD ==========================================
    /******************************
     * execution time analysis 
     * From the numbers 100 -- 1000 batch sizes w/ intervals of 10, this performs mergeSort on each 1000 times and prints out the average 
     * Also generates times for more extreme values
     ******************************/
    public static void main( String[] args )
    {
        //====================================== CONTROL GROUP (O(n) runtime method) ================
        //Uses known processes with O(n) runtime - filling an array randomly and times them to have a baseline to compare to
        System.out.println("n = 1: " + averagePrintn(1));
        System.out.println("n = 10: " + averagePrintn(10));
        
        for (int i = 100; i <= 1000; i += 10){
    
          System.out.println(averagePrintn(i));
          
        }
        System.out.println("n = 5000" + averagePrintn(5000));
        System.out.println("n = 10,000" + averagePrintn(10000));
        
        //====================================== MERGE SORT =========================================
	   System.out.println("n = 1: " + averagePrint(1));
        System.out.println("n = 10: " + averagePrint(10));
        
        for (int i = 100; i <= 1000; i += 10){
    
          System.out.println(averagePrint(i));
          
        }
        System.out.println("n = 5000" + averagePrint(5000));
        System.out.println("n = 10,000" + averagePrint(10000));
        
    }//end main

}//end class
