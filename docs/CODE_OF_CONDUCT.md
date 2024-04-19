# ¡Bienvenido al código fuente de nuestro programa!

En este documento podrás visualizar el como esta construido el programa a total detalle.

# Clase Restaurant

```
package com.ripadbaisor.restaurants;

public class Restaurant implements Comparable<Restaurant> {

    private String name;
    private String localization;
    private String schedule;
    private float punctuation;

    public Restaurant(String name, String localization, String schedule, float punctuation) {
        this.name = name;
        this.localization = localization;
        this.schedule = schedule;
        this.punctuation = punctuation;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalization() {
        return this.localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getSchedule() {
        return this.schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public float getPunctuation() {
        return this.punctuation;
    }

    public void setPunctuation(float punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        return "******************\nNombre: " + this.name + "\nLocalizacion: " + this.localization +
        "\nHorarios: " + this.schedule + "\nPuntuación: " + this.punctuation + "\n******************";
    }

    public int compareTo(Restaurant e) {
        if (e.getPunctuation() < punctuation) {
            return -1;
        } else if (e.getPunctuation() < punctuation) {
            return 0;
        } else {
            return 1;
        }
    }

}

```

Esta clase es la base en la que se apoyará todo el proceso lógico de almacenamiento y gestionamiento de datos del programa.

## Atributos

- **name**
  > variable donde se guardara el nombre del restaurante.
  
- **location**
  > variable donde se guardara la localización del restaurante.
  
- **schedule**
  > variable donde se guardara el horario del restaurante.
  
- **punctuation**
  > variable donde se guardara la puntuación del restaurante

## Constructor(es)

Esta clase cuenta con un solo constructor para inicializar todos los atributos con los valores colocados en los parametros indicados.

## Metodos de acceso

Se han creado métodos de acceso para todos los atributos de la clase.

## Método toString

Este método se ha sobreescrito para poder dar un mensaje personalizado a finalidad de comodidad visual para el usuario.

Esta clase tambien posee una "interfaz" extraida del paquete de java **Compare** con la palabra reservada **implements** en la cual estará agarrando como 
tipo de objeto, el objeto **Restaurant** de esta misma clase en este caso. En la cual se sobreescribe tambien el método **compareTo(Object x)** 
provenientes del paquete **Compare**.

## Método compareTo

- El método **compareTo(Object x)** recibe como parámetro un objeto tipo **Restaurant**.
  
- Si la puntuación recogida es menor al valor que esta almacenada actualmente en el atributo **punctuation** devolverá un -1.
  
- Si la puntuación recogida es menor al valor que esta almacenada actualmente en el atributo **punctuation** devolverá un 0.
  > En este caso es por si los valores que se estan comparando, son iguales.

- Caso contrario de que no se cumpla ninguna de las condiciones, devolverá un 1.

# Clase LogicProcess

```
package com.ripadbaisor.logicalprocesses;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import com.ripadbaisor.datamanagement.InputRequester;
import com.ripadbaisor.restaurants.Restaurant;

public class LogicProcess {
    private boolean keepAsking;
    private ArrayList<Restaurant> restaurantList = new ArrayList<>();

    public boolean isKeepAsking() {
        return this.keepAsking;
    }

    public void setKeepAsking(boolean keepAsking) {
        this.keepAsking = keepAsking;
    }

    public void addRestaurant() {
        try {
            restaurantList.add(InputRequester.restaurantData());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero en el campo de la puntuación", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editRestaurant() {

        try {
            int index = InputRequester.getRestaurantIndex(restaurantList);
            restaurantList.get(index).toString();
            int element = InputRequester.restaurantElementsMenu();

            switch (element) {
                case 0:
                    return;
                case 1:
                    restaurantList.get(index).setName(InputRequester.restaurantModifyElement());
                    break;
                case 2:
                    restaurantList.get(index).setLocalization(InputRequester.restaurantModifyElement());
                    break;
                case 3:
                    restaurantList.get(index).setSchedule(InputRequester.restaurantModifyElement());
                    break;
                case 4:
                    restaurantList.get(index).setPunctuation(Float.parseFloat(InputRequester.restaurantModifyElement()));
                            while (restaurantList.get(index).getPunctuation() < 1 || restaurantList.get(index).getPunctuation() > 10) {
                                restaurantList.get(index).setPunctuation(Float.parseFloat(JOptionPane.showInputDialog(null, 
                                "Debe introducir un numero valido entre 1-10", "ERROR", JOptionPane.ERROR_MESSAGE)));
                            }
                    break;
                default:
                    break;
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Debes introducir un valor valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showRestaurants() {
        ArrayList<Restaurant> orderedList = restaurantList;
        Collections.sort(orderedList);
        String message = "";

        for (Restaurant restaurant : orderedList) {
            message += restaurant.toString();
        }

        JOptionPane.showMessageDialog(null, message, "Lista de restaurantes", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deleteRestaurant() {
        try {
            restaurantList.remove(InputRequester.restaurantsToDelete(restaurantList));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes colocar un numero valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Debes introducir un valor valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}

```

