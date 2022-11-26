/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 14 de outubro de 2022, 11:57
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

        int  m1, s1;
        int  m2, s2;
        int  m3, s3;
        int  m4, s4;
        int  m5, s5;
        int  h1;
        int  resultado_segundos, resultado_minutos, resultado_horas;
        
        h1=0;
     
    
    printf("Diga os minutos e segundos da primeira canção: ");
    scanf("%d:%d", &m1, &s1);
    
    printf("Diga os minutos e segundos da segunda canção: ");
    scanf("%d:%d", &m2, &s2);
    
    resultado_segundos=(s1+s2)%60;
    resultado_minutos=(m1+m2+((s1+s2)/60))%60;
   
    resultado_horas=(h1+((m1+m2)/60));
    
            
    printf("Total: %02d:%02d:%02d", resultado_horas,resultado_minutos, resultado_segundos);
    

    
    return (EXIT_SUCCESS);
}

