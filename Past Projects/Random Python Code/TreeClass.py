"""
Johnathan Smith

3/17/2021

Test 1 Coding
"""


class Tree(object):

    def __init__(self, Index, Girth, Height, Volume):
        """creates the tree object."""
        self.Index = Index
        self.Girth = Girth
        self.Height = Height
        self.Volume = Volume
        self.new_tree = [self.Index, self.Girth, self.Height, self.Volume]

    def __str__(self):
        """how the tree object will be returned"""
        return str(self.new_tree)

    def __repr__(self):
        """how the tree object will be returned"""
        return str(self.new_tree)

    def get_index(self):
        """retrieves the index value for the current tree object. returns the Index value."""
        return self.Index

    def get_Girth(self):
        """retrieves the girth value for the current tree object. returns the girth value."""
        return self.Girth

    def get_Height(self):
        """retrieves the height value for the current tree object. returns the height value."""
        return self.Height

    def get_Volume(self):
        """retrieves the volume value for the current tree object. returns the volume value."""
        return self.Volume

    def get_new_tree(self):
        """retrieves current tree object. returns the tree object."""
        return self.new_tree


