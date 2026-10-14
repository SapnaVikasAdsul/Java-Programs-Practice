
public class SecondLarge {

    public static void main(String[] args) {
        int[] arr = {-10, -20, -5, -30};

        Integer largest = null;
        Integer secondLargest = null;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (largest == null || num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num != largest
                    && (secondLargest == null || num > secondLargest)) {
                secondLargest = num;
            }
        }

        if (secondLargest != null) {
            System.out.println(secondLargest);
        } else {
            System.out.println("No second largest element");
        }
    }
}
