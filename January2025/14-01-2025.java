// 2657. Find the Prefix Common Array of Two Arrays



class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        // int n1 = B.length;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j <= i; j++){
                for(int k = 0; k <= i; k++){
                    if(A[j] == B[k]){
                        count++;
                        break;
                    }
                }
            }
            result[i] = count;
        }
        return result;
    }
}