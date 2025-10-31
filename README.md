# Practica 3 — Funciones Primitivas Recursivas (CC)

## Descripción breve

Este repositorio contiene la implementación en Java de una pequeña "máquina"
de funciones primitivo-recursivas (PR). El objetivo de la práctica es modelar
las funciones básicas (cero, sucesor, proyección), la composición y la
recursión primitiva, y proporcionar una forma sencilla de construir y evaluar
funciones sobre enteros.

## Estructura del proyecto

- `src/` — Código fuente Java.
  - `domain/` — Núcleo de funciones PR y control de llamadas.
    - `axioms/` — Axiomas básicos: `ZeroFunction`, `SuccessorFunction`, `ProjectionFunction`.
    - `operands/` — Operandos/combinadores: `ComposedFunction`, `RecursiveFunction`.
  - `algorithms/` — Factorías de funciones (ejemplos de uso y construcciones).
  - `presenter/` — Clase `App` y `ArgumentParser` para ejecutar desde línea de comandos.
- `build/` — Salida de compilación (`.class`) (generada por `compile.sh`).
- `compile.sh` — Script para compilar el proyecto.
- `run.sh` — Script para ejecutar ejemplos / la aplicación.

## Requisitos

- Java 11+ (o una versión compatible con las APIs usadas en el código).
- Bash (scripts `compile.sh` y `run.sh`).

## Compilar

Usa el script provisto para compilar todos los ficheros Java y generar las
clases en el directorio `build/`:

```bash
./compile.sh
```

Salida esperada: tras una compilación correcta verás los ficheros `.class`
en `build/` y un mensaje "Compilación exitosa".

## Ejecutar la aplicación

La aplicación principal se encuentra en `src/presenter/App.java`. Hay un
script `run.sh` que facilita la ejecución; puede requerir parámetros según
cómo quieras evaluar funciones desde la línea de comandos.

Ejemplo (modo genérico):

```bash
./run.sh
# o ejecutar directamente con java (desde la raíz del repo):
java -cp build presenter.App
```

## Probar y ejemplos

El directorio `src/algorithms` contiene factorías de ejemplo (por ejemplo,
sumas, multiplicaciones, potencias) que muestran cómo construir funciones PR
usando los axiomas y operadores. Para probar manualmente desde código, puedes
hacer lo siguiente:

1. Compila con `./compile.sh`.
2. Escribe una pequeña clase Java (o modifica `presenter.App`) para instanciar
   las factorías de funciones y llamar a `eval(List<Integer>)` sobre ellas.

Ejemplo rápido (pseudo-pasos):

- Ejecuta `presenter.App` sin argumentos para ver qué opciones proporciona la
  aplicación (si está implementado el parsing de argumentos).
- Alternativamente, abre y edita `src/presenter/App.java` para añadir casos
  de prueba o invocaciones directas a las factorías en `src/algorithms`.

## Notas de diseño

- `PRFunction` es la clase base; su método público `eval(List<Integer>)`
  registra la llamada en `CallController` y delega en `_eval(List)` para la
  implementación concreta.
- `CallController` mantiene un contador estático de llamadas (útil para medir
  recursividad/profundidad/numero de invocaciones durante la evaluación).
- `ComposedFunction` aplica una lista de funciones hijas a los mismos
  argumentos y pasa sus resultados a la función raíz.
- `RecursiveFunction` modela la recursión primitiva usando un caso base y un
  caso recursivo.
