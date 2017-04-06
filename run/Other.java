package splitfile.run;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Other {
	
	public static void main(String[] args) {
		String code = "F_X3566.000 ";
        String number = getStringOfRegulareExpressionPattern(code, "[a-z]*");

        System.out.println("?§: "+number);
	}
	
	
	public static String getStringOfRegulareExpressionPattern(String string, String pattern)
            throws PatternSyntaxException {
        
        // Pattern : permet d'obtenir une version compilée d'une expression
        // régulière.
        final Pattern p = Pattern.compile(pattern);
        final String enter = string;
        // Matcher : permet d'analyser une chaîne en entrée à partir d'un
        // Pattern.
        final Matcher m = p.matcher(enter);
        final StringBuffer buffer = new StringBuffer();
        while (m.find()) {
                buffer.append(enter.substring(m.start(), m.end()));
           
        }

        return buffer.toString();
    }

}
