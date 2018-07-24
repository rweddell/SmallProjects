
from Foundations.ColoredGrid import ColoredGrid
from Algorithms.AldousBroder import AldousBroder
from Algorithms.Wilsons import Wilsons
from Algorithms.HuntAndKill import HuntAndKill as hk

george = hk()

grid = george.on(ColoredGrid(20,20))

start = grid.grid[round(grid.rows/2)][round(grid.columns/2)]

grid.set_distances(start.distances())

filename = "coloredmaze.png"
img = grid.to_png()
img.save(filename)
