/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.utils;

/**
 *
 * @author lucas
 */
public class Formata {
    
    private Formata(){}
    
    public static Integer getInteger(String valor) {
        try {
            if (valor != null && !valor.isEmpty()) {
                return Integer.valueOf(valor.replaceAll("[\\D]", "").trim());
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
