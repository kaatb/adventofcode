package adventofcode.day12;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Runner {

    public static void main(String[] args) throws IOException {
        List<ProgramInputLine> programInputLines = Files.readLines(new File("src/main/resources/day12.txt"), Charset.defaultCharset())
                .stream()
                .map(ProgramInputLine::new)
                .collect(toList());

        List<Program> programs = new ProgramInputParser().parse(programInputLines);
        System.out.println(new ProgramResolver(programs).findProgramsConnectedTo(0).size());
        System.out.println(new ProgramResolver(programs).findNumberOfGroups());
    }
}
