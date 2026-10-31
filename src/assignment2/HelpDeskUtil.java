package assignment2;
import java.util.List;

public class HelpDeskUtil {
	//Generic method
    public static <T> void printAll(List<T> items) {
        if (items != null) {
            for (T item : items) {
                System.out.println(item);
            }
        }
    }

    //Wild card method with upper bounds
    public static int sumPoints(List<? extends Technician> technicians) {
        int total = 0;
        if (technicians != null) {
            for (Technician tech : technicians) {
                total += tech.getServicePoints();
            }
        }
        return total;
    }
}
