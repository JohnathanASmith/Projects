from random import randint
from timeit import repeat


def run_sorting_algorithm(Output_file, algorithm, array):
    # Set up the context and prepare the call to the specified
    # algorithm using the supplied array. Only import the
    # algorithm function if it's not the built-in `sorted()`.
    setup_code = f"from __main__ import {algorithm}" \
        if algorithm != "sorted" else ""

    stmt = f"{algorithm}({array})"

    # Execute the code ten different times and return the time
    # in seconds that each execution took
    times = repeat(setup=setup_code, stmt=stmt, repeat=3, number=10)

    # Finally, display the name of the algorithm and the
    # minimum time it took to run
    print(f"Algorithm: {algorithm}. Minimum execution time: {min(times)}")
    output_file.write(f"Algorithm: {algorithm}. Minimum execution time: {min(times)}\n")

#**you should not have to touch the bubble sort function
def bubble_sort(array):
    n = len(array)

    for i in range(n):
        # Create a flag that will allow the function to
        # terminate early if there's nothing left to sort
        already_sorted = True

        # Start looking at each item of the list one by one,
        # comparing it with its adjacent value. With each
        # iteration, the portion of the array that you look at
        # shrinks because the remaining items have already been
        # sorted.
        for j in range(n - i - 1):
            if array[j] > array[j + 1]:
                # If the item you're looking at is greater than its
                # adjacent value, then swap them
                array[j], array[j + 1] = array[j + 1], array[j]

                # Since you had to swap two elements,
                # set the `already_sorted` flag to `False` so the
                # algorithm doesn't finish prematurely
                already_sorted = False

        # If there were no swaps during the last iteration,
        # the array is already sorted, and you can terminate
        if already_sorted:
            break

    return array


def insertion_sort(array):
    n = len(array)
    for i in range(1, n):
        target = array[i]
        j = i - 1
        while j >= 0 and target < array[j]:
            array[j + 1] = array[j]
            j -= 1
        array[j + 1] = target
    return array


# def merge(left, right):
#    pass  #replace this


def merge_sort(array):
    if len(array) > 1:
        mid = len(array) // 2
        left = array[:mid]
        right = array[mid:]
        merge_sort(left)
        merge_sort(right)
        i = j = k = 0

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                array[k] = left[i]
                i += 1
            else:
                array[k] = right[j]
                j += 1
            k += 1

        # Checking whats left
        while i < len(left):
            array[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            array[k] = right[j]
            j += 1
            k += 1
    return array


#**you should not have to touch the quicksort function
def quicksort(array):
    # If the input array contains fewer than two elements,
    # then return it as the result of the function
    if len(array) < 2:
        return array

    low, same, high = [], [], []

    # Select your `pivot` element randomly
    pivot = array[randint(0, len(array) - 1)]

    for item in array:
        # Elements that are smaller than the `pivot` go to
        # the `low` list. Elements that are larger than
        # `pivot` go to the `high` list. Elements that are
        # equal to `pivot` go to the `same` list.
        if item < pivot:
            low.append(item)
        elif item == pivot:
            same.append(item)
        elif item > pivot:
            high.append(item)

    # The final result combines the sorted `low` list
    # with the `same` list and the sorted `high` list
    return quicksort(low) + same + quicksort(high)


if __name__ == "__main__":
    output_file = open('results.txt', "w")

    array = []  #this is your list that you will need to fill with the sqft data

    print("Reading in data from zillow.csv....\n")
    print("Here is my list of just the sqft from the zillow houses......")
    file = open('zillow.csv', "r")
    for line in file:  # iterates through each line of the file
        if line == '\n':  # end of file tester
            break
        line = line.split(',')
        if 'Index' in line[0]:  # if the line had words skip it
            continue
        else:
            object = (line[1])  # makes object and adds to list
            array.append(object)
    print(array)
    print()
    print("Now we are going to use th timeit library to run repeated trials of our sorting algorithms to "
          "compare runtimes.\n")

    # Call the function using the name of the sorting algorithm
    # and the array you just created
    run_sorting_algorithm( output_file, algorithm="bubble_sort", array=array)
    run_sorting_algorithm( output_file, algorithm="insertion_sort", array=array)
    run_sorting_algorithm( output_file, algorithm="merge_sort", array=array)
    run_sorting_algorithm( output_file, algorithm="quicksort", array=array)
    print("\nResults on the screen have also been written to the output file.")