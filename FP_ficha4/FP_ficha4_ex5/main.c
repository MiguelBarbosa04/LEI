/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Miguel
 *
 * Created on 6 de novembro de 2022, 21:09
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    char str1[10];
    char str2[10];
    int n;
    
    printf("Diga a primeira string: ");
    scanf("%s", str1);
    printf("Diga a segunda string: ");
    scanf("%s", str2);
    
    n = strcmp(str1,str2);
    
    if (n == 0)
        printf("As strings são iguais");
    else
        printf("As strings não são iguais");
    
   
           
    return (EXIT_SUCCESS);
}

