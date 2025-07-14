# UI Автотесты для [интернет-магазина Kinash.ru](https://kinash.ru/)
&nbsp;
![сайт Kinash.ru](https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/kinash_mainPage.png)

Этот проект представляет собой масштабируемую и гибко настраиваемую систему автотестирования пользовательского интерфейса интернет-магазина, разработанную с акцентом на читаемость, поддержку и расширяемость. Проект демонстрирует глубокую интеграцию с современным стеком инструментов автоматизации и подходит как для локального запуска, так и для CI/CD окружений.

---

## 🚀 Возможности проекта

- ✅ Поддержка **локального** и **удалённого** запуска (через Selenoid)
- ✅ Гибкий выбор **браузеров**: Chrome, Firefox
- ✅ Настраиваемая **параллельность** тестов через Jenkins/Gradle
- ✅ Полная **интеграция с Allure** (видео, логи, скриншоты)
- ✅ Расширенное логирование через **Selenide Custom Listener**
- ✅ Обработка нестандартных ошибок через **кастомные исключения**
- ✅ Детальный **tag-based запуск** групп тестов (`Smoke`, `Regression`, `Cart`, и др.)
- ✅ Отчётливое разделение слоёв: `Pages`, `Components`, `Config`, `Extensions`, `Helpers`

---

## 🧠 Особенности проекта

- 🔧 **TestWatcher (JUnit Extension)**: автоматическое прикрепление всех артефактов к отчету при падении.
- 📂 **Owner + env-переменные**: гибкое управление окружениями.
- 🔭 **Selenide Logger**: каждый шаг пишется в Allure + stdout (для отладки).
- ❗ **Custom Exceptions**: подробные сообщения об ошибках с URL, действием и локатором.

---

## Реализованы проверки:
### UI
- Проверка отображения главной страницы (лого, футер, заголовок)
- Поиск по товарам с использованием параметризованных тестов
- Фильтрация товаров по бренду в категории
- Добавление товара в корзину
- Очистка корзины
- Проверка характеристик и отзывов в карточке товара

---

## Используемые технологии и инструменты
<table>
<tbody>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/Intelij_IDEA.svg" width="40" height="40"><br>IntelliJ IDEA</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/Java.svg" width="40" height="40"><br>Java</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/Gradle.svg" width="40" height="40"><br>Gradle</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/JUnit5.svg" width="40" height="40"><br>JUnit5</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/Selenide.svg" width="40" height="40"><br>Selenide</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/Selenoid.svg" width="40" height="40"><br>Selenoid</td>
</tr>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/Jenkins.svg" width="40" height="40"><br>Jenkins</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/Github.svg" width="40" height="40"><br>Github</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/Allure.svg" width="40" height="40"><br>Allure Report</td>
</tr>
</tbody>
</table>

---

## 🏗️ Архитектура проекта

```
src
└── test
    ├── java
    │   ├── config            # Конфигурация WebDriver, env, OWNER
    │   ├── data              # Enums и тестовые данные
    │   ├── exceptions        # Кастомные исключения (например, ElementNotFound)
    │   ├── extensions        # JUnit TestWatcher для attach'ей на fail
    │   ├── helpers           # Скриншоты, видео, консоль и source -> Allure
    │   ├── listeners         # Кастомный Selenide listener с Allure-интеграцией
    │   ├── pages             # PageObject + Fluent API
    │   │   └── components    # Подкомпоненты и шапки, меню, и т.п.
    │   └── tests             # Тестовые сценарии
    │       ├── regress       # Регрессионные тесты
    │       └── smoke         # Smoke-сценарии
    └── resources
        └── properties        # Настройки окружений: local / remote
```

---

## Команды для запуска из терминала
Локально должны быть заданы параметры в remote.properties 
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
---

## Параметры с помощью которых можно [запустить сборку в Jenkins](https://jenkins.autotests.cloud/job/kinash-ui-tests/build):
![Сборка Jenkins-параметры-1](https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/Parameters.png)

---

## 📊 Allure отчет

Каждое падение сопровождается:

- Скриншотом
- HTML Source страницы
- Консольными логами браузера
- Видео (если `isRemote=true` и Selenoid)


### Доска с аналитикой тестирования
![Allure Overview](https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/AllureOverview.png)

---

### Пример автоматизированного тест кейса
![Allure Behaviors](https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/TestExample.png)

---

## Видео прохождение тестов из Selenoid
- Добавление товара в корзину и дальнейшая ее очистка
![cecc45885c9d83c248ce0c005f115492](https://github.com/LakeenkoI/LakeenkoI/blob/main/attachments/cecc45885c9d83c248ce0c005f115492.gif)
