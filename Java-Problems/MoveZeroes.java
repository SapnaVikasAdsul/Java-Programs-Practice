
public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
