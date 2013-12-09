package fi.metacity.androidbenchmarks;

import android.util.Log;
import io.leocad.delta.BenchmarkTask;

public class NormalLoopTest extends BenchmarkTask {

	int[] mRandomInts;

	@Override
	protected void onPreExecute() {
		mRandomInts = MainActivity.generateRandomInts(100000);
		Log.i(getClass().getSimpleName(), "Using array size: " + mRandomInts.length);
	}

	@Override
	protected Object task() {
		final int xor = 123456789;
		
		int len = mRandomInts.length;
		for (int i = 0; i < len; ++i) {
			mRandomInts[i] ^= xor;
		}
		
		return null;
	}

}
