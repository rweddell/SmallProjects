
from Foundations.Grid import Grid
from Algorithms.AldousBroder import AldousBroder


lester = AldousBroder()

grid = lester.on(Grid(10, 10))

print(grid)

img = grid.to_png()

img.save("mazeimage.png")