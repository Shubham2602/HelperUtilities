import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

public class LetsChangeLog4j {

	static String str = "Level=10";
	static String orig_str = "";
	static String configFile = "log4j.properties";
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(new File(configFile));

		while (scan.hasNextLine()) {
			orig_str = orig_str + scan.nextLine() + "\n";
		}

		scan.close();
		System.out.println("Original : " + orig_str);

		FileWriter fwriter = new FileWriter(new File(configFile), true);

		BufferedWriter bwriter = new BufferedWriter(fwriter);

		bwriter.append(str);

		bwriter.close();
		fwriter.close();

		getValue();

		setBack(orig_str, str);

		getValue();

	}

	public static void setBack(String orig_str, String str) throws Exception {
		System.out.println("Str : " + str);
		System.out.println("Orig : " + orig_str);
		
		
		Scanner sc = new Scanner(new File(configFile));
		FileWriter fwriter = null;
		BufferedWriter bwriter = null;
		while (sc.hasNextLine()) {
			fwriter = new FileWriter(new File(configFile));

			bwriter = new BufferedWriter(fwriter);

			if (sc.nextLine().contains(str)) {
				bwriter.write(orig_str);
			}
		}
		bwriter.close();
		fwriter.close();
		sc.close();
	}

	public static void getValue() throws Exception {
		
		FileInputStream fis = new FileInputStream(new File("log4j.properties"));

		Properties prop = new Properties();
		prop.load(fis);

		System.out.println(prop.getProperty("Level"));
	}
}
