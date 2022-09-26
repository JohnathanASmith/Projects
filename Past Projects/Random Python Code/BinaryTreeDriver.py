"""
Johnathan Smith

4/25/2021

Take Home assignment 2. Driver to run tree.
"""


from BinaryTree import *


def main():
    """
    Main function to run everything
    :return:
    """
    # creating the tree object
    print("Creating tree object...\n")
    tree = BinaryTree()

    # Displaying the current max height/depth before anything is added
    print("Testing current Max height:", tree.max_height())

    # inserting a set of integers into the tree
    print("\nInserting 10, 5, 32, 14, 12, 6\n")
    tree.insert(10)
    tree.insert(5)
    tree.insert(32)
    tree.insert(14)
    tree.insert(12)
    tree.insert(6)

    # Restating the Max height/depth of the tree after inserting integers
    print("Testing Max height after insertions:", tree.max_height())

    # Showing the tree in inorder, preorder, and postorder traversal
    print("\nDisplaying tree in inorder, preorder, and postorder traversal")
    print("INORDER Traversal")
    tree.traverse_inorder(tree.root)
    print("\nPREORDER Traversal")
    tree.traverse_preorder(tree.root)
    print("\nPOSTORDER Traversal")
    tree.traverse_postorder(tree.root)

    # Displaying the length of the tree using direct access to the variable that holds the data and the len function
    print("\n\nDisplaying length of the tree using two different ways")
    print("Using tree.length: ",tree.length)
    print("Using len(tree): ",len(tree))

    # removing two integers from the tree
    print("\nRemoving 5 and 32")
    tree.delete(5)
    tree.delete(32)

    # Showing that the max height/depth hasn't changed even after removal of two integers
    print("\nChecking to see if Max height same even after removal:", tree.max_height())

    # Showing the tree in inorder, preorder, and postorder traversal after removal of integers
    print("\nDisplaying tree in inorder, preorder, and postorder traversal after removal")
    print("INORDER Traversal")
    tree.traverse_inorder(tree.root)
    print("\nPREORDER Traversal")
    tree.traverse_preorder(tree.root)
    print("\nPOSTORDER Traversal")
    tree.traverse_postorder(tree.root)

    # Displaying the length of the tree using direct access to the variable that holds the data and the len function
    print("\n\nDisplaying length of the tree using two different ways after removal")
    print("Using tree.length: ", tree.length)
    print("Using len(tree): ", len(tree))

    # Showing the alteration made to the __contains__ function to work with the tree structure
    print("\nTesting the __contains__ function with a 'if x in tree' format:")
    print("if 12 in tree: Should be True")
    if 12 in tree:
        print("True")
    else:
        print("False")
    print("if 32 in tree: Should be False. Was removed earlier.")
    if 32 in tree:
        print("True")
    else:
        print("False")


main()
