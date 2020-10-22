package statemachine.typewriter;

public enum TypeWriterState {
    UPPERCASE {
        TypeWriterState next() {
            return TypeWriterState.LOWERCASE;
        }
    },
    LOWERCASE {
        TypeWriterState next() {
            return TypeWriterState.UPPERCASE;
        }

    };

    abstract TypeWriterState next();
}
