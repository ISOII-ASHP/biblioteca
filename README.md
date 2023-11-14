### Documentación ISOII ASHP

## Índice

- [Sprints](#sprints)

- [Workflows](#workflows)

- [Pom.xml](#pom)

- [Ramas y merges](#ramas-y-merges)

- [Commits](#commits)

- [Proyecto Peso](#proyecto-weight)

- [Product Backlog](#product-backlog)

- [Deployment.yml](#deployment)

## Sprints
  <p align="justify">
   Antes de definir el antes y después de cada sprint, vamos a indicar que nuestros sprints son de cada 2 semanas.
</p>

#### Sprint 1

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/9d9725b2-d22f-4b7e-a855-93125f63b834)

<p align="justify">
Tareas:
•	Crear un backlog de producto con tareas priorizadas.
•	Configurar el entorno de desarrollo y el repositorio en GitHub.
•	Integrar Maven para la gestión de dependencias y la automatización de la construcción del proyecto.
•	Desarrollar una estructura básica del proyecto con la implementación inicial de Maven (archivos pom.xml).
•	Realizar caso de uso dar de alta nuevos títulos.
Retrospectiva:
•	Revisar lo que funcionó bien y lo que podría mejorarse.
•	Planificar mejoras para el siguiente sprint.
Antes y después de cada Sprint:
•	Después: Como no fuimos capaz de completar Dar de alta nuevos títulos, lo metimos en el siguiente sprint.

</p>

#### Sprint 2

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/4a04fc19-3e5d-4031-bb37-b299e3a143e6)

<p align="justify">
Tareas:
•	Configurar dependencias de Spring JPA en el pom.xml.
•	Crear un entorno en que podamos planificarnos para cada sprint y los issues.
•	Realizar caso de uso dar de alta nuevos títulos.
•	Obtener de la UML un código base.
•	Crear página index.html y la implementación de la herramienta hibernar
Retrospectiva:
•	Analizar cómo la introducción de Spring JPA ha afectado el proceso de desarrollo.
•	Revisar la configuración y el código para identificar posibles mejoras o problemas.

Antes y después de cada Sprint:
•	Después: Como no fuimos capaz de completar Dar de alta nuevos títulos, lo metimos en el siguiente sprint. En este sprint, nos dimos cuenta que necesitamos un código base pero que sea funcional para poder empezar a realizar los casos de uso. Nos queríamos centrar en un código base que funcione correctamente y mejorarlo para realizar mas tarde las funcionalidades. Por esta razón, algunos issues no fuimos capaces de completarlos También realizamos un pequeño mockup para mostrarle al usuario. Y mostrar las funcionalidades que tendrá cada actor.
</p>

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/c5fa4f90-03a8-449c-bc0d-3bc54a9ccdfb)

 <p align="justify">
   La imagen muestra una serie de diagramas de flujo de casos de uso para la gestión de bibliotecas, organizados por roles de usuario: Administrador, Bibliotecario, Usuario y acciones comunes a todos. Cuando un usuario inicia sesión, en una misma página pueden reflejarse múltiples casos de uso, como ver, listar o mostrar información.

Se muestra una mockup de la vista del bibliotecario y usuario con detalles de penalizaciones, préstamos y reservas. Por ejemplo, para el usuario "Paco", se muestra que está penalizado hasta una fecha específica y se detallan los préstamos y reservas activos con sus fechas correspondientes y los títulos de los libros.
</p>

## Workflows
<p align="justify">
Los workflows, o flujos de trabajo, son secuencias de procesos o pasos necesarios para llevar a cabo una tarea o proyecto. Un workflow representa la automatización de procesos de negocio, donde las tareas, la información o los documentos se pasan de un participante a otro para realizar acciones según un conjunto de reglas procedimentales. Estos pueden ser manuales o automatizados y son fundamentales para organizar y optimizar las operaciones y tareas dentro de un proyecto.
</p>

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/f4712d69-a4f7-4693-ae2c-fb353c030543)

<p align="justify">
 Cuando se agrega un elemento al proyecto, en este caso los problemas y las solicitudes de extracción, el valor se ajusta por defecto para que aparezca en producto backlog.
</p>

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/a23b85b5-6574-4389-a538-9476bd4d4c0c)

<p align="justify">
Cuando se vuelve a abrir un problema o una solicitud de extracción el estado de cada elemento estará en revisión.
</p>

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/683c18e5-5a3c-4af7-a2c1-372d80425683)

<p align="justify">
Cuando un problema está cerrado su estado pasa a listo.
</p>

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/7052430a-6f44-403d-8e41-2e38d663d87a)

<p align="justify">
Cuando una solicitud de extracción tiene una revisión que solicita cambios su estado se modifica a en revisión.
</p>

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/a385ccf6-c26f-43d5-a0e2-4ce044cc5b3a)

<p align="justify">
Cuando se aprueba una solicitud de extracción se cambia su estado a listo.
</p>

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/a11bda44-a865-4f99-8add-903a48df79bf)

<p align="justify">
Cuando se fusiona una solicitud de extracción, quiere decir que se ha aceptado la solicitud y por lo tanto, su estado pasaría a listo.
</p>

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/a6fd6722-488f-4bdd-bd63-6e2e30da1b74)

<p align="justify">
Cuando el filtro coincide con un elemento nuevo o actualizado, en este caso los filtros relacionados con un problema o si está abierto, se agrega el artículo al proyecto.
</p>




## Pom
![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/47db923d-0964-45d7-b9f5-cac88308440a)

<p align="justify">
  El archivo pom.xml, indica las siguientes dependencias gestionadas:

</p>

`Spring Boot Starter Thymeleaf:` Para integrar el motor de plantillas Thymeleaf.

`Spring Boot Starter Web:` Proporciona todas las dependencias necesarias para construir aplicaciones web, incluyendo Spring MVC, Tomcat como el contenedor por defecto, etc.

`Spring Boot Starter Test:` Incluye herramientas de testing como JUnit, Hamcrest y Mockito.

`Spring Boot Starter Data JPA:` Facilita la implementación de repositorios JPA.

`Apache Derby:` Una base de datos en memoria que se utiliza para la persistencia de datos.

`Apache Derby Tools:` Herramientas para trabajar con la base de datos Derby.

<p align="justify">

Estas dependencias están configuradas para ser gestionadas por Maven, lo que significa que Maven se encargará de descargar y mantener actualizadas estas librerías de acuerdo con las versiones especificadas en tu archivo pom.xml.

</p>


## Ramas y merges

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/73a3a5f8-a3d5-4afb-9efd-9c192d99924d)

<p align="justify">
 La gestión de configuración de ramas en un proyecto que utiliza Git y sigue el modelo de branching por características junto con las ramas master y develop se organiza generalmente de la siguiente manera:

</p>

`Rama Master:` Sirve como la rama principal donde el código refleja el estado de producción. Las actualizaciones a master se hacen a través de merges cuidadosamente revisados desde develop o ramas de hotfix, en caso de error.

`Rama Develop:` Actúa como una rama de integración para las características que se están desarrollando. Esta es la rama donde todas las características (feature branches) se unen (merge) antes de ser llevadas a master.

`Feature Branches:` Por cada nueva característica o mejora significativa, se crea una nueva rama desde develop. Esto permite trabajar en la característica de manera aislada. Una vez que la característica está completa y ha pasado todas las pruebas, se hace merge de vuelta a develop.

`Merges:` Los merges de las ramas de características a develop se hacen con frecuencia para integrar y probar nuevas funcionalidades. Antes de un lanzamiento, develop se fusiona con master para reflejar la nueva versión.

<p align="justify">
 Este enfoque ayuda a mantener organizado el desarrollo, facilita la integración continua y la entrega continua (CI/CD), y asegura que la rama de producción siempre mantenga un estado estable.
</p>

## Commits

## Proyecto weight

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/ba032d07-7628-4cb6-8e97-d2f912585658)

<p align="justify">
 La asignación de un peso a los issues es una forma de priorización basada en importancia y urgencia. Un issue con un peso de 5 indica máxima prioridad y debe ser abordado antes que otros. Estos suelen ser críticos para el negocio o la funcionalidad. Un peso de 1 indica una tarea de menor importancia, que aunque debe completarse, puede esperar sin afectar significativamente el progreso general del proyecto. Esta técnica de priorización ayuda al equipo a enfocarse en los problemas más impactantes y a gestionar eficientemente el flujo de trabajo del proyecto.
</p>

## Product Backlog

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/ef5383ed-906b-4780-8714-e3f8f82a44bc)

<p align="justify">
 Este método una metodología ágil de gestión de proyecto. Contiene los siguientes términos:
</p>

`Product Backlog:` Lista priorizada de todo el trabajo o funcionalidades que se desean en el producto final. Es dinámica y puede cambiar a lo largo del desarrollo del proyecto.

`Sprint Backlog:` Subconjunto de items del Product Backlog seleccionados para el Sprint, más un plan para entregar el incremento del producto y alcanzar el objetivo del Sprint.

`In Process:` Tareas que actualmente se están trabajando. Una vez que comienza el Sprint, los items se mueven aquí desde el Sprint Backlog.

`In Review:` Tareas completadas pero que están en proceso de ser revisadas por calidad, funcionalidad o cumplimiento de requisitos. Es un paso antes de ser consideradas "hechas".

`Done:` Tareas que han sido completadas y han pasado todas las revisiones necesarias, cumpliendo con la definición de "hecho" del equipo. Están listas para ser entregadas o han sido entregadas al cliente.

<p align="justify">
 Esta estructura ayuda a visualizar el progreso del trabajo y asegura que todas las tareas pasen por las etapas necesarias antes de ser consideradas completas.
</p>

## Deployment

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/69b55c87-68b0-40a0-8c86-3ec3f39bf4b8)

<p align="justify">
 Deployment.yml automatizará el proceso de despliegue cuando ocurran eventos específicos en la rama main. Aquí está lo que hace cada sección:
</p>

`name:` El nombre del flujo de trabajo es "Deployment".

`on:` Define los eventos que desencadenan el flujo de trabajo. En este caso, cualquier push o pull request a la rama main, además del evento workflow_dispatch, que permite la ejecución manual del flujo de trabajo.

`permissions:` Configura los permisos del token de GitHub, dando permiso para escribir en los contenidos del repositorio.

`jobs:` Define los trabajos que el flujo de trabajo ejecutará, que en este caso es build-and-deploy.

`runs-on:` Especifica que el trabajo se ejecutará en el último entorno de Windows disponible.

`steps:` Los pasos que se llevarán a cabo en el trabajo, que incluyen:

  •	`Checkout Repo:` Utiliza la acción actions/checkout@v3 para clonar el repositorio y poder trabajar con él.
  •	`Set up JDK 11:` Utiliza la acción actions/setup-java@v2 para configurar el entorno Java Development Kit (JDK) versión 11, usando la distribución 'temurin'.
        

        
        
<p align="justify">
Este es un flujo de trabajo de despliegue y se ocupará de preparar el entorno necesario para compilar.
</p>





