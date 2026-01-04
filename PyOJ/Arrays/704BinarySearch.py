class Solution:
    def search(self, nums, target) -> int:
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        while right >= left:
            mid = (right - left) // 2 + left
            if nums[mid] > target:
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                return mid
        return -1

if __name__ == '__main__':
    solution = Solution()
    print(solution.search([-1, 0, 3, 5, 9, 12], 9))
    # your test code here
