import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Scanner;


public class Data2 {


public static boolean VerificarData(String data){
        String[] partes = data.split("/");
        if (partes.length != 3){
            System.out.println("Formato Invalido");
            data = "01/01/1900";
            return false;
        }

        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        if(ano < 0 || ano > 9999){
            System.out.println("ANO INVALIDO");
            data = "01/01/1900";
            return false;
        }

        if(mes < 0 || mes > 12){
            System.out.println("MES INVALIDO");
            data = "01/01/1900";
            return false;
        }

        int[] diasPorMes= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
            diasPorMes[2] = 29; 
        }

        if(dia < 1 || dia > diasPorMes[mes]){
            System.out.println("DIA INVALIDO");
            data = "01/01/1900";
            return false;
        }
        return true;


    }

    public static boolean CompararData(String data1, String data2){

        String[] partes1 = data1.split("/");
        String[] partes2 = data2.split("/");

        int ano1 = Integer.parseInt(partes1[2]);
        int mes1 = Integer.parseInt(partes1[1]);
        int dia1 = Integer.parseInt(partes1[0]);

        int ano2 = Integer.parseInt(partes2[2]);
        int mes2 = Integer.parseInt(partes2[1]);
        int dia2 = Integer.parseInt(partes2[0]);

        if(ano1 > ano2){
            return true;
        }else if(ano1 == ano2){
            if (mes1 > mes2){
                return true;
            }else if(mes1 == mes2 && dia1 > dia2){
                return true;
            }
        }
        return false;


        

 }

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("/Users/1403236/Desktop/arquivos/datas.txt");
	    Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String dateString = sc.nextLine();
            String[] dateParts = dateString.split("/");

            int day = Integer.parseInt(dateParts[0]);
	        int month = Integer.parseInt(dateParts[1]);
	        int year = Integer.parseInt(dateParts[2]);
          //continuar aqui


        }



sc.close();
 }
}
