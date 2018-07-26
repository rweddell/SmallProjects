
from Foundations.Grid import Grid
from Foundations.Cell import Cell

class MaskedGrid(Grid):

    def __init__(self, newmask):
        self.mask = newmask
        super().__init__(self.mask.rows, self.mask.columns)

    def prepare_grid(self):
        grid = [[Cell(x, y) for y in range(self.rows)] for x in range(self.columns)]
        return grid

    def random_cell(self):
        row, col = self.mask.random_location()
        return self.grid[row][col]

    def configure_cells(self):
        for line in self.grid:
            for cell in line:
                row, col = cell.row, cell.column
                if self.mask.is_bit(row, col):
                    if self.mask.is_bit(row-1, col):
                        cell.north = self.borders(row - 1, col)
                    if self.mask.is_bit(row+1, col):
                        cell.south = self.borders(row + 1, col)
                    if self.mask.is_bit(row, col+1):
                        cell.east = self.borders(row, col + 1)
                    if self.mask.is_bit(row, col-1):
                        cell.west = self.borders(row, col - 1)
