
// 2011. Final Value of Variable After Performing Operations


class Solution {
    public int finalValueAfterOperations(String[] operations) {
        return java.util.Arrays.stream(operations).mapToInt(op -> op.charAt(1) == '+' ? 1 : -1).sum();
    }
}