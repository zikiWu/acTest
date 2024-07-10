package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 208. 实现 Trie (前缀树)
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 */
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
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */