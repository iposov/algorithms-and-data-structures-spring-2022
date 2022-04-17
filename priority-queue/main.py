
class PriorityQueue:
    def __init__(self):
        self.heapList = []

    def add(self, element):
        self.heapList.append(element)
        i = len(self.heapList) - 1
        parent = int((i - 1) / 2)

        while i > 0 and self.heapList[parent] < self.heapList[i]:

            temp = self.heapList[i]
            self.heapList[i] = self.heapList[parent]
            self.heapList[parent] = temp

            i = parent
            parent = int((i - 1) / 2)

    def heapify(self, i):
        while True:
            left = 2 * i + 1
            right = 2 * (i + 1)
            max_child = i

            if left < len(self.heapList) and self.heapList[left] > self.heapList[max_child]:
                max_child = left

            if right < len(self.heapList) and self.heapList[right] > self.heapList[max_child]:
                max_child = right

            if max_child == i:
                break

            temp = self.heapList[i]
            self.heapList[i] = self.heapList[max_child]
            self.heapList[max_child] = temp

            i = max_child

    def get_max(self):
        result, self.heapList[0] = self.heapList[0], self.heapList[-1]
        del self.heapList[-1]
        return result


if __name__ == '__main__':
    heap = PriorityQueue()

    for _ in range(int(input())):
        action = input()
        if "GET" in action:
            print(heap.get_max())
            heap.heapify(0)
        else:
            heap.add(int(action))