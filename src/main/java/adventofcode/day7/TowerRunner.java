package adventofcode.day7;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TowerRunner {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readLines(new File("src/main/resources/day7.txt"), Charset.defaultCharset());
        List<ProgramInputLine> programInputLines = lines.stream().map(ProgramInputLine::new).collect(toList());

        List<Program> programList = new ProgramCreator().createAllPrograms(programInputLines);
        new ProgramLinker().linkPrograms(programInputLines, programList);
        Program baseProgram = findBaseProgram(programList);

        System.out.println(baseProgram.getName());
    }

    private static Program findBaseProgram(List<Program> programList) {
        return programList.stream()
                .filter(Program::hasPrograms)
                .filter(program -> programList.stream().filter(parentProgram -> parentProgram.hasProgram(program)).count() == 0)
                .findFirst()
                .get();
    }
}
