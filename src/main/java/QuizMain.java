import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMain {
    public static void main(String[] args) throws FileNotFoundException {


        File folder = new File("C:/Test/quiz/");
        File[] listaKategorii = folder.listFiles();

        int wybranaKategoria = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz kategorię: ");
        System.out.println("1.Animals\n2.Board Games\n3.Books\n4.Cartoon Animations\n5.Film\n6.Anime\n7.Music\n8.Television" +
                "\n9.Video games\n10.General knowledge\n11.Geography\n12.History\n13.Science - Computers\n14.Science - Nature" +
                "\n15.Sports\n16.Vehicles");
        wybranaKategoria = scanner.nextInt();

        Scanner scanner2 = new Scanner(listaKategorii[wybranaKategoria-1]);

        while (scanner2.hasNextLine()){
            String text = scanner2.nextLine();
            System.out.println(text);
        }







    }
}
