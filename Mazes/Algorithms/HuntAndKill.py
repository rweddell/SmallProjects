
from random import choice

class HuntAndKill:

    def on(self, grid):
        current = grid.random_cell()
        while current:
            unvisited = []
            for neighbor in current.neighbors():
                unvisited.append(neighbor)
            if unvisited:
                neighbor = choice(unvisited)
                current.link(neighbor)
                current = neighbor
            else:
                current = None
                for cell in grid.each_cell():
                    visited = []
                    for neighbor in cell.neighbors():
                        visited.append(neighbor)
                    if not cell.links and visited:
                        current = cell
                        tolink = choice(visited)
                        current.link(tolink)
        return grid
