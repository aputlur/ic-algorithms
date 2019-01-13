package bytetobyte;

public class FindMedianForSortedArrays {

    public static void main(String[] args) {
        double result = findMedian(new int[] { 4, 5, 6 }, new int[] { 1, 2, 3, 10, 12 });
        System.out.println("Median result -> " + result);
    }

    private static double findMedian(int[] arr1, int[] arr2) {

        // Initialize result[] array with length of both arrays.
        // resultIndex to be initiated
        // startIndex and endIndex

        int length = arr1.length + arr2.length;
        int[] result = new int[length];
        int firstArrayLength = arr1.length;
        int secondArrayLength = arr2.length;
        int currentIndex = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstArrayLength && secondIndex < secondArrayLength) {

            if (firstIndex < arr1.length && arr1[firstIndex] < arr2[secondIndex]) {
                result[currentIndex] = arr1[firstIndex];
                firstIndex++;
                currentIndex++;
            } else if (secondIndex < arr2.length && arr1[firstIndex] > arr2[secondIndex]) {
                result[currentIndex] = arr2[secondIndex];
                secondIndex++;
                currentIndex++;
            }
        }
        if (currentIndex < length) {
            if (firstIndex == arr1.length) {
                for (int i = currentIndex; i < length; i++) {
                    result[currentIndex] = arr2[secondIndex];
                    secondIndex++;
                    currentIndex++;
                }
            } else if (secondIndex == arr2.length) {

                for (int i = currentIndex; i < length; i++) {
                    result[currentIndex] = arr1[firstIndex];
                    firstIndex++;
                    currentIndex++;
                }
            }
        }
        int median = result.length / 2;
        double first = Double.valueOf(result[median - 1]);
        double second = Double.valueOf(result[median]);
        double val = (first + second) / 2;
        System.out.println(val);
        return val;
    }

    //Are these arrays have values? I mean, I assume that these arrays are populated with values.
}
