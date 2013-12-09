package fi.metacity.androidbenchmarks;

import io.leocad.delta.BenchmarkTask;

public class GetterSetterTest extends BenchmarkTask {
	
	GetterSetterClass mTestClass;
	int[] mRandomInts;
	
	@Override
    protected void onPreExecute() {
		mTestClass = new GetterSetterClass();
	    mRandomInts = MainActivity.generateRandomInts(100000);
    }

	@Override
    protected Object task() {
		for (int num : mRandomInts) {
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
