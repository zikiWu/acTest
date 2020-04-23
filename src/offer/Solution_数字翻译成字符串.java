package offer;

public class Solution_数字翻译成字符串 {
    public static void main(String[] args){
        getTranslationCount(1225825);
    }
    private static int getTranslationCount(int number)
    {
        if (number < 0) return 0; //负数默认可翻译个数为0
        System.out.println(translationCount(String.valueOf(number)));
        System.out.println(translationCount2(String.valueOf(number)));
        return translationCount(String.valueOf(number));
    }
    private static int translationCount2(String number)
    {
        return count(number,0);
    }
    private static int count(String number,int i)
    {
        if (i == number.length()-1 || i == number.length())
            return 1;
        else if(i > number.length()){
            return 0;
        }

        int d = (number.charAt(i)-'0')*10+(number.charAt(i+1)-'0');
        int count = 0;
        if (d>=10 && d<=25){
            count += count(number,i+2);
        }
        count += count(number,i+1);
        return count;
    }

    private static int translationCount(String number)
    {
        int length = number.length();
        int[] countRecords = new int[length];
        //只有一个数字，则只有一种翻译方式
        countRecords[length - 1] = 1;
        int count;
        for (int i = length - 2; i >= 0; i--)
        {
            //f(i+1)
            count = countRecords[i + 1];
            int digit1 = number.charAt(i) - '0';
            int digit2 = number.charAt(i + 1) - '0';
            int connectedNumber = digit1 * 10 + digit2; //拼接两个数字
            //拼接的数字在10~25范围内
            if (connectedNumber >= 10 && connectedNumber <= 25)
            {
                if (i < length - 2)
                {
                    //f(i) = f(i+1) + f(i+2)
                    count += countRecords[i + 2];
                } else if (i == length - 2)
                {
                    count += 1;  //拼接的数字只有一种翻译方式
                }
            }
            countRecords[i] = count;
        }
        count = countRecords[0];
        return count;
    }

}
