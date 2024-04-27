/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva2_examen_prac;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rubra
 */
public class Eva2_Examen_prac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         enum Jugada { PIEDRA, PAPEL, TIJERAS }
    enum Resultado { GANA, PIERDE, EMPATA }
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int partidas = 0;
        int ganadas = 0;
        int perdidas = 0;
        int empates = 0;
        
        System.out.println("Bienvenido a Piedra, Papel o Tijeras!");
        
        while (true) {
            System.out.print("Elige tu jugada (1: Piedra, 2: Papel, 3: Tijeras, 0: Salir): ");
            int eleccion = scanner.nextInt();
            
            if (eleccion == 0) {
                break;
            }
            
            Jugada jugadaUsuario = obtenerJugada(eleccion);
            Jugada jugadaComputadora = obtenerJugada(random.nextInt(3) + 1);
            
            System.out.println("Tu jugada: " + jugadaUsuario);
            System.out.println("Jugada de la computadora: " + jugadaComputadora);
            
            Resultado resultado = determinarResultado(jugadaUsuario, jugadaComputadora);
            
            if (resultado == Resultado.GANA) {
                System.out.println("¡Ganaste!");
                ganadas++;
            } else if (resultado == Resultado.PIERDE) {
                System.out.println("¡Perdiste!");
                perdidas++;
            } else {
                System.out.println("¡Empate!");
                empates++;
            }
            
            partidas++;
        }
        
        System.out.println("Fin del juego.");
        System.out.println("Estadísticas:");
        System.out.println("Partidas jugadas: " + partidas);
        System.out.println("Ganadas: " + ganadas);
        System.out.println("Perdidas: " + perdidas);
        System.out.println("Empates: " + empates);
        
        scanner.close();
    }
     enum Jugada { PIEDRA, PAPEL, TIJERAS }
    enum Resultado { GANA, PIERDE, EMPATA }
    public static Jugada obtenerJugada(int eleccion) {
        switch (eleccion) {
            case 1: return Jugada.PIEDRA;
            case 2: return Jugada.PAPEL;
            case 3: return Jugada.TIJERAS;
            default: throw new IllegalArgumentException("Elección no válida.");
        }
    }
    
    public static Resultado determinarResultado(Jugada jugadaUsuario, Jugada jugadaComputadora) {
        if (jugadaUsuario == jugadaComputadora) {
            return Resultado.EMPATA;
        }
        
        if ((jugadaUsuario == Jugada.PIEDRA && jugadaComputadora == Jugada.TIJERAS) ||
            (jugadaUsuario == Jugada.PAPEL && jugadaComputadora == Jugada.PIEDRA) ||
            (jugadaUsuario == Jugada.TIJERAS && jugadaComputadora == Jugada.PAPEL)) {
            return Resultado.GANA;
        }
        
        return Resultado.PIERDE;
    }
    
}
