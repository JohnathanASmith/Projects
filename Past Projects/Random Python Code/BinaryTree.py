"""
Johnathan Smith

4/25/2021

Take Home Assignment 2. Make a Binary tree and display it's functions.
"""


class BinaryNode:
    def __init__(self, data):
        """
        Initialization of the node being made
        :param data:
        """
        self.data = data
        self.left = None
        self.right = None

    def __str__(self):
        """
        How the node is displayed to the user
        :return node information in string format:
        """
        return str(self.data)


class BinaryTree:
    def __init__(self):
        """
        Initialization of the tree object
        """
        self.root = None
        self.length = 0
        self.height = 0

    def is_empty(self):
        """
        Function to check if the tree is empty
        :return True or False depending if empty or not:
        """
        if self.root is None:  # if root is None. Meaning empty tree
            return True
        else:
            return False

    def max_height(self):
        """
        function to give the all time max height of the tree
        :return max height of tree:
        """
        return self.height

    def insert(self, item):
        """
        Main insert function that is called when trying tio add a node to the tree
        :param item:
        :return nothing:
        """
        if self.root is None:  # if tree is empty adds the starting root
            self.root = BinaryNode(item)
            self.length += 1  # increase length variable
        else:
            level = 0  # place holder to hold what level currently on. How deep in the tree.
            self._insert(item, self.root, level)  # calls helper function with level passed through

    def _insert(self, item, node, level):
        """
        Helper function that is used in the insert function to add a node to the tree
        :param item:
        :param node:
        :param level:
        :return nothing:
        """
        if item < node.data:  # left of node
            level += 1  # increments the level currently on
            if node.left is not None:
                self._insert(item, node.left, level)  # When left child isn't empty
            else:
                node.left = BinaryNode(item)  # updates left child as new node
                self.length += 1  # increment length
                if level > self.height:  # if current level node added is higher then current max update it.
                    self.height = level
        else:  # else right node
            level += 1  # increments level currently on
            if node.right is not None:
                self._insert(item, node.right, level)  # When right child isn't empty
            else:
                node.right = BinaryNode(item)  # updates right child as new node
                self.length += 1  # increment length
            if level > self.height:  # if current level node added is higher then current max update it.
                self.height = level

    def delete(self, item, root=None):
        """
        Function used to delete a node in the binary tree
        :param self:
        :param item:
        :param root:
        :return None, root.left, root.right, and root, depending on what needs to be done with the tree:
        """
        if self.root == None:  # If empty tree
            return None
        if root == None:  # root to start with
            self.length -= 1  # decrease length variable for tree
            root = self.root
        if root.data > item:  # Node to left tree if item less than
            root.left = self.delete(item, root=root.left)
        elif root.data < item:  # Node to right tree if item greater than
            root.right = self.delete(item, root=root.right)
        else:  # Delete node if ==
            if not root.right:  # No right child then delete and new root becomes root.left
                return root.left
            if not root.left:  # No left child then delete and new root becomes root.right
                return root.right
            # If both children exist. Replace value with min value in right subtree then delete it.
            temp_val = root.right
            mini_val = temp_val.data
            while temp_val.left:
                temp_val = temp_val.left
                mini_val = temp_val.data

            root.right = self.delete(root.data, root=root.right)  # delete min node in right subtree
        return root

    def __contains__(self, item, node=None):
        """
        Configures the in functionality to work with the tree.
        :param self:
        :param item:
        :param node:
        :return True are False depending if in the tree:
        """
        if self.root == None:  # if tree is empty
            return False
        if item == self.root:  # if == to the root of the tree
            return True
        elif node is None:  # creates a node to start with. starts with root if not given a place to start
            node = self.root
        return self.finder(item, node)  # calls helper function

    def __len__(self):
        """
        Configures the len functionality to work with the tree
        :param self:
        :return self.length variable:
        """
        return self.length

    def finder(self, item, node):
        """
        Helper function for the __contains__ function
        :param self:
        :param item:
        :param node:
        :return True or False:
        """
        if item == node.data:  # if item looking for == Node
            return True
        if (item < node.data and node.data is not None):  # if less than and not empty
            return self.finder(item, node.left)  # iterates through with new node
        elif (item > node.data and node.right is not None):  # if greater than and not empty
            return self.finder(item, node.right)  # iterates through with new node
        else:
            return False  # end of tree so not in tree so returns false

    def traverse_inorder(self, node=None):
        """
        Function to display tree in inorder traversal
        :param self:
        :param node:
        :return nothing:
        """
        if (node is not None):  # if not at end of tree segment
            self.traverse_inorder(node.left)
            print(node.data,end=' ')
            self.traverse_inorder(node.right)

    def traverse_preorder(self, node=None):
        """
        Function to display tree in preorder traversal
        :param self:
        :param node:
        :return nothing:
        """
        if (node is not None):  # if not at end of tree segment
            print(node.data, end=' ')
            self.traverse_preorder(node.left)
            self.traverse_preorder(node.right)

    def traverse_postorder(self, node=None):
        """
        Function to display tree in postorder traversal
        :param self:
        :param node:
        :return nothing:
        """
        if (node is not None):  # if not at end of tree segment
            self.traverse_postorder(node.left)
            self.traverse_postorder(node.right)
            print(node.data, end=' ')




