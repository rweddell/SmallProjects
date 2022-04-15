import time
import random



class Player:

    def __init__(self, number) -> None:
        self.number = number

    def __repr__(self) -> str:
        return str(self)

    def __str__(self) -> str:
        return f'Player{self.number}'

    def say_number(self):
        number = random.randint(1,4)
        print(f'Player {self.number} says {number}')
        return number


class TheGame:

    def __init__(self) -> None:
        self.player1 = Player(1)
        self.player2 = Player(2)
        self.score = 0

    def start_ai_game(self):
        self.score = 0
        current_player = self.player1
        while self.score < 11: 
            if current_player.number == 1:
                current_player = self.player2
            else:
                current_player = self.player1
            self.score += current_player.say_number()
            time.sleep(1)
        
        print(f'{current_player} wins with a score of {self.score}!')

    def start_pc_game(self):

        self.score = 0

        def ask_number():
            try:
                num = int(input('1->4: '))
                if num < 1 or num > 4:
                    raise Exception
                return num
            except:
                return False

        player_turn = False
        while self.score < 11:

            if player_turn:
                result = ask_number()
                while not result:
                    print(result, not result, result==False, result is False)
                    result = ask_number()
                self.score += result
                player_turn = False
            else: 
                self.score += self.player1.say_number()
                player_turn = True

        if player_turn == False:
            print(f'You win with a score of {self.score}')
        else:
            print(f'You lose with a score of {self.score}!')

# down here you should initialize an instance of TheGame and call it's start_game function
the_game = TheGame()

# the_game.start_ai_game()
the_game.start_pc_game()