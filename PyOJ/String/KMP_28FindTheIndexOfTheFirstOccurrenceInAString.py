class Solution(object):
    """
    kmp，就是找已遍历过的部分是否有要查找的元素，
    前缀后缀，就是已遍历过的部分的前面是否等于后面，
    next数组，就是统计相等元素的数量
    """
    def strStr(self, haystack, needle):
        n = len(haystack)
        m = len(needle)

        # 如果模式串为空，直接返回0
        if m == 0:
            return 0

        # 构建部分匹配表（pi数组）
        pi = [0] * m
        j = 0  # j表示当前匹配的长度
        for i in range(1, m):
            # 回退到上一个可能的匹配位置
            while j > 0 and needle[i] != needle[j]:
                j = pi[j - 1]
            # 如果匹配，j向前移动
            if needle[i] == needle[j]:
                j += 1
            pi[i] = j

        # KMP主匹配过程
        j = 0
        for i in range(n):
            # 回退到部分匹配的位置
            while j > 0 and haystack[i] != needle[j]:
                j = pi[j - 1]
            # 如果当前字符匹配，j向前移动
            if haystack[i] == needle[j]:
                j += 1
            # 如果完全匹配，返回起始索引
            if j == m:
                return i - m + 1

        # 没有找到匹配，返回-1
        return -1


if __name__ == '__main__':
    solution = Solution()
    # # 测试用例1：基础匹配
    # print(solution.strStr("hello", "ll"))  # 输出: 2
    # # 测试用例2：无匹配
    # print(solution.strStr("aaaaa", "bba"))  # 输出: -1
    # # 测试用例3：模式串为空
    # print(solution.strStr("abc", ""))  # 输出: 0