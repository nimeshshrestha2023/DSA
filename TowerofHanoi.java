public class TowerofHanoi{
    public static void towerofhanoi(int n, char src, char aux, char dest)
    {
        if(n == 1)
        {
            System.out.println(src+" ->"+dest);
            return;
        }
        towerofhanoi(n-1,src,dest,aux);
        towerofhanoi(1,src,aux,dest);
        towerofhanoi(n-1,aux,src,dest);
    }
    public static void main(String[] args)
    {
        towerofhanoi(3,'a','b','c');
    }

}
