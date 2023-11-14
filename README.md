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
 
</p>


## Workflows



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

`Apache Derby Tools:` Una base de datos en memoria que se utiliza para la persistencia de datos.
    Apache Derby Tools: Herramientas para trabajar con la base de datos Derby.

<p align="justify">

Estas dependencias están configuradas para ser gestionadas por Maven, lo que significa que Maven se encargará de descargar y mantener actualizadas estas librerías de acuerdo con las versiones especificadas en tu archivo pom.xml.

</p>


## Ramas y merges

![image](https://github.com/ISOII-ASHP/biblioteca/assets/91836109/193bd82b-292b-4b6e-b50f-f58beacd23ff)


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

## Product Backlog

## Deployment



