import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class teste{

	    public static void main(String[] args) {
	        try {
	            File file = new File("/Users/1403236/Desktop/arquivos/datas.txt");
	            Scanner scanner = new Scanner(file);

	            while (scanner.hasNextLine()) {
	                String dateString = scanner.nextLine();
	                String[] dateParts = dateString.split("/");

	                int day = Integer.parseInt(dateParts[0]);
	                int month = Integer.parseInt(dateParts[1]);
	                int year = Integer.parseInt(dateParts[2]);

	                LocalDate date = LocalDate.of(year, month, day);
	                System.out.println("Data lida do arquivo: " + date);
	            } 
	                System.out.println("O arquivo está vazio.");
	            

	            scanner.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Arquivo não encontrado: " + e.getMessage());
	        }
	    }
	}
