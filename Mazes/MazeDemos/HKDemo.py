
from Foundations.Grid import Grid
from Algorithms.HuntAndKill import HuntAndKill as hk

jeremy = hk()

grid = jeremy.on(Grid(20, 20))

img = grid.to_png()

img.save("hk.png")
