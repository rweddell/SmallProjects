# Do not import any modules. If you do, the tester may reject your submission.

# Constants for the contents of the maze.

# The visual representation of a wall.
WALL = '#'

# The visual representation of a hallway.
HALL = '.'

# The visual representation of a brussels sprout.
SPROUT = '@'

# Constants for the directions. Use these to make Rats move.

# The left direction.
LEFT = -1

# The right direction.
RIGHT = 1

# No change in direction.
NO_CHANGE = 0

# The up direction.
UP = -1

# The down direction.
DOWN = 1

# The letters for rat_1 and rat_2 in the maze.
RAT_1_CHAR = 'J'
RAT_2_CHAR = 'P'


class Rat:
    """ A rat caught in a maze. """

    def __init__(self, symbol, row, col):
        """(Rat, str, int, int) -> NoneType """
        self.symbol = symbol
        self.row = row
        self.col = col
        self.num_sprouts_eaten = 0
        
    def __str__(self):
        """ (Rat) -> str """
        return '{0} at ({1}, {2}) ate {3} sprouts.'.format(self.symbol, self.row, self.col, self.num_sprouts_eaten)

    def eat_sprout(self):
        """ 
        (Rat) -> NoneType
        Increment this Rat's num_sprouts_eaten count 
        """
        self.num_sprouts_eaten += 1

    def set_location(self, new_row, new_col):
        """ 
        (Rat, int, int) -> NoneType
        Update the row and column of this Rat 
        """
        if new_row:
            self.row = new_row
        if new_col:
            self.col = new_col



class Maze:
    """ A 2D maze. """

    def __init__(self, maze, rat_1, rat_2):
        """ 
        (Maze, list of list of str, Rat, Rat) -> NoneType

        maze = Maze(list_of_list_of_str, rat_1, rat_2))
        """
        self.maze = maze
        self.rat_1 = rat_1
        self.rat_2 = rat_2
        self.num_sprouts_left = 0

    def __str__(self):
        """ (Maze) -> NoneType 
        """
        maze_str = ''
        for row in self.maze:
            for col in row:
                maze_str += col
            maze_str += '\n'
        return maze_str + "{0}\n{1}".format(self.rat_1, self.rat_2)

    def is_wall(self, row, col):
        """ 
        (Maze, int, int) -> bool
        Return True if (row, col) is WALL, else return False 
        """
        return self.maze[row][col] == WALL

    def get_character(self, row, col) :
        """ 
        (Maze, int, int) -> str
        Return Rat's symbol at location (row,col) or 'HALL'/'.' if no Rat at location 
        """
        if (row, col, row, col) == (self.rat_1.row, self.rat_1.col, self.rat_2.row, self.rat_2.col):
            return '!'
        elif (row, col) == (self.rat_1.row, self.rat_1.col):
            return self.rat_1.symbol
        elif (row, col) == (self.rat_2.row, self.rat_2.col):
            return self.rat_2.symbol
        return self.maze[row][col]

    def move(self, rat, row_change, col_change):
        """ 
        (Maze, Rat, int, int) -> bool
        Check if move is valid for rat. If so, move rat. If sprout present, rat eats the sprout.
        """
        rat_loc = (rat.row, rat.col)
        row = rat.row+row_change
        col = rat.col+col_change
        if self.maze[row][col] != WALL:
            if self.maze[row][col] == SPROUT:
                rat.eat_sprout()
                self.num_sprouts_left -= 1
            self.maze[rat_loc[0]][rat_loc[1]] = HALL
            rat.set_location(row, col)
            self.maze[row][col] = rat.symbol
            return True
        return False