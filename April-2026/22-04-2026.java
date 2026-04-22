// 2452. Words Within Two Edits of Dictionary



class Solution {
    public List<String> twoEditWords(final String[] queries, final String[] dictionary) {
        final List<String> words = new ArrayList<>();
        final TrieNode root = new TrieNode();

        for(final String word : dictionary)
            insert(root, word);

        for(final String word : queries)
            if(match(root, word, 0, 0))
                words.add(word);

        return words;
    }

    private void insert(TrieNode root, final String word) {
        for(final char c : word.toCharArray()) {
            final int idx = c - 'a';

            if(root.children[idx] == null)
                root.children[idx] = new TrieNode();

            root = root.children[idx];
        }
    }

    private boolean match(TrieNode root, final String word, final int idx, int miss) {
        if(root == null || miss > 2)
            return false;

        if(idx >= word.length())
            return true;

        final int index = word.charAt(idx) - 'a';

        if(match(root.children[index], word, idx + 1, miss))
            return true;

        if(miss < 2)
            for(int i = 0; i < 26; ++i)
                if(i != index && match(root.children[i], word, idx + 1, miss + 1))
                    return true;

        return false;
    }

    private class TrieNode {
        public final TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}