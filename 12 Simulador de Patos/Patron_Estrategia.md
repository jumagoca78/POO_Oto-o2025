# 📌 Patrón de Diseño: Estrategia

## 🏛️ Introducción

El **Patrón Estrategia** es un **patrón de comportamiento** que permite definir un conjunto de algoritmos, encapsularlos y hacerlos intercambiables en tiempo de ejecución. Se basa en el principio de **composición sobre herencia**, lo que significa que en lugar de definir comportamientos en una superclase y que todas las subclases hereden el mismo comportamiento, cada comportamiento se modela como una estrategia independiente.

### 📌 ¿Por qué usar el Patrón Estrategia?

Este patrón es útil cuando:

✔️ Existen múltiples formas de realizar una tarea o algoritmo y se desea poder cambiarlas dinámicamente.  
✔️ Se quiere evitar estructuras de código rígidas con múltiples condicionales (`if-else` o `switch-case`).  
✔️ Se busca **alta flexibilidad** y fácil mantenimiento del código.  

### 📌 ¿Cómo funciona?

1. Se define una **interfaz común** para todas las estrategias (por ejemplo, `WeaponBehavior` para ataques en un juego).  
2. Se crean **múltiples implementaciones** de la interfaz (por ejemplo, `Sword`, `Bow`, `Axe`).  
3. Se declara un **atributo de tipo estrategia** en la clase principal y se le delega la ejecución del comportamiento.  
4. Se permite **cambiar la estrategia en tiempo de ejecución** sin modificar la estructura interna de la clase.

---

## 📖 Ejemplo Clásico: Patos (Head First Design Patterns)

En el libro *Head First Design Patterns*, el **problema de los patos** ilustra la necesidad del patrón Estrategia.  
Si definimos una clase `Duck` con métodos como `fly()` y `quack()`, **todos los patos tendrían estos comportamientos**, pero algunos patos no vuelan o no hacen ruido.

En lugar de definir los métodos en la superclase `Duck`, el patrón Estrategia nos permite crear **interfaces separadas** para "volar" y "hacer sonido", permitiendo que cada pato use una estrategia distinta.

### 🔹 Implementación en Java

```java
// Interfaz para el comportamiento de vuelo
interface FlyBehavior {
    void fly();
}

// Implementaciones de vuelo
class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("Vuelo con alas 🦆");
    }
}

class NoFly implements FlyBehavior {
    public void fly() {
        System.out.println("No puedo volar ❌");
    }
}

// Interfaz para el sonido
interface QuackBehavior {
    void quack();
}

// Implementaciones de sonido
class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("¡Cuac cuac! 🦆");
    }
}

class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silencio >> 🤐");
    }
}

// Clase base Duck
abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public abstract void display();
}

// Implementación concreta de un pato
class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("Soy un pato real 🦆");
    }
}

// Programa principal
public class StrategyPatternExample {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        // Cambiando comportamiento en tiempo de ejecución
        System.out.println("El pato ha perdido sus alas... 😢");
        mallard.setFlyBehavior(new NoFly());
        mallard.performFly();
    }
}
```

---

### 🔹 Implementación en C++

```cpp
#include <iostream>
using namespace std;

// Interfaz para el comportamiento de vuelo
class FlyBehavior {
public:
    virtual void fly() = 0;
};

// Implementaciones de vuelo
class FlyWithWings : public FlyBehavior {
public:
    void fly() override {
        cout << "Vuelo con alas 🦆" << endl;
    }
};

class NoFly : public FlyBehavior {
public:
    void fly() override {
        cout << "No puedo volar ❌" << endl;
    }
};

// Interfaz para el sonido
class QuackBehavior {
public:
    virtual void quack() = 0;
};

// Implementaciones de sonido
class Quack : public QuackBehavior {
public:
    void quack() override {
        cout << "¡Cuac cuac! 🦆" << endl;
    }
};

class MuteQuack : public QuackBehavior {
public:
    void quack() override {
        cout << "<< Silencio >> 🤐" << endl;
    }
};

// Clase base Duck
class Duck {
protected:
    FlyBehavior* flyBehavior;
    QuackBehavior* quackBehavior;
public:
    void setFlyBehavior(FlyBehavior* fb) {
        flyBehavior = fb;
    }

    void setQuackBehavior(QuackBehavior* qb) {
        quackBehavior = qb;
    }

    void performFly() {
        flyBehavior->fly();
    }

    void performQuack() {
        quackBehavior->quack();
    }

    virtual void display() = 0;
};

// Implementación concreta de un pato
class MallardDuck : public Duck {
public:
    MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    void display() override {
        cout << "Soy un pato real 🦆" << endl;
    }
};

// Programa principal
int main() {
    MallardDuck mallard;
    mallard.display();
    mallard.performFly();
    mallard.performQuack();

    // Cambiando comportamiento en tiempo de ejecución
    cout << "El pato ha perdido sus alas... 😢" << endl;
    mallard.setFlyBehavior(new NoFly());
    mallard.performFly();

    return 0;
}
```

---

## 📌 Conclusión

El **Patrón Estrategia** permite:

- **Separar el comportamiento** del objeto principal, evitando dependencias innecesarias.
- **Facilitar el mantenimiento** y escalabilidad del código.
- **Evitar condicionales anidados** y código difícil de modificar.

Este enfoque promueve la **programación flexible**, permitiendo **cambiar comportamientos en tiempo de ejecución sin modificar la estructura de la clase**. 🚀
