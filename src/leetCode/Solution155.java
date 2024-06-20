package leetCode;

/**
 * 155. 最小栈
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 *
 * 示例 1:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 104 次
 */
public class Solution155 {
    public static void main(String[] args){

    }
    int[] v;
    int[] min;
    int vRight;
    int mRight;
    int curMin;

    // 维持一般栈和最小值栈，最小栈栈保存一般栈的下标
    public Solution155() {
        v = new int[462];
        min = new int[462];
        vRight = -1;
        mRight = -1;
        curMin = Integer.MAX_VALUE;
    }

    public void push(int val) {
        v[++vRight] = val;
        if (curMin > val){
            curMin = val;
            min[++mRight] = vRight;
        }
    }

    public void pop() {
        if (vRight == min[mRight]){
            mRight --;
            curMin = mRight >=0 ? v[min[mRight]] : Integer.MAX_VALUE;
        }
        vRight --;
    }

    public int top() {
        return v[vRight];
    }

    public int getMin() {
        return curMin;
    }

}
