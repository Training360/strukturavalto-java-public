package exceptions.faults;

public enum ProcessingResult {
    NO_ERROR(0), COMMENT(1), WORD_COUNT_ERROR(2), VALUE_ERROR(4), DATE_ERROR(8), VALUE_AND_DATE_ERROR(12);

    private int code;

    ProcessingResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
