/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoorelaciones;

import guiapoorelaciones.entities.CardExercise3;
import guiapoorelaciones.entities.CinemaExercise5;
import guiapoorelaciones.entities.DogExercise4;
import guiapoorelaciones.entities.GameExercise2;
import guiapoorelaciones.entities.InstallmentManagementExercise6;
import guiapoorelaciones.entities.IntegratedCustomerManagementExercise6;
import guiapoorelaciones.entities.PackOfCards;
import guiapoorelaciones.entities.PersonExercise1;
import guiapoorelaciones.entities.PersonExercise4;
import guiapoorelaciones.entities.PolicyManagementExercise6;
import guiapoorelaciones.entities.VehicleManagementExercise6;
import guiapoorelaciones.service.Exercise1;
import guiapoorelaciones.service.Exercise4;
import guiapoorelaciones.service.Exercise5;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class GuiaPooRelaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        /*
    1. Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con atributos: nombre, apellido, edad, documento y Perro.
    Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde la clase Persona, la información del Perro y de la Persona.
        Exercise1 exercise1 = new Exercise1();
        PersonExercise1 person = exercise1.createPerson();
        PersonExercise1 person1 = exercise1.createPerson();

        System.out.println("person one");
        System.out.println(" The name: " + person.getName()
                + ". The last name: " + person.getLastName()
                + ". The age: " + person.getAge()
                + ". The dni: " + person.getDni()
                + ". the dog's name: " + person.getDog().getName()
                + ". the dog's race: " + person.getDog().getRace()
                + ". the dog's age: " + person.getDog().getAge()
                + ". the dog's size: " + person.getDog().getSize());
    
        System.out.println("person two");
        System.out.println(" The name: " + person1.getName()
                + ". The last name: " + person1.getLastName()
                + ". The age: " + person1.getAge()
                + ". The dni: " + person1.getDni()
                + ". the dog's name: " + person1.getDog().getName()
                + ". the dog's race: " + person1.getDog().getRace()
                + ". the dog's age: " + person1.getDog().getAge()
                + ". the dog's size: " + person1.getDog().getSize());
    

     2. Realizar el juego de la ruleta rusa de agua en Java. Como muchos saben, el juego se trata de un número de jugadores, que, con un revolver de agua, el cual posee una sola carga de agua, se dispara y se moja. Las clases a hacer del juego son las siguientes:
    Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del tambor donde se encuentra el agua). Estas dos posiciones,
    se generarán aleatoriamente.
    Métodos:
    • llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores deben ser aleatorios.
    • mojar(): devuelve true si la posición del agua coincide con la posición actual
    • siguienteChorro(): cambia a la siguiente posición del tambor
    • toString(): muestra información del revolver (posición actual y donde está el agua) Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (
    indica si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
    Métodos:
    • disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y 
    el método devuelve true, sino false.
    Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y Revolver
    Métodos:
    • llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores y el revolver para guardarlos en los atributos del juego.
    • ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se
    tiene que mojar. Al final del juego, se debe mostrar que jugador se mojó. Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego
   
        
        GameExercise2 game = new GameExercise2();
        game.createGame();
        game.round(game);
        
   

        3. Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número entre 1 y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas). Esta clase debe contener un método toString() que retorne el número de carta y 
        el palo. La baraja estará compuesta por un conjunto de cartas, 40 exactamente. Las operaciones que podrá realizar la baraja son:
        • barajar(): cambia de posición todas las cartas aleatoriamente.
        • siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o se haya llegado al final, se indica al usuario que no hay más cartas.
        • cartasDisponibles(): indica el número de cartas que aún se puede repartir.
        • darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero debemos indicárselo al usuario.
        • cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna indicárselo al usuario
        • mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y luego se llama al método, este no mostrara esa primera carta
        
        PackOfCards packOfCards = new PackOfCards();
        System.out.println("shuffle cards -------");
        packOfCards.shuffle();
        System.out.println("order letters --------");
        for (int i = 0; i < 10; i++) {
            CardExercise3 card = packOfCards.nextCard();
            System.out.println(card.getStick() + " - " + card.getNumber());
        }
        System.out.println("number of cards available --------");
        System.out.println(packOfCards.available());
        System.out.println("give letters --------");
        ArrayList<CardExercise3> cards = packOfCards.toGive(10);
        cards.forEach(aux -> {
            System.out.println(aux.getStick() + " - " + aux.getNumber());
        });
        System.out.println("cards from the pile ------");
        packOfCards.heapCards();
        System.out.println("show the deck ---------");
        packOfCards.showDeck();


        4. Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden 
        adoptar al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la persona. Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las personas con sus respectivos perros
    
        
        Exercise4 exercise4 = new Exercise4();
        ArrayList<DogExercise4> dogs = new ArrayList<>();
        ArrayList<PersonExercise4> people = new ArrayList<>();
        System.out.println("Enter the dogs to adopt");
        String decide = "";
        do {
            dogs.add(exercise4.createDog());
            System.out.println("Enter yes if you want to add another dog. Other letter or word will be taken as no");
            decide = read.nextLine().toLowerCase();
        } while (decide.equals("yes"));
        decide = "";
        do {
            people.add(exercise4.createPerson());
            System.out.println("Enter yes if you want to add another person. Other letter or word will be taken as no");
            decide = read.nextLine().toLowerCase();
        } while (decide.equals("yes"));
        for (int i = 0; i < people.size(); i++) {
            System.out.println("The person facundo veron is going to choose a dog: " + people.get(i).getName() + " " + people.get(i).getLastName());
            DogExercise4 dog = exercise4.adopt(dogs);
            people.get(i).setDog(dog);
            dogs.remove(dog);
        }
    
        5.Nos piden hacer un programa sobre un Cine, que tiene una sala con un conjunto de asientos (8 filas por 6 columnas). De Cine nos interesa conocer la película que se está reproduciendo, la sala con los espectadores y el precio de la entrada. Luego, de las
        películas nos interesa saber el título, duración, edad mínima y director. Por último, del espectador, nos interesa saber su nombre, edad y el dinero que tiene disponible. Para representar la sala con los espectadores vamos a utilizar una matriz. Los asientos
        son etiquetados por una letra y un número la fila A1 empieza al final del mapa como se muestra en la tabla. También deberemos saber si el asiento está ocupado por un espectador o no, si esta ocupado se muestra una X, sino un espacio vacío
        
        8 A X | 8 B X | 8 C X | 8 D | 8 E X | 8 F X
        7 A X | 7 B X | 7 C X | 7 D X | 7 E | 7 F X
        6 A | 6 B X | 6 C | 6 D X | 6 E X | 6 F
        5 A X | 5 B | 5 C X | 5 D X | 5 E X | 5 F X
        4 A X | 4 B X | 4 C X | 4 D X | 4 E X | 4 F X
        3 A | 3 B X | 3 C X | 3 D | 3 E X | 3 F X
        2 A X | 2 B | 2 C X | 2 D X | 2 E X | 2 F
        1 A X | 1 B X | 1 C X | 1 D X | 1 E X | 1 F X
        
        Se debe realizar una pequeña simulación, en la que se generen muchos espectadores y se los ubique en los asientos aleatoriamente (no se puede ubicar un espectador donde ya este ocupado el asiento). Los espectadores serán ubicados de uno en uno y para ubicarlos
        tener en cuenta que podrá sentar a un espectador si tiene el dinero suficiente para pagar la entrada, si hay espacio libre en la sala y si tiene la edad requerida para ver la película. En caso de que el asiento este ocupado se le debe buscar uno libre. Al final 
        del programa deberemos mostrar la tabla, podemos mostrarla con la letra y numero de cada asiento o solo las X y espacios vacíos.
        
        
        
        Exercise5 exercise5 = new Exercise5();
        CinemaExercise5 cinemaExercise5 = new CinemaExercise5();
        System.out.println("create film");
        cinemaExercise5.setFilm(exercise5.createFilm());
        System.out.println("create viewer´s");
        cinemaExercise5.setViewers(exercise5.listViewers());
        cinemaExercise5.setPrice(10);
        exercise5.viewerLocation(cinemaExercise5.getViewers(), cinemaExercise5.getPrice());
    

        
        
        6.Ha llegado el momento de poner de prueba tus conocimientos. Para te vamos a contar que te ha contratado “La Tercera Seguros”, una empresa aseguradora que brinda a sus clientes coberturas integrales para vehículos. Luego de un pequeño relevamiento, te vamos a pasar en limpio
        los requerimientos del sistema que quiere realizar la empresa.
        a. Gestión Integral de clientes. En este módulo vamos a registrar la información personal de cada cliente que posea pólizas en nuestra empresa. Nombre y apellido, documento, mail, domicilio, teléfono.
        b. Gestión de vehículos. Se registra la información de cada vehículo asegurado. Marca, modelo, año, número de motor, chasis, color, tipo (camioneta, sedán, etc.).
        c. Gestión de Pólizas: Se registrará una póliza, donde se guardará los datos tanto de un vehículo, como los datos de un solo cliente. Los datos incluidos en ella son:
        número de póliza, fecha de inicio y fin de la póliza, cantidad de cuotas, forma de pago, monto total asegurado, incluye granizo, monto máximo granizo, tipo de cobertura (total, contra terceros, etc.). Nota: prestar atención al principio de este enunciado y pensar en las relaciones
        entre clases. Recuerden que pueden ser de uno a uno, de uno a muchos, de muchos a uno o de muchos a muchos.
        d. Gestión de cuotas: Se registrarán y podrán consultar las cuotas generadas en cada póliza. Esas cuotas van a contener la siguiente información: número de cuota, monto total de la cuota, si está o no pagada, fecha de vencimiento, forma de pago (efectivo, transferencia, etc.).        
        
        
        InstallmentManagementExercise6 installmentManagement = new InstallmentManagementExercise6();
        IntegratedCustomerManagementExercise6 integratedCustomerManagement = new IntegratedCustomerManagementExercise6();
        PolicyManagementExercise6 policyManagement = new PolicyManagementExercise6();
        VehicleManagementExercise6 vehicleManagement = new VehicleManagementExercise6();
        
        */
    }

}
