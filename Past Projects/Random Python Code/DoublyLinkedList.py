"""
Johnathan Smith

3/19/2021

To make a Doubly Linked List structure.
"""


class Node(object):
    """Creates Node class and variables that go with it. """
    def __init__(self, data):
        self.data = data
        self.next = None
        self.previous = None

    def __str__(self):
        """how the Node class represents its info"""
        return str(self.data)


class DoublyLinkedList(object):
    """Creates the DoublyLinkedList class and variables that go with it"""
    def __init__(self):
        self.head = None
        self.next = None
        self.tail = None
        self.length = 0

    def is_empty(self):
        """Test to see if List is empty"""
        if self.head is None:
            return True
        else:
            return False

    def size(self):
        """returns the total length of the list"""
        return self.length

    def add(self, item):
        """Adds a node to the front of the list"""
        newNode = Node(item)
        if self.head is None:  # if List is empty
            self.head = newNode         # assigns every element in regards to the list with the new nodes variables b/c
            self.next = newNode.next    # the list was originally empty and replaced now with the new node
            self.tail = newNode
            self.length += 1  # increases the length of the list by 1
        else:  # When list is anything other than empty
            self.head.previous = newNode  # current head values previous value becomes the new node
            newNode.next = self.head  # New nodes next values becomes the head value
            self.head = newNode  # the head value becomes the new node
            self.length += 1  # increases the length of the list by 1

    def __iter__(self):
        """used to be able to iterate through the List"""
        current = self.head
        while current is not None:
            yield current
            current = current.next

    def append(self, item):
        """adds item to the end of the list"""
        newNode = Node(item)
        if self.head is None:  # if list is empty
            self.head = newNode         # assigns every element in regards to the list with the new nodes variables b/c
            self.next = newNode.next    # the list was originally empty and replaced now with the new node
            self.tail = newNode
            self.length += 1  # increases the length of the list by 1
        else:  # When list is anything other than empty
            self.tail.next = newNode
            newNode.previous = self.tail
            self.tail = newNode
            self.length += 1

            #Version was very slow
            #counter = 1  # Counts thought iterations
            #for node in self:  # iterates through list giving a node every time it iterates
                #if counter == self.length:  # When iteration number is the last one in the list(Length of list)
                    #newNode.previous = node  # New nodes previous value becomes old end node
                    #node.next = newNode  # old end nodes next value becomes the new node
                    #self.tail = newNode  # Tail of list becomes the new node
                    #self.length += 1  # increases the length of the list by 1
                #else:
                   # counter += 1  # increases the length of the list by 1

    def pop(self, pos=-1):
        """Removes last node from list or whichever one from a position if position is given by user"""
        if self.length == 0 or (pos != -1 and pos not in range(self.length)):  # If list is empty
            return  # return nothing and dont proceed through function
        elif pos == -1:  # if used didn't put in a position but list still has items
            counter = 1  # Counts through iterations
            for node in self:  # iterates through list giving a node every time it iterates
                if counter == self.length:  # When iteration number is the last one in the list(Length of list)
                    data = node  # placeholder to hold the node so able to return it after it has been deleted from list
                    node = None  # assigns node to none to delete it from list.
                    self.length -= 1  # decreases the length of the list by 1
                    if self.length == 0:  # If list is empty
                        self.head = None  # Head of lists becomes none
                    return data  # return data variable to know what was deleted
                else:  # if iteration is not equal to length
                    counter += 1  # increase iteration counter
        else:  # When position is given
            for index, node in enumerate(self):  # iterates through list giving node and spot in list(index)
                if pos == 0:  # If position wanted to delete is the first
                    data = node  # placeholder to hold the node so able to return it after it has been deleted from list
                    self.head.previous = None
                    self.head = node.next  # Head of list becomes node after the first node in list
                    #self.head.previous = None  # The new head of list previous value gets changed to none
                    #Caused problems with router, fixed when taken out
                    self.length -= 1  # decreases the length of the list by 1
                    return data  # return data variable to know what was deleted
                if pos == self.length - 1 and index == pos - 1:  # When position is one less than the length(position follows index format) and spot in list(index) is equal to position minus 1 (position 1 == spot in list(index) 0)
                    data = node.next  # placeholder to hold the node so able to return it after it has been deleted from list
                    node.next = None  # deletes the next value of node(the node at the end of the list)
                    self.length -= 1  # decreases the length of the list by 1
                    return data  # return data variable to know what was deleted
                if index == pos - 1:  # When position is not the first or the last of the list(stops at iteration before node you want to delete giving you the node before it)
                    for s_index, s_node in enumerate(self):  # iterates through list once again to get the actualy node you want to delete(s_index, s_node == second_index, second_node)
                        if s_index == pos:  # When iteration is on the node in the position given
                            data = node.next  # placeholder to hold the node so able to return it after it has been deleted from list
                            s_node.next.previous = node  # assigns the previous value of the node after you the one you want to delete to the node before the one you want to delete
                            node.next = s_node.next  # assigns the next value of the node before the one you want to delete to the node after the on you want to delete
                            self.length -= 1  # decreases the length of the list by 1
                            return data  # return data variable to know what was deleted

    def search(self, item):
        """Finds item in list and returns True if in list and false if not in the list"""
        count = 0  # Counts through iterations
        if self.length == 0:  # If list is empty
            return  # return nothing and dont proceed through function
        for index, node in enumerate(self):   # iterates through list giving node and spot in list(index)
            if str(node) == item:  # if during this current iteration the node is equal to the item it returns True
                return True
            else:  # increases count of iterations gone through
                count += 1
            if count == self.length:  # when count is equal to the length of list(reached the end of the list)
                return False  # return False

    def remove(self, item):
        """Removes an item from the list using its node name"""
        if self.length == 0:  # If list is empty
            return  # return nothing and dont proceed through function
        for index2, node2 in enumerate(self):  # iterates through the list (using index2, node2 b/c index, node used later)
            if str(node2) == item:  # when the iteration reaches the value that equals the one wanted to be removed
                pos = index2  # assigns position with the index value of the value wanted to delete (proceeds to use that in the same way as the pop() function)
                if pos == -1:  # if used didn't put in a position but list still has items
                    counter = 1  # Counts through iterations
                    for node in self:  # iterates through list giving a node every time it iterates
                        if counter == self.length:  # When iteration number is the last one in the list(Length of list)
                            node = None  # assigns node to none to delete it from list.
                            self.length -= 1  # decreases the length of the list by 1
                            if self.length == 0:  # If list is empty
                                self.head = None  # Head of lists becomes none
                            return  # returns nothing
                        else:  # if iteration is not equal to length
                            counter += 1  # increase iteration counter
                else:  # When position is given
                    for index, node in enumerate(self):  # iterates through list giving node and spot in list(index)
                        if pos == 0:  # If position wanted to delete is the first
                            self.head = node.next  # Head of list becomes node after the first node in list
                            self.head.previous = None  # The new head of list previous value gets changed to none
                            self.length -= 1  # decreases the length of the list by 1
                            return  # returns nothing
                        if pos == self.length - 1 and index == pos - 1:  # When position is one less than the length(position follows index format) and spot in list(index) is equal to position minus 1 (position 1 == spot in list(index) 0)
                            node.next = None  # deletes the next value of node(the node at the end of the list)
                            self.length -= 1  # decreases the length of the list by 1
                            return  # returns nothing
                        if index == pos - 1:  # When position is not the first or the last of the list(stops at iteration before node you want to delete giving you the node before it)
                            for s_index, s_node in enumerate(self):  # iterates through list once again to get the actualy node you want to delete(s_index, s_node == second_index, second_node)
                                if s_index == pos:  # When iteration is on the node in the position given
                                    s_node.next.previous = node  # assigns the previous value of the node after you the one you want to delete to the node before the one you want to delete
                                    node.next = s_node.next  # assigns the next value of the node before the one you want to delete to the node after the on you want to delete
                                    self.length -= 1  # decreases the length of the list by 1
                                    return  # returns nothing
"""Does not work"""
#
#    def reverse(self):
#        count = -1
#        for index, node in enumerate(self):
#            count += 1
#            for index2, node2 in enumerate(self):
#                print(node, node2)
#                if index2 == self.length - (1+count):
#                    node, node2 = node2, node
#        return self
#




