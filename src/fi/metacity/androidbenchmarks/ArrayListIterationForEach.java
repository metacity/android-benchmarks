package fi.metacity.androidbenchmarks;

import java.util.ArrayList;

import io.leocad.delta.BenchmarkTask;

public class ArrayListIterationForEach extends BenchmarkTask {

	ArrayList<Integer> mList;
	Integer state;
	
	@Override
    protected void onPreExecute() {
	    mList = new ArrayList<Integer>();
	    state = Integer.valueOf(0);
	    for (int num : MainActivity.generateRandomInts(100)) {
	    	mList.add(num);
	    }
    }

	@Override
	protected Object task() {
		for (Integer num : mList) {
			state ^= num;
		}
		return state;
	}

}
