public class First {
    public static void first( int array[], int sum1){
        for (int i = 0; i < array.length; i++){
            sum1 = sum1 + array[i];
        }
        System.out.println(sum1);
    }
    public static void second( int array[], int sum2, int i){
        while (i != array.length){
            sum2 = sum2 + array[i];
            i++;
        }
        System.out.println(sum2);
    }
    public static void third( int array[], int sum3, int i){
        do{
            sum3 = sum3 + array[i];
            i++;
        } while (i != array.length);
        System.out.println(sum3);
    }
}

class App extends First{
    public static void main(String[] args) {
        int[] array = {0, 1, 3, 5, 7, 13, 17, 54};
        int sum = 0, i = 0;
        first(array, sum);
        second(array, sum, i);
        third(array, sum, i);
    }
}
