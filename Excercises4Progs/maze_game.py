from random import randint, choice


class Room:

    def __init__(self) -> None:
        self.left = None
        self.right = None
        self.up = None
        self.down = None

    def show_moves():
        # show the available connections for the player to move
        pass


class Maze:

    def __init__(self, height, width) -> None:
        self.height = height
        self.width = width
        self.maze = self.build_maze()

        # The player can start here
        self.start = (0,0)

        # The game ends when the player reaches this point in the maze
        self.end = (height, width)

    def build_maze(self):
        maze = [[Room() for h in range(self.height)] for w in range(self.width)]

        # This logic is incomplete, but should make random connections throughout the maze
        # Each room should have at least 1, and up to 4 connections to other rooms
        for h in self.height:
            for w in self.width:
                connect = randint(1,2)
                if connect % 2 == 0:
                    maze[h,w].connect(maze[h,w+1])

        return maze

    

    