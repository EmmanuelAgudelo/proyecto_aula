/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.tdea.edd.estructure.linkedList.singly;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Nodo<T> {
    private T data;
    private Nodo<T> next;

    Nodo(T data) {
        this.data = data;
        this.next = null;
    }
}