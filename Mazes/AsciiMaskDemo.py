
from Foundations.Mask import *
from Foundations.MaskedGrid import MaskedGrid
from Algorithms.HuntAndKill import HuntAndKill
from Algorithms.RecursiveBacktracker import RecursiveBacktracker

mask = from_txt('Output\masktext.txt')
recback = RecursiveBacktracker()
grid = recback.on(MaskedGrid(mask))

img = grid.to_png()
img.save('Output\mascii.png')


mask = from_png('Output\sampleimage.png')
grid = recback.on(MaskedGrid(mask))
img = grid.to_png(size=10)
img.save('Output\pngmask.png')


#makes a 5-1 mapping of the png file
smallmask = from_big_png('Output\sampleimage.png')
smallgrid = recback.on(MaskedGrid(smallmask))
smallimage = smallgrid.to_png(size=10)
smallimage.save('Output\shrunken.png')
