

// 3000. Maximum Area of Longest Diagonal Rectangle


class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0; // store the longest diagonal length
        int maxArea = 0;        // store the corresponding area
        
        for (int i = 0; i < dimensions.length; i++) {
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            
            double diagonal = Math.sqrt(l * l + w * w);
            int area = l * w;
            
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
}
