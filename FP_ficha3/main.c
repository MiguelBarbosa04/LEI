/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 2 de novembro de 2023, 09:29
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

void ex1() {
    //    int soma = 0 , numero = 0;
    //    
    //    do{
    //        soma += numero;
    //        scanf("%d", &numero);
    //    }while ( numero > 0);

    //    
    //    int numero;
    //    
    //    
    //    for (numero = 1; numero <= 10; numero++){
    //         printf("%d", numero);
    //    }


    int i, j;
    for (i = 20, j = 0; i > j; i--, j++) {
        printf("\n%d    %d", i, j);
    }


}

void ex2() {

    int numero = 1;
    while (numero <= 10) {
        printf("%d", numero);
        numero--;
    }
    //é um ciclo infinito pois a variavel numero 
    //é 1 e a cada interação vamos estar a diminuir 1 o numero, por isso 10 vai ser sempre superior á variavel numero
}

void ex3() {
    char opcao;

    printf("Escolha 'M' para maiúsculas ou 'm' para minúsculas: ");
    scanf(" %c", &opcao);

    if (opcao == 'M') {
        printf("A");


        printf("\n");
    } else {
        printf("a");
    }
}

void ex4() {

    int numero, soma = 0, count = 0, media;


    do {
        printf("Diga um número, insira 0 se quiser para:");
        scanf("%d", &numero);
        soma += numero;
        count++;
    } while (numero != 0);

    media = soma / (count - 1);
    printf("A média é: %d", media);
}

void ex5() {

    int numero;
    int i;

    do {
        printf("Diga um número positivo:");
        scanf("%d", &numero);
    } while (numero < 0);

    for (i = numero; i >= 1; i--) {
        if (i % 2 != 0) {
            printf("%d", i);
        }
    }
}

void P2Ex1() {

    int n1, n2, soma, sub, div, mult;
    char op, op2;

    do {
        printf("Diga o n1: ");
        scanf("%d", &n1);
        printf("Diga o n2: ");
        scanf("%d", &n2);
        printf("Diga a operacao:");
        scanf(" %c", &op);

        switch (op) {
            case '+':
                soma = n1 + n2;
                printf("%d", soma);
                break;
            case '-':
                sub = n1 - n2;
                printf("%d", sub);
                break;
            case '/':
                div = n1 / n2;
                printf("%d", div);
                break;
            case '*':
                mult = n1 * n2;
                printf("%d", mult);
                break;
            default:
                soma = n1 + n2;
                printf("%d", soma);
                break;
        }
        printf("\nDeseja continuar? (introduza s/n)");
        scanf(" %c", &op2);
    } while (op2 == 's' || op2 == 'S');


}

void P2Ex2() {

    char op, op2;

    do {
        printf("Diga a opcao que quer, 1.criar 2.atualizar 3.eliminar 4.sair: ");
        scanf("%d", &op);

        switch (op) {
            case 1:
                printf("Escolheu Criar");
                break;
            case 2:
                printf("Escolheu Atualizar");
            case 3:
                printf("Escolheu Eliminar");
                break;
            case 4:
                printf("Escolheu Sair");
                break;
            default:
                printf("Escolheu uma opcao invaldia");
                break;
        }

    } while (op != 4);


}

void P2Ex3() {

    int num, num2, count = 0;

    do {
        printf("Diga um número entre 0 e 100 : ");
        scanf("%d", &num);
    } while (num < 0 || num > 100);



    while (num2 != num) {
        printf("Tente acertar no número jogador 2, insira o numero: ");
        scanf("%d", &num2);
        count++;
        if (num2 > num) {
            printf("O número do jogador 1 é menor");
        } else if (num2 < num) {
            printf("O número do jogador 1 é maior");
        } else {
            printf("Acertouuuuu, o número é %d", num);
            printf("\nPrecisou de %d tentativas", count);
        }

    }
}

void P2Ex4() {

    int num, i, count = 0;

    printf("Insira um número: ");
    scanf("%d", &num);

    if (num <= 1) {
        printf("O número não é primo");
    } else {
        for (i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                count++;
                break;
            }
        }

        if (count == 0) {
            printf("O número não é primo");
        } else {
            printf("O número é primo");
        }
    }
}

