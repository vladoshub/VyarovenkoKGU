package calculator.userinterface;

    public enum ClassPathList
    {
        OperADD("Operation ADD"),
        OperMUL("Operation MUL"),
        OperDIV("Operation DIV"),
        OperSUBTRACTION("Operation SUBTRACTION");

        private String operation;

        ClassPathList(String operation) {
            this.operation = operation;
        }

        public String operation() {
            return operation;
        }
    }
