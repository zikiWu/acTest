package class02;


public class Code02_Manacher2 {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	//最长回文串，len数组记录当前位置的回文字子串的长度
	public static String maxLcpsLength(String str) {
		if(str.length()<1){
			return "";
		}
		if(str.length()<2){
			return str;
		}
		char[] arr = manacherString(str);
		int R = -1; //记录当前最长的字串位置的下一个点的位置
		int c = -1; //记录当前最长的字串的中点
		int[] len = new int[arr.length];
		int max = 0;
		int maxI = 0;
		for (int i = 0;i<arr.length;i++){
			len[i] = R>i?Math.min(len[2*c-i],R-i):1;
			while (i+len[i]<arr.length && i-len[i]>-1){
				if(arr[i+len[i]] == arr[i-len[i]]){
					len[i]++;
				}else {
					break;
				}
			}
			if(i+len[i]>R){
				R = i+len[i];
				c = i;
				if(len[i]>max){
					max = len[i];
					maxI = i;
				}
			}
		}
		System.out.println(max-1);
		String result = "";
 		for (int j = maxI -max+1;j<maxI+max;j++){
			result+=arr[j];
		}
		return result.replace("#","");
	}

	public static void main(String[] args) {
		String str1 = "cbbcdd";
		System.out.println(maxLcpsLength(str1));
	}

}
