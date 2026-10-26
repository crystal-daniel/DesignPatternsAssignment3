package assignment03;

import java.time.LocalTime;

public class Driver {
	public static void main(String[] args) {
		Person person = new Person("Alex Student", "2000-01-01");
		AbstractStudent student = new ConcreteStudent(person);
		student.setMajor("Computer Science");
		student.setUniversity("Example University");

		student = new CS537(student);
		student = new CS528(student);
		student = new CS542(student);
		student = new CS551(student);

		System.out.println(student.getInnerSelf().getName());
		System.out.println(student.getMajor() + " at " + student.getUniversity());
		System.out.println(student.getCourses());

		// Test 1: overlaps CS542 (1:30-2:30pm) plus its 15-minute buffer
		LocalTime meeting1 = LocalTime.of(14, 30);
		System.out.println("Test 1: meeting at " + meeting1);
		System.out.println("  Expected: true");
		System.out.println("  Actual:   " + student.timeConflict(meeting1));
		System.out.println("  Reason:   overlaps CS542 (1:30-2:30pm) plus its 15-minute buffer");
		System.out.println();

		// Test 2: after CS551 (ends 4:00pm, buffer ends 4:15pm)
		LocalTime meeting2 = LocalTime.of(17, 0);
		System.out.println("Test 2: meeting at " + meeting2);
		System.out.println("  Expected: false");
		System.out.println("  Actual:   " + student.timeConflict(meeting2));
		System.out.println("  Reason:   the last class, CS551, ends at 4:00pm, so its buffer ends at 4:15pm");
	}
}
