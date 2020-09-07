public class Itera {
    static final Object o = new Object();
    static int i = 0;
    static int currentNumber = 0;
    static int size = 3;
    public static void main(String[] args) {

        for (int j = 1; j <= size; j++) {
            new Threadk(j).start();
        }

    }
    public static class Threadk extends  Thread{

        private final int number;

        public Threadk(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (true){
                synchronized (o) {
                    if (number - currentNumber == 1) {
                        if (i != 100) {
                            i++;
                            System.out.println(getName() + " " + i);
                            currentNumber++;
                        } else {
                            return;
                        }

                        if (currentNumber == size) {
                            currentNumber = 0;
                        }
                    }
                }
            }

        }
    }

}
