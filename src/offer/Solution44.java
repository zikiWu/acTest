package offer;

public class Solution44 {
    public static void main(String[] args){
        new Solution44().ReverseSentence("");
    }
    public String ReverseSentence(String str) {
        if(str == null){ return null;}
        if(str.trim().equals("")){
            return str;
        }
        String[]strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
