/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiapoocolecciones;

import guiapoocolecciones.entities.BookGuiaPooCollections;
import guiapoocolecciones.entities.CountriesGuiaPooCollections;
import guiapoocolecciones.entities.FamousSingerGuiaPooCollections;
import guiapoocolecciones.entities.ListOfDogsGuiaPooCollections;
import guiapoocolecciones.entities.ListOfDogs1GuiaPooCollections;
import guiapoocolecciones.entities.ListOfNumbersGuiaPooCollections;
import guiapoocolecciones.entities.MovieGuiaPooCollections;
import guiapoocolecciones.entities.StoreGuiaPooCollections;
import guiapoocolecciones.entities.StoreGuiaPooCollectionsServicie;
import guiapoocolecciones.entities.StudentGuiaPooCollections;
import guiapoocolecciones.entities.ZipCodeGuiaPooCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class GuiaPooColecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        /*
    1.Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El programa pedirá una raza de perro en un bucle, el mismo se guardará
    en la lista y después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide salir, se mostrará todos los perros guardados
    en el ArrayList.
    
    
        ListOfDogsGuiaPooCollections listOfDogs = new ListOfDogsGuiaPooCollections();
        listOfDogsGuiaPooCollections.saveDogs();
    
        
    2.Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro
    en la lista. Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista ordenada. Si el perro no se encuentra en la lista,
    se le informará al usuario y se mostrará la lista ordenada.

    
        ListOfDogs1GuiaPooCollections listOfDogs1 = new ListOfDogs1GuiaPooCollections();
        listOfDogs1GuiaPooCollections.saveDogs();
        listOfDogs1GuiaPooCollections.deleteDog();



    3.Crear una clase llamada Alumno que mantenga información sobre las notas de distintos alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer con sus 3 notas.
    En el main deberemos tener un bucle que crea un objeto Alumno. Se pide toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y
    se le pregunta al usuario si quiere crear otro Alumno o no. Despues de ese bluce tendremos el siguiente método en la clase Alumno:
    Metodo notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro del método
    se usará la lista notas para calcular el promedio final de alumno. Siendo este promedio final, devuelto por el método y mostrado en el main. 

       
        ArrayList<StudentGuiaPooCollections> students = new ArrayList<>();
        String decide = "";
        String name = "";
        Integer note = null;
        StudentGuiaPooCollections student;
        do {
            ArrayList<Integer> notes = new ArrayList<>();
            do {
                System.out.println("Enter the student's name");
                name = read.next();
            } while (name.isEmpty() || name == null);
            do {
                System.out.println("Enter the student's grade 0 - 10");
                do {
                    note = read.nextInt();
                } while (note == null || note < 0 || note > 10);
                notes.add(note);
            } while (notes.size() < 3);
            student = new StudentGuiaPooCollections(name, notes);
            students.add(student);
            System.out.println("Do you want to add another student? Yes to add one more, no to not add more (any other letter is taken as no).");
            decide = read.next().toLowerCase();
        } while ((decide.equals("yes")));

        System.out.println("el promedio de notas es " + student.finalNote(students));



        4.Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto, tendremos una clase Pelicula con el titulo, director y duración de la película (en horas).
        Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo que se pide a continuación:
        En el main deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario todos sus datos y guardándolos en el objeto Pelicula. Después, esa Pelicula se guarda una lista
        de Peliculas y se le pregunta al usuario si quiere crear otra Pelicula o no. Después de ese bucle realizaremos las siguientes acciones:
        • Mostrar en pantalla todas las películas.
        • Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
        • Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en pantalla.
        • Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en pantalla.
        • Ordenar las películas por titulo, alfabéticamente y mostrarlo en pantalla.
        • Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
        Nota: recordar el uso del Comparator para ordenar colecciones con objetos
        
        ArrayList<MovieGuiaPooCollections> movies = new ArrayList<>();
        String title = "";
        String manager = "";
        Double duration = null;
        MovieGuiaPooCollections movie;
        String decide = "";
        
        do{
            System.out.println("Enter title");
            do {
                title = read.next();
            } while (title.isEmpty() || title == null);
            System.out.println("Enter manager");
            do {
                manager = read.next();
            } while (manager.isEmpty() || manager == null);
            System.out.println("Enter duration");
            do {
                duration = read.nextDouble();
            } while (duration == null || duration.isNaN() || duration > 5 || duration < 0);
            movie = new MovieGuiaPooCollections(title, manager, duration);
            movies.add(movie);
            System.out.println("Do you want to add another movie? Yes to add one more, no to not add more (any other letter is taken as no).");
            decide = read.next().toLowerCase();
        }while ((decide.equals("yes")));



        5.Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos usaremos un conjunto. El programa pedirá un país en un bucle,
        se guardará el país en el conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir, si decide salir, se mostrará todos los países
        guardados en el conjunto. Después deberemos mostrar el conjunto ordenado alfabéticamente para esto recordar como se ordena un conjunto. Y por ultimo, al usuario se le pedirá un país y
        se recorrerá el conjunto con un Iterator, se buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el usuario y se mostrará el conjunto.
        Si el país no se encuentra en el conjunto se le informará al usuario

        
        CountriesGuiaPooCollections countriesGuiaPooCollections = new CountriesGuiaPooCollections();
        HashSet<CountriesGuiaPooCollections> countries = new HashSet<>();
        countriesGuiaPooCollections.addCountrie(countries);
        countriesGuiaPooCollections.sortByName(countries);
        


        6.Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos productos que venderemos y el precio que tendrán. Además, se necesita que la aplicación cuente con las funciones básicas.
        Estas las realizaremos en el main. Como, introducir un elemento, modificar su precio, eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar Hashmap).
        El HashMap tendrá de llave el nombre del producto y de valor el precio. Realizar un menú para lograr todas las acciones previamente mencionadas.
        
        
        
        StoreGuiaPooCollectionsServicie storeGuiaPooCollectionsServicie = new StoreGuiaPooCollectionsServicie();
        Integer caso = null;
        do {            
            System.out.println("Enter the caso 1: Create producto 2: Modify precie 3: Delete product 4: Show the products");
            caso = read.nextInt();
        } while (caso == null || !(caso == 1 || caso == 2 || caso == 3 || caso == 4));
        storeGuiaPooCollectionsServicie.menu(caso);
    



        7.Diseñar un programa que lea una serie de valores numéricos enteros desde el teclado y los guarde en un ArrayList de tipo Integer. La lectura de números termina cuando se introduzca el valor -99. Este valor no se guarda en el ArrayList.
        A continuación, el programa mostrará por pantalla el número de valores que se han leído, su suma y su media (promedio).
        
        ListOfNumbersGuiaPooCollections listOfNumbersGuiaPooCollections = new ListOfNumbersGuiaPooCollections();
        listOfNumbersGuiaPooCollections.saveNumbers();
        listOfNumbersGuiaPooCollections.show();
    


        8.Crear una clase llamada CantanteFamoso. Esta clase guardará cantantes famosos y tendrá como atributos el nombre y discoConMasVentas. Se debe, además, en el main, crear una lista de tipo CantanteFamoso y agregar 5 objetos de tipo CantanteFamoso
        a la lista. Luego, se debe mostrar los nombres de cada cantante y su disco con más ventas por pantalla. Una vez agregado los 5, en otro bucle, crear un menú que le de la opción al usuario de agregar un cantante más, mostrar todos los cantantes,
        eliminar un cantante que el usuario elija o de salir del programa. Al final se deberá mostrar la lista con todos los cambios
         

        FamousSingerGuiaPooCollections famousSingerGuiaPooCollections = new FamousSingerGuiaPooCollections();
        ArrayList<FamousSingerGuiaPooCollections> singers = new ArrayList<>();
        famousSingerGuiaPooCollections.addFiveSinger(singers);
        singers.forEach(aux -> {
            System.out.println("The name is " + aux.getName() + ", the best- selling album " + aux.getBestSellingAlbum());
        });
        famousSingerGuiaPooCollections.menu(singers);
        singers.forEach(aux -> {
            System.out.println("The name is " + aux.getName() + ", the best- selling album " + aux.getBestSellingAlbum());
        });
        
        
        9.Implemente un programa para una Librería haciendo uso de un HashSet para evitar datos repetidos. Para ello, se debe crear una clase llamada Libro que guarde la información de cada uno de los libros de una Biblioteca. La clase Libro debe guardar
        el título del libro, autor, número de ejemplares y número de ejemplares prestados. También se creará en el main un HashSet de tipo Libro que guardará todos los libros creados. En el main tendremos un bucle que crea un objeto Libro pidiéndole 
        al usuario todos sus datos y los seteandolos en el Libro. Despues, ese Libro se guarda en el conjunto y se le pregunta al usuario si quiere crear otro Libro o no. La clase Librería contendrá además los siguientes métodos:
        • Constructor por defecto.
        • Constructor con parámetros.
        • Métodos Setters/getters
        • Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar y se lo busca en el conjunto. Si está en el conjunto, se llama con ese objeto Libro al método. El método se incrementa de a uno, como un carrito de compras, el
        atributo ejemplares prestados, del libro que ingresó el usuario. Esto sucederá cada vez que se realice un préstamo del libro. No se podrán prestar libros de los que no queden ejemplares disponibles para prestar. Devuelve true si se ha podido realizar
        la operación y false en caso contrario.
        • Método devolucion(): El usuario ingresa el titulo del libro que quiere devolver y se lo busca en el conjunto. Si está en el conjunto, se llama con ese objeto al método. El método decrementa de a uno, como un carrito de compras, el atributo ejemplares prestados,
        del libro seleccionado por el usuario. Esto sucederá cada vez que se produzca la devolución de un libro. No se podrán devolver libros donde que no tengan ejemplares prestados. Devuelve true si se ha podido realizar la operación y false en caso contrario.
        • Método toString para mostrar los datos de los libros


        
        BookGuiaPooCollections bookGuiaPooCollections;
        HashSet<BookGuiaPooCollections> books = new HashSet<>();
        String title = "";
        String author = "";
        Integer numberOfCopies = 0;
        String decide = "";
        do {
            do {
                System.out.println("Enter the title");
                title = read.nextLine();
            } while (title.isEmpty() || title == null);
            do {
                System.out.println("Enter the author");
                author = read.nextLine();
            } while (author.isEmpty() || author == null);
            do {
                System.out.println("Enter the number of copies");
                numberOfCopies = read.nextInt();
            } while (numberOfCopies == null || numberOfCopies < 0);
            bookGuiaPooCollections = new BookGuiaPooCollections(title, author, numberOfCopies);
            books.add(bookGuiaPooCollections);
            System.out.println("Enter yes to continue adding books, otherwise any other letter will be taken as no.");
            decide = read.next().toLowerCase();
        } while (decide.equals("yes"));
        System.out.println(bookGuiaPooCollections.loan(books));
        System.out.println(bookGuiaPooCollections.returnTo(books));
        bookGuiaPooCollections.toString(books);
    
        
        10.Almacena en un HashMap los códigos postales de 10 ciudades a elección de esta página: https://mapanet.eu/index.htm. Nota: Poner el código postal sin la letra, solo el numero.
        • Pedirle al usuario que ingrese 10 códigos postales y sus ciudades.
        • Muestra por pantalla los datos introducidos
        • Pide un código postal y muestra la ciudad asociada si existe sino avisa al usuario.
        • Muestra por pantalla los datos
        • Agregar una ciudad con su código postal correspondiente más al HashMap.
        • Elimina 3 ciudades existentes dentro del HashMap, que pida el usuario.
        • Muestra por pantalla los datos

         */

        HashMap<String, String> zipCode = new HashMap<>();
        ZipCodeGuiaPooCollections zipCodeGuiaPooCollections = new ZipCodeGuiaPooCollections();
        //• Ask the user to enter 10 zip codes and their cities.
        zipCodeGuiaPooCollections.addZipCountries(zipCode);

        //• Displays the entered data on the screen
        zipCode.forEach((aux, aux1) -> System.out.println("The zip code " + aux + " , the country " + aux1));
        
        //• It asks for a zip code and displays the associated city if it exists, otherwise it alerts the user.
        if(zipCodeGuiaPooCollections.showCountry(zipCode)){
            System.out.println("no country found with this code ");
        }
        
        //• Add a city with its corresponding zip code more to the HashMap.
        zipCodeGuiaPooCollections.addZipCounty(zipCode);
        
        //• Displays the entered data on the screen
        zipCode.forEach((aux, aux1) -> System.out.println("The zip code " + aux + " , the country " + aux1));
        
        //• Deletes 3 existing cities within the HashMap, requested by the user.
        zipCodeGuiaPooCollections.deleteCountries(zipCode);
        
        //• Displays the entered data on the screen
        zipCode.forEach((aux, aux1) -> System.out.println("The zip code " + aux + " , the country " + aux1));
        
    }

}
