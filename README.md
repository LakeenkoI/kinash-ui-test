# UI Автотесты для [интернет-магазина Kinash.ru'](https://kinash.ru/)
&nbsp;
![сайт Kinash.ru](https://github.com/LakeenkoI/sourceItems/blob/main/source/kinash_mainPage.png)

&nbsp;
## Реализованы проверки:
### UI
- Проверка отображения главной страницы (лого, футер, заголовок)
- Поиск по товарам: позитивные и негативные кейсы
- Фильтрация товаров по бренду в категории
- Добавление товара в корзину
- Очистка корзины
- Проверка характеристик и отзывов в карточке товара


&nbsp;
## Используемые технологии и инструменты
<table>
<tbody>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/sourceItems/blob/main/source/Intelij_IDEA.svg" width="40" height="40"><br>IntelliJ IDEA</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/sourceItems/blob/main/source/Java.svg" width="40" height="40"><br>Java</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/sourceItems/blob/main/source/Gradle.svg" width="40" height="40"><br>Gradle</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/sourceItems/blob/main/source/JUnit5.svg" width="40" height="40"><br>JUnit5</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/sourceItems/blob/main/source/Selenide.svg" width="40" height="40"><br>Selenide</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/sourceItems/blob/main/source/Selenoid.svg" width="40" height="40"><br>Selenoid</td>
</tr>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/sourceItems/blob/main/source/Jenkins.svg" width="40" height="40"><br>Jenkins</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/sourceItems/blob/main/source/Github.svg" width="40" height="40"><br>Github</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/sourceItems/blob/main/source/Allure.svg" width="40" height="40"><br>Allure Report</td>
</tr>
</tbody>
</table>

&nbsp;
## Команды для запуска из терминала
Локально должны быть заданы параметры в remoteweb.properties
### Запуск всех тестов на удалённом сервере:
```bash
gradle clean test -Denv=remote
```
### Запуск всех тестов в браузере FireFox с разрешением экрана 1920x1080:
```bash
gradle clean test -Dbrowser=firefox -DbrowserSize=1920x1080
```
### Запуск тестов с включением параллельного выполнения и выбором 4-х потоков:
```bash
gradle clean cart_tests -DparallelRun=true -Dthreads=4
```
### Собрать Allure отчет:
```bash
allure serve build/allure-results
```

&nbsp;
## Параметры с помощью которых можно [запустить сборку в Jenkins](https://jenkins.autotests.cloud/job/kinash-ui-tests/build):
![Сборка Jenkins-параметры-1](https://github.com/LakeenkoI/sourceItems/blob/main/source/Parameters.png)

## Отчёт в [Allure Report](https://jenkins.autotests.cloud/job/kinash-ui-tests/17/allure/)
### Доска с аналитикой тестирования
![Allure Overview](https://github.com/LakeenkoI/sourceItems/blob/main/source/AllureOverview.png)

### Пример автоматизированного тест кейса
![Allure Behaviors](https://github.com/LakeenkoI/sourceItems/blob/main/source/TestExample.png)

&nbsp;
## Видео прохождение тестов из Selenoid
- Добавление товара в корзину и дальнейшая ее очистка
![cecc45885c9d83c248ce0c005f115492](https://github.com/LakeenkoI/sourceItems/blob/main/source/cecc45885c9d83c248ce0c005f115492.gif)
