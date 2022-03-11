
class HeapBin:
    def __init__(self):
        self.heapList = []
        self.heapSize = len(self.heapList)

    def add(self, element):
        self.heapList.append(element)
        self.heapSize += 1
        i = self.heapSize - 1
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
            right = 2 * i + 2
            max_child = i

            if left < self.heapSize and self.heapList[left] > self.heapList[max_child]:
                max_child = left

            if right < self.heapSize and self.heapList[right] > self.heapList[max_child]:
                max_child = right

            if max_child == i:
                break

            temp = self.heapList[i]
            self.heapList[i] = self.heapList[max_child]
            self.heapList[max_child] = temp

            i = max_child

    def get_max(self):
        result = self.heapList[0]
        self.heapList[0] = self.heapList[self.heapSize - 1]
        del self.heapList[self.heapSize - 1]
        self.heapSize -= 1
        return result


N = int(input())

heap = HeapBin()

list_actions = []
for cnt in range(0, N):
    action = input()
    list_actions.append(action)

for action in list_actions:
    if "GET" in action:
        print(heap.get_max())
        heap.heapify(0)
    else:
        heap.add(int(action))
