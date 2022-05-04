
public class AudioCollage {
	// Returns a new array that rescales a[] by a multiplicative factor of alpha.
	public static double[] amplify(double[] a, double alpha) {
		double[] amplified = new double[a.length];
		for (int i = 0; i < amplified.length; i++) {
			amplified[i] = alpha * a[i];
		}
		return amplified;

	}

	// Returns a new array that is the reverse of a[].
	public static double[] reverse(double[] a) {
		double[] reversed = new double[a.length];
		for (int i = 0; i < reversed.length; i++) {
			reversed[i] = a[reversed.length - 1 - i];
		}
		return reversed;
	}

	// Returns a new array that is the concatenation of a[] and b[].
	public static double[] merge(double[] a, double[] b) {
		double[] merged = new double[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			merged[i] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			merged[a.length + i] = b[i];
		}
		return merged;
	}

	// Returns a new array that is the sum of a[] and b[],
	// padding the shorter arrays with trailing 0s if necessary.
	public static double[] mix(double[] a, double[] b) {
		int difference = Math.abs(a.length - b.length);
		double[] c = new double[difference];
		double[] mergedB = null;
		double[] mergedA = null;
		double[] add = null;
		if (a.length > b.length) {
			mergedB = merge(b, c);
			add = new double[mergedB.length];
		} else if (b.length > a.length) {
			mergedA = merge(a, c);
			add = new double[mergedA.length];
		} else {
			add = new double[a.length];
		}
		// double[] add = new double[mergedB.length];
		for (int i = 0; i < add.length; i++) {
			if (a.length > b.length) {
				add[i] = a[i] + mergedB[i];
			} else if (b.length > a.length) {
				add[i] = b[i] + mergedA[i];
			} else {
				add[i] = a[i] + b[i];
			}

		}
		return add;
	}

	// Returns a new array that changes the speed by the given factor.
	public static double[] changeSpeed(double[] a, double alpha) {
		double[] resampled = new double[(int) Math.floor(a.length / alpha)];
		for (int i = 0; i < resampled.length; i++) {
			resampled[i] = a[(int) Math.floor(alpha * i)];
		}
		return resampled;
	}

	// Creates an audio collage and plays it on standard audio.
	// See below for the requirements.
	public static void main(String[] args) {
		String[] sounds = { "beatbox.wav", "exposure.wav", "piano.wav", "singer.wav", "harp.wav" };
		for (int i = 1; i < sounds.length; i++) {
			double[] sound = StdAudio.read(sounds[i - 1]);
			double[] sound1 = StdAudio.read(sounds[i]);
			StdAudio.play(amplify(sound, 2));
			StdAudio.play(reverse(sound));
			StdAudio.play(merge(sound, sound1));
			StdAudio.play(mix(sound, sound1));
			StdAudio.play(changeSpeed(sound, 2));
		}

	}

}
