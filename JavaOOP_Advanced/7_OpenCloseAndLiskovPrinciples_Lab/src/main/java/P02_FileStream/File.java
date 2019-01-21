package P02_FileStream;

public class File extends BaseFile {

    private String name;

    public File(int length, int bytesSent) {
        super(length, bytesSent);
    }

    public int getLength() {
        return super.getLength();
    }

    public int getBytesSent() {
        return super.getBytesSent();
    }
}
