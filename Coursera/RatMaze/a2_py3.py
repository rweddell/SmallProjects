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

    def __init__(self, symbol:str, row:int, col:int) -> None:
        self.symbol = symbol
        self.row = row
        self.col = col
        self.num_sprouts_eaten = 0

    def __repr__(self) -> str:
        return f'{self.symbol}' 
        
    def __str__(self) -> str:
        return f'{self.symbol} at ({self.row}, {self.col}) ate {self.num_sprouts_eaten} sprouts.'

    def eat_sprout(self) -> None:
        """ Increment this Rat's num_sprouts_eaten count """
        self.num_sprouts_eaten += 1

    def set_location(self, new_row:int=None, new_col:int=None) -> None:
        """ Update the row and column of this Rat """
        if new_row:
            self.row = new_row
        if new_col:
            self.col = new_col



class Maze:
    """ A 2D maze. """

    def __init__(self, maze:list[list[str]], rat_1:Rat, rat_2:Rat, wall_symbol:str='#', sprout_symbol:str='@') -> None:
        self.maze = maze
        self.rat_1 = rat_1
        self.rat_2 = rat_2
        self.num_sprouts_left = 0
        self.wall_symbol = wall_symbol
        self.sprout_symbol = sprout_symbol

    def __str__(self) -> str:
        maze_str = ''
        for row in self.maze:
            for col in row:
                maze_str += col
            maze_str += '\n'
        return f'{maze_str}\n{self.rat_1}\n{self.rat_2}'

    def is_wall(self, row:int, col:int) -> bool:
        """ Return True if (row, col) is WALL, else return False """
        return self.maze[row][col] == self.wall_symbol

    def get_character(self, row:int, col:int) -> Rat|str:
        """ Return Rat's symbol at location (row,col) or 'HALL'/'.' if no Rat at location """
        if (row, col, row, col) == (self.rat_1.row, self.rat_1.col, self.rat_2.row, self.rat_2.col):
            return '!'
        elif (row, col) == (self.rat_1.row, self.rat_1.col):
            return self.rat_1.symbol
        elif (row, col) == (self.rat_2.row, self.rat_2.col):
            return self.rat_2.symbol
        return self.maze[row][col]

    def move(self, rat:Rat, row_change:int, col_change:int) -> bool:
        """ 
        Check if (row, col) is a valid move for rat. If so: 
         1. Check if space holds a sprout and if so:
            a. Increment rat.num_sprouts_eaten by 1
            b. Reduce self.num_sprouts_left by 1
         2. Update the row and col of rat
         3. Update the characters in the spaces of the maze
         4. Return True
        If not so:
         1. Return False
        """
        rat_loc = (rat.row, rat.col)
        row = rat.row+row_change
        col = rat.col+col_change
        if self.maze[row][col] != self.wall_symbol:
            if self.maze[row][col] == self.sprout_symbol:
                rat.eat_sprout()
                self.num_sprouts_left -= 1
            self.maze[rat_loc[0]][rat_loc[1]] = '.'
            rat.set_location(row, col)
            self.maze[row][col] = rat.symbol
            return True
        return False