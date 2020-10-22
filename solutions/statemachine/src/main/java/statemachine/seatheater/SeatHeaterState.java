package statemachine.seatheater;

public enum SeatHeaterState {
    OFF {
        SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    },
    THREE {
        SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }

    },
    TWO {
        SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }

    },
    ONE {
        SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }

    };

    abstract SeatHeaterState next();

}
