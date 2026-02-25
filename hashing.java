public class hashing{
    public static void main(String[] args) {
        Hashing hash = new Hashing(10);
        hash.insertHash(10);
        hash.insertHash(34);
        hash.insertHash(45);

        hash.display();
        

    }
}

class Hashing{
    int tableSize;
    Integer[] arr;
    public Hashing(int tableSize)
    {
        this.tableSize = tableSize;
        arr = new Integer[tableSize];
    }

    public int hashFunction(int key)
    {
        return key % this.tableSize;
    }
    public boolean collision(int index)
    {
        return (arr[index] != null);
    }

    public void insertHash(int key)
    {
        int index = hashFunction(key);
        int i = 1;
        while(collision(index))
        {
            index = (hashFunction(key)+i) % this.tableSize;
            i++;
        }
        arr[index] = key;
    }

    public void display()
    {
        for(int i=0;i<tableSize;i++)
        {
            System.out.println("Index "+i+" :"+arr[i]);
        }
    }
}