Краткое оглавление материала на javarush(задания обычно следуют за пунктами краткой теории)


=4.1. Области действия переменных
4.6. Задачи на условные операторы
4.7. Тип boolean
4.11. Цикл For

=5.2. Пакеты (packages)
5.4. Создание объектов, ссылки на объекты
5.6. Инициализация объектов, метод Initialize
5.8. Конструкторы

=6.1. Видимость объектов и ссылка null.
6.3. Знакомство с методом finalize
6.6. Статические переменные и методы
6.7. Статические классы и методы

=7. Массивы 1. Массивы, null
7.2. Особенность устройства массивов в памяти
7.5. ArrayList, отличие от Array
7.7. Generics

=8. Коллекции
8.4. Знакомимся с типом Date
8.5. ArrayList vs. LinkedList
8.7. Set, Map, что можно с ними делать

=9.1. Стек трейс
9.3. Знакомство с исключениями
9.4. RuntimeException, throw
9.5. Раскрутка стека вызовов, как это идёт при исключениях
9.7. Как работает множественный catch

=10.1. Рассказ про жёсткую типизацию объектов
10.2. Список базовых типов
10.3. Преобразование типов. Расширение и сужение типов.
10.5. Преобразование к типу String
10.6. Задание на преобразование типов
10.7. Вещественные типы
10.8. Литералы

=11.1. ООП - основные принципы
11.3. Еще одно объяснение ООП (слабая связность, четкие функции)
11.5. Наследование. Преимущество наследования
11.7. Инкапсуляция. Преимущество инкапсуляции

=12.1. Полиморфизм и переопределение
12.3. Перегрузка методов
12.5. Абстрактные классы
12.7. Интерфейсы
12.8. Интерфейсы - это больше чем интерфейсы - это поведение

=13.1. Причины существования интерфейсов - поддержка заявленного поведения
13.3. Абстрактные классы
13.5. Множественное наследование интерфейсов
13.7. Абстрактный класс vs. интерфейс
13.8. Стандартные интерфейсы: InputStream, OutputStream

=14.1. instanceof - что это такое и зачем нужно
14.3. Приведение типов. Расширение и сужение

=15.1. Переопределение методов, реализация абстрактных методов и интерфейсов..
15.3. Перегрузка методов
15.5. Создание объекта. Порядок вызова конструкторов
15.7. Порядок загрузки классов, статические данные...
15.8. Порядок инициализации переменных

=16.1. Что такое многопоточность и зачем
16.2. Способы создания и запуска новых потоков
16.4. join- ожидание завершения потока
16.6. sleep-спать
16.8. Наша версия остановки потока
16.9. interrupt, IsInterrupted, interrupted exception

=17.1. Проблемы многопоточности: обращение к общему ресурсу
17.3. synchronized
17.5. Кэш. проблема многопоточности - локальный кэш. volatile
17.7. yield - пропуск хода

=18.1. Знакомство с потоками
18.2. FileInputStream, FileOutputStream
18.4. InputStream/OutputStream
18.6. BufferedInputStream
18.7. Пишем свой поток - обертку на System.in

=19.1. Концепция адаптера
19.2. Reader/Writer
19.4. FileReader/FileWriter
19.7. Пишем свой реадер - обертку на System.out

=20.1. Нужно сохранить объект в файл - построчно. Сохранение массива объектов
20.3. Решение - сериализация, ISerializable
20.5. transient
20.6. Сохранение данных/externalizable

=21.1. Приоритет операторов
21.3. Все методы класса Object, метод toString()
21.4. Методы equals & hashCode: зачем, где используются, как работают
21.6. Знакомство с методами wait, notify, notifyAll
21.7. Метод clone, интерфейс Cloneable
21.9. Метод finalize, интерфейс closeable, try-with-resources(java7)
Опасности метода finalize
21.11. Метод getClass(), объект класс, знакомство с Reflection

=22.1. Что такое mutable/imutable объекты и зачем они
22.2. Перечисляю все классы, связанные со строками, и говорю, что делают они и все методы
22.3. Внутреннее устройство String, метод substring
22.4. Поиск, получение, удаление подстроки в String
22.6. String.format
22.8. StringBilder, StringBuffer
22.10. Character, кодировки
22.11. Регулярные выражения, примеры
22.12. StringTokinizer, String.replace, String.split

=23.1. final и другие ключевые слова java
23.3. Вложенные классы
23.5. Внутренние статические классы
23.7. Внутренние анонимные классы, примеры

=24.1. Интерфейсы-маркеры, глубокое клонирование
24.3. Наследование внутренних классов
24.5. Локальные классы - классы внутри методов
24.7. Что происходит на самом деле (Во что превращаются классы компилятором)
24.8. Конструкторы/переменные анонимных иннер классов, final

=25.1. Enum, все особенности
25.3. Thread Life Cyrcle, состояние объекта Thread
25.4. Все нюансы создания и запуска новой нити, демоны
25.6. Все нюансы прерывания/остановки нитей
25.8. Стек вызовов и перехват ошибок
25.10. Другие методы класса Thread (sleep, yield...)

=26.1. Comparator, сортировка коллекций
26.3. Разделяемые ресурсы, Конфликты, Проблема совместного доступа
26.4. Применение volatile
26.6. Мютекс и монитор
26.7. Применение synchronized
26.9. Канкаренси, BlockingQueues (java7)

=27.1. Циклы (break и return, continue, метки)
27.3. DeadLock, и его причины
27.5. Стратегии избегания DeadLock
27.7. Стратегия "wait-notify-notifyAll"
27.8. Нюансы работы
27.10. Другие детали синхронизации и многонитиевости

=28.1. switch, case, default
28.3. ThreadGroup - группы потоков
28.5. Приоритеты потоков
28.7. ThreadPoolExecutor пул нитей
28.9. Executor, ExecutorService, Callable

=29.1. NamingConventions, CodeConventions
29.3. Autoboxing (imutables)
29.4. Number (Integer Long, Byte)
29.6. Boolean
29.8. Character
29.10. Void и др.

=30.1. 16-я система исчисления. 2 и 8 системы исчисления. Запись двоичного числа как 1000100В
30.3. Числовые операторы
30.5. Логические операторы
30.7. Побитовые операторы (&, xor, <<,...)
30.9. NaN, Infinity
30.10. Практическое применение (Битовые маски,...)

=31.1. File, Files, Path
31.3. Files, Path
31.5. FileInputStream, FileOutputStream, ZipOutputStream, ZipInputStream
31.7. Reader, Writer
31.9. Properties

=32.1. RandomAccessFile и т.д.
32.3. StringReader, StringWriter
32.5. BufferedReader, BufferedWriter
32.7. DinamicProxy
32.9. RMI

=33.1. JavaScript
33.2. JSON
33.3. Сериализация в JSON
33.4. Json serialize frameworks
33.6. XML, Сериализация в XML
33.7. JAXB
33.9. Сложная сериализация в XML, JAXB (вложенные классы и т.д.)

=34.1. Рекурсия
34.3. Сборка мусора
