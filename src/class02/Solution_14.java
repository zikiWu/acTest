package class02;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution_14 {

    public static void main(String[] args){
        String[] s = {"flower","flow","flight"};
        Solution_14 ss = new Solution_14();
        ss.longestCommonPrefix(s);
    }

    public String longestCommonPrefix(String[] strs) {
        Trie t = new Trie();
        for (String s : strs){
            t.insert(s);
        }
        if (t.root.nexts.length>1){
            return "";
        }
        System.out.println(t.prx());
        return t.prx();
    }
    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        public TrieNode root;

        boolean isPrx;

        public Trie() {
            root = new TrieNode();
            isPrx = false;
        }

        public void insert(String word) {
            char[] ws = word.toCharArray();
            TrieNode node = root;
            for (char w : ws){
                if(node.nexts[w-'a'] == null){
                    node.nexts[w-'a'] = new TrieNode();
                }
                node.path++;
                node = node.nexts[w-'a'];
            }
            node.path++;
            node.end++;
            isPrx = true;
        }
        public String prx() {
            TrieNode node = root;
            boolean isOne = false;
            StringBuffer sb = new StringBuffer();
            while (node!=null){
                char s = 0;
                int i = 0;
                for (TrieNode w : node.nexts){
                    if (w!=null &&isOne){
                        return sb.toString();
                    }
                    if(w != null){
                        isOne = true;
                        s = (char)('a'+i);
                    }
                    i++;
                }
                node = node.nexts[i];
                sb.append(s);
            }
            return "";
        }
    }
}
