package _03_parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Write code to parse the file "jsonFiles/exe4.json" and return list of all the y's values of all the points in the
 * odd locations.
 *
 * You can run the test in the class "Exe_04_Test" to verify your code.
 *
 * For example: for the following JSON:
 * {
 *   "points": [
 *     {
 *       "x": 10,
 *       "y": 13
 *     },
 *     {
 *       "x": 34,
 *       "y": 109
 *     },
 *     {
 *       "x": 11,
 *       "y": 68
 *     },
 *     {
 *       "x": 223,
 *       "y": 309
 *     }
 *   ]
 * }
 *
 * the expected list should be: [13, 68]
 */
public class Exe_04 {
    public List<Integer> getYOfOddPoints() throws IOException {
       return null;

    }
}
