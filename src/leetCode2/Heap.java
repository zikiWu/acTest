package leetCode2;

public class Heap {
    //用数组存储堆中的元素
    private int[] items;
    //堆中元素的个数
    private int num;

    public Heap(int capacity) {
//数组下标0不存储数据，所以容量+1
        this.items = new int[capacity + 1];
        this.num = 0;
    }

    /**
     * 判断堆中 items[left] 元素是否小于 items[right] 的元素
     */
    private boolean rightBig(int left, int right) {
        return items[left] < items[right];
    }

    /**
     * 交换堆中的两个元素位置
     */
    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 往堆中插入一个元素，默认是最后面，++num先执行，然后进行上浮判断操作
     */
    public void insert(int value) {
        items[++num] = value;
        up(num);
    }

    /**
     * 使用上浮操作，新增元素后，重新堆化
     * 不断比较新节点 arr[k]和对应父节点arr[k/2]的大小，根据情况交互元素位置
     * 直到找到的父节点比当前新增节点大则结束
     * <p>
     * 数组中下标为 k 的节点
     * 左子节点下标为 2*k 的节点
     * 右子节点就是下标 为 2*k+1 的节点
     * 父节点就是下标为 k/2 取整的节点
     */
    private void up(int k) {
//父节点 在数组的下标是1，下标大于1都要比较
        while (k > 1) {
//比较 父结点 和 当前结点 大小
            if (rightBig(k / 2, k)) {
//当前节点大，则和父节点交互位置
                swap(k / 2, k);
            }
// 往上一层比较，当前节点变为父节点
            k = k / 2;
        }
    }

    /**
     * 删除堆中最大的元素,返回这个最大元素
     */
    public int delMax() {
        int max = items[1];
//交换索引 堆顶的元素（数组索引1的）和 最大索引处的元素，放到完全二叉树中最右侧的元素，方便后续变为临时根结点
// 为啥不能直接删除顶部元素，因为删除后会断裂，成为森林，所以需要先交互，再删除
        swap(1, num);
//最大索引处的元素删除掉, num--是后执行，元素个数需要减少1
        items[num--] = 0;
//通过下浮调整堆，重新堆化
        down(1);
        return max;
    }

    /**
     * 使用下沉操作，堆顶和最后一个元素交换后，重新堆化
     * 不断比较 节点 arr[k]和对应 左节点arr[2*k] 和 右节点arr[2*k+1]的大小，如果当前结点
     * 小，则需要交换位置
     * 直到找到 最后一个索引节点比较完成 则结束
     * 数组中下标为 k 的节点
     * 左子节点下标为 2*k 的节点
     * 右子节点就是下标 为 2*k+1 的节点
     * 父节点就是下标为 k/2 取整的节点
     */
    private void down(int k) {
        //最后一个节点下标是num
        while (2 * k <= num) {
//记录当前结点的左右子结点中，较大的结点
            int maxIndex;
            if (2 * k + 1 <= num) { //2 * k + 1 <= num 是判断 确保有右节点
//比较当前结点下的左右子节点哪个大
                if (rightBig(2 * k, 2 * k + 1)) {
                    maxIndex = 2 * k + 1;
                } else {
                    maxIndex = 2 * k;
                }
            } else {
                maxIndex = 2 * k;
            }
//比较当前结点 和 较大结点的值, 如果当前节点较大则结束
            if (items[k] > items[maxIndex]) {
                break;
            } else {
//否则往下一层比较，当前节点k索引 变换为 子节点中较大的值
                swap(k, maxIndex);
//变换k的值
                k = maxIndex;
            }
        }
    }
}