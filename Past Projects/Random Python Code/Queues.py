from LinkedList import *
from DoublyLinkedList import *


class QueuePythonList(object):
    def __init__(self):
        self.list = list()

    def size(self):
        return len(self.list)

    def is_empty(self):
        if len(self.list) == 0:
            return True
        else:
            return False

    def enqueue(self, item):
        self.list.append(item)

    def dequeue(self):
        front_item = self.list[0]
        self.list.remove(front_item)
        return front_item


class QueueLinkedList(object):
    def __init__(self):
        self.list = LinkedList()

    def size(self):
        return self.list.size()

    def is_empty(self):
        return self.list.is_empty()

    def enqueue(self, item):
        self.list.append(item)

    def dequeue(self):
        self.list.pop(0)


class QueueDoublyLinkedList(object):
    def __init__(self):
        self.list = DoublyLinkedList()

    def size(self):
        return self.list.size()

    def is_empty(self):
        return self.list.is_empty()

    def enqueue(self, item):
        self.list.append(item)

    def dequeue(self):
        self.list.pop(0)
