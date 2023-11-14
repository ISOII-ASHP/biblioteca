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

`Apache Derby Tools:` Una base de datos en memoria que se utiliza para la persistencia de datos.
    Apache Derby Tools: Herramientas para trabajar con la base de datos Derby.

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

## Product Backlog

## Deployment



