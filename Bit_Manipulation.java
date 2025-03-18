public class Bit_Manipulation {


    public static String Integer2Bit(int value) {

        String result = "";
        int n = value;

        while(n > 0) {
            int bit = n % 2;

            result = bit + result;

            n = n / 2;

        }

        return result;

    }

    public static Integer Bit2Integer(String binary) {

        int size = binary.length();
        String n = binary;
        int result = 0;

        for (int i = size - 1; i >= 0 ; i--){
            char ch = n.charAt(i);
            int bit = ch - '0';

            result = (int) (result + (bit * (Math.pow(2, size - 1- i))));
            
        }
        return result;


    }

    static boolean checkKthBit(int n, int k) {
        return (n & (1 << k)) != 0;
    }




    public static void main(String [] args) {

        System.out.println(Integer2Bit(5));
        System.out.println(Bit2Integer("101"));
        System.out.println(checkKthBit(5, 1));

    }
    
}
