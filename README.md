# Store

## Описание проекта
**Store** - это консольное Java-приложение для управления списком товаров в магазине. Приложение позволяет добавлять, удалять, обновлять и сортировать товары, а также просматривать историю изменений.

## Возможности
- Добавление новых товаров с указанием названия, категории, цены и количества.
- Удаление товаров по названию.
- Обновление количества товара.
- Поиск товаров по категории.
- Поиск товаров в заданном диапазоне цен.
- Просмотр списка товаров с сортировкой по названию или категории.
- Просмотр истории изменений.


## Использование
После запуска программы доступны следующие команды:
- `add` - добавить товар.
- `update` - обновить количество товара.
- `delete` - удалить товар.
- `show` - показать список товаров.
- `search` - найти товары по категории.
- `price range` - найти товары в указанном диапазоне цен.
- `history` - показать историю изменений.
- `exit` - завершить программу.

## Структура кода
- `Product` - класс товара с полями: название, категория, цена, количество.
- `Category` - перечисление доступных категорий товаров.
- `Store` - класс управления списком товаров и историей изменений.
- `Main` - основной класс для взаимодействия с пользователем.