En esta clase es donde se realizaran todos los procesos lógicos del programa, donde se almacenará, editará y borrará la informacion de los datos.

## Atributos

- **keepAsking**
  > Es un atributo que guardará valores booleanos(verdadero, falso). Nos sirve como condición de salida del programa.

- **restaurantList**
  > Es un atributo tipo lista dinámica de tipo **Restaurant**, inicializado como una nueva lista. Nos servirá para almacenar todos los restaurantes.

## Métodos de acceso

Se ha creado los métodos de acceso para el atributo **keepAsking**.

## Método addRestaurant

Este método se encarga de almacenar los restaurantes en la lista dinámica mediante la llamada del método estático **restaurantData** de la clase
**InputRequester**. Utilizando el método **add**.

## Excepciones

- **NumberFormatException**

Esta excepción saltará en caso de que al introducir la puntuación del restaurante no sea un número, provocando que salte una ventana
emergente indicando el error.

## Método editRestaurant

Este método se encarga de editar un restaurante.

## Variables locales

- index
  > Esta variable se encargará de guardar el indice del restaurante que se desee editar por la llamada al método **getRestaurantByIndex** de
    la clase **InputRequester**

- element
  > Esta variable se encargará de guardar la opción indicada mediante un número por un menú de los atributos a editar del restaurante
    seleccionado por el llamado del método **restaurantElementsMenu** de la clase **InputRequester**.

Una vez escogido el restaurante, se mostrará un menú con todos los atributos disponibles con un índice a editar sobre el restaurante, para que
junto con un switch, dependiendo de la opción, se solicitará la nueva información a editar sobre el atributo del restaurante mediante el
método estatico **restaurantModifyElement** de la clase **InputRequester**. Utilizando los métodos de acceso para la edición de los datos.

- Si en caso quiere editar la puntuación y esta sea mayor o menor a los limites indicados, se le solicitará que introduzca una puntuacion
  entre esos limites mediante una ventana. Este proceso se repetirá hasta que el usuario introduzca un valor válido.

## Excepciones

- **IndexOutOfBoundsException**

Esta excepción saltará en caso de que el usuario introduzca un número fuera de los límites de los índices. provocando que salte una 
ventana emergente indicando el error.

- **NumberFormatException**

Esta excepción saltará en caso de que al introducir la puntuación del restaurante no sea un número, provocando que salte una ventana
emergente indicando el error.

## Método showRestaurants

Este método se encargará de mostrar todos los restaurantes almacenados de forma descendente según la puntuación.

## Variables locales

- orderedList
  > Esta variable es una lista dinámica de tipo **Restaurant** que tendrá como valor, la lista original.
> [!NOTE]
> Se debe guardar la lista original en esta otra lista, para evitar alterar la lista original tras el ordenamiento.

- message
  > Esta variable servirá para almacenar todos los restaurantes junto con toda su información.

##

Este método contiene un método estático **sort** de la clase **Collections**, que acepta como parámetro una lista dinámica (en este caso
la que se ha creado anteriormente), como la "interfaz" creada anteriormente, ordenará los restaurantes de la lista dinámica. Su orden se basará
en la puntuación de cada restaurante almacenado.

Además tiene un bucle **forEach** que se encargará de recorrer todos los elementos existentes de la lista dinámica ordenada, a los cuales se les
aplicará el método sobreescrito previamente **toString** en la variable mensaje.

Finalmente se mostrará todos los restaurantes almacenados ordenados de forma descendiente por la puntuación en una ventana.

## Método deleteRestaurant

Este método se encargará de eliminar el restaurante indicado mediante un menú de todos los nombres de los restaurantes registrados con un índice.

Para la selección del restaurante a eliminar se llama al método estático **restaurantsToDelete** de la clase **InputRequester**, el cual
su valor será utilizado como argumento para el método **remove** aplicado a la lista dinámica donde se almacenan los restaurantes.

## Excepciones

- **NumberFormatException**

Esta excepción saltará en caso de que al introducir el indice del restaurante, este no sea un número, provocando que salte una ventana
emergente indicando el error.

- **IndexOutOfBoundsException**

Esta excepción saltará en caso de que el usuario introduzca un número fuera de los límites de los índices. provocando que salte una 
ventana emergente indicando el error.

# Clase InputRequester

