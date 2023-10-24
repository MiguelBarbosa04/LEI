/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Miguel
 *
 * Created on 24 de outubro de 2023, 11:37
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

void ex1() {
    int n1, n2;
    int maior, menor;

    printf("Primeiro número: ");
    scanf("%d", &n1);
    printf("Segundo número: ");
    scanf("%d", &n2);


    if (n1 < n2) {
        printf("O maior número é: %d", n2);
    } else {
        printf("O maior número é: %d", n1);
    }


    if (n1 > n2) {
        maior = n1;
        menor = n2;
    } else {
        maior = n2;
        menor = n1;
    }

    printf("\nMaior:%d ", maior);
    printf("Menor:%d ", menor);
}

void ex2() {

    int n1, n2, n3;

    printf("Primeiro número: ");
    scanf("%d", &n1);
    printf("Segundo número: ");
    scanf("%d", &n2);
    printf("Terceiro número: ");
    scanf("%d", &n3);

    if (n1 < n2 && n1 < n3) {
        printf("O maior pequeno é: %d", n1);
    } else if (n2 < n1 && n2 < n3) {
        printf("O maior pequeno é: %d", n2);
    } else {
        printf("O maior pequeno é: %d", n3);
    }

}

void ex3() {
    int a = 0, b = 1;
    if (a = b) { //se for == só compara, como é um = o a fica igual a b
        printf("Os valores são iguais");
    }
    printf("\na : %d b: %d: ", a, b);
}

void ex4() {
    int n1;

    printf("diga um número: ");
    scanf("%d", &n1);

    if (n1 % 2 == 0) {
        printf("%d é par", n1);
    } else {
        printf("%d é impar", n1);
    }

}

void ex5() {

    int a = 1;


    switch (a) {
        case 1:
            printf("O valor e um");
            break;
        case 2:
            printf("O valor e dois");
            break;
        case 3:
            printf("O valor e tres");
            break;
        default:
            break;
    }
}

void Parte2Ex1() {

    int n1, n2, resultado;
    char car;

    printf("Primeiro número: ");
    scanf("%d", &n1);
    printf("Segundo número: ");
    scanf("%d", &n2);

    printf("diga a operacoa que quer:");
    scanf(" %c", &car);

    switch (car) {
        case '+':
            resultado = n1 + n2;
            printf("O resultado da soma é: %d", resultado);
            break;
        case '-':
            resultado = n1 - n2;
            printf("O resultado da subtracao é: %d", resultado);
            break;
        case '*':
            resultado = n1 * n2;
            printf("O resultado da multiplicacao é:%d", resultado);
            break;
        case '/':
            resultado = n1 / n2;
            printf("O resultado da divisao é: %d", resultado);
            break;
        default:
            resultado = n1 + n2;
            printf("Por default é feita  soma ---> O resultado da soma é: %d", resultado);
            break;
    }

}

void Parte2Ex2() {

    int saldo, credito, debito;
    char operacao;

    printf("Diga o seu saldo:");
    scanf("%d", &saldo);

    printf("Diga a operacao -- +  para creditar ou - para debitar");
    scanf(" %c", &operacao);

    switch (operacao) {
        case '+':
            printf("Diga o montade que quer inserir: ");
            scanf("%d", &credito);
            saldo += credito;
            printf("saldo: %d", saldo);

            break;
        case '-':
            printf("Diga o montade que quer retirar: ");
            scanf("%d", &debito);
            if (saldo - debito < 0) {
                printf("imp+ossivel fazer operacao");
            } else {
                saldo -= debito;
                printf("saldo: %d", saldo);
            }

            break;

        default:

            break;
    }


}

