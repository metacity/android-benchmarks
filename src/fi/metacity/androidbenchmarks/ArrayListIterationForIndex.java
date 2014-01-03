package fi.metacity.androidbenchmarks;

import java.util.ArrayList;

import io.leocad.delta.BenchmarkTask;

public class ArrayListIterationForIndex extends BenchmarkTask {

	ArrayList<Integer> mRandomIntegers;

	@Override
	protected void onPreExecute() {
		mRandomIntegers = new ArrayList<Integer>();
		for (int num : MainActivity.generateRandomInts(100000)) {
			mRandomIntegers.add(num);
		}
	}

	@Override
	protected Object task() {
		int state = 0;
		int len = mRandomIntegers.size();
		for (int i = 0; i < len; ++i) {
			state ^= mRandomIntegers.get(i);
		}
		return state;
	}

}
