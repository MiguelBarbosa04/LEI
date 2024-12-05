/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 20 de outubro de 2022, 12:09
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int n1, n2;
    float media, media_ponderada, quarenta, sessenta;
    
    printf("Insira a primeira nota: ");
    scanf("%d", &n1);
    printf("Insira a segunda nota: ");
    scanf("%d", &n2);
    
    if (n1 > 20 && n1 <0 ){
        
        printf("Inseriu um valor errado");
    }else if (n2 > 20 && n2 < 0){
        printf("Inseriu um valor errado");
    }
    
    
    media = (n1 + n2 )/2.0;
    printf(" A média é: %.2f", media);
    
    
    quarenta = n1 * 0.4;
    printf(" \n Quarenta porcento da primeira nota é: %.2f ", quarenta);
    
    sessenta = n2 * 0.6;
    printf(" \n Sessenta porcento da segunda nota é: %.2f ", sessenta);
    
    media_ponderada = quarenta + sessenta;
    printf("\n A média ponderada é: %.2f", media_ponderada);
    
    if (media_ponderada >= 9,5){
        
        printf("Parabéns passou");
    }else if (media_ponderada < 9,5){
        printf("Reprovou");
    }
        
        
        
        
    return (EXIT_SUCCESS);
}

