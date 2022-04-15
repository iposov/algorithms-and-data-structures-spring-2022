class Node:
   def __init__(self, data):
      self.left = None
      self.right = None
      self.data = data

   def insert(self, data):
# Compare the new value with the parent node
      if self.data:
         if data < self.data:
            if self.left is None:
                print('-')
                self.left = Node(data)
            else:
                self.left.insert(data)
         elif data > self.data:
            if self.right is None:
                print('-')
                self.right = Node(data)
            else:
                self.right.insert(data)
         else:
            print('+')
            self.data = data

# Print the tree
   def PrintTree(self):
      if self.left:
         self.left.PrintTree()
      print( self.data),
      if self.right:
         self.right.PrintTree()

# Use the insert method to add nodes
print('-')
data = []
with open("1.in") as f:
    for line in f:
        data.append(line)
n = int(data[0])
root = Node(data[1])
for i in range(2, n+1):
    root.insert(data[i])
