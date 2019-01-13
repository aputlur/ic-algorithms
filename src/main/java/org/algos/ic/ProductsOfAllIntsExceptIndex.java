package org.algos.ic;

public class ProductsOfAllIntsExceptIndex {

    public static void main(String[] args) {


        int result[] = getProductsOfAllIntsExceptAtIndex(new int[] {1,2,3,4});
        for(int k : result){
            System.out.print(k + ",");
        }
    }

     // output -> {24,12,8,6}
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if(intArray.length < 2) throw new IllegalArgumentException();
        int[] productsofAllIntsExceptAtIndex = new int[intArray.length];

        int productSoFar = 1;

        //from first to last
        for(int i=0;i<intArray.length;i++){
            productsofAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }


        //from last to first
        productSoFar = 1;
        for(int i=intArray.length-1;i>=0;i--){
            productsofAllIntsExceptAtIndex[i]*=productSoFar;
            productSoFar *= intArray[i];
        }
        return productsofAllIntsExceptAtIndex;
    }

}
