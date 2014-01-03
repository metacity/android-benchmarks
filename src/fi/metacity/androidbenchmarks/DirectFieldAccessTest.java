package fi.metacity.androidbenchmarks;

import io.leocad.delta.BenchmarkTask;

public class DirectFieldAccessTest extends BenchmarkTask {

	DirectFieldAccessClass mTestClass;
	int[] mRandomInts;

	@Override
	protected void onPreExecute() {
		mTestClass = new DirectFieldAccessClass();
		mRandomInts = MainActivity.generateRandomInts(100000);
	}

	@Override
	protected Object task() {
		for (int num : mRandomInts) {
			mTestClass.x ^= num;
		}
		return mTestClass;
	}

	private static class DirectFieldAccessClass {
		int x;
	}
}
