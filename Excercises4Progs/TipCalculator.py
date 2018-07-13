
"""
57 Excercises for Programmers
Excercise 0: Tip Calculator
Rob Weddell
"""

import tkinter as tk
from tkinter import *

def click():
	billamount = billentry.get()
	tipamount = tipentry.get()
	totalout.delete(0.0, END)
	tipout.delete(0.0, END)
	try:
		billamount = float(billamount)
		tipamount = float(tipamount)
		if billamount > 0 and tipamount > 0:
			result = calc_tip(tipamount, billamount)
		else:
			result = "X"
	except:
		result = "X"
	if result != "X":
		tipout.insert(END, '$ {:,.2f}'.format(result))
		totalout.insert(END, '$ {:,.2f}'.format(result + billamount))
	else:
		tipout.insert(END, result)
		totalout.insert(END, result)
	
	
def calc_tip(tiprate, bill):
	return bill * (tiprate/100)
	

window = tk.Tk()
window.title("TipCalc")
window.minsize(270, 180)
window.configure(background = "black")

Label(window, bg = 'black').grid(row = 0, column = 0, sticky = W)

billentry = Entry(window, width = 13, bg = "white")
billentry.grid(row = 2, column = 1, sticky = W)

tipentry = Entry(window, width = 13, bg = "white")
tipentry.grid(row = 3, column = 1, sticky = W)

Button(window, text = "SUBMIT", width = 6, command = click).grid(row = 4, column = 1, sticky = W)

Label(window, text = "Enter bill amount:", bg = "black", fg = "white", font = "none 12 bold").grid(row = 2, column = 0, sticky = W)
Label(window, text = "Enter tip percentage: ", bg = "black", fg = "white", font = "none 12 bold").grid(row = 3, column = 0, sticky = W)

Label(window, text = "Tip = ", bg = "black", fg = "white", font = "none 12 bold").grid(row = 7, column = 0, sticky = W)
Label(window, text = "Total = ", bg = "black", fg = "white", font = "none 12 bold").grid(row = 8, column = 0, sticky = W)

tipout = Text(window, width = 10, height = 1, background = "white")
tipout.grid(row = 7, column = 1, sticky = W)

totalout = Text(window, width = 10, height = 1, background = "white")
totalout.grid(row = 8, column = 1, sticky = W)

window.mainloop()
