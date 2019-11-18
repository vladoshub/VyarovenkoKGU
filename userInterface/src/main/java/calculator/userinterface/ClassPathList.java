package calculator.userinterface;

    public enum ClassPathList
    {
        ADD("add.Add"),
        MUL("mul.Mul"),
        DIV("div.Div"),
        SUBTRACTION("subtraction.Subtraction");

        private String path;

        ClassPathList(String path) {
            this.path = path;
        }

        public String path() {
            return path;
        }
    }
