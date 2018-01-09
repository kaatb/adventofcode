package adventofcode.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spiral {

    public static void main(String[] args) throws IOException {
        Integer squareInput = getSquareInput();
        System.out.println(new ManhattanDistanceResolver().resolve(squareInput));
        System.out.println(new SpiralSumMemory(squareInput).findElementWithValueBiggerThan(squareInput));
    }

    private static Integer getSquareInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter square number");
        return Integer.parseInt(br.readLine());
    }
}
