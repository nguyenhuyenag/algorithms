import heapq

heap = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
heapq.heapify(heap)
i = 0
while heap:
    print(heap[0])
    i += 1
    if i == len(heap):
        break
