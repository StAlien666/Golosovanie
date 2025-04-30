import java.time.LocalDate;
import java.time.Period;

public class Person {
        private String name;
        private LocalDate birthday;
        private final String numberID;
        private int hours;

    private static final String EMPTY_MSG = "Тут не должно быть пусто"; //шоб не дублировать


        public Person(String name, short year, byte month, byte day, int hours) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_MSG);
            }
            this.name = name;
            this.birthday = LocalDate.of(year, month, day);
            this.numberID = generateUniqueID();
            this.hours = hours;
        }

        private String generateUniqueID() {
            return java.util.UUID.randomUUID().toString(); //уникальный номер пользователя
        }

        public int getAge() {
            return Period.between(birthday, LocalDate.now()).getYears();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_MSG);
            }
            this.name = name;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public void setBirthday(LocalDate birthday) {
            this.birthday = birthday;
        }
        public String getNumberID() {
            return numberID;
        }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    private static final double MAX_WEIGHT = 1000.0;
    private static final int FORMULA_DENOMINATOR = 10_000;

    public double calculateVoteWeight() {
        return (MAX_WEIGHT * hours * hours) / (FORMULA_DENOMINATOR + hours);  // взял за основу e(число Эйлера) из микробиологии
    }
}
