#include <stdio.h>

int codDesc(int desc){
    const int codSecr = 123;
    do{
        if(desc == codSecr) {
            printf("codigo em uso \n");
        } else {
            printf("sem codigo ativado \n");
        }
        printf("tem algum codigo de desconto? ");
        scanf("%d", &desc);
        printf("\e[1;1H\e[2J");
        if(desc != codSecr && desc > 0 && desc < 999) {
            printf("nao existe esse codigo.\n");
        } else if(desc == codSecr){
            printf("codigo ativado.\n");
        }else if(desc < 0 || desc > 999){
            printf("insira um valor positivo menor que 999.\n");
        }
    }while(desc<0 || desc>999);
    return desc;
}

int funNif(int nif){
    do{
        if(nif > 0 && nif < 999){
            printf("NIF atual: %d\n",nif);
        }
        printf("insira o seu NIF: ");
        scanf("%d", &nif);
        printf("\e[1;1H\e[2J");
        if(nif > 0 && nif < 999){
            printf("O seu NIF foi atualizado para: %d\n",nif);
        }else{
            printf("insira um nif positivo menor que 999.\n");
        }
    }while(nif < 0 || nif > 999);
    return nif;
}

int menuInicial(int menuAdm){
    int menu, menu2;
    do{
        printf("1-NIF \n2-codigo de desconto \n3-tipo de cliente \n4-conta \n5-sair\n");
        if(menuAdm == 0){
            printf("6-atualizar preços\n");
        }
        scanf("%d", &menu);
        menu2 = 0;
        printf("\e[1;1H\e[2J");
        if(menu < 0 || menu > 6){
            printf("introduza um valor no menu positivo menor que 7.\n");
        }
    }while(menu < 0 || menu > 6);
    return menu;
}

int desc = 0;
const int codSecr = 123;
int nif = 0;
int descClie, descSan, descCod;
float lucro = 0, lucro1 = 0, lucro2 = 0, desconto, rest = 0, rest1 = 0, rest2 = 0 , total, mao = 0, mao1 = 0, mao2 = 0, troc, pag;
int cinq, vint, dez, cinc, doi, eur, cent50, cent20, cent10, cent5, cent2, cent;
int enc = 0, clie = 0, op = 0, opp = 0;
int utl = 1, menuLucro = 0, menuObra = 0, menuDesc = 0, menuAdc = 0, menuNum = 0, menuNum1 = 0, menuNum2 = 0, obraBotas = 7, obraSandalias = 4, obraOutros = 5;
float numMen = 0.1, numMen1 = 0.2, numMai = 0.15, numMai1 = 0.25, numMed = 0, numMed1 = 0, lucroBotas = 0.4, lucroSandalias = 0.25, lucroOutros = 0.3, DescSandalias = 0.15, DescCodigo = 0.05, DescRevendedor = 0.1, AdcBotas = 3.5, AdcSandalias = 3.0, AdcOutros = 3.0;
int sap[12],bot[12],san[12];
float pre[12], pre1[12];
int l=0, j=0, w=0;

