package splitfile.run;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunSql {
	
	
	public static void main(String argv[]) {
		RunSql runs = new RunSql();
		for (int i = 1; i <= 190; i++) {
			runs.runScript(i);
		}
	  }
	
	public void runScript(int scripfile){
		 try {
		      String line;
		      Process p = Runtime.getRuntime().exec
		        ("psql -U XXXX_DBA -d XXXX_DBA -h localhost -f "+MakeTheSplit.PATH+scripfile+".sql");
		      BufferedReader input =
		        new BufferedReader
		          (new InputStreamReader(p.getInputStream()));
		      while ((line = input.readLine()) != null) {
		        System.out.println(line);
		      }
		      input.close();
		    }
		    catch (Exception err) {
		      err.printStackTrace();
		    }
		
	}

}
