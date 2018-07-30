
from Foundations.Grid import Grid
from PIL import Image, ImageDraw
from math import *

class PolarGrid(Grid):

    def __init__(self, rows, columns):
        super().__init__(rows, columns)

    def to_png(self, cellsize=10):
        imgsize = 2 * self.rows * cellsize
        bg = (255, 255, 255)
        wall = (0, 0, 0)
        img = Image.new('RGBA', (imgsize+1, imgsize+1), bg)
        drw = ImageDraw.Draw(img)
        center = imgsize/2
        drw.ellipse([(0, 0), (imgsize, imgsize)], outline=wall, fill=bg)

        for cell in self.each_cell():
            theta = (2 * pi)/self.grid[cell.row].__len__()
            inner_radius = cell.row * cellsize
            outer_radius = (cell.row + 1) * cellsize
            theta_ccw = cell.column * theta
            theta_cw = (cell.column+1) * theta

            ax = center + round(inner_radius * cos(theta_ccw))
            ay = center + round(inner_radius * sin(theta_ccw))
            bx = center + round(outer_radius * cos(theta_ccw))
            by = center + round(outer_radius * sin(theta_ccw))
            cx = center + round(inner_radius * cos(theta_cw))
            cy = center + round(inner_radius * sin(theta_cw))
            dx = center + round(outer_radius * cos(theta_cw))
            dy = center + round(outer_radius * sin(theta_cw))

            if not cell.is_linked(cell.north):
                # TODO: Understand the trig to get PIL.arc to work
                #drw.arc([(bx, by), (dx, dy)], theta_ccw, theta_ccw + by - dy, fill=wall)
                drw.line([(ax, ay), (cx, cy)], fill=wall, width=2)
            if not cell.is_linked(cell.east):
                drw.line([(cx, cy), (dx, dy)], fill=wall, width=2)

        return img


