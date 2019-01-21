package P02_FileStream;

public class Music extends BaseFile{

    private String artist;
    private String album;

    public Music(int length, int bytesSent) {
        super(length, bytesSent);
    }

    public int getLength() {
        return super.getLength();
    }

    public int getBytesSent() {
        return super.getBytesSent();
    }
}
