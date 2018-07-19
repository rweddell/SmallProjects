
class Distances:

    def __init__(self, root):
        self.root = root
        self.cells = {}
        self.cells[root] = 0
        
    def get_dist(self, cell):
        """
        This is where the book overrides [] for ruby
        """
        return self.cells[cell]
        
    def set_distance(self, cell, distance):
        """
        This is where the book overrides []= for ruby
        """
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
        for cell in self.cells.keys():   #TypeError: 'Cell' object is not iterable
            if self.cells[cell] > max_dist:
                max_cell = cell
                max_dist = self.cells[cell]
        return (max_dist, max_cell)
        