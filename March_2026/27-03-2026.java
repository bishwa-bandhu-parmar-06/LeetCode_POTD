

// 2946. Matrix Similarity After Cyclic Shifts




class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length,n=mat[0].length;
        int[][] matrix=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=mat[i][j];
            }
        }
        for(int x=0;x<k%n;x++)
        {
            for(int i=0;i<m;i++)
            {
                if(i%2==0)
                {
                    int key=mat[i][0];
                    for(int j=0;j<n-1;j++)
                    {
                        mat[i][j]=mat[i][j+1];
                    }
                    mat[i][n-1]=key;
                }
                else
                {
                    int key=mat[i][n-1];
                    for(int j=n-1;j>0;j--)
                    {
                        mat[i][j]=mat[i][j-1];
                    }
                    mat[i][0]=key;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]!=mat[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
}