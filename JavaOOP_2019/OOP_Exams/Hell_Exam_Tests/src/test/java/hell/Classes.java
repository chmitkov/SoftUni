package hell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Classes {

    public static HashMap<String, Class<?>> allClasses = new HashMap<>();

    static {
        try {
            initClasses();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initClasses() throws IOException {
        String basePath = System.getProperty("user.dir");
        String dir = basePath + "/src/main/java/";
        Files.walk(Paths.get(dir))
                .filter(f -> {
                    boolean a = f.getFileName().toString().endsWith(".java");
                    return a;
                })
                .forEach(f -> {
                    try {
                        System.out.println(f.getParent().toString());
                        String packageR = f.getParent().toString().replaceAll("(.*?src\\\\main\\\\java\\\\?)","");
                        packageR = packageR.replaceAll("\\\\|/",".");
                        String fl = f.getFileName().toString().replaceAll("\\.java","");
                        allClasses.put(fl,Class.forName((!packageR.equals("") ? packageR + ".": "") + fl));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
    }

}
