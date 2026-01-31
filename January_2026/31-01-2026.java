
// 744. Find Smallest Letter Greater Than Target

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
       int index=0;
       while(index<letters.length && letters[index]<=target){
         index++;
       }
       if(index>=letters.length) return letters[0]; 
       return letters[index];
    }
}