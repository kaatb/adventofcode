package adventofcode.day6;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class MemoryReallocationRunner {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readLines(new File("src/main/resources/day6.txt"), Charset.defaultCharset());

        List<MemoryBank> memoryBanks = stream(lines.get(0).split("\t"))
                .mapToInt(Integer::parseInt)
                .mapToObj(MemoryBank::new)
                .collect(toList());

        MemoryReallocationResult reallocationResult = new MemoryBankReallocator().reallocateUntilHistoryRepeatsItself(memoryBanks);
        System.out.println(reallocationResult.getNumberOfCycles());
        System.out.println(reallocationResult.getLoopSize());
    }
}
