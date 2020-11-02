package isahasa.htmlmarchaller;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    class DataSourceImpl implements TextSource {
        private boolean getPlainTextCalled;
        private String getPlainTextReturnValue;

        public DataSourceImpl(String getPlainTextReturnValue) {
            this.getPlainTextReturnValue = getPlainTextReturnValue;
        }


        public boolean isGetPlainTextCalled() {
            return getPlainTextCalled;
        }

        @Override
        public String getPlainText() {
            getPlainTextCalled = true;
            return getPlainTextReturnValue;
        }
    }

    class ChannelImpl implements Channel {
        private byte[] writeBytesParam;

        @Override
        public int writeByte(byte[] bytes) {
            writeBytesParam = bytes;
            return bytes.length;
        }

        public byte[] getWriteBytesParam() {
            return writeBytesParam;
        }
    }

    @Test
    public void writeToChannel() throws Exception {
        ChannelImpl channel = new ChannelImpl();
        final String message = "1234";
        DataSourceImpl dataSource = new DataSourceImpl(message);
        Client client = new Client(channel);

        int sent = client.writeToChannel(dataSource);

        assertTrue(dataSource.isGetPlainTextCalled());

        assertArrayEquals(message.getBytes(), channel.getWriteBytesParam());
        assertEquals(message.length(), sent);
    }

}