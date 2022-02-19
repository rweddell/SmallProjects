from random import randint, choice
import string


screen = ""
alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g','h', 'i', 'j', 'k','l', 'm','n','o','p','q','r','s','t','u','v','w', 'x','y','z']
vowels = ['a','e','i','o','u']
for i in range(200):
    screen = screen + choice(alphabet)
    if randint(0,10) == 5:
        screen = screen + choice(vowels)
    if randint(0,5) == 2:
        screen = screen + ' '

print(screen) 