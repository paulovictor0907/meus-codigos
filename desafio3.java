import java.io.File;
import java.io.FileNotFoundException;
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

        if(ano < 0 || ano > 9999){            System.out.println("ANO INVALIDO");

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
 public static String LerDataArquivo(String filePath)throws FileNotFoundException{
    File file = new File(filePath);
    String novaDatamaisrecente = "01/01/1900"; // Data padrão inicial
    try {
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String dateString = sc.nextLine();
            String[] dateParts = dateString.split("/");

            if (dateParts.length == 3) {
                if (VerificarData(dateString)) {
                    System.out.println("Data Valida: " + dateString);
                    if (CompararData(dateString, novaDatamaisrecente)) {
                        novaDatamaisrecente = dateString;
                    }
                } else {
                    System.out.println("Data invalida");
                }
            } else {
                System.out.println("Formato de data invalido");
            }
        }
        sc.close();
    } catch (FileNotFoundException e) {
        System.out.println("Arquivo não encontrado: " + e.getMessage());
    }

    return novaDatamaisrecente;
}
public static void lerDataTeclado(String dataMaisRecenteDoArquivo){
    Scanner teclado = new Scanner(System.in);
    String novaData = "";
    System.out.println("Insira uma nova data no formado dd/mm/aaaa ou digite sair para encerrar o programa");
    while(true){
        String entrada = teclado.nextLine();
        if (entrada.equalsIgnoreCase("sair")) {
            break;
        }
        if(VerificarData(entrada)){
            System.out.println("Data Valida inserida: "+ entrada);
            if (CompararData(entrada, dataMaisRecenteDoArquivo)) {
                System.out.println("Insira uma nova data no formado dd/mm/aaaa ou digite sair para encerrar o programa");
                System.out.println("A nova data inserida é mais recente.");
                novaData = entrada;

            } else {
                System.out.println("Insira uma nova data no formado dd/mm/aaaa ou digite sair para encerrar o programa");
                System.out.println("A nova data inserida não é a mais recente.");

            }
        }
      else {
        System.out.println("Data inválida inserida: " + entrada);
     }
    }
    teclado.close();
    if (!novaData.isEmpty()) {
        System.out.println("A data mais recente foi: " + novaData);
    } else {
        System.out.println("A data mais recente foi "+ dataMaisRecenteDoArquivo );
    }
}


    public static void main(String[] args) throws FileNotFoundException{
        String filePath = "/teste/datas.txt";
        String dataMaisRecenteDoArquivo = LerDataArquivo(filePath);
        System.out.println("Atual data mais recente: "+dataMaisRecenteDoArquivo);
        lerDataTeclado(dataMaisRecenteDoArquivo);
       
}




 
}
