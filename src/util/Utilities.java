package util;
import java.util.List;

//Método que imprime cualqueir tipo de elemento
public class Utilities {
    public static <T> void printElements(List<T> list){
        for (T element : list){
            System.out.println(element);
        }
    }
}
