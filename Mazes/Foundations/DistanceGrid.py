
import Foundations.Base36 as Base36
from Foundations.Grid import Grid


class DistanceGrid(Grid):

    def __init__(self, rows, columns):
        Grid.__init__(self, rows, columns)
        self.distlist = {}

    def contents_of(self, cell):
        if self.distlist and cell in self.distlist.keys():
            return Base36.encode(self.distlist[cell])
        else:
            return super().contents_of(cell)
