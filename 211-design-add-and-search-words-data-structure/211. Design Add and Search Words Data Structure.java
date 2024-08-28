class TrieNode {
    TrieNode() {
        child = new HashMap<>();
        endOfWord = false;
    }
    public Map<Character,TrieNode> child;
    public boolean endOfWord;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode base = root;
        for (char c: word.toCharArray()) {
            if (base.child.containsKey(c)) {
                base = base.child.get(c);
            } else {
                TrieNode newNode = new TrieNode();
                base.child.put(c, newNode);
                base = newNode;
            }
        }
        base.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode base = root;
        return searchWord(word, base);
    }

    private boolean searchWord(String word, TrieNode base) {
        for (char c: word.toCharArray()) {
            if (base.child.containsKey(c)) {
                base = base.child.get(c);
            } else if (c == '.') {
                boolean find = false;
                for (TrieNode t: base.child.values()) {
                    find = find || searchWord(word.substring(word.indexOf('.')+1),t);
                }
                return find;
            } else {
                return false;
            }
        }
        return base.endOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */