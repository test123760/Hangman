package hangmangame;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    
    String randomWord = generateRandomWord(10);
    String lettersLine = new String(new char[randomWord.length()]).replace("\0", "-");
    int count = 0;

    public void main(String[] args) {
                Scanner s = new Scanner(System.in);
		while (count < 7 && lettersLine.contains("-")) {
			message("Guess any letter in the word");
			message(lettersLine);
			String guessWord = s.next();
			hangCharachter(guessWord);
		}
		s.close();
    }
void hangCharachter(String guessWord) {
		String newLettersLine = "";
		for (int i = 0; i < randomWord.length(); i++) {
			if (randomWord.charAt(i) == guessWord.charAt(0)) {
				newLettersLine += guessWord.charAt(0);
			} else if (lettersLine.charAt(i) != '*') {
				newLettersLine += randomWord.charAt(i);
			} else {
				newLettersLine += "*";
			}
		}
		if (lettersLine.equals(newLettersLine)) {
			count++;
			hangmanLife();
		} else {
			lettersLine = newLettersLine;
		}
		if (lettersLine.equals(randomWord)) {
			message("Congratulations! you guessed the right word. You win! The word was " + randomWord);
		}
	}
	void hangmanLife() {
            int count = 7;
            switch(count)
            {
                case 1:
                    message("Wrong guess, try again");
                    message("Player Life Remaining: 10");
                    break;
                case 2:
                    message("Wrong guess, try again");
                    message("Player Life Remaining: 8");
                    break;
                case 3:
                    message("Wrong guess, try again");
                    message("Player Life Remaining: 6");
                    break;
                case 4:
                    message("Wrong guess, try again");
                    message("Player Life Remaining: 4");
                    break;
                case 5:
                    message("Wrong guess, try again");
                    message("Player Life Remaining: 2");
                    break;
                case 6:
                    message("Wrong guess, try again");
                    message("Player Life Remaining: 1");
                    break;
                case 7:
                    message("Game Over!");
                    message("Player Hanged");
                    break;
            }
	}
        String generateRandomWord(int wordLength) {
                Random r = new Random();
                StringBuilder sb = new StringBuilder(wordLength);
                for(int i = 0; i < wordLength; i++) { 
                    char tmp = (char) ('a' + r.nextInt('z' - 'a'));
                    sb.append(tmp); 
                }
                return sb.toString();
        }
        void message(String inputMessage)
        {
            System.out.println(inputMessage);
        }
}

