
from Cell import Cell
from random import randint

class Grid(object):
	
	rows = 0
	columns = 0
	grid = []
	
	def __init__(self, rows, columns):
		self.rows = rows
		self.columns = columns
		self.prepare_grid()
		self.configure_cells()
		
	def prepare_grid(self):
		self.grid = [[0 for x in range(self.rows)] for y in range(self.columns)]
		for i in range(0, self.rows):
			for j in range(0, self.columns):
				self.grid[i][j] = Cell(i, j)
	
	def configure_cells(self):
		for line in self.grid:
			for cell in line:
				row, col = cell.row, cell.column 
				cell.north = self.borders(row - 1, col)
				cell.south = self.borders(row + 1, col)
				cell.east = self.borders(row, col + 1)
				cell.west = self.borders(row, col - 1)
				
	def borders(self, row, column):
		if row > self.rows - 1 or row < 0:
			return None
		if column > self.columns - 1 or column < 0:
			return None
		else:
			return self.grid[row][column]
	
	def random_cell(self):
		return self.grid[randint(0,rows)][randint(0, columns)]
		
	def size(self):
		return self.rows * self.columns
		
	def each_row(self):
		for row in self.grid:
			yield row
	
	def each_cell(self):
		for row in self.each_row():
			for cell in row:
				yield cell
	
	def __str__(self):
		output = "+" + "---+" * self.columns + "\n"
		for row in self.each_row():
			line = "|"
			bottom = "+"
			#accum = ""
			for cell in row:
				#accum += "+"
				body = "   "
				east_bound = "|"
				south_bound = "---"
				corner = '+'
				if cell.is_linked(cell.east) == True:
					#print("east " + str(cell.is_linked(cell.east)))
					east_bound = " " 
				line = line + body + east_bound
				if cell.is_linked(cell.south) == True:
					#print("south " + str(cell.is_linked(cell.south)))
					south_bound = "   "
				bottom = bottom + south_bound + corner
			#print(accum)
			output = output + line + "\n" + bottom + "\n"
		return output
		