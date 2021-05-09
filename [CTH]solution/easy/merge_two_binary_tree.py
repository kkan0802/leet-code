import TreeNode


class Solution:
    @staticmethod
    def merge_trees(root1: TreeNode, root2: TreeNode) -> TreeNode:
        if not root1:
            return root2
        if not root2:
            return root1
        t = TreeNode(root1.val + root2.val)
        t.left = TreeNode(root1.left, root2.left)
        t.right = TreeNode(root2.right, root2.right)
        return t


if __name__ == '__main__':
    pass
