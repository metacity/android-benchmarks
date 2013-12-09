package fi.metacity.androidbenchmarks;

import io.leocad.delta.BenchmarkTask;

public class StringBuilderTest extends BenchmarkTask {

	String[] mRandomsStrings;
	
	@Override
    protected void onPreExecute() {
		mRandomsStrings = MainActivity.generateRandomUUIDStrings(1000);
    }

	@Override
	protected Object task() {
		StringBuilder sb = new StringBuilder();
		for (String random : mRandomsStrings) {
			sb.append(random);
		}
		return sb.toString();
	}

}
