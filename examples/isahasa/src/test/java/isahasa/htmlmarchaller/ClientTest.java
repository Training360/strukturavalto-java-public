package isahasa.htmlmarchaller;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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

		assertThat(dataSource.isGetPlainTextCalled(), is(true));

		assertThat(channel.getWriteBytesParam(), is(message.getBytes()));
		assertThat(sent, is(message.length()));
	}

}