
package utilidades;

import java.util.regex.*;

public class Utilidades {
    
    public static boolean esValido(String correo) {
        
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher validador = patron.matcher(correo);
        return validador.find();
    }
}
