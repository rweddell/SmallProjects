
from Grid import Grid
import random

class BinaryTree():
	
	def on(self, grid):
		for row in grid.grid:
			for cell in row:
				near = []
				if cell.north is not None:
					near.append(cell.north)
				if cell.east is not None:
					near.append(cell.east)
				if near:
					print(cell.__str__() + " " + str(near))
					#indy = random.randint(0, len(near)-1)
					#chosen = near[indy]
					chosen = random.choice(near)
					#print(cell.__str__() + " -> " + chosen.__str__())
					cell.link(chosen)
					print(cell.__str__() + "'s links are: " + str(cell.links))
		return grid
