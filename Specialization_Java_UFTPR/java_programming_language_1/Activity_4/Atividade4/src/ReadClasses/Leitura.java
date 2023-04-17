package ReadClasses;

import java.util.Scanner;

public class Leitura {
    public static String entDados(String dadoRecebido){
        if(dadoRecebido.isBlank()){
            return "0";
        }
        return dadoRecebido;
    }
}
