# leetcode submit region begin(Prohibit modification and deletion)
import collections


class MonoQueue(object):
    def __init__(self):
        self.queue = collections.deque()  # 初始化成员变量
    def pop(self, value):
        if len(self.queue)!=0 and value == self.queue[0]:
            self.queue.popleft()
    def push(self, value):
        while len(self.queue) != 0 and value > self.queue[-1]:
            self.queue.pop()
        self.queue.append(value)
    def front(self):
        return self.queue[0]


class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        q = MonoQueue()
        res = []
        for i in range(k):
            q.push(nums[i])
        res.append(q.front())
        for i in range(k, len(nums)):
            q.pop(nums[i-k])
            q.push(nums[i])
            res.append(q.front())
        return res


        
# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    solution = Solution()
    # res = solution.maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3)
    res = solution.maxSlidingWindow([2,3,5,1,4,8,9,0], 4)
    res = solution.maxSlidingWindow([1], 1)
    print(res)