/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author migue
 */
public class BankAccount {

    private int money = 0;

    public synchronized void putMoney() {
        money += 1250;
        System.out.println("Foi depositado");

    }

    public synchronized boolean getMoney(int valorARetirar) {
        if (money >= valorARetirar) {
            money -= valorARetirar;
            System.out.println("Retirou " + valorARetirar + " da conta ---> " + balance());
            return true;
        } else {
            System.out.println("TENTOU RETIRAR: " + valorARetirar + " --- Não foi possível retirar dinheiro");
            return false;
        }
    }

    public int balance() {
        return this.money;
    }

}
