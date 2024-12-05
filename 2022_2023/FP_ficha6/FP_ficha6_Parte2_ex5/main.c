/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 30 de novembro de 2022, 16:10
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

void swap(int *x, int *y){
    
    int tmp = *x;
    *x = *y;
    *y = tmp;
}

void swap_pointers(char **x, char **y){
    
    char *tmp;
    tmp = *x;
    *x = *y;
    *y = tmp;
    
    
}
int main(int argc, char** argv) {

    int a = 0, b = 1;
    char *s1 = "da programação", *s2 = "Fundamentos";
    
    swap(&a, &b);
    printf("a: %d\n", a);
    printf("b: %d\n", b);
    
    swap_pointers(&s1, &s2);
    printf("%s %s\n", s1, s2);
    
    
    return 0;
}

