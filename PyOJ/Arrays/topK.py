class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        def sift_down(arr, root, k):
            """下沉log(k),如果新的根节点>子节点就一直下沉"""
            val = arr[root] # 用类似插入排序的赋值交换
            while root<<1 < k:
                child = root << 1
                # 选取左右孩子中小的与父节点交换
                if child|1 < k and arr[child|1][1] < arr[child][1]:
                    child |= 1
                # 如果子节点<新节点,交换,如果已经有序break
                if arr[child][1] < val[1]:
                    arr[root] = arr[child]
                    root = child
                else:
                    break
            arr[root] = val

        def sift_up(arr, child):
            """上浮log(k),如果新加入的节点<父节点就一直上浮"""
            val = arr[child]
            while child>>1 > 0 and val[1] < arr[child>>1][1]:
                arr[child] = arr[child>>1]
                child >>= 1
            arr[child] = val

        import collections
        stat = collections.Counter(nums)
        stat = list(stat.items())
        heap = [(0,0)]

        # 构建规模为k+1的堆,新元素加入堆尾,上浮
        for i in range(k):
            heap.append(stat[i])
            sift_up(heap, len(heap)-1)
        # 维护规模为k+1的堆,如果新元素大于堆顶,入堆,并下沉
        for i in range(k, len(stat)):
            if stat[i][1] > heap[1][1]:
                heap[1] = stat[i]
                sift_down(heap, 1, k+1)
        return [item[0] for item in heap[1:]]


class Solution2:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        # 第一步：统计每个数字出现的频率
        freq_map = {}
        for num in nums:
            # 等价于Java的map.getOrDefault(num, 0) + 1
            freq_map[num] = freq_map.get(num, 0) + 1

        # 第二步：使用堆（Python的heapq默认是小顶堆，需转换为大顶堆）
        # 方式：存入负的频率，模拟大顶堆的效果
        heap = []
        for num, count in freq_map.items():
            # 堆中存储 (-频率, 数字)，保证频率高的先被弹出
            heapq.heappush(heap, (-count, num))

        # 第三步：提取前k个高频元素
        result = []
        for _ in range(k):
            # 弹出堆顶元素（负频率对应的原数字）
            result.append(heapq.heappop(heap)[1])

        return result


# 测试示例（可选）
if __name__ == "__main__":
    sol = Solution2()
    # 测试用例1
    print(sol.topKFrequent([1, 1, 1, 2, 2, 3], 2))  # 输出: [1,2]
    # 测试用例2
    print(sol.topKFrequent([1], 1))  # 输出: [1]


    import heapq

    # [2,0,4,1]

    # 1.创建堆
    # 方法一：定义一个空列表，然后使用heapq.heqppush(item)函数把元素加入到堆中
    item = 2
    heap = []
    heapq.heappush(heap, item)
    # 方法二：使用heapq.heapify(list)将列表转换为堆结构
    heap = [2, 0, 4, 1]
    heapq.heapify(heap)

    # 2.heapq.heappush() 添加新元素 num
    num = 3
    heapq.heappush(heap, num)

    # 3.heapq.heappop() 删除并返回堆顶元素
    heapq.heappop(heap)

    # 4.heapq.heappushpop() 比较添加元素num与堆顶元素的大小:如果num>堆顶元素，删除并返回堆顶元素，然后添加新元素num;如果num<堆顶元素，返回num，原堆不变
    # 其实也就等价于 添加新元素num，然后删除并返回堆顶元素
    num = 0
    heapq.heappushpop(heap, num)

    # 5.heapq.heapreplace() 删除并返回堆顶元素，然后添加新元素num
    num = 5
    heapq.heapreplace(heap, num)

    # 6. heapq.merge() 合并多个排序后的序列成一个排序后的序列， 返回排序后的值的迭代器。
    heap1 = [1, 3, 5, 7]
    heap2 = [2, 4, 6, 8]
    heap = heapq.merge(heap1, heap2)
    print(list(heap))

    # 7.heapq.nsmallest() 查询堆中的最小n个元素
    n = 3
    heap = [1, 3, 5, 7, 2, 4, 6, 8]
    print(heapq.nsmallest(n, heap))  # [1,2,3]

    # 8.heapq.nlargest() 查询堆中的最大n个元素
    n = 3
    heap = [1, 3, 5, 7, 2, 4, 6, 8]
    print(heapq.nlargest(n, heap))  # [8,7,6]