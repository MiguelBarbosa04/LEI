/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include "myIntLib.h"

int somar(int n1, int n2) {


    int res = n1 + n2;

    printf("O resultado é: %d\n", res);
    return res;


}

int sub(int n1, int n2) {



    int res = n1 - n2;
    printf("O resultado é: %d\n", res);

    return res;


}

int multi(int n1, int n2) {


    int res = n1 * n2;
    printf("O resultado é: %d\n", res);

    return res;

}

int divi(int n1, int n2) {
    if (n2 != 0) {

        int res = n1 / n2;

        printf("O resultado é: %d\n", res);

        return res;
    } else {
        printf("Erro: Divisão por zero.\n");
        return 0;
    }
}

int limites(int inferior, int superior) {

    int n;

    do {
        printf("\nDiga um número: ");
        scanf("%d", &n);


        if (n < inferior || n > superior) {
            printf("\nDiga um número entre os intervalos que definiu");
        }
    } while (n < inferior || n > superior);

    return n;

}

void imprimir(int n) {

    for (int i = 0; i < n; i++) {
        printf("*");
    }
    printf("\n");
}

void somarElementos(int m1[3][3], int m2[3][3]) {

    int cont = 0;
    int newm[3][3];

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            newm[i][j] = m1[i][j] + m2[i][j];
            cont += newm[i][j];
        }
    }

    printf("A soma dos elementos é : %d", cont);


}

void somarm(int m1[3][3], int m2[3][3]) {

    int newm[3][3];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            newm[i][j] = m1[i][j] + m2[i][j];
        }
    }

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%d", newm[i][j]);
        }
        printf("\n");
    }

}

float media(int soma, int tamanho) {

    float mediaTeste;

    mediaTeste = (float) soma / (float) tamanho;

    return mediaTeste;
}

void valorMinAndMax(int n1, int n2) {

    if (n1 == n2) {
        do {
            printf("Os valores não podem ser iguais por favor muda as variaveis");

            printf("\n Novo valor do n1:");
            scanf("%d", &n1);

            printf("\n Novo valor do n2:");
            scanf("%d", &n2);
        } while (n1 == n2);
    }

    if (n1 > n2) {
        printf("\nO valor máximo é: %d", n1);
        printf("\nO valor minino é : %d ", n2);
    } else {
        printf("\nO valor máximo é: %d", n2);
        printf("\nO valor minino é :%d ", n1);
    }

}

int potencia(int x, int y) {

    if (y == 0) {
        return 1;
    } else {
        return x * potencia(x, y - 1);
    }
}

void lerDiasTrabalhados(int diasArray[]) {
    for (int i = 0; i < 12; i++) {
        do {
            printf("Diga o número de dias que trabalhou para o mês %d: ", i + 1);
            scanf("%d", &diasArray[i]);

            if (diasArray[i] < 0 || diasArray[i] > 31) {
                printf("O número de dias não pode ser negativo nem maior que 31. Tente novamente.\n");
            }
        } while (diasArray[i] < 0 || diasArray[i] > 31);
    }

}

void calcularVencimento(char cargo, int diasArray[], float valorIliquidoArray[], float valorSubsidioAlimentacaoArray[]) {

    switch (cargo) {
        case 'E':
            for (int i = 0; i < 12; i++) {
                valorIliquidoArray[i] = 40 * diasArray[i];
                valorSubsidioAlimentacaoArray[i] = diasArray[i] * 5;
            }
            break;
        case 'C':
            for (int i = 0; i < 12; i++) {
                valorIliquidoArray[i] = 60 * diasArray[i];
                valorSubsidioAlimentacaoArray[i] = diasArray[i] * 7.5;
            }
            break;
        case 'A':
            for (int i = 0; i < 12; i++) {
                valorIliquidoArray[i] = 80 * diasArray[i];
                valorSubsidioAlimentacaoArray[i] = diasArray[i] * 7.5;
            }
            break;
        default:
            printf("Inseriu um cargo inválido\n");
            break;
    }
}

