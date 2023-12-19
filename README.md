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

- [.gitignore](#gitignore)

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

#### Sprint 3

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/53c02034-233e-423b-b93f-c431e406998f)


<p align="justify">
  Tareas:
  
•	Identificar y priorizar los casos de uso clave para el sprint.

•	Implementar las vistas y controladores requeridos para los casos de uso seleccionados.

•	Asegurar que cada caso de uso se integre correctamente con la capa de persistencia.

•	Continuar la refactorización y mejora del código base según sea necesario.

•	Añadimos un .yml para mejorar los work flows y la configuración del proyecto.

Retrospectiva:

•	Evaluar la implementación de los casos de uso y la eficacia del trabajo en equipo.

•	Identificar desafíos técnicos encontrados y cómo se resolvieron.

•	Revisar y ajustar las prácticas de desarrollo si es necesario para mejorar la productividad.

•	Recoger retroalimentación para ajustar y mejorar los siguientes sprints.

Antes y después de cada Sprint:

•	Al no ser capaz de completar los casos de uso, vamos a introducirlos en el siguiente sprint, a pesar de ello, hemos realizado algunas fusiones para avanzar en el proyecto y de esta manera ver que se ha seguido avanzando
</p>

#### Sprint 4

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/d0c9bc3f-8c3a-4662-a0d6-7d1f41c5b074)

<p align="justify">
Tareas:
  
•	Continuar con la implementación de casos de uso pendientes y documentación.

•	Implementar las vistas y controladores requeridos para los casos de uso seleccionados.

•	Configurar SonarCloud en el proyecto y conectarlo con el repositorio de GitHub.

•	Establecer umbrales de calidad y reglas de análisis para el proyecto.

•	Ajustar el archivo pom.xml para incluir el plugin de SonarCloud si es necesario.

•	Ejecutar análisis iniciales y resolver problemas críticos o bloqueantes encontrados.

•	Implementar las vistas y controladores requeridos para los casos de uso seleccionados.

•	Refinar la automatización de CI/CD para incluir análisis de SonarCloud.

Retrospectiva:

•	Evaluar la implementación de los casos de uso y la eficacia del trabajo en equipo.

•	Evaluar la integración de SonarCloud y su impacto en el flujo de trabajo del equipo.

•	Revisar y ajustar las prácticas de desarrollo si es necesario para mejorar la productividad.

•	Recoger retroalimentación para ajustar y mejorar los siguientes sprints.

Antes y después de cada Sprint:

•	Seguimos implementando funcionalidades del proyecto. Ahora que tenemos incorporado SonarCloud, nos ayudará a mantener estándares de calidad en el código y a prevenir erroes a medida que avanza el proyecto.
</p>

#### Sprint 5

<img width="239" alt="image" src="https://github.com/ISOII-ASHP/biblioteca/assets/91836109/960a49ea-d4d6-4009-a9c0-d3af01567755">

<p align="justify">
Tareas:
  
•	Configurar el plugin Maven Surefire para la ejecución de pruebas unitarias.

•	Escribir pruebas unitarias con JUnit para las funcionalidades desarrolladas.

•	Integrar JaCoCo para analizar y reportar la cobertura de código.

•	Establecer umbrales de cobertura de código y trabajar para cumplirlos o superarlos.

•	Continuar con el desarrollo de las funcionales que faltan.

•	Configurar un workflow para que en cada commit del main, se realice un análisis de código con SonarCloud.

Retrospectiva:

•	Evaluar la efectividad del marco de pruebas implementado.

•	Discutir los desafíos y las mejoras en la calidad y cobertura de código.

Antes y después de cada Sprint:

•	Seguimos implementando funcionalidades del proyecto. Vamos introduciendo pruebas unitarias y análisis de cobertura que nos ayudará a detectar problemas temprano, evitar regresiones y mantener un estándar de calidad a medida que el proyecto crece. El equipo continúa con el desarrollo de pruebas unitarias utilizando JUnit y el plugin Maven Surefire para asegurarse de que las funcionalidades y correcciones son estables y no introducen regresiones. 
</p>

#### Sprint 6
<p align="justify">
Tareas:
  
•	Crear una rama mantenimiento dedicada a las tareas de limpieza del código.

•	Revisar los informes de SonarCloud para identificar y priorizar errores.

•	Corregir los errores y llevar a cabo refactorizaciones necesarias para mejorar la calidad del código.

•	Realizar pruebas para asegurar que las correcciones no introduzcan nuevos errores.

•	Fusionar la rama mantenimiento de vuelta a master después de que las correcciones hayan sido verificadas.

Retrospectiva:

•	Analizar el proceso de mantenimiento y las correcciones realizadas.

