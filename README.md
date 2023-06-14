ildar
тестовое задание
-
запуск сервисов скопом ./install.sh или команды по очереди
1 сборка mvn clean package
2 докеризация docker build -t sprinbootcore:dev .
3 запуск бд в докере и приложения docker-compose up -d --build

 локальный запуск
 1 mvn clean install
 2 run
 
тестирование
1. localhost:8080/employee/add
2. localhost:8080/flights/add
3. localhost:8080/pairings/populate-assigments
4. localhost:8080/employee/87694/pairings
5. localhost:8080/employee/87694/flights

сваггер
