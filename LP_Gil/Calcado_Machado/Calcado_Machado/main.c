#include <stdio.h>
#include <stdlib.h>
#include "Machado.h"
#include "input.h"


int main() {
    int Menu = 0, Menu_Adm = 0, Menu_Cli = 0, Menu_Crud_cli = 0, Menu_Precos = 0, Menu_Artigos = 0;
    Clientes clientes = {.contador = 0};
    Artigos artigos = {.contador = 0};
    do{
        switch( Menu ){
            default: 
                do{
                    menu_ini();
                    scanf("%d",&Menu);
                    system("clear");
                    if(Menu < 0 || Menu > 2){
                        msg_error();
                    }
                }while(Menu < 0 || Menu > 2);
                break;
                
            case 1://cliente
                
                do{
                    switch(Menu_Cli){
                        default:
                            do{
                                menu_cli();
                                scanf("%d",&Menu_Cli);
                                system("clear");
                                if(Menu_Cli < 0 || Menu_Cli > 2){
                                    msg_error();
                                }
                            }while(Menu_Cli < 0 || Menu_Cli > 2);
                            break;
                        case 1: //login
                            if(procurarClientes(clientes) == 1){
                                //codigo apos login
                            }
                            Menu_Cli = -1;
                            system("clear");
                            break;
                        case 2: //criar conta
                            inserirClientes(&clientes);
                            Menu_Cli = -1;
                            system("clear");
                            break;
                    }
                }while(Menu_Cli != 0);
                
                Menu = -1;
                system("clear");
                break;
                
            case 2://Adm
                
                do{
                    switch(Menu_Adm){
                        default:
                            do{
                                menu_adm();
                                scanf("%d",&Menu_Adm);
                                system("clear");
                                if(Menu_Adm < 0 || Menu_Adm > 3){
                                    msg_error();
                                }
                            }while(Menu_Adm < 0 || Menu_Adm > 3);
                            break;
                        case 1: //Crud clientes
                            do{
                                switch(Menu_Crud_cli){
                                    default:
                                        do{
                                            menu_crud_cli();
                                            scanf("%d",&Menu_Crud_cli);
                                            if(Menu_Crud_cli < 0 || Menu_Crud_cli > 4){
                                                msg_error();
                                            }
                                        }while(Menu_Crud_cli < 0 || Menu_Crud_cli > 4);
                                        break;
                                    case 1:
                                        inserirClientes(&clientes);
                                        Menu_Crud_cli = -1;
                                        system("clear");
                                        break;
                                    case 2:
                                        system("clear");
                                        listarClientes(clientes);
                                        Menu_Crud_cli = -1;
                                        break;
                                    case 3:
                                        editarClientes(&clientes);
                                        Menu_Crud_cli = -1;
                                        system("clear");
                                        break;
                                    case 4:
                                        eliminarClientes(&clientes);
                                        Menu_Crud_cli = -1;
                                        system("clear");
                                        break;
                                }
                            }while(Menu_Crud_cli != 0);
                            Menu_Adm = -1;
                            system("clear");
                            break;
                        case 2: //Crud artigos
                            do{
                                switch(Menu_Artigos){
                                    default:
                                        do{
                                            menu_crud_artigos();
                                            scanf("%d",&Menu_Artigos);
                                            if(Menu_Artigos < 0 || Menu_Artigos > 4){
                                                msg_error();
                                            }
                                        }while(Menu_Artigos < 0 || Menu_Artigos > 4);
                                        break;
                                    case 1:
                                        inserirArtigos(&artigos);
                                        Menu_Artigos = -1;
                                        system("clear");
                                        break;
                                    case 2:
                                        system("clear");
                                        listarArtigos(artigos);
                                        Menu_Artigos = -1;
                                        break;
                                    case 3:
                                        editarArtigos(&artigos);
                                        Menu_Artigos = -1;
                                        system("clear");
                                        break;
                                    case 4:
                                        eliminarArtigos(&artigos);
                                        Menu_Artigos = -1;
                                        system("clear");
                                        break;
                                }
                            }while(Menu_Artigos != 0);
                            Menu_Adm = -1;
                            system("clear");
                            break;
                        case 3: //crud preços
                            menu_crud_precos();
                            scanf("%d",&Menu_Precos);
                            Menu_Adm = -1;
                            system("clear");
                            break;
                    }
                }while(Menu_Adm != 0);
                
                Menu = -1;
                system("clear");
                break;
                
        }
    }while(Menu != 0);
    msg_adeus();
    return (0);
}