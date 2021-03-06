# MySQL
- sudo mysql
- sudo systemctl status mysql
- sudo service mysql restart
- show databases;
- use my_db_spring_mvc_aop;
- show tables;
- SELECT * FROM my_db_spring_mvc_aop.employees;
 
# REST API
- REST - REpresentation State Transfer
- способ коммуникации между приложениями.
- Описывает стандарты, используя которые Клиент взаимодействует с Севревром посредством HTTP протокола.

## JSON
- JavaScript Data Notation
- Формат данных предств. собой текстувую инфр-ю.
- - содержит коллекцию пар ключ-значение.
- не привязан к языку программирования.
- JSON Data Binding или JSON Mapping - это привязка JSON к Java объекту.
  {
  "name":"Batman",
  "salary":100500,
  "languages":["English", "Deutch"],
  "car":{
  "model":"Panzer",
  "color":"black"
  },
  "house":null
  }

# Spring
- @requestMapping(path="/showDetails", method = RequestMethod.GET) == @GetMapping("/showDetails") OR @PostMapping()

## HTTP request
- Request line --> HTTP метод и адрес (URL)
- Zero or more Headers --> Метаданные о запросе
- An empty line --> разделитель
- Message body(optional) --> Payload - полезная нагрузка

## HTTP response
- Statis line --> код статуса и текст статуса.
- Zero or more Headers --> Метаданные о ответе
- An empty line --> разделитель
- Message body(optional) --> Payload - полезная нагрузка

### HTTP response status codes
1. 1XX informational.
2. 2XX success
3. 3XX redirection
4. 4XX client error
5. 5XX server error

## REST API стандарты
    > konvut.github.io/k50articles/
| HTTP метод | URL                          | CRUD                            |
|------------|------------------------------|---------------------------------|
| *GET*      | `api/employees`              | **Получение всех  работников**  |
| *GET*      | `api/employees/{employeeId}` | **Получение одного  работника** |
| *POST*     | `api/employees`              | **Добавление  работника**       |
| *PUT*      | `api/employees`              | **Изменение  работника**        |
| *DELETE*   | `api/employees/{employeeId}` | **Удаление работника**          |
#

# REST API configuration
- конфигурация приложения Spring MVC + Hibernate без участия XML файлов:
  - Подготовка БД
    - заимствуем из https://github.com/mirpribili/spring_mvc_hibernate_aop/blob/master/README.md
  - add dependencies
  - создание конфигурационного Java класса
  - add if not exist <artifactId>maven-war-plugin</artifactId>
  - Создание класса для реализации Dispatcher Servlet
  - Добавить  TomCat
# Получение списка работников
  - @RestController - Controller, управляющий REST запросами и ответами.
    - @RequestMapping("/api") 
    - public class MyRESTController{
# Получение 1 работника по id
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
- вот как можно получить переменную из запроса
# Обработка исключений
# Глобальная обработка исключений для любого количества контроллеров
- с помощью AOP реализуем структуру:
  > global_exceptions.png
# Добавление нового работника
# Изменение существующего
# Удаление работника

