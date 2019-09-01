import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class QuizMain {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {


        File folder = new File("C:/Test/quiz/");
        File[] listaKategorii = folder.listFiles();
        int punkty = 0;
        for (int j = 0; j < 10; j++) {
            int wybranaKategoria = 0;
            Scanner skanerWybranejKategorii = new Scanner(System.in);

            System.out.println("\nWybierz kategorię: ");
            for (int i = 0; i < listaKategorii.length; i++) {
                System.out.println((i + 1) + ". " + listaKategorii[i].getName()
                        .replaceAll("_", " ")
                        .replaceAll(".txt", ""));
            }
            wybranaKategoria = skanerWybranejKategorii.nextInt();

            Scanner scanner = new Scanner(listaKategorii[wybranaKategoria - 1]);

            List<ZadanieQuizowe> zadania = new LinkedList<ZadanieQuizowe>();
            int liczbaOdpowiedzi = 0;

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
            System.out.println("Zadanie nr." + (j+1) + "\n" + zadania.get(0).pytanie);
            String prawidlowaOdpowiedz = zadania.get(0).odpowiedzi.get(0);
            Collections.shuffle(zadania.get(0).odpowiedzi);
            for (int i = 0; i < zadania.get(0).odpowiedzi.size(); i++) {
                System.out.println((i + 1) + ". " + zadania.get(0).odpowiedzi.get(i));
            }
            Scanner skanerWybranejOdpowiedzi = new Scanner(System.in);
            int wybranaOdpowiedz = (skanerWybranejOdpowiedzi.nextInt());

            if (prawidlowaOdpowiedz == zadania.get(0).odpowiedzi.get(wybranaOdpowiedz-1)) {
                System.out.println("Dobra odpowiedź!");
                punkty++;
            } else {
                System.out.println("Błędna odpowiedź");
                System.out.println("Prawidłowa odpowiedź to: \n"+prawidlowaOdpowiedz);
            }
            Thread.sleep(2000);

        }

        System.out.println("\nKoniec gry");
        System.out.println("Twoje punkty: " + punkty + "/10");
    }
}
