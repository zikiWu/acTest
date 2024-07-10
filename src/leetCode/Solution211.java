package leetCode;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // 返回 False
 * wordDictionary.search("bad"); // 返回 True
 * wordDictionary.search(".ad"); // 返回 True
 * wordDictionary.search("b.."); // 返回 True
 *
 */
public class Solution211 {
    public static void main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("b");
        wordDictionary.search("b.");
        System.out.println(wordDictionary);
    }


}
class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node('#');
    }

    public void addWord(String word) {
        Node pre = root;
        for (int i = 0; i < word.length(); i++){
            Node[] curCs = pre.cs;
            Node curNode = curCs[word.charAt(i) - 'a'];
            if (curNode == null){
                curNode = new Node(word.charAt(i));
                curCs[word.charAt(i) - 'a'] = curNode;
                curNode.num = 1;
            }else {
                curNode.num ++;
            }
            if (i == word.length() - 1){
                curNode.end ++;
            }
            pre = curNode;
        }
    }

    public boolean search(String word) {
        if (word == null){
            return true;
        }
        boolean b = searchSub(word, 0, root);
        System.out.println(b);
        return b;
    }

    public boolean searchSub(String word, int i, Node curNode) {
        if (curNode != null && i >= word.length()){
            if (curNode.end > 0){
                return true;
            }else {
                return false;
            }
        }
        if (curNode == null){
            return false;
        }
        if (word.charAt(i) == '.'){
            boolean result = false;
            for (int j = 0; j < 26; j ++){
                result = result || searchSub(word, i + 1, curNode.cs[j]);
            }
            return result;
        }else{
            return curNode.cs[word.charAt(i) - 'a'] != null && searchSub(word, i + 1, curNode.cs[word.charAt(i) - 'a']);
        }
    }


    class Node{
        private int num;
        private int end;
        private char var;
        private Node[] cs;
        public Node(char var){
            cs = new Node[26];
            num = 0;
            end = 0;
            this.var = var;
        }
    }
}
