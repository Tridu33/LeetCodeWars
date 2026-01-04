# Definition for a binary tree node.
import collections
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        level = 0
        if not root:
            return []
        res = []
        queue = collections.deque()
        queue.append(root)
        while len(queue) > 0:
            curLevel = []
            size = len(queue)
            while size > 0: # for _ in range(size):
                cur = queue.popleft()
                curLevel.append(cur.val)
                if cur.left is not None:
                    queue.append(cur.left)
                if cur.right is not None:
                    queue.append(cur.right)
                size -= 1
            res.append(curLevel)
        return res

if __name__ == '__main__':
    solution = Solution()
    root = TreeNode(1)
    array = solution.levelOrder(root)
    import numpy as np
    arr = np.array(array)
    print(arr)