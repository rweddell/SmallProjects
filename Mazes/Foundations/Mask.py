
from PIL import Image
from random import randint

class Mask:

    def __init__(self, rows, columns):
        self.rows = rows-1
        self.columns = columns-1
        self.bits = [[True for i in range(self.rows)] for j in range(self.columns)]

    def is_bit(self, row, column):
        try:
            if row in range(0, self.rows) and column in range(0, self.columns):
                return self.bits[row][column]
        except:
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
    """
    Note - an extra row and column is generated, not sure how to fix
    :param file:
    :return:
    """
    with open(file) as f:
        lines = f.readlines()
    f.close()
    text = open(file, 'r')
    rows = sum(1 for line in text)
    columns = len(lines[1])
    mask = Mask(rows, columns)
    for i in range(rows-1):
        for j in range(columns-1):
            if lines[i][j] is 'x':
                mask.set_bit(i, j, False)
    return mask

def from_png(file):
    img = Image.open(file, 'r')
    rows, columns = img.size
    img = img.convert('RGB')
    pix = img.load()
    mask = Mask(rows, columns)
    print(type(pix))
    print(pix)
    for i in range(0, rows-1):
        for j in range(0, columns-1):
            if pix[i, j] == (0, 0, 0):
                mask.set_bit(j, i, value=False)
    return mask

def from_big_png(file):
    """
    from_png can overflow memory with large png files. This takes 1/5 of a png file.
    :param file:
    :return:
    """
    img = Image.open(file, 'r')
    rows, columns = img.width, img.height
    img = img.convert('RGB')
    pix = img.load()
    shortrows = round(rows/5)
    shortcols = round(columns/5)
    mask = Mask(shortcols, shortrows)
    print(rows, columns)
    print(type(pix))
    print(pix)
    for i in range(0, shortcols-1):
        for j in range(0, shortrows-1):
            try:
                if i*5 < columns and j*5 < rows and pix[j*5, i*5] == (0, 0, 0):
                    mask.set_bit(i, j, value=False)
            except:
                pass
    return mask
