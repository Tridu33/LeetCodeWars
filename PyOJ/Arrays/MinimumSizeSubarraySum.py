
class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        left, right = 0, 0
        sum = 0
        minLen = float('inf')
        for right in range(len(nums)):
            sum += nums[right]
            while sum >= target:
              minLen = min(minLen, right - left + 1)
              sum -= nums[left]
              left += 1
        return 0 if minLen == float('inf') else minLen

if __name__ == '__main__':
    solution = Solution()
    print(solution.minSubArrayLen(11, [1,1,1,1,1,1,1,1]))
