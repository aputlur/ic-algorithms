package educative;

public class BinarySearch {

    public static void main(String[] args) {
        int result = binarySearch(new int[] {1,2,3,4,5,6}, 9);
        System.out.println("found at ->" + result);
    }

    private static int binarySearch(int[] array, int target) {

        int min = 0;
        int max = array.length-1;

    
        while(min < max) {
            int mid = (min+max)/2;
            
            if (array[mid] == target)
                return mid;

            if (array[mid] < target) {
                min = mid + 1;
                max = array.length - 1;
//                binarySearch(array,target);
            } else {
                min = 0;
                max = mid -1;
//                binarySearch(array,target);
            }
        }

        return -1;

    }

}
