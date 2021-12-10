import java.io.IOException;

public interface IRemoteProvider {
    byte[] getData(String url) throws IOException;
}
