/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Miguel
 *
 * Created on 6 de novembro de 2022, 19:46
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    const int tam_colunas = 3;
    const int tam_linhas = 3;
  
    
    int mat[tam_colunas][tam_linhas];
    int num , i, j, maior, menor;
   
    
    
    for(i=0; i<tam_linhas; i++) {
      for(j=0;j<tam_colunas;j++) {
         printf("Digite os valor de i e de j:[%d][%d]:\n", i, j);
         scanf("%d", &mat[i][j]);
      }
   }
    
     for(i=0; i<tam_linhas; i++) {
      for(j=0;j<tam_colunas;j++) {
         printf("\n %d ", mat[i][j]);
        
      }
      printf("\n");
   }
   
    /*
     for(i=0; i<tam_linhas; i++) {
      for(j=0; j<tam_colunas;j++) {
        
      }
      printf("\n");
   }
   */
    
    menor = mat[0][0];
    maior = mat[0][0];
      
     for(i=0;i<tam_linhas;++i)
    {
        for(j=0;j<tam_colunas;++j)
        {
            if(mat[i][j]>maior)
                maior=mat[i][j];
            else
                if(mat[i][j]<menor)
                    menor=mat[i][j];
        }
    }
    
    printf("\nO número mais pequeno é: %d", menor);
    printf("\nO número maior é: %d", maior);
    
    return (EXIT_SUCCESS);
}

