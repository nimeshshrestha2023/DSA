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
***
# Algorithm for Binary Search: 
1. Begin.
2. Set arr[] = {1,2, .....} or you can explicitely create a dynamic array.
3. Set lower = 0, upper = arr.length -1 , found = 0, mid = -1
4. Take user input key for searching
5. Generate a loop: while(lower <= upper)
6. Set mid = (lower + upper) / 2
7. if(arr[mid] == key) then set found = 1 then break
8. if(arr[mid] < key) then
   set lower = mid + 1
   else
   set upper = mid - 1
9. if found = 1, then print "Item found " with location = mid
    else
   print "Item not found"
10. Exit
***



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



