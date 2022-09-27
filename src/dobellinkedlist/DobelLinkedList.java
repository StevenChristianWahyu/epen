/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dobellinkedlist;

import java.util.Scanner;

/**
 *
 * @author STEVEN CHRISTIAN
 */
public class DobelLinkedList {

    static class Node{
        int nim;
        String nama;
        Node next;
        Node prev;
    }
    static Node head = null;
    static Node tail = null;
    static Scanner scan = new Scanner(System.in);
    static void Insert() {
        System.out.println("Masukkan nama: ");
        String nama = scan.next();
        System.out.println("Masukkan nim: ");
        int nim = scan.nextInt();
        Node newNode = new Node();
        newNode.nama = nama;
        newNode.nim = nim;
        if (head == null) {
            tail = newNode;
            newNode.next = head;
            head = newNode;
        } else if (newNode.nim >= tail.nim) {
            tail.next = newNode;
            tail = newNode;
        } else if (newNode.nim <= head.nim) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.nim >= newNode.nim) {
                    newNode.next = temp.next;
                    temp.next = newNode;
                    break;
                } else {
                    temp = temp.next;
                }
            }
        }
    }
    static void addDelete() {
        Node current;
        int delete;
        System.out.println("Masukkan input yang mau di delete: ");
        delete = scan.nextInt();
        current = head;
        if (current == head && current.nim == (delete)) {
            current = current.next;
        }
        while (current != null) {
            System.out.println(current.nim + " " + current.nama);
            if (current.next != null && current.next.nim == (delete)) {
                current = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
    static void Forward(){
        Node current = head;
        System.out.println("Print Forward: ");
        while (current != null){
            System.out.println(current.nim + "" + current.nama);
            current = current.next;
        }
    }
    static void Backward (){
        Node current = tail;
        System.out.println("Print Backward: ");
        while (current!= null){
            System.out.println(current.nim + "" + current.nama);
            current = current.prev;
        }
    }
    
    public static void main(String[] args) {
        int pilihan = 0;
        while (pilihan != 5){
            System.out.println("Menu");
            System.out.println("1.Insert/2.Print Forward/3.Print Backward/4.Delete/5.Keluar");
            pilihan = scan.nextInt();
            switch(pilihan){
                case 1:
                    Insert();
                    break;
                case 2:
                    Forward();
                    break;
                case 3:
                    Backward();
                    break;
                case 4:
                    addDelete();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Pilihan tidak terdapat pada menu");
            }
        }
    }
}
