
from DistanceGrid import DistanceGrid
from BinaryTree import BinaryTree

grid = DistanceGrid(5, 5)

edgar = BinaryTree()

start = grid.grid[0][0]

distances = start.distances()

newstart, distance = distances.max_path()

newdist = newstart.distances()
goal, distance = newdist.max_path()

grid.distances = newdist.path_to(goal)
print(grid)