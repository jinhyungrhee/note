package algo.interview.zz_concept.trie;

public class Main {
    public static void main(String[] args) {

        Trie t = new Trie();
        t.insert("apple");
        t.insert("appear");
        t.insert("appeal");

        System.out.println(t.search("appeal"));
        System.out.println(t.startsWith("app"));
        System.out.println(t.startsWith("bpp"));

    }
}
