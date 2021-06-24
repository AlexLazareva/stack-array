package ru.beans;

public class DynamicList {

    //Первый и последний элементы - head и tail
    Element head;
    Element tail;
    int size = 0;

    //При создании листа сразу создаем элемент - так написано в задании
    //Этот элемент нигде не отображается
    public DynamicList() {
        head = new Element();
        //Когда список пустой head и tail указывают на один и тот же элемент
        tail = head;
    }

    //Метод для добавления элемента
    public void add(Thread thread) {
        //Создаем новый элемент из переданного значения
        Element e = new Element(thread);
        //Устанавливаем указатель в последнем элементе на новый элемент
        //Т.е было b -> null, стало b -> a -> null
        tail.next = e;
        //Меняем указатель на последний элемент (tail) и увеличиваем размер
        tail = e;
        size++;
    }

    //Вставка после первого элемента с заданным значением
    public boolean addAfter(Thread after, Thread a) {
        //Проходим по всем элементам и ищем с нужным значением
        //Тут p - это элемент перед элементом с нудным значением
        Element p = head;
        while (p != null) {
            if (p.val.equals(after)) {
                //Когда найден - добавляем новый элемент после него как в методе add
                Element e = new Element(a);
                //Было  -> p -> g ->;  e -> null
                //После этой строчки стало: -> p -> g ->;  e -> g
                e.next = p.next;
                //После этой строчки стало: -> p -> e -> g ->
                p.next = e;

                if (tail == p) {
                    tail = e;
                }
                //Увеличиваем размер и возвращаем истину т.е элемент найден и новый вставлен
                size++;
                return true;
            }
            //Если элемент пока не найден переходим к следующему
            p = p.next;
        }
        //Если не найден - возвращаем false
        return false;
    }

    //Вставка до первого элемента с заданным значением
    public boolean addBefore(int index, Thread a) {
        //Проходим по всем элементам и ищем с нужным значением
        //Тут p.next - это элемент перед элементом с нужным значением
        Element p = head;
        while (p.next != null) {
            if (p.next.val.equals(index)) {
                //Когда найден - добавляем новый элемент после него как в методе add
                Element e = new Element(a);
                e.next = p.next;
                p.next = e;
                //Увеличиваем размер и возвращаем истину т.е элемент найден и новый вставлен
                size++;
                return true;
            }
            //Если элемент пока не найден переходим к следующему
            p = p.next;
        }
        //Если не найден - возвращаем false
        return false;
    }

    //Удаление элемента по индексу
    public void removeAt(int index) throws IndexOutOfBoundsException {
        //Если такого индекса нет - кидаем исключение
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        //Проходимся по элементам до индекса
        //Тут p - это элемент перед искомым
        Element p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        //Если удаляем последний элемент - перемещем указатель последнего элемента списка на предыдущий
        if (index == size - 1) {
            p.next = null;
            tail = p;
        } else {
            //Иначе - перемещаем указатель 'предыдущего элемента на следующий' на элемент после удаляемого
            //Все остальное сделает сборщик мусора
            //Было: p -> a -> c ->;
            //Стало: p -> c ->
            p.next = p.next.next;
        }
        size--;
    }

    //Проходим по элементам до индекса и возвращаем нужный
    public Thread get(int index) throws IndexOutOfBoundsException{
        //Ошибка если индекс некорректный
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        //Тут идем до index+1
        //Тогда get(0) будет возвращать значение элемента после head
        Element p = head;
        for (int i = 0; i < index+1; i++) {
            p = p.next;
        }
        return (Thread) p.val;
    }

    //Новый элемент получит индекс = index + 1
    //или добавитя в конец если index > size
    public void insertAfter(int index, Thread a) throws IndexOutOfBoundsException {
        if (index < -1)
            throw new IndexOutOfBoundsException();
        //Если вставка больше чем элементов или в конец - используем add
        if (size-1 <= index) {
            add(a);
            return;
        }

        //Прохожим по элементам до индекса
        Element p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        //Вставляем новый элемент
        Element e = new Element(a);
        //Было: -> p -> c ->; e -> null
        //После этой строчки: -> p -> c ->; e -> c
        e.next = p.next;
        //После этой строчки: -> p -> e -> c
        p.next = e;
        //По необходимости меняем хвост
        if (tail == p)
            tail = e;
        size++;
    }


    public void remove(int a) {
        //Удаление первого элемента с данным значением
        Element p = head;
        while (p.next != null) {
            if (p.next.val.equals(a)) {
                //Если удаляем последний элемент, устанавливаем новый tail
                if (p.next == tail)
                    tail = p;
                //Было p -> a -> c
                //Стало p -> c; a -> c
                //Сборщик мусора удалит a
                p.next = p.next.next;
                size--;
                break;
            }
            //Если элемент с нужным значением пока не найден - смотрим следующий
            p = p.next;
        }
    }

    public int size() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Element p = head.next;
        while (p != null) {
            sb.append(p.val);
            sb.append(" ");
            p = p.next;
        }
        return sb.toString();
    }

    //Это класс - обертка для значений однонаправленного списка
    class Element {
        Thread val;
        Element next = null;

        public Element(){}

        public Element(Thread val) {
            this.val = val;
        }
    }
}