void calcularIRS(float valorATirarDoIRSArray[], float valorIliquidoArray[]) {

    for (int i = 0; i < 12; i++) {


        for (int irs = 0; irs <= valorATirarDoIRSArray[i]; irs++) {
            if (valorIliquidoArray[i] < 1000) {
                valorATirarDoIRSArray[i] = valorIliquidoArray[i] * 0.1;
            } else if (valorIliquidoArray[i] >= 1000) {
                valorATirarDoIRSArray[i] = valorIliquidoArray[i] * 0.2;
            } else {
                valorATirarDoIRSArray[i] = valorIliquidoArray[i] * 0.3;
            }
        }
    }

}

void resetarArrays(float totalAPagarVencimentoArray[], float totalAPagarSubsidiosArray[], float totalAPagarImpostosArray[], float segurancaSocialArray[], float valorATirarDoIRSArray[]) {
    for (int i = 0; i < 12; i++) {
        totalAPagarVencimentoArray[i] = 0;
        totalAPagarSubsidiosArray[i] = 0;
        totalAPagarImpostosArray[i] = 0;
        segurancaSocialArray[i] = 0;
        valorATirarDoIRSArray[i] = 0;
    }

}

void calcularSegurancaSocial(char cargo, float segurancaSocialArray[], float valorIliquidoArray[], float valorParaEntidadePatronalArray[]) {
    for (int i = 0; i < 12; i++) {
        for (int um = 1; um <= 1; um++) {
            if (cargo == 'A') {
                segurancaSocialArray[i] = valorIliquidoArray[i] * 0.09;
                valorParaEntidadePatronalArray[i] = valorIliquidoArray[i] * 0.21;
            } else {
                segurancaSocialArray[i] = valorIliquidoArray[i] * 0.11;
                valorParaEntidadePatronalArray[i] = valorIliquidoArray[i] * 0.2375;
            }
        }
    }

}

void calcularValorIliquido(int diasArray[], float valorIliquidoArray[]) {
    for (int i = 0; i < 12; i++) {
        for (int dia = 1; dia <= diasArray[i]; dia++) {
            if (dia > 20) {
                valorIliquidoArray[i] += valorIliquidoArray[i] * 0.05;
            } else if (dia > 17) {
                valorIliquidoArray[i] += valorIliquidoArray[i] * 0.02;
            }
        }
    }
}

void calcularValorLiquido(float valorLiquidoArray[], float valorIliquidoArray[], float valorSubsidioAlimentacaoArray[], float valorATirarDoIRSArray[], float segurancaSocialArray[]) {
    for (int i = 0; i < 12; i++) {
        valorLiquidoArray[i] = valorIliquidoArray[i] + valorSubsidioAlimentacaoArray[i] - valorATirarDoIRSArray[i] - segurancaSocialArray[i];
    }
}

void imprimirResultados(int codigoFuncionario, float valorIliquidoArray[], float valorSubsidioAlimentacaoArray[],
        float valorATirarDoIRSArray[], float segurancaSocialArray[], float valorParaEntidadePatronalArray[],
        float valorLiquidoArray[], float totalAPagarVencimentoArray[], float totalAPagarSubsidiosArray[],
        float totalAPagarImpostosArray[]) {

    float valorLiquidoTodosMeses = 0, encargoTotalTodosMeses = 0;
    for (int i = 0; i < 12; i++) {
        printf("\nMês %d:", i + 1);
        printf("\n  Valor ilíquido: %.2f", valorIliquidoArray[i]);
        printf("\n  Subsídio de alimentação: %.2f", valorSubsidioAlimentacaoArray[i]);
        printf("\n  Valor a pagar ao IRS: %.2f", valorATirarDoIRSArray[i]);
        printf("\n  Segurança Social: %.2f", segurancaSocialArray[i]);
        printf("\n  Valor para entidade patronal: %.2f", valorParaEntidadePatronalArray[i]);
        printf("\n  Valor líquido: %.2f\n", valorLiquidoArray[i]);

        totalAPagarVencimentoArray[i] += valorLiquidoArray[i];
        totalAPagarSubsidiosArray[i] += valorSubsidioAlimentacaoArray[i];
        totalAPagarImpostosArray[i] += valorATirarDoIRSArray[i] + segurancaSocialArray[i] + valorParaEntidadePatronalArray[i];
    }

    printf("\nResumo para o funcionário %d:", codigoFuncionario);
    printf("\n  Valor líquido total: %.2f\n", valorLiquidoTodosMeses);

    printf("\nResumo para a empresa:");
    printf("\n  Encargo total de todos os meses: %.2f\n", encargoTotalTodosMeses);
}