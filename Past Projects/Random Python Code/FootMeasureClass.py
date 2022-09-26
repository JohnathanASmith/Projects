class FootMeasure():

    def __init__(self, feet=0, inches=0):
        self.feet = feet
        self.inches = inches

    def __str__(self):
        """Displays the feet and inches a specific way depending on what values are given."""
        if self.feet == 0 and self.inches == 0:
            return '{} ft. {} in.'.format(self.feet, self.inches)
        elif self.inches >= 12:
            while self.inches >= 12:
                self.feet += 1
                self.inches = self.inches - 12
            if self.inches == 0:
                return '{} ft.'.format(self.feet)
            else:
                return '{} ft. {} in.'.format(self.feet, self.inches)
        elif self.feet != 0 and self.inches == 0:
            return '{} ft.'.format(self.feet)
        else:
            return '{} ft. {} in.'.format(self.feet, self.inches)

    def __add__(self, rMeasure):
        """Adds two FootMeasure values together and return it"""
        newMeasure = FootMeasure(feet = 0, inches = 0)
        newMeasure.feet = self.feet + rMeasure.feet
        newMeasure.inches = self.inches + rMeasure.inches
        return newMeasure

    def __eq__(self, rMeasure):
        """Returns True if two FootMeasure values are equal"""
        equalTO = False
        measure1_feet = self.feet
        measure1_inches = self.inches
        measure2_feet = rMeasure.feet
        measure2_inches = rMeasure.inches
        if measure1_feet == measure2_feet and measure1_inches == measure2_inches:
            equalTO = True

        return equalTO

    def __neq__(self, rMeasure):
        """Returns True if two FootMeasure values are not equal"""
        return not self.__eq__(rMeasure)

    def __lt__(self, rMeasure):
        """Returns True if the first FootMeasure value is less than the second"""
        lessthan = False
        measure1_feet = self.feet
        measure1_inches = self.inches
        measure2_feet = rMeasure.feet
        measure2_inches = rMeasure.inches
        if measure1_feet == measure2_feet:
            if measure1_inches < measure2_inches:
                lessthan = True
        if measure1_feet < measure2_feet:
            lessthan = True

        return lessthan

    def __le__(self, rMeasure):
        """Returns True if the first FootMeasure value is less than or equal to the second"""
        lessthanORequal = False
        measure1_feet = self.feet
        measure1_inches = self.inches
        measure2_feet = rMeasure.feet
        measure2_inches = rMeasure.inches
        if self == rMeasure:
            lessthanORequal = True
        if measure1_feet == measure2_feet:
            if measure1_inches < measure2_inches:
                lessthanORequal = True
        if measure1_feet < measure2_feet:
            lessthanORequal = True


        return lessthanORequal

    def __gt__(self, rMeasure):
        """Returns True if the first FootMeasure value is greater than the second"""
        greaterthan = False
        measure1_feet = self.feet
        measure1_inches = self.inches
        measure2_feet = rMeasure.feet
        measure2_inches = rMeasure.inches
        if measure1_feet == measure2_feet:
            if measure1_inches > measure2_inches:
                greaterthan = True
        if measure1_feet > measure2_feet:
            greaterthan = True

        return greaterthan

    def __ge__(self, rMeasure):
        """Returns True if the first FootMeasure value is greater than or equal to the second"""
        greaterthanORequal = False
        measure1_feet = self.feet
        measure1_inches = self.inches
        measure2_feet = rMeasure.feet
        measure2_inches = rMeasure.inches
        if self == rMeasure:
            greaterthanORequal = True
        if measure1_feet == measure2_feet:
            if measure1_inches > measure2_inches:
                greaterthanORequal = True
        if measure1_feet > measure2_feet:
            greaterthanORequal = True

        return greaterthanORequal


