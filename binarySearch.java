import java.util.Scanner;

class binarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        int lower = 0, upper = arr.length - 1; 
        int found = 0;

        System.out.println("Enter the element to search: ");
        int key = sc.nextInt();

        int mid = -1; 
        while (lower <= upper) {
            mid = (upper + lower) / 2;
            if (arr[mid] == key) {
                found = 1;
                break;
            }
            if (arr[mid] < key) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }

        if (found == 1) {
            System.out.println("Element found at index: " + mid);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}
