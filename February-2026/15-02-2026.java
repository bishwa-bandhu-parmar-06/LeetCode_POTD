// 67. Add Binary



class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        int carry = 0;
        char ca = '0';
        char cb = '0';
        while(len1 >= 0 || len2 >= 0 || carry == 1){
            ca = (len1 >= 0) ? a.charAt(len1) : '0';
            cb = (len2 >= 0) ? b.charAt(len2) : '0';

            if((ca == '1' && cb == '1') && carry == 1){
                sb.append('1');
                carry = 1;
            } else if((ca == '1' && cb == '1') && carry == 0){
                sb.append('0');
                carry = 1;
            } else if((ca == '1' && carry == 1) || (cb == '1' && carry == 1)){
                sb.append('0');
                carry = 1;
            } else if(ca == '1' || cb == '1'){
                sb.append('1');
            } else if(carry == 1){
                sb.append('1');
                carry = 0;
            } else {
                sb.append('0');;
            }
            len1--;
            len2--;
        }
        return sb.reverse().toString();
    }
}