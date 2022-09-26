"""
Johnathan Smith

4/10/2021

To make different functions based on the sorting methods Bubble, Selection, Insertion, Merge, and Quicksort
"""
import random


def bubble_sort(list):
    """
    Function performs the Bubble sort method to sort a list
    :param list:
    :return sorted list:
    """
    n = len(list)
    for i in range(n):
        for j in range(0, n-i-1):
            if list[j] > list[j+1]:
                list[j], list[j+1] = list[j+1], list[j]
    return list


def selection_sort(list):
    """
    Function performs the Selection sort method to sort a list
    :param list:
    :return sorted list:
    """
    n = len(list)
    for i in range(n):
        new_min = i
        for j in range(i+1, n):
            if list[new_min] > list[j]:
                new_min = j
        list[i], list[new_min] = list[new_min], list[i]
    return list


def insertion_sort(list):
    """
    Function performs the Insertion sort method to sort a list
    :param list:
    :return sorted list:
    """
    n = len(list)
    for i in range(1, n):
        target = list[i]
        j = i-1
        while j >= 0 and target < list[j]:
            list[j+1] = list[j]
            j -= 1
        list[j+1] = target
    return list


def merge_sort(list):
    """
    Function performs the merge sort method to sort a list
    :param list:
    :return sorted list:
    """
    if len(list) > 1:
        mid = len(list) // 2
        left = list[:mid]
        right = list[mid:]
        merge_sort(left)
        merge_sort(right)
        i = j = k = 0

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                list[k] = left[i]
                i += 1
            else:
                list[k] = right[j]
                j += 1
            k += 1

        # Checking whats left
        while i < len(left):
            list[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            list[k] = right[j]
            j += 1
            k += 1
    return list


def pivot_handle(list, low, high):
    """
    Function used in quicksort. Used to find the new pivot point for each new section of list it makes.
    :param list:
    :param low:
    :param high:
    :return pivot index:
    """
    i = (low-1)
    pivot = list[high]
    for j in range(low, high):
        if list[j] <= pivot:
            i = i + 1
            list[i], list[j] = list[j], list[i]
    list[i+1], list[high] = list[high], list[i+1]
    return i + 1


def quicksort(list, low, high):
    """
    Function performs the quicksort method to sort a list
    :param list:
    :param low:
    :param high:
    :return sorted list:
    """
    if low < high:
        piv = pivot_handle(list, low, high)
        quicksort(list, low, piv-1)
        quicksort(list, piv+1, high)
    return list


def main():
    list = []
    size_of_list = 10
    for i in range(0, size_of_list):
        num = random.randint(0, size_of_list)
        list.append(num)

    # BUBBLE SORT
    print('BUBBLE SORT')
    print("Before sorting")
    print(list)
    print("After sorting")
    sorted_list = bubble_sort(list)
    print(sorted_list)
    print()
    print("(1) Is this sort stable or not stable?\nIt is stable.")
    print("(2) Is this sort in-place or does it use extra memory?\nIn-place")
    print(
        "(3) What is the running time of this sort? "
        "What are the expensive operations in the algorithm? Worst case?\n"
        "O(n^2). The expensive part is the loops it does through the list. "
        "Worst case would be having to swap every digit as if it was ordered in reverse.")
    print("(4) When would this sort be used? or not?\nWouldn't use on a very large set of numbers.\n")

    list = []
    size_of_list = 10
    for i in range(0, size_of_list):
        num = random.randint(0, size_of_list)
        list.append(num)

    # SELECTION SORT
    print('SELECTION SORT')
    print("Before sorting")
    print(list)
    print("After sorting")
    sorted_list = selection_sort(list)
    print(sorted_list)
    print()
    print("(1) Is this sort stable or not stable?\nNot stable.")
    print("(2) Is this sort in-place or does it use extra memory?\nIn-place.")
    print(
        "(3) What is the running time of this sort? "
        "What are the expensive operations in the algorithm? Worst case?\n"
        "O(n^2). The expensive part is the loops it does through the list."
        "Worst case is if list is in reverse order.")
    print("(4) When would this sort be used? or not?\nUse where the cost of swapping items is high\n")

    list = []
    size_of_list = 10
    for i in range(0, size_of_list):
        num = random.randint(0, size_of_list)
        list.append(num)

    # INSERTION SORT
    print('INSERTION SORT')
    print("Before sorting")
    print(list)
    print("After sorting")
    sorted_list = insertion_sort(list)
    print(sorted_list)
    print()
    print("(1) Is this sort stable or not stable?\nIt is stable.")
    print("(2) Is this sort in-place or does it use extra memory?\nUses some extra memory.")
    print(
        "(3) What is the running time of this sort? "
        "What are the expensive operations in the algorithm? Worst case?\n"
        "O(n^2). The expensive part is the loops it does through the list. "
        "Worst case is if list is in reverse order.")
    print("(4) When would this sort be used? or not?\nUse with small lists.\n")

    list = []
    size_of_list = 10
    for i in range(0, size_of_list):
        num = random.randint(0, size_of_list)
        list.append(num)

    # MERGE SORT
    print('MERGE SORT')
    print("Before sorting")
    print(list)
    print("After sorting")
    sorted_list = merge_sort(list)
    print(sorted_list)
    print()
    print("(1) Is this sort stable or not stable?\nIt is stable.")
    print("(2) Is this sort in-place or does it use extra memory?\nUses extra memory.")
    print(
        "(3) What is the running time of this sort? "
        "What are the expensive operations in the algorithm? Worst case?\n"
        "0(n*log2(n)). The expensive part is the loops it does through the list. Same as best. ")
    print("(4) When would this sort be used? or not?\nUse for large lists.\n")

    list = []
    size_of_list = 10
    for i in range(0, size_of_list):
        num = random.randint(0, size_of_list)
        list.append(num)

    # QUICKSORT
    print('QUICKSORT')
    print("Before sorting")
    print(list)
    print("After sorting")
    sorted_list = quicksort(list, low=0, high=len(list)-1)
    print(sorted_list)
    print()
    print("(1) Is this sort stable or not stable?\nNot stable.")
    print("(2) Is this sort in-place or does it use extra memory?\nUses extra memory.")
    print(
        "(3) What is the running time of this sort? "
        "What are the expensive operations in the algorithm? Worst case?\n"
        "O(nlogn) on average but sometimes O(n^2). "
        "Expensive part is the recursive calls and the loops."
        "Worst case is when list is sorted.")
    print("(4) When would this sort be used? or not?\nNot used on lists that are majority sorted\n")

main()