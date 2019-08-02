package collection.t;

public class Genericity {
    public static <E> void printArray(E[] arr) {
        for (E elem : arr) {
            System.out.print(elem);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5, 6};
        String[] stringArr = {"hello", "world", "hi"};
        Character[] charArr = {'a', 'b', 'c', 'd'};
        printArray(intArr);
        printArray(stringArr);
        printArray(charArr);
    }
}
