public class Birthday {

	public static void main(String[] args) {
		 int n = Integer.parseInt(args[0]);
		 int trials = Integer.parseInt(args[1]);
		int[] personCount = new int[n + 2]; // this should use an expandable collection data stucture like an arrasylist
		for (int i = 0; i < trials; i++) {
			int personInRoom = 0;
			int[] numberOfSharedBirthday = new int[n];
			int detect = 0;
			while (numberOfSharedBirthday[detect] < 2) { // more flexibility in variable number of shared birthdays
				personInRoom++;
				detect = (int) (Math.random() * n);
				numberOfSharedBirthday[detect] += 1;
			}
			personCount[personInRoom]++;
		}
		int sum = 0;
		for (int i = 1; i < personCount.length; i++) {
			sum += personCount[i];
			System.out.println(i + "\t" + personCount[i] + "\t" + (double) sum / trials);
			if ((double) sum / trials >= 0.5)
				break;
		}
	}

}