•	 Planificar actividades de mantenimiento continuo basadas en la retroalimentación de SonarCloud.

Antes y después de cada Sprint:

•	Este enfoque de mantenimiento asegura un código más limpio y robusto, lo que puede reducir los costos a largo plazo y mejorar la mantenibilidad del software. El equipo trabaja diligentemente para cerrar el ciclo de desarrollo con un producto bien probado y con una interfaz de alta calidad.
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
<img width="662" alt="image" src="https://github.com/ISOII-ASHP/biblioteca/assets/91836109/08165d8a-f144-4d4f-9123-12b9b5ed1dc1">

<img width="590" alt="image" src="https://github.com/ISOII-ASHP/biblioteca/assets/91836109/785c0a8d-8ead-490b-a3c8-c116c57ae37a">

<img width="487" alt="image" src="https://github.com/ISOII-ASHP/biblioteca/assets/91836109/30863fa1-3eae-4baf-bd1d-8e6f114f067b">

<img width="338" alt="image" src="https://github.com/ISOII-ASHP/biblioteca/assets/91836109/d9a52e10-6f22-4728-8987-dbd5b9cdfa2a">



<p align="justify">
  El archivo pom.xml, indica las siguientes dependencias gestionadas:

</p>

`Spring Boot Starter Thymeleaf:` Para integrar el motor de plantillas Thymeleaf.

`Spring Boot Starter Web:` Proporciona todas las dependencias necesarias para construir aplicaciones web, incluyendo Spring MVC, Tomcat como el contenedor por defecto, etc.

`Spring Boot Starter Test:` Incluye herramientas de testing como JUnit, Hamcrest y Mockito.

`Spring Boot Starter Data JPA:` Facilita la implementación de repositorios JPA.

`Apache Derby:` Una base de datos en memoria que se utiliza para la persistencia de datos.

`Apache Derby Tools:` Herramientas para trabajar con la base de datos Derby.

`JUnit Platform launcer:` Proporciona capacidades para lanzar el marco de pruebas de JUnit.

`JUnit:` La biblioteca de JUnit para pruebas unitarias, marcada también para uso exclusivo en pruebas (<scope>test</scope>).

<p align="justify">

El proyecto está configurado para el desarrollo de una aplicación web con Spring Boot, aprovechando Thymeleaf como motor de plantillas y Spring Data JPA para la gestión de la persistencia de datos. La base de datos Derby se utiliza para el almacenamiento de datos, facilitando un entorno de base de datos integrado. Para las pruebas unitarias, el proyecto se apoya en JUnit.

</p>


<p align="justify">
  Además, el archivo pom.xml incluye configuraciones relacionadas con:

</p>

`JaCoCo:` Configurado a través del plugin jacoco-maven-plugin. Este plugin se utiliza para medir y reportar la cobertura de código de las pruebas. Hay dos ejecuciones configuradas para JaCoCo: una para inicializar JaCoCo (jacoco-initialize) y otra para crear reportes de cobertura durante la fase de empaquetado (jacoco-site).

`SonarCloud:` Mencionado en las propiedades del proyecto con las claves sonar.organization y sonar.host.url. SonarCloud es un servicio de análisis de código en la nube que ayuda a identificar problemas de calidad y seguridad en el código. Aunque el plugin de SonarCloud no está explícitamente configurado en el pom.xml, las propiedades mencionadas sugieren que el proyecto está preparado para integrarse con SonarCloud.

`Surefire:` Configurado a través del plugin maven-surefire-report-plugin. Este plugin se usa para ejecutar pruebas unitarias y generar informes de estas pruebas. La configuración especifica que no se debe omitir el informe si no hay pruebas (<skipEmptyReport>false</skipEmptyReport>), asegurando así que se generen informes incluso cuando no hay pruebas o estas no se ejecutan.


<p align="justify">

Estos componentes son esenciales en proyectos de software modernos, ya que JaCoCo proporciona información vital sobre la cobertura de pruebas, SonarCloud ayuda a mantener la calidad del código y Surefire asegura que las pruebas unitarias se ejecuten correctamente y se generen informes de las mismas.

Estas herramientas juntas ofrecen un entorno robusto para el desarrollo, prueba, y mantenimiento de aplicaciones web de alta calidad y con buenas prácticas de ingeniería de software.

</p>


## Ramas y merges

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/73a3a5f8-a3d5-4afb-9efd-9c192d99924d)

<p align="justify">
 La gestión de configuración de ramas en un proyecto que utiliza Git y sigue el modelo de branching por características junto con las ramas master y develop se organiza generalmente de la siguiente manera:

</p>

`Rama Master:` Sirve como la rama principal donde el código refleja el estado de producción. Las actualizaciones a master se hacen a través de merges cuidadosamente revisados desde develop o ramas de hotfix, en caso de error.

