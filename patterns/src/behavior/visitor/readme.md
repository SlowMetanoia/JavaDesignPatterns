<h1 align="center">
   Visitor
</h1>
<h3 align="center">
   Посетитель
</h3>

**Посетитель** — это поведенческий паттерн проектирования, который позволяет создавать новые операции, не меняя классы
объектов, над которыми эти операции могут выполняться.

*Паттерн хороший, но имеет неприятный краевой случай про который буде описано далее.*

<h3 align="center">
   Применимость
</h3>

- Когда вам нужно выполнить операцию над всеми элементами сложной структуры объектов (например, деревом).
- Когда над объектами сложной структуры объектов надо выполнять некоторые, не связанные между собой операций, но вы не
  хотите «засорять» классы такими операциями.
- Когда новое поведение имеет смысл только для некоторых классов из существующей иерархии.

<h3 align="center">
   Реализация
</h3>

1. Создайте интерфейс посетителя и объявите в нём методы «посещения» для каждого класса компонента, который необходимо
   посетить.
2. Опишите интерфейс компонентов. Если вы работаете с уже существующими классами, то объявите абстрактный метод принятия
   посетителей в базовом классе иерархии компонентов.
3. Если есть возможность: Реализуйте методы принятия во всех конкретных компонентах. Они должны переадресовывать вызовы
   тому методу посетителя, в котором класс параметра совпадает с текущим классом компонента - метод двойной
   диспетчеризации.
4. Иерархия компонентов должна знать только о базовом интерфейсе посетителей. С другой стороны, посетители будут знать
   обо всех классах компонентов.
5. Для каждого нового поведения создайте свой конкретный класс. Приспособьте это поведение для всех посещаемых
   компонентов, реализовав все методы интерфейса посетителей.
6. Клиент будет создавать объекты посетителей, а затем передавать их компонентам, используя метод принятия.

<h3>
   Механизм двойной диспетчеризации
</h3>

*Кратко, как это имеется в виду в данном паттерне:*

В класс, который мы посещаем добавляться метод принятия посетителя ```accept(Visitor visitor)```, внутри которого
происходит передача данного элемента в посетитель:

```
foreach (Node node : graph)
    node.accept(exportVisitor);
    
class Type1:
    method accept(Visitor v) is
        v.doForType1(this);
```

<h3>
    Краевой случай - классы недоступные для изменения
</h3>

Проблема с данным паттерном начинаются когда классы, которые мы хотим посещать не доступны для изменения и не имеет в
себе методов для принятия посетителя. В таком случае мы не можем воспользоваться/реализовать метод двойной
диспетчеризации и код превращается в большой набор условных операторов проверки типа:

```
foreach (Node node : graph)
    if (node instanceof Type1)
        exportVisitor.doForType1((Type1) node);
    if (node instanceof Type2)
        exportVisitor.doForType2((Type2) node);
```

<h3 align="center">
   Visitor UML-диаграмма
</h3>

![diagram.png](diagram.png)

<h3>Плюсы</h3>

- Упрощает добавление новых операций над всей связанной структурой объектов.
- Объединяет родственные операции в одном классе.
- Посетитель может накоплять состояние при обходе структуры компонентов.

<h3>Минусы</h3>

- Паттерн неоправдан, если иерархия компонентов часто меняется.
- Может привести к нарушению инкапсуляции компонентов.
- Сложная реализация если классы компонентов не доступны для изменения.

<h3 align="center">
   Сравнение с другими паттернами
</h3>

Конечно паттерн **Посетитель** с первого взгляда может быть поход на **Итератор** - и там и там мы обходим элементы, но
на самом деле они имеют принципальные отличия:

**Итератор** задает порядок обхода элемента и предоставляет клиентскому коду возможность воспользоваться этим
обходом - ```иетратором```.

**Посетитель** никак не связан с порядком обхода. Суть посетителя это выполнение действий с/над данными элементам.

Паттерны хорошо синергируют, когда при помощи **Итератора** мы задаем порядок обхода. Используя **Итератор** для обхода
**Посетитель** выполняет действия над данными.

<h3 align="center">
   Примеры
</h3>

- [Обход документа с узлами в разынх нотациях](code)

<h3 align="center">
   Источники
</h3>

- [Wikipedia: Двойная диспетчеризация.](https://en.wikipedia.org/wiki/Double_dispatch)
- Design Patterns with
  Java: [Visitor](books/Olaf%20Musch%20EN.pdf)
- Введение в паттерны
  проектирования: [Посетитель](books/Alexander%20Shvets%20RU.pdf)