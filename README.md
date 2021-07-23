# StudentsClasses

сервис заявок для школьников

поля которые передает мобильное приложение для создания заявки:
имя ученика
номер телефона 
адрес школы 
название школы 
дату рождения
 
 ```java
1.Проверяем по номеру телефона 
     1.1 если есть переходим к пункту 2
      1.2 если нету создать пользователя
2. проверяем заявки end_date is null 
  2.1 если есть заявка проверяем статус
    new,approved,denied->canceled и сохранить новую заявку и ответ ваша заявка принята
    processed-> то отклоняем заявку и возщвращаем ответ на рассмотрении

                      при сохранении заявки end_date/ navi_date comment null 

        Response{
          code:1 || 0
          message:"" 
         }

            1. список всех заявок
            2. просмотр одной заявки findById(orderId) (обработка)
 		2.1 new-> end_date new Date() navi_date ;
                a. processed-> approved processed end_date 
 		b. processed-> denied заполняет comment("Неверные данные") end_date->new Date(); denied  
    
  ```
    
поля которые передает админ интерфейс:
id
schoolName,
address,
comment,
order_status
subscriber
