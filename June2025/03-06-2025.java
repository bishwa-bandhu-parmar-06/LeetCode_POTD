
// 1298. Maximum Candies You Can Get from Boxes

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;

        Queue<Integer> queue = new LinkedList<>();

        boolean visited[] = new boolean[n];
        for(int start : initialBoxes)
        {
            queue.offer(start);
        }
        
        int result = 0;
        int current = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                current = queue.poll();
                visited[current] = true;

                if(status[current] == 1)
                {
                    result += candies[current];
                }

                for(int box : containedBoxes[current])
                {
                    if(!visited[box])
                        queue.offer(box);
                }

                for(int key : keys[current])
                {
                    if(status[key] == 0 && key != current)
                    {
                        status[key] = 1;
                        if(visited[key])
                        {
                            queue.offer(key);
                        }
                    }
                }
            }
        }

        return result;
    }
}