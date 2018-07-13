class Cell(object):
    row = 0
    column = 0
    north = None
    south = None
    east = None
    west = None
    links = {}

    def __init__(self, row, column):
        self.row = row
        self.column = column
        self.links = {}

    def __str__(self):
        return "(" + str(self.row) + ", " + str(self.column) + ")"

    def __hash__(self):
        return hash(self.__str__())

    def __repr__(self):
        return "Cell" + self.__str__()

    def link(self, cell, bidi=True):
        # if cell is self.north or cell is self.south or cell is self.east or cell is self.west and cell is not None:
        self.links[cell] = True
        if bidi == True:
            cell.link(self, False)

    def unlink(self, cell, bidi=True):
        # this is wrong, but I'll deal with it later cuz I don't need it right now
        del self.links[cell]
        if bidi == True:
            cell.unlink(self, False)

    def list_links(self):
        return self.links

    def is_linked(self, cell):
        # IS THE PROBLEM HERE????!?!
        # print(cell)
        # print(self.links)
        # print(cell in self.links.keys())
        if cell is not None:
            return cell in self.links.keys()
            #print("We got None")
        else:
            return False

    def neighbors(self):
        nlist = []
        if self.north is not None:
            nlist.append(self.north)
        if self.south is not None:
            nlist.append(self.south)
        if self.east is not None:
            nlist.append(self.east)
        if self.west is not None:
            nlist.append(self.west)
        return nlist
