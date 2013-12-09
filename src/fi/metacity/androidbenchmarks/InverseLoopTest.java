package fi.metacity.androidbenchmarks;

import android.util.Log;
import io.leocad.delta.BenchmarkTask;

public class InverseLoopTest extends BenchmarkTask {

	int[] mRandomInts;

	@Override
	protected void onPreExecute() {
		mRandomInts = MainActivity.generateRandomInts(100000);
		Log.i(getClass().getSimpleName(), "Using array size: " + mRandomInts.length);
	}

	@Override
	protected Object task() {
		final int xor = 123456789;
		
		for (int i = mRandomInts.length - 1; i >= 0; --i) {
			mRandomInts[i] ^= xor;
		}
		
		return null;
	}

}
