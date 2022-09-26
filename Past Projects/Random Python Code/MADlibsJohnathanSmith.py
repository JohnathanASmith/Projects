'''
Johathan Smith
2/4/2021
Resources:
    https://www.w3schools.com/
    realpython.com
    https://stackoverflow.com/
    https://www.daniweb.com/
    Used for syntax and general refresher on a lot of things I had forgotten.

I've never had to make an algorithm for my code in the past and never learned in my last class how to. Also never had
to leave comments or anything. I did what I thought was right after some googling.

1. Create an introduction for the game for the user to see.
2. Assign Input with the file name given my the user.
3. Test file to see if it exists. If not create exception to ask the reader for another input. Return Input.
4. Assign output with the file given by the reader.
5. open input file.
6. Assign a variable with the story with the the input file
7. iterate through the story line by line while assigning a variable to the lines continuously adding on to each other
so they are all on one line.
8. take the variable that has the one line story and make it a list separating each letter.
9. iterate through the list.
10. when hitting a point when the letter is < start adding the letters after it to another variable until the
letter is >.
11. once the letter is > then it should be added to a list. This continues to happen for all occurrences
that < and > are present until reaching the end of the story.
12. join the list together so the letters arent separated anymore.
13.The < than sign is present in the list so replace that with a space to separate the words.
14. Once again split the words by the space just created so you have a list of the parts of speech being asked for.
15. iterate through the list for any values that have - in it and replace that with a space.
16. add the new parts of speech to a list.
17. close the input file.
18. return the new list.
19. create a loop to iterate through the new list.
20. specify if there will be an or a before the parts of speech.
21. every time the user gives an answer add that to a new list.
22. return that list with the answers
23. open the input and output files.
24. iterate through each line.
25. make each line into a list
26. join the list together then separate it again so the words are separated not the letters.
27. iterate through he list and for every value that has < in it replace it with the answer.
28. have a counter that goes up each time you replace something so it knows to use the next answer in the answers list.
29. this format will be duplicated into 3 different statements with one being for a line with 2 less than signs, a
line with 1 less than signs and the last for none.
30. the only one that is different is the one with none because it never uses any of the answers so the counter used to
go to the next answer will not be increased.
31. every time it gets through a line it takes the variable assigned with the new line which now has the answer in it
and writes the line to the output file.
32. close the output and Input file.
33. return the output file.
34.open the output file back up.
35. ask the user if they wish to see the story they have created.
36. assign a variable with there answer.
37. if the answer is y print out the new story.
38. if no do nothing.
39. close the output file.
40. ask the user if they wish to play again.
41. assign there answer to a variable.
42. if the answer is y run the main function to start the game all over again.
43. If the answer is n do nothing.
'''

def Instructions():
    """Presents the reader the introduction to the game"""
    print("\nWelcome to the game of Mad Libs.")
    print("I will ask you to provide several words and phrases to fill in a mad lib story.")
    print("The result will be written to an output file.\n")

def Input_Name():
    """Asks user for input file and if not found re prompts the user for another file."""
    Input = input("Input file name: ")
    try:
        test_file = open(Input, "r")
        test_file.close()
    except:
        test_file = input("File not found. Try again: ")
        Input = test_file
    return Input
    '''returns input file for later use'''

def Output_Name():
    '''Asks the user for a output file'''
    Output = input("Output file name: ")
    print()
    return Output
    '''returns output file for later use'''

def Whats_being_asked_for(Input):
    '''Develops a list of what is being asked of the user to be used later'''
    Complete_What_Asking_for_List = []
    Input_file = open(Input, "r")
    Holder = []
    count = 0
    word_values = []
    One_line_story = ""
    for line in Input_file:
        One_line_story += line
    One_line_story = list(One_line_story)
    for index, character in enumerate(One_line_story):
        if character == '<':
            count = 1
        if count == 1:
            if character == ">":
                count = 0
            else:
                word_values.append(character)
    word_values = ''.join(word_values)
    word_values = word_values.replace('<', ' ')
    word_values = word_values.split(' ')
    for index, character in enumerate(word_values):
        if character != '':
            if '-' in character:
                character = character.replace('-', ' ')
            Holder.append(character)
        Complete_What_Asking_for_List = Holder
    Input_file.close()
    return Complete_What_Asking_for_List
    '''returns a list of the parts od speech being asked for in the story'''

def Asking_User_for_Words(Complete_Asked_List):
    '''uses the whats being asked for list and iterate through it and develops a list of answers to the questions'''
    Counter = 0
    Answer_List = []
    Temp_Answer = None
    while Counter < len(Complete_Asked_List):
        if Complete_Asked_List[Counter] == "adjective":
            Temp_Answer = input("Please type an adjective: ")
        else:
            Temp_Answer = input("Please type a {}: ".format(Complete_Asked_List[Counter]))
        Counter += 1
        Answer_List.append(Temp_Answer)
    return Answer_List
    '''Returns the answers given my the user for the parts of speech'''

def Complete_story(Input, output, Answer_list):
    '''reads the input file and writes it over to the output file while replacing the spots where a <.....> is with the answer given by the user'''
    Output_file = open(output, "w")
    Input_file = open(Input, "r")
    count = 0
    for line in Input_file:
        holder_line = list(line)
        if holder_line.count('<') == 2:
            holder_line = ''.join(holder_line)
            holder_line = holder_line.split()
            for index, value in enumerate(holder_line):
                if '<' in value:
                    holder_line[index] = Answer_list[count]
                    count += 1
            holder_line = ' '.join(holder_line)
            holder_line = holder_line + '\n'
            Output_file.write(holder_line)
        elif holder_line.count('<') == 1:
            holder_line = ''.join(holder_line)
            holder_line = holder_line.split()
            for index, value in enumerate(holder_line):
                if '<' in value:
                    holder_line[index] = Answer_list[count]
                    count += 1
            holder_line = ' '.join(holder_line)
            holder_line = holder_line + '\n'
            Output_file.write(holder_line)
        else:
            holder_line = ''.join(holder_line)
            Output_file.write(holder_line)
            continue
    Input_file.close()
    Output_file.close()
    return Output_file
    '''returns the output file with the complete story on it'''

def Asking_want_to_see(Output):
    '''Asks the user if they want to see the result of the MAdLib. If yes shows the reader the Mad Lib created'''
    MadLib = open(Output, 'r')
    print("\nYour MadLib story has been created.\n")
    yes_no = input("Do you want to see the resulting story? (Y|N) ")
    if yes_no == 'Y' or yes_no == 'y':
        print("\nHere is the resulting MadLib:")
        lines = MadLib.readlines()
        for line in lines:
            print(line[:-1])
    MadLib.close()

def Do_you_want_to_play_again():
    '''Asks the user if they want to play again. If so calls the main function to starts again.'''
    yes_no = input("\nDo you want to process another Mad Lib? (Y|N) ")
    if yes_no == 'Y' or yes_no == 'y':
        main()

def main():
    '''Runs all the functions'''
    Instructions()
    Input = Input_Name()
    Output = Output_Name()
    Complete_Asked_List = Whats_being_asked_for(Input)
    Answer_list = Asking_User_for_Words(Complete_Asked_List)
    Complete_story(Input, Output, Answer_list)
    Asking_want_to_see(Output)
    Do_you_want_to_play_again()

#main run
main()
