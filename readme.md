﻿# [LifeBank Project](https://github.com/priziie/evaluacionlm)

## Back end
Los proyectos utilizan lombok, por lo que se recomienda instalar la herramienta de [este link](https://projectlombok.org/download).
 
Los servicios están hechos en Java Spring Boot y utilizan base de datos postgresql. Para preparar la base es necesario:<br>
1. Correr el script `1-database.sql` que está en la raíz de la carpeta con mi nombre.<br>
2. Asegurarse que está conectado en la base de datos *bank* antes de correr el script `2-schemas.sql.`<br>
3. Cambiar en los yml de los proyectos el puerto al correspondiente de su servicio, al igual que el usuario y contraseña generica. El puerto generalmente es *5432* y el usuario  *postgres* con la contraseña *root*, yo lo cambié ya que tuve problemas con la instancia principal.

### Servicios
* **bnk-authentication-svc**: Servicio para autenticar y autorizar una petición. Sirve como gateway para los demás servicios. Toda petición de la web vendrá a este servicio.
* **bnk-product-svc**: Servicio que contiene la información de todos los productos (cuentas bancarias, tarjetas de crédito y préstamos).
* **bnk-transaction-svc**: Servicio que almacena las transacciones.
* **bnk-beneficiary-svc**: Servicio que maneja la información de los beneficiarios.

### Endpoints con datos de prueba
**POST**<br>
localhost:1999/login

*Request*
```json
{
	"username": "LPMENDEZ",
	"password": "12345"
}
```

Todos los endpoints descritos abajo necesitan de un token de authentication en los parámetros del header request.
Este token que lo provee el inicio de sesión (arriba mencionado).

Para las pruebas iniciar sesión con usuario `LPMENDEZ` y contraseña `12345`

**GET**<br>
localhost:1999/products/getAccounts

----------------------------------

**GET**<br>
localhost:1999/transactions/getTransactions/{accountID}?start=01-Jan-2019&end=30-Mar-2019&prd=ACC<br>

*Parámetos Path*
* **accountID**: Id de la cuenta o producto. Prueba: 0000001<br>

*Parámetros Querystring*
* **start**: Fecha de inicio en formato *dd-MMM-yyyy (Inglés)*
* **end**: Fecha fin en formato *dd-MMM-yyyy (Inglés)*
* **prd**: Tipo de producto. *loan, creditCard, personal.*

----------------------------------

**POST**<br>
localhost:1999/operations/ownTransfer

*Request*
```json
{
	"from": "0000002",
	"to": "0000001",
	"amount": 3.4,
	"description": "Prueba"
}
```

----------------------------------

**POST**<br>
localhost:1999/operations/ownPayLoan<br>

*Request*
```json
{
	"from": "0000002",
	"to": "0000003",
	"amount": 50,
	"description": ""
}
```

----------------------------------

**POST**<br>
localhost:1999/operations/thirdPayCard

*Request*
```json
{
	"from": "0000002",
	"beneficiaryID": "3",
	"amount": 10,
	"description": "Pago de tarjeta abril"
}
```

----------------------------------

**POST**<br>
localhost:1999/operations/thirdTransfer

*Request*
```json
{
	"from": "0000001",
	"beneficiaryID": "1",
	"amount": 5.65,
	"description": "Almuerzo lunes"
}
```


Los siguientes endpoints iniciar sesión con usuario `PRUEBA` y contraseña `12345` y utilizar ese token en el header request

**POST**<br>
localhost:1999/operations/ownPayCard

*Request*
```json
{
	"from": "0000002",
	"to": "0000003",
	"amount": 50,
	"description": ""
}
```

----------------------------------

**POST**<br>
localhost:1999/operations/thirdPayLoan

*Request*
```json
{
    "from": "0000004",
    "beneficiaryID": "2",
    "amount": 90,
    "description": ""
}
```

----------------------------------

**POST**<br>
localhost:1999/beneficiaries/beneficiary

*Request*
```json
{
	"name": "Ledys cuenta",
	"account": "0000002",
	"type": "ACC",
	"email": "ledys@test.com"
}
```

----------------------------------

**PATCH**<br>
localhost:1999/beneficiaries/beneficiary/{beneficiaryID}

*Parámetos Path*
* **beneficiaryID**: Id del beneficiario. Prueba: 4

*Request*
```json
{
	"email": "ledys.mendez@test.com"
}
```

----------------------------------

**DELETE**<br>
localhost:1999/beneficiaries/beneficiary/{beneficiaryID}

*Parámetos Path*
* **beneficiaryID**: Id del beneficiario. Prueba: 4


## Front end
El proyecto web está hecho con [VueJS](https://vuejs.org/). <br>
Para iniciar el proyecto `bnk-views` es necesario tener instalado [NodeJS](https://nodejs.org/en/download/). Una vez instalado, basta con correr el siguiente comando en el path del proyecto
```shell
npm install
```
Luego
```shell
npm start
```
Inicia en puerto 3003.
