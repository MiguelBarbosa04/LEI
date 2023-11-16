/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   myIntLib.h
 * Author: migue
 *
 * Created on 16 de novembro de 2023, 09:42
 */
#include <stdio.h>
#ifndef MYINTLIB_H
#define MYINTLIB_H

#ifdef __cplusplus
extern "C" {
#endif

    int somar(int n1, int n2);
    int sub(int n1, int n2);
    int multi(int n1, int n2);
    int divi(int n1, int n2);
    int limites(int inferior, int superior);
    void imprimir(int n);
    void somarm(int m1[3][3], int m2[3][3]);
    void somarElementos(int m1[3][3], int m2[3][3]);
    float media(int soma, int tamanho);
    void valorMinAndMax(int n1, int n2);
    int potencia(int x, int y);



#ifdef __cplusplus
}
#endif

#endif /* MYINTLIB_H */

