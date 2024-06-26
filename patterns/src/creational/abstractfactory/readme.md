<h1 align="center">
   Abstract Factory
</h1>
<h3 align="center">
   Абстрактная фабрика
</h3>

**Абстрактная фабрика** — это порождающий паттерн проектирования, который позволяет создавать семейства связанных
объектов, не привязываясь к конкретным классам создаваемых объектов.

Зачастую асбтрактная фабрика рождается из фабричного метода, когда необходимо добавить новыый продукт. В хорошей
программе, каждый класс отвечает только за одну вещь. Если класс имеет слишком много фабричных методов, они способны
затуманить его основную функцию. Поэтому имеет смысл вынести всю логику создания продуктов в отдельную иерархию классов,
применив абстрактную фабрику.

Абстрактная фабрика скрывает от клиентского кода подробности того, как и какие конкретно объекты будут созданы. Но при
этом клиентский код может работать со всеми типами создаваемых продуктов, так как их общий интерфейс был заранее
определён.

<h3 align="center">
   Реализация
</h3>

1. Абстрактные продукты объявляют интерфейсы продуктов, которые связаны друг с другом по смыслу, но выполняют разные
   функции.
2. Конкретные продукты — большой набор классов, которые относятся к различным абстрактным продуктам (кресло/ столик), но
   имеют одни и те же вариации (Барокко/Модерн).
3. Абстрактная фабрика объявляет методы создания различных абстрактных продуктов (кресло/столик).
4. Конкретные фабрики относятся каждая к своей вариации
   продуктов (Барокко/Модерн) и реализуют методы абстрактной фабрики, позволяя создавать все продукты определённой
   вариации.
5. Несмотря на то, что конкретные фабрики порождают конкретные продукты, сигнатуры их методов должны возвращать
   соответствующие абстрактные продукты. Это позволит клиентскому коду, использующему фабрику, не привязываться к
   конкретным классам продуктов. Клиент сможет работать с любыми вариациями продуктов через абстрактные интерфейсы.

<h3 align="center">
   Abstract Factory UML-диаграмма
</h3>

![diagram.png](diagram.png)

<h3>Плюсы</h3>

- Гарантирует сочетаемость создаваемых продуктов.
- Избавляет клиентский код от привязки к конкретным классам продуктов.
- Выделяет код производства продуктов в одно место, упрощая поддержку кода.
- Упрощает добавление новых продуктов в программу.
- Реализует принцип открытости/закрытости.

<h3>Минусы</h3>

- Усложняет код программы за счёт множества дополнительных классов.
- Требует наличия всех типов продуктов в каждой вариации

<h3 align="center">
   Пример реализации
</h3>

[Фабрики мебели разных стилей.](code)

<h3 align="center">
   Источники
</h3>

- Design Patterns with Java: [Abstract Factory](books/Olaf%20Musch%20EN.pdf)
- Введение в паттерны проектирования: [Абстрактная фабрика](books/Alexander%20Shvets%20RU.pdf)