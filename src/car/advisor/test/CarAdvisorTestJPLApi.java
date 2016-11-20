package car.advisor.test;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

public class CarAdvisorTestJPLApi {

	public static void main(String argv[]) {

		// load db
		Query loadDB = new Query("consult",
				new Term[] { new Atom("car-db.pl") });
		System.out.println("consult "
				+ (loadDB.hasSolution() ? "succeeded" : "failed"));

		// memorize rule
		Query memorize = new Query("pamietaj", new Term[] { new Atom("test"),
				new Atom("pass"), new Atom("tak") });
		System.out.println("memorization "
				+ (memorize.hasSolution() ? "complete" : "failed"));

		// check if memorization worked
		Query test = new Query("test", new Term[] { new Atom("any") });
		System.out.println("test is "
				+ (test.hasSolution() ? "provable" : "not provable"));
	}

}