void funConta(int op, int opp, int enc){
    switch(op) {
        case 1:
            for(j=1;j<13;j++){
                if(opp == j){
                    if(opp<=3){
                        mao = enc * obraOutros * 2 * (1-pre[j-1]);
                        rest = enc * AdcOutros * (1-pre1[j-1]);
                    }else if(opp>=9){
                        mao = enc * obraOutros * 2 * (1-pre[j-1]);
                        rest = enc * AdcOutros * (1-pre1[j-1]);
                    }else{
                        mao = enc * obraOutros * 2 * (1+pre[j-1]);
                        rest = enc * AdcOutros * (1+pre1[j-1]);
                    }
                }
            }
            lucro = (rest + mao) * lucroOutros;
            printf("\e[1;1H\e[2J");
            for(l = 0; l < 12; l++){
            if(op == 1 && l+1 == opp){
                sap[l] += (enc);
            }else if(op == 2 && l+1 == opp){
                san[l] += (enc);
            }else if (op == 3 && l+1 == opp){
                bot[l] += (enc);
            }
        }
            op = 0;
            break;

        case 2:
            for(j=1;j<13;j++){
                if(opp == j){
                    if(opp<=3){
                        mao1 = enc * obraSandalias * 2 * (1-pre[j-1]);
                        rest1 = enc * AdcSandalias * (1-pre1[j-1]);
                    }else if(opp>=9){
                        mao1 = enc * obraSandalias * 2 * (1-pre[j-1]);
                        rest1 = enc * AdcSandalias * (1-pre1[j-1]);
                    }else{
                        mao1 = enc * obraSandalias * 2 * (1+pre[j-1]);
                        rest1 = enc * AdcSandalias * (1+pre1[j-1]);
                    }
                }
            }
            lucro1 = (rest1 + mao1) * lucroSandalias;
            printf("\e[1;1H\e[2J");
            for(l = 0; l < 12; l++){
            if(op == 1 && l+1 == opp){
                sap[l] += (enc);
            }else if(op == 2 && l+1 == opp){
                san[l] += (enc);
            }else if (op == 3 && l+1 == opp){
                bot[l] += (enc);
            }
        }
            op = 0;
            break;

        case 3:
            for(j=1;j<13;j++){
                if(opp == j){
                    if(opp<=3){
                        mao2 = enc * obraBotas * 2 * (1-pre[j-1]);
                        rest2 = enc * AdcBotas * (1-pre1[j-1]);
                    }else if(opp>=9){
                        mao2 = enc * obraBotas * 2 * (1-pre[j-1]);
                        rest2 = enc * AdcBotas * (1-pre1[j-1]);
                    }else{
                        mao2 = enc * obraBotas * 2 * (1+pre[j-1]);
                        rest2 = enc * AdcBotas * (1+pre1[j-1]);
                    }
                }
            }
            lucro2 = (rest2 + mao2) * lucroBotas;
            printf("\e[1;1H\e[2J");
            for(l = 0; l < 12; l++){
            if(op == 1 && l+1 == opp){
                sap[l] += (enc);
            }else if(op == 2 && l+1 == opp){
                san[l] += (enc);
            }else if (op == 3 && l+1 == opp){
                bot[l] += (enc);
            }
        }
            op = 0;
            break;
        case 4:
            op = 0;
            printf("\e[1;1H\e[2J");

            printf("Nif: %d \n", nif);

            if(clie == 1) {
                printf("tipo de cliente: revendedor \n");
            } else {
                printf("tipo de cliente: cliente final \n");
            }
            for(l = 0; l < 12; l++){
                if(bot[l] != 0 || san[l] != 0 || sap[l] != 0){
                    printf("encomendou %d botas, %d sandalias, %d sapatos numero %d\n",bot[l],san[l],sap[l],l+35);
                }
            }

            printf("custo da mao de obra: %.2f\n", mao+mao1+mao2);
            printf("custo adicional: %.2f\n", rest+rest1+rest2);
            printf("lucro: %.2f\n", lucro+lucro1+lucro2);

            descClie=0;
            descSan=0;

            if(clie == 1) {
                descClie = (mao + rest + lucro + mao1 + rest1 + lucro1 + mao2 + rest2 + lucro2) * DescRevendedor;
            }
            if(op == 2) {
                descSan = (mao + rest + lucro + mao1 + rest1 + lucro1 + mao2 + rest2 + lucro2) * DescSandalias;
            }
            if(desc == codSecr) {
                descCod = (mao + rest + lucro + mao1 + rest1 + lucro1 + mao2 + rest2 + lucro2) * DescCodigo;
            }

            total = (mao + rest + lucro + mao1 + rest1 + lucro1 + mao2 + rest2 + lucro2) - (descClie + descSan + descCod);
            enc = 0;
            printf("Total: %.2f\n", total);
            printf("insira credito para o pagamento: ");
            scanf("%f",&pag);
            troc = pag - total;
            if(troc<0){
                printf("Encomenda nao efetuada por falta de fundos\n");
            }else if(troc == 0 ){
                printf("Compra sem troco\n");
            }else{
                cinq = troc / 50;
                troc = troc - (cinq * 50);
                vint = troc / 20;
                troc = troc - (vint * 20);
                dez = troc / 10;
                troc = troc - (dez * 10);
                cinc = troc / 5;
                troc = troc - (cinc * 5);
                doi = troc / 2;
                troc = troc - (doi * 2);
                eur = troc / 1;
                troc = troc - (eur * 1);
                cent50 = troc / 0.50;
                troc = troc - (cent50 * 0.50);
                cent20 = troc / 0.20;
                troc = troc - (cent20 * 0.20);
                cent10 = troc / 0.10;
                troc = troc - (cent10 * 0.10);
                cent5 = troc / 0.05;
                troc = troc - (cent5 * 0.05);
                cent2 = troc / 0.02;
                troc = troc - (cent2 * 0.02);
                cent = troc / 0.01;
                troc = troc - (cent * 0.01);
                printf("O seu troco deve ser:\n");
                if(cinq>0){
                    printf("%d notas de 50\n",cinq);
                }
                if(vint>0){
                    printf("%d notas de 20\n",vint);
                }
                if(dez>0){
                    printf("%d notas de 10\n",dez);
                }
                if(cinc>0){
                    printf("%d notas de 5\n",cinc);
                }
                if(doi>0){
                    printf("%d moedas de 2\n",doi);
                }
                if(eur>0){
                    printf("%d moedas de 1\n",eur);
                }
                if(cent50>0){
                    printf("%d moedas de 0.50\n",cent50);
                }
                if(cent20>0){
                    printf("%d moedas de 0.20\n",cent20);
                }
                if(cent10>0){
                    printf("%d moedas de 0.10\n",cent10);
                }
                if(cent5>0){
                    printf("%d moedas de 0.05\n",cent5);
                }
                if(cent2>0){
                    printf("%d moedas de 0.02\n",cent2);
                }
                if(cent>0){
                    printf("%d moedas de 0.01\n",cent);
                }
            }
        break;
    }
}