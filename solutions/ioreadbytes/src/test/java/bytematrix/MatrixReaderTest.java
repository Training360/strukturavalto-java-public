package bytematrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixReaderTest {
    MatrixReader matrixReader = new MatrixReader();


    @Test
    public void readBytesAndCreateMatrixTest() {
        assertEquals(0, matrixReader.getMyMatrix().size());
        matrixReader.readBytesAndCreateMatrix("matrix.dat");

        assertEquals(9, matrixReader.getMyMatrix().size());
        assertEquals(1000, matrixReader.getMyMatrix().get(5).length);
    }


    @Test
    public void numberOfColumnsWhereMoreZeros() {
        matrixReader.readBytesAndCreateMatrix("matrix.dat");
        assertEquals(493, matrixReader.numberOfColumnsWhereMoreZeros());
    }

}
