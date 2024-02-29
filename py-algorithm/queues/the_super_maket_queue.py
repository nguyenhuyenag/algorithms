import unittest
import heapq
from queue import PriorityQueue

"""
    https://www.codewars.com/kata/57b06f90e298a7b53d000a86/
    
    Cho mảng số nguyên chứa n khách hàng và các giá trị đại diện cho thời
    gian để hoàn thành thanh toán. Số nguyên k đại diện cho số quầy thành
    toán. Tìm thời gian ít nhất cần có để tất cả các khách hàng thành toán xong
    
        queueTime([5,3,4], 1) = 12    -> Vì chỉ có 1 quầy nên 5 + 3 + 4 = 12
    
        queueTime([10,2,3,3], 2) = 10 -> Người thứ nhất ở quầy 1, ba người còn lại ở quầy 2 
                                         nên chỉ cần 10 phút
"""
class Solution(unittest.TestCase):

    def find_min_index(self, arr):
        min_index = 0
        for i, v in enumerate(arr):
            if v < arr[min_index]:
                min_index = i
        return min_index

    def queue_time_1(self, customers, n):
        queue = [0] * n
        for time in customers:
            min_index = self.find_min_index(queue)
            queue[min_index] += time
        return max(queue)

    def queue_time_2(self, customers, n):
        queue = PriorityQueue()

        for i in range(n):
            queue.put(0)

        for time in customers:
            min_time = queue.get()
            queue.put(min_time + time)

        max_time = 0
        while not queue.empty():
            max_time = max(max_time, queue.get())

        return max_time

    def queue_time(self, customers, n):
        queue = [0] * n
        heapq.heapify(queue)
        for time in customers:
            heapq.heapreplace(queue, queue[0] + time)

        return max(queue)

    def test(self):
        self.assertEqual(12, self.queue_time([5, 3, 4], 1))
        self.assertEqual(10, self.queue_time([10, 2, 3, 3], 2))


if __name__ == '__main__':
    unittest.main()
