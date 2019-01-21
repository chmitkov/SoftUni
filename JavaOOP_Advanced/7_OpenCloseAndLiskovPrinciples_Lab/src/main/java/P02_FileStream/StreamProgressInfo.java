package P02_FileStream;

public class StreamProgressInfo {
    private BaseFile baseFile;

    public StreamProgressInfo(BaseFile file) {
        this.baseFile = file;
    }

    public int calculateCurrentPercent() {
        return (this.baseFile.getBytesSent() * 100) / this.baseFile.getLength();
    }
}
