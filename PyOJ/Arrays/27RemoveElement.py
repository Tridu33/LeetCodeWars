class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        slowIdx, fastIdx = 0, 0
        for fastIdx in range(len(nums)):
            if nums[fastIdx] != val:
                nums[slowIdx] = nums[fastIdx]
                slowIdx += 1
        return slowIdx


if __name__ == '__main__':
    solution = Solution()

    # your test code here