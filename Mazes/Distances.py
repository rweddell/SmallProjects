
class Distances:

	root = None
	cells = {}

	def __init__(self, root):
		self.root = root
		self.cells = {}
		self.cells[root] = 0
		
	def get_dist(self, cell):
		"""
		this is where the book overrides [] for ruby
		"""
		return self.cells[cell]
		
	def set_distance(self, cell, distance):
		"""
		this is where the book overrides []= for ruby
		"""
		self.cells[cell] = distance
		
	def get_cells(self):
		return self.cells.keys()
		