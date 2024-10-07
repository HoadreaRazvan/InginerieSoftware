public class Animal implements Muritor{
        private String nume;

        public Animal(String nume) {
            this.nume = nume;
            System.out.println(this.nume);
        }

        public void mananca()
        {
            System.out.println("Animal\t" + this.nume);
        }

        @Override
        public void mort() {
            System.out.println("Muritor\t" + this.nume);
        }
}
