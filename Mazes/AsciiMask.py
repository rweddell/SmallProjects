
from Foundations.Mask import *
from Foundations.MaskedGrid import MaskedGrid
from Algorithms.RecursiveBacktracker import RecursiveBacktracker

mask = from_txt('Output\masktext.txt')
recback = RecursiveBacktracker()
grid = recback.on(MaskedGrid(mask))

img = grid.to_png()
img.save('Output\mascii.png')
