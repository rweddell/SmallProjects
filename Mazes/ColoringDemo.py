
from Foundations.ColoredGrid import ColoredGrid
from Algorithms.RecursiveBacktracker import *
from Algorithms.Sidewinder import Sidewinder

george = RecursiveBacktracker()

grid = george.on(ColoredGrid(20,20))

start = grid.grid[round(grid.rows/2)][round(grid.columns/2)]

grid.set_distances(start.distances())

filename = "Output\coloredmaze3.png"
img = grid.to_png()
img.save(filename)
