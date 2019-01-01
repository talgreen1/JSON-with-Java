package _04_formatting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Random;
import java.util.Scanner;

/**
 * Write guess the number game: The user should guess a choosen number between 1 and 100.
 * The user should type guesses and for each incorrect guess he should get a hit: if the guess was too high or too low.
 *
 * The game stops when:
 * - The user guessed the correct number
 * - The user typed -99
 *
 * The game should be able to give a JSON with the results. For example:
 *
 * {
 * 	"numberToGuess":15,
 * 	"numberOfGuesses":4,
 * 	"guesses":[10, 20, 14,15]
 * }
 */
public class Exe_05 {


}
