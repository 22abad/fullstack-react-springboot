
// import java.io.PrintStream;
// import java.io.PrintStream.print;

import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        int nums[] = {0, 5, 0, 7, 9};
        //moveZeroToFront(nums);
        // separator
        System.out.println();
        moveZeroToEnd(nums);
        System.out.println();
        bubbleZero(nums);
        System.out.println();
        bubbleZeroEnd(nums);
        System.out.println();
        zeroToLeft(nums);
        System.out.println();
        reverse(1234);
        System.out.println();
        moveCat(nums);
    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            res = res * 10 + digit;
            x /= 10;
        }
        System.out.println(res);
        return  res;
    }
    
    public static void zeroToLeft(int[] nums) {
        int n = nums.length;
        // since all zero to left, we work form tail
        // we need a index to record all the non-zero digit
        int idx = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] != 0) nums[idx--] = nums[i];
        }
        while(idx >= 0) nums[idx--] = 0;
        for (int i : nums) System.out.print(i);
    }


    // public static void zeroToLeft(int[] nums) {
    //     int n = nums.length;
    //     int newIdx = n - 1;
    //     for (int i = n - 1; i >= 0; i--) {
    //         if (nums[i] != 0) nums[newIdx--] = nums[i];
    //     }
    //     while (newIdx >= 0) nums[newIdx--] = 0;
    //     for (int i : nums) System.out.print(i);
    // }
    public static void zeroToRight(int[] nums) {
        int n = nums.length;
        int newAnchor = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) nums[newAnchor++] = nums[i];
        }
        while (newAnchor < n) nums[newAnchor++] = 0;
        for (int i : nums) System.out.print(i);
    }
        
    // public static void moveZeroToFront(int[] nums) {
    //     int n = nums.length;
    //     int nonZeroIndex = n - 1;
    //     // loop from end, fill each num w/ non-zero num;
    //     for (int i = n - 1; i >= 0; i--) {
    //        if (nums[i] != 0) {
    //            nums[nonZeroIndex] = nums[i];
    //            nonZeroIndex--;
    //        }
    //     }
    //     // fill remaining with 0
    //     while (nonZeroIndex >= 0) {
    //        nums[nonZeroIndex] = 0;
    //        nonZeroIndex--;
    //     }
    //     for (int i : nums) System.out.print(i);
    // }
    public static void moveCat (int[] nums) {
        int n = nums.length;
        // int fast = 0;
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            while (fast < n && nums[fast] != 0) {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
        }
        System.out.print(Arrays.toString(nums));
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