package repro;

public enum EnumThatReproduces {

    INSTANCE {
        @Override
        public Object test() {
            return null;
        }

        /**
         * {@link java.lang.Throwable}
         */
        private void unusedMethod() {

        }
    };

    public abstract Object test();
}
