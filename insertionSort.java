import java.util.Scanner;

public class insertionSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements?");
        int limit = Integer.valueOf(sc.nextLine());

        System.out.println("Enter "+limit+" numbers: ");
        int[] arr = new int[limit];
        
        for(int i=0;i<arr.length;i++)
        {
            System.out.println("Number: "+i);
            arr[i] = Integer.valueOf(sc.nextLine());
        }


        

    }

}