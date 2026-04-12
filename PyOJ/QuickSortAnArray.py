import random
import time


class Solution:
    def sortArray(self, nums: list[int]) -> list[int]:
        # 设置随机数种子，对应C++的srand((unsigned)time(NULL))
        random.seed(time.time())
        self.randomized_quicksort(nums, 0, len(nums) - 1)
        return nums

    def partition(self, nums: list[int], l: int, r: int) -> int:
        """核心分区函数：以nums[r]为基准，将数组分为两部分"""
        pivot = nums[r]  # 选取最右侧元素作为主元
        i = l - 1  # i指向小于pivot区域的最后一个元素
        # 遍历l到r-1的元素
        for j in range(l, r):
            if nums[j] < pivot:
                i += 1
                # 交换nums[i]和nums[j]，将小于pivot的元素放到左侧
                nums[i], nums[j] = nums[j], nums[i]
        # 将主元放到正确位置（i+1）
        nums[i + 1], nums[r] = nums[r], nums[i + 1]
        return i + 1  # 返回主元的最终位置

    def randomized_partition(self, nums: list[int], l: int, r: int) -> int:
        """随机化分区：随机选一个元素作为主元，避免最坏情况"""
        # 随机生成[l, r]范围内的索引，对应C++的rand() % (r - l + 1) + l
        idx = random.randint(l, r)
        # 将随机选中的元素交换到最右侧，作为partition的主元
        nums[r], nums[idx] = nums[idx], nums[r]
        return self.partition(nums, l, r)

    def randomized_quicksort(self, nums: list[int], l: int, r: int) -> None:
        """递归执行随机化快速排序"""
        if l < r:  # 递归终止条件：区间长度<=1
            # 获取分区点
            pos = self.randomized_partition(nums, l, r)
            # 递归排序左半部分
            self.randomized_quicksort(nums, l, pos - 1)
            # 递归排序右半部分
            self.randomized_quicksort(nums, pos + 1, r)

class Solution2:
    def sortArray(self, nums: list[int]) -> list[int]:
        self.quick_sort(nums, 0 , len(nums)-1)
        return nums
    def quick_sort(self, nums, l, r):
        if l< r:
            pos = self.partition(nums, l, r)
            self.quick_sort(nums, l, pos-1)
            self.quick_sort(nums, pos+1, r)
    def partition(self, nums, l, r):
        # idx = random.randint(l, r)
        # nums[idx], nums[r] = nums[r], nums[idx]
        pivot = nums[r]
        i = l-1 # i指向小于pivot区域的最后一个元素
        for j in range(l, r):
            if nums[j] < pivot:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        nums[i+1], nums[r] = nums[r], nums[i+1]
        return i+1

# 测试示例
if __name__ == "__main__":
    sol = Solution()
    sol2 = Solution2()
    # 测试用例1：普通乱序数组
    test1 = [5, 2, 3, 1]
    # print(sol.sortArray(test1))  # 输出: [1, 2, 3, 5]
    print(sol2.sortArray(test1))  # 输出: [1, 2, 3, 5]
    # 测试用例2：包含重复元素的数组
    test2 = [5, 1, 1, 2, 0, 0]
    # print(sol.sortArray(test2))  # 输出: [0, 0, 1, 1, 2, 5]
    # 测试用例3：空数组
    test3 = []
    # print(sol.sortArray(test3))  # 输出: []

class Solution2:
    def partition(self, nums, left, right):
        """
        在子数组 [left, right] 中随机选择一个基准元素 pivot
        根据 pivot 重新排列子数组 [left, right]
        重新排列后，<= pivot 的元素都在 pivot 的左侧，>= pivot 的元素都在 pivot 的右侧
        返回 pivot 在重新排列后的 nums 中的下标
        特别地，如果子数组的所有元素都等于 pivot，我们会返回子数组的中心下标，避免退化
        """

        # 1. 在子数组 [left, right] 中随机选择一个基准元素 pivot
        i = random.randint(left, right)
        pivot = nums[i]
        # 把 pivot 与子数组第一个元素交换，避免 pivot 干扰后续划分，从而简化实现逻辑
        nums[i], nums[left] = nums[left], nums[i]

        # 2. 相向双指针遍历子数组 [left + 1, right]
        # 循环不变量：在循环过程中，子数组的数据分布始终如下图
        # [ pivot | <=pivot | 尚未遍历 | >=pivot ]
        #   ^                 ^     ^         ^
        #   left              i     j         right

        i, j = left + 1, right
        while True:
            while i <= j and nums[i] < pivot:
                i += 1
            # 此时 nums[i] >= pivot

            while i <= j and nums[j] > pivot:
                j -= 1
            # 此时 nums[j] <= pivot

            if i >= j:
                break

            # 维持循环不变量
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1

        # 循环结束后
        # [ pivot | <=pivot | >=pivot ]
        #   ^             ^   ^     ^
        #   left          j   i     right

        # 3. 把 pivot 与 nums[j] 交换，完成划分（partition）
        # 为什么与 j 交换？
        # 如果与 i 交换，可能会出现 i = right + 1 的情况，已经下标越界了，无法交换
        # 另一个原因是如果 nums[i] > pivot，交换会导致一个大于 pivot 的数出现在子数组最左边，不是有效划分
        # 与 j 交换，即使 j = left，交换也不会出错
        nums[left], nums[j] = nums[j], nums[left]

        # 交换后
        # [ <=pivot | pivot | >=pivot ]
        #               ^
        #               j

        # 返回 pivot 的下标
        return j

    def sortArray(self, nums):
        # 快速排序子数组 [left, right]
        def quick_sort(left: int, right: int) -> None:
            # 优化：如果子数组已是升序，直接返回
            # 也可以写 if all(nums[i] <= nums[i + 1] for i in range(left, right)): return
            ordered = True
            for i in range(left, right):
                if nums[i] > nums[i + 1]:
                    ordered = False
                    break
            if ordered:
                return

            i = self.partition(nums, left, right)  # 划分子数组
            quick_sort(left, i - 1)   # 排序在 pivot 左侧的元素
            quick_sort(i + 1, right)  # 排序在 pivot 右侧的元素

        quick_sort(0, len(nums) - 1)
        return nums

