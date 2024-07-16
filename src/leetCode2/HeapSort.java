package leetCode2;

import java.util.Arrays;

public class HeapSort {
    /**
     * 从小到大进行堆排序
     *
     * @param source
     */
    public static void sort(int[] source) {
//步骤一：构建堆，数组下标0不存储数据
        int[] heap = new int[source.length + 1];
//根据待排序数组，构造一个无序的堆
        System.arraycopy(source, 0, heap, 1, source.length);
//对堆中的元素做下沉调整，从长度的一半处开始，往堆顶索引1处扫描)
//二叉堆特性：数组索引一半后的都是叶子节点，不需要做下沉，一半前都是非叶子节点，才需要做
        for (int i = (heap.length) / 2; i > 0; i--) {
            down(heap, i, heap.length - 1);
        }
        System.out.println("大顶堆：" + Arrays.toString(heap));
// 步骤二：堆排序，把堆顶元素和数组最后一个索引元素交换；然后再堆化，然后堆顶又是最大元素，再和数组倒数第二索引处交换；持续进行直到最后
// 类似删除操作，只需要下沉操作重新堆化即可
//记录未排序的元素中最大的索引
        int maxUnSortIndex = heap.length - 1;
//通过循环，交换堆顶元素和最大未排序元素的下标
        while (maxUnSortIndex != 1) {
//交换元素
            swap(heap, 1, maxUnSortIndex);
//排序后最大元素所在的索引，不要参与堆的下沉，所以 递减1
            maxUnSortIndex--;
//继续对堆顶处的元素进行下沉调整
            down(heap, 1, maxUnSortIndex);
        }
//把heap中的数据复制到原数组source中
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    /**
     * 比较大小,item[left] 元素是否小于 item[right]的元素
     */
    private static boolean rightBig(int[] heap, int left, int right) {
        return heap[left] < heap[right];
    }

    /**
     * 交互堆中两个元素的位置
     */
    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 使用下沉操作，堆顶和最后一个元素交换后，重新堆化
     * 不断比较 节点 arr[k]和对应 左节点arr[2*k] 和 右节点arr[2*k+1]的大小，如果当前结点
     * 小，则需要交换位置
     * 直到找到 最后一个索引节点比较完成 则结束
     * <p>
     * 数组中下标为 k 的节点
     * 左子节点下标为 2*k 的节点
     * 右子节点就是下标 为 2*k+1 的节点
     * 父节点就是下标为 k/2 取整的节点
     */
    private static void down(int[] heap, int k, int range) {
// 最后一个节点的下标是range，即元素总个数
        while (2 * k <= range) {
//记录当前节点的左右子节点，较大的节点
            int maxIndex;
            if (2 * k + 1 <= range) {
                if (rightBig(heap, 2 * k, 2 * k + 1)) {
                    maxIndex = 2 * k + 1;
                } else {
                    maxIndex = 2 * k;
                }
            } else {
                maxIndex = 2 * k;
            }
//比较当前节点和较大接的值，如果当前节点大则结束
            if (heap[k] > heap[maxIndex]) {
                break;
            } else {
//否则往下一层比较，当前节点的k变为子节点中较大的值
                swap(heap, k, maxIndex);
                k = maxIndex;
            }
        }
    }
}