`Rama Develop:` Actúa como una rama de integración para las características que se están desarrollando. Esta es la rama donde todas las características (feature branches) se unen (merge) antes de ser llevadas a master.

`Rama Mantenimiento:` La rama es una rama dedicada a la mejora continua y corrección de errores en el código existente. El propósito de esta rama es permitir un enfoque organizado para abordar los problemas identificados por herramientas de análisis de código como SonarCloud, así como para realizar refactorizaciones y optimizaciones.

`Feature Branches:` Por cada nueva característica o mejora significativa, se crea una nueva rama desde develop. Esto permite trabajar en la característica de manera aislada. Una vez que la característica está completa y ha pasado todas las pruebas, se hace merge de vuelta a develop.

`Merges:` Los merges de las ramas de características a develop se hacen con frecuencia para integrar y probar nuevas funcionalidades. Antes de un lanzamiento, develop se fusiona con master para reflejar la nueva versión.

<p align="justify">
 Este enfoque ayuda a mantener organizado el desarrollo, facilita la integración continua y la entrega continua (CI/CD), y asegura que la rama de producción siempre mantenga un estado estable.
</p>

## Commits

<img width="958" alt="image" src="https://github.com/ISOII-ASHP/biblioteca/assets/91836109/dd349d55-ca08-4c6a-904f-553ae3c1317a">

<p align="justify">
Actualmente, tenemos 54 commits.
</p>

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

<img width="442" alt="image" src="https://github.com/ISOII-ASHP/biblioteca/assets/91836109/53e1f1c9-0363-4797-9d87-895f2c80da3c">

<p align="justify">
 El flujo de trabajo "Deployment" se activa con cambios en la rama main o mediante activación manual. Posee permisos para escribir en el repositorio. Se ejecuta en Windows y consta de varios pasos: clona el repositorio, configura JDK 11 con Temurin, compila el proyecto con Maven y realiza un análisis de código con SonarCloud, usando tokens de autenticación. Aquí está lo que hace cada sección:
</p>

`name:` El nombre del flujo de trabajo es "Deployment".

`on:` Define los eventos que desencadenan el flujo de trabajo. En este caso, cualquier push o pull request a la rama main, además del evento workflow_dispatch, que permite la ejecución manual del flujo de trabajo.

`permissions:` Configura los permisos del token de GitHub, dando permiso para escribir en los contenidos del repositorio.

`jobs:` Define los trabajos que el flujo de trabajo ejecutará, que en este caso es build-and-deploy.

`runs-on:` Especifica que el trabajo se ejecutará en el último entorno de Windows disponible.

`steps:` Los pasos que se llevarán a cabo en el trabajo, que incluyen:

  •	`Checkout Repo:` Utiliza la acción actions/checkout@v3 para clonar el repositorio y poder trabajar con él.
  •	`Set up JDK 11:` Utiliza la acción actions/setup-java@v2 para configurar el entorno Java Development Kit (JDK) versión 11, usando la distribución 'temurin'.
  •	`Build with Maven:` Compila el proyecto utilizando Maven.
  •	`Analyze with SonarCloud:` Realiza un análisis de código con SonarCloud, utilizando tokens de GitHub y SonarCloud para autenticación.
        
        
<p align="justify">
Este es un flujo de trabajo de despliegue y se ocupará de preparar el entorno necesario para compilar.
</p>

## Gitignore

<img width="221" alt="image" src="https://github.com/ISOII-ASHP/biblioteca/assets/91836109/5e71cd03-7dec-49b5-986a-0c7c824de835">

<p align="justify">
El archivo .gitignore es utilizado en repositorios de Git para excluir archivos y directorios del control de versiones. Las entradas especificadas en este archivo no serán rastreadas por Git, lo que significa que no aparecerán en commits ni serán subidos al repositorio remoto. Este archivo está configurado para ignorar:
</p>

•	Directorios comunes de compilación como target/.

•	Archivos relacionados con herramientas y entornos de desarrollo como IntelliJ IDEA (.idea, *.iws, *.iml, *.ipr), Eclipse (.classpath, .project, .settings, springBeans, .sts4-cache), NetBeans (nbproject/private/, nbbuild/, dist/, nbdist/, .nb-gradle), y Visual Studio Code (.vscode/).

•	Archivos relacionados con la base de datos y logs como database/, derby.log, y archivos .dat.

•	Otros archivos de configuración de herramientas como .dbeaver.

<p align="justify">
El propósito de estas exclusiones es mantener el repositorio limpio y evitar subir archivos que son específicos de la configuración de cada desarrollador o que son generados durante la compilación y ejecución del código.
</p>


