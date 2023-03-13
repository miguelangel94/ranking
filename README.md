Ranking api.
Se trata de un microservicio en el cual puedes subir series con tu grupo de amigos y valorarlas.
Cuenta con 5 endpoints
1- GET ranking/v1/users Trae la lista de Users
2- POST ranking/v1/series Permite guardar una serie nueva (No puedes guardar una serie con un nombre que ya exista)
3- POST ranking/v1/users/{userId}/series/{serieId}/scores  Te permite como usuario hacer una valoracion a una serie (No puedes valorar mas de una vez la misma y la valoracion debe ir entre 0 y 10 puntos)
4- GET ranking/v1/series Trae la lista de series ordenadas por su puntuacion promedio.  Cumple con los requisitos demandados en el ejercicio
5- GET ranking/v1/series/scores Trae la lista de series con su lista de valoraciones adentro. Cumple con los requisitos demandados en el ejercicio

Como levantar la app en local
La app esta desarrollada con Java 17, spingBoot 3 y mysql 8.0
1- Debes crear una conexion local en l puerto 3306 con user y pass = root  (Mirar aplication properties)
2- Debido a que la app utiliza flyway para crear las tablas y lanzar algunos scripts basicos deber crear un esquema vacío en la conexion creada anteriormente llamado "ranking" para que flyway pueda ejecutar los scripts en el.
3- A nivel de readme encontraras una coleccion de postman que podrás usar para probar las llamadas.
Esto es todo lo necesario.
A disfrutar de ranking app!!