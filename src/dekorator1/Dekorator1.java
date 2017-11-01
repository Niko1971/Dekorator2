package dekorator1;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Bercik
 */
public class Dekorator1 {

    public static void liczbaSlow(String plik) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(plik));
            String linie = null;
            int slowa = 0;
            while ((linie = in.readLine()) != null) {
                if (linie.length() > 0) {
                    if (((byte) linie.charAt(0) != 32) && ((byte) linie.charAt(0) != 9)) {
                        slowa++;
                    }
                    if (linie.length() > 1) {
                        for (int i = 0; i < linie.length() - 1; i++) {
                            if ((((byte) linie.charAt(i) == 32) || ((byte) linie.charAt(i) == 9)) && (((byte) linie.charAt(i + 1) != 32) && ((byte) linie.charAt(i + 1) != 9))) {
                                slowa++;
                            }
                        }
                    }
                }
            }
            System.out.println("Ilosc slow w pliku: " + slowa);
        } catch (Exception ex) {
            System.out.println("Błąd");
            ex.printStackTrace();
        }
    }

    public static void liczbaWierszy(String plik) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(plik));
            int a = 0;
            int wiersze = 0;
            if ((a = in.read()) != -1) {
                wiersze++;
                while ((a = in.read()) != -1) {
                    if (a == 10) {
                        wiersze++;
                    }
                }
            }
            System.out.println("Ilosc wierszy w pliku: "+wiersze);
        } catch (Exception ex) {
            System.out.println("Błąd");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String plik = "asd.txt";
        liczbaSlow(plik);
        liczbaWierszy(plik);
    }
}
