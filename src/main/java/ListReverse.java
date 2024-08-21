import java.util.Iterator;

/**
 * Разворот односвязного списка.
 */
public class ListReverse {

    public static void main(String[] args){

        MyList<Integer> list = new MyList<>();
        list.add(1).add(2).add(3).add(4).add(5);

        for (Integer i : list){
            System.out.println(i);
        }

        list.reverse();
        System.out.println();

        for (Integer i : list){
            System.out.println(i);
        }



    }
    public static class MyList <T> implements Iterable<T>{

        private T value;
        private MyList<T> nextElement;

        public MyList<T> add(T value){
           nextElement = new MyList<>();
           nextElement.setValue(value);
           return nextElement;
        }

        private MyList<T> getNextElement(){
            return nextElement;
        }

        private void setNextElement(MyList<T> nextElement){
            this.nextElement = nextElement;
        }

        public void reverse(){
            MyList<T> firstElement = this;
            MyList<T> currentElement = this;
            MyList<T> nextElement = this.getNextElement();
            while (nextElement != null){
                MyList<T> nextNextElement = nextElement.getNextElement();
                if (currentElement == firstElement ) nextElement.setNextElement(null);
                else nextElement.setNextElement(currentElement); //Для того чтобы разорвать зацикливание списка
                currentElement = nextElement;
                nextElement = nextNextElement;
            }
            firstElement.setNextElement(currentElement);
        }

        private void setValue(T value){
            this.value = value;
        }

        private T getValue(){
            return value;
        }

        @Override
        public Iterator<T> iterator() {
            Iterator<T> iterator = new Iterator<T>() {
                MyList<T> currentElement = MyList.this;

                @Override
                public boolean hasNext() {
                    return (currentElement.nextElement != null);
                }

                @Override
                public T next() {
                    currentElement = currentElement.nextElement;
                    return currentElement.getValue();
                }
            };
            return iterator;
        }
    }
}
