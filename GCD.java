import java.util.Scanner;

class GCD{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two number: ");
        int num1 = Integer.valueOf(sc.nextLine());
        int num2 = Integer.valueOf(sc.nextLine());
        
        System.out.println("GCD of "+num1+" and "+num2+" is "+gcd(num1,num2));
    }
    
    public static int  gcd(int num1, int num2)
    {
        if(num2 != 0)
        {
            return gcd(num1,num1 % num2);
        }else{
            return num1;
        }
    }
}