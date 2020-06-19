package repro;

public enum EnumThatReproduces {

    INSTANCE {

        /**
         * {@link Throwable}
         */
        @Override
        public void test() {
        }

        /**
         * This link also triggers an error.
         *
         * {@link Object}
         */
        private void method() {

        }
    };

    public abstract void test();
}
