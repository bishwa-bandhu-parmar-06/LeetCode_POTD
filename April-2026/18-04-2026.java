
// 3783. Mirror Distance of an Integer


class Solution {
    public int mirrorDistance(int n) {
        int originalNumber = n;
        int reverse = 0;
        while(n != 0){
            int rem = n % 10;
            reverse = reverse * 10 + rem;
            n = n / 10;
        };
        int result = Math.abs(originalNumber - reverse);
        return result;
    }
}