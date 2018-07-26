
from random import randint

class Mask:

    def __init__(self, rows, columns):
        self.rows = rows
        self.columns = columns
        self.bits = [[True for i in range(self.rows)] for j in range(self.columns)]
    def is_bit(self, row, column):
        if row in range(0, self.rows-1) and column in range(0, self.columns-1):
            return self.bits[row][column]
        else:
            return False

    def set_bit(self, row, column, value=True):
        self.bits[row][column] = value

    def count(self):
        total = 0
        for row in self.rows:
            for col in row:
                if self.is_bit(row, col):
                    total += 1
        return total

    def random_location(self):
        row = randint(0, self.rows)
        col = randint(0, self.columns)
        while not self.is_bit(row, col):
            row = randint(0, self.rows)
            col = randint(0, self.columns)
        return row, col

def from_txt(file):
    with open(file) as f:
        lines = f.readlines()
    text = open(file, 'r')
    rows = sum(1 for line in text)
    columns = len(lines[1])
    mask = Mask(rows, columns)
    for i in range(rows-1):
        for j in range(columns-1):
            if lines[i][j] is 'x':
                mask.set_bit(i, j, False)
    return mask