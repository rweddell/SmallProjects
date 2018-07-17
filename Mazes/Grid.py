from Cell import Cell
from random import randint
import png


class Grid(object):

    def __init__(self, rows, columns):
        self.rows = rows
        self.columns = columns
        self.prepare_grid()
        self.configure_cells()

    def prepare_grid(self):
        self.grid = [[0 for x in range(self.rows)] for y in range(self.columns)]
        for i in range(0, self.rows):
            for j in range(0, self.columns):
                self.grid[i][j] = Cell(i, j)

    def configure_cells(self):
        for line in self.grid:
            for cell in line:
                row, col = cell.row, cell.column
                cell.north = self.borders(row - 1, col)
                cell.south = self.borders(row + 1, col)
                cell.east = self.borders(row, col + 1)
                cell.west = self.borders(row, col - 1)

    def borders(self, row, column):
        if row > self.rows - 1 or row < 0:
            return None
        if column > self.columns - 1 or column < 0:
            return None
        else:
            return self.grid[row][column]

    def random_cell(self):
        return self.grid[randint(0, rows)][randint(0, columns)]

    def size(self):
        return self.rows * self.columns

    def each_row(self):
        for row in self.grid:
            yield row

    def each_cell(self):
        for row in self.each_row():
            for cell in row:
                yield cell
    
    def contents_of(cell):
        return " "

    def __str__(self):
        output = "+" + "---+" * self.columns + "\n"
        for row in self.each_row():
            line = "|"
            bottom = "+"
            for cell in row:
                body = " " + self.contents_of(cell) + " "
                east_bound = "|"
                south_bound = "---"
                corner = '+'
                if cell.is_linked(cell.east) == True:
                    east_bound = " "
                line = line + body + east_bound
                if cell.is_linked(cell.south) == True:
                    south_bound = "   "
                bottom = bottom + south_bound + corner
            output = output + line + "\n" + bottom + "\n"
        return output
        
    def __repr__(self):
        return self.__str__()
    
    #Haven't figured this out yet
    """
    def to_png(size):
        width = size * self.columns
        length = size * self.rows
        bg = Color.WHITE
        wall = Color.BLACK
        writ = png.Writer()
        for cell in self.each_cell():
            x1 = cell.column * size
            x2 = (cell.column+1) * size
            y1 = cell.row * size
            y2 = (cell.column+1) * size
            writ.write
    """ 
