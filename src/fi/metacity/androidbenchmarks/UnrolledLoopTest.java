package fi.metacity.androidbenchmarks;

import android.util.Log;
import io.leocad.delta.BenchmarkTask;

public class UnrolledLoopTest extends BenchmarkTask {

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
		for (int i = 0; i < len; i += 4) {
			mRandomInts[i] ^= xor;
			mRandomInts[i+1] ^= xor;
			mRandomInts[i+2] ^= xor;
			mRandomInts[i+3] ^= xor;
		}

		return null;
	}

}
