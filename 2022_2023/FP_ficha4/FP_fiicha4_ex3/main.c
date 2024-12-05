/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Miguel
 *
 * Created on 4 de novembro de 2022, 15:46
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    /*
    int mat[4][5];
    int i, j, num, count = 0;
    
    
   for(i=0; i<5; i++) {
      for(j=0;j<6;j++) {
         printf("Digite os valor de i e de j:[%d][%d]:", i, j);
         scanf("%d", &mat[i][j]);
      }
   }
    
    printf("Diga um número:");
    scanf("%d", &num);
    
    for ( i = 0; i < num; i++)
       for (j= 0 ;j< num ;j++)
    {
        if (mat[i][j] == num ) {
            count++;                
    }
    }
       
    
  
    printf("\n %d Apareceu %d vezes na matriz.", num, count);
    
    
    */
    unsigned int TAM1=4,TAM2=5,cont=0,i,j;
    int Matriz[TAM1][TAM2],num,num2;

    printf("\nIntroduza valores inteiros a colocar na matriz: ");

    for(i=0;i<TAM1;i++){
        for(j=0;j<TAM2;j++){
            scanf("%d",&num);

            Matriz[i][j]=num;
        }
    }

    printf("\nQual o numero que deseja confirmar que existe: ");
    scanf("%d",&num2);

    for(i=0;i<TAM1;i++){
        for(j=0;j<TAM2;j++){
            if(num2==Matriz[i][j]){
                cont++;
            }
        }
    }

    printf("\nO número foi intruduzido %u vezes.",cont);
 
    
    return (EXIT_SUCCESS);
}

