import TreeNode


class Solution:
    @staticmethod
    def is_symmetric(root: TreeNode) -> bool:
        return is_symmetric_equal(root.left, root.right)


def is_symmetric_equal(node1: TreeNode, node2: TreeNode) -> bool:
    if node1 is None and node2 is None:
        return True
    if node1 is not None and node2 is None:
        return False
    if node1 is None and node2 is not None:
        return False
    if node1.val != node2.val:
        return False
    if not is_symmetric_equal(node1.left, node2.right):
        return False
    if not is_symmetric_equal(node1.right, node2.left):
        return False
    return True


if __name__ == '__main__':
    pass
