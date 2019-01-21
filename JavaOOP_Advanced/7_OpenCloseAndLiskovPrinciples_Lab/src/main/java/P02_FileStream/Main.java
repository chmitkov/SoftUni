package P02_FileStream;

public class Main {
    public static void main(String[] args) {

        BaseFile file = new File(10, 10);
        StreamProgressInfo streamProgressInfo = new StreamProgressInfo(file);
        System.out.println(streamProgressInfo.calculateCurrentPercent());

        BaseFile music = new Music(120,31);
        StreamProgressInfo streamProgressInfo1 = new StreamProgressInfo(music);
        System.out.println(streamProgressInfo1.calculateCurrentPercent());

    }
}
