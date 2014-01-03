package fi.metacity.androidbenchmarks;

import io.leocad.delta.BenchmarkTask;

public class StringBuilderTest extends BenchmarkTask {

	String[] mRandomStrings;

	@Override
	protected void onPreExecute() {
		mRandomStrings = MainActivity.generateRandomUUIDStrings(1000);
	}

	@Override
	protected Object task() {
		StringBuilder sb = new StringBuilder();
		for (String random : mRandomStrings) {
			sb.append(random);
		}
		return sb.toString();
	}

}
