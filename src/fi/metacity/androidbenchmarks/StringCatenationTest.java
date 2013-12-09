package fi.metacity.androidbenchmarks;

import io.leocad.delta.BenchmarkTask;

public class StringCatenationTest extends BenchmarkTask {

	String[] mRandomsStrings;
	
	@Override
    protected void onPreExecute() {
		mRandomsStrings = MainActivity.generateRandomUUIDStrings(1000);
    }

	@Override
	protected Object task() {
		String result = "";
		for (String random : mRandomsStrings) {
			result += random;
		}
		return result;
	}

}
