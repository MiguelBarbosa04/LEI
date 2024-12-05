/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   newmain.c
 * Author: migue
 *
 * Created on 23 de novembro de 2023, 12:37
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
#include <stdio.h>

void swap(int *x, int *y) {
    int tmp = *x;
    *x = *y;
    *y = tmp;
}

void swap_pointers(char **x, char **y) {
    char *tmp;
    tmp = *x;
    *x = *y;
    *y = tmp;

}

//int main() {
//    int a = 0, b = 1;
//    char *s1 = "da programação", *s2 = "Fundamentos";
//    printf("Valor de s1: %s", s1);
//     printf("\nValor de s2: %s", s2);
//      printf("\n/////////////////");
//    swap(&a, &b);
//    printf("a: %d\n", a);
//    printf("b: %d\n", b);
//    swap_pointers(&s1, &s2);
//    printf("%s %s\n", s1, s2);
//
//    return 0;
//}

