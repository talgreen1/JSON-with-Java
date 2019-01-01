package _04_formatting;

import _03_parsing.Exe_04_Answer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Random;
import java.util.Scanner;

public class Exe_05_Answer {

    private int numberToGuess;
    private ObjectMapper mapper;
    private ArrayNode guesses;

    public Exe_05_Answer() {
        mapper = new ObjectMapper();
    }

    public void initGame() {
        numberToGuess = new Random().nextInt(99) + 1;
        guesses = mapper.createArrayNode();
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        int guess = 0;


        while (true) {
            System.out.println("Please enter your guess:");
            guess = readNumber(in);

            if (guess == -99) {
                break;
            }

            guesses.add(guess);

            if (guess == numberToGuess) {
                System.out.println("Correct!!! The number is " + numberToGuess);
                break;
            } else if (guess < numberToGuess) {
                System.out.println("You guess is to low");
            } else {
                System.out.println("Your guess is too high");
            }

        }

        in.close();
    }

    public String getResultAsJson() throws JsonProcessingException {
        ObjectNode root = mapper.createObjectNode();

        root.put("numberToGuess", numberToGuess);
        root.put("numberOfGuesses", guesses.size());
        root.set("guesses", guesses);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
    }

    private int readNumber(Scanner in) {
        String line = in.nextLine();
        return Integer.parseInt(line);
    }

    public static void main(String[] args) throws JsonProcessingException {
        Exe_05_Answer game = new Exe_05_Answer();
        game.initGame();
        game.start();

        System.out.println(game.getResultAsJson());
    }
}
