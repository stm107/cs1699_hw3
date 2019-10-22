import java.io.*;
import java.util.*;

public class WordCountSLOW{

	public static void main(String[] args) throws Exception{
		long start_time = System.currentTimeMillis();
		
		//System.out.println("Please specify text file path");
		//Scanner kbd_input = new Scanner(System.in);
		//String file_name = kbd_input.nextLine();
		HashMap<String, Integer> word_count = new HashMap<String, Integer>();
		String[] file_list = {"completeWorksShakespear_X2.txt", "warAndPeace_X3.txt", "mobyDick_X16.txt"};
		

		for(int i = 0; i < file_list.length; i++){

			BufferedReader get_lines = new BufferedReader(new FileReader(file_list[i]));
			while(get_lines.ready()){
				
				String cur_line = get_lines.readLine();
				StringTokenizer token_line = new StringTokenizer(cur_line, " .:?!<>(){}[],;\"");
				while(token_line.hasMoreTokens()){
					String cur_token = token_line.nextToken();
					if(word_count.containsKey(cur_token)){
						int old_value = word_count.get(cur_token);
						word_count.replace(cur_token, old_value + 1);
					}
					else{
						word_count.put(cur_token, 1);
					}

				} 
				
			}
		}
		long total_time = System.currentTimeMillis() - start_time;
		System.out.println(total_time);
	}

}