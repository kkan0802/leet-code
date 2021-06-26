"""
20. Valid Parentheses
"""
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for i in range(len(s)):
            if (s[i] == '(' or s[i] == '{' or s[i] == '['):
                stack.append(s[i])
            elif s[i] == ')':
                if len(stack)==0:
                    return False
                top = stack.pop()
                if top != '(':
                    return False
            elif s[i] == '}':
                if len(stack)==0:
                    return False
                top = stack.pop()
                if top != '{':
                    return False
            elif s[i] == ']':
                if len(stack)==0:
                    return False
                top = stack.pop()
                if top != '[':
                    return False
        if len(stack) == 0:
            return True
        else:
            return False


"""
155. Min Stack
"""
class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        top = self.stack[-1]
        return top

    def getMin(self) -> int:
        if len(self.stack) == 0 :
            return []
        min=self.stack[0]
        for i in range(1,len(self.stack)):
            if self.stack[i] < min:
                min = self.stack[i]
        return min


"""
21. Merge Two Sorted Lists
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next    

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        newNode = ListNode(0)
        head = newNode
        
        while l1 and l2:
            if l1.val <= l2.val:
                newNode.next=ListNode(l1.val)
                l1=l1.next
                newNode=newNode.next
            else:
                newNode.next=ListNode(l2.val)
                l2=l2.next
                newNode=newNode.next
                
        while l1:
            newNode.next = ListNode(l1.val)
            l1=l1.next
            newNode=newNode.next
        
        while l2:
            newNode.next = ListNode(l2.val)
            l2=l2.next
            newNode=newNode.next
        
        return head.next


"""
206. Reverse Linked List
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        tempList = []
        Ans = ListNode(0)
        curr = Ans
        
        while head:
            tempList.append(head.val)
            head=head.next
        
        tempList.reverse()
        
        for i in tempList:
            Ans.next=ListNode(i)
            Ans = Ans.next
        
        return curr.next
   

"""
234. Palindrome Linked List
"""        
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        list1 = []
        
        while head:
            list1.append(head.val)
            head=head.next
        
        list2 = list(reversed(list1))
        
        
        for i in range(floor(len(list1)/2)):
            if list1[i] != list2[i]:
                return False
        
        return True 


"""
617. Merge Two Binary Trees
"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def mergeTrees(self, root1: TreeNode, root2: TreeNode) -> TreeNode:
        
        Ans = TreeNode()
        
        if root1 is None:
            return root2
        
        if root2 is None:
            return root1
        
        Ans.val = root1.val + root2.val
        Ans.left = self.mergeTrees(root1.left,root2.left)
        Ans.right = self.mergeTrees(root1.right,root2.right)
        
        return Ans


"""
104. Maximum Depth of Binary Tree
"""
class Solution:  
    def maxDepth(self, root: TreeNode) -> int:
        
        if root is None:
            return 0
        
        LDepth = self.maxDepth(root.left)
        RDepth = self.maxDepth(root.right)
        
        if LDepth >= RDepth:
            MaxDepth = LDepth
        else:
            MaxDepth = RDepth
        
        return 1+MaxDepth


"""
160. Intersection of Two Linked Lists
"""
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None:
            return None
        if headB is None:
            return None
        
        lenA=0
        lenB=0
        curA=headA
        curB=headB
        
        while curA:
            lenA +=1
            curA = curA.next
        while curB:
            lenB +=1
            curB = curB.next
        dif = abs(lenA-lenB)
        if lenA>lenB:
            while dif>0:
                headA = headA.next
                dif -= 1
        elif lenB>lenA:
            while dif>0:
                headB = headB.next
                dif -= 1
        
        flg=0
        while headA and headB:
            if headA == headB:
                return headA
            
            if flg%2 == 0:
                headA = headA.next
                flg += 1
            else:
                headB = headB.next
                flg += 1
                
        return None


"""
215. Kth Largest Element in an Array
"""
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        numset = set(nums)
        numdict = {}
        
        for i in numset:
            numdict[i] = nums.count(i)
        
        reversedict = sorted(numdict.items(), reverse = True)
        
        for j in range(len(reversedict)):
            if reversedict[j][1] >= k:
                return reversedict[j][0]
            
            k-= reversedict[j][1]


"""
141. Linked List Cycle
"""
class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        isHad = set()
        while head:
            if head in isHad:
                return True
            isHad.add(head)
            head=head.next
        
        return False


"""
53. Maximum Subarray
"""
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum = float('-inf')
        current_sum = 0
        
        for num in nums:
            if num + current_sum > num:
                current_sum = num + current_sum
            else:
                current_sum = num
            
            if current_sum > max_sum:
                max_sum = current_sum
        
        return max_sum
