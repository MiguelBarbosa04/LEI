/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Miguel
 *
 * Created on 9 de novembro de 2023, 16:54
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

void P3() {

    int diasArray[12];
    float valorIliquidoArray[12], valorATirarDoIRSArray[12], valorParaEntidadePatronalArray[12], valorLiquidoArray[12], valorSubsidioAlimentacaoArray[12];
    float segurancaSocialArray[12], totalAPagarVencimentoArray[12], totalAPagarSubsidiosArray[12], totalAPagarImpostosArray[12];
    float valorLiquidoTodosMeses = 0, encargoTotalTodosMeses = 0;
    int codigoFuncionario, dias;
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


        for (int i = 0; i < 12; i++) {
            do {
                printf("Diga o número de dias que trabalhou para o mês %d: ", i + 1);
                scanf("%d", &dias);

                if (dias < 0) {
                    printf("O número de dias não pode ser negativo. Tente novamente.\n");
                }
                if (dias > 31) {
                    printf("O número de dias não pode ser maior que 31. Tente novamente.\n");
                }
            } while (dias < 0 || dias > 31);

            diasArray[i] = dias;
        }


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

        for (int i = 0; i < 12; i++) {
            totalAPagarVencimentoArray[i] = 0;
            totalAPagarSubsidiosArray[i] = 0;
            totalAPagarImpostosArray[i] = 0;
        }


        for (int i = 0; i < 12; i++) {

            valorATirarDoIRSArray[i] = 0;
            segurancaSocialArray[i] = 0;
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


        for (int i = 0; i < 12; i++) {
            for (int dia = 1; dia <= diasArray[i]; dia++) {
                if (dia > 20) {
                    valorIliquidoArray[i] += valorIliquidoArray[i] * 0.05;
                } else if (dia > 17) {
                    valorIliquidoArray[i] += valorIliquidoArray[i] * 0.02;
                }
            }
        }

        for (int i = 0; i < 12; i++) {
            valorLiquidoArray[i] = valorIliquidoArray[i] + valorSubsidioAlimentacaoArray[i] - valorATirarDoIRSArray[i] - segurancaSocialArray[i];
        }

        for (int i = 0; i < 12; i++) {
            printf("\nO valor ilíquido do mes %d é: %.2f", i, valorIliquidoArray[i]);
            printf("\nO valor do subsídio de alimentação do mes %d é: %.2f", i, valorSubsidioAlimentacaoArray[i]);
            printf("\nO valor a pagar ao estado de IRS do mes %d é: %.2f", i, valorATirarDoIRSArray[i]);
            printf("\nO valor da Segurança Social do mes %d é: %.2f", i, segurancaSocialArray[i]);
            printf("\nO valor da entidade Patronal do mes %d é: %.2f", i, valorParaEntidadePatronalArray[i]);
            printf("\nO valor líquido do mes %d é: %.2f\n", i, valorLiquidoArray[i]);

            totalAPagarVencimentoArray[i] += valorLiquidoArray[i];
            totalAPagarSubsidiosArray[i] += valorSubsidioAlimentacaoArray[i];
            totalAPagarImpostosArray[i] += valorATirarDoIRSArray[i] + segurancaSocialArray[i] + valorParaEntidadePatronalArray[i];
            printf("\nTotal a pagar de salário aos funcionários no mes %d : %.2f", i, totalAPagarVencimentoArray[i]);
            printf("\nTotal a pagar de subsidios no mes %d: %.2f", i, totalAPagarSubsidiosArray[i]);
            printf("\nTotal a pagar de impostos no mes %d: %.2f", i, totalAPagarImpostosArray[i]);
        }

        printf("\nO funcionário %d teve um valor liquido total de:", codigoFuncionario);
        for (int i = 0; i < 12; i++) {
            valorLiquidoTodosMeses += valorLiquidoArray[i];
        }
        printf("%.2f", valorLiquidoTodosMeses);



        printf("\nA empresa vai ter um encargo total de todos os meses de :");
        for (int i = 0; i < 12; i++) {
            encargoTotalTodosMeses += valorLiquidoArray[i];
            encargoTotalTodosMeses += totalAPagarSubsidiosArray[i];
            encargoTotalTodosMeses += totalAPagarImpostosArray[i];
        }
        printf("%.2f", encargoTotalTodosMeses);



        printf("\nQuer fazer outro calculo? Diga s/S");
        scanf(" %c", &op);
    } while (op == 's' || op == 'S');
}

void P2ex5() {
    char str[100];
    printf("Diga uma string: ");
    fgets(str, sizeof (str), stdin);


    int length = strlen(str);

    for (int i = 0; i < length / 2; i++) {
        char temp = str[i];
        str[i] = str[length - i - 1];
        str[length - i - 1] = temp;
    }

    printf("String invertida: %s\n", str);


}

