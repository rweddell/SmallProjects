
"""
Creates a simple solution to a maze using 
Dijkstra's algorithm.
"""

from Foundations.DistanceGrid import DistanceGrid
from Algorithms.AldousBroder import AldousBroder
from Algorithms.BinaryTree import BinaryTree

larry = AldousBroder()

grid = larry.on(BinaryTree(5, 5))
 
start = grid.grid[0][0]
distances = start.distances()

grid.distlist = distances
print(grid.__str__())

print("Path from NW to SW")
grid.distlist = distances.path_to(grid.grid[grid.rows-1][0])

print(grid.__str__())
