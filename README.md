# Binary Search: 
```

import java.util.Scanner;
class Main{
    public static void main(String[] args)
    {
    
        Scanner sc = new Scanner(System.in);
        System.out.println("How many array size: ");
        int size = Integer.valueOf(sc.nextLine());
        System.out.println("Enter "+size+" different numbers: ");
        int[] arr = new int[size];
        for(int i=0;i<size;i++)
        {
            System.out.println("Number: "+(i+1));
            arr[i] = Integer.valueOf(sc.nextLine());
        }
        System.out.println("Enter the searching elemnts: ");
        int item = Integer.valueOf(sc.nextLine());
        int lower = 0, upper = arr.length-1, found = 0, mid = -1;
        
        while(lower <= upper)
        {
            mid = (lower + upper) / 2;
            if(arr[mid] == item)
            {

                found++;
                break;
            }
            if(arr[mid] < item)
            {
                lower = mid + 1;
            }else{
                upper = mid - 1;
            }
        }
        if(found == 1)
        {
             System.out.println("Elements found at index: "+mid);
        }else{
            System.out.println("Element not found: ");
        }
    }
}
```

# Linear Search:

```
import java.util.Scanner;
class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many array size: ");
        int size = Integer.valueOf(sc.nextLine());
        System.out.println("Enter "+size+" different numbers: ");
        int[] arr = new int[size];
        for(int i=0;i<size;i++)
        {
            System.out.println("Number: "+(i+1));
            arr[i] = Integer.valueOf(sc.nextLine());
        }
        System.out.println("Enter the searching elemnts: ");
        int item = Integer.valueOf(sc.nextLine());
        
        int i = 0;
        while(i<arr.length)
        {
            if(arr[i] == item)
            {
                System.out.println("Element found at index: "+i);
                break;
            }
            i++;
            
        }
        if(i>=arr.length)
        {
            System.out.println("Items not found: ");
        }
       
    }
    
}

```



