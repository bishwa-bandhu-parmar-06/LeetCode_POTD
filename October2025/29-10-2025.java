
// 3370. Smallest Number With All Set Bits


class Solution {
    public int smallestNumber(int n) {
        int x = n;
        while ((x & (x + 1)) != 0){
            x++;
        }
        
        return x;
    }
}