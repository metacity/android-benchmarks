package fi.metacity.androidbenchmarks;

import io.leocad.delta.BenchmarkResult;
import io.leocad.delta.BenchmarkTask;
import io.leocad.delta.Delta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private final List<BenchmarkTask> mBenchmarks = new ArrayList<BenchmarkTask>();

	private Spinner mBenchmarkSpinner;
	private Spinner mIterationsSpinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mBenchmarkSpinner = (Spinner) findViewById(R.id.benchmark_spinner);
		mIterationsSpinner = (Spinner) findViewById(R.id.iterations_spinner);
		generateBenchmarks();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onRunBenchmarkClicked(View v) {
		BenchmarkTask task = mBenchmarks.get(mBenchmarkSpinner.getSelectedItemPosition());
		new Delta() {
			@Override
			public void onPostExecute(BenchmarkResult result) {
				String msg = "Cycles: " + result.benchmarkCycles + "\n" +
						"Total time: " + result.benchmarkDurationSecs + " sec\n"
						+ "Avg. time per task: " + result.benchmarkAvgTaskTimeNs + " ns";
				new AlertDialog.Builder(MainActivity.this).setMessage(msg).show();
			}
		}.benchmark(this, task.getClass(), Integer.parseInt(mIterationsSpinner.getSelectedItem().toString()));
	}

	private void generateBenchmarks() {
		mBenchmarks.add(new GetterSetterTest());
		mBenchmarks.add(new DirectFieldAccessTest());
		mBenchmarks.add(new ArrayListIterationForEach());
		mBenchmarks.add(new ArrayListIterationForIndex());
		mBenchmarks.add(new StringCatenationTest());
		mBenchmarks.add(new StringBuilderTest());
		mBenchmarks.add(new UnrolledLoopTest());
		mBenchmarks.add(new NormalLoopTest());
		mBenchmarks.add(new InverseLoopTest());
	}

	public static int[] generateRandomInts(int size) {
		int[] randoms = new int[size];
		for (int i = 0; i < randoms.length; ++i) {
			randoms[i] = (int)(Math.random() * Integer.MAX_VALUE);
		}
		return randoms;
	}

	public static String[] generateRandomUUIDStrings(int size) {
		String[] randoms = new String[size];
		for (int i = 0; i < randoms.length; ++i) {
			randoms[i] = UUID.randomUUID().toString();
		}
		return randoms;
	}

}
