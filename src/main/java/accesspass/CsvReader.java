package accesspass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CsvReader {
	private HashMap<String, String>user_pass;
	public String get_password(String user)
	{
		return user_pass.get(user);
	}
	public CsvReader(String name)
	{
		String line;
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(name));
			while((line = bf.readLine()) != null)
			{
				String[] user_pass_sp;
				user_pass_sp = line.split(",");
				user_pass.put(user_pass_sp[0], user_pass_sp[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
