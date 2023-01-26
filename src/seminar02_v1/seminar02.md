## Проблемы с созданием проекта.

Java 19 пока не надо использовать - с-ма сборки Gradle не поддерживает. 17-ю версию, напр., от Amazon `correto-17`, можно с 11-й версией.

Интересная команда в Builder'e Gradle. На панели кнопка с динозавром, команда:

    gradle clean build

Возможно пересборка проекта.

В случае выбора сборщика `Gradle`. File -> Setting -> Build, Execution... -> Gradle: Gradle procjects.
* check on `Download external  annotations for dependencies`;
* Build and run using: Gradle (Default);
* Run tests using: Gradle (Default);
* Use  Gradle from: `gradle-wrapper.properties` file;
* Gradle JVM: correto-17 Amazon....

Есть настройки. File -> Project Structure -> Project Settings -> Project:
* Name: name_of_project;
* SDK: correto-17 Amazon...;
* Language level: SDK default (17 - Sealed types,...)

## Структура проекта для сдачи ДЗ.

Как подготовить проект для отправки на GitHub?

    Path: <name_of_project>/src/main/java

> Это обязательный путь. Далее относительно этого пути.

Напр., создать `package` (каталог) с названием урока, напр., `string_array`, главное чтобы каталог был внутри каталога `java`. 

Пр. кн. мыши на `java` -> New -> Package.

> Внимание! На одном уровне с `../src/java` - ничего не должно быть.

Навести мышь, на вновь созданный пакет и создать `Class` с нужным именем, напр. `Seminar01Task01`. Имя созданного файла должно совпадать с наз. класса в самом файле.

### StringBuilder.

StringBuilder - класс, который хранит в себе последовательность символов, работает как массив. И когда к нему что-то добавляется, то создается новая строка.

> Складывать строки в цикле - плохо!



## Sources.
1. [13.27. Java – Метод Math.random()](https://doc.cuba-platform.com/manual-latest-ru/recommended_code_style.html)