```
package com.ripadbaisor.datamanagement;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.ripadbaisor.restaurants.Restaurant;

public class InputRequester {

    public static Restaurant restaurantData() throws NumberFormatException {
        String name = JOptionPane.showInputDialog("Nombre del restaurante");
        name = checkIfStringIsNotNull(name);
        String location = JOptionPane.showInputDialog("Localizacion");
        location = checkIfStringIsNotNull(location);
        String schedule = JOptionPane.showInputDialog("Horario semanal");
        schedule = checkIfStringIsNotNull(schedule);
        float punctuation = Float.parseFloat(JOptionPane.showInputDialog("Puntuacion 1/10"));

        while (punctuation < 1 || punctuation > 10) {
            punctuation = Float.parseFloat(JOptionPane.showInputDialog(null,
                    "Debe introducir un numero valido entre 1-10", "ERROR", JOptionPane.ERROR_MESSAGE));
        }

        Restaurant restaurant = new Restaurant(name, location, schedule, punctuation);
        return restaurant;
    }

    public static int getRestaurantIndex(ArrayList<Restaurant> restaurants) throws NumberFormatException {
        String message = "";
        for (int i = 0; i < restaurants.size(); i++) {
            message += (i + 1) + ".- " + restaurants.get(i).getName() + "\n";
        }

        return (Integer.parseInt(JOptionPane.showInputDialog(null,
                message, "SELECTOR", JOptionPane.QUESTION_MESSAGE)) - 1);
    }

    public static int restaurantElementsMenu() throws NumberFormatException {
        return Integer.parseInt(JOptionPane.showInputDialog(null, """
                1- Nombre
                2- Localizacion
                3- Horarios
                4- Puntuacion
                """, "Menu de edición", JOptionPane.QUESTION_MESSAGE));
    }

    public static String restaurantModifyElement() {
        String newElement = JOptionPane.showInputDialog(null, "Introduzca el nuevo dato", "Introduccion",
                JOptionPane.QUESTION_MESSAGE);
        newElement = checkIfStringIsNotNull(newElement);
        return newElement;
    }

    public static int restaurantsToDelete(ArrayList<Restaurant> restaurants)throws NumberFormatException, IndexOutOfBoundsException {
        String message = "";
        for (int i = 0; i < restaurants.size(); i++) {
            message += (i + 1) + ".- " + restaurants.get(i).getName() + "\n";
        }

        return (Integer.parseInt(JOptionPane.showInputDialog(null, message, "Lista de restaurantes a eliminar",
                JOptionPane.INFORMATION_MESSAGE)) - 1);
    }

    public static String checkIfStringIsNotNull(String message) {

        if (message == null || message.length() == 0) {
            do {
                message = JOptionPane.showInputDialog(null, """
                        El campo no puede estar vacio.
                        Introduzca un nuevo dato.
                            """, "ERROR", JOptionPane.ERROR_MESSAGE);
            } while (message == null || message.length() == 0); // Asegúrate de que la cadena no sea null o vacía
        }
        return message;
    }
}

```

Esta clase es la que se encarga para la solicitud y recolección de datos mediante ventanas emergentes.

## Método checkIfStringIsNotNull

Este método asi como lo dice su nombre, se le pasará como parámetro una cadena de texto.

- Si la cadena esta vacia o su longitud es igual a 0, entrará en un bucle mostrando una ventana de error indicandole al usuario que no
  deberá dejar esa información vacía, este proceso durará hasta que el usuario coloque un dato.

## Método restaurantData

Este método se encargará de solicitar todos los datos del restaurante al usuario mediante multiples ventanas emergentes.

## Variables locales

- name
  > Esta variable es donde se guardara el nombre del restaurante.
  
- location
  > Esta variable es donde se guardara la localización del restaurante.
  
- schedule
  > Esta variable es donde se guardara el horario del restaurante.
  
- punctuation
  > Esta variable es donde se guardara la puntuación del restaurante.

> [!NOTE]
> Las variables donde se almacena el nombre, localización y el horario del restaurante, su valor se actualizará con la comprobación que devuelve
> el método **checkIfStringIsNotNull**, para asi evitar que se introduzca información vacía.

> [!NOTE]
> La variable donde se almacena la información tiene la misma condicion que cuando se esta editando la misma en **editRestaurant** de la clase
> **LogicProcess** para evitar que se introduzca un valor que sea mayor o menor a los limites establecidos.

##

Si la información ha sido recolectada correctamente, se creará un nuevo restaurante llamado al constructor de la clase **Restaurant** colocando
como argumento todas las variables locales con sus respectivos valores.

## Método getRestaurantIndex

Este método tiene como parámetro una lista dinámica de restaurantes, se encargará de mostrar un menú con los nombres de todos los restaurantes 
almacenados en dicha lista junto a su índice.

## Variables locales

