package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.Objects;

public class SugarPizza extends Pizza {
    public enum Degree { LITTLE, NORMAL, HEAVY};
    private final Degree degree;
    private String name;



    public static class Builder extends Pizza.Builder<Builder> {
        private final Degree degree;
        private String name;

        public Builder(Degree degree) {
            this.degree = Objects.requireNonNull(degree);
        }

        public Builder name(String name) {
            this.name = Objects.requireNonNull(name);
            return this;
        }


        @Override
        SugarPizza build() {
            return new SugarPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private SugarPizza(Builder builder) {
        super(builder);
        this.degree = builder.degree;
        this.name = builder.name;

    }

    @Override public String toString() {
        return String.format("Sugar Pizza %s has %s degree sugar in it,", name, degree);
    }
}