void P2ex4() {

    int a[4][4] = {
        {1, 2, 3, 4},
        {7, 8, 9, 0},
        {1, 1, 1, 1},
        {3, 3, 3, 3}
    };

    for (int i = 0; i < 4 / 2; i++) {
        for (int j = i; j < 4 - i - 1; j++) {

            int temp = a[i][j];
            a[i][j] = a[4 - 1 - j][i];
            a[4 - 1 - j][i] = a[4 - 1 - i][4 - 1 - j];
            a[4 - 1 - i][4 - 1 - j] = a[j][4 - 1 - i];
            a[j][4 - 1 - i] = temp;
        }
    }



    printf("A matriz depois de 90 graus:\n ");
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            printf("%d\t", a[i][j]);
        }
    }



}

void P2ex3() {

    int m[3][3];
    int m2[3][3];


    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("Diga o valor da posição [%d][%d]", i, j);
            scanf("%d", &m[i][j]);
        }
    }


    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            m2[i][j] = m[j][i];
        }
    }


    printf("A matriz 1 é : ");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%d\t", m[i][j]);
        }
        printf("\n");
    }

    printf("A matriz 2 é : ");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%d\t", m2[i][j]);
        }
        printf("\n");
    }
}

void P2ex2() {


    int tamanhoMatriz;

    printf("Digite o tamanho do array: ");
    scanf("%d", &tamanhoMatriz);

    int array[tamanhoMatriz];
    int count = 0;
    int num = 2;

    while (count < tamanhoMatriz) {
        int prime = 1;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                prime = 0;
                break;
            }
        }

        if (prime == 1) {
            array[count] = num;
            count++;
        }

        num++;
    }

    printf("O array é: ");
    for (int i = 0; i < tamanhoMatriz; i++) {
        printf("%d ", array[i]);
    }


}

void P2ex1() {

    int array[10];
    int par = 0;
    for (int i = 0; i < 10; i++) {
        printf("Diga o valor %d : ", i);
        scanf("%d", &array[i]);
    }

    for (int i = 0; i < 10; i++) {
        if (array[i] % 2 == 0 && array[i] > par) {
            par = array[i];
        }
    }

    if (par != 0) {
        printf("O maior valor par é: %d\n", par);
    } else {
        printf("Não existe valor par.\n");
    }


}

void ex5() {

    char str1[100], str2[100];

    printf("Digite a primeira string: ");
    fgets(str1, sizeof (str1), stdin);
    puts(str1);

    printf("Digite a segunda string: ");
    fgets(str2, sizeof (str2), stdin);
    puts(str2);


    if ((strcmp(str1, str2)) == 0) {
        printf("As strings são iguais.\n");
    } else {
        printf("As strings são diferentes.\n");
    }
}

void ex4() {

    int mat[3][3];
    int menor, maior;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("Diga o valore da posicao [%d][%d] : ", i, j);
            scanf("%d", &mat[i][j]);
        }
    }

    menor = mat [0][0];
    maior = mat [0][0];


    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (mat[i][j] < menor) {
                menor = mat[i][j];
            }
        }
    }

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (mat[i][j] > maior) {
                maior = mat[i][j];
            }
        }
    }

    printf("O menor é: %d", menor);
    printf("\nO maior é: %d", maior);


    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%d\t", mat[i][j]);
        }
        printf("\n");
    }


}

void ex3() {



    int array[4][5];
    int num, count = 0;

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 5; j++) {
            printf("Diga os valores de [%d][%d]: ", i, j);
            scanf(" %d", &array[i][j]);
        }
    }

    printf("Diga o número que quer encontrar: ");
    scanf(" %d", &num);

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 5; j++) {
            if (array[i][j] == num) {
                count++;
            }
        }
    }

    printf("O número de vezes que aparece na matriz é %d vezes", count);

}

void ex2() {


    const int TAM = 4;
    char array[TAM];
    char letra;

    for (int i = 0; i < TAM; i++) {
        printf("Diga uma letra: ");
        scanf(" %c", &letra);
        array[i] = letra;
    }

    printf("O texto cifrado fica: ");
    for (int i = 0; i < TAM; i++) {
        array[i] += 4;
        printf("%c", array[i]);
    }

}

void ex1() {


    const int TAM = 10;
    float array[TAM];
    float preco, count = 0;
    for (int i = 0; i < TAM; i++) {
        printf("diga o preço de um produto: ");
        scanf("%f", &preco);
        array[i] = preco;
    }

    for (int i = 0; i < TAM; i++) {
        count += array[i];
    }

    printf("O total é: %2.0f", count);


}

int main(int argc, char** argv) {

    P3();

    return (EXIT_SUCCESS);
}