- message
  > Esta variable servirá para almacenar todos los nombres de los restaurantes con un índice para indicar su posicion.

##

Con un bucle **for** es como se encargará de almacenar el indice y el nombre de cada restaurante guardado en la variable local **message**.

Para que despues de que la almacene, muestre una lista mediante en una ventana emergente con un mensaje donde el usuario podrá seleccionar 
el restaurante que quiera seleccionar mediante un numero.

## Método restaurantElementsMenu

Este método se encarga solamente de mostrar un ménu de todos los datos de un restaurante.

## Método restaurantModifyElement

Este método se encarga de introducir un nuevo dato de un atributo de un restaurante mediante una ventana.

## Variables locales

- newElement
  > Esta variable es la encargada de guardar la informacion dada por una ventana de solicitud de datos.

> [!NOTE]
> Esta variable su valor se actualizara con la comprobación que devuelve el método **checkIfStringIsNotNull**, para asi evitar que se
> introduzca información vacía.

## 

## Método restaurantsToDelete

Este método tiene como parámetro una lista dinámica de restaurantes, se encargará de mostrar un menú con los nombres de todos los restaurantes 
almacenados en dicha lista junto a su índice.

## Variables locales

- message
  > Esta variable servirá para almacenar todos los nombres de los restaurantes con un índice para indicar su posicion.

##

Con un bucle **for** es como se encargará de almacenar el indice y el nombre de cada restaurante guardado en la variable local **message**.

Para que despues de que la almacene, muestre una lista mediante en una ventana emergente con un mensaje donde el usuario podrá seleccionar 
el restaurante que quiera eliminar mediante un numero.

# Clase Menu

```
package com.ripadbaisor.menus;

import javax.swing.JOptionPane;

import com.ripadbaisor.logicalprocesses.LogicProcess;

public class Menu {

    private boolean keepAsking;
    private LogicProcess programLogic = new LogicProcess();
    private String menuMessage = """
            1. Añadir Restaurante.
            2. Editar Restaurante.
            3. Mostrar Restaurantes.
            4. Eliminar Restaurantes.
            Q. Salir del programa.
            """;

    public boolean isKeepAsking() {
        return this.keepAsking;
    }

    public void setKeepAsking(boolean keepAsking) {
        this.keepAsking = keepAsking;
    }

    public void showMainMenu() {
        String message = JOptionPane.showInputDialog(null, menuMessage, "Menu Principal",
                JOptionPane.INFORMATION_MESSAGE);

        if (message != null) {

            switch (message.toUpperCase()) {
                case "1":
                    programLogic.addRestaurant();
                    break;
                case "2":
                    programLogic.editRestaurant();
                    break;
                case "3":
                    programLogic.showRestaurants();
                    break;
                case "4":
                    programLogic.deleteRestaurant();
                    break;
                case "Q":
                    this.setKeepAsking(false);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }

        if (message == null) {
            JOptionPane.showMessageDialog(null, "¡Adios, gracias por usar nuestro programa!", "Despedida",
                    JOptionPane.INFORMATION_MESSAGE);
            this.setKeepAsking(false);
        }

    }
}

```

Esta clase se encarga de mostrar al usuario un menú con las diferentes opciones del programa principal.

## Atributos

- **keepAsking**
  > Es un atributo que guardará valores booleanos(verdadero, falso). Nos sirve como condición de salida del programa.

- **programLogic**
  > Es un objeto de la clase **LogicProcess**, que es usado para llamar los métodos de dicha clase.

- **menuMessage**
  > Es un atributo que guarda las opciones del programa en una manera **family friendly**

## Métodos de acceso

Se ha creado los métodos de acceso para el atributo **keepAsking**.

## Método showMainMenu

Este método mostrará mediante una ventana el menú principal del programa.

## Variables locales

- message
  > Esta variable se encargará de mostrar dicho menú mediante una ventana.

##

- Si el usuario no ha pulsado en el boton cancelar, se entrará en un **switch** en el cual según la opción del usuario entrará en un caso u otro.
- Si el usuario ha pulsado en el boton cancelar, se mostrará una ventana con un mensaje de despedida, cerrando el programa.

# Clase Main

```
import com.ripadbaisor.menus.Menu;

public class Main {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        menu.setKeepAsking(true);
        while (menu.isKeepAsking()) {
            menu.showMainMenu();
        }
    }
}

```

Esta es la clase donde se ejecutará nuestro programa.

En esta clase, se ha creado un objeto menu, en el cual utilizando un **setter** colocaremos un valor booleano en su atributo como verdadero.

Para así al utilizar un bucle, que mientras el valor que se obtiene de dicho atributo por un **getter** sea verdadero, nos muestre el menú
principal del programa con el método **showMainMenu**.