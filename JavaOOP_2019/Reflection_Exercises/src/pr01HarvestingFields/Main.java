package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;

		while (!"HARVEST".equals(line=br.readLine())){
			printAllFieldsByModifier(line);
		}
	}

	private static void printAllFieldsByModifier(String line) throws ClassNotFoundException {
		String classPath  = "pr01HarvestingFields.RichSoilLand";

		Class<?> RichSoilLandClass = Class.forName(classPath);

		switch (line){
			case "private":
				Arrays.stream(RichSoilLandClass.getDeclaredFields())
						.filter(x-> Modifier.isPrivate(x.getModifiers()))
						.forEach(x-> System.out.printf("%s %s %s%n",
								Modifier.toString(x.getModifiers()),
								x.getType().getSimpleName(),
								x.getName()));
				break;
			case "protected":
				Arrays.stream(RichSoilLandClass.getDeclaredFields())
						.filter(x-> Modifier.isProtected(x.getModifiers()))
						.forEach(x-> System.out.printf("%s %s %s%n",
								Modifier.toString(x.getModifiers()),
								x.getType().getSimpleName(),
								x.getName()));
				break;
			case "public":
				Arrays.stream(RichSoilLandClass.getDeclaredFields())
						.filter(x-> Modifier.isPublic(x.getModifiers()))
						.forEach(x-> System.out.printf("%s %s %s%n",
								Modifier.toString(x.getModifiers()),
								x.getType().getSimpleName(),
								x.getName()));
				break;
			case "all":
				Arrays.stream(RichSoilLandClass.getDeclaredFields())
						.forEach(x-> System.out.printf("%s %s %s%n",
								Modifier.toString(x.getModifiers()),
								x.getType().getSimpleName(),
								x.getName()));
				break;
		}
	}
}
