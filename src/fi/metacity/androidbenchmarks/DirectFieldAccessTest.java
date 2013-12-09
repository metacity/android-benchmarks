package fi.metacity.androidbenchmarks;

import io.leocad.delta.BenchmarkTask;

public class DirectFieldAccessTest extends BenchmarkTask {
	DirectFieldAccessClass mTestClass;
	int[] mArrayOfRandoms;
	
	@Override
    protected void onPreExecute() {
		mTestClass = new DirectFieldAccessClass();
	    mArrayOfRandoms = MainActivity.generateRandomInts(100);
    }

	@Override
    protected Object task() {
		for (int num : mArrayOfRandoms) {
			mTestClass.x ^= num;
		}
		return mTestClass;
    }
	
	private static class DirectFieldAccessClass {
		int x;
	}
}
