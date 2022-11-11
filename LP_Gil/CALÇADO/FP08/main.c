/*
 * File:   main.c
 * Author: ESTG
 */

#include <stdio.h>

#include "alunos.h"
#include "logs.h"

#define LOGS_FILE       "logs.txt"
#define CLIENTES__DB_FILE  "clientes.bin"
#define ARTIGOS_DB_FILE  "artigos.bin"
#define ENCOMENDAS_DB_FILE "encomendas.bin"
#define ENCOMENDAS_RECIBOS "vis_encs.txt"
#define RECLAMACAO "reclamaçoes.txt"

/*
 * Demonstração de gestão de registos
 */
int main() {
    int opcao ,opcao1, opcao2, opcao3, opcao4, opcao5, opcao6;
    int verificar;
    char reclamacao[150];
    Clientes clientes;
    Artigos artigos;
    Encomendas encomendas;
    if (carregarClientes(&clientes, CLIENTES__DB_FILE)) {
        if (carregarArtigos(&artigos, ARTIGOS_DB_FILE)) {
            if (carregarEncomendas(&encomendas, ENCOMENDAS_DB_FILE)) {
                carrega_val(&artigos);
                do {
                    printf("\n------------------------------------------------------------");
                    printf("\n1 - Cliente");
                    printf("\n2 - Administrador");
                    printf("\n0 - Sair");
                    printf("\n------------------------------------------------------------");

                    printf("\nOpcão: ");
                    scanf("%d", &opcao);

                    switch (opcao) {
                        case 0:
                            break;
                        case 1:
                            do {
                                printf("\nCliente-----------------------------------------------------");
                                printf("\n1 - Login");
                                printf("\n2 - Criar conta");
                                printf("\n0 - Sair");
                                printf("\n------------------------------------------------------------");

                                printf("\nOpcão: ");
                                scanf("%d", &opcao1);

                                switch (opcao1) {
                                    case 0:
                                        break;
                                    case 1:
                                        verificar = procurarClientesLog(clientes);
                                        if(verificar != -1){
                                            logMsg("Procurar_cli_cli", LOGS_FILE);
                                            do {
                                                printf("\nLogin-------------------------------------------------------");
                                                printf("\n1 - Encomendar.");
                                                printf("\n2 - Listar encomendas.");
                                                printf("\n3 - Reclamaçao.");
                                                printf("\n0 - Logout.");
                                                printf("\n------------------------------------------------------------");
                                                printf("\nEncomendas: %d/%d", encomendas.contador, encomendas.tamanho);
                                                printf("\nOpcão: ");
                                                scanf("%d", &opcao6);

                                                switch (opcao6) {
                                                    case 0:
                                                        break;
                                                    case 1:

                                                        inserirEncomendas(&encomendas, ENCOMENDAS_DB_FILE, &clientes, &artigos, verificar, ENCOMENDAS_RECIBOS);
                                                        logMsg("Inserir_cli_cli", LOGS_FILE);
                                                        
                                                        break;
                                                    case 2:
                                                        
                                                        listarEncomendas(encomendas, ENCOMENDAS_DB_FILE);
                                                        break;
                                                    case 3:
                                                        reclamar(RECLAMACAO);
                                                        break;
                                                    default:
                                                        printf("\nOpcão invalida!");
                                                }
                                            } while(opcao6 != 0);
                                            printf("\n\n\ndeu certo.");
                                        }else{
                                            printf("\ncliente nao encontrado.");
                                        }
                                        break;
                                    case 2:
                                        inserirClientes(&clientes, CLIENTES__DB_FILE);
                                        logMsg("Inserir_cli_cli", LOGS_FILE);
                                        break;
                                    default:
                                        printf("\nOpcão invalida!");
                                }
                            } while (opcao1 != 0);
                            break;
                        case 2:
                            do {
                                printf("\nAdministrador-----------------------------------------------");
                                printf("\n1 - C.R.U.D. de clientes.");
                                printf("\n2 - C.R.U.D. de artigos.");
                                printf("\n3 - C.R.U.D. das tabelas de custo.");
                                printf("\n0 - Sair");
                                printf("\n------------------------------------------------------------");

                                printf("\nOpcão: ");
                                scanf("%d", &opcao2);

                                switch (opcao2) {
                                    case 0:
                                        break;
                                    case 1:
                                        do {
                                            printf("\nC.R.U.D. de clientes----------------------------------------");
                                            printf("\n1 - Inserir");
                                            printf("\n2 - Procurar");
                                            printf("\n3 - Atualizar");
                                            printf("\n4 - Remover");
                                            printf("\n5 - Listar");
                                            printf("\n0 - Sair");
                                            printf("\n------------------------------------------------------------");
                                            printf("\nClientes: %d/%d", clientes.contador, clientes.tamanho);

                                            printf("\nOpcão: ");
                                            scanf("%d", &opcao3);

                                            switch (opcao3) {
                                                case 0:
                                                    break;
                                                case 1:
                                                    inserirClientes(&clientes, CLIENTES__DB_FILE);
                                                    logMsg("Inserir_cli", LOGS_FILE);
                                                    break;
                                                case 2:
                                                    procurarClientes(clientes);
                                                    logMsg("Procurar_cli", LOGS_FILE);
                                                    break;
                                                case 3:
                                                    atualizarClientes(&clientes, CLIENTES__DB_FILE);
                                                    logMsg("Actualizar_cli", LOGS_FILE);
                                                    break;
                                                case 4:
                                                    removerClientes(&clientes, CLIENTES__DB_FILE);
                                                    logMsg("Remover_cli", LOGS_FILE);
                                                    break;
                                                case 5:
                                                    listarClientes(clientes);
                                                    logMsg("Listar_cli", LOGS_FILE);
                                                    break;
                                                default:
                                                    printf("\nOpcão invalida!");
                                            }
                                        } while (opcao3 != 0);

                                        break;
                                    case 2:

                                        do {
                                            printf("\nC.R.U.D. de artigos-----------------------------------------");
                                            printf("\n1 - Inserir");
                                            printf("\n2 - Procurar");
                                            printf("\n3 - Atualizar");
                                            printf("\n4 - Remover");
                                            printf("\n5 - Listar");
                                            printf("\n0 - Sair");
                                            printf("\n------------------------------------------------------------");
                                            printf("\nArtigos: %d/%d", artigos.contador, artigos.tamanho);

                                            printf("\nOpcão: ");
                                            scanf("%d", &opcao3);

                                            switch (opcao3) {
                                                case 0:
                                                    break;
                                                case 1:
                                                    inserirArtigos(&artigos, ARTIGOS_DB_FILE);
                                                    logMsg("Inserir_art", LOGS_FILE);
                                                    break;
                                                case 2:
                                                    procurarArtigos(artigos);
                                                    logMsg("Procurar_art", LOGS_FILE);
                                                    break;
                                                case 3:
                                                    atualizarArtigos(&artigos, ARTIGOS_DB_FILE);
                                                    logMsg("Actualizar_art", LOGS_FILE);
                                                    break;
                                                case 4:
                                                    removerArtigos(&artigos, ARTIGOS_DB_FILE, &encomendas);
                                                    logMsg("Remover_art", LOGS_FILE);
                                                    break;
                                                case 5:
                                                    listarArtigos(artigos);
                                                    logMsg("Listar_art", LOGS_FILE);
                                                    break;
                                                default:
                                                    printf("\nOpcão invalida!");
                                            }

                                        } while (opcao3 != 0);

                                        break;
                                    case 3:
                                        do {
                                            printf("\ntabelas de custo--------------------------------------------");
                                            printf("\n1 - Editar mao de obra.");
                                            printf("\n2 - Editar custo fixo.");
                                            printf("\n3 - Editar lucro.");
                                            printf("\n4 - Editar preço de numero.");
                                            printf("\n5 - Listar preços.");
                                            printf("\n0 - Sair");
                                            printf("\n------------------------------------------------------------");
                                            printf("\nArtigos: %d/%d", artigos.contador, artigos.tamanho);

                                            printf("\nOpcão: ");
                                            scanf("%d",&opcao4);

                                            switch (opcao4) {
                                                case 0:
                                                    break;
                                                case 1:
                                                    atualizarMao_obra(&artigos, ARTIGOS_DB_FILE);
                                                    logMsg("Actualizar_Mao_Obra", LOGS_FILE);
                                                    break;
                                                case 2:
                                                    atualizarCusto_fixo(&artigos, ARTIGOS_DB_FILE);
                                                    logMsg("Actualizar_Custo_Fixo", LOGS_FILE);
                                                    break;
                                                case 3:
                                                    atualizarLucro(&artigos, ARTIGOS_DB_FILE);
                                                    logMsg("Actualizar_Lucro", LOGS_FILE);
                                                    break;
                                                case 4:
                                                    do {
                                                        printf("\nTabelas de custo--------------------------------------------");
                                                        int conta = 1+(artigos.contador);
                                                        for(int i = 1; i < conta; i++){
                                                            printf("\n%d - %s",i ,artigos.artigos->nome);
                                                        }
                                                        printf("\n0 - Sair");
                                                        printf("\n------------------------------------------------------------");
                                                        printf("\nArtigos: %d/%d", artigos.contador, artigos.tamanho);

                                                        printf("\nOpcão: ");
                                                        scanf("%d", &opcao5);
                                                        if(opcao5 < 0 || opcao5 > (artigos.contador +1)){
                                                            printf("\nOpçao invalida.");
                                                        }else{
                                                            if(opcao5 != 0){
                                                                opcao5--;
                                                                alteraTamanho(&artigos, ARTIGOS_DB_FILE, opcao5);
                                                                logMsg("Actualizar_Lucro", LOGS_FILE);
                                                                opcao5++;
                                                            }
                                                        }
                                                    } while (opcao5 != 0);
                                                    break;
                                                case 5:
                                                    listarArtigos_precos(artigos);
                                                    logMsg("Listar_art", LOGS_FILE);
                                                    break;
                                                default:
                                                    printf("\nOpcão invalida!");
                                                    break;
                                            }
                                        } while (opcao4 != 0);
                                        break;
                                    default:
                                        printf("\nOpcão invalida!");
                                }

                            } while (opcao2 != 0);
                            break;
                        default:
                            printf("\nOpcão invalida!");
                    }
                } while (opcao != 0);
            } else {
                puts("Não foi possível criar o ficheiro de armazenamento.");
            }
        } else {
            puts("Não foi possível criar o ficheiro de armazenamento.");
        }
    } else {
        puts("Não foi possível criar o ficheiro de armazenamento.");
    }
    libertarArtigos(&artigos);
    libertarClientes(&clientes);
    return 0;
}
