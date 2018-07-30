
class Distances:

    def __init__(self, root):
        self.root = root
        self.cells = {}
        self.cells[root] = 0
        self.max_path()
        self.max_dist = 0

    def __getitem__(self, item):
        return self.cells[item]

    def keys(self):
        return self.cells.keys()

    def get_dist(self, cell):
        return self.cells[cell]
        
    def set_distance(self, cell, distance):
        self.cells[cell] = distance
        
    def get_cells(self):
        return self.cells.keys()

    def path_to(self, goal):
        current = goal
        path = Distances(self.root)
        path.cells[current] = self.cells[current]
        while current is not self.root:
            for neighbor in current.links:
                if self.cells[neighbor] < self.cells[current]:
                    path.cells[neighbor] = self.cells[neighbor]
                    current = neighbor
                    break
        return path
    
    def max_path(self):
        max_dist = 0
        max_cell = self.root
        for cell in self.cells.keys():
            if self.cells[cell] > max_dist:
                max_cell = cell
                max_dist = self.cells[cell]
        self.max_dist = max_dist
        return (max_cell, max_dist)
