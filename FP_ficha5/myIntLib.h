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
    void lerDiasTrabalhados(int diasArray[]);
    void calcularVencimento(char cargo, int diasArray[], float* valorIliquidoArray, float* valorSubsidioAlimentacaoArray);
    void calcularIRS(float valorATirarDoIRSArray[], float valorIliquidoArray[]);
    void resetarArrays(float totalAPagarVencimentoArray[], float totalAPagarSubsidiosArray[], float totalAPagarImpostosArray[], float segurancaSocialArray[], float valorATirarDoIRSArray[]);
    void calcularSegurancaSocial(char cargo, float segurancaSocialArray[], float valorIliquidoArray[], float valorParaEntidadePatronalArray[]);
    void calcularValorIliquido(int diasArray[], float valorIliquidoArray[]);
    void calcularValorLiquido(float valorLiquidoArray[], float valorIliquidoArray[], float valorSubsidioAlimentacaoArray[], float valorATirarDoIRSArray[], float segurancaSocialArray[]);
    void imprimirResultados(int codigoFuncionario, float valorIliquidoArray[], float valorSubsidioAlimentacaoArray[], float valorATirarDoIRSArray[], float segurancaSocialArray[], float valorParaEntidadePatronalArray[],float valorLiquidoArray[], float totalAPagarVencimentoArray[], float totalAPagarSubsidiosArray[], float totalAPagarImpostosArray[]);




#ifdef __cplusplus
}
#endif

#endif /* MYINTLIB_H */

