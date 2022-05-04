
public class Clock {
	int h;
	int m;

	public Clock(int h, int m) {
		if (h > 23 || h < 0)
			throw new IllegalArgumentException("Hour is greater than 23 or less than 0");
		if (m > 59 || m < 0)
			throw new IllegalArgumentException("Minutes is greter than 59 or less than 0");
		this.h = h;
		this.m = m;
	}

	public Clock(String s) {
		if (s.length() != 5)
			throw new IllegalArgumentException("String length is not correct");
		if (!s.substring(2, 3).equals(":"))
			throw new IllegalArgumentException("Column not present");
		if (s.substring(0, 2).length() > 2 || s.substring(0, 2).length() < 2)
			throw new IllegalArgumentException("number of Hour digits is not 2");
		if (s.substring(3, 5).length() > 2 || s.substring(2, 5).length() < 2)
			throw new IllegalArgumentException("number of Minutes digits is not 2");

		h = Integer.parseInt(s.substring(0, 2));
		m = Integer.parseInt(s.substring(3, 5));
		if (h > 23 || h < 0)
			throw new IllegalArgumentException("Hour is greater than 23 or less than 0");
		if (m > 59 || m < 0)
			throw new IllegalArgumentException("Minutes is greter than 59 or less than 0");

	}

	// Returns a string representation of this clock, using the format HH:MM.
	public String toString() {
		String zeroHourPadding = "";
		String zeroMinutePadding = "";
		if (h < 10) {
			zeroHourPadding += 0;
		}
		if (m < 10) {
			zeroMinutePadding += 0;
		}
		return zeroHourPadding + h + ":" + zeroMinutePadding + m;
	}

	public boolean isEarlierThan(Clock that) {
		if (this.h < that.h) {
			return true;
		}
		if (this.h == that.h && this.m < that.m) {
			return true;
		}
		return false;

	}

	public void tic() {
		this.m += 1;
		this.h += (this.m / 60);
		this.m = (this.m % 60);
		this.h = (this.h % 24);
	}

	public void toc(int delta) {
		if (delta < 0)
			throw new IllegalArgumentException("delta is negative");
		this.m += delta;
		this.h += (this.m / 60);
		this.m = (this.m % 60);
		this.h = (this.h % 24);
	}

	// Test client (see below).
	public static void main(String[] args) {
		Clock clock = new Clock("01:12");
		clock.tic();
		clock.tic();
		clock.tic();
		clock.toc(1900000005);
		StdOut.print(clock);

	}

}
