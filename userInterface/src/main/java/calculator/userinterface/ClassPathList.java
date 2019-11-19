package calculator.userinterface;

    public enum ClassPathList
    {
        ADD("add.Add"),
        MUL("mul.Mul"),
        DIV("div.Div"),
        SUBTRACTION("subtraction.Subtraction"),
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
