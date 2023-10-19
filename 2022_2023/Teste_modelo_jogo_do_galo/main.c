/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Miguel
 *
 * Created on 28 de novembro de 2022, 14:21
 */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <time.h>


char board[3][3];
const char jogador1 = '0';  
const char jogador2 = '1';

void resetBoard();
void imprimeMatriz();
int verificaPosicaoVazia();
void obtemCoord();
void computerMove();
char verificaVitoria();
void printWinner(char);

int main()
{
   char winner = ' ';
   char response = ' ';

   do
   {
      winner = ' ';
      response = ' ';
      resetBoard();

      while(winner == ' ' && verificaPosicaoVazia() != 0)
      {
         imprimeMatriz();

         obtemCoord();
         winner = verificaVitoria();
         if(winner != ' ' || verificaPosicaoVazia() == 0)
         {
            break;
         }

         computerMove();
         winner = verificaVitoria();
         if(winner != ' ' || verificaPosicaoVazia() == 0)
         {
            break;
         }
      }

      imprimeMatriz();
      printWinner(winner);

      printf("\nGostavas de jodar outra vez? (Y/N): ");
      scanf("%c");
      scanf("%c", &response);
      response = toupper(response);
   } while (response == 'Y');

   printf("Obrigado por jogar!");

   return 0;
}

void resetBoard()
{
   for(int i = 0; i < 3; i++)
   {
      for(int j = 0; j < 3; j++)
      {
         board[i][j] = ' ';
      }
   }
}
void imprimeMatriz()
{
   printf(" %c | %c | %c ", board[0][0], board[0][1], board[0][2]);
   printf("\n---|---|---\n");
   printf(" %c | %c | %c ", board[1][0], board[1][1], board[1][2]);
   printf("\n---|---|---\n");
   printf(" %c | %c | %c ", board[2][0], board[2][1], board[2][2]);
   printf("\n");
}
int verificaPosicaoVazia()
{
   int freeSpaces = 9;

   for(int i = 0; i < 3; i++)
   {
      for(int j = 0; j < 3; j++)
      {
         if(board[i][j] != ' ')
         {
            freeSpaces--;
         }
      }
   }
   return freeSpaces;
}
void obtemCoord()
{
   int x;
   int y;

   do
   {
      printf("Diga a linha #(0-2): ");
      scanf("%d", &x);
      
      printf("Diga a coluna #(0-2): ");
      scanf("%d", &y);
     

      if(board[x][y] != ' ')
      {
         printf("Movimento inválido!\n");
      }
      else
      {
         board[x][y] = jogador1;
         break;
      }
   } while (board[x][y] != ' ');
   
   
   
   
}
void computerMove()
{
   //creates a seed based on current time
   srand(time(0));
   int x;
   int y;

   if(verificaPosicaoVazia() > 0)
   {
      do
      {
         x = rand() % 3;
         y = rand() % 3;
      } while (board[x][y] != ' ');
      
      board[x][y] = jogador2;
   }
   else
   {
      printWinner(' ');
   }
}
char verificaVitoria()
{
   //check rows
   for(int i = 0; i < 3; i++)
   {
      if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
      {
         return board[i][0];
      }
   }
   //check columns
   for(int i = 0; i < 3; i++)
   {
      if(board[0][i] == board[1][i] && board[0][i] == board[2][i])
      {
         return board[0][i];
      }
   }
   //check diagonals
   if(board[0][0] == board[1][1] && board[0][0] == board[2][2])
   {
      return board[0][0];
   }
   if(board[0][2] == board[1][1] && board[0][2] == board[2][0])
   {
      return board[0][2];
   }

   return ' ';
}
void printWinner(char winner)
{
   if(winner == jogador1)
   {
      printf("Ganhaste!");
   }
   else if(winner == jogador2)
   {
      printf("Perdeste!");
   }
   else{
      printf("Empate!");
   }
}

