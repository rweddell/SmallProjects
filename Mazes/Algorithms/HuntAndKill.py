
class HuntAndKill:

    def on(self, grid):
        current = grid.random_cell()
        while current:
            unvisited = current.neighbors