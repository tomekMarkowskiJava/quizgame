import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuizMain {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {


        File folder = new File("src\\main\\resources");
        File[] listaKategorii = folder.listFiles();
        int punkty = 0;
        for (int j = 0; j < 10; j++) {
            int wybranaKategoria;
            Scanner skanerWybranejKategorii = new Scanner(System.in);

            System.out.println("\nWybierz kategorię: ");
            for (int i = 0; i < listaKategorii.length; i++) {
                System.out.println((i + 1) + ". " + listaKategorii[i].getName()
                        .replaceAll("_", " ")
                        .replaceAll(".txt", ""));
            }
            System.out.println((listaKategorii.length+1)+ ". Wszystkie kategorie.\n" + (listaKategorii.length+2) + ". Wyjdź");
            wybranaKategoria = skanerWybranejKategorii.nextInt();

            if (wybranaKategoria == listaKategorii.length+1){
                Random random = new Random();
                wybranaKategoria=random.nextInt(listaKategorii.length);
            }else if (wybranaKategoria == listaKategorii.length+2){
                break;
            }

            Scanner scanner = new Scanner(listaKategorii[wybranaKategoria - 1]);

            List<ZadanieQuizowe> zadania = new LinkedList<ZadanieQuizowe>();
            int liczbaOdpowiedzi;

            while (scanner.hasNextLine()) {
                ZadanieQuizowe zadanie = new ZadanieQuizowe();
                zadanie.pytanie = scanner.nextLine();
                liczbaOdpowiedzi = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < liczbaOdpowiedzi; i++) {
                    zadanie.odpowiedzi.add(scanner.nextLine());
                }
                zadania.add(zadanie);
            }

            Collections.shuffle(zadania);
            ZadanieQuizowe biezaceZadanie = zadania.get(0);
            System.out.println("Pytanie nr." + (j + 1) + "\n" + biezaceZadanie.pytanie);
            String prawidlowaOdpowiedz = biezaceZadanie.odpowiedzi.get(0);
            Collections.shuffle(biezaceZadanie.odpowiedzi);
            for (int i = 0; i < biezaceZadanie.odpowiedzi.size(); i++) {
                System.out.println((i + 1) + ". " + biezaceZadanie.odpowiedzi.get(i));
            }
            Scanner skanerWybranejOdpowiedzi = new Scanner(System.in);
            int wybranaOdpowiedz = (skanerWybranejOdpowiedzi.nextInt());

            if (prawidlowaOdpowiedz.equals(biezaceZadanie.odpowiedzi.get(wybranaOdpowiedz - 1))) {
                System.out.println("Dobra odpowiedź!");
                punkty++;
            } else {
                System.out.println("Błędna odpowiedź");
                System.out.println("Prawidłowa odpowiedź to: \n" + prawidlowaOdpowiedz);
            }
            Thread.sleep(2000);

        }

        System.out.println("\nKoniec gry");
        System.out.println("Twoje punkty: " + punkty + "/10");
    }
}
