/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpf_maker;

/**
 *
 * @author Vicio
 */
import java.util.Random;
public class CPF_Maker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // link da regra do cpf: http://www.gerardocumentos.com.br/?pg=entenda-a-formula-do-cpf
        
        short[][] cpf = new short[3][11]; // 3 linhas e 11 colunas
        Random aleatorio = new Random();
        int i;
        short somatoria=0;
        for(i=0; i<9; i++){
            cpf[0][i] = (short) aleatorio.nextInt(10);// 0 até 9
            cpf[1][i] =  (short)(10-i);
            cpf[2][i] = (short)(cpf[0][i] * cpf[1][i]);
            somatoria+= cpf[2][i];
        }
        // exemplo de For each (for aprimorado)
        for(short[] a:cpf){
            for( short elemento: a){
            System.out.printf(" %d",elemento);
            }
            System.out.println("\n==============================");
        }
         System.out.println("somatória: "+somatoria);
         System.out.println("Quociente: "+ (somatoria/11));
         System.out.println("Resto: "+ (somatoria%11));
         
         // calculando o primeiro dígito verificador xxx.xxx.xxx-?x
         if(somatoria%11<2){
             cpf[0][9]= 0;
         }else{
             cpf[0][9] = (short) (11- (somatoria%11));
         }
         System.out.println("Primeiro digito verificador: "+ cpf[0][9]);
         
         // calculando o segundo dígito verificador xxx.xxx.xxx-x?
         somatoria =0; // reiniciando a somatória para o segundo dígito verificador
         for(i=0;i<10;i++){
             cpf[1][i]= (short)(11-i);
             cpf[2][i] = (short)(cpf[0][i] * cpf[1][i]);
             somatoria+= cpf[2][i];
         }
         System.out.println("Segundo somatória: "+somatoria);
         System.out.println("Segundo Quociente: "+ (somatoria/11));
         System.out.println("Segundo Resto: "+ (somatoria%11));
         if(somatoria%11<2){
             cpf[0][10]= 0;
         }else{
             cpf[0][10] = (short) (11- (somatoria%11));
         }
         System.out.println("Segundo digito verificador: "+ cpf[0][10]);
         System.out.println();
         System.out.println("=================================");
         System.out.printf("CPF: "); 
         for(i=0;i<11;i++){
                if((i+1)==0)
                    System.out.printf("%d",cpf[0][i]);
                else{
                    if((i+1)%3==0){
                        if(i==8)
                            System.out.printf("%d-",cpf[0][i]);
                        else
                            System.out.printf("%d.",cpf[0][i]);
                    }
                    else{      
                        System.out.printf("%d",cpf[0][i]);
                    }
                }
         }
        System.out.printf("\n");
        System.out.printf("\n");

    }
    
}
