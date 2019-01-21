package P02_FileStream;

public abstract class BaseFile {
    private int length;
    private int bytesSent;

    public BaseFile(int length, int bytesSent){
        this.length = length;
        this.bytesSent = bytesSent;
    }

    public int getLength() {
        return length == 0 ? 1 : this.length;
    }

    public int getBytesSent() {
        return bytesSent;
    }
}
