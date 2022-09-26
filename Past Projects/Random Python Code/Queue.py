"""
Johnathan Smith

2/23/2021

To make a queue class that was accessible through different functions
"""


class Queue:
    def __init__(self):
        self.queue = []

    def is_empty(self):
        if len(self.queue) == 0:
            return True
        else:
            return False

    def enqueue(self, item):
        self.queue.append(item)

    def size(self):
        return len(self.queue)

    def dequeue(self):
        front_item = self.queue[0]
        self.queue.remove(front_item)
        return front_item
