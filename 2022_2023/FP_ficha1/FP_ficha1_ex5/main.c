/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 14 de outubro de 2022, 09:37
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

        int a = 2, b = 4, c = 3, d;
        d = (((a = a + 1) + ++b) * c++) % (2 * c);
        printf("%d, %d, %d, %d", a, b, c, d);
        return 0;
}
   
    /*
    
                      
                      c= 4
                      ((3+5) * 3) % (6)
                      24 % 6 
                      0
                      a = 2
                      B = 5
                      C = 4
                      D = 0*/