void P2Ex5() {

    int voto, count0 = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count9 = 0, countGlobal;
    float percentagem1, percentagem2, percentagem3, percentagem4, percentagem5, percentagem0, percentagem9;

    do {
        printf("Diga o candidato que quer votar: ");
        scanf("%d", &voto);
        if (voto == 1) {
            count1++;
        } else if (voto == 2) {
            count2++;
        } else if (voto == 3) {
            count3++;
        } else if (voto == 4) {
            count4++;
        } else if (voto == 5) {
            count5++;
        } else if (voto == 9) {
            count9++;
        } else if (voto == 0) {
            count0++;
        } else {
            printf("Insiriu um caracter invalido");
        }
    } while (voto != -1);




    countGlobal = count1 + count2 + count3 + count4 + count5 + count9 + count0;
    printf("\nVoto 1 : %d", count1);
    printf("\nVoto 2 : %d", count2);
    printf("\nVoto 3 : %d", count3);
    printf("\nVoto 4 : %d", count4);
    printf("\nVoto 5 : %d", count5);
    printf("\nVoto 9 : %d", count9);
    printf("\nVoto 0 : %d", count0);


    percentagem1 = ((float) count1 / countGlobal) * 100;
    percentagem2 = ((float) count2 / countGlobal) * 100;
    percentagem3 = ((float) count3 / countGlobal) * 100;
    percentagem4 = ((float) count4 / countGlobal) * 100;
    percentagem5 = ((float) count5 / countGlobal) * 100;
    percentagem9 = ((float) count9 / countGlobal) * 100;
    percentagem0 = ((float) count0 / countGlobal) * 100;

    printf("A percentagem de votos da 1 é: %.2f%%\n", percentagem1);
    printf("A percentagem de votos da 2 é: %.2f%%\n", percentagem2);
    printf("A percentagem de votos da 3 é: %.2f%%\n", percentagem3);
    printf("A percentagem de votos da 4 é: %.2f%%\n", percentagem4);
    printf("A percentagem de votos da 5 é: %.2f%%\n", percentagem5);
    printf("A percentagem de votos da 9 é: %.2f%%\n", percentagem9);
    printf("A percentagem de votos da 0 é: %.2f%%\n", percentagem0);




}

void P3() {


    int codigoFuncionario, dias;
    float valorIliquido, valorSubsidioAlimentacao;
    float valorATirarDoIRS, valorComIRSRetirado;
    float valorParaEntidadePatronal, valorLiquido, totalAPagarImpostos, segurancaSocial, totalAPagarSubsidios, totalAPagarVencimento;
    char cargo, op;

    do {
        do {
            printf("Diga o seu código de funcionário: ");
            scanf("%d", &codigoFuncionario);
        } while (codigoFuncionario < 0);

        do {
            printf("Diga o seu cargo de trabalho --> E - empregado  C - chefe  A - administrador: ");
            scanf(" %c", &cargo);
        } while (cargo != 'E' && cargo != 'C' && cargo != 'A');

        do {
            printf("Diga o número de dias que trabalhou: ");
            scanf("%d", &dias);
        } while (dias < -1);

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
                valorIliquido = 80 * dias;
                valorSubsidioAlimentacao = dias * 7.5;
                break;
            default:
                printf("Inseriu um cargo inválido\n");
                break;
        }


        for (int irs = 0; irs <= valorATirarDoIRS; irs++) {
            if (valorIliquido < 1000) {
                valorATirarDoIRS = valorIliquido * 0.1;
            } else if (valorIliquido >= 1000) {
                valorATirarDoIRS = valorIliquido * 0.2;
            } else {
                valorATirarDoIRS = valorIliquido * 0.3;
            }
        }

        for (int um = 1; um <= 1; um++) {
            if (cargo == 'A') {
                segurancaSocial = valorIliquido * 0.09;
                valorParaEntidadePatronal = valorIliquido * 0.21;
            } else {
                segurancaSocial = valorIliquido * 0.11;
                valorParaEntidadePatronal = valorIliquido * 0.2375;
            }
        }


        for (int dia = 1; dia <= dias; dia++) {
            if (dia > 20) {
                valorIliquido += valorIliquido * 0.05;
            } else if (dia > 17) {
                valorIliquido += valorIliquido * 0.02;
            }
        }

        valorLiquido = valorIliquido + valorSubsidioAlimentacao - valorATirarDoIRS - segurancaSocial;

        printf("\nO valor ilíquido é: %.2f", valorIliquido);
        printf("\nO valor do subsídio de alimentação é: %.2f", valorSubsidioAlimentacao);
        printf("\nO valor a pagar ao estado de IRS é: %.2f", valorATirarDoIRS);
        printf("\nO valor da Segurança Social é: %.2f", segurancaSocial);
        printf("\nO valor da entidade Patronal é: %.2f", valorParaEntidadePatronal);
        printf("\nO valor líquido é: %.2f\n", valorLiquido);

        totalAPagarVencimento += valorLiquido;
        totalAPagarSubsidios += valorSubsidioAlimentacao;
        totalAPagarImpostos += valorATirarDoIRS + segurancaSocial + valorParaEntidadePatronal;
        printf("\nTotal a pagar de salário aos funcionários: %f", totalAPagarVencimento);
        printf("\nTotal a pagar de subsidios: %f", totalAPagarSubsidios);
        printf("\nTotal a pagar de impostos: %f", totalAPagarImpostos);

        printf("\nQuer fazer outro calculo? Diga s/S");
        scanf(" %c", &op);
    } while (op == 's' || op == 'S');
}

int main(int argc, char** argv) {

    P3();


    return (EXIT_SUCCESS);
}

