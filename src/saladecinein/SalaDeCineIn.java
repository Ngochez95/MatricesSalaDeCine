package saladecinein;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SalaDeCineIn {

    public static void main(String[] args) {
        //Creamos una matriz de tipo String sin difenir el tamaño
        String cine[][];
       
        //Declaración de todas las variables que se utilizarán a lo largo de programa
        boolean estado = true, operacion = false;
        double precio;
        int filas, columnas, fila, columna, opcion, encontrado, numero, contador = 0;
        String salida = "", cualDesea, cambio, cualAsiento;
        char letra;

        //Creación y dimensionamiento de vector de tipo char que contiene el abecedario
        char abec[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        //peticion al usuario para ingresar el número filas y columnas con las que contará la matriz
        //como también el precio que costará cada voleto de cine
        //como recomendación se debería validar que el ingreso de datos del usuario esté en el rango permitido
        filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas"));
        columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas"));
        precio = Double.parseDouble(JOptionPane.showInputDialog("Precio de la función?"));
        
        //Definimos el tamaño de la matriz de tipo String
        //NOTA: [fila][columna] es el orden adecuado  
        cine = new String[filas][columnas];
        
        //Creamos un elemento de JTextArea para mostrar la salida de manera más bonita y amigable al usuario
        JTextArea hoja = new JTextArea();
        
        
        //Cuando se crea una matriz de tipo String por defecto se llena de valores String vacios, es de decir cadenas de texto tipo: "";
        //es por eso que se utiliza este for para llenar la matriz y simular los asientos de la sala de cine 
        //Es aqui donde se implementa el vector de tipo char que creamos en la parte de arriba que contiene las letras del abecedario
        //Generamos dos for anidados uno de ellos para recorrer las filas y dentro de ese el segundo para recorrer las columnas
        for (fila = 0; fila < filas; fila++) {
            for (columna = 0; columna < columnas; columna++) {
                //llamamos a la matriz en la posición de filas y columnas y la igualamos a :
                //vector tipo char de abecedario y le conctenamos la posición de las columnas para generar algo como:
                //a0 a1 a2 a3 a4 
                //b0 b1 b2 b3 b4
                
                cine[fila][columna] = abec[fila] + "" + (columna);
            }

        }
        
        //luego de tener llena la matriz podemos generar una especie de menu con el bucle dowhile
        //El dowhile responde a una variable booleana que se llama estado

        do {
            //solicitamos al usuario el ingreso de un valor que contenga el menu
            opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué opción desea?\n1-Ver sala\n2-Reservar asiento\n3-Cambiar Asientos\n4-Ver caja\n-Otro número salir"));
            
            //Implementamos la estructura de control del switch
            switch (opcion) {
                case 1:
                    //El caso número 1 es visualizar la sala de cine 
                    //de igual forma hacemos dos bucles for para recorrer la matriz 
                    for (fila = 0; fila < filas; fila++) {
                        for (columna = 0; columna < columnas; columna++) {
                            //La variable salida de tipo String nos servirá para almacenar los datos que contiene la matriz
                            //Es por eso que se hace un acumulador de string
                            //Le concatenamos el valor de la matriz en la posicion [fila][columna] y hacemos una tabulación p
                            salida += cine[fila][columna] + "\t";
                        }
                        //salimos del primer for y aplicamos un salto de linea al mismo acumulador de tipo string 
                        //Nota: el salto de linea tiene que ser fuera del for que recorre las columnas
                        salida += "\n";
                    }
                    //luego al objeto JTexArea que se llama hoja le asignamos el valor que venimos acumulando en la variable salida
                    hoja.setText(salida);
                    //luego solo lo imprimimos
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 2:
                    //Reservar un asiento 
                    //volvemos a generar los dos bucles for para volver a mostrar la salida y asi el usuario 
                    //tener un mejor aspecto visual a la hora de reservar su asiento
                    
                    for (fila = 0; fila < filas; fila++) {
                        for (columna = 0; columna < columnas; columna++) {
                            salida += cine[fila][columna] + "\t";
                        }
                        salida += "\n";
                    }
                    hoja.setText(salida);
                    cualDesea = JOptionPane.showInputDialog(null, hoja, "¿Cuál asiento desea?");
                    //solicitamos al usuario cual asiento desea y recorremos la matriz con dos for
                    for (fila = 0; fila < filas; fila++) {
                        for (columna = 0; columna < columnas; columna++) {
                            //aplicamos el condicional if y verificamos si la matriz en la posicion [fila][columna] es igual lo que el 
                            //usuario ingreso
                            //de ser verdadero asigamos un valor a la matriz en la posicion [fila][columna]  y le asignamos un *
                            if (cine[fila][columna].equals(cualDesea)) {
                                cine[fila][columna] = "*";
                                //la variable boolean operación es utilizada para verificar si en verdad se encontró el asiento
                                //ya que inicialmente cuenta con un valor negativo y se cambia a positivo si se encuentra el asiento
                                operacion = true;

                            }
                        }
                    }
                    if (operacion == false) {
                        //si la variable operacion aún sigue false quiere decir que no se encontró el asiento
                        JOptionPane.showMessageDialog(null, "error al reservar asiento");
                    } else {
                        //sino el asiento se asignó co éxito
                        JOptionPane.showMessageDialog(null, "El asiento reservado con éxito");
                        //varible entera contador para llevar el número de asientos vendidos
                        contador++;
                    }
                    break;
                case 3:
                    //cambiarse de asiento
                    //volvemos a generar los dos bucles for para volver a mostrar la salida y asi el usuario 
                    //tener un mejor aspecto visual a la hora de reservar su asiento
                    for (fila = 0; fila < filas; fila++) {
                        for (columna = 0; columna < columnas; columna++) {
                            salida += cine[fila][columna] + "\t";
                        }
                        salida += "\n";
                    }
                    hoja.setText(salida);
                    cambio = JOptionPane.showInputDialog(null, hoja, "¿Hacia cual asiento desea moverse?");
                    for (fila = 0; fila < filas; fila++) {
                        for (columna = 0; columna < columnas; columna++) {
                            //verificamos con el condicional if si la posicion de la matriz en [fila][columna] es igual a la que el usuario ingresó
                            if (cine[fila][columna].equals(cambio)) {
                                cine[fila][columna] = "*";
                                //la variable boolean operación es utilizada para verificar si en verdad se encontró el asiento
                                //ya que inicialmente cuenta con un valor negativo y se cambia a positivo si se encuentra el asiento
                                operacion = true;
                            }
                        }
                    }
                    if (operacion == false) {
                        //si la variable operación aún sigue en false se produjo un error al querer cambiar de asiento
                        JOptionPane.showMessageDialog(null, "Error al cambiar asiento, intente de nuevo");
                    } else {
                        //sino se generó con exito y luego  se procede a preguntar en que asiento se encontraba anteriormente en un variable tipo String 
                        //para luego aplicar el charAT
                        cualAsiento = JOptionPane.showInputDialog("¿En qué asiento se encontraba anteriormente?");
                        //obtenemos solo la letra  de lo que el usaurio ingresó
                        letra = cualAsiento.charAt(0);
                        //Conveertimos el char en un numero entero
                        numero = Integer.parseInt("" + cualAsiento.charAt(1));
                           // recorremos en este caso con un for hasta que sea menor a las filas del vector
                        for (int posicion = 0; posicion < filas; posicion++) {
                            if (abec[posicion] == letra) {
                                //verificamos si la letra que el usuario ingresó se encuentra definida en el vector de abecedario
                                //si se encuentra almacenamos esa posición de esa letra en una variable de tipo int  que se llama encontrado
                                encontrado = posicion;
                                if (cine[encontrado][numero].equals("*")) {
                                    //verifiacmoas si la matriz en la posicion encotrado(que es el nuúmero a la que corresponde la letra que ingresó el usuario)
                                    //numero(valor obtenido por el charAT)
                                    //es igual a "*"
                                    //asignamos a la mtriz el valor de que se almacena en la variable cual asiento
                                    cine[encontrado][numero] = cualAsiento;
                                    JOptionPane.showMessageDialog(null, " Operación realizada con éxto");
                                }

                            }
                        }
                    }

                    break;
                case 4:
                    //solo se tabula la salida para y se multiplica el valor del contador por el precio que se almacenó al inicio del programa
                    //donde se especificó cuando valía la entrada
                    for (fila = 0; fila < filas; fila++) {
                        for (columna = 0; columna < columnas; columna++) {
                            salida += cine[fila][columna] + "\t";
                        }
                        salida += "\n";
                    }
                    salida += "vendidos\ttotal\n";
                    salida += "" + contador + "\t" + (contador * precio) + "";
                    hoja.setText(salida);
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 5:
                    estado = false;
                    break;
            }
            //
            //NOTA: RESETEAR LAS VARIABLES PARA NO GENERAR PROBLEMAS DE REPETICION DE CONTENIDO
            salida = "";
            hoja.setText(salida);
            operacion = false;
        } while (estado);

    }

}
