/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 29 de novembro de 2022, 18:28
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

void ordenar(int *v1, int *v2, int *v3){
    
    
    printf("%p \n <%p>", v1, &v1);
    printf("%p \n <%p>", v2 + 2, *(&v1 + 2));
    printf("%p \n <%p>", v3 + 1, *(&v1 + 1));
    
}
int main(int argc, char** argv) {

    int v1, v2, v3;
    
    v1 = 1;
    v2 = 2;
    v3 = 3;
    
    ordenar(v1, v2, v3);
    return (EXIT_SUCCESS);
}

