package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution208 {


}
class Trie {

    node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] arr = word.toCharArray();
        node n = root;
        for (char c :arr){
            int i = c-'a';
            if(n.next[i]==null){
                n.next[i] = new node();
            }
            n.next[i].prx++;
            n = n.next[i];
        }
        n.end++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        node n = root;
        for (char c :arr){
            int i = c-'a';
            if(n.next[i]==null){
                return false;
            }
            n = n.next[i];
        }
        if(n.end > 0){
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        node n = root;
        for (char c :arr){
            int i = c-'a';
            if(n.next[i]==null){
                return false;
            }
            n = n.next[i];
        }
        return true;
    }
}
class node{
    int prx;
    int end;
    node[] next;

    public node() {
        this.prx = 0;
        this.end = 0;
        this.next = new node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */