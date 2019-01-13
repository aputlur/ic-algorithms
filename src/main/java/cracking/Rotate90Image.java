package cracking;

public class Rotate90Image {

    public static void main(String[] args) {

        int[][] image = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] result = nonInPlace(image);
        System.out.println("sd");
    }

    private static int[][] nonInPlace(int[][] image) {

        int[][] result  = new int[3][3];

        for(int col=0;col < image.length; col++){

            for(int row =image.length-1;row>=0;row--){
                result[col][image.length-1-row] = image[row][col];
            }
        }
        return result;
    }

}
