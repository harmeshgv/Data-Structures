import java.util.HashMap;
public class zerosumSubarray {

    public static void main(String [] args) {
        int a[] = {1, 2, 3, 8, 4, -15, 2, 3, 5};
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for ( int i = 0 ; i < a.length; i++) {
            sum+= a[i];
            if(sum == 0) {
                System.out.println("Sub array found from 0th index till " + 1);
            }

            if(hm.containsKey(sum)) {
                System.out.println("Sub array found from "+ (hm.get(sum) + 1)+" to " + 1);
            }
        }
    }
    
}
