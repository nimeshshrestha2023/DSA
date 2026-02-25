class bubbleSort{
    public static void main(String[] args)
    {
        int[] arr = {23,34,12,9,3,56};
        System.out.println("Before Sorting");
        for(int el: arr)
        {
            System.out.print(el+" ");
        }
        
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        
        System.out.println("\nAfter sorting");
        for(int el: arr)
        {
            System.out.print(el+" ");
        }
        
    }
}