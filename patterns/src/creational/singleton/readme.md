<h1 align="center">
   Singleton
</h1>
<h3 align="center">
   Одиночка
</h3>

**Одиночка** — это порождающий паттерн проектирования, который гарантирует, что у класса есть только один экземпляр, и
предоставляет к нему глобальную точку доступа.

1. Синглтон гарантирует наличие единственного экземпляра класса.
   Чаще всего это полезно для доступа к какому-то общему
   ресурсу, например, базе данных.
2. Предоставляет глобальную точку доступа. Это не просто
   глобальная переменная, через которую можно достучаться
   к определённому объекту. Глобальные переменные не
   защищены от записи, поэтому любой код может подменять
   их значения без вашего ведома.

<h3 align="center">
   Реализация
</h3>
Все реализации одиночки сводятся к тому, чтобы скрыть
конструктор по умолчанию и создать публичный
статический метод, который и будет контролировать
жизненный цикл объекта-одиночки.

Принято, что статисческое поле, хранящее ссылку на переменную имеет название ```instance```, а статический метод
получения доступа к экземпляру ```getInstance()```.
*Все к этому привыкли, так что используйте только такие названия.*
***Гадать что имел ввиду автор люди не любях и не хотят!***

<h3 align="center">
   Singleton UML-диаграмма
</h3>

![diagram.png](diagram.png)

<h3>Плюсы</h3>

- Гарантирует наличие единственного экземпляра класса.
- Предоставляет к нему глобальную точку доступа.

<h3>Минусы</h3>

- Нарушает принцип единственной ответственности класса.
- Требует постоянного создания Mock-объектов при юнит-тестирования.
- Маскирует плохой дизайн.
- Проблемы мультипоточности.

*Автор данного репозитория не соглсаен с некоторыми минусами.* :grin:

<h3 align="center">
   Антипаттерн
</h3>

Любят холеварить что синглтон антипаттерн, так как:

1. Синглтон накладывает ограничения на код и приводит к скрытой связности, что в дальнейшем затрудняет тестирование,
   расширяемость и поддержку кода.
2. Нарушает принцип единой отвественности, так как выполняет сразу функции управления жизненым циклом объекта и бизнес
   логику.

Да, решает две проблемы. Нет, не плохой паттерн, а один из самых распространенных. В некоторых ЯП для него даже имеются
встроенные языковые кострукции, например ```Object``` в Scala/Kotlin.

<h3 align="center">
   Потоко-безопасный Singleton
</h3>

В книге [Design Patterns with Java](books/Olaf%20Musch%20EN.pdf) *Olaf Musch* приведены
несколько способов создания потоко-безопасных.
Сущесвует несколько способов создания потоко-безопасных синглотов, в завивисимости от ситуации.
Синглтонов. Возможно вам пригодиться это при выполнении ЛР3.

<h3 align="center">
   Пример реализации
</h3>

[Имитация объекта, отвечающего за подключение к БД.](code)

<h3 align="center">
   Источники
</h3>

- Design Patterns with Java: [Singleton](books/Olaf%20Musch%20EN.pdf)
- Введение в паттерны проектирования: [Одиночка](books/Alexander%20Shvets%20RU.pdf)
