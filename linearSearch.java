import java.util.Scanner;

class linearSearch{
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        int[] arr = {1,2,3,4,6,7};
        int i = 0;
        System.out.println("Enter the searching key: ");
        int key = Integer.valueOf(sc.nextLine());
        
        while(i<arr.length)
        {
            if(arr[i] == key)
            {
                System.out.println("Element found at index: "+i);
                break;
            }
            i++;
        }
        if(i>=arr.length)
        {
            System.out.println("Element not found: ");
        }
        
    }
}