class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
        for (char c: word.toCharArray()) {
            if (base.child.containsKey(c)) {
                base = base.child.get(c);
            } else {
                return false;
            }
        }
        return base.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode base = root;
        for (char c: prefix.toCharArray()) {
            if (base.child.containsKey(c)) {
                base = base.child.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {
    TrieNode() {
        child = new HashMap<>();
        endOfWord = false;
    }
    public Map<Character,TrieNode> child;
    public boolean endOfWord;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */