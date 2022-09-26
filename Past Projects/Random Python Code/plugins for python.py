print() #Displays
int()   #Converts string or value to a computable integer
input() #Allows values to be input into the code while running
'{.2f}' #Allows the ablility to change the amount of decimal places after integer
Import math #To get math functions
abs     #To do absolute value
math.sqrt #does square root
float   #when useing decimals
-=, *=, /=, +=, #shortcuts
#example
# num_atoms += 5?   num_atoms is originally 7. SO 7 + 5 is 12.
**  #square or rased power
//  #division but rounds down, keeps integers intergers and floats floats
%   #gives the reaminder of a division

math. FUNCTIONS
Function	Description		  Function	Description
ceil	        Round up value		  fabs	        Absolute value
factorial	factorial (3! = 3 * 2 * 1)		floor	Round down value
fmod	        Remainder of division	   fsum	        Floating-point sum
exp	        Exponential function ex	   log	        Natural logarithm
pow	        Raise to power		   sqrt	        Square root
acos	        Arc cosine		   asin	        Arc sine
atan	        Arc tangent		   atan2	Arc tangent with two parameters
cos	        Cosine		           sin	        Sine
hypot	        Length of vector from origin degrees	Convert from radians to degrees
radians 	Convert degrees to radians  tan	        Tangent
cosh	        Hyperbolic cosine	    sinh	Hyperbolic sine
gamma	        Gamma function		    erf	        Error function
pi (constant)	Mathematical constant 3.141592...e (constant)	Mathematical constant 2.718281...


\n #newline character, pushes text to a new line
\t #indents the next like
\"  
and  #Allows for the use of quotes in a print  EX. He said, "Hello friend!".
\'
\\ #Allowa for the \ to be in the print EX.\home\users\

#  r'  #prints a string raw and withiut compting anything in it

ord() #converts string back into coding number
chr() #converts coding number value to string


#with variable test=Lave
    print(test[2]) #picks the character v out of the variable
    lin(test) #tells how many characters are in the variable test

my_list = [10, 'abc'] #assigns my_list with a list or sequence of things

#updating list
my_nums = [5, 12, 20]
print(my_nums)

# Update a list element
my_nums[1] = -28
print(my_nums)


.append #adds element to the end of a list
.pop    #removes element at specific index point
.remove #removes the first element whose value is ("  ").

Operation	Description
len(list)	Find the length of the list.
list1 + list2	Produce a new list by concatenating list2 to the end of list1.
min(list)	Find the element in list with the smallest value.
max(list)	Find the element in list with the largest value.
sum(list)	Find the sum of all elements of a list (numbers only).
list.index(val)	Find the index of the first element in list whose value matches val.
list.count(val)	Count the number of occurrences of the value val in list.


#for tuples, lists that cant be changed
from collections import namedtuple

Car = namedtuple('Car', ['make','model','price','horsepower','seats'])  # Create the named tuple

chevy_blazer = Car('Chevrolet', 'Blazer', 32000, 275, 8)  # Use the named tuple to describe a car
chevy_impala = Car('Chevrolet', 'Impala', 37495, 305, 5)  # Use the named tuple to describe a different car

print(chevy_blazer)
print(chevy_impala)
Car(make='Chevrolet', model='Blazer', price=32000, horsepower=275, seats=8)
Car(make='Chevrolet', model='Impala', price=37495, horsepower=305, seats=5)

set{}   #creates a set of values use curly brackets     no indexes

Operation	Description
len(set)	Find the length (number of elements) of the set.
set1.update(set2)	Adds the elements in set2 to set1.
set.add(value)	Adds value into the set.
set.remove(value)	Removes value from the set. Raises KeyError if value is not found.
set.pop()	Removes a random element from the set.
set.clear()	Clears all elements from the set.



#set operations

Operation	                                Description
set.intersection  (set_a, set_b, set_c...)	Returns a new set containing only the elements in common between set and all provided sets.
set.union  (set_a, set_b, set_c...)	        Returns a new set containing all of the unique elements in all sets.
set.difference  (set_a, set_b, set_c...)	Returns a set containing only the elements of set that are not found in any of the provided sets.
set_a.symmetric_difference  (set_b)	        Returns a set containing only elements that appear in exactly one of set_a or set_b

######Very cool remember#####
The union() method builds a set containing the unique elements from names1 and names2. 'Corrin' only appears once in the resulting set.
The intersection() method builds a set that contains all common elements between result_set and names3.
The difference() method builds a set that contains elements only found in result_set that are not in names4.

#fhfhfhfhfhfhf
Type	Notes
string	Sequence type: Used for text.
list	Sequence type: A mutable container with ordered elements.
tuple	Sequence type: An immutable container with ordered elements.
dict	Mapping type: A container with key-values associated elements.

#New programmers often struggle with choosing the types that best fit their needs, such as choosing
#whether to store particular data using a list, tuple, or dict. In general, a programmer might use
#a list when data has an order, such as lines of text on a page. A programmer might use a tuple instead
#of a list if the contained data should not change. If order is not important, a programmer might use a
#dictionary to capture relationships between elements, such as student names and grades.



Type	Description	                                                         Example	                    Output
s	String (default presentation type - can be omitted)	                '{:s}'.format('Aiden')              Aiden
d	Decimal (integer values only)	                                        '{:d}'.format(4)                    4
b	Binary (integer values only)	                                        '{:b}'.format(4)                    100
x, X	Hexadecimal in lowercase (x) and uppercase (X) (integer values only)	'{:x}'.format(15)                   f
e	Exponent notation	                                                '{:e}'.format(44)                   4.400000e+01
f	Fixed-point notation (6 places of precision)	                        '{:f}'.format(4)                    4.000000
.[precision]f	Fixed-point notation (programmer-defined precision)	        '{:.2f}'.format(4)                  4.00


if else elif statements
not that hard
== if something is equal to something  NoT an assignment
!= Not equal to



booleans

Boolean operator	Description
a and b	        Boolean AND: True when both operands are True.
a or b	        Boolean OR: True when at least one operand is True.
not a	        Boolean NOT (opposite): True when the single operand is False (and False when operand is True).


Membership operators
One common programming task involves determining whether a specific value can
be found within a container, such as a list or dictionary. The in and
not in operators, known as membership operators, yield True or False if
the left operand matches the value of some element
in the right operand, which is always a container.
in
not in

Identity operators
is & is not

from random import randint
random.randint(0, 5)
picks a random number between 0 and 5


while loop
for loop

reversed() prints list backwards
[::-1] reads string backwards
"string"[::-1]



seemed complicated so may need later
contact_emails = {
    'Sue Reyn' : 's.reyn@email.com',
    'Mike Filt': 'mike.filt@bmail.com',
    'Nate Arty': 'narty042@nmail.com'
}

new_contact = input()
new_email = input()
contact_emails[new_contact] = new_email

''' Your solution goes here '''
for a,b in contact_emails.items():
      print(str(b)+" is "+str(a))

also can be maybe
for contacts in contact_emails:
      print(contacts 'is' contact_emails(contacts))



    #####

range()
range(Y) generates a sequence of all non-negative integers less than Y.
Ex: range(3) creates the sequence 0, 1, 2.
range(X, Y) generates a sequence of all integers >= X and < Y.
Ex: range(-7, -3) creates the sequence -7, -6, -5, -4.
range(X, Y, Z), where Z is positive, generates a sequence of all integers >= X and < Y, incrementing by Z.
Ex: range(0, 50, 10) creates the sequence 0, 10, 20, 30, 40.
range(X, Y, Z), where Z is negative, generates a sequence of all integers <= X and > Y, incrementing by Z.
Ex: range(3, -1, -1) creates the sequence 3, 2, 1, 0.

enumerator
retieves the index and the corresponding element value

origins = [4, 8, 10]

for (index, value) in enumerate(origins):
    print('Element {}: {}'.format(index, value))


variable = input().split()
# puts varibles into list






from random import randint
x_var = 0
y_var = 0
my_list = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
max_list = {0}

while ((a * x_var) + (b * y_var)) != c:
    if my_list == max_list:
        N_sol1 = "No solution"
        break
    else:
        x_var = randint(-10, 10)
        y_var = randint(-10, 10)
        if ((a * x_var) + (b * y_var)) == c:
            A_1 = x_var
            A_2 = y_var
            N_sol1 = (A_1, A_2)
            break
        else:
            max_list.add(x_var)
            max_list.add(y_var)
            max_list = max_list.intersection(my_list)
            

x_var = 0
y_var = 0
my_list = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
max_list = {0}

while ((d * x_var) + (e * y_var)) != f:
    if my_list == max_list:
        N_sol2 = "No solution"
        break
    else:
        x_var = randint(-10, 10)
        y_var = randint(-10, 10)
        if ((d * x_var) + (e * y_var)) == f:
            B_1 = x_var
            B_2 = y_var
            N_sol2 = (B_1, B_2)
            break
        else:
            max_list.add(x_var)
            max_list.add(y_var)
            max_list = max_list.intersection(my_list)
            
if N_sol1 == N_sol2:
    print('No solution')
elif N_sol1 == 'No solution':
    print(N_sol2)
else:
    print(N_sol1)


"""
Program to print all 2-letter domain names.

Note that ord() and chr() convert between text and the ASCII or Unicode encoding:
-  ord('a') yields the encoded value of 'a', the number 97.
-  ord('a')+1 adds 1 to the encoded value of 'a', giving 98.
-  chr(ord('a')+1) converts 98 back into a letter, producing 'b'
"""
print('Two-letter domain names:')

letter1 = 'a'
letter2 = '?'
while letter1 <= 'z':  # Outer loop
    letter2 = 'a'
    while letter2 <= 'z':  # Inner loop
        print('{}{}.com'.format(letter1, letter2))
        letter2 = chr(ord(letter2) + 1)
    letter1 = chr(ord(letter1) + 1)

#fuck my life

    x_var = -10
y_var = -10
count = 0
answers1 = [0]
while count <= 440:
    count += 1
    if ((a * x_var) + (b * y_var)) == c:
        variables = str(x_var) + (' ') + str(y_var)
        answers1.append(variables)
        y_var += 1
        if y_var == 11:
            y_var = -10
            x_var += 1
    else:
        y_var += 1
        if y_var == 11:
            y_var = -10
            x_var += 1
        
  

x_var = -10
y_var = -10
count = 0
answers2 = [1]
while count <= 440:
    count += 1
    if ((d * x_var) + (e * y_var)) == f:
        variables = str(x_var) + (' ') + str(y_var)
        answers2.append(variables)
        y_var += 1
        if y_var == 11:
            y_var = -10
            x_var += 1
    else:
        y_var += 1
        if y_var == 11:
            y_var = -10
            x_var += 1



#the fucking answer to the problem
''' Read in first equation, ax + by = c '''
a = int(input())
b = int(input())
c = int(input())

''' Read in second equation, dx + ey = f '''
d = int(input())
e = int(input())
f = int(input())

''' Type your code here. '''

from random import randint

x_var = 0
y_var = 0
count = 0 
nono = 0

while count <= 1000:
    count += 1
    x_var = randint(-10, 10)
    y_var = randint(-10, 10)
    if ((a * x_var) + (b * y_var)) == c and ((d * x_var) + (e * y_var)) == f:
        print(x_var, y_var)
        nono = 25
        break
    
while count <= 1000 and nono != 25:
    count += 1
    x_var = randint(-10, 10)
    y_var = randint(-10, 10)
    if ((a * x_var) + (b * y_var)) == c or ((d * x_var) + (e * y_var)) == f:
        print(x_var, y_var)
        break

if count >= 1000:
    print('No solution')



#############

def get_numbers():
    user_input = input()
    values = []
    for token in user_input.split():
        values.append(int(token))
    return values

def print_selected_numbers():
    numbers = get_numbers()
    for number in numbers:
        if number >= 8:
            print(number)

print_selected_numbers()



###
global #variable#
allows the modification of a global variable inside if a function

employee_name = 'N/A'

def get_name():
    global employee_name
    name = input('Enter employee name:')
    employee_name = name

