/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 3 de novembro de 2022, 11:04
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    /*
    unsigned int i;
    char deslocamento, tx_n, tx_c ;

    printf("Diga o que quer encriptar:");
    scanf(" %c", &tx_n);
    
    printf("Quer avançar ou recuar: ");
    scanf(" %c", &deslocamento);
    
    switch(deslocamento)
            {
        case '+':
            tx_n + 4;
            printf("%c", tx_n);
            break;
            
        case '-':
            tx_n - 4;
            printf("%c", tx_n);
            break;
 
        default : 
            
            printf("Inseriu um sinal errado.");
           
        
    }
    */
    
    char frase[20],sinal;
    int i=0;
    int chave;
    printf("\n\nEscreva uma chave:");
    scanf("%d",&chave);



    printf("\nDigite a frase a ser encriptada:");

    scanf("%s",frase);

    printf("Quer deslocar para frente ou para trás?:");
    scanf(" %c", sinal);
    
    
    switch(sinal)
    {
        case '+':
            
        printf("\n\nFrase encriptada com sucesso!\n\n");
        printf("Encriptacao:  ");

        for(i=0;i<strlen(frase);i++)
        {

        int enc=(int)frase[i]+chave;
        printf("%c",(char)enc);
        }


        printf("\n\n");
        break;
        
        
        
        
            
        case '-':
            
        printf("\n\nFrase encriptada com sucesso!\n\n");
        printf("Encriptacao:  ");

        for(i=0;i<strlen(frase);i++)
        {

        int enc=(int)frase[i]-chave;
        printf("%c",(char)enc);
        }


        printf("\n\n");
        break;
    
        default : 
            printf("Algo deu errado");
           
        
    }
    
    
    
    
    
    return (EXIT_SUCCESS);
}

