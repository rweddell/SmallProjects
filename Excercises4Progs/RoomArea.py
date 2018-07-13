
"""
57 Excercises for Programmers
Excercise 7: Area of a Rectangular Room
Rob Weddell
"""

import math
import tkinter as tk
from tkinter import *

con_factor = 0.09290304
scale = 'feet'
converted = 'meters'

def slide(position):
	global scale
	global converted
	if position == '0':
		scale = 'feet'
		converted = 'meters'
	elif position == '1':
		scale = 'meters'
		converted = 'feet'
		
def calc_area(length, width):
	return length * width

def convert(measure):
	global converted
	if converted == 'meters':
		result = measure/con_factor
	elif converted == 'feet':
		result = measure * con_factor
	return result

def click():
	length = len_entry.get()
	width = wid_entry.get()
	try:
		length = float(length)
		width = float(width)
		area = calc_area(length, width)
	except:
		area = 0
	diplay_result(area)
		
def diplay_result(area):
	area_out.delete(0.0, END)
	convert_out.delete(0.0, END)
	area_out.insert(END, '{:,.2f}'.format(area))
	convert_out.insert(END, '{:,.2f}'.format(convert(area)))
		
		
root = tk.Tk()
root.title("Room Area Converter")
root.minsize(300, 250)
root.configure(background = 'grey')
Label(root, bg = 'grey').grid(row=0, column=0, sticky=W)

#information collection
len_label = Label(root, text = "Length of room:", bg = "grey", fg = 'white', font = 'none 12 bold')
len_label.grid(row = 1, column = 0, sticky = W)

wid_label = Label(root, text = 'Width of room:', bg = 'grey', fg = 'white', font = 'none 12 bold')
wid_label.grid(row = 2, column = 0, sticky = W)

len_entry = Entry(root, width = 10, bg = 'white')
len_entry.grid(row = 1, column = 1, sticky = W)

wid_entry = Entry(root, width = 10, bg = 'white')
wid_entry.grid(row = 2, column = 1, sticky = W)

#slider and button
submit = Button(root, text = "SUBMIT", width = 6, command = click)
submit.grid(row = 4, column = 1, sticky = W)

scale_label = Label(root, text = 'Feet=0 Meters=1', bg = 'grey', fg = 'white', font = 'none 12 bold')
scale_label.grid(row = 3, column = 0, sticky = W)

feetormeters = Scale(root, from_ = 0, to = 1, bg = 'grey', bd = 0, command = slide, tickinterval = 1, orient = HORIZONTAL, )
feetormeters.grid(row = 4, column = 0, sticky = W)

#information display
area_label = Label(root, text = "Area of room:", bg = "grey", fg = 'white', font = 'none 12 bold')
area_label.grid(row = 6, column = 0, sticky = W)

convert_label = Label(root, text = "Area of room converted:", bg = "grey", fg = 'white', font = 'none 12 bold')
convert_label.grid(row = 7, column = 0, sticky = W)

area_out = Text(root, width = 10, height = 1, background = 'white')
area_out.grid(row = 6, column = 1, sticky = W)

convert_out = Text(root, width = 10, height = 1, background = 'white')
convert_out.grid(row = 7, column = 1, sticky = W)


root.mainloop()








