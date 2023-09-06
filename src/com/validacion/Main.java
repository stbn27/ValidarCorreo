/*
 * Fecha de creacion: 05/09/2023 14:36:43
 * Version: v.0.1
 * Detalles: 
 */
package com.validacion;

import java.util.Scanner;

/**
 * @author Willy Stbn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String correo = "";
        Scanner in = new Scanner(System.in);

        System.out.print("Ingrese el correo a validar: ");
        correo = in.nextLine();

        System.out.println("\n... Validando correo\n");

        int totalPuntos = 0;
        int totalArrobas = 0;

        for (int i = 0; i < correo.length(); i++) {
            if (correo.charAt(i) == '@') {
                totalArrobas++;
            }
            if (correo.charAt(i) == '.') {
                totalPuntos++;
            }

        }

        if (totalArrobas == 1 && totalPuntos >= 1) {

            int posicioArroba = correo.indexOf('@');
            
            if (posicioArroba != 0 && posicioArroba != (correo.length() - 1)) {
                
                String usuario = correo.substring(0, correo.indexOf('@'));
                String dominio = correo.substring(correo.indexOf('@') + 1, correo.length());

                boolean plU = Character.isAlphabetic(usuario.charAt(0));
                boolean plD = Character.isAlphabetic(dominio.charAt(0));
                boolean ulD = Character.isAlphabetic(dominio.charAt(dominio.length() - 1));

                totalPuntos = 0;
                for (int i = 0; i < dominio.length(); i++) {
                    if (dominio.charAt(i) == '.') {
                        totalPuntos++;
                    }

                }

                if (plU && plD && ulD && totalPuntos == 1) {

                    System.out.println("\n\t******************************************");
                    System.out.println("\t********* Este correo es valido ********* ");
                    System.out.println("\t******************************************\n");

                } else {
                    System.out.println("\n\t ** Corrreo invalido **");
                }

            } else {
                System.out.println("\n\t ** Corrreo invalido **");
            }

        } else {
            System.out.println("\n\t ** Corrreo invalido **");
        }

    }

}
