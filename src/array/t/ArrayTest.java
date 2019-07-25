package array.t;
import java.util.Arrays;
public class ArrayTest {
    public static int[] sort1(int[] arr) {
        // 冒泡排序:走若干趟，每趟从头开始和后面的对比，一有比当前小的就交换，则每趟能将最大的放到最后
        // 同时每趟走的距离减少已排好的长度
        int[] newArr = arr.clone();
        for (int i = 0; i < newArr.length; i += 1) {
            for (int j = 0; j < newArr.length - i - 1; j += 1) {
                if (newArr[j] > newArr[j + 1]) {
                    int temp = newArr[j];
                    newArr[j] = newArr[j + 1];
                    newArr[j + 1] = temp;
                }
            }
        }
        return newArr;
    }
    public static int[] sort2(int[] arr) {
        // 选择排序:从0的位置开始，和后面的比，如果有比当前位置小的就换上来，达到每次把剩下的最小的放到前面
        // 都过一遍之后就能排出从小到大的顺序
        int[] newArr = arr.clone();
        for (int i = 0; i < newArr.length; i += 1) {
            for (int j = i + 1; j < newArr.length; j += 1) {
                if (newArr[i] > newArr[j]) {
                    int temp = newArr[j];
                    newArr[j] = newArr[i];
                    newArr[i] = temp;
                }
            }
        }
        return newArr;
    }
    public static int search1(int[] arr, int target) {
        // 基本查找
        int r = -1;
        for (int i = 0; i < arr.length; i += 1) {
            if (arr[i] == target) {
                r = i;
                break;
            }
        }
        return r;
    }
    public static int search2(int[] arr, int target) {
        // 二分查找
        int bigIndex = arr.length - 1;
        int smallIndex = 0;
        int middleIndex = (bigIndex + smallIndex) / 2;
        int r = -1;
        while (smallIndex <= bigIndex) {
            if (arr[middleIndex] == target) {
                r = middleIndex;
                break;
            } else if (arr[middleIndex] > target) {
                bigIndex = middleIndex - 1;
                middleIndex = (bigIndex + smallIndex) / 2;
            } else {
                smallIndex = middleIndex + 1;
                middleIndex = (bigIndex + smallIndex) / 2;
            }
        }
        return r;
    }
    public static int[] transformBytesToInts(byte[] arr) {
        int[] r = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1) {
            r[i] = arr[i];
        }
        return r;
    }
    public static String reverseStr(String str) {
        byte[] arr = str.getBytes();
        int[] arr2 = transformBytesToInts(arr);
        int[] sortedArr = sort2(arr2);
        char[] charArr = new char[sortedArr.length];
        for (int i = 0; i < sortedArr.length; i += 1) {
            charArr[i] = (char)sortedArr[i];
        }
        return new String(charArr);
    }
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13};
        int[] arr2 = sort1(arr);
        int[] arr3 = sort2(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("arr2:" + Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        int index1 = search1(arr, 24);
        System.out.println(index1);
        int index2 = search2(arr2, 80);
        System.out.println(index2);
        System.out.println(reverseStr("fesddffg"));
        System.out.println(Arrays.binarySearch(arr, 14));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
