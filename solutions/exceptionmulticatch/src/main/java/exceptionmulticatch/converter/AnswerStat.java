package exceptionmulticatch.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AnswerStat {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerStat.class);

    private BinaryStringConverter converter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.converter = binaryStringConverter;
    }

    public int answerTruePercent(String answers) {
        boolean[] booleans = convert(answers);
        int numberOfTrue = 0;
        for (int j = 0; j < booleans.length; j++) {
            if (booleans[j]) {
                numberOfTrue++;
            }
        }
        return (int)Math.round((double)numberOfTrue / booleans.length * 100);
    }

    public boolean[] convert(String checkboxes) {
        try {
            return converter.binaryStringToBooleanArray(checkboxes);
        } catch (NullPointerException | IllegalArgumentException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new InvalidBinaryStringException(ex);
        }
    }

}