void Parte2Ex3() {

    int menu;

    printf("diga a operacao do menu 1 - Criar 2 - Atualizar 3 - Eliminar 4 -Sair");
    scanf("%d", &menu);

    switch (menu) {
        case 1:
            printf("A operacao escolhida foi a 1");
            break;

        case 2:
            printf("A operacao escolhida foi a 2");
            break;

        case 3:
            printf("A operacao escolhida foi a 3");
            break;

        case 4:

            break;

        default:
            printf("Escolheu um operacao invalida");

    }
}

void Parte2Ex4() {

    int n1, n2;
    float mediaP;
    printf("--- DIGA AS NOTAS ENTRE OS VALORES 0 E 20 ---");
    printf("Diga a nota 1 : ");
    scanf("%d", &n1);
    if (n1 < 0 && n1 > 20) {
        printf("Valor inserido errado");
        return;
    } else {
        printf("Diga a nota 2: ");
        scanf("%d", &n2);
        if (n2 < 0 && n2 > 20) {
            printf("Valor inserido errado");
            return;
        }
    }

    mediaP = (n1 * 0.4) + (n2 * 0.6);
    if (mediaP >= 9.5) {
        printf("PARABENS PASSOU");
    } else {
        printf("SEU BURRO");
    }


}

void Parte2Ex5() {

    int x, y;


    printf("diga a coordenada x: ");
    scanf("%d", &x);
    printf("diga a coordenada y: ");
    scanf("%d", &y);

    if (x < 0 && y < 0) {
        printf("QUADRANTE 3");
    } else if (x > 0 && y > 0) {
        printf("QUADRANTE 1");
    } else if (x > 0 && y < 0) {
        printf("QUADRANTE 4");
    } else if (x < 0 && y > 0) {
        printf("QUADRANTE 2");
    }
}

void Parte3() {






    int codigoFuncionario, dias;
    float valorIliquido, valorSubsidioAlimentacao;
    float valorATirarDoIRS, valorComIRSRetirado;
    float valorParaEntidadePatronal, valorLiquido, segurancaSocial;
    char cargo;


    printf("Diga o seu código de funcionário: ");
    scanf("%d", &codigoFuncionario);
    printf("Diga o seu cargo de trabalho --> E - empregado  C - chefe  A - administrador : ");
    scanf(" %c", &cargo);
    printf("Diga o número de dias que trabalhou: ");
    scanf("%d", &dias);


    switch (cargo) {

        case 'E':

            valorIliquido = 40 * dias;
            valorSubsidioAlimentacao = dias * 5;



            break;
        case 'C':
            valorIliquido = 60 * dias;
            valorSubsidioAlimentacao = dias * 7.5;


            break;

        case 'A':
            break;
            valorIliquido = 80 * dias;
            valorSubsidioAlimentacao = dias * 7.5;


        default:
            printf("inseriu um cargo inválido");
            break;
    }


    if (valorIliquido < 1000) {
        valorATirarDoIRS = valorIliquido * 0.1;
    } else {
        valorATirarDoIRS = valorIliquido * 0.2;
    }


    if (cargo == 'A') {

        segurancaSocial = valorIliquido * 0.09;
        valorParaEntidadePatronal = valorIliquido * 0.21;
    } else {
        segurancaSocial = valorIliquido * 0.11;
        valorParaEntidadePatronal = valorIliquido * 0.2375;
    }

    valorLiquido = valorIliquido + valorSubsidioAlimentacao - valorATirarDoIRS - segurancaSocial;

    printf("\nO valor iliquido é : %.2f", valorIliquido);
    printf("\nO valor do subsidio de alimentacao é : %.2f", valorSubsidioAlimentacao);
    printf("\nO valor a dar ao estado do IRS é : %.2f", valorATirarDoIRS);
    printf("\nO valor da Seguramça Social é : %.2f", segurancaSocial);
    printf("\nO valor da entidade Patronal é : %.2f", valorParaEntidadePatronal);
    printf("\nO valor liquido é : %.2f", valorLiquido);
}

int main(int argc, char** argv) {


    Parte3();





    return (EXIT_SUCCESS);
}

