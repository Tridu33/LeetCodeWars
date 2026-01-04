# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        values = []
        stack = [(root, False)] if root else []  # 多加一个参数，False 为默认值，含义见下文

        while stack:
            node, visited = stack.pop()  # 多加一个 visited 参数，使“迭代统一写法”成为一件简单的事

            if visited:  # visited 为 True，表示该节点和两个儿子位次之前已经安排过了，现在可以收割节点了
                values.append(node.val)
                continue

            # visited 当前为 False, 表示初次访问本节点，此次访问的目的是“把自己和两个儿子在栈中安排好位次”
            # 后序遍历是'左右中'，节点自己最先入栈，最后出栈。
            # 同时，设置 visited 为 True，表示下次再访问本节点时，允许收割。
            stack.append((node, True))

            if node.right:
                stack.append((node.right, False))  # 右儿子位置居中

            if node.left:
                stack.append((node.left, False))  # 左儿子最后入栈，最先出栈

        return values

if __name__ == '__main__':
    solution = Solution()