package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.*;

public class Main
{
    public static void main( String[] args ) {
        System.out.println("Unisite brojeve u listu (ako zelite zaustaviti unos, unesite stop): ");
        List lista = new ArrayList();
        for (;;) {
            Scanner ulaz = new Scanner (System.in);
            if (ulaz.hasNextDouble()) {
                double n = ulaz.nextDouble();
                lista.add(n);
            }
            else if (ulaz.hasNextLine()) {
                String b = ulaz.nextLine();
                if (b.equals("stop")) {
                    break;
                }
            }
        }
        if (!lista.isEmpty()) {
            Double sum = new Double(0);
            for (int i = 0; i < lista.size(); i++) {
                sum += (Double) lista.get(i);
            }
            Double srednjaVrijednost =sum/lista.size();
            Double pomocnaVarijabla = new Double(0);
            for(Object num: lista) {
                pomocnaVarijabla += Math.pow((Double) num - srednjaVrijednost, 2);
            }

            Double standardnaDevijacija = Math.sqrt(pomocnaVarijabla/lista.size());

            Double median = new Double(0);

            sort(lista);

            if (lista.size()%2 == 1) {
                Integer indeks = ((lista.size()+1)/2)-1;
                median = (Double) lista.get(indeks);
            } else {
                Integer indeks1 = (lista.size()/2)-1;
                Integer indeks2 = lista.size()/2;
                Double broj1 = (Double) lista.get(indeks1);
                Double broj2 = (Double) lista.get(indeks2);
                median = (Double) (broj1+broj2)/2;
            }
            System.out.println("Min vrijednost u listi je: " + min(lista) + ", max vrijednost u listi je: " + max(lista) +
                    ", srednja vrijednost iznosi: " + srednjaVrijednost + ", standardna devijacija iznosi: " + standardnaDevijacija +
                    ", median iznosi: " + median + ".");
        }
    }
}
