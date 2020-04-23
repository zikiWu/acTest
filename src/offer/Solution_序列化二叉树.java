package offer;

public class Solution_序列化二叉树 {
    public static void main(String[] args){

    }
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Slize(root,sb);
        return sb.toString();
    }

    void Slize(TreeNode root,StringBuilder sb) {
        if(root == null){
            sb.append("#!");
            return;
        }
        sb.append(root.val).append("!");
        Slize(root.left, sb);
        Slize(root.right, sb);
    }
    TreeNode Deserialize(String str) {
        String[] strs =  str.split("!");
        return Dlize(strs);
    }
    int index = 0;
    TreeNode Dlize(String[] strs) {
        String s = strs[index];
        index++;
        if(!s.equals("#")){
            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = Dlize(strs);
            root.right = Dlize(strs);
            return root;
        }
        return null;
    }
}
