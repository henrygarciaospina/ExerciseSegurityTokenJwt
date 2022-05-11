1. Para tener acceso a los endpoints primero se debe correr los tests de UserRepositoryTests que al correrlos
crea un usuario con la contraseña y correo que se defina, se puede modificar, se pueden crear n usuarios, 
los tests validan que no existe elusuario para poder crearlo.

2.En Postman 
  a. Correr la api Post http://localhost:8080/auth/login
  b. Antes de correr el post creamos el cuerpo con el correo y el password definidos
    en UserRepositoryTests

   {
    "email":"henry@codejava.com",
    "password":"nam2020"
   }


Una vez corramos nuestra api de login se va ha generar el token de autenticación que nos va ha permitir
acceder a los endpoints.

 "email": "henry@codejava.com",
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1LGhlbnJ5QGNvZGVqYXZhLmNvbSIsImlzcyI6IkNvZGVKYXZhIiwiaWF0IjoxNjUyMjc3NjQyLCJleHAiOjE2NTIzNjQwNDJ9.Ze92p8paqQwCPYZmBeVcbTMChU1CgF_ioB_BM7ecXdphjpV7lp1ExSuepYGN1IyWBdOxGMVucNiLiRdpabn2Ng" 


3.Para configurar el acceso a las apis debemos elegir Authorization
                                                      Bearer token
                
y al lado derecho donde aparece la etiqueta token, ingresamos en la caja de texto el token sin comillas

4.Una vez configurada la seguridad podemos correr nuestros 3 endpoints:
  
POST http://localhost:8080/products
GET http://localhost:8080/products
GET http://localhost:8080/products/1


