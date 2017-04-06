package splitfile.run;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MakeTheSplit {

	public static final String PATH = "C:\\_NICO\\x\\split\\";
	public static final int COMMIT_TO_X = 500;
	
	public static void main(String[] args) {
		
		final String file = "C:\\_NICO\\x\\exportXXXX.sql";
		
		final MakeTheSplit make = new MakeTheSplit();
		
		make.readFile(file);
		
		
	}
	
	
	public void readFile(String fichier){
		
		List<String> fileTruc = new ArrayList<String>();
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String line;
			int nameFileOfSequence = 0;
			int numberOfcommit = 0;
			while ((line=br.readLine())!=null){
				fileTruc.add(line);
				if(line.equals("commit;") || line.equals("COMMIT;")){					
					
					numberOfcommit++;
					// write in file to the X commit word.
					if (numberOfcommit % COMMIT_TO_X == 0) {
						nameFileOfSequence++;
	                    //commit = true;
	                    writeFile(String.valueOf(nameFileOfSequence) , fileTruc);
						fileTruc = new ArrayList<String>();
	                }
					
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.err.println(e.toString());
		}
	}
	
	public void writeFile(String fileName, List<String> fileTruc){
		FileWriter fileWriter = null;

        try {

            fileWriter = new FileWriter(PATH+fileName+".sql", true);
            
            for (String text : fileTruc) {
            	fileWriter.append(text +System.getProperty("line.separator"));
			}           

            System.out.println("File: "+fileName+" Done!");

        } catch (final Exception e) {
        	System.err.println(e.toString());
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (final IOException e) {
            	System.err.println(e.toString());
            }

        }
	}
}
