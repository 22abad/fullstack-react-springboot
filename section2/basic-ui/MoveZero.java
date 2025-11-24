
public class MoveZero {
    public static void main(String[] args) {
        int nums[] = {0, 5, 0, 7, 9};
        moveZeroToFront(nums);
        // separator
        System.out.println();
        moveZeroToEnd(nums);
        System.out.println();
        bubbleZero(nums);
        System.out.println();
        bubbleZeroEnd(nums);
        System.out.println();
    }
    public static void moveZeroToFront(int[] nums) {
        int n = nums.length;
        int nonZeroIndex = n - 1;
        // loop from end, fill each num w/ non-zero num;
        for (int i = n - 1; i >= 0; i--) {
           if (nums[i] != 0) {
               nums[nonZeroIndex] = nums[i];
               nonZeroIndex--;
           }
        }
        // fill remaining with 0
        while (nonZeroIndex >= 0) {
           nums[nonZeroIndex] = 0;
           nonZeroIndex--;
        }
        for (int i : nums) System.out.print(i);
    }
    public static void moveZeroToEnd(int[] nums) {
        int n = nums.length;
        int nonZeroIndex = 0;
        for (int i = 0; i < n; i++) {
           if (nums[i] != 0) {
               nums[nonZeroIndex] = nums[i];
               nonZeroIndex++;
           }
        }
        while (nonZeroIndex < n) {
           nums[nonZeroIndex] = 0;
           nonZeroIndex++;
        }
        for (int i : nums) System.out.print(i);
    }
    public static void bubbleZero(int[] nums) {
        // int nums[] = {0, 5, 0, 7, 9}; 

        for (int j = 0; j < nums.length; j++) {
            // bubble up the 0
            for (int i = 1; i < nums.length; i++) {
                // swap when current is 0 and previous is non-zero
                if (nums[i] == 0 && nums[i-1] != 0) {
                    // swap
                    int temp = nums[i]; 
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "");
        }

    }
    public static void bubbleZeroEnd(int[] nums) {
        // int nums[] = {0, 5, 0, 7, 9}; 
        int n = nums.length - 1;
        for (int j = n; j >= 0; j--) {
            // bubble up the 0
            for (int i = n - 1; i >= 0; i--) {
                // swap when current is 0 and next is non-zero
                if (nums[i] == 0 && nums[i + 1] != 0) {
                    // swap
                    int temp = nums[i]; 
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "");
        }

    }

}