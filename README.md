### TATETI ATR
Juego en desarrollo.

### GUARDIAS PROFESIONAL

El problema consiste en asignar, de la manera más equitativa posible,
60 guardias a un grupo de 10 agentes según su disponibilidad.

A tener en cuenta:
- Las guardias cubren 30 días del mes a partir de una fecha ingresada por el usuario. 
- Por fecha del mes existe una guardia turno DIA y una guardia turno NOCHE.
- Hay agentes que hacen guardias de 24 hs, empezando en el turno DIA y terminando en el turno NOCHE de la misma fecha.
- La distribución de guardias debe corresponderse con la disponibilidad de los agentes y atender las siguientes condiciones:
	- no se debe superar un máximo de 3 guardias de findeSemana por Agente por mes.
	- cada agente tiene un crédito que se corresponde con la cantidad de guardias que quiere hacer. Las guardias asignadas a ese agente no puede superar ese límite.
	- no se debe asignar la guardia si el agente está de licencia ese día.
	- las guardias deben asignarse al mismo agente con al menos dos días de separación entre una y otra.

Estado de resolución del problema:

- Definición de las entidades guardia y profesional, creación de un mes modelo y carga de profesionales según datos reales.
- Iniciación del bucle de distribución. Ordenamiento de los profesionales según el criterio "quien menos pueda y menos quiera primero" para evaluar primero a quienes menos posibilidades tienen.

Resultado con datos modelo: El bucle asigna 59 guardias quedando una que no cumple con las condiciones para tener un profesional asignado. El "algoritmo" todavía no evalúa diferentes distribuciones para elegir la más óptima. Está todavía lejos de ser equitativa la distribución, apenas se está logrando forzar todas las asignaciones pero no hacerlo de forma que tengan todos una distribución pareja y acorde a sus requisitos.
