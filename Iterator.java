public class Iterator {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        IteratorPattern iterator = nameRepository.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

interface IteratorPattern {
    boolean hasNext();
    Object next();
}


interface Container {
    IteratorPattern createIterator();
}

class NameRepository implements Container {
    private String[] names = {"Juan", "María", "Carlos"};

    @Override
    public IteratorPattern createIterator() {
        return new NameIterator();
    }

    private class NameIterator implements IteratorPattern {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
