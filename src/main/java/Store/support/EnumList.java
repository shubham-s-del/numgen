package Store.support;

/**
 * Created by shubham.srivastava on 06/06/15.
 */
public class EnumList {
    public static enum DaysOfTheWeek implements Enums {
        MONDAY("Monday") {
            @Override
            public String getViewName() {
                return this.enumName;
            }
        },
        TUESDAY("Tuesday") {
            @Override
            public String getViewName() {
                return this.enumName;
            }
        },
        WEDNESDAY("Wednesday") {
            @Override
            public String getViewName() {
                return this.enumName;
            }
        },
        THURSDAY("Thursday") {
            @Override
            public String getViewName() {
                return this.enumName;
            }
        },
        FRIDAY("Friday") {
            @Override
            public String getViewName() {
                return this.enumName;
            }
        },
        SATURDAY("Saturday") {
            @Override
            public String getViewName() {
                return this.enumName;
            }
        },
        SUNDAY("Sunday") {
            @Override
            public String getViewName() {
                return this.enumName;
            }
        };

        public String enumName;

        DaysOfTheWeek(String enumName) {
            this.enumName = enumName;
        }





    }
}
