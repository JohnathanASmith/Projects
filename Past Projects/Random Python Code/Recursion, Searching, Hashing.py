"""
Johnathan Smith

3/26/2021

To make different functions to solve the problems given. Using Recursion, Searching, Hashing.
"""
import math
import random
# problem 1
def binary_search(someList, target):
    """
    This function performs a binary search on a list, looking for a target
    :param someList:
    :param target:
    :return whether or not the target was found:
    """
    found = False
    first = 0
    last = len(someList)-1
    while first <= last and not found:  # check to see if searched all
        mid = (first+last)//2
        if target < someList[mid]:
            last = mid-1
        elif target > someList[mid]:
            first = mid+1
        else:
            found = True
    return found
# problem 2
def sequential_search(someList, target):
    """
    This function performs a linear search on a list, looking for a target
    :param someList:
    :param target:
    :return whether or not the target was found and its location(none if not found):
    """
    for index, value in enumerate(someList):
        if value == target:
            return True, index
        if index == len(someList)-1:  # if at end of list
            return False, None
# problem 3
def smart_sequential_search(someList, target):
    """
    This function performs a smart sequential search on a list
    :param someList:
    :param target:
    :return whether or not the target was found and its location(none if not found):
    """
    for index, value in enumerate(someList):
        if value == target:
            return True, index
        if index == len(someList)-1 or value > target:  # if at end of list or value is greater than target
            return False, None
# problem 4
def maximum(someList):
    """
    This is a function that searches for the maximum value in the list
    :param someList:
    :return the max value:
    """
    if len(someList) == 1:  # if list has one item
        return someList[0]
    else:
        return max(someList[0],maximum(someList[1:]))
# problem 5
def hash(value, list_size):
    """
    function that maps phone numbers to a smaller list
    :param value:
    :param list_size:
    :return the index value of the hashed phone number:
    """
    index = int(math.sqrt(int(value)))%list_size  # hash formula
    return index


def main():

    # problem 1
    print("problem 1")
    listF = [11, 23, 58, 31, 56, 77, 43, 12, 65, 19]
    listF.sort()
    print("listF: ", listF)
    result = binary_search(listF, 43)
    print("Looking for 43 in listF: ", result)
    result = binary_search(listF, 234)
    print("Looking for 234 in listF: ", result)
    result = binary_search(listF, 48)
    print("Looking for 48 in listF: ", result)
    print()

    # problem 2
    print("problem 2")
    listB = [11,23,58,31,56,77,43,12,65,19]
    print("listB: ", listB)
    result = sequential_search(listB, 31)
    print("Looking for 31 in listB: ", result)
    result = sequential_search(listB, 178)
    print("Looking for 178 in listB: ", result)
    print()

    # problem 3
    print("problem 3")
    listC = [11, 23, 58, 31, 56, 77, 43, 12, 65, 19]
    listC.sort()
    print("listC: ", listC)
    result = smart_sequential_search(listC, 43)
    print("Looking for 43 in listC: ", result)
    result = smart_sequential_search(listC, 234)
    print("Looking for 234 in listC: ", result)
    result = smart_sequential_search(listC, 48)
    print("Looking for 48 in listC: ", result)
    print()

    # problem 4
    print("Problem 4")
    listA = [23,56,1,34,12,100,75,3,4]
    maxValue = maximum(listA)
    print("This is what is in listA: ", listA)
    print("maxValue in listA is: ", maxValue)
    print()

    # problem 5
    print("problem 5")
    phone_list = []
    for i in range(0,20):  # size of initial list
        num = random.randint(1000000000,9999999999)
        phone_list.append(num)
        hashList = [None]*(2*len(phone_list))  # size of hash list
    load = 0
    print("List before anything has been done to it: ",hashList)
    for num in phone_list:
        index = hash(num,len(hashList))
        while hashList[index] is not None:  # checking to see if index is emtpy
            if index == len(hashList)-1:  # if at end of list
                index = -1
            index += 1
        hashList[index] = num
        load = 1 - (hashList.count(None) / len(hashList))  # calculating current load
        print("Testing load amount")
        print("load is: ",load)
        while load >= .67:  # while load is over a given threshold
            print("Load is above threshold. Adding a extra None to end of list")
            hashList.append(None)
            load = 1 - (hashList.count(None) / len(hashList))
        print("Load is below threshold")
    print("List after numbers have been added: ",hashList)

    #search for value in hashList
    value = phone_list[8]
    print("searching for phone num: ", phone_list[8])
    potentialIndex = hash(value,len(hashList))
    if hashList[potentialIndex] == phone_list[8]:
        print('direct hit at: ', potentialIndex)
    else:
        found = False
        counter = 0
        while not found and counter < len(hashList):
            potentialIndex += 1
            if hashList[potentialIndex] == phone_list[8]:
                print("finally found it: ",potentialIndex)
                found = True
            counter += 1



main()