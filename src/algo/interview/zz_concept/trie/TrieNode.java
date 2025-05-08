package algo.interview.zz_concept.trie;

// 트라이 각각의 노드는 TrieNode 클래스가 되고
// 자식 노드는 children 이라는 멤버 변수에 묶이는 형태

public class TrieNode {
    boolean word;
    TrieNode[] children;

    TrieNode() {
        children = new TrieNode[26];
        word = false;
    }

}
