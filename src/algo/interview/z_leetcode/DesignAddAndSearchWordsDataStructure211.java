package algo.interview.z_leetcode;

public class DesignAddAndSearchWordsDataStructure211 {

    public static void main(String[] args) {
        WordDictionary wordDic = new WordDictionary();
        wordDic.addWord("bad");
        wordDic.addWord("dad");
        wordDic.addWord("mad");
        System.out.println(wordDic.search("pad")); // return False
        System.out.println(wordDic.search("bad")); // return True
        System.out.println(wordDic.search(".ad")); // return True
        System.out.println(wordDic.search("b..")); // return True
    }

    static class TrieNode {
        boolean word;
        TrieNode[] children;

        TrieNode() {
            this.word = false;
            this.children = new TrieNode[27];
        }
    }

    static class WordDictionary {
        TrieNode root;
        public WordDictionary() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {

            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        public boolean dfs(String word, int index, TrieNode node) {

            if (index == word.length()) {
                return node.word;
            }

            char c = word.charAt(index);

            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && dfs(word, index + 1, child)) {
                        return true;
                    }
                }
                return false;

            } else {

                TrieNode next = node.children[c - 'a'];
                return next != null && dfs(word, index + 1, next);

            }
        }
    }
}
