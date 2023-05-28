package testCase;

import endPoint.URL;
import generalFunction.API_generalFunction;
import generalFunction.file_GenerationFunction;
import io.restassured.path.json.JsonPath;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
public class test1 {
	@Test
	
	public static void execute() throws IOException {
		
		// step1 call the baseURI from URL method and save into variable
		String baseURI=URL.goibibo_BaseURI();
		String resource=URL.goibibo_resource();
		
		
		//step2 configure the response by calling method present in API_generalFunction class and save into variable
		int statusCode=API_generalFunction.res_statusCode(baseURI, resource);
		String responseBody=API_generalFunction.res_responseBody(baseURI, resource);
		System.out.println(responseBody);
		
		
		//step3 expeceted reslut in the response
		String [] iata= {"GOI","GOX"};
		String [] n= {"Goa Dabolim International Airport","Goa (North) - Manohar International Airport"};
		String [] ct= {"Goa - Dabolim Airport","Goa (North)"};
		
		
		// step4 fetch the responseBody  
	    JsonPath resjsp=new JsonPath(responseBody);
	    int count =resjsp.getList("r").size();
	    System.out.println(count);
	    
	    
	    
	    for (int i=0; i<count ; i++) 
	    {
	    	//step5  parse the expected result parameter and save in variable
	    	String exp_iata=iata[i];
	    	String exp_n=n[i];
	    	String exp_ct=ct[i];
	    	
	    	
	    	//step6 save the responseBody parameter in variable
	    	String res_iata=resjsp.getString("r["+i+"].iata");
	    	String res_n=resjsp.getString("r["+i+"].n");
	    	String res_ct=resjsp.getString("r["+i+"].ct");
	    	
	    	
	    	//step7 validate the parameter
	    	Assert.assertEquals(statusCode, 200);
	    	Assert.assertEquals(res_iata,exp_iata);
	    	Assert.assertEquals(res_n, exp_n);
	    	Assert.assertEquals(res_ct, exp_ct);
	 	    	
	    
	    }
	  
	    file_GenerationFunction.filegenerator("test1", responseBody);	
	}

	

}
