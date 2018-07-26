
from Algorithms.RecursiveBacktracker import RecursiveBacktracker
from Foundations.Grid import Grid

sylvester = RecursiveBacktracker()

grid = sylvester.on(Grid(20,20))

img = grid.to_png()
img.save('Output\recursive.png')