package hometasks.hw7stringandfileutils;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Task2Runner {
    private static final Logger LOGGER = LogManager.getLogger(Task2Runner.class);

    public static void main(String[] args) throws IOException {
        File messi = new File("src/main/resources/text/testFiles/messi.txt");
        String text = FileUtils.readFileToString(messi, "UTF-8");
        File csv = new File("src/main/resources/text/testFiles/csv.txt");

        String textUpperCase = text.toUpperCase();
        LOGGER.info(textUpperCase);

        String textLowerCase = text.toLowerCase();
        LOGGER.info(text);

        String textUnderScore = text.replaceAll(" ", "_");
        LOGGER.info(textUnderScore);
        LOGGER.info(textUnderScore.isEmpty());
        LOGGER.info(textUnderScore.isBlank());
        LOGGER.warn(StringUtils.remove(textLowerCase, 'o'));
        LOGGER.info("Times Messi is mentioned: " + StringUtils.countMatches(textUnderScore, "Messi"));

        LOGGER.info("The difference of characters in uppercase and lower case texts are:" +
                textLowerCase.compareTo(textUpperCase));

//        Stream<String> stringStream = Files.lines(Paths.get(messi))){
//            stringStream
//                    .filter(s -> s.startsWith("m"))
//                    .sorted()
//                    .map(String::toUpperCase)
//                    .count();
//        }
        //ArrayList<String> csvString = new ArrayList<>(StringUtils.split(csv,',')));

    }

}
