import javax.swing.JOptionPane;
public class App {
    /*Vamos a crear un programa que tiene tres instancias de Gato, Ave y Perro
    y que cada una de estas instancias va a ejecutar sus métodos para mostrarse en un JOptionPane.
    Cada instancia va a tener sus propios atributos (nombre, género, edad, peso, color, etc) y
    sus propios métodos (respirar, comer, maullar, correr, dormir, etc).

    Luego vamos a crear una carrera entre las tres instancias, donde cada una va a correr una distancia
    determinada y vamos a mostrar en un JOptionPane quién ganó la carrera.

    Y en la terminal mostraremos la distancia que han avanzado cada una de las instancias en la carrera.
    */
    public static void main(String[] args) throws Exception {

        Gato gato = new Gato("Michi", "Macho", (short)3, 4.5f, "Gris");
        Ave ave = new Ave("Piolin", "Macho", (short)1, 0.5f, "Amarillo");
        Perro perro = new Perro("Firulais", "Macho", (short)3, 8.5f, "Marrón");

        gato.mostrarGato("pescado", 100, 8);
        ave.mostrarAve("semillas", 50, 4);
        perro.mostrarPerro("croquetas", 200, 5);


        /*carrera
        cada uno corre una distancia aleatoria entre 1 y 10 metros
        calculamos la distancia con la ecuación Math.random() * (max - min) + min, donde max es el maximo y min el mínimo 
        en este caso max es 10 y min es 1 y la formula queda así: Math.random() * (10 - 1) + 1
        no puede ocurrir que más de un animal pase de 100 por eso tenemos que revisar en cada calculo si alguno ya paso de 100
        y evitar que los otros sigan corriendo, es decir ya no calcular su distancia
         */

        float distanciaGato = 0;
        float distanciaAve = 0;
        float distanciaPerro = 0;
        float distanciaTotal = 100.0f; //metros
        int ganador = 0; //usamos constantes para identificar al ganador
        final int GATO = 1;
        final int AVE = 2;
        final int PERRO = 3;

        while(true){
            if(distanciaGato < distanciaTotal){
                distanciaGato += Math.random() * (10 - 1) + 1;
                if(distanciaGato > distanciaTotal){
                    ganador = GATO;
                    System.out.println("Distancia Gato: " + distanciaGato);
                    break;//si el gato llega a la meta, se termina la carrera y acaba el while
                }
            }
            if(distanciaAve < distanciaTotal){
                distanciaAve += Math.random() * (10 - 1) + 1;
                if(distanciaAve > distanciaTotal){
                    ganador = AVE;
                    System.out.println("Distancia Ave: " + distanciaAve);
                    break;//si el ave llega a la meta, se termina la carrera y acaba el while
                }
            }
            if(distanciaPerro < distanciaTotal){
                distanciaPerro += Math.random() * (10 - 1) + 1;
                if(distanciaPerro > distanciaTotal){
                    ganador = PERRO;
                    System.out.println("Distancia Perro: " + distanciaPerro);
                    break;//si el perro llega a la meta, se termina la carrera y acaba el while
                }
            }

            //mostrar en la terminal la distancia que han avanzado cada una de las instancias en la carrera
            System.out.println("Distancia Gato: " + distanciaGato);
            System.out.println("Distancia Ave: " + distanciaAve);
            System.out.println("Distancia Perro: " + distanciaPerro);
            System.out.println("-------------------------");
        }

        //mostrar en un JOptionPane show message Dialog quién ganó la carrera
        switch(ganador){
            case GATO:
                JOptionPane.showMessageDialog(null, "El ganador es el gato " + gato.getNombre());
                break;
            case AVE:
                JOptionPane.showMessageDialog(null, "El ganador es el ave " + ave.getNombre());
                break;
            case PERRO:
                JOptionPane.showMessageDialog(null, "El ganador es el perro " + perro.getNombre());
                break;
            default:
                JOptionPane.showMessageDialog(null, "No hay ganador");
                break;
        }   
    }
}