get_name()
print('Employee name:', employee_name)

Enter employee name: Juliet Capulet
Employee name: Juliet Capulet
            

locals()
globals()
#Global scope – Contains all globally defined names outside of any functions.
Local scope – Usually refers to scope within the currently
executing function, but is
the same as global scope if no function is executing.

    
1	def modify(my_list):
2	    my_list[1] = 99  # Modifying only the copy
3	
4	my_list = [10, 20, 30]
5	modify(my_list[:])  # Pass a copy of the list 
6	
7	print(my_list)  # my_list does not contain 99!


Note: split() and strip() are string methods further
explained elsewhere. split() separates a string into tokens
using any whitespace as the default separator. The tokens are
returned in a list (i.e., 'a b c'.split() returns ['a', 'b', 'c']).
strip() returns a copy of a
string with leading and trailing whitespace removed.







Sometimes a programmer doesn't know how many arguments a function requires. A function definition can include a *args parameter that collects optional positional parameters into an arbitrary argument list tuple.

Figure 6.11.1: Arbitrary numbers of position arguments using *args.
def sandwich(bread, meat, *args): 
    print('{} on {}'.format(meat, bread), end=' ') 
    if len(args) > 0: 
        print('with', end=' ') 
    for extra in args: 
        print(extra, end=' ') 
    print('')


sandwich('sourdough', 'turkey', 'mayo')
sandwich('wheat', 'ham', 'mustard', 'tomato', 'lettuce')

output
turkey on sourdough with mayo
ham on wheat with mustard tomato lettuce




Adding a final function parameter of **kwargs creates a dictionary containing "extra" arguments not defined in the function definition; kwargs is short for keyword arguments. The keys of the dictionary are the parameter names specified in the function call.

Figure 6.11.2: Arbitrary numbers of keyword arguments using **kwargs.
def sandwich(bread, meat, **kwargs):
    print('{} on {}'.format(bread, meat))
    for category, extra in kwargs.items():
        print('   {}: {}'.format(category, extra))

sandwich('sourdough', 'turkey', sauce='mayo')
sandwich('wheat', 'ham', sauce1='mustard', veggie1='tomato', veggie2='lettuce')

output
sourdough on turkey
   sauce: mayo

wheat on ham
   veggie2: lettuce
   sauce1: mustard
   veggie1: tomato



List Stuff:

list.append(x)	Add an item to the end of list.	my_list = [5, 8]
my_list.append(16)	
[5, 8, 16]
list.extend([x])	Add all items in [x] to list.	my_list = [5, 8]
my_list.extend([4, 12])	
[5, 8, 4, 12]
list.insert(i, x)	Insert x into list before position i.	my_list = [5, 8]
my_list.insert(1, 1.7)	
[5, 1.7, 8]

list.remove(x)	Remove first item from list with value x.	my_list = [5, 8, 14]
my_list.remove(8)	
[5, 14]
list.pop()	Remove and return last item in list.	my_list = [5, 8, 14]
val = my_list.pop()	
[5, 8]

val is 14
list.pop(i)	Remove and return item at position i in list.	my_list = [5, 8, 14]
val = my_list.pop(0)	
[8, 14]

val is 5

list.sort()	Sort the items of list in-place.	my_list = [14, 5, 8]
my_list.sort()	
[5, 8, 14]
list.reverse()	Reverse the elements of list in-place.	my_list = [14, 5, 8]
my_list.reverse()	
[8, 5, 14]


list.index(x)	Return index of first item in list with value x.	my_list = [5, 8, 14]
print(my_list.index(14))	Prints "2"
list.count(x)	Count the number of times value x is in list.	my_list = [5, 8, 5, 5, 14]
print(my_list.count(5))	Prints "3"


all(list)	True if every element in list is True (!= 0), or if the list is empty.	print(all([1, 2, 3]))
print(all([0, 1, 2]))	
True
False
any(list)	True if any element in the list is True.	print(any([0, 2]))
print(any([0, 0]))	
True
False
max(list)	Get the maximum element in the list.	print(max([-3, 5, 25]))	
25
min(list)	Get the minimum element in the list.	print(min([-3, 5, 25]))	
-3
sum(list)	Get the sum of all elements in the list.	print(sum([-3, 5, 25]))	
27


