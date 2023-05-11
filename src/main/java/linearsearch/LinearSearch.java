package linearsearch;

public class LinearSearch {

    public static int linearSearch(int [] arr, int searchTerm){
        if(arr.length == 0){
            return -1;
        }

        for(int i=0;i< arr.length;i++){
            if(arr[i] == searchTerm){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,9,8,4};
        System.out.println(linearSearch(arr, 9));
    }
}
