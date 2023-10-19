/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 29 de novembro de 2022, 17:56
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
#include <stdio.h>
#include <stdio.h>
void foo(int a, int *aPtr) {
 // imprimir o valor de a printf("%d", a)
 // imprimir o endereço de a printf("%p", &a)
 // imprimir o valor de aPtr printf("%d", aptr)
 // imprimir o endereço de aPtr printf("%p", &aptr)
 // somar um ao valor de a printf("%d", a++)
 // somar um ao valor apontado por de aPtr ("%d", *(aptr)++)
}
int main() {
 int a = 0;
 // imprimir o valor de a printf ("%d",a)
 // imprimir o endereço de a printf("%p", &a)
 foo(a, &a);
 // imprimir o valor de a printf("%d", a)
 return 0;
}

