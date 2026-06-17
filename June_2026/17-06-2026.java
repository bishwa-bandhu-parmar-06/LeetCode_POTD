




class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];
        long curr = 0;

        // Forward pass: track the length after each operation
        for (int i = 0; i < n; i++) {
            char op = s.charAt(i);
            if (op >= 'a') {
                curr++;                 // append a letter
            } else if (op == '*') {
                if (curr > 0) curr--;   // backspace
            } else if (op == '#') {
                curr *= 2;               // duplicate
            }
            // '%' (reverse) doesn't change the length
            len[i] = curr;
        }

        if (k >= curr) return '.';       // k is out of bounds

        // Backward pass: rewind k through the operations
        for (int i = n - 1; i >= 0; i--) {
            char op = s.charAt(i);
            long lenBefore = (i > 0) ? len[i - 1] : 0;
            long lenAfter = len[i];

            if (op >= 'a') {
                if (k == lenBefore) return op;   // this letter created index k
            } else if (op == '#') {
                if (k >= lenBefore) k -= lenBefore; // it's in the duplicated half
            } else if (op == '%') {
                k = lenAfter - 1 - k;             // mirror the index
            }
            // '*': backspace never affects a still-valid index, skip it
        }

        return '.'; // unreachable when k was valid, kept as a safe fallback
    }
}