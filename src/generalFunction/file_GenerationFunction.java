package generalFunction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class file_GenerationFunction {
	
	public static void filegenerator(String filename,String responseBody) throws IOException {
		
		File newfile=new File("G:\\restFile\\get\\"+filename+".txt");
		
		System.out.println("a new file generated to save the response :"+newfile.getName());
		
		FileWriter datawrite=new FileWriter(newfile);
		datawrite.write("response body"+responseBody);
		datawrite.close();
		
		System.out.println("responseBody parameter saved in :"+newfile.getName());
		
		
		
	}

}
