import java.util.Scanner;

public class primeCheck {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        int num= scanner.nextInt();

        if(prime(num) == false){

            System.out.println("It is not a prime number");

        }else{
            System.out.println("It is a prime number");
        }

    }

    public static boolean prime(int number){

        for (int i = 2; i < Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }


        return true;
    }
    
}
