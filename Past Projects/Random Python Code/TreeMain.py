"""
Johnathan Smith

3/17/2021

Test 1 Coding
"""

from TreeClass import *


def get_file():
    """Retrieves teh file and tests it to see if it exists. returns the file pointer and name of file."""
    Input = input("Input file name: ")
    counter = 0
    try:
        test_file = open(Input, "r")
        test_file.close()

    except:
        if counter == 1:
            return FileNotFoundError
        test_file = input("File not found. Try again: ")
        Input = test_file
        counter = 1
    return Input


def create_list(tree_file):
    """Creates a list of tree objects form the tree class using a given file. Returns the list of tree objects"""
    tree_list = []
    tree_file = open(tree_file, "r")
    for line in tree_file:  # iterates through each line of the file
        if line == '\n':  # end of file tester
            break
        line = line.split(',')
        if 'Index' in line[0]:  # if the line had words skip it
            continue
        else:
            tree_object = Tree(line[0], line[1], line[2], line[3].rstrip())  # makes tree object and adds to list
            tree_list.append(tree_object)
    return tree_list


def search(tree_list, Volume):
    """Takes the list of tree objects and searches through them for one tree object that contains a given volume.
    Returns index of tree containing the volume give or tells if no tree object exists."""
    for tree in tree_list:  # iterates through the list of tree objects
        if str(tree.get_Volume()) == str(Volume):  # tests to see if the current tree has the volume looking for
            return tree.get_index()
        if str(tree.get_index()) == str(len(tree_list)):  # If at end of list
            not_found = "Tree can't be found!"
            return not_found


def main():
    """Utilizes the function created above"""
    tree_file = get_file()
    tree_list = create_list(tree_file)
    print("Tree List")
    for tree in tree_list:  # You can just say print(tree_list) but it comes out in one long line.
        print(tree)
    print("Searching for Tree with a volume of 21.0 \nShould be at index 12")
    print(search(tree_list, 21.0))
    print("Searching for Tree with a volume of 100 \nShould not exist")
    print(search(tree_list, 100))



main()