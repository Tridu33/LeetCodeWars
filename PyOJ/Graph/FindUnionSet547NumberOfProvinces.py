#两道姊妹题695.岛屿的最大面积、200.岛屿数量
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findCircleNum(self, isConnected):
        n = len(isConnected)
        ### 传说江湖中有各种门派 ###
        # 初始化 数组中存放每个城市i的上一级节点
        pre = [-1] * n

        ### 打架之前先自报家门 ###
        # 找每个省份的省会
        def find(root):
            son = root
            ### 我不认识掌门啊 让我师傅去问问？ ###
            # 让root一直向上查找直到找到省会
            while pre[root] >= 0:
                root = pre[root]

            ### 当徒孙多没意思 直接拜倒掌门门下 辈分高 有牌面儿 ###
            # 路径压缩
            while son != root:
                # 让查找路径上的所有城市都直接连到省会
                tmp = pre[son]
                pre[son] = root
                son = tmp

            ### 说出我家掌门 吓你一跳 ###
            return root

        ### 弱肉强食 小门派终究还是要被大门派兼并 ###
        # 按秩归并 pre数组存放的是下面连接的城市数量
        def union(root1, root2):
            if pre[root2] < pre[root1]:
                pre[root2] += pre[root1]
                pre[root1] = root2
            else:
                pre[root1] += pre[root2]
                pre[root2] = root1

        # 因为是对称的 只需要遍历右上区域
        for i in range(n):
            for j in range(i + 1, n):
                if isConnected[i][j] == 1:
                    ### 我师从名门 识相的就快点投降 ###
                    # 找到i和j的省会
                    root1 = find(i)
                    root2 = find(j)
                    ### 江湖规矩 我们不打自家人 ###
                    # 如果i和j不在一个省但是彼此相连 将他们连到同一个省会
                    if root1 != root2:
                        union(root1, root2)

        ### 腥风血雨过后门派所剩无几 这就是"江湖" ###
        # 统计省会个数
        cnt = 0
        for i in range(n):
            if pre[i] < 0:
                cnt += 1
        return cnt


# leetcode submit region end(Prohibit modification and deletion)


if __name__ == '__main__':
    solution = Solution()
    isConnected = [[1,0,0],[0,1,0],[0,0,1]]
    solution.findCircleNum(isConnected)