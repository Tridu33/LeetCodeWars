class Solution(object):
    """
    kmp，就是找已遍历过的部分是否有要查找的元素，
    前缀后缀，就是已遍历过的部分的前面是否等于后面，
    next数组，就是统计相等元素的数量
    """
    def build_next(self, patt):
        next = [0] # 初始值
        prefix_len = 0 # 当前共同前后缀长度
        i = 0
        while i < len(patt):
            if patt[prefix_len] == patt[i]:
                prefix_len += 1
                next.append(prefix_len)
                i += 1
            else:
                if prefix_len == 0:
                    next.append(0)
                    i += 1
                else:
                    prefix_len = next[prefix_len - 1]
        return next
        pass

    def kmp(self, string, patt):
        next = self.build_next(patt)

        i = 0
        j = 0
        while i < len(string):
            if string[i] == patt[i]:
                j += 1
                i += 1
            elif j > 0:
                j = next[j-1]
            else:
                i += 1

            if j == len(patt):
                return i-j

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