/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 17 de novembro de 2022, 09:16
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

 int soma_elementos(int matriz[100][100], int tam_linhas, int tam_colunas)  {
            
     
    
            int i, j;
            int soma = 0;
            
            for (i = 0; i <tam_linhas ; i++){
                for (j = 0; j<tam_colunas; j++){
                    soma = soma + matriz[i][j];
            }
            }
            return soma;
 }

 
 int soma_total(int array[100][100], int array2[100][100], int linhas, int colunas) {
    int i, j;
    int soma = 0;
    int soma2 = 0;
    int soma_total_matrizes;

    for (i = 0; i < linhas; i++){
        for(j= 0 ; j < colunas; j++){

            soma += array[i][j];
            soma2 += array2[i][j];
            soma_total_matrizes = soma + soma2;
        }
    }
    return soma_total_matrizes;
 }

void soma_matrizes (int a[100][100], int b[100][100], int tam_linhas, int tam_colunas){
    
    int i, j;
    
    
    
    for (i = 0; i < tam_linhas ; i++){
        for (j = 0; j<tam_colunas; j++){
            printf("%d \t",  a[i][j] + b[i][j]);
        }
    printf("\n");
    }   
  
            
}


int main(int argc, char** argv) {
    

   
    int i, j;
    const int tam_colunas, tam_linhas;
    int a[100][100];
    int b[100][100];
    
    
    printf("Diga quantas lihas vão ter as matrizes:");
    scanf("%d", &tam_linhas);
    printf("Diga quantas colunas vão ter as matrizes:");
    scanf("%d", &tam_colunas);
    
    
    
    
    /* for(i=0; i<tam_linhas; i++) {
      for(j=0;j<tam_colunas;j++) {
         printf("Digite os valor de i e de j:[%d][%d]:\n", i, j);
         scanf("%d", &a[i][j]);
         scanf("%d", &b[i][j]);
      }
   }*/
    
    
    
    for(i=0;i<tam_linhas;i++)
    for(j=0;j<tam_colunas;j++){
    printf("Diga o elemento da posição [%d][%d]: ",i+1,j+1);
    scanf("%d",&a[i][j]);

    }
    for(i=0;i<tam_linhas;i++){
    for(j=0;j<tam_colunas;j++){
    printf(" %d ",a[i][j]);
    }
    printf("\n");
    }
    
    

    for(i=0;i<tam_linhas;i++)
    for(j=0;j<tam_colunas;j++){
    printf("Diga o elemento da posição [%d][%d]: ",i+1,j+1);
    scanf("%d",&b[i][j]);

    }
    for(i=0;i<tam_linhas;i++){
    for(j=0;j<tam_colunas;j++){
    printf(" %d ",b[i][j]);
    }
    printf("\n");

    }
        
   

    
   printf("\n%d", soma_elementos(a, tam_linhas, tam_colunas));
   printf("\n%d\n", soma_elementos(b, tam_linhas, tam_colunas));
   printf("\n%d\n", soma_total(a, b, tam_linhas, tam_colunas));
   printf("\n");
   soma_matrizes(a, b, tam_linhas, tam_colunas);
   
    
  
    
    

  return 0;
     
}