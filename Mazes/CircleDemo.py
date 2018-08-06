
from Foundations.PolarGrid import PolarGrid
from Algorithms.RecursiveBacktracker import RecursiveBacktracker

albert = RecursiveBacktracker()
grid = albert.on(PolarGrid(10))
img = grid.to_png()
img.save('Output\circlemaze.png')