import java.util.Arrays;
import java.util.List;

public class Binary_search{

    public static boolean binarySearch(List<Integer> array, int target){
        int start = 0;
        int end = array.size() - 1;
        
        while(start <= end){
            int mid = start + (end - start)/2;

            if(array.get(mid) == target){
                return true;
            }
            else if(array.get(mid) > target){
                end = mid - 1;
            }
            else if(array.get(mid) < target){
                start = mid + 1;
            }
        }
        return false;

    }

    public static void main(String [] args){

        System.out.println("Hello");
        List<Integer> num = Arrays.asList(1,3,4,5,6,7,8);
        int target = 4;

        boolean output = binarySearch(num, target);

        System.out.println(output);


    }
}