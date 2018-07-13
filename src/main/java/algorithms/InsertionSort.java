package algorithms;

public class InsertionSort {

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{45,76,12,98,34,193,78,23,65,23,65,456,3,56,21};

        Integer[] array = InsertionSort.insertionSort(vals);

        for(Number n : array){
            System.out.print(n + " | ");
        }
    }

    public static <N extends Number> N[] insertionSort(N[] array){

        long startime = System.nanoTime();
        // if there is 0 or 1 element in the array, return array
        if (array.length < 2){
            return array;
        }

        // iterate through the original array
        for (int i = 1; i < array.length; i++){
            // back up element at array[i]
            N num = array[i];
            // create index that is one less than i
            int j = i - 1;

            // compare against every value in sorted size of the list until the correct spot to insert it is found
            while(j >= 0 && array[j].doubleValue() > num.doubleValue()){
                // shuffle elements to the right
                array[j + 1] = array[j];
                // decrement
                j--;
            }
            // insert num at appropriate location
            array[j + 1] = num;
        }
        // pring the time it took in nanoseconds
        System.out.println("\nTime: " + (System.nanoTime() - startime));

        return array;
    }
}
