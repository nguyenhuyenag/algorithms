import unittest
from typing import Optional

import linked.list_node
from linked.list_node import ListNode

"""
    https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
"""


class Solution(unittest.TestCase):

    def getDecimalValue(self, head: Optional[ListNode]) -> int:
        result = 0
        while head:
            result = (result << 1) | head.val
            head = head.next
        return result

    def test_1(self):
        head = linked.list_node.ListNode.build_linked_list([1, 0, 1])
        self.assertEqual(self.getDecimalValue(head), 5)

    def test_2(self):
        head = linked.list_node.ListNode.build_linked_list([0])
        self.assertEqual(self.getDecimalValue(head), 0)

    def test_3(self):
        head = linked.list_node.ListNode.build_linked_list([1, 1, 1, 1])
        self.assertEqual(self.getDecimalValue(head), 15)


if __name__ == '__main__':
    unittest.main()
