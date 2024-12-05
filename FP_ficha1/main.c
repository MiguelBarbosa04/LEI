/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Miguel
 *
 * Created on 19 de outubro de 2023, 16:35
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h> 

/*
 * 
 */


void ex1() {

    int n1, n2, soma;
    printf("Diga o número 1 é:");
    scanf("%d", &n1);
    printf("Diga o número 2 é:");
    scanf("%d", &n2);

    soma = n1 + n2;

    printf("O resultado da soma é: %d", soma);
}

void ex2() {

    int aluno1, aluno2, aluno3, media;


    printf("Insira    a    idade    do    aluno    1:    ");
    scanf("%d", &aluno1);
    printf("Insira    a    idade    do    aluno    2:    ");
    scanf("%d", &aluno2);
    printf("Insira    a    idade    do    aluno    3:    ");
    scanf("%d", &aluno3);

    media = (aluno1 + aluno2 + aluno3) / 3;
    printf("A    média    de    idades    é:    %d", media);
}

void ex3() {

    int a, b, sum, sub, multi, div;


    printf("Insita o primeiro num:    ");
    scanf("%d", &a);
    printf("Insita o primeiro num:    ");
    scanf("%d", &b);


    sum = a + b;
    sub = a - b;
    multi = a * b;
    div = a / b;

    printf("Sum: %d: sub: %d multi: %d  div: %d", sum, sub, multi, div);
}

void ex4() {

    int a, b, area, perimetro;
    int alturaT, baseT, areaT;
    int r, areaC;
    int pi = 3.14159265358979323846;

    printf("Insira o comprimento:    ");
    scanf("%d", &a);
    printf("Insita a largura:    ");
    scanf("%d", &b);


    area = a * b;
    perimetro = (a * 2) + (b * 2);

    printf("A area é: %d e o perimetro é %d", area, perimetro);


    printf("Diga a altura da triangulo:\n ");
    scanf("%d", &alturaT);
    printf("\n Diga a base da triangulo:\n  ");
    scanf("%d", &baseT);

    areaT = (alturaT * baseT) / 2;

    printf("\n A area do triangulo é: %d", areaT);


    printf("\n Diga o raio da circunferecnai: ");
    scanf("%d", &r);
    areaC = pi * pow(r, 2);
    printf("\n A area da circunferencia é: %d", areaC);
}

void ex1Parte2() {

    char l;

    printf("Digite um caractere: ");
    scanf(" %c", &l);

    printf("Caractere digitado: %c\n", l);
    printf("Antecessor: %c\n", l - 1);
    printf("Sucessor: %c\n", l + 1);
}

void ex2Parte2() {
    float a1, a2, a3;
    float mediaAri, mediaPon;

    printf("\nDiga o a1");
    scanf("%a1", &a1);
    printf("\nDiga o a2");
    scanf("%a2", &a2);
    printf("\nDiga o a3");
    scanf("%a3", &a3);


    mediaAri = (a1 + a2 + a3) / 3;
    mediaPon = (a1 * 0.2) + (a2 * 0.3) + (a3 * 0.5);
    printf("\nA media arimetrica é: %f", mediaAri);
    printf("\nA media ponderada é: %f", mediaPon);

}

void ex3Parte() {
    int v1, v2;

    printf("diga o v1: ");
    scanf("%d", &v1);
    printf("diga o v2: ");
    scanf("%d", &v2);


    v1 = (v1 + v2) - v1;
    printf("O valor agora de v1 é :  %d", v1);
    v2 = (v2 + ++v1) - v2;
    printf("O valor agora de v2 é :  %d", v2);
   
}

void ex4Parte2() {
    float v1, v2, v3, valorADescontar, valorFinal;
    float desconto = 0.1;

    printf("diga o valor de v1 : ");
    scanf("%f", &v1);
    printf("diga o valor de v2 : ");
    scanf("%f", &v2);
    printf("diga o valor de v3 : ");
    scanf("%f", &v3);

    valorADescontar = (v1 + v2 + v3) * desconto;
    valorFinal = (v1 + v2 + v3) - valorADescontar;

    printf("O valor final é:%f ", valorFinal);

}

void ex5Parte2() {
    int min, seg, cont, minutosTotais, segundosTotais, horasTotais;

    for (int i = 1; i <= 5; i++) {
        printf("Diga os minutos da musica %d :", i);
        scanf("%d", &min);
        printf("Diga os segundos da musica: %d : ", i);
        scanf("%d", &seg);
        cont += (min * 60) + seg;
    }

    printf("Cont = %d", cont);

    horasTotais = cont / 3600;
    minutosTotais = (cont - (3600 * horasTotais)) / 60;
    segundosTotais = (cont - (3600 * horasTotais) - (minutosTotais * 60));


    printf("\n As horas sao : %d", horasTotais);
    printf("\n Os minutos sao : %d", minutosTotais);
    printf("\n Os segundos sao : %d", segundosTotais);

    printf("\n A duração do album é ->  %d:%d:%d", horasTotais, minutosTotais, segundosTotais);

}

void ex1Parte3() {
    float vencimento = 40, subsidioAlimentacao = 5, irs = 0.1;
    float segurancaSocial = 0.11, encargoFuncionario = 0.2375;
    int codigoFuncionario, dias;
    float valorIliquido, valorSubsidioAlimentacao;
    float valorATirarDoIRS, valorComIRSRetirado;
    float valorParaSS, valorParaEntidadePatronal, valorLiquido;


    printf("Diga o seu código de funcionário: ");
    scanf("%d", &codigoFuncionario);
    printf("Diga o número de dias que trabalhou: ");
    scanf("%d", &dias);

    valorIliquido = vencimento * dias;

    printf("\nO valor iliquido é : %.2f", valorIliquido);

    valorSubsidioAlimentacao = dias *subsidioAlimentacao;

    printf("\nO valor do subsidio de alimentacao é : %.2f", valorSubsidioAlimentacao);

    valorATirarDoIRS = (valorIliquido * irs);

    printf("\nO valor a dar ao estado do IRS é : %.2f", valorATirarDoIRS);

    valorParaSS = valorIliquido * segurancaSocial;
    valorParaEntidadePatronal = valorIliquido * encargoFuncionario;
    printf("\nO valor da Seguramça Social é : %.2f", valorParaSS);
    printf("\nO valor da entidade Patronal é : %.2f", valorParaEntidadePatronal);

    valorLiquido = valorIliquido + valorSubsidioAlimentacao - valorATirarDoIRS - valorParaSS;
    printf("\nO valor liquido é : %.2f", valorLiquido);
    
}

int main(int argc, char** argv) {

    
   //FICHA 1 DE FP//
  ex1Parte3();

    return (EXIT_SUCCESS);
}

