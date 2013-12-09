package fi.metacity.androidbenchmarks;

import io.leocad.delta.BenchmarkTask;

public class StringCatenationTest extends BenchmarkTask {

	String[] mRandomStrings;
	
	@Override
    protected void onPreExecute() {
		mRandomStrings = MainActivity.generateRandomUUIDStrings(1000);
    }

	@Override
	protected Object task() {
		String result = "";
		for (String random : mRandomStrings) {
			result += random;
		}
		return result;
	}

}
