
from DistanceGrid import DistanceGrid
from BinaryTree import BinaryTree

larry = BinaryTree()

grid = larry.on(DistanceGrid(5, 5))
 
start = grid.grid[0][0]
distances = start.distances()

grid.distlist = distances
print(grid.__str__())
