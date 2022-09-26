"""
Johnathan Smith

2/23/2021

To make a dequeue class that was accessible through different functions
"""


class Deque:
    def __init__(self):
        self.deque = []

    def is_empty(self):
        if len(self.deque) == 0:
            return True
        else:
            return False

    def add_rear(self, item):
        self.deque.append(item)

    def remove_rear(self):
        return self.deque.pop(len(self.deque) - 1)

    def add_front(self, item):
        self.deque.insert(0, item)

    def remove_front(self):
        front_item = self.deque[0]
        self.deque.remove(front_item)
        return front_item

    def size(self):
        return len(self.deque)
