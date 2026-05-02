public class Main{

    public static void conquer(int[] arr, int si, int mid, int ei){
        // Temporary array to store merged (sorted) elements
        int[] merged = new int[ei - si + 1];
        
        int idx1 = si;      // Pointer for left subarray
        int idx2 = mid + 1; // Pointer for right subarray
        int x = 0;          // Pointer for merged array
        
        // Compare elements from both halves and store smaller one
        while(idx1 <= mid && idx2 <= ei){
            if(arr[idx1] < arr[idx2]){
                merged[x++] = arr[idx1++];
            }else{
                merged[x++] = arr[idx2++];
            }
        }
        
        // Copy remaining elements from left half (if any)
        while(idx1 <= mid){
            merged[x++] = arr[idx1++];
        }
        
        // Copy remaining elements from right half (if any)
        while(idx2 <= ei){
            merged[x++] = arr[idx2++];
        }
        
        // Copy merged (sorted) elements back into original array
        for(int i = 0, j = si; i < merged.length; i++, j++){
            arr[j] = merged[i];
        }
    } 
    
    public static void divide(int[] arr, int si, int ei){
        // Base case: when array has 1 or no element (already sorted)
        if(si >= ei){
            return;
        }

        // Find middle index (prevents overflow compared to (si + ei)/2)
        int mid = si + (ei - si) / 2;

        // Recursively divide left half
        divide(arr, si, mid);

        // Recursively divide right half
        divide(arr, mid + 1, ei);

        // Merge both sorted halves
        conquer(arr, si, mid, ei);
    }

    public static void main(){
        int[] arr = {23, 56, 324, 56767, 34};
        int n = arr.length;
        
        // Start merge sort
        divide(arr, 0, n - 1);

        // Print sorted array
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
