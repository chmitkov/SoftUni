import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class _5FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> dict = new LinkedHashMap<>();
        int namesCount = Integer.parseInt(br.readLine());
        while (namesCount-- > 0) {
            String[] pair = br.readLine().split(", ");
            dict.putIfAbsent(pair[0], Integer.valueOf(pair[1]));
        }
        String[] arr = new String[3];
        arr[0] = br.readLine();  //this is condition
        arr[1] = br.readLine();  // this is age
        arr[2] = br.readLine(); //this is type

        BiFunction<String[],Map<String,Integer>,Map<String,Integer>> sortMapByConditions =
                (currArr,map) -> {
                    Map<String,Integer> sortedMap = new LinkedHashMap<>();
                    if ("older".equals(currArr[0])){
                        map.entrySet().forEach(pair->{
                            if (pair.getValue()>=Integer.valueOf(currArr[1]))
                                sortedMap.put(pair.getKey(),pair.getValue());
                        });
                    }else{
                        map.entrySet().forEach(pair->{
                            if (pair.getValue()< Integer.valueOf(currArr[1]))
                                sortedMap.put(pair.getKey(),pair.getValue());
                        });
                    }
                    return sortedMap;
                };
        BiConsumer<String, Map<String,Integer>> printByFormat  =
                (currentCondition,map )->{
                                switch (currentCondition){
                                    case "name age":
                                        map.entrySet().forEach(
                                                x-> System.out.printf("%s - %d%n",x.getKey(),x.getValue()));
                                        break;
                                    case "name":
                                        map.keySet().forEach(System.out::println);
                                        break;
                                    case "age":
                                        map.values().forEach(System.out::println);
                                        break;
                                }
                };

        dict = sortMapByConditions.apply(arr,dict);
        printByFormat.accept(arr[2],dict);


    }
}
