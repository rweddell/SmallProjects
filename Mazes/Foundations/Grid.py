from Foundations.Cell import Cell
from random import randint
from PIL import Image, ImageDraw


class Grid(object):

    def __init__(self, rows, columns):
        self.rows = rows
        self.columns = columns
        self.prepare_grid()
        self.configure_cells()
        self.size = self.get_size()

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
        return self.grid[randint(0, self.rows-1)][randint(0, self.columns-1)]

    def get_size(self):
        return self.rows * self.columns

    def each_row(self):
        for row in self.grid:
            yield row

    def each_cell(self):
        for row in self.grid:
            for cell in row:
                yield cell
    
    def contents_of(self, cell):
        return " "
        
    def bg_color(self, cell):
        return None

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
                if cell.is_linked(cell.east):
                    east_bound = " "
                line = line + body + east_bound
                if cell.is_linked(cell.south):
                    south_bound = "   "
                bottom = bottom + south_bound + corner
            output = output + line + "\n" + bottom + "\n"
        return output
        
    def __repr__(self):
        return self.__str__()
    
    def to_png(self, size=50):
        """
        Creates a png file of maze
        :param size: 50 is default
        :return: image object
        """
        width = size * self.columns
        height = size * self.rows
        dimensions = (width, height)
        bg = (255, 255, 255)
        wall = (0, 0, 0)
        img = Image.new('RGBA', dimensions, bg)
        drw = ImageDraw.Draw(img)
        for cell in self.each_cell():
            x1 = cell.column * size
            x2 = (cell.column+1) * size
            y1 = cell.row * size
            y2 = (cell.row+1) * size
            color = self.bg_color(cell)
            if color:
                drw.rectangle(((x1, y1), (x2, y2)), color)
            # TODO: walls are not drawn when maps are colored
            if not cell.north:
                drw.line(((x1, y1), (x2, y1)), wall, 5)
            if not cell.west:
                drw.line(((x1, y1), (x1, y2)), wall, 5)
            if not cell.is_linked(cell.east):
                drw.line(((x2, y1), (x2, y2)), wall, 5)
            if not cell.is_linked(cell.south):
                drw.line(((x1, y2), (x2, y2)), wall, 5)
        return img
