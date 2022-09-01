package hometasks.hw7stringandfileutils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class Task1Runner {
    private static final Logger LOGGER = LogManager.getLogger(Task1Runner.class);

    public static void main(String[] args) throws IOException {
        File sourceFile = new File("src/main/resources/text/from.txt");
        File targetFile = new File("src/main/resources/text/to.txt");
        String charset = "UTF-8";
        String sourceString = FileUtils.readFileToString(sourceFile, "UTF-8");

        try {
            FileUtils.write(targetFile,
                    String.valueOf(Stream.of(sourceString.split("[\\n\\r\\t .,)(;:=%≤-]+"))
                            .filter(word -> StringUtils.countMatches(sourceString, word) == 1)
                            .count()
                    ), charset);
        } catch (IOException e) {
            LOGGER.warn(e);
        }

        LOGGER.info("Unique words: " + FileUtils.readFileToString(targetFile, "UTF-8"));
    }
}