#LISTS INSODE LISTS ARE POSSIBLE#
EXAMPLE
my_list = [
    [10, 0, 55],
    [0, 4, 16]
]

# Write to some elements
my_list[0][0] = 33
my_list[1][1] = 77
my_list[1][2] = 99


#Slice Notation
boston_bruins = ['Tyler', 'Zdeno', 'Patrice']
print('Elements 0 and 1:', boston_bruins[0:2])
print('Elements 1 and 2:', boston_bruins[1:3])

#RESULT#
Elements 0 and 1: ['Tyler', 'Zdeno']
Elements 1 and 2: ['Zdeno', 'Patrice']

#this does a range of things in a list#

#Stride can also be used
print('Elements 0 and 1:', boston_bruins[0:2:5])
#5 is the stride##ounts by 5# every 5th value is used.



my_list[start:end]	Get a list from start to end (minus 1).	my_list = [5, 10, 20]
print(my_list[0:2])	
[5, 10]
my_list[start:end:stride]	Get a list of every stride element from start to end (minus 1).	my_list = [5, 10, 20, 40, 80]
print(my_list[0:5:3])	
[5, 40]
my_list[start:]	Get a list from start to end of the list.	my_list = [5, 10, 20, 40, 80]
print(my_list[2:])	
[20, 40, 80]
my_list[:end]	Get a list from beginning of list to end (minus 1).	my_list = [5, 10, 20, 40, 80]
print(my_list[:4])	
[5, 10, 20, 40]
my_list[:]	Get a copy of the list.	my_list = [5, 10, 20, 40, 80]
print(my_list[:])	
[5, 10, 20, 40, 80]


#LIST COMPREHENSION###
A list comprehension has three components:

An expression component to evaluate for each element in the iterable object.
A loop variable component to bind to the current iteration element.
An iterable object component to iterate over (list, string, tuple, enumerate, etc)

sort() rearanges the list from smalles to largest and alphabetically
sorted() creates a new sorted list without messing with the original list
can add a key
ex. sorted(names, key=str.lower)
reverse=True as the key makes list reversed


#DICTIONARY#
my_dict.clear()	Removes all items from the dictionary.	my_dict = {'Ahmad': 1, 'Jane': 42}
my_dict.clear()
print(my_dict)	
{}
my_dict.get(key, default)	Reads the value of the key from the dictionary. If the key does not exist in the dictionary, then returns default.	my_dict = {'Ahmad': 1, 'Jane': 42}
print(my_dict.get('Jane', 'N/A'))
print(my_dict.get('Chad', 'N/A'))	
42
N/A
my_dict1.update(my_dict2)	Merges dictionary my_dict1 with another dictionary my_dict2. Existing entries in my_dict1 are overwritten if the same keys exist in my_dict2.	my_dict = {'Ahmad': 1, 'Jane': 42}
my_dict.update({'John': 50})
print(my_dict)	
{'Ahmad': 1, 'Jane': 42, 'John': 50}
my_dict.pop(key, default)	Removes and returns the key value from the dictionary. If key does not exist, then default is returned.	my_dict = {'Ahmad': 1, 'Jane': 42}
val = my_dict.pop('Ahmad')
print(my_dict)	
{'Jane': 42}

dict.items() – returns a view object that yields (key, value) tuples.
dict.keys() – returns a view object that yields dictionary keys.
dict.values() – returns a view object that yields dictionary values.

for line in Input_file:
    begin_index = line.find('<')
    end_index = line.find('>')
    place_holder = []
    while begin_index < (end_index - 1):
        if begin_index != -1:
            begin_index += 1
            place_holder.append(line[begin_index])
            if begin_index == (end_index - 1):
                joined_place_holder = "".join(place_holder)
                if "-" in joined_place_holder:
                    joined_place_holder = joined_place_holder.replace('-', ' ')
                Complete_What_Asking_for_List.append(joined_place_holder)
        else:
            continue
return Complete_What_Asking_for_List