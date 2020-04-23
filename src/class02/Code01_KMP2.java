package class02;

public class Code01_KMP2 {

	//kmp算法
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = m.toCharArray();
		int i1 = 0;
		int i2 = 0;
		int[] next = getNextArray(str2);
		while (i1<str1.length && i2<str2.length){
			if(str1[i1]==str2[i2]){
				i1++;
				i2++;
			}
			else if(i2 == 0){
				i1++;
			}else {
				//当i2 == 0 时，会先进行比较等值，即条件1，不相等就说明之前的字符串全部不等，直接i1+1,进行新的比较
				i2 = next[i2];
			}
		}
		if(i2==str2.length){
			return i1-i2;
		}
		return 0;
	}

	//计算当前字符前面对应的数量
	public static int[] getNextArray(char[] ms) {
		if(ms.length<2){
			return new int[]{-1};
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int cn = 0;
		int i = 2;
		while(i<ms.length){
			if(ms[i-1]==ms[cn]){
				next[i] = cn+1;
				i++;
				cn++;
			}else if(cn > 0){
				cn = next[cn];
			}else {
				next[i] = 0;
				i++;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "cababa";
		System.out.println(getIndexOf(str, match));

	}

}
