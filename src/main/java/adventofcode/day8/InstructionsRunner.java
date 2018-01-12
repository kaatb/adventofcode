package adventofcode.day8;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InstructionsRunner {

    public static void main(String[] args) throws IOException {
        List<InstructionLine> instructionLines = Files.readLines(new File("src/main/resources/day8.txt"), Charset.defaultCharset())
                .stream()
                .map(InstructionLine::new)
                .collect(toList());

        InstructionExecutor instructionExecutor = new InstructionExecutor();
        instructionExecutor.execute(instructionLines);
        System.out.println(instructionExecutor.findRegisterWithLargestValue());
        System.out.println(instructionExecutor.findRegisterWithLargestHistoricalValue().getMaxValue());
    }
}
