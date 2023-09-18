/***********************************************************************
 * Pontificia Universidade Catolica de Minas Gerais
 * Engenharia de Software
 * Teoria dos Grafos e Computabilidade
 * Aluno: Paulo Victor Fernandes de Araujo Silva
 ************************************************************************/
/*========================================================================
 * Bibliotecas 
 * =======================================================================
 */
import java.util.Scanner;
/*=========================================================================*/

public class Grafos {

   
    public static boolean Regular(int[][] mat){

        int n = mat.length;
        //Tamanho Do Vertice
        int[] grauV = new int[n];
        for(int i = 0; i < n; i++){            /*Percorrer Matriz */
                for(int j = 0; j < n; j++){
                    if (i != j && mat[i][j] != -1){
                        grauV[i]++; //grau do vertice
                    }
                }
            }
        
        int gRegular = grauV[0];  //primeiro vertice tem grau regular
        for(int grauV1 : grauV){
            if(grauV1 != gRegular){
                return false;//se nao for regular
            }
            
        }
        return true;//se for regular

    }




    public static void main(String[] args){
         Scanner scanner = new Scanner (System.in);
        while(true){
            int n = scanner.nextInt();
            if(n == 0){
                break; // fecha o loop para n = 0
            }
            int [][] mat = new int[n][n]; //Matriz que representa o grafo

            for(int i = 0; i < n; i++){            /*Percorrer Matriz */
                for(int j = i + 1; j < n; j++){
                    int value = scanner.nextInt();
                    mat[i][j] = value;             /*Valores das Matrizes */
                    mat[j][i] = value;

                }
            }
            if(Regular(mat)){
                System.out.println("SIM");                          
          }else{
            System.out.println("NAO");
          }
       

        }
        scanner.close();
    }
}
