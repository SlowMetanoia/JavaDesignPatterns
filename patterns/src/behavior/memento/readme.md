<h1 align="center">
   Memento
</h1>
<h3 align="center">
   Снимок
</h3>

**Снимок** — это поведенческий паттерн проектирования, который позволяет делать снимки состояния объектов, не раскрывая
подробностей их реализации. Затем снимки можно использовать, чтобы восстановить прошлое состояние объектов.

<h3 align="center">
   Применимость
</h3>

- Когда вам нужно сохранять мгновенный снимок состояния объекта (или его части), чтобы впоследствии объект можно было
  восстановить в том же состоянии.
- Когда прямое получение состояния объекта раскрывает детали его реализации и нарушает инкапсуляцию.

<h3 align="center">
   Реализация
</h3>

1. Определите класс создателя, объекты которого должны создавать снимки своего состояния.
2. Создайте класс снимка и опишите в нём все те же поля, которые имеются в оригинальном классе-создателе.
3. Сделайте объекты снимков неизменяемыми. Они должны получать начальные значения только один раз, через свой
   конструктор.
4. Если ваш язык программирования это позволяет, сделайте класс снимка вложенным в класс создателя.
5. Добавьте в класс создателя метод получения снимков. Создатель должен создавать новые объекты снимков, передавая
   значения своих полей через конструктор.
6. Добавьте в класс создателя метод восстановления из снимка.
7. Опекуны, будь то история операций, объекты команд или нечто иное, должны знать о том, когда запрашивать снимки у
   создателя, где их хранить, и когда восстанавливать.
8. Связь опекунов с создателями можно перенести внутрь снимков. В этом случае каждый снимок будет привязан к своему
   создателю и должен будет сам восстанавливать его состояние. Но это будет работать либо если классы снимков вложены в
   классы создателей, либо если создатели имеют сеттеры для установки значений своих полей.

<h3 align="center">
   Memento UML-диаграмма
</h3>

![diagram.png](diagram.png)

<h3>Плюсы</h3>

- Не нарушает инкапсуляции исходного объекта.
- Упрощает структуру исходного объекта. Ему не нужно  хранить историю версий своего состояния.

<h3>Минусы</h3>

- Требует много памяти, если клиенты слишком часто  создают снимки.
- Может повлечь дополнительные издержки памяти, если  объекты, хранящие историю, не освобождают ресурсы,  занятые устаревшими снимками
- При реализации паттерна легко нарушить инкапсуляцию.
- При создании снимков всплывают проблемы поверхностного и глубокого копирования.

<h5>
   Замечание
</h5>

Здесь и в книге Швеца представлен алгоритм создания с вложенным классом снимка. Класс снимка может быть и не вложенным,
как в примере приведеным в ```code```.

В общем суть паттерна в наличии возможности возврата к предыдущему состоянию. Будет ли это целя история состояний, где и
как они будут храниться, будет ли класс снимка вложен в класс, чьё состояние мы должны уметь сохронять - особенности
конкрентной реализации.

<h3 align="center">
   Примеры
</h3>

- Всё где вы отменяете действие это и есть снимок.
- [Пример с текстовым рекдактором.](code)

<h3 align="center">
   Источники
</h3>

- [Baeldung: Memento Design Pattern in Java](https://www.baeldung.com/java-memento-design-pattern)
- Design Patterns with
  Java: [Memento](books/Olaf%20Musch%20EN.pdf)
- Введение в паттерны
  проектирования: [Снимок](books/Alexander%20Shvets%20RU.pdf)