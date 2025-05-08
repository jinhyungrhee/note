package algo.interview.zz_concept.trie;

// 트라이 연산을 구현할 별도의 클래스
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * [자식노드의 인덱스 정하는 방식]
     * - 유니코드 값 사용
     * - 문자에서 문자를 빼면 아스키 코드 값의 차이(=유니코드 값)를 리턴함
     * - 알파벳의 경우, 유니코드가 아스키 코드와 동일함
     * - (예시)
     *   > 'a' - 'a' = 0
     *   > 'f' - 'a' = 5
     *   > 'z' - 'a' = 25
     *   > 'a' == 97 (0번 인덱스 사용)
     *   > 'z' == 122 (25번 인덱스 사용)
     */
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = true;
    }

    /**
     * [search]
     * - 문자 단위로 계속 깊이 탐색 진행
     * - 마지막에 word(문자 여부)가 true 인지 확인
     */
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.word == true;
    }

    /**
     * [startWtih]
     * - 문자 탐색만 모두 완료한다면, 단어 완성 여부와 상관없이 항상 true 리턴
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}
