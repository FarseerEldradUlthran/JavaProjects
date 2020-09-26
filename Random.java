import java.util.Random;
class Random1 {
    public static void completion(int array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ( 7 + Math.random() * 23);
        }
    }
    public static void completion_too(int array2[]) {
        Random rand = new Random();
        rand.nextInt();
        for (int i = 0; i < array2.length; i++) {
            array2[i] = rand.nextInt(10000);
        }
    }
    public static void show(int array[]) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }
    public static void sort(int array[]) {
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i + 1]){
                    isSorted = false;
                    buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                }
            }
        }
        show(array);
    }
    public static void main(String [] args) {
        int array[] = new int[10];
        int array2[] = new int[10];
        completion(array);
        show(array);
        sort(array);
        completion_too(array2);
        show(array2);
        sort(array2);

    }
}
