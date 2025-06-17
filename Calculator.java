import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("1.add 2.subtract 3.multiply 4.division");
        int option = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        float result = calculate(option,a,b);
        System.out.println("Your Result:");
        System.out.println(result);


    }

    public static float calculate(int option, int a, int b){

        switch(option){
            case 1:
              return a + b;
            
            case 2:
              return a - b;
            
            case 3:
              return a * b;
            
            case 4:
              return (float)a / b;
            
            default:
              return 0;
        }
    }
}
