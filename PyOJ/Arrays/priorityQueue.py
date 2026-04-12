"""
N 只小白鼠，每只鼠头上戴着一顶有颜色的帽子。
现在称出每只白鼠的重量，要求按照白鼠重量从大到小的顺序输出它们头上帽子的颜色。
帽子的颜色用 red，blue 等字符串来表示。
不同的小白鼠可以戴相同颜色的帽子。
白鼠的重量用整数表示。

输入格式
第一行为一个整数 N，表示小白鼠的数目。
下面有 N 行，每行是一只白鼠的信息。第一个为不大于 100 的正整数，表示白鼠的重量；第二个为字符串，表示白鼠的帽子颜色，字符串长度不超过 10 个字符。
注意：白鼠的重量各不相同。

输出格式
按照白鼠的重量从大到小的顺序输出白鼠的帽子颜色。

数据范围
1≤N ≤100
"""

# def main0():
#     class Node:
#         def __init__(self, w, col):
#             self.w = w
#             self.col = col
#
#         def __lt__(self, other):
#             return self.w > other.w  # 按w从大到小排序
#
#     N = int(input())
#     lst = []
#
#     for i in range(N):
#         w, col = input().split()
#         lst.append(Node(int(w), col))
#
#     lst.sort()  # 排序
#
#     for i in range(N):
#         print(lst[i].col)

def main():
    from queue import PriorityQueue

    class Node:
        def __init__(self, w, col):
            self.w = w
            self.col = col

        def __lt__(self, other):
            return self.w > other.w # 大根堆

    q = PriorityQueue()
    n = 3
    inputs = [(30, 'red'),(50, 'blue'),(40, 'green')]
    for i in range(n):
        w, col = inputs[i]
        q.put(Node(w, col))

    while q.qsize():
        print(q.get().col)
        # blue
        # green
        # red

if __name__ == '__main__':
    main()

















