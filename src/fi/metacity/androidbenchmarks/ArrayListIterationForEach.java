package fi.metacity.androidbenchmarks;

import java.util.ArrayList;

import io.leocad.delta.BenchmarkTask;

public class ArrayListIterationForEach extends BenchmarkTask {

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
		for (Integer num : mRandomIntegers) {
			state ^= num;
		}
		return state;
	}

}
