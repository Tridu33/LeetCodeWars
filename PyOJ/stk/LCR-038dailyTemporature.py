class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        n = len(temperatures)
        res = [0] * n
        stk = []
        for i in range(n):
            while stk and temperatures[i] > temperatures[stk[-1]]:
                prevIdx = stk.pop()
                res[prevIdx] = (i - prevIdx)
            stk.append(i)
        return res

if __name__ == '__main__':
    solution = Solution()