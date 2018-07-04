package Modelo;


public class Tools {
    static public String converterURL(String URL){
        String pagina = new String();
        for(int i=URL.length()-1; URL.charAt(i) != '/'; i--) pagina = URL.charAt(i) + pagina;
        return pagina;
    }
}
