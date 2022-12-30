import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        int disks = readNumberOfDisks();

        SortHanoi('a', 'b', 'c', disks);
    }

    private static int readNumberOfDisks() {
        try (Scanner iScanner = new Scanner(System.in)) {
            while (true) {
                System.out.printf("Пожалуйста, введите количество дисков: ");
                String line = iScanner.nextLine();
                try {
                    int disks = Integer.parseInt(line);
                    if (disks <= 0) {
                        System.out.printf("Количество дисков должно быть положительным числом\n");
                    } else {
                        return disks;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Количество дисков должно быть целым числом");
                }
            }
        }
    }

    public static void printMove(char spire1, char spire2) {
        System.out.println(spire1 + "-->" + spire2);
    }

    static void SortHanoi(char spire1, char spire2, char spire3, int disksNumber) {
        if (disksNumber == 1) {
            printMove(spire1, spire2);
        } else {
            SortHanoi(spire1, spire3, spire2, disksNumber - 1);
            printMove(spire1, spire2);
            SortHanoi(spire3, spire2, spire1, disksNumber - 1);
        }
    }
}