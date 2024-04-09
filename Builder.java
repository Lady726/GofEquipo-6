public class Builder {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder("Grande")
                .cheese(true)
                .pepperoni(true)
                .mushrooms(true)
                .build();

        pizza.printDetails();
    }
}

class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;


    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    public String getSize() {
        return size;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }

    public boolean hasMushrooms() {
        return mushrooms;
    }


    public void printDetails() {
        System.out.println("Tamaño: " + size);
        System.out.println("Queso: " + cheese);
        System.out.println("Pepperoni: " + pepperoni);
        System.out.println("Champiñones: " + mushrooms);
    }


    public static class Builder {
        private String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;


        public Builder(String size) {
            this.size = size;
        }

        public Builder cheese(boolean value) {
            cheese = value;
            return this;
        }

        public Builder pepperoni(boolean value) {
            pepperoni = value;
            return this;
        }

        public Builder mushrooms(boolean value) {
            mushrooms = value;
            return this;
        }


        public Pizza build() {
            return new Pizza(this);
        }
    }
}
