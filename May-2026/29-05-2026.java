// 3300. Minimum Element After Replacement With Digit Sum





import java.util.ArrayList;

class Solution {
    public int minElement(int[] nums) {

        ArrayList<Integer> dynamicArray = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            int newElement = 0;

            while (num != 0) {
                int rem = num % 10;
                newElement = newElement + rem;
                num = num / 10;
            }

            dynamicArray.add(newElement);
        }

        int min = dynamicArray.get(0);

        for (int i = 1; i < dynamicArray.size(); i++) {
            if (dynamicArray.get(i) < min) {
                min = dynamicArray.get(i);
            }
        }

        return min;
    }
}