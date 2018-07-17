
import Base36
from Grid import Grid

class DistanceGrid(Grid):

    def __init__(self, rows, columns):
        Grid.__init__(self, rows, columns)
        self.distlist = {}

    def contents_of(self, cell):
        if self.distlist and cell in self.distlist.cells.keys():
            return Base36.encode(self.distlist.cells[cell])
        else:
            return super.contents_of(cell)
