# ¡Bievenido al Manual de Usuario!

En este manual, podras saber como utilizar cada característica o detalles sobre nuestro programa.

## ¿Como iniciar el programa?

Primero antes de poder iniciar el programa, deberá seguir los siguientes pasos:

### Vincular el repositorio

- Deberas en tu IDE preferido vincular el repositorio con el proyecto.
- Abrir una nueva terminal
  > preferiblemente tipo BASH
- Introducir los siguientes comandos
  ```
  git remote add origin https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa.git
  git branch -M main
  git push -u origin main

  ```
Siguiendo estos pasos tendrás vinculado existosamente el proyecto en tu dispositivo y así ya podrás ejecutar el programa.

## Iniciando en el programa

Al inicar el programa se mostrará una ventana emergente como la siguiente.

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/9c24371c-d015-490a-80a3-3804cdd00a07)

Como puede ver, en esta ventana hay multiples opciones las cuales son seleccionadas escribiendo el indice correspondiente a la opción.
  > Ejemplo: Si introduce 1, entrará en la opción de **Añadir restaurante**.

A continuación explicaremos de manera detallada y en orden todas las opciones del programa.

## Opciones del programa

### Añadir restaurante

Al elegir esta opcion, permitira como lo dice su nombre añadir un restaurante a partir una serie de ventanas como las siguientes:

- **Nombre del restaurante**

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/29605b4c-d119-46aa-83d9-94080965a537)


En esta ventana se le solicitará añadir el nombre del restaurante.

- **Localizacion**

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/94e65ce5-3bad-4852-8801-d957a56c69e3)

En esta ventana se le solicitará añadir una localización.

- **Horario Semanal**

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/4c9e61f9-99b2-45a0-8729-6f4b85d68d0c)

En esta ventana se le solicitara añadir un horario en general

- **Puntuación**

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/79dfc0ab-d13d-4e8b-be5b-0a1b9d207d6b)

En esta ventana se le solicitara añadir una puntuacion en formato de numero entre el 1 y el 10.

### Posibles fallos al insertar los datos

Si usted coloca una información vacía en los siguientes campos: 
- Nombre del restaurante
- Localizacion
- Horario semanal

Se mostrará la siguiente ventana: 

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/611de950-12a2-40f4-b019-8c3776248b17)

Esta ventana de error, se repetirá hasta que introduzca una información que no este vacía.

Si usted coloca una información fuera de los límites, vacía o en otro formato que no sea numérico en el siguiente campo:
- Puntuacion

Se mostrará las siguientes ventanas:
- Si se coloca informacion vacia o en otro formato, nos saltará esta mensaje de error, lo llevará al menú principal y sin añadir el restaurante.

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/a4e4378b-5d03-4061-b2d1-f94ece306af7)

- Si se coloca una información que este fuera de los limites establecidos, nos saltará esta ventana hasta que coloquemos un valor dentro del limite.
  > Si se coloca una información vacía en esta ventana de error, lo llevará al menú principal sin añadir el restaurante.

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/7cb38144-9d1c-411b-8fe5-7692268fca3c)

### Editar Restaurante

Al elegir esta opcion permitirá editar un restaurante, con un menú que contendrá todos los nombres de los restaurantes añadidos previamente junto con
un indice a través de la siguiente ventana:

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/54543f65-43f1-4480-ad36-1ae43be8eb6f)

  > Ejemplo: Si usted quiere editar un dato del primer restaurante, pulse 1.

Una vez seleccionado el restaurante a editar, se desplegará otro menú con los datos relacionados al restaurante:

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/2b213bbd-4fab-4d05-ae22-ec02b3f73145)

En dicho menú, mediante un indice podra escoger que dato del restaurante quiere editar.

> [!NOTE]
> Ejemplo: Si quiere editar el nombre del restaurante, pulse 1.

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/d36310ec-2146-486f-8b17-4c9ebb399930)

> [!NOTE]
> La manera de solicitar los datos junto con la salida de los posibles errores son las mismas salidas que al añadir un restaurante.

### Mostrar Restaurantes

Al elegir esta opción mostrará los restaurantes almacenados de manera descendente según su puntuación.

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/a7fb0e18-35b9-43c7-930d-93c5f8583d4c)

### Eliminar Restaurantes

Al elegir esta opcion nos mostrará los restaurantes almacenados junto con su indice por el cual podrá
eliminar el restaurante deseado.

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/652aeebb-85e9-48d7-b4a2-bce2290eadc8)

### Posibles fallos al escoger un restaurante

Si usted coloca una información vacía o un índice inválido (que no exista), se mostrarán las siguientes ventanas: 

- Informacion vacía
![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/acc838a0-837f-4f91-a692-f860ca14bca8)

- Indice inválido
![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/e738bfe0-ace5-450c-9a69-9e8136bc1962)

### Salir del Programa

Al elegir esta opción el programa finalizará.

> [!NOTE]
> Puede salir tanto con "q", "Q" o clickeando en el boton "cancelar".

Si pulsa el boton cancelar, obtendrá una ventana de despedida especial.

![image](https://github.com/AlvaroNegrin/PROG-UD5-Chipi-Chipi-Chapa/assets/159430287/658db209-c1fd-42d6-948f-a0377fed1752)

Para volver al README principal haga click [aqui](/README.md)