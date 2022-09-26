"""
Johnathan Smith

2/23/2021

To make a stack class that was accessible through different functions
"""


class Stack:
    def __init__(self):
        self.stack = []

    def is_empty(self):
        if len(self.stack) == 0:
            return True
        else:
            return False

    def push(self, item):
        self.stack.append(item)

    def size(self):
        return len(self.stack)

    def peek(self):
        return self.stack[len(self.stack)-1]

    def pop(self):
        return self.stack.pop(len(self.stack) - 1)
