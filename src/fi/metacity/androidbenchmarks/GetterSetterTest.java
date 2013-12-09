package fi.metacity.androidbenchmarks;

import io.leocad.delta.BenchmarkTask;

public class GetterSetterTest extends BenchmarkTask {
	GetterSetterClass mTestClass;
	int[] mArrayOfRandoms;
	
	@Override
    protected void onPreExecute() {
		mTestClass = new GetterSetterClass();
	    mArrayOfRandoms = MainActivity.generateRandomInts(100);
    }

	@Override
    protected Object task() {
		for (int num : mArrayOfRandoms) {
			mTestClass.setX(mTestClass.getX() ^ num);
		}
		return mTestClass;
    }

	private static class GetterSetterClass {
		private int mX;

		public int getX() {
			return mX;
		}

		public void setX(int x) {
			mX = x;
		}
	}

}
