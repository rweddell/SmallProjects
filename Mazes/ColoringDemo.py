
from Foundations.ColoredPolar import ColoredPolar
from Foundations.ColoredGrid import ColoredGrid
from Algorithms.RecursiveBacktracker import *
from Algorithms.Sidewinder import Sidewinder

george = RecursiveBacktracker()

grid = george.on(ColoredGrid(20, 20))

start = grid.grid[round(grid.rows/2)][round(grid.columns/2)]

grid.set_distances(start.distances())

filename = "Output\coloredmaze.png"
img = grid.to_png()
img.save(filename)


circle = george.on(ColoredPolar(15))
other = circle[round(grid.rows/2)][round(grid.columns/2)]
circle.set_distances(other.distances())
img = circle.to_png(cellsize=20)
img.save('Output\colorcircle